package com.jut.user_currency.repository;

import com.jut.user_currency.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
   default Exchange findByIdOrElseThrow(Long exchangeId) {
       return findById(exchangeId).orElseThrow(() ->  new IllegalStateException("찾을수 없는 환전 요청 정보입니다."));
   }
}
