package com.learn.users.exceptions;

public class BookNotFoundException extends ResourceNotFoundException {
    public BookNotFoundException(String exception) {
        super(exception);
    }
}
