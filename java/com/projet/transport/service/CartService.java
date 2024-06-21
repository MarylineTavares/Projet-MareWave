package com.projet.transport.service;

import com.projet.transport.model.Cart;
import com.projet.transport.model.CartItem;
import com.projet.transport.request.AddCartItemRequest;

public interface CartService {
	
	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception;

	public CartItem updateCartItemQuantity(Long cartItemId, Long quantity) throws Exception;
	
	public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception;
	
	public Float calculateCartTotals(Cart cart) ;
	
	public Cart findCartById(Long id) throws Exception;
	
	public Cart findCartByUserId(Long userId);
	
	public Cart clearCart(Long userId) throws Exception;
 }
