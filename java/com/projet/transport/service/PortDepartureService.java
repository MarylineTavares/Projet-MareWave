package com.projet.transport.service;

import java.util.List;

import com.projet.transport.model.User;
import com.projet.transport.model.PortDeparture;
import com.projet.transport.model.PortI;
import com.projet.transport.request.CreatePortRequest;


public interface PortDepartureService {
	
	public PortDeparture createPort(CreatePortRequest req, User user);

	public PortDeparture updatePort(Long portId, CreatePortRequest updatedPort) throws Exception;
	
	public PortDeparture deletePort(Long portId) throws Exception;
	
	public List<PortDeparture> getAllPort();
	
	public List<PortDeparture> searchPort(String keyword);
	
	public PortI searchCoordinate(String keyword);
	
	public PortDeparture findPortById(Long id)throws Exception;
}
