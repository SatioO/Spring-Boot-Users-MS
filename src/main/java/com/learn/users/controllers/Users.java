package com.learn.users.controllers;

import com.learn.users.models.UserModel;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

import javax.validation.Valid;

import com.learn.users.dto.UserDto;
import com.learn.users.services.IUserService;


@RestController
@RequestMapping("users")
public class Users {
    @Autowired
    private IUserService userService;

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<UserDto>> getUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserModel userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto = modelMapper.map(userDetails, UserDto.class);
        return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.OK);
    }
}
