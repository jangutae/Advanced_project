package com.jut.user_currency.repository;

import com.jut.user_currency.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
   default Exchange findByIdOrElseThrow(Long exchangeId) {
       return findById(exchangeId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "찾을수 없는 환전요청 정보입니다." + exchangeId));
   }
}
