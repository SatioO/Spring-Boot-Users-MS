package com.learn.users.dto.models;

import lombok.*;
import lombok.experimental.Accessors;

@ToString
@Getter @Setter @Accessors(chain = true)
public class ResponseDTO<T> {
    private String statusCode;
    private T data;
    private String error;
}
