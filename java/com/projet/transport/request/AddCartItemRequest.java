package com.projet.transport.request;

import lombok.Data;

@Data
public class AddCartItemRequest {
	
	private Float merchandiseWidth;
	
	private Float merchandiseLength;
	
	private Float merchandiseHeight;
	
	private Long quantity;
}
