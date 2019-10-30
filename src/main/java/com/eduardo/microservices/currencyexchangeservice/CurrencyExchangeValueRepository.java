package com.eduardo.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeValueRepository extends JpaRepository<CurrencyExchangeValue, Long> {

	// Notice the method name 'findByFromAndTo' refers to the names 'from' and 'to' as the names of the
	// variables in the CurrencyExchangeValue class, NOT as the column names I arbitrarily assigned to
	// them with the annotation @Column
	// No need to implement the method, the JPA implements it automatically
	public CurrencyExchangeValue findByFromAndTo(String from, String to);
}
