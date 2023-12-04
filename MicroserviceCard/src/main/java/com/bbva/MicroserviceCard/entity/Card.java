package com.bbva.MicroserviceCard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    private Integer cardId;

    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Enumerated(EnumType.STRING)
    private CardType type;

    @Column(name = "available_balance", nullable = false)
    private BigDecimal availableBalance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
