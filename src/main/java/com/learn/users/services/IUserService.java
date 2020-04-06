package com.learn.users.services;

import com.learn.users.dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(String id);
    UserDto createUser(UserDto user);
}
