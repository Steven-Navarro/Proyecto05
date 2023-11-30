package com.bbva.MicroserviceCard.controllers;

import com.bbva.MicroserviceCard.dto.CardDTO;
import com.bbva.MicroserviceCard.entity.Card;
import com.bbva.MicroserviceCard.repositories.ICardRepository;
import com.bbva.MicroserviceCard.services.ICardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "Obtener tarjeta", description = "Obtiene la tarjeta del Id ingresado")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json"))
    @GetMapping("/{cardID}")
    public ResponseEntity<CardDTO> obtenerTarjeta(@PathVariable Integer cardID) {
        CardDTO cardDTO = cardService.getCard(cardID);
        return ResponseEntity.ok(cardDTO);
    }

    @Operation(summary = "Obtener todos las tarjetas", description = "Obtiene la lista completa de tarjetas.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json"))
    @GetMapping
    public ResponseEntity<List<CardDTO>> listarTarjetas() {
        List<CardDTO> cardsDTO = cardService.getAllCards();
        return ResponseEntity.ok(cardsDTO);
    }

}
