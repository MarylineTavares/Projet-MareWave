package com.projet.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.transport.model.Quotation;

public interface QuotationRepository extends JpaRepository <Quotation,Long>{
	
	List<Quotation> findAll();
}
