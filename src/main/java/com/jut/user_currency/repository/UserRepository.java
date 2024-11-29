package com.jut.user_currency.repository;

import com.jut.user_currency.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    default User findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new IllegalStateException("찾을수 없는 사용자 정보입니다."));
    }
}

