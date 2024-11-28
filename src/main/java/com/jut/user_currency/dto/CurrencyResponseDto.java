package com.jut.user_currency.dto;

import com.jut.user_currency.entity.Currency;

import java.math.BigDecimal;

public record CurrencyResponseDto(Long id, String currencyName, BigDecimal exchangeRate, String symbol) {

    public static CurrencyResponseDto toDto(Currency currency) {
        return new CurrencyResponseDto(currency.getCurrencyId(), currency.getCurrencyName(), currency.getExchangeRate(), currency.getSymbol());
    }
}
