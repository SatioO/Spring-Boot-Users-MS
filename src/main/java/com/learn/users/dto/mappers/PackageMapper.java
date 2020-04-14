package com.learn.users.dto.mappers;

import com.learn.users.dto.models.PackageDTO;
import com.learn.users.entities.Package;

public class PackageMapper {
    public static PackageDTO toPackageDTO(Package aPackage){
        return new PackageDTO()
                .setId(aPackage.getId())
                .setName(aPackage.getName());
    }

    public static Package toPackageEntity(PackageDTO aPackage){
        return new Package()
                .setId(aPackage.getId())
                .setName(aPackage.getName());
    }
}
