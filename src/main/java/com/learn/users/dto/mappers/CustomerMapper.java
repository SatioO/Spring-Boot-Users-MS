package com.learn.users.dto.mappers;

import com.learn.users.dto.models.CustomerDTO;
import com.learn.users.entities.Customer;
import org.springframework.stereotype.Component;


@Component
public class CustomerMapper {
    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO().setName(customer.getName())
                .setGender(customer.getGender());
    }

    public static Customer toCustomerEntity(CustomerDTO customer) {
        return new Customer()
                .setGender(customer.getGender())
                .setName(customer.getName());
    }
}
