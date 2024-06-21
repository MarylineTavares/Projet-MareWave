package com.projet.transport.request;

import lombok.Data;

@Data
public class CreatePortRequest {
	
	private Long id;
	
	private String departure;
	
	private String arrival;
	
	private String address;
	
	private String openingHours;
	
	// Getters & setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String name) {
		this.departure = departure;
	}
	
	public String getArrival() {
		return arrival;
	}

	public void setArrival(String name) {
		this.arrival = arrival;
	}


	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}
}
