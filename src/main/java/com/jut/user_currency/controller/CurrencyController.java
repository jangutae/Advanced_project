package com.jut.user_currency.controller;

import com.jut.user_currency.dto.CurrencyRequestDto;
import com.jut.user_currency.dto.CurrencyResponseDto;
import com.jut.user_currency.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;
    // 통화 생성
    @PostMapping
    public ResponseEntity<CurrencyResponseDto> createCurrency(@RequestBody CurrencyRequestDto requestDto) {
        CurrencyResponseDto currencyResponseDto = currencyService.createdCurrency(requestDto.currencyName(), requestDto.exchangeRate(), requestDto.symbol());

      return ResponseEntity.status(HttpStatus.CREATED).body(currencyResponseDto);
    }
    // 통화 전체 조회
    @GetMapping
    public ResponseEntity<List<CurrencyResponseDto>> findAllCurrencies() {
      List<CurrencyResponseDto> allCurrencies = currencyService.findAllCurrencies();

      return ResponseEntity.ok().body(allCurrencies);
    }
    // 특정 통화 조회
    @GetMapping("/{currencyId}")
    public ResponseEntity<CurrencyResponseDto> findCurrencyById(@PathVariable Long currencyId) {
       CurrencyResponseDto currencyResponseDto = currencyService.getCurrencyById(currencyId);

       return ResponseEntity.ok().body(currencyResponseDto);
    }

    @PatchMapping("/{currencyId}")
    public ResponseEntity<?> updateCurrency(
        @PathVariable Long currencyId,
        @RequestBody CurrencyRequestDto requestDto) {

        String text = currencyService.updateCurrency(currencyId, requestDto);

        return ResponseEntity.ok().body(text);
    }
}
