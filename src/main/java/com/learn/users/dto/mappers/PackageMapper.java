package com.learn.users.dto.mappers;

import com.learn.users.dto.models.PackageDTO;
import com.learn.users.entities.Package;

public class PackageMapper {
    public static PackageDTO toRoleDTO(Package aPackage){
        return new PackageDTO()
                .id(aPackage.id())
                .name(aPackage.name());
    }

    public static Package toRoleEntity(PackageDTO aPackage){
        return new Package()
                .id(aPackage.id())
                .name(aPackage.name());
    }
}
