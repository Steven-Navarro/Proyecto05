package com.bbva.MicroserviceCard.mapper;

import com.bbva.MicroserviceCard.dto.CustomerDTO;
import com.bbva.MicroserviceCard.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICustomerMapper {
    Customer toEntity(CustomerDTO customerDTO);
    CustomerDTO toDTO(Customer customer);
    List<CustomerDTO> ListToDtoList(List<Customer> customers);
}
