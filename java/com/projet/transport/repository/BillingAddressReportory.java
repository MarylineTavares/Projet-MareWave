package com.projet.transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.transport.model.BillingAddress;


public interface BillingAddressReportory extends JpaRepository <BillingAddress, Long>{

}
