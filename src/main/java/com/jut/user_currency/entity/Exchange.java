package com.jut.user_currency.entity;

import jakarta.persistence.*;

@Entity
@Table( name = "exchange")
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
    Double beforeExchange;

    @Column(name = "amount_after_exchange", nullable = false)
    Double afterExchange;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(255) DEFAULT 'normal'")
    Status status;

    public Exchange() {}

    public enum Status {
        NORMAL, CANCELLED
    }
}
