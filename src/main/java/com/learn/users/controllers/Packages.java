package com.learn.users.controllers;

import com.learn.users.dto.models.PackageDTO;
import com.learn.users.services.IPackageService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "packages")
public class Packages {
    private final IPackageService packageService;

    @GetMapping
    public List<PackageDTO> findPackages() {
        return packageService.getPackages();
    }

    @GetMapping("/{id}")
    public PackageDTO findPackages(@PathVariable @NotNull Long packageId) {
        return packageService.getPackage(packageId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PackageDTO createPackage(@RequestBody @Valid PackageDTO packageGroup) {
        return packageService.createPackage(packageGroup);
    }
}
