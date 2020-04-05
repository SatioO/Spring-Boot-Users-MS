package com.learn.users.services;

import com.learn.users.dto.UserDto;
import com.learn.users.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    Map<UUID, User> users = new HashMap<>();

    @Override
    public Map<UUID, User> getAllUsers() {
        return users;
    }

    @Override
    public User getUserById(UUID id) {
        return users.get(id);
    }

    @Override
    public User createUser(UserDto user) {
        UUID id = UUID.randomUUID();
        User newUser = new User(id, user.getName(), user.getGender());
        users.put(id, newUser);

        return newUser;
    }
}
