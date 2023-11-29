package com.bbva.MicroserviceCard.controllers;

import com.bbva.MicroserviceCard.dto.CardDTO;
import com.bbva.MicroserviceCard.entity.Card;
import com.bbva.MicroserviceCard.repositories.ICardRepository;
import com.bbva.MicroserviceCard.services.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    private ICardService cardService;

    @GetMapping("/{cardID}")
    public ResponseEntity<CardDTO> obtenerTarjeta(@PathVariable Integer cardID) {
        CardDTO cardDTO = cardService.getCard(cardID);
        return ResponseEntity.ok(cardDTO);
    }

    @GetMapping
    public ResponseEntity<List<CardDTO>> listarTarjetas() {
        List<CardDTO> cardsDTO = cardService.getAllCards();
        return ResponseEntity.ok(cardsDTO);
    }

}
