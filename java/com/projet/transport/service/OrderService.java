package com.projet.transport.service;

import java.util.List;

import com.projet.transport.model.Order;
import com.projet.transport.model.User;
import com.projet.transport.request.OrderRequest;

public interface OrderService {
	
	public Order createOrder(OrderRequest order, User user) throws Exception;
	
	public Order updateOrder(Long orderId, String orderStatus) throws Exception;
	
	public void calculOrder(Long orderId) throws Exception;
	
	public List<Order> getUsersOrder(Long userId) throws Exception;

	public List<Order> getPortsOrder(Long portId, String orderStatus) throws Exception;

	public Order findOrderById (Long orderId) throws Exception;
}
