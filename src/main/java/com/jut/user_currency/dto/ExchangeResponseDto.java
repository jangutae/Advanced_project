package com.jut.user_currency.dto;

import com.jut.user_currency.entity.Exchange;

import java.math.BigDecimal;

public class ExchangeResponseDto {

    private final Long id;
    private final Long userId;
    private final Long currencyId;
    private final BigDecimal afterExchange;
    private final Exchange.Status status;

    public ExchangeResponseDto(Long id, Long userId, Long currencyId, BigDecimal afterExchange, Exchange.Status status) {
        this.id = id;
        this.userId = userId;
        this.currencyId = currencyId;
        this.afterExchange = afterExchange;
        this.status = status;
    }
}
