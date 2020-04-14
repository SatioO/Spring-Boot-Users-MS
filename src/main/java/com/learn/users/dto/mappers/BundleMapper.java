package com.learn.users.dto.mappers;

import com.learn.users.dto.models.BundleDTO;
import com.learn.users.entities.Bundle;

public class BundleMapper {
    public static BundleDTO toBundleDTO(Bundle bundle){
        return new BundleDTO()
                .setId(bundle.getId())
                .setName(bundle.getName());
    }

    public static Bundle toBundleEntity(BundleDTO bundle){
        return new Bundle()
                .setId(bundle.getId())
                .setName(bundle.getName());
    }
}
