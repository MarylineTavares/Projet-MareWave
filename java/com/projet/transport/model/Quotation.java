package com.projet.transport.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Quotation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne
	private PortDeparture departure;
	
	@OneToOne
	private PortDeparture arrival;
		
	private Float dimension;
	
	private String type;
	
	private Float height;
	
	private Float length;
	
	private Float width;
	
	private Long quantity;
	
	private Float valueHT;

	private Float volume;
	
	private Double price;
	
	private Float distance;
}