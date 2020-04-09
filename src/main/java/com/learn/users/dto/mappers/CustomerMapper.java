package com.learn.users.dto.mappers;

import com.learn.users.dto.models.CustomerDTO;
import com.learn.users.entities.Customer;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;


@Component
public class CustomerMapper {
    public static CustomerDTO toCustomerDTO(Customer customer) {
        return new CustomerDTO()
                .setId(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setGender(customer.getGender())
                .setEmail(customer.getEmail())
                .setOrders(customer.getOrders()
                        .stream()
                        .map(OrderMapper::toOrderDTO)
                        .collect(Collectors.toList())
                );
    }

    public static Customer toCustomerEntity(CustomerDTO customer) {
        return new Customer()
                .setId(customer.getId())
                .setFirstName(customer.getFirstName())
                .setLastName(customer.getLastName())
                .setGender(customer.getGender())
                .setEmail(customer.getEmail())
                .setOrders(customer.getOrders()
                        .stream()
                        .map(OrderMapper::toOrderEntity)
                        .collect(Collectors.toList())
                );
    }
}
