package com.learn.users.services;

import com.learn.users.dto.models.PackageDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.exceptions.UserNotFoundException;

import java.util.List;

public interface IUserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id) throws UserNotFoundException;

    UserDTO createUser(UserDTO user, PackageDTO packageDTO);
}
