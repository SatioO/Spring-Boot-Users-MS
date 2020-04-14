package com.learn.users.services.impl;

import com.learn.users.dto.mappers.PackageMapper;
import com.learn.users.dto.models.PackageDTO;
import com.learn.users.repositories.PackageRepository;
import com.learn.users.services.IPackageService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PackageService implements IPackageService {
    private final PackageRepository packageRepository;

    @Override
    public List<PackageDTO> getAllRoles() {
        return packageRepository.findAll().stream().map(PackageMapper::toRoleDTO).collect(Collectors.toList());
    }

    @Override
    public PackageDTO createRole(PackageDTO role) {
        return PackageMapper.toRoleDTO(packageRepository.save(PackageMapper.toRoleEntity(role)));
    }
}
