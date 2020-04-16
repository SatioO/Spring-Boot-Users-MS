package com.learn.users.services;

import com.learn.users.dto.models.BundleDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.exceptions.UserNotFoundException;

import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface IUserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id) throws UserNotFoundException;

    Set<UserDTO> getUsersByIds(Set<Long> userIds);

    List<UserDTO> getUsersByBundleId(Long bundleId);

    UserDTO createUser(UserDTO user, BundleDTO bundle);

}
