package com.projet.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.transport.model.PortDeparture;
import com.projet.transport.model.PortI;
import com.projet.transport.service.PortDepartureService;


@RestController
@RequestMapping("/departure_ports")
public class PortDepartureController {

	@Autowired
	private PortDepartureService portDepartureService;
	
	
	@GetMapping("/search")
	public ResponseEntity<List<PortDeparture>>searchPort(@RequestParam String keyword)throws Exception{
		
		List<PortDeparture> port = portDepartureService.searchPort(keyword);
		
		return new ResponseEntity<>(port, HttpStatus.OK);
	}
	
	@GetMapping("/coordinate")
	public ResponseEntity<PortI>searchCoordinate(@RequestParam String keyword)throws Exception{
		
		PortI port = portDepartureService.searchCoordinate(keyword);
		
		return new ResponseEntity<>(port, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<PortDeparture>>getAllPort()throws Exception{
		
		List<PortDeparture> port = portDepartureService.getAllPort();
		
		return new ResponseEntity<>(port, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <PortDeparture> findPortById(@PathVariable Long id
												)throws Exception{
		
	
		
		PortDeparture port = portDepartureService.findPortById(id);
		
		return new ResponseEntity<>(port, HttpStatus.OK);
	}
}
