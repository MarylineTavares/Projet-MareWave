package com.projet.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.transport.model.Cart;


public interface CartRepository extends JpaRepository<Cart,Long>{

	Cart findByCustomerId(Long id);

}
