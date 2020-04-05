package com.learn.users.controllers;

import com.learn.users.dto.UserDto;
import com.learn.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserDto> getUser(@PathVariable UUID id) {
        return new ResponseEntity<>(UserService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> getUsers() {
        return new ResponseEntity<>(UserService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDto user) {
        return new ResponseEntity<>(UserService.createUser(user), HttpStatus.OK);
    }
}
