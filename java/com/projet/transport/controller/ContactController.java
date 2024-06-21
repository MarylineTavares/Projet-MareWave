package com.projet.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.transport.model.Contact;
import com.projet.transport.service.ContactService;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@GetMapping()
	public ResponseEntity<List<Contact>>getAllContact()throws Exception{
		
		List<Contact> contact = contactService.getAllContact();
		
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}
}
