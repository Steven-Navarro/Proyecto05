package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.dto.CardDTO;
import com.bbva.MicroserviceCard.entity.Card;
import com.bbva.MicroserviceCard.mapper.ICardMapper;
import com.bbva.MicroserviceCard.repositories.ICardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ICardRepository cardRepository;

    @Autowired
    private ICardMapper cardMapper;

    @Autowired
    private RestTemplate clienteRest;

    @Override
    @Transactional(readOnly = true)
    public List<CardDTO> getAllCards() {

        List<Card> cards = cardRepository.findAll();
        List<CardDTO> cardsDTO = cardMapper.toDtoList(cards);

        return cardsDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public CardDTO getCard(Integer cardID) {

        Card card = cardRepository.findById(cardID).orElseThrow();
        CardDTO cardDTO = cardMapper.toDTO(card);

        return  cardDTO;
    }
}
