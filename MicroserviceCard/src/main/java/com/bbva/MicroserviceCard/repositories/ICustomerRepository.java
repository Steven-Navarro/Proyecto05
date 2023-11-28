package com.bbva.MicroserviceCard.repositories;

import com.bbva.MicroserviceCard.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
}
