package com.projet.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.PortArrival;
import com.projet.transport.model.PortI;
import com.projet.transport.model.User;
import com.projet.transport.repository.PortArrivalRepository;
import com.projet.transport.request.CreatePortRequest;

@Service
public class PortArrivalServiceImp implements PortArrivalService {

	@Autowired
	private PortArrivalRepository portArrivalRepository;
	
	@Override
	public PortArrival createArrivalPort(CreatePortRequest req, User user) {
		
		PortArrival port = new PortArrival();
		port.setArrival(req.getArrival());
		port.setOpeningHours(req.getOpeningHours());
		port.setAddress(req.getAddress());
		
		return portArrivalRepository.save(port);
		
		}

	@Override
	public PortArrival updateArrivalPort(Long portId, CreatePortRequest updatedPort) throws Exception{
		
		PortArrival port = findPortById(portId);
		
		if(port.getAddress() != null) {
			port.setAddress(updatedPort.getAddress());
		}
		
		
		if(port.getArrival() != null) {
			port.setArrival(updatedPort.getArrival());
		}
		
		if(port.getOpeningHours() != null) {
			port.setOpeningHours(updatedPort.getOpeningHours());
		}
		
		return portArrivalRepository.save(port);
	}
	
	@Override
	public PortArrival deleteArrivalPort(Long portId) throws Exception{
		
		PortArrival port = findPortById(portId);
		
		portArrivalRepository.delete(port);
		
		return port;
	}
	
	@Override
	public List<PortArrival>getAllPort(){
	
		return portArrivalRepository.findAll();
	}
	
	@Override
	public List<PortArrival> searchPort(String keyword){
		
		return portArrivalRepository.findBySearchQuery(keyword);
	}
	
	@Override
	public PortI searchCoordinate(String keyword){
		
		return portArrivalRepository.findCoordinate(keyword);
	}
	
	@Override
	public PortArrival findPortById(Long id) throws Exception{
		
		Optional<PortArrival> opt = portArrivalRepository.findById(id);
		
		if(opt.isEmpty()) {
			throw new Exception("Port not found");
		}
		
		return opt.get();
	}
	
}

