package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.dto.CardDTO;
import com.bbva.MicroserviceCard.entity.Card;

import java.util.List;

public interface ICardService {

    List<CardDTO> getAllCards();

    CardDTO getCard(Integer cardID);
}
