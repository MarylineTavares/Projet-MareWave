package com.projet.transport.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.Cart;
import com.projet.transport.model.CartItem;
import com.projet.transport.model.DeliveryAddress;
import com.projet.transport.model.Order;
import com.projet.transport.model.OrderItem;
import com.projet.transport.model.PortDeparture;
import com.projet.transport.model.User;
import com.projet.transport.repository.DeliveryAddressRepository;
import com.projet.transport.repository.OrderItemRepository;
import com.projet.transport.repository.OrderRepository;
import com.projet.transport.repository.UserRepository;
import com.projet.transport.request.OrderRequest;

@Service
public class OrderServiceImp implements OrderService{

	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private DeliveryAddressRepository deliveryAddressRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PortDepartureService portDepartureService;
	
	@Autowired
	private CartService cartService;
	
	@Override
	public Order createOrder(OrderRequest order, User user) throws Exception {
		
		DeliveryAddress shippingAddress = order.getDeliveryAddress();
		
		DeliveryAddress savedAddress = deliveryAddressRepository.save(shippingAddress);
		
		if(!user.getDeliveryAddresses().contains(savedAddress)) {
			user.getDeliveryAddresses().add(savedAddress);
			userRepository.save(user);
		}
		
		PortDeparture port = portDepartureService.findPortById(order.getPortId());
		
		Order createdOrder = new Order();
		createdOrder.setCustomer(user);
		createdOrder.setOrderDate(new Date());
		createdOrder.setOrderStatus("PENDING");
		createdOrder.setDeliveryAddresses(savedAddress);
		createdOrder.setPort(port);
		
		Cart cart = cartService.findCartByUserId(user.getId());
		
		List<OrderItem> orderItems = new ArrayList<>();
		
		for(CartItem cartItem: cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setMerchandiseHeight(cartItem.getMerchandiseHeight());
			orderItem.setMerchandiseLength(cartItem.getMerchandiseLength());
			orderItem.setMerchandiseWidth(cartItem.getMerchandiseWidth());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setPrice(cartItem.getPrice());
			
			OrderItem savedOrderItem = orderItemRepository.save(orderItem);
			orderItems.add(savedOrderItem);
		}
		
		Float totalPrice = cartService.calculateCartTotals(cart);
		
		createdOrder.setItems(orderItems);
		createdOrder.setTotalPrice(cart.getTotalPrice());
	
		Order savedOrder = orderRepository.save(createdOrder);
		port.getOrders().add(savedOrder);
		
		return createdOrder;
	}
	
	@Override
	public Order updateOrder(Long orderId, String orderStatus) throws Exception{
		Order order = findOrderById(orderId);
		
		if(orderStatus.equals("DELIVERED")
				||orderStatus.equals("PENDING")
				||orderStatus.equals("COMPLETED")
				) {
			order.setOrderStatus(orderStatus);
			return orderRepository.save(order);
		}
		
		throw new Exception("Please select a valid order status");
	}
	
	@Override
	public void calculOrder(Long orderId) throws Exception{
		Order order = findOrderById(orderId);
		orderRepository.deleteById(orderId);
	}
	
	@Override
	public List<Order> getUsersOrder(Long userId) throws Exception{
		return orderRepository.findByCustomerId(userId);
	}
	
	@Override
	public List<Order> getPortsOrder(Long portId, String orderStatus) throws Exception {
		List<Order> orders = orderRepository.findByPortId(portId);
		if(orderStatus != null) {
			orders = orders.stream().filter(order ->
			order.getOrderStatus().equals(orderStatus)).collect(Collectors.toList());
		}
		return orders;
	}
	
	@Override
	public Order findOrderById(Long orderId) throws Exception{
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		
		if(optionalOrder.isEmpty()) {
			throw new Exception("order not found");
		}
		return optionalOrder.get();
	}
}
