package com.projet.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.transport.model.DeliveryAddress;


public interface DeliveryAddressRepository extends JpaRepository <DeliveryAddress, Long>{

}
