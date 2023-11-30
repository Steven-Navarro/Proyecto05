package com.bbva.MicroservicePurchase.controllers;

import com.bbva.MicroservicePurchase.entity.Purchase;
import com.bbva.MicroservicePurchase.repositories.IPurchaseRepository;
import com.bbva.MicroservicePurchase.services.IPurchaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;

@Controller
@RequestMapping("/compras")
public class PurchaseController {

    @Autowired
    private IPurchaseService purchaseService;

    @Autowired
    private IPurchaseRepository purchaseRepository;

    @Operation(summary = "Realiza compra", description = "Procesa la compra con tarjeta en un establecimiento")
    @ApiResponse(responseCode = "200", description = "Operación exitosa", content = @Content(mediaType = "application/json"))
    @PostMapping("/realizarCompra")
    public Purchase realizarCompra(@RequestBody CompraRequest compraRequest) {
        tarjetaService.validarTarjeta(compraRequest.getTarjetaId(), compraRequest.getMonto());

        Compra compra = new Compra();
        compra.setFecha(new Date());
        compra.setMonto(compraRequest.getMonto());
        return compraRepository.save(compra);
    }

    static class CompraRequest {
        private Long tarjetaId;
        private BigDecimal monto;
    }
}
