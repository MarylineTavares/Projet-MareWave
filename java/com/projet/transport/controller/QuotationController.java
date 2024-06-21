package com.projet.transport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projet.transport.model.Quotation;
import com.projet.transport.request.QuotationRequest;
import com.projet.transport.service.QuotationService;


@RestController
@RequestMapping("/quotation")
public class QuotationController {
		
	@Autowired
	private QuotationService quotationService;
	
	@PostMapping()
	public ResponseEntity<Quotation>calculatePrice(@RequestBody QuotationRequest req)throws Exception{
		
		Quotation quotation = quotationService.calculatePrice(req);
		
		return new ResponseEntity<>(quotation, HttpStatus.CREATED);
	}
	
	@GetMapping("/list")
	public ResponseEntity<List<Quotation>>getAllPort()throws Exception{
		
		List<Quotation> quote = quotationService.getAllQuote();
		
		return new ResponseEntity<>(quote, HttpStatus.OK);
	}
}
