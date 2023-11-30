package com.bbva.MicroserviceEstablishment.service;

import com.bbva.MicroserviceEstablishment.dto.EstablishmentDTO;

import java.util.List;

public interface IEstablishmentService {

    List<EstablishmentDTO> getAllEstablishment();

    EstablishmentDTO getEstablishment(Integer establishmentID);
}
