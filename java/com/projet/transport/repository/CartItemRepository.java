package com.projet.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.transport.model.CartItem;


public interface CartItemRepository extends JpaRepository <CartItem, Long>{

}
