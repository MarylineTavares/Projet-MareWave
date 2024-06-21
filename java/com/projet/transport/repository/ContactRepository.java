package com.projet.transport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projet.transport.model.Contact;

public interface ContactRepository extends JpaRepository<Contact,Long> {

	List<Contact> findAll();
}
