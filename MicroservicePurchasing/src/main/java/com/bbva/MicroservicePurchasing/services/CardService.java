package com.bbva.MicroservicePurchasing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    @Autowired
    private CardRepository tarjetaRepository;

    public Tarjeta validarTarjeta(Long tarjetaId, BigDecimal monto) {
        Tarjeta tarjeta = tarjetaRepository.findById(tarjetaId)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));

        if (tarjeta.getSaldoDisponible().compareTo(monto) < 0) {
            throw new RuntimeException("Saldo insuficiente en la tarjeta");
        }

        // Actualizar saldo
        tarjeta.setSaldoDisponible(tarjeta.getSaldoDisponible().subtract(monto));
        tarjetaRepository.save(tarjeta);

        return tarjeta;
    }
}
