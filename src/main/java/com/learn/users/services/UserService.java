package com.learn.users.services;

import com.learn.users.entities.User;
import com.learn.users.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(User userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        userRepository.save(userDetails);
        return userDetails;
    }
}
