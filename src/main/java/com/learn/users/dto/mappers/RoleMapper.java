package com.learn.users.dto.mappers;

import com.learn.users.dto.models.RoleDTO;
import com.learn.users.entities.Role;

public class RoleMapper {
    public static RoleDTO toRoleDTO(Role role){
        return new RoleDTO().role(role.role());
    }

    public static Role toRoleEntity(RoleDTO role){
        return new Role().id(role.id()).role(role.role());
    }
}
