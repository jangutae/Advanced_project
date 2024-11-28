package com.jut.user_currency.dto;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class ExchangeRequestDto {

   private final Double beforeExchange;

    public ExchangeRequestDto(Double beforeExchange) {
        this.beforeExchange = beforeExchange;
    }
}
