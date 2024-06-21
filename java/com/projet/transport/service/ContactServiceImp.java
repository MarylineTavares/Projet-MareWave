package com.projet.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.Contact;
import com.projet.transport.repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	@Override
	public List<Contact>getAllContact(){
	
		return contactRepository.findAll();
	}
}
