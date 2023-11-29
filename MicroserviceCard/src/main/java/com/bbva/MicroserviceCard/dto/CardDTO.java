package com.bbva.MicroserviceCard.dto;

import com.bbva.MicroserviceCard.entity.CardType;
import com.bbva.MicroserviceCard.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {

    private Integer cardID;

    private String numeroTarjeta;

    private CardType tipo;

    private BigDecimal saldoDisponible;

    private Customer customer;
}
