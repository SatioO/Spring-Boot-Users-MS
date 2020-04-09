package com.learn.users.services;

import com.learn.users.dto.mappers.CustomerMapper;
import com.learn.users.dto.models.CustomerDTO;
import com.learn.users.entities.Customer;
import com.learn.users.exceptions.CustomerNotFoundException;
import com.learn.users.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll().stream()
                .map(CustomerMapper::toCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerById(Long id) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Invalid customer id : " + id));
        return CustomerMapper.toCustomerDTO(customer);
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customer) {
        return CustomerMapper.toCustomerDTO(customerRepository.save(CustomerMapper.toCustomerEntity(customer)));
    }
}
