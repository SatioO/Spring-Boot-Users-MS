package com.learn.users.exceptions;

public class OrderNotFoundException extends ResourceNotFoundException {
    public OrderNotFoundException(String exception) {
        super(exception);
    }
}
