package com.learn.users.dto.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@Getter @Setter
public class Response<T> {
    private String status;
    private T data;

    public Response(String status, T data) {
        this.data = data;
        this.status = status;
    }
}
