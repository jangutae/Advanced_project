package com.jut.user_currency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table( name = "exchanges")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Exchange extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long exchangeId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    Currency currency;

    @Column(name = "amount_in_krw")
    Double beforeExchangeAmount;

    @Column(name = "amount_after_exchange")
    BigDecimal afterExchangeAmount;

    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "VARCHAR(255) DEFAULT 'normal'")
    Status status;

    public enum Status {
        NORMAL, CANCELLED
    }

    public Exchange(User user, Currency currency, Double beforeExchangeAmount, Exchange.Status status) {
        this.user = user;
        this.currency = currency;
        this.beforeExchangeAmount = beforeExchangeAmount;
        this.status = status;

    }

    public void update(BigDecimal afterExchangeAmount) {
        this.afterExchangeAmount = afterExchangeAmount;
    }
}
