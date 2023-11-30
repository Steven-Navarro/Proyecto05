package com.bbva.MicroserviceEstablishment.mapper;

import com.bbva.MicroserviceEstablishment.dto.EstablishmentDTO;
import com.bbva.MicroserviceEstablishment.entity.Establishment;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IEstablishmentMapper {
    Establishment toEntity(EstablishmentDTO establishmentDTO);

    EstablishmentDTO toDTO(Establishment establishment);

    List<EstablishmentDTO> ListToDtoList(List<Establishment> establishments);
}
