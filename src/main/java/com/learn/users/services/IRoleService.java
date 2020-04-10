package com.learn.users.services;

import com.learn.users.dto.models.RoleDTO;

import java.util.List;

public interface IRoleService {
    List<RoleDTO> getAllRoles();
    RoleDTO createRole(RoleDTO role);
}
