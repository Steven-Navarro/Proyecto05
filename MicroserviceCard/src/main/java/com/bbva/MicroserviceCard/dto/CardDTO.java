package com.bbva.MicroserviceCard.dto;

import com.bbva.MicroserviceCard.entity.CardType;
import com.bbva.MicroserviceCard.entity.Customer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

//@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CardDTO implements Serializable {

    private Integer cardID;
    private String numeroTarjeta;
    private CardType tipo;
    private BigDecimal saldoDisponible;
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
