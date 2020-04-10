package com.learn.users.controllers;

import com.learn.users.dto.models.RoleDTO;
import com.learn.users.services.IRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "roles")
public class Roles {
    private IRoleService roleService;

    public Roles(IRoleService roleService) {
        this.roleService = roleService;
    }

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