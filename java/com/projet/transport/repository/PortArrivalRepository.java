package com.projet.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.transport.model.PortArrival;
import com.projet.transport.model.PortI;


public interface PortArrivalRepository extends JpaRepository <PortArrival,Long>{
	
	@Query("SELECT r FROM PortArrival r WHERE lower(r.arrival) LIKE lower(concat('%',:query,'%'))")
	List<PortArrival> findBySearchQuery(String query);
	
	@Query("SELECT c FROM PortArrival c WHERE arrival=:query")
	PortI findCoordinate(String query);
	
	List<PortArrival> findAll();
}
