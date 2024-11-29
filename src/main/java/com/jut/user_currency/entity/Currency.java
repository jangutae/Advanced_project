package com.jut.user_currency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currencies")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Currency extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long currencyId;

    @Column(name = "currency_name" , nullable = false)
    private String currencyName;

    @Column(name = "exchange_rate", nullable = false)
    private BigDecimal exchangeRate;

    @Column(name = "symbol", nullable = false)
    private String symbol;

    // 하나의 통화 여러 환전 요청
    @OneToMany(mappedBy = "currency")
    private final List<Exchange>  exchanges = new ArrayList<>();

    public Currency(String currencyName, BigDecimal exchangeRate, String symbol) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }
}
