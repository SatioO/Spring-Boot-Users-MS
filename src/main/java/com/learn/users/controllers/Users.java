package com.learn.users.controllers;

import com.learn.users.models.UserModel;
import com.learn.users.services.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import com.learn.users.dto.UserDto;


@RestController
@RequestMapping("users")
public class Users {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserModel userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        userService.createUser(userDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }
}
