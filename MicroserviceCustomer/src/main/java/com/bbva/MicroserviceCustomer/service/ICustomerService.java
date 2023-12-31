package com.bbva.MicroserviceCustomer.service;

import com.bbva.MicroserviceCustomer.dto.CustomerDTO;
import com.bbva.MicroserviceCustomer.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomer(String customerID);

}
