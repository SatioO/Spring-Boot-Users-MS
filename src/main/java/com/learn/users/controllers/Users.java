package com.learn.users.controllers;

import com.learn.users.dto.models.UserDTO;
import com.learn.users.dto.response.Response;
import com.learn.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController

@RequestMapping("users")
public class Users {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/{id}")
    public Response getUser(@PathVariable  Long id) {
        return Response.ok().setPayload(userService.getUserById(id));
    }

    @GetMapping
    public Response getUsers() {
        return Response.ok().setPayload(userService.getAllUsers());
    }

    @PostMapping
    public Response createUser(@RequestBody @Valid UserDTO user) {
        return Response.created().setPayload(userService.createUser(user));
    }
}
