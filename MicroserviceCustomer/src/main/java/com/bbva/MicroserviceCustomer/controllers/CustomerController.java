package com.bbva.MicroserviceCustomer.controllers;

import com.bbva.MicroserviceCustomer.entity.Customer;
import com.bbva.MicroserviceCustomer.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping("/{customerID}")
    public ResponseEntity<Customer> obtenerCliente(@PathVariable String customerID) {
        Customer customer = customerService.getCustomer(customerID);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> listarClientes() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }
}
