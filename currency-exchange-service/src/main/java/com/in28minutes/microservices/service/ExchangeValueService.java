package com.in28minutes.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.microservices.repository.ExchangeValueRepository;
import com.in28minutes.microservices.vo.ExchangeValue;

@Service
public class ExchangeValueService {

	@Autowired
	private ExchangeValueRepository exchangeValueRepository;
	
	public ExchangeValue getExchangeValue(String from, String to, int port) {
		ExchangeValue exchangeValue = exchangeValueRepository.findByFromAndTo(from, to);
		
		if(exchangeValue == null) {
			return null;
		}
		exchangeValue.setPort(port);
		return exchangeValue;
	}
}
