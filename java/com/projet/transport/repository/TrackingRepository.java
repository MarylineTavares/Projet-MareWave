package com.projet.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projet.transport.model.Tracking;


public interface TrackingRepository extends JpaRepository <Tracking, Long>{
	
	@Query("SELECT t FROM Tracking t JOIN t.calendar c WHERE c.reference=:reference")
	public List<Tracking> findByReference(String reference);
}
	
