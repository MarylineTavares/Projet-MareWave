package com.projet.transport.service;

import java.util.List;

import com.projet.transport.model.Tracking;

public interface TrackingService {
	
	public List<Tracking> findByReference(String reference);

}
