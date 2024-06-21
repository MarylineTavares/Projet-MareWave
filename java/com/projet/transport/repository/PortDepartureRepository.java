package com.projet.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.transport.model.PortDeparture;
import com.projet.transport.model.PortI;


public interface PortDepartureRepository extends JpaRepository <PortDeparture,Long>{
	
	@Query("SELECT r FROM PortDeparture r WHERE lower(r.departure) LIKE lower(concat('%',:query,'%'))")
	List<PortDeparture> findBySearchQuery(String query);
	
	@Query("SELECT c FROM PortDeparture c WHERE departure=:query")
	PortI findCoordinate(String query);
	
	List<PortDeparture> findAll();
}
