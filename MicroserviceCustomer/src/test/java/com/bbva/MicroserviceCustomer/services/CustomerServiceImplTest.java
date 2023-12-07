package com.bbva.MicroserviceCustomer.services;

import com.bbva.MicroserviceCustomer.mapper.ICustomerMapper;
import com.bbva.MicroserviceCustomer.repositories.ICustomerRepository;
import com.bbva.MicroserviceCustomer.service.CustomerServiceImpl;
import com.bbva.MicroserviceCustomer.entity.Customer;
import com.bbva.MicroserviceCustomer.dto.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerServiceImplTest {

    @Mock
    private ICustomerRepository customerRepository;

    @Mock
    private ICustomerMapper customerMapper;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Test
    public void testGetAllCustomers() {
        List<Customer> mockCustomers = Arrays.asList(
                new Customer("1", "John", "Doe", "john.doe@example.com", "123456789"),
                new Customer("2", "Jane", "Doe", "jane.doe@example.com", "987654321")
        );
        Mockito.when(customerRepository.findAll()).thenReturn(mockCustomers);

        List<CustomerDTO> mockCustomerDTOs = Arrays.asList(
                new CustomerDTO("1", "John", "Doe", "john.doe@example.com", "123456789"),
                new CustomerDTO("2", "Jane", "Doe", "jane.doe@example.com", "987654321")
        );
        Mockito.when(customerMapper.customerListToDtoList(mockCustomers)).thenReturn(mockCustomerDTOs);

        List<CustomerDTO> result = customerService.getAllCustomers();

        assertEquals(mockCustomerDTOs, result);
    }

    @Test
    public void testGetCustomer() {
        String customerId = "1";
        Customer mockCustomer = new Customer(customerId, "John", "Doe", "john.doe@example.com", "123456789");
        Mockito.when(customerRepository.findById(customerId)).thenReturn(Optional.of(mockCustomer));

        CustomerDTO mockCustomerDTO = new CustomerDTO(customerId, "John", "Doe", "john.doe@example.com", "123456789");
        Mockito.when(customerMapper.customerToCustomerDTO(mockCustomer)).thenReturn(mockCustomerDTO);

        CustomerDTO result = customerService.getCustomer(customerId);

        assertEquals(mockCustomerDTO, result);
    }
}

