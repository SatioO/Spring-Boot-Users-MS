package com.learn.users.controllers;

import com.learn.users.dto.models.CustomerDTO;
import com.learn.users.exceptions.ResourceNotFoundException;
import com.learn.users.exceptions.CustomerNotFoundException;
import com.learn.users.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("customers")
public class Customers {
    private ICustomerService customerService;

    public Customers(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "/{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        try {
            return customerService.getCustomerById(id);
        } catch (CustomerNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customer) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerService.createCustomer(customer));
    }
}