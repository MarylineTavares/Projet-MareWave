package com.projet.transport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity

public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Cart cart;
	
	private Float merchandiseWidth;
	
	private Float merchandiseLength;
	
	private Float merchandiseHeight;
	
	private Float volume;
	
	private String merchandise_type;
	
	private Long quantity;
	
	private Float price;
	
	private Float TotalPrice;
	
	private String provenance;
	
	//private Date pickupDate;
	
	private String destination;
	
	//private Date deliveryDate;
	
	private boolean isTruckAvailable;
	
	private boolean isInsured;
	
	private Float value_of_goods;

}

