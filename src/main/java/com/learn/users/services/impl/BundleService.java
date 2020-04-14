package com.learn.users.services.impl;

import com.learn.users.dto.mappers.BundleMapper;
import com.learn.users.dto.models.BundleDTO;
import com.learn.users.exceptions.BundleNotFoundException;
import com.learn.users.repositories.BundleRepository;
import com.learn.users.services.IBundleService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BundleService implements IBundleService {
    private final BundleRepository bundleRepository;

    @Override
    public List<BundleDTO> getBundles() {
        return bundleRepository.findAll()
                .stream()
                .map(BundleMapper::toBundleDTO).collect(Collectors.toList());
    }

    @Override
    public BundleDTO getBundleById(Long packageId) {
        return bundleRepository.findById(packageId)
                .map(BundleMapper::toBundleDTO)
                .orElseThrow(() -> new BundleNotFoundException("Package not found: " + packageId));
    }

    @Override
    public BundleDTO createBundle(BundleDTO role) {
        return BundleMapper
                .toBundleDTO(
                        bundleRepository.save(BundleMapper.toBundleEntity(role))
                );
    }
}
