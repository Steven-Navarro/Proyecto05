package com.bbva.MicroserviceCard.controllers;

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
    public ResponseEntity<Card> obtenerTarjeta(@PathVariable Integer cardID) {
        Card customer = cardService.getCard(cardID);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Card>> listarTarjetas() {
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

}
