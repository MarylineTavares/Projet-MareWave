package com.projet.transport.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="orders")

public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private User customer;
	
	private Float totalVolume;
	
	private Long totalQuantity;
	
	private Float totalPrice;
	
	private Date orderDate;
	
	private String orderStatus;
	
	@ManyToOne
	private DeliveryAddress deliveryAddresses;
	
	@ManyToOne
	private PortDeparture port;
	
	@OneToMany
	private List<OrderItem> items;


	//private Payment payment;
	
}