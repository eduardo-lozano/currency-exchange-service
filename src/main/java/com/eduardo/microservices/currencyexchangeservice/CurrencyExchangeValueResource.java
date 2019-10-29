package com.eduardo.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeValueResource {
	
	@GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
	public CurrencyExchangeValue retrieveCurrencyExchangeValue(
			@PathVariable String fromCurrency, @PathVariable String toCurrency) {
		return new CurrencyExchangeValue(1000, fromCurrency, toCurrency, BigDecimal.valueOf(19.50));
	}
}