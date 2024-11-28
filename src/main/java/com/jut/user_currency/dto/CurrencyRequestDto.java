package com.jut.user_currency.dto;

import lombok.Getter;

import java.math.BigDecimal;


public record CurrencyRequestDto(String currencyName, BigDecimal exchangeRate, String symbol) {

}
