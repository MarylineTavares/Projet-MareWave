package com.projet.transport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Float merchandiseWidth;
	
	private Float merchandiseLength;
	
	private Float merchandiseHeight;
	
	private String merchandise_type;
	
	private Float volume;
	
	private Long quantity;
	
	private Float price;
	
	private String provenance;
	
	//private Date pickupDate;
	
	private String destination;
	
	//private Date deliveryDate;
	
	private boolean isInsured;
	
	private Float value_of_goods;

}
