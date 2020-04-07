package com.learn.users.services;

import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.User;
import com.learn.users.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElse(new User());
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDTO createUser(UserDTO user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        user.setUserId(UUID.randomUUID().toString());
        User userEntity = modelMapper.map(user, User.class);

        userRepository.save(userEntity);

        return user;
    }
}
