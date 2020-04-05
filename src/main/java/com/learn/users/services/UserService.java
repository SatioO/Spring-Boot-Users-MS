package com.learn.users.services;

import com.learn.users.dto.UserDto;
import com.learn.users.models.User;

import java.util.Map;
import java.util.UUID;

public interface UserService {
    Map<UUID, User> getAllUsers();
    User getUserById(UUID id);
    User createUser(UserDto user);
}
