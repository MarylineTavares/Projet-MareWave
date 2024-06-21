package com.projet.transport.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.transport.model.Calendar;


public interface CalendarRepository extends JpaRepository <Calendar, Long>{
	
	@Query("SELECT c FROM Calendar c JOIN c.portDeparture pd JOIN c.portArrival pa WHERE pd.departure=:departure AND pa.arrival=:arrival AND (:departureDate is null OR c.departureDate=:departureDate) AND (:arrivalDate is null or c.arrivalDate=:arrivalDate)")
	public List<Calendar> findByCalendar(String departure, String arrival, Date departureDate, Date arrivalDate);
}
	
