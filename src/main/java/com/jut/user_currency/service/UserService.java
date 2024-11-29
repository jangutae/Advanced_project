package com.jut.user_currency.service;

import com.jut.user_currency.dto.UserResponseDto;
import com.jut.user_currency.entity.User;
import com.jut.user_currency.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserResponseDto createdUser(String name, String email) {
        User createdUser = new User(name, email);

        // 유저 등록 시 필수 값 확인
        if (createdUser.getName().isBlank() || createdUser.getEmail().isBlank()) {
            throw new IllegalArgumentException("요청값의 형식이 맞지 않습니다.");
        }
        // 이메일 형식 검사 로직
        if (!validateEmail(createdUser.getEmail())) {
            throw new IllegalArgumentException("요청값이 형식에 맞지 않습니다.");
        }
        userRepository.save(createdUser);

        return new UserResponseDto(createdUser.getUserId(),
                                   createdUser.getName(),
                                   createdUser.getEmail());
    }

    public List<UserResponseDto> findAllUsers() {
        return userRepository.findAll()
                             .stream()
                             .map(UserResponseDto::toDto)
                             .toList();
    }

    public UserResponseDto findUserById(Long id) {
       User findUser = userRepository.findByIdOrElseThrow(id);

       return new UserResponseDto(findUser.getUserId(),
                                  findUser.getName(),
                                  findUser.getEmail());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public static boolean validateEmail(String email) {
        // 이메일 형식에 대한 정규식
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // 정규식 패턴을 사용하여 이메일 검증
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
