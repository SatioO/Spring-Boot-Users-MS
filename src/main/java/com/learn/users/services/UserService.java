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
    Map<UUID, UserDto> users = new HashMap<>();

    @Autowired
    private UserRepository userRepository;

    @Override
    public Collection<UserDto> getAllUsers() {
        return users.values();
    }

    @Override
    public UserDto getUserById(String id) {
        return users.get(id);
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
