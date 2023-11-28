package com.bbva.MicroserviceEstablishment.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EstablishmentDTO {

    private Integer establishmentID;

    private String nombre;

    private String direccion;
}
