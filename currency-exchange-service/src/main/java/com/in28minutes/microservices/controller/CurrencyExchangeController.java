package com.in28minutes.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.service.ExchangeValueService;
import com.in28minutes.microservices.vo.ExchangeValue;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueService exchangeValueService;

	@GetMapping("/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
		log.info(" From -> {}, To -> {}", from, to);
		return exchangeValueService.getExchangeValue(from, to, Integer.valueOf(environment.getProperty("local.server.port")));
	}
}
