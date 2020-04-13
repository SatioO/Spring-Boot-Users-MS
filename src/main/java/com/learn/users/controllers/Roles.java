package com.learn.users.controllers;

import com.learn.users.dto.models.RoleDTO;
import com.learn.users.services.IRoleService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "roles")
public class Roles {
    private final IRoleService roleService;

    @GetMapping
    public List<RoleDTO> findAll() {
        return roleService.getAllRoles();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO save(@RequestBody @Valid RoleDTO role) {
        return roleService.createRole(role);
    }
}
