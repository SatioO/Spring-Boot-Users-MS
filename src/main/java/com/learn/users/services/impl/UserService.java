package com.learn.users.services.impl;

import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.User;
import com.learn.users.exceptions.UserNotFoundException;
import com.learn.users.repositories.UserRepository;
import com.learn.users.services.IUserService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Invalid user id : " + id));
        return UserMapper.toUserDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        return UserMapper.toUserDTO(userRepository.save(UserMapper.toUserEntity(user)));
    }
}
