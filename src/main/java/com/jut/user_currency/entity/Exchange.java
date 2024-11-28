package com.jut.user_currency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table( name = "exchange")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exchange extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    User user;

    @ManyToOne
    @JoinColumn(name = "currency_id", nullable = false)
    Currency currency;

    @Column(name = "amount_in_krw", nullable = false)
    BigDecimal beforeExchange;

    @Column(name = "amount_after_exchange", nullable = false)
    BigDecimal afterExchange;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(255) DEFAULT 'normal'")
    Status status;

    public enum Status {
        NORMAL, CANCELLED
    }
}
