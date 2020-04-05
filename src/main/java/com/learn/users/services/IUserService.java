package com.learn.users.services;

import com.learn.users.dto.UserDto;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(UUID id);
    UserDto createUser(UserDto user);
}
