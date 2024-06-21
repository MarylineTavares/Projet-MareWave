package com.projet.transport.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class PortDeparture {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String departure;
	
	private String address;	
	
	private String openingHours;
	
	private Double latitude;
	
	private Double longitude;

	@OneToMany(mappedBy ="port")
	private List<Order> orders = new ArrayList<>();
	
	@ManyToMany(mappedBy="portDeparture", cascade=CascadeType.ALL)
	private List<Calendar> calendar;
}
