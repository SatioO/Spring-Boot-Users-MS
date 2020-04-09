package com.learn.users.controllers;

import com.learn.users.dto.models.CustomerDTO;
import com.learn.users.services.ICustomerService;
import org.springframework.http.HttpStatus;
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
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public List<CustomerDTO> getCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody @Valid CustomerDTO customer) {
        return customerService.createCustomer(customer);
    }
}