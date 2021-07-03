package com.in28minutes.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.config.Configuration;
import com.in28minutes.microservices.vo.LimitsConfiguration;

@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration limitsConfig;
	
	@GetMapping("/limits")
	public LimitsConfiguration getLimitsConfigurations() {
		return new LimitsConfiguration(limitsConfig.getMaximum(), limitsConfig.getMinimum());
	}
}
