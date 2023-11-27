package com.bbva.MicroserviceCustomer.service;

import com.bbva.MicroserviceCustomer.entity.Customer;
import com.bbva.MicroserviceCustomer.exceptions.ResourceNotFoundException;
import com.bbva.MicroserviceCustomer.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(String customerID) {
        return customerRepository.findById(customerID).orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado no el ID: " + customerID));
    }
}
