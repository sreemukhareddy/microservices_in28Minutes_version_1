package com.in28minutes.microservices.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LimitsConfiguration {

	private int maximum;
	private int minimum;
}
