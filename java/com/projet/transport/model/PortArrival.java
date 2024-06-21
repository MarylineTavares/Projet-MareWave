package com.projet.transport.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class PortArrival {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String arrival;
	
	private String address;	
	
	private String openingHours;
	
	private Double latitude;
	
	private Double longitude;
	
	@ManyToMany(mappedBy="portArrival", cascade=CascadeType.ALL)
	private List<Calendar> calendar;
	
}
