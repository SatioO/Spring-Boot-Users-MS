package com.learn.users.services;

import com.learn.users.dto.models.PackageDTO;

import java.util.List;

public interface IPackageService {
    List<PackageDTO> getAllRoles();

    PackageDTO createRole(PackageDTO role);
}
