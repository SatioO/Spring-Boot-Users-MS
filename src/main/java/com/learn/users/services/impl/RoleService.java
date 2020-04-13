package com.learn.users.services.impl;

import com.learn.users.dto.mappers.RoleMapper;
import com.learn.users.dto.models.RoleDTO;
import com.learn.users.repositories.RoleRepository;
import com.learn.users.services.IRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream().map(RoleMapper::toRoleDTO).collect(Collectors.toList());
    }

    @Override
    public RoleDTO createRole(RoleDTO role) {
        return RoleMapper.toRoleDTO(roleRepository.save(RoleMapper.toRoleEntity(role)));
    }
}
