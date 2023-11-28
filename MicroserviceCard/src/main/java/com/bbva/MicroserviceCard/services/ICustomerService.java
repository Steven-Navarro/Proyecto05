package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomer(String customerID);

}
