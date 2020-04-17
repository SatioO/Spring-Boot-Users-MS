package com.learn.users.dto.mappers;

import com.learn.users.dto.models.SectionDTO;
import com.learn.users.entities.Section;

public class SectionMapper {
    public static SectionDTO toSectionDTO(Section section) {
        return new SectionDTO()
                .setId(section.getId())
                .setName(section.getName())
                .setDescription(section.getDescription());
    }

    public static Section toSectionEntity(SectionDTO section) {
        return new Section()
                .setId(section.getId())
                .setName(section.getName())
                .setDescription(section.getDescription());
    }
}
