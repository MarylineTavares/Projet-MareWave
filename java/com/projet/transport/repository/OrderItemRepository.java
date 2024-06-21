package com.projet.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.transport.model.OrderItem;


public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{


}
