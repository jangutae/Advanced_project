package com.jut.user_currency.repository;

import com.jut.user_currency.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
     default Currency findByIdOrElseThrow(Long id) {
         return findById(id).orElseThrow(() -> new IllegalStateException("찾을수 없는 통화 정보입니다."));
     }
}
