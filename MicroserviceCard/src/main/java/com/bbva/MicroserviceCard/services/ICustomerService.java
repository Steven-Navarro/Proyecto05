package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomer(String customerID);

}
