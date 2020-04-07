package com.learn.users.controllers;

import com.learn.users.dto.models.UserDTO;
import com.learn.users.dto.response.Response;
import com.learn.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController

@RequestMapping("users")
public class Users {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/{id}")
    public Response<UserDTO> getUser(@PathVariable  Long id) {
        return Response.set(HttpStatus.OK,userService.getUserById(id));
    }

    @GetMapping
    public Response<List<UserDTO>> getUsers() {
        return Response.set(HttpStatus.OK, userService.getAllUsers());
    }

    @PostMapping
    public Response createUser(@RequestBody @Valid UserDTO user) {
        return Response.set(HttpStatus.CREATED, userService.createUser(user));
    }
}