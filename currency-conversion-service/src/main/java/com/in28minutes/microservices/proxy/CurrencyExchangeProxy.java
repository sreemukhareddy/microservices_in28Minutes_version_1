package com.in28minutes.microservices.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.microservices.vo.ExchangeValue;

//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000/currency-exchange")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "zuul-api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange-service/from/{from}/to/{to}")
	public ExchangeValue getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
