package com.jut.user_currency.service;

import com.jut.user_currency.dto.CurrencyResponseDto;
import com.jut.user_currency.entity.Currency;
import com.jut.user_currency.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyResponseDto createdCurrency(String currencyName, BigDecimal exchangeRate, String symbol) {
        Currency currency = new Currency(currencyName, exchangeRate, symbol);

        currencyRepository.save(currency);

        return new CurrencyResponseDto(currency.getId(), currency.getCurrencyName(), currency.getExchangeRate(), currency.getSymbol());
    }

    public List<CurrencyResponseDto> findAllCurrencies() {
       return currencyRepository.findAll().stream().map(CurrencyResponseDto::toDto).toList();
    }

    public CurrencyResponseDto getCurrencyById(Long id) {
       Currency getCurrency = currencyRepository.findByIdOrElseThrow(id);

        return new CurrencyResponseDto(getCurrency.getId(), getCurrency.getCurrencyName(), getCurrency.getExchangeRate(), getCurrency.getSymbol());
    }
}
