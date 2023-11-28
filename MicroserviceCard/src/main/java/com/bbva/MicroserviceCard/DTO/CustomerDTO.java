package com.bbva.MicroserviceCard.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private String customerID;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
