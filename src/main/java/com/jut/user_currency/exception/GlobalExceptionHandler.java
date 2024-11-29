package com.jut.user_currency.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 데이터 베이스에 저장되어 있지 않을 경우 반환 에러 코드
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<Map<String, String>> handlerIllegalStateException(IllegalStateException ex) {

        Map<String, String> response = new HashMap<>();

        response.put("errorCode", "ERR001");
        response.put("errorMessage", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
    // 요청 형식이 올바르지 않을 경우 반환 에러코드
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handlerIllegalArgumentException(IllegalArgumentException ex) {

        Map<String, String> response = new HashMap<>();

        response.put("errorCode", "ERR002");
        response.put("errorMessage", ex.getMessage());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(response);
    }
}
