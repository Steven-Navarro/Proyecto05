package com.bbva.MicroserviceCustomer.service;

import com.bbva.MicroserviceCustomer.dto.CustomerDTO;
import com.bbva.MicroserviceCustomer.entity.Customer;
import com.bbva.MicroserviceCustomer.mapper.ICustomerMapper;
import com.bbva.MicroserviceCustomer.repository.ICustomerRepository;
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
        List<CustomerDTO> customerDTOS =  customerMapper.customerListToDtoList(customers);

        return customerDTOS;
    }

    @Override
    public CustomerDTO getCustomer(String customerID) {

        Customer customer = customerRepository.findById(customerID)
                .orElseThrow();

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        return customerDTO;
    }
}
