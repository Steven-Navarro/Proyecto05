package com.bbva.MicroserviceCard.dto;

import com.bbva.MicroserviceCard.entity.CardType;
import com.bbva.MicroserviceCard.entity.Customer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CardDTO implements Serializable {

    private Integer cardId;
    private String cardNumber;
    private CardType type;
    private BigDecimal availableBalance;
    private Customer customer;

}
