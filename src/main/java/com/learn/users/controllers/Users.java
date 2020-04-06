package com.learn.users.controllers;

import com.learn.users.dto.UserDto;
import com.learn.users.entities.User;
import com.learn.users.services.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import javax.validation.Valid;


@RestController
@RequestMapping("users")
public class Users {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<Collection<User>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid UserDto userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        User userEntity = modelMapper.map(userDetails, User.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userEntity));
    }
}
