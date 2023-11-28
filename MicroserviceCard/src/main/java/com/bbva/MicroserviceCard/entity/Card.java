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
    private Integer cardID;

    private String numeroTarjeta;

    @Enumerated(EnumType.STRING)
    private CardType tipo;

    private BigDecimal saldoDisponible;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

}
