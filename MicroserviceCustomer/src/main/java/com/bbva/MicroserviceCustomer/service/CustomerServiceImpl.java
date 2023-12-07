package com.bbva.MicroserviceCustomer.service;

import com.bbva.MicroserviceCustomer.dto.CustomerDTO;
import com.bbva.MicroserviceCustomer.entity.Customer;
import com.bbva.MicroserviceCustomer.mapper.ICustomerMapper;
import com.bbva.MicroserviceCustomer.repositories.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ICustomerMapper customerMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDTO> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();
        List<CustomerDTO> customerDTOS =  customerMapper.customerListToDtoList(customers);

        return customerDTOS;
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerDTO getCustomer(String customerID) {

        Customer customer = customerRepository.findById(customerID)
                .orElseThrow();

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        return customerDTO;
    }
}
