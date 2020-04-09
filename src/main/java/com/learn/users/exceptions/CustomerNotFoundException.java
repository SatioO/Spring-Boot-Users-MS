package com.learn.users.exceptions;

public class CustomerNotFoundException extends ResourceNotFoundException {
    public CustomerNotFoundException(String exception) {
        super(exception);
    }
}
