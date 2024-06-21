package com.projet.transport.service;

import java.util.List;

import com.projet.transport.model.User;
import com.projet.transport.model.PortArrival;
import com.projet.transport.model.PortI;
import com.projet.transport.request.CreatePortRequest;


public interface PortArrivalService {
	
	public PortArrival createArrivalPort(CreatePortRequest req, User user);

	public PortArrival updateArrivalPort(Long portId, CreatePortRequest updatedPort) throws Exception;
	
	public PortArrival deleteArrivalPort(Long portId) throws Exception;
	
	public List<PortArrival> getAllPort();
	
	public List<PortArrival> searchPort(String keyword);
	
	public PortI searchCoordinate(String keyword);

	public PortArrival findPortById(Long id) throws Exception;
}
