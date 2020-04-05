package com.learn.users.services;

import com.learn.users.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {
    Map<UUID, UserDto> users = new HashMap<>();

    @Override
    public Collection<UserDto> getAllUsers() {
        return users.values();
    }

    @Override
    public UserDto getUserById(UUID id) {
        return users.get(id);
    }

    @Override
    public UserDto createUser(UserDto userInfo) {
        UUID id = UUID.randomUUID();
        userInfo.setUserId(id);
        users.put(id, userInfo);
        System.out.println(userInfo);
        return null;
    }
}