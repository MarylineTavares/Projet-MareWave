package com.projet.transport.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.transport.model.Tracking;
import com.projet.transport.service.TrackingService;

@RestController
@RequestMapping("/tracking")

public class TrackingController {
	
	@Autowired
	private TrackingService trackingService;
	
	@GetMapping()
	public ResponseEntity<List<Tracking>>findByReference(@RequestParam String reference) throws Exception{
		
		List<Tracking> tracking = trackingService.findByReference(reference);
		
		return new ResponseEntity<>(tracking, HttpStatus.OK);
	
	
}
}
