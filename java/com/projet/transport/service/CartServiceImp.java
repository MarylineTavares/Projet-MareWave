package com.projet.transport.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.Cart;
import com.projet.transport.model.CartItem;
import com.projet.transport.model.User;
import com.projet.transport.repository.CartItemRepository;
import com.projet.transport.repository.CartRepository;
import com.projet.transport.request.AddCartItemRequest;

@Service
public class CartServiceImp implements CartService{

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Override
	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception{
		User user = userService.findUserByJwtToken(jwt);
		
		Cart cart = cartRepository.findByCustomerId(user.getId());
		
		for(CartItem cartItem : cart.getCartItems()) {
			
			if(cartItem.getMerchandiseWidth().equals(req.getMerchandiseWidth()) 
				&& cartItem.getMerchandiseLength().equals(req.getMerchandiseLength())
				&& cartItem.getMerchandiseHeight().equals(req.getMerchandiseHeight())) {
				Long newQuantity = cartItem.getQuantity()+req.getQuantity();
					return updateCartItemQuantity(cartItem.getId(), newQuantity);
			}
			}
				CartItem newCartItem = new CartItem();
				newCartItem.setCart(cart);
				newCartItem.setMerchandiseWidth(req.getMerchandiseWidth());
				newCartItem.setMerchandiseLength(req.getMerchandiseLength());
				newCartItem.setMerchandiseHeight(req.getMerchandiseHeight());
				newCartItem.setQuantity(req.getQuantity());
				newCartItem.setPrice(req.getQuantity()*req.getMerchandiseHeight()*req.getMerchandiseLength()*req.getMerchandiseWidth());
				
		
				CartItem savedCartItem = cartItemRepository.save(newCartItem);
				
				cart.getCartItems().add(savedCartItem);
		
		return savedCartItem;
	}
	
	@Override
	public CartItem updateCartItemQuantity(Long cartItemId, Long newQuantity) throws Exception{
		
		Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
		if(cartItemOptional.isEmpty()) {
			throw new Exception("cart item not found");
		}
		
		CartItem item = cartItemOptional.get();
		
		item.setQuantity(newQuantity);
		
		item.setTotalPrice(item.getVolume()*item.getPrice()*item.getQuantity());
		
		return cartItemRepository.save(item);
	}
	
	@Override
	public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception{
		
		User user = userService.findUserByJwtToken(jwt);
		
		Cart cart = cartRepository.findByCustomerId(user.getId());
		
		Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
		if(cartItemOptional.isEmpty()) {
			throw new Exception("cart item not found");
		}
		
		CartItem item = cartItemOptional.get();
		
		cart.getCartItems().remove(item);
		
		return cartRepository.save(cart);
	}
	
	@Override
	public Float calculateCartTotals(Cart cart){
		
		Float total = (float) 0;
		
		for(CartItem cartItem : cart.getCartItems()) {
			total += cartItem.getMerchandiseWidth()
					*cartItem.getMerchandiseLength()
					*cartItem.getMerchandiseHeight()
					*cartItem.getQuantity()
					*cartItem.getPrice();		}
		
		return total;
	}
	
	@Override
	public Cart findCartById(Long id) throws Exception{
		
		Optional<Cart> optionalCart = cartRepository.findById(id);
		if(optionalCart.isEmpty()) {
			throw new Exception("cart not found");
		}
		return optionalCart.get();
	
	}
	
	@Override
	public Cart findCartByUserId(Long userId){
		
		Cart cart = cartRepository.findByCustomerId(userId);
		cart.setTotalPrice(calculateCartTotals(cart));
		return cart;
	}
	
	@Override
	public Cart clearCart(Long userId) throws Exception{
				
		Cart cart = findCartByUserId(userId);
		
		cart.getCartItems().clear();
		
		return cartRepository.save(cart);
	}
 
}
