package com.projet.transport.request;

import com.projet.transport.model.PortDeparture;

import lombok.Data;

@Data
public class QuotationRequest {

	private PortDeparture departure;
	
	private PortDeparture arrival;
	
	private String type;
	
	private Float dimension;
	
	private Float height;
	
	private Float length;
	
	private Float width;
	
	private Long quantity;
	
	private Float valueHT;

	private Float distance;
	
	private Double price;
	
	private Float volume;

}
