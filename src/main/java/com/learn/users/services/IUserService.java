package com.learn.users.services;

import com.learn.users.dto.UserDto;

import java.util.Collection;
import java.util.UUID;

public interface IUserService {
    Collection<UserDto> getAllUsers();
    UserDto getUserById(UUID id);
    UserDto createUser(UserDto user);
}
