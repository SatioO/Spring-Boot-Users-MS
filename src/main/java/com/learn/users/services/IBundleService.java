package com.learn.users.services;

import com.learn.users.dto.models.BundleDTO;

import java.util.List;

public interface IBundleService {
    List<BundleDTO> getBundles();

    BundleDTO getBundleById(Long bundleId);

    BundleDTO createBundle(BundleDTO role);
}
