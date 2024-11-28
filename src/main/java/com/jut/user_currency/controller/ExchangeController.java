package com.jut.user_currency.controller;

import com.jut.user_currency.dto.ExchangeRequestDto;
import com.jut.user_currency.dto.ExchangeResponseDto;
import com.jut.user_currency.service.CurrencyService;
import com.jut.user_currency.service.ExchangeService;
import com.jut.user_currency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final CurrencyService currencyService;
    private final UserService userService;

    @PostMapping("/users/{userId}/currencies/{currencyId}")
    public ResponseEntity<ExchangeResponseDto> requestExchange(
            @PathVariable Long userId,
            @PathVariable Long currencyId,
            @RequestBody ExchangeRequestDto requestDto
    ) {
        userService.findUserById(userId);
        currencyService.getCurrencyById(currencyId);
        ExchangeResponseDto exchangeResponseDto = exchangeService.requestedExchange(userId, currencyId, requestDto.getBeforeExchange());

        return ResponseEntity.ok().body(exchangeResponseDto);
    }
}
