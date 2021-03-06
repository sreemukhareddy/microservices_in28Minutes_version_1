package com.in28minutes.microservices.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeValue {


	private Long id;
	
	private String from;
	
	private String to;
	private BigDecimal conversionMultiple;
	private Integer port;
	
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
}
