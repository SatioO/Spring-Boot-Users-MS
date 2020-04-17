package com.learn.users.controllers;

import com.learn.users.dto.models.BundleDTO;
import com.learn.users.services.IBundleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "bundles")
@AllArgsConstructor
public class Bundles {
    private final IBundleService bundleService;

    @GetMapping
    public List<BundleDTO> findBundles() {
        return bundleService.getBundles();
    }

    @GetMapping("/{id}")
    public BundleDTO findBundleById(@PathVariable @NotNull Long bundleId) {
        return bundleService.getBundleById(bundleId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BundleDTO createBundle(@RequestBody @Valid BundleDTO bundle) {
        return bundleService.createBundle(bundle);
    }
}
