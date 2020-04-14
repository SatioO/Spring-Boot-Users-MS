package com.learn.users.exceptions;

public class PackageNotFoundException extends ResourceNotFoundException {
    public PackageNotFoundException(String exception) {
        super(exception);
    }
}
