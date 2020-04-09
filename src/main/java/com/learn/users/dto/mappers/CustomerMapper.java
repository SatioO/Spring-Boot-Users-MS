package com.learn.users.dto.mappers;

import com.learn.users.dto.models.CustomerDTO;
import com.learn.users.entities.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerMapper {
    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO()
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setGender(customer.getGender())
                .setEmail(customer.getEmail());
    }

    public static Customer toCustomerEntity(CustomerDTO customer) {
        return new Customer()
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setGender(customer.getGender())
                .setEmail(customer.getEmail());
    }
}
