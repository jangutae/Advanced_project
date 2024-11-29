package com.jut.user_currency.dto;


import com.jut.user_currency.entity.Exchange;

import java.math.BigDecimal;

public record ExchangeResponseDto(Long exchangeId, Long userId, Long currencyId, Double beforeExchangeAmount, BigDecimal afterExchangeAmount, Exchange.Status status) {

    public static ExchangeResponseDto toDto(Exchange exchange) {
        return new ExchangeResponseDto(exchange.getExchangeId(),
                                       exchange.getUser().getUserId(),
                                       exchange.getCurrency().getCurrencyId(),
                                       exchange.getBeforeExchangeAmount(),
                                       exchange.getAfterExchangeAmount(),
                                       exchange.getStatus());

    }
}
