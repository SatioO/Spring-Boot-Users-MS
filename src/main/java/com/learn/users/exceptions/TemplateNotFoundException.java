package com.learn.users.exceptions;

public class TemplateNotFoundException extends ResourceNotFoundException {
    public TemplateNotFoundException(String exception) {
        super(exception);
    }
}
