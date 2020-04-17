package com.learn.users.dto.mappers;

import com.learn.users.dto.models.TemplateDTO;
import com.learn.users.entities.Template;

public class TemplateMapper {
    public static TemplateDTO toTemplateDTO(Template template) {
        return new TemplateDTO()
                .setId(template.getId())
                .setName(template.getName())
                .setContent(template.getContent());
    }

    public static Template toTemplateEntity(TemplateDTO template) {
        return new Template()
                .setId(template.getId())
                .setName(template.getName())
                .setContent(template.getContent());
    }
}
