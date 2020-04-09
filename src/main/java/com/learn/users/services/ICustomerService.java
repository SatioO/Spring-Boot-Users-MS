package com.learn.users.services;

import com.learn.users.dto.models.CustomerDTO;
import com.learn.users.exceptions.CustomerNotFoundException;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerById(Long id) throws CustomerNotFoundException;
    CustomerDTO createCustomer(CustomerDTO customer);
}
