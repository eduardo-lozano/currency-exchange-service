package com.eduardo.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeValueResource {

	@Autowired
	private Environment environment;

	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchangeValue retrieveCurrencyExchangeValue(
			@PathVariable String fromCurrency, @PathVariable String toCurrency) {

		CurrencyExchangeValue currencyExchangeValue = new CurrencyExchangeValue(1000, fromCurrency, toCurrency, BigDecimal.valueOf(19.50));
		// Just for learning purposes, to know easily which service instance I'm talking to:
		// we put different service instances in different ports
		currencyExchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));

		return currencyExchangeValue;
	}
}