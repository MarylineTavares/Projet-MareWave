package com.projet.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.Tracking;
import com.projet.transport.repository.TrackingRepository;

@Service
public class TrackingServiceImp implements TrackingService{
	
	@Autowired
	private TrackingRepository trackingRepository;
	
	@Override
	public List<Tracking> findByReference(String reference){
		
		return trackingRepository.findByReference(reference);
	}

	
}
