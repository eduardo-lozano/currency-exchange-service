package com.eduardo.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchangeValue {

	@Id
	private long id;

	// Since the word 'from' is reserved in SQL, you cannot have a column named 'from'.
	// You have to change the name of the column with the annotation @Column
	@Column(name="currency_from")
	private String from;
	// Change this column name as well, just for name consistency
	@Column(name="currency_to")
	private String to;
	private BigDecimal conversionFactor;
	// Just for learning purposes, to know easily which service instance I'm talking to:
	// we put different service instances in different ports
	private int port;

	// Default no-args constructor is required for JPA to be able to use this bean
	public CurrencyExchangeValue() {

	}

	public CurrencyExchangeValue(long id, String from, String to, BigDecimal conversionMultiple) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionFactor = conversionMultiple;
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

	public BigDecimal getConversionFactor() {
		return conversionFactor;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}