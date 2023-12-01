package com.bbva.MicroserviceCard.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "cards")
public class Card {

    @Id
    private Integer cardID;

    @Column(name = "numero_tarjeta", nullable = false)
    private String numeroTarjeta;

    @Enumerated(EnumType.STRING)
    private CardType tipo;

    @Column(name = "saldo_disponible", nullable = false)
    private BigDecimal saldoDisponible;

    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    public Integer getCardID() {
        return cardID;
    }

    public void setCardID(Integer cardID) {
        this.cardID = cardID;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public CardType getTipo() {
        return tipo;
    }

    public void setTipo(CardType tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(BigDecimal saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
