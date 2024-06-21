package com.projet.transport.service;

import java.sql.Date;
import java.util.List;

import com.projet.transport.model.Calendar;

public interface CalendarService {
	public List<Calendar> searchCalendar(String departure, String arrival, Date departureDate, Date arrivalDate);

}
