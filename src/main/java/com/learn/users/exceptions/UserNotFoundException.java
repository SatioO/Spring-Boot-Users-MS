package com.learn.users.exceptions;

public class UserNotFoundException extends ResourceNotFoundException {
    public UserNotFoundException(String exception) {
        super(exception);
    }
}
