package com.jut.user_currency.dto;


import com.jut.user_currency.entity.Exchange;

public record ExchangeRequestDto(Long userId, Long currencyId, Double beforeExchangeAmount, Exchange.Status status) {

}
