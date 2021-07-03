package com.in28minutes.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.service.CurrencyConversionService;
import com.in28minutes.microservices.vo.ExchangeValue;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/currency-converter")
public class CurrencyConversionController {
	
	
	@Autowired
	private CurrencyConversionService exchangeValueService;

	@GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable String quantity) {
		return exchangeValueService.getExchangeValue(from, to, Integer.valueOf(quantity));
	}
	
	@GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
	public ExchangeValue getExchangeValueUsingFeign(@PathVariable String from, @PathVariable String to, @PathVariable String quantity) {
		log.info("From -> {}, To -> {}, Quantity -> {}", from, to, quantity);
		return exchangeValueService.getExchangeValueUsingFeign(from, to, Integer.valueOf(quantity));
	}
}
