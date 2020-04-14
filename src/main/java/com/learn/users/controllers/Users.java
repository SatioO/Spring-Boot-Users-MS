package com.learn.users.controllers;

import com.learn.users.dto.models.BundleDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.services.IBundleService;
import com.learn.users.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "users")
@AllArgsConstructor
public class Users {
    private final IUserService userService;
    private final IBundleService bundleService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(path="/bundle/{bundleId}")
    public List<UserDTO> getUsersByBundleId(@PathVariable Long bundleId) {
        return userService.getUsersByBundleId(bundleId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestParam Long bundleId, @RequestBody @Valid UserDTO customer) {
        BundleDTO bundle = bundleService.getBundleById(bundleId);
        return userService.createUser(customer, bundle);
    }
}