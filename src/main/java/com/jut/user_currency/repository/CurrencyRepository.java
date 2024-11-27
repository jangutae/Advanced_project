package com.jut.user_currency.repository;

import com.jut.user_currency.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
     default Currency findByIdOrElseThrow(Long id) {
         return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "잘못된 통화 정보입니다." + id));
     }
}
