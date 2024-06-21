package com.projet.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.transport.model.Order;


public interface OrderRepository extends JpaRepository <Order,Long>{

	public List<Order> findByCustomerId(Long userId);
	
	public List<Order> findByPortId (Long portId);
}
