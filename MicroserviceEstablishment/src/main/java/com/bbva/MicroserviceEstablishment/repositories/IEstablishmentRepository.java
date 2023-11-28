package com.bbva.MicroserviceEstablishment.repositories;

import com.bbva.MicroserviceEstablishment.entity.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstablishmentRepository extends JpaRepository<Establishment, Integer> {
}
