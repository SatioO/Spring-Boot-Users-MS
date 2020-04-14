package com.learn.users.exceptions;

public class BundleNotFoundException extends ResourceNotFoundException {
    public BundleNotFoundException(String exception) {
        super(exception);
    }
}
