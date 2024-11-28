package com.jut.user_currency.repository;

import com.jut.user_currency.entity.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {
}
