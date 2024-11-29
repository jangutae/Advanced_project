package com.jut.user_currency.exception;

import lombok.Getter;

@Getter
public class ExceptionResponseDto {

    private final String ErrorCode;
    private final String ErrorMessage;

    public ExceptionResponseDto(String errorCode, String errorMessage) {
        ErrorCode = errorCode;
        ErrorMessage = errorMessage;
    }
}
