package com.learn.users.services.impl;

import com.learn.users.dto.mappers.PackageMapper;
import com.learn.users.dto.mappers.UserMapper;
import com.learn.users.dto.models.PackageDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.entities.User;
import com.learn.users.exceptions.PackageNotFoundException;
import com.learn.users.exceptions.UserNotFoundException;
import com.learn.users.repositories.UserRepository;
import com.learn.users.services.IUserService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
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
    public List<UserDTO> getUsersByPackageId(Long packageId) throws PackageNotFoundException {
        List<User> users = userRepository.findUsersByPackageFk(packageId)
                .orElseThrow(() -> new UserNotFoundException("Invalid package id : " + packageId));
        System.out.println(users);
        return users.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO createUser(UserDTO user, PackageDTO packageGroup) {
        return UserMapper.toUserDTO(
            userRepository.save(
                    UserMapper.toUserEntity(user).setPackageFk(
                            PackageMapper.toPackageEntity(packageGroup)
                    )
            )
        );
    }


}
