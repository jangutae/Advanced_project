package com.jut.user_currency.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currencies")
@Getter
public class Currency extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String currencyName;

    @Column(nullable = false)
    private BigDecimal exchangeRate;

    @Column(nullable = false)
    private String symbol;

    @OneToMany(mappedBy = "currency")
    private final List<Exchange>  exchanges = new ArrayList<>();

    public Currency() {}


    public Currency(String currencyName, BigDecimal exchangeRate, String symbol) {
        this.currencyName = currencyName;
        this.exchangeRate = exchangeRate;
        this.symbol = symbol;
    }
}
