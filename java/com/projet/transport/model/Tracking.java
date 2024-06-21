package com.projet.transport.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Tracking{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private STATUS preRoutingStatus;
	
	private Date preRouting;
	
	@Enumerated(EnumType.STRING)
	private STATUS preparingDocumentCustomsStatus;
	
	private Date preparingDocumentCustoms;
	
	@Enumerated(EnumType.STRING)
	private STATUS transportStatus;
	
	private Date transport;
	
	@Enumerated(EnumType.STRING)
	private STATUS customsClearanceStatus;
	
	private Date customsClearance;
	
	@Enumerated(EnumType.STRING)
	private STATUS postRoutingStatus;
	
	private Date postRouting;
	
	@OneToOne(mappedBy="tracking")
	private Calendar calendar;
	
}
