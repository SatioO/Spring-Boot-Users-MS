package com.learn.users.dto.response;

import com.learn.users.dto.models.ResponseDTO;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse response) {
        if(methodParameter.getContainingClass().isAnnotationPresent(RestController.class)){
            int status = ((ServletServerHttpResponse) response).getServletResponse().getStatus();
            String statusCode = HttpStatus.valueOf(status).getReasonPhrase().toUpperCase();
            return new ResponseDTO<>().setStatusCode(statusCode).setData(o);
        }

        return o;
    }
}