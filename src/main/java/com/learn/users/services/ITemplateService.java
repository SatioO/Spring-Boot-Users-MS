package com.learn.users.services;

import com.learn.users.dto.models.TemplateDTO;
import com.learn.users.exceptions.TemplateNotFoundException;

import java.util.List;

public interface ITemplateService {
    List<TemplateDTO> getTemplates();

    TemplateDTO getTemplateById(Long templateId);

    TemplateDTO createTemplate(TemplateDTO template) throws TemplateNotFoundException;
}
