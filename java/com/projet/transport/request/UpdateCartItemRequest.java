package com.projet.transport.request;

import lombok.Data;

@Data
public class UpdateCartItemRequest {
	
	private Long cartItemId;
	
	private Long quantity;
}
