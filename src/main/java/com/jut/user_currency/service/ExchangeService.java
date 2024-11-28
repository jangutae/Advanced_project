package com.jut.user_currency.service;

import com.jut.user_currency.dto.ExchangeRequestDto;
import com.jut.user_currency.dto.ExchangeResponseDto;
import com.jut.user_currency.entity.Currency;
import com.jut.user_currency.entity.Exchange;
import com.jut.user_currency.entity.User;
import com.jut.user_currency.repository.CurrencyRepository;
import com.jut.user_currency.repository.ExchangeRepository;
import com.jut.user_currency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ExchangeService {

    private final CurrencyRepository currencyRepository;
    private final UserRepository userRepository;

    public ExchangeResponseDto requestedExchange(Long userId, Long currencyId, Double beforeExchange) {
        User findUser = userRepository.findByIdOrElseThrow(userId);
        Currency findCurrency = currencyRepository.findByIdOrElseThrow(currencyId);
        Exchange exchange = new Exchange();

        BigDecimal exchange1 = findCurrency.getExchangeRate().multiply(new BigDecimal(beforeExchange));

        return new ExchangeResponseDto(exchange.getId(), findUser.getUserId(), findCurrency.getCurrencyId(), exchange1, exchange.getStatus());
    }
}
