package com.bbva.MicroserviceEstablishment.service;

import com.bbva.MicroserviceEstablishment.dto.EstablishmentDTO;
import com.bbva.MicroserviceEstablishment.entity.Establishment;
import com.bbva.MicroserviceEstablishment.mapper.IEstablishmentMapper;
import com.bbva.MicroserviceEstablishment.repositories.IEstablishmentRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public class EstablishmentServiceImpl implements IEstablishmentService {

    @Autowired
    private IEstablishmentRepository establishmentRepository;

    @Autowired
    private IEstablishmentMapper establishmentMapper;

    @Override
    public List<EstablishmentDTO> getAllEstablishment() {
        List<Establishment> establishments = establishmentRepository.findAll();
        List<EstablishmentDTO> establishmentsDTO = establishmentMapper.ListToDtoList(establishments);
        return establishmentsDTO;
    }

    @Override
    public EstablishmentDTO getEstablishment(Integer establishmentID) {
        Establishment establishment = establishmentRepository.findById(establishmentID).orElseThrow();
        EstablishmentDTO establishmentDTO = establishmentMapper.toDTO(establishment);
        return establishmentDTO;
    }
}
