package com.projet.transport.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Calendar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Date departureDate;
	
	private Date arrivalDate;
	
	@Column (unique=true)
	private String reference;
	
	@OneToOne
	private Tracking tracking;
	
	@ManyToMany
	@JoinTable(name="PortCalendar",
				joinColumns= @JoinColumn (name="calendar_id"),
				inverseJoinColumns= @JoinColumn (name="port_departure_id"))
	private List<PortDeparture> portDeparture;
	
	@ManyToMany
	@JoinTable(name="PortCalendar",
				joinColumns= @JoinColumn (name="calendar_id"),
				inverseJoinColumns= @JoinColumn (name="port_arrival_id"))
	private List<PortArrival> portArrival;
}

