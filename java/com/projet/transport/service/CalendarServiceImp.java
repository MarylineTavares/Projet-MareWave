package com.projet.transport.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.Calendar;
import com.projet.transport.repository.CalendarRepository;

@Service
public class CalendarServiceImp implements CalendarService{
	
	@Autowired
	private CalendarRepository calendarRepository;
	
	@Override
	public List<Calendar>searchCalendar(String departure, String arrival, Date departureDate, Date arrivalDate){
		
		return calendarRepository.findByCalendar(departure, arrival, departureDate, arrivalDate);
	}
	
}
