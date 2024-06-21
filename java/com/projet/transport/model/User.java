package com.projet.transport.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String email;
	
	@Enumerated(EnumType.STRING)
	private USER_ROLE role;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;

	@OneToMany(cascade=CascadeType.ALL, orphanRemoval = true, mappedBy="billingAddress")
	private List<BillingAddress> billingAddresses = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="deliveryAddress")
	private List<DeliveryAddress> deliveryAddresses = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
	private List<Order>orders = new ArrayList<>();
	
	//Getters and setters
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	

	  
}