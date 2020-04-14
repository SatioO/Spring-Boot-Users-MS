package com.learn.users.services.impl;

import com.learn.users.dto.mappers.PackageMapper;
import com.learn.users.dto.models.PackageDTO;
import com.learn.users.exceptions.PackageNotFoundException;
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
    public List<PackageDTO> getPackages() {
        return packageRepository.findAll()
                .stream()
                .map(PackageMapper::toPackageDTO).collect(Collectors.toList());
    }

    @Override
    public PackageDTO getPackage(Long packageId) {
        return packageRepository.findById(packageId)
                .map(PackageMapper::toPackageDTO)
                .orElseThrow(() -> new PackageNotFoundException("Package not found: " + packageId));
    }

    @Override
    public PackageDTO createPackage(PackageDTO role) {
        return PackageMapper
                .toPackageDTO(
                        packageRepository.save(PackageMapper.toPackageEntity(role))
                );
    }
}
