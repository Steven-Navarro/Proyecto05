package com.bbva.MicroserviceEstablishment.service;

import com.bbva.MicroserviceEstablishment.entity.Establishment;

import java.util.List;

public interface IEstablishmentService {

    List<Establishment> getAllEstablishment();

    Establishment getCard(Integer EstablishmentID);
}
