package com.learn.users.controllers;

import com.learn.users.dto.models.PackageDTO;
import com.learn.users.dto.models.UserDTO;
import com.learn.users.services.IPackageService;
import com.learn.users.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "users")
public class Users {
    private final IUserService userService;
    private final IPackageService packageService;

    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping(path="/package/{packageId}")
    public List<UserDTO> getUsersByPackageId(@PathVariable Long packageId) {
        return userService.getUsersByPackageId(packageId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@RequestParam Long packageId, @RequestBody @Valid UserDTO customer) {
        PackageDTO packageFk = packageService.getPackage(packageId);
        return userService.createUser(customer, packageFk);
    }
}