package com.projet.transport.controller;

import java.sql.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projet.transport.model.Calendar;
import com.projet.transport.service.CalendarService;

@RestController
@RequestMapping("/calendar")

public class CalendarController {
	
	@Autowired
	private CalendarService calendarService;
	
	@GetMapping()
	public ResponseEntity<List<Calendar>>searchCalendar(@RequestParam (name="departure") String departure,
														@RequestParam (name="arrival") String arrival,
														@RequestParam (name="departureDate", required=false) Date departureDate,	
														@RequestParam (name="arrivalDate", required=false) Date arrivalDate
														) throws Exception{
		
		List<Calendar> calendar = calendarService.searchCalendar(departure, arrival, departureDate, arrivalDate);
		
		return new ResponseEntity<>(calendar, HttpStatus.OK);
	}

}
