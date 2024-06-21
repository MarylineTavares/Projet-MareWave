package com.projet.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.transport.model.PortDeparture;
import com.projet.transport.model.User;
import com.projet.transport.request.CreatePortRequest;
import com.projet.transport.response.MessageResponse;
import com.projet.transport.service.PortDepartureService;
import com.projet.transport.service.UserService;

@RestController
@RequestMapping("/api/admin/ports")	

public class AdminPortController {	
	
	@Autowired
	private PortDepartureService portService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping()
	public ResponseEntity<PortDeparture>createPort(@RequestBody CreatePortRequest req, 
											@RequestHeader ("Authorization") String jwt
											)throws Exception{
		
		User user = userService.findUserByJwtToken(jwt);
		
		PortDeparture port = portService.createPort(req,user);
		
		
		return new ResponseEntity<>(port, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PortDeparture>updatePort(@RequestBody CreatePortRequest req, 
											@RequestHeader ("Authorization") String jwt,
											@PathVariable Long id
											)throws Exception{
		
		User user = userService.findUserByJwtToken(jwt);
		
		PortDeparture port = portService.updatePort(id,req);
		
		return new ResponseEntity<>(port, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse>deletePort(@RequestHeader ("Authorization") String jwt,
														@PathVariable Long id
														)throws Exception{
		
		User user = userService.findUserByJwtToken(jwt);
		
		portService.deletePort(id);
		
		MessageResponse res = new MessageResponse();
		res.setMessage("Port deleted successfully");
		
		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}
}

