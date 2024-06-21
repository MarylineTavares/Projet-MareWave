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

import com.projet.transport.model.PortArrival;
import com.projet.transport.model.PortI;
import com.projet.transport.service.PortArrivalService;


@RestController
@RequestMapping("/arrival_ports")
public class PortArrivalController {

	@Autowired
	private PortArrivalService portArrivalService;
	
	
	@GetMapping("/search")
	public ResponseEntity<List<PortArrival>>searchPort(@RequestParam String keyword)throws Exception{
		
		List<PortArrival> port = portArrivalService.searchPort(keyword);
		
		return new ResponseEntity<>(port, HttpStatus.OK);
	}
	
	@GetMapping("/coordinate")
	public ResponseEntity<PortI>searchCoordinate(@RequestParam String keyword)throws Exception{
		
		PortI port = portArrivalService.searchCoordinate(keyword);
		
		return new ResponseEntity<>(port, HttpStatus.OK);
	}
	
	@GetMapping()
	public ResponseEntity<List<PortArrival>>getAllPort()throws Exception{
		
		List<PortArrival> port = portArrivalService.getAllPort();
		
		return new ResponseEntity<>(port, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <PortArrival> findPortById(@PathVariable Long id
												)throws Exception{
		
	
		
		PortArrival port = portArrivalService.findPortById(id);
		
		return new ResponseEntity<>(port, HttpStatus.OK);
	}
}
