package com.jut.user_currency.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class CurrencyRequestDto {

    private final String currencyName;

    private final BigDecimal exchangeRate;

    private final String symbol;


    public CurrencyRequestDto(String currencyName, BigDecimal exchangeRate, String symbol) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }
}
