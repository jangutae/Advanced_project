package com.jut.user_currency.controller;

import com.jut.user_currency.dto.UserRequestDto;
import com.jut.user_currency.dto.UserResponseDto;
import com.jut.user_currency.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 생성
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto requestDto) {
        UserResponseDto userResponseDto = userService.createdUser(requestDto.name(), requestDto.email());

        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }
    // 유저 전체 조회
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUsers() {
        List<UserResponseDto> allUsers = userService.findAllUsers();

        return ResponseEntity.ok().body(allUsers);
    }
    // 특정 유저 조회
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long userId) {
        UserResponseDto userResponseDto = userService.findUserById(userId);

        return ResponseEntity.ok().body(userResponseDto);
    }
    // 유저 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return ResponseEntity.ok().body("유저가 정상적으로 삭제됐습니다.");
    }
}


