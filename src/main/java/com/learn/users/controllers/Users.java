package com.learn.users.controllers;

import com.learn.users.dto.models.UserDTO;
import com.learn.users.exceptions.ResourceNotFoundException;
import com.learn.users.exceptions.UserNotFoundException;
import com.learn.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("users")
public class Users {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        try {
            UserDTO user = userService.getUserById(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user);
        } catch (UserNotFoundException e) {
            throw new ResourceNotFoundException(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userService.createUser(user));
    }
}