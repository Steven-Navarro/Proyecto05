package com.bbva.MicroserviceCustomer.repositories;

import com.bbva.MicroserviceCustomer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, String> {
}
