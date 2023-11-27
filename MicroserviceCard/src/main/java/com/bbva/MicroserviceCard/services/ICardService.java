package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.entity.Card;

import java.util.List;

public interface ICardService {

    List<Card> getAllCards();

    Card getCard(Integer cardID);
}
