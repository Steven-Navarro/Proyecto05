package com.bbva.MicroservicePurchasing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Date;

@Controller
@RequestMapping("/compras")
public class PurchasingController {

    @Autowired
    private CardService tarjetaService;

    @Autowired
    private PurchasingRepository compraRepository;

    @PostMapping("/realizarCompra")
    public Compra realizarCompra(@RequestBody CompraRequest compraRequest) {
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
