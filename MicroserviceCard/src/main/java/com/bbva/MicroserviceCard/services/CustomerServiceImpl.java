package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.entity.Customer;
import com.bbva.MicroserviceCard.exceptions.ResourceNotFoundException;
import com.bbva.MicroserviceCard.repositories.ICustomerRepository;
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
