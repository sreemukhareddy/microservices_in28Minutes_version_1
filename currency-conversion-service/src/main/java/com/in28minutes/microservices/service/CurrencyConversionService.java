package com.in28minutes.microservices.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.microservices.proxy.CurrencyExchangeProxy;
import com.in28minutes.microservices.vo.ExchangeValue;

@Service
public class CurrencyConversionService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	public ExchangeValue getExchangeValue(String from, String to, int quantity) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<ExchangeValue> responseEntity = restTemplate.getForEntity("http://localhost:8000/from/{from}/to/{to}", ExchangeValue.class, uriVariables);
		if(responseEntity != null && responseEntity.getStatusCodeValue() == 200) {
			ExchangeValue exchangeValue = responseEntity.getBody();
			BigDecimal multiply = exchangeValue.getConversionMultiple().multiply(new BigDecimal(quantity));
			exchangeValue.setQuantity(new BigDecimal(quantity));
			exchangeValue.setTotalCalculatedAmount(multiply);
			return exchangeValue;
		}
		return null;
	}

	public ExchangeValue getExchangeValueUsingFeign(String from, String to, Integer quantity) {
		ExchangeValue exchangeValue = currencyExchangeProxy.getExchangeValue(from, to);
		if(exchangeValue != null ) {
			BigDecimal multiply = exchangeValue.getConversionMultiple().multiply(new BigDecimal(quantity));
			exchangeValue.setQuantity(new BigDecimal(quantity));
			exchangeValue.setTotalCalculatedAmount(multiply);
			return exchangeValue;
		}
		return null;
	}
}
