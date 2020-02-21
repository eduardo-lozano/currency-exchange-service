package com.eduardo.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeValueResource {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeValueRepository repository;

	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchangeValue retrieveCurrencyExchangeValue(
			@PathVariable String fromCurrency, @PathVariable String toCurrency) {

		CurrencyExchangeValue currencyExchangeValue = repository.findByFromAndTo(fromCurrency, toCurrency);
		// Just for learning purposes, to know easily which service instance I'm talking to:
		// we put different service instances in different ports
		currencyExchangeValue.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		logger.info("{}", currencyExchangeValue);

		return currencyExchangeValue;
	}
}