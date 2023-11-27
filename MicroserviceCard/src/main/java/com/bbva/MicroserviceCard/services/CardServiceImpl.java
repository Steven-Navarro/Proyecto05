package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.entity.Card;
import com.bbva.MicroserviceCard.repositories.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ICardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card getCard(Integer cardID) {
        return cardRepository.findById(cardID).orElseThrow();
    }
}
