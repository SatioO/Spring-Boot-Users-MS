package com.learn.users.dto.mappers;

import com.learn.users.dto.models.RoleDTO;
import com.learn.users.entities.Role;

public class RoleMapper {
    public static RoleDTO toRoleDTO(Role role){
        return new RoleDTO().setRole(role.getRole());
    }

    public static Role toRoleEntity(RoleDTO role){
        return new Role().setId(role.getId()).setRole(role.getRole());
    }
}
