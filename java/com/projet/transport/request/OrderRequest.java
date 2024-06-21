package com.projet.transport.request;

import com.projet.transport.model.DeliveryAddress;

import lombok.Data;

@Data
public class OrderRequest {

	private Long id;
	
	private Long PortId;
	
	private DeliveryAddress deliveryAddress;
	
}
