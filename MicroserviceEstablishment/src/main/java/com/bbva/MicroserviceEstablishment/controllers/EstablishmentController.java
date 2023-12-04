package com.bbva.MicroserviceEstablishment.controllers;

import com.bbva.MicroserviceEstablishment.dto.EstablishmentDTO;
import com.bbva.MicroserviceEstablishment.service.IEstablishmentService;
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
@RequestMapping("/establishments")
public class EstablishmentController {

    @Autowired
    private IEstablishmentService establishmentService;

    @Operation(summary = "Obtener establecimiento", description = "Obtiene el establecimiento del Id ingresado.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json"))
    @GetMapping("/{establishmentId}")
    public ResponseEntity<EstablishmentDTO> obtenerEstablecimiento(@PathVariable Integer establishmentId) {
        EstablishmentDTO establishmentDTO = establishmentService.getEstablishment(establishmentId);
        return ResponseEntity.ok(establishmentDTO);
    }

    @Operation(summary = "Obtener todos los establecimientos", description = "Obtiene la lista completa de establecimientos.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json"))
    @GetMapping
    public ResponseEntity<List<EstablishmentDTO>> listarEstablecimientos() {
        List<EstablishmentDTO> establishmentsDTO = establishmentService.getAllEstablishment();
        return ResponseEntity.ok(establishmentsDTO);
    }

}
