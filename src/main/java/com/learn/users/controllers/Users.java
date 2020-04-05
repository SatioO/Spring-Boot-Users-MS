package com.learn.users.controllers;

import com.learn.users.dto.UserDto;
import com.learn.users.models.User;
import com.learn.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class Users {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public Map<UUID, User> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody @Valid UserDto user) {
        return userService.createUser(user);
    }
}
