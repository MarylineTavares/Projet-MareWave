package com.projet.transport.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projet.transport.model.Quotation;
import com.projet.transport.repository.QuotationRepository;
import com.projet.transport.request.QuotationRequest;

@Service
public class QuotationServiceImp implements QuotationService {
	
	@Autowired
	private QuotationRepository quotationRepository;
	
	@Override
	public Quotation calculatePrice(QuotationRequest req) throws Exception{
		
		Quotation quotation = new Quotation();
		quotation.setDeparture(req.getDeparture());
		quotation.setArrival(req.getArrival());
		quotation.setType(req.getType());
		quotation.setDimension(req.getDimension());
		quotation.setHeight(req.getHeight());
		quotation.setLength(req.getLength());
		quotation.setWidth(req.getWidth());
		quotation.setQuantity(req.getQuantity());
		quotation.setValueHT(req.getValueHT());
		quotation.setDistance(req.getDistance());
		quotation.setVolume(req.getVolume());
		quotation.setPrice(req.getPrice());
		
		Quotation savedquotation = quotationRepository.save(quotation);

		return savedquotation;
	}
	
	@Override
	public List<Quotation>getAllQuote(){
		
		return quotationRepository.findAll();
	}
}

