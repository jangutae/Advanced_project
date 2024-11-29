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

    @PostMapping("/exchanges")
    public ResponseEntity<ExchangeResponseDto> requestExchange(
            @RequestBody ExchangeRequestDto requestDto
    ) {
        ExchangeResponseDto exchangeResponseDto = exchangeService.requestedExchange(requestDto);

        return ResponseEntity.ok().body(exchangeResponseDto);
    }

    @GetMapping("/exchanges/{exchangeId}")
    public ResponseEntity<ExchangeResponseDto> requestExchangeByUserId(
            @PathVariable Long exchangeId
    ) {
        ExchangeResponseDto exchangeResponseDto = exchangeService.requestedExchangeById(exchangeId);

        return ResponseEntity.ok().body(exchangeResponseDto);
    }

    @PostMapping("/exchanges/{exchangeId}")
    public ResponseEntity<String> requestedExchangeStatus(
            @PathVariable Long exchangeId
    ) {
      String status = exchangeService.requestedExchangeChangeStatus(exchangeId);

        return ResponseEntity.ok().body(status + "로 상태가 변경되었습니다.");
    }

//    @DeleteMapping("/users/{userId}")
//    public ResponseEntity<String> deleteExchangeByUserId(@PathVariable Long userId) {
//        userService.deleteUser(userId);
//
//       return ResponseEntity.ok().body("정상적으로 삭제되었습니다.");
//    }
}
