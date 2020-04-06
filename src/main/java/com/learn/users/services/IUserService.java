package com.learn.users.services;

import com.learn.users.dto.models.UserDto;
import com.learn.users.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto user);
}
