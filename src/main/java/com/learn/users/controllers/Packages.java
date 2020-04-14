package com.learn.users.controllers;

import com.learn.users.dto.models.PackageDTO;
import com.learn.users.services.IPackageService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.AllArgsConstructor;
import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "packages")
public class Packages {
    private final IPackageService packageService;

    @GetMapping
    public List<PackageDTO> findPackages() {
        return packageService.getAllRoles();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PackageDTO createPackage(@RequestBody @Valid PackageDTO packageDTO) {
        return packageService.createRole(packageDTO);
    }
}
