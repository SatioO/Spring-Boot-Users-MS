package com.learn.users.controllers;

import com.learn.users.dto.models.UserDTO;
import com.learn.users.services.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(path = "users")
public class Users {
    private IUserService userService;

    public Users(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/{id}")
    public UserDTO findById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public List<UserDTO> findAll() {
        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO save(@RequestBody @Valid UserDTO customer) {
        return userService.createUser(customer);
    }
}