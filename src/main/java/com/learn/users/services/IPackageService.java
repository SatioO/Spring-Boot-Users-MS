package com.learn.users.services;

import com.learn.users.dto.models.PackageDTO;

import java.util.List;

public interface IPackageService {
    List<PackageDTO> getPackages();

    PackageDTO getPackage(Long packageId);

    PackageDTO createPackage(PackageDTO role);
}
