package com.bbva.MicroserviceEstablishment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "establishments")
public class Establishment {

    @Id
    @Column(name = "establishment_id")
    private Integer establishmentId;

    private String name;

    private String address;
}
