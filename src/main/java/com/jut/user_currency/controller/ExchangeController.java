package com.jut.user_currency.controller;

import com.jut.user_currency.dto.ExchangeRequestDto;
import com.jut.user_currency.dto.ExchangeResponseDto;
import com.jut.user_currency.service.ExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping
public class ExchangeController {

    private final ExchangeService exchangeService;

    // 환전 요정
    @PostMapping("/exchanges")
    public ResponseEntity<ExchangeResponseDto> requestExchange(
            @RequestBody ExchangeRequestDto requestDto
    ) {
        ExchangeResponseDto exchangeResponseDto = exchangeService.requestedExchange(requestDto);

        return ResponseEntity.ok().body(exchangeResponseDto);
    }

    // 환전 요청 조회
    @GetMapping("/exchanges/{exchangeId}")
    public ResponseEntity<ExchangeResponseDto> requestExchangeByUserId(
            @PathVariable Long exchangeId
    ) {
        ExchangeResponseDto exchangeResponseDto = exchangeService.requestedExchangeById(exchangeId);

        return ResponseEntity.ok().body(exchangeResponseDto);
    }

    // 환전 요청 상태 변경
    @PostMapping("/exchanges/{exchangeId}")
    public ResponseEntity<String> requestedExchangeStatus(
            @PathVariable Long exchangeId
    ) {
        String status = exchangeService.requestedExchangeChangeStatus(exchangeId);

        return ResponseEntity.ok().body(status + "로 상태가 변경되었습니다.");
    }
}

