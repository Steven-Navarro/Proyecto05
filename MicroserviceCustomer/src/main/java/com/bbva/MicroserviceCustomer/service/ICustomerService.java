package com.bbva.MicroserviceCustomer.service;

import com.bbva.MicroserviceCustomer.entity.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomer(String customerID);

}
