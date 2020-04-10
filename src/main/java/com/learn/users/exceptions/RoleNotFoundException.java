package com.learn.users.exceptions;

public class RoleNotFoundException extends ResourceNotFoundException {
    public RoleNotFoundException(String exception) {
        super(exception);
    }
}
