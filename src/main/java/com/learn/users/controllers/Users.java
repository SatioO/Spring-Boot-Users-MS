package com.learn.users.controllers;

import com.learn.users.dto.UserDto;
import com.learn.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class Users {
    @Autowired
    private IUserService UserService;

    @GetMapping(path = "/{id}")
    public UserDto getUser(@PathVariable UUID id) {
        return UserService.getUserById(id);
    }

    @GetMapping
    public Collection<UserDto> getUsers() {
        return UserService.getAllUsers();
    }

    @PostMapping
    public UserDto createUser(@RequestBody @Valid UserDto user) {
        return UserService.createUser(user);
    }
}
