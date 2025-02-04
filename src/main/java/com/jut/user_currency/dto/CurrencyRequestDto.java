package com.jut.user_currency.dto;


import java.math.BigDecimal;


public record CurrencyRequestDto(
	String currencyName,
	BigDecimal exchangeRate,
	String symbol) {

}
