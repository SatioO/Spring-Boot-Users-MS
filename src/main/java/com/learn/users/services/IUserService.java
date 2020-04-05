package com.learn.users.services;

import com.learn.users.dto.UserDto;

import java.util.Collection;

public interface IUserService {
    Collection<UserDto> getAllUsers();
    UserDto getUserById(String id);
    UserDto createUser(UserDto user);
}
