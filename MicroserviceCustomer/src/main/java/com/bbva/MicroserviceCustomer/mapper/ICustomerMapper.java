package com.bbva.MicroserviceCustomer.mapper;

import com.bbva.MicroserviceCustomer.dto.CustomerDTO;
import com.bbva.MicroserviceCustomer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {

    //ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDTOToCustomer(CustomerDTO customerDTO);

    List<CustomerDTO> customerListToDtoList(List<Customer> customers);
}
