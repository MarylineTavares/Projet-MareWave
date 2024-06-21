package com.projet.transport.service;

import java.util.List;

import com.projet.transport.model.Quotation;
import com.projet.transport.request.QuotationRequest;

public interface QuotationService {
	
	public Quotation calculatePrice(QuotationRequest req) throws Exception;
	
	public List<Quotation> getAllQuote() throws Exception;
	
}
