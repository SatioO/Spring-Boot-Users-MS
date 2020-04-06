package com.learn.users.services;

import com.learn.users.dto.UserDto;
import com.learn.users.entities.UserEntity;
import com.learn.users.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findUsers();
    }

    @Override
    public UserDto getUserById(String id) {
        return userRepository.findUserById(id);
    }

    @Override
    public UserDto createUser(UserDto userDetails) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        userDetails.setUserId(UUID.randomUUID().toString());
        UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);

        userRepository.save(userEntity);
        return userDetails;
    }
}
