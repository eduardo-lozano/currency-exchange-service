package com.eduardo.microservices.currencyexchangeservice;

import java.math.BigDecimal;

public class CurrencyExchangeValue {

	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;

	// Default no-args constructor is required for JPA to be able to use this bean
	public CurrencyExchangeValue() {
		
	}

	public CurrencyExchangeValue(long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
	}

	// Only getters, no setters (info will be set up directly from the DB using JPA? )
	public long getId() {
		return id;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
}
