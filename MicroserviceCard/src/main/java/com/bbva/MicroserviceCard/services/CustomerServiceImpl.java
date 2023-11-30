package com.bbva.MicroserviceCard.services;

import com.bbva.MicroserviceCard.dto.CustomerDTO;
import com.bbva.MicroserviceCard.entity.Customer;
import com.bbva.MicroserviceCard.mapper.ICustomerMapper;
import com.bbva.MicroserviceCard.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ICustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customersDTO = customerMapper.ListToDtoList(customers);
        return customersDTO;
    }

    @Override
    public CustomerDTO getCustomer(String customerID) {
        Customer customer = customerRepository.findById(customerID).orElseThrow();
        CustomerDTO customerDTO = customerMapper.toDTO(customer);
        return customerDTO;
    }
}
