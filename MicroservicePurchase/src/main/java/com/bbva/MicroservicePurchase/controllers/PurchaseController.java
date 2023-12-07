package com.bbva.MicroservicePurchase.controllers;

import com.bbva.MicroservicePurchase.dto.PurchaseDTO;
import com.bbva.MicroservicePurchase.entity.Purchase;
import com.bbva.MicroservicePurchase.repositories.IPurchaseRepository;
import com.bbva.MicroservicePurchase.services.IPurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private IPurchaseService purchaseService;

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Operation(summary = "Realiza compra", description = "Procesa la compra con tarjeta en un establecimiento")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json"))
    @PostMapping("/makePurchase")
    public Purchase realizarCompra(@RequestBody CompraRequest compraRequest) {
        //tarjetaService.validarTarjeta(compraRequest.getTarjetaId(), compraRequest.getMonto());

        //Compra compra = new Compra();
        //compra.setFecha(new Date());
        //compra.setMonto(compraRequest.getMonto());
        //return compraRepository.save(compra);
        return null;
    }

    static class CompraRequest {
        private Long tarjetaId;
        private BigDecimal monto;
    }

    @Operation(summary = "Obtener compra", description = "Obtiene la compra del Id ingresado.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json"))
    @GetMapping("/{purchaseId}")
    public ResponseEntity<PurchaseDTO> obtenerCompra(@PathVariable Integer purchaseId) {
        PurchaseDTO purchaseDTO = purchaseService.getPurchase(purchaseId);
        return ResponseEntity.ok(purchaseDTO);
    }

    @Operation(summary = "Obtener compras", description = "Obtiene la lista completa de compras realizadas.")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json"))
    @GetMapping
    public ResponseEntity<List<PurchaseDTO>> listarCompras() {
        List<PurchaseDTO> purchaseDTOS = purchaseService.getAllPurchase();
        return ResponseEntity.ok(purchaseDTOS);
    }
}
