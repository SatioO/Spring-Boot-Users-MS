package com.learn.users.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> {
    private String status;
    private T data;
    private Object error;
    private Object metadata;

    public static <T> Response<T> set(HttpStatus status, T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        response.setStatus(status.getReasonPhrase().toUpperCase());
        return response;
    }
}
