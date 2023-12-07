package com.bbva.MicroserviceEstablishment.service;

import com.bbva.MicroserviceEstablishment.dto.EstablishmentDTO;
import com.bbva.MicroserviceEstablishment.entity.Establishment;
import com.bbva.MicroserviceEstablishment.mapper.IEstablishmentMapper;
import com.bbva.MicroserviceEstablishment.repositories.IEstablishmentRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper(componentModel = "spring")
public class EstablishmentServiceImpl implements IEstablishmentService {

    @Autowired
    private IEstablishmentRepository establishmentRepository;

    @Autowired
    private IEstablishmentMapper establishmentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<EstablishmentDTO> getAllEstablishment() {

        List<Establishment> establishments = establishmentRepository.findAll();
        List<EstablishmentDTO> establishmentDTOS = establishmentMapper.ListToDtoList(establishments);

        return establishmentDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public EstablishmentDTO getEstablishment(Integer establishmentID) {

        Establishment establishment = establishmentRepository.findById(establishmentID).orElseThrow();
        EstablishmentDTO establishmentDTO = establishmentMapper.toDTO(establishment);

        return establishmentDTO;
    }
}
