package com.jut.user_currency.service;

import com.jut.user_currency.dto.UserResponseDto;
import com.jut.user_currency.entity.User;
import com.jut.user_currency.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createdUser(String name, String email) {

        User createdUser = new User(name, email);

        userRepository.save(createdUser);

        return new UserResponseDto(createdUser.getId(), createdUser.getName(), createdUser.getEmail());

    }

    public List<UserResponseDto> findAllUsers() {

        return userRepository.findAll().stream().map(UserResponseDto::toDto).toList();

    }

    public UserResponseDto findUserById(Long id) {
       User findUser = userRepository.findByIdOrThrowElse(id);

       return new UserResponseDto(findUser.getId(), findUser.getName(), findUser.getEmail());
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
