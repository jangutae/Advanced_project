package com.jut.user_currency.dto;

import com.jut.user_currency.entity.User;

public record UserResponseDto(Long id, String name, String email) {

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getUserId(), user.getName(), user.getEmail());
    }
}
