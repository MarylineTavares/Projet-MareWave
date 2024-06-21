package com.projet.transport.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.PortDeparture;
import com.projet.transport.model.PortI;
import com.projet.transport.model.User;
import com.projet.transport.repository.PortDepartureRepository;
import com.projet.transport.request.CreatePortRequest;

@Service
public class PortDepartureServiceImp implements PortDepartureService {

	@Autowired
	private PortDepartureRepository portRepository;
	
	@Override
	public PortDeparture createPort(CreatePortRequest req, User user) {
		
		PortDeparture port = new PortDeparture();
		port.setDeparture(req.getDeparture());
		port.setOpeningHours(req.getOpeningHours());
		port.setAddress(req.getAddress());
		
		return portRepository.save(port);
		
		}

	@Override
	public PortDeparture updatePort(Long portId, CreatePortRequest updatedPort) throws Exception{
		
		PortDeparture port = findPortById(portId);
		
		if(port.getAddress() != null) {
			port.setAddress(updatedPort.getAddress());
		}
		
		
		if(port.getDeparture() != null) {
			port.setDeparture(updatedPort.getDeparture());
		}
		
		if(port.getOpeningHours() != null) {
			port.setOpeningHours(updatedPort.getOpeningHours());
		}
		
		return portRepository.save(port);
	}
	
	@Override
	public PortDeparture deletePort(Long portId) throws Exception{
		
		PortDeparture port = findPortById(portId);
		
		portRepository.delete(port);
		
		return port;
	}
	
	@Override
	public List<PortDeparture>getAllPort(){
	
		return portRepository.findAll();
	}
	
	@Override
	public List<PortDeparture> searchPort(String keyword){
		
		return portRepository.findBySearchQuery(keyword);
	}
	
	@Override
	public PortI searchCoordinate(String keyword){
		
		return portRepository.findCoordinate(keyword);
	}
	
	@Override
	public PortDeparture findPortById(Long id) throws Exception{
		
		Optional<PortDeparture> opt = portRepository.findById(id);
		
		if(opt.isEmpty()) {
			throw new Exception("Port not found");
		}
		
		return opt.get();
	}
	
}

