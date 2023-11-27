package com.bbva.MicroserviceCustomer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer {

    @Id
    private String customerID;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
