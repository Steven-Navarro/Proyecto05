package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.dto.CardDTO;
import com.bbva.MicroserviceCard.entity.Card;
import com.bbva.MicroserviceCard.mapper.ICardMapper;
import com.bbva.MicroserviceCard.repositories.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ICardRepository cardRepository;

    @Autowired
    private ICardMapper cardMapper;

    @Override
    public List<CardDTO> getAllCards() {
        List<Card> cards = cardRepository.findAll();

        Card firstCard = cards.get(0);
        System.out.println("Información de la primera tarjeta:");
        System.out.println("Card ID: " + firstCard.getCardID());
        System.out.println("Número de tarjeta: " + firstCard.getNumeroTarjeta());
        System.out.println("Tipo de tarjeta: " + firstCard.getTipo());
        System.out.println("Saldo disponible: " + firstCard.getSaldoDisponible());
        System.out.println("Customer ID: " + (firstCard.getCustomer() != null ? firstCard.getCustomer().getCustomerID() : "N/A"));

        List<CardDTO> cardsDTO = cardMapper.toDtoList(cards);

        CardDTO firstCard2 = cardsDTO.get(0);
        System.out.println("Información de la primera tarjeta:");
        System.out.println("Card ID: " + firstCard2.getCardID());
        System.out.println("Número de tarjeta: " + firstCard2.getNumeroTarjeta());
        System.out.println("Tipo de tarjeta: " + firstCard2.getTipo());
        System.out.println("Saldo disponible: " + firstCard2.getSaldoDisponible());
        System.out.println("Customer ID: " + (firstCard2.getCustomer() != null ? firstCard2.getCustomer().getCustomerID() : "N/A"));

        return cardsDTO;
    }

    @Override
    public CardDTO getCard(Integer cardID) {
        Card card = cardRepository.findById(cardID).orElseThrow();
        CardDTO cardDTO = cardMapper.toDTO(card);
        return  cardDTO;
    }
}
