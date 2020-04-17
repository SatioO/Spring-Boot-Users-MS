package com.learn.users.services.impl;

import com.learn.users.dto.mappers.TemplateMapper;
import com.learn.users.dto.models.TemplateDTO;
import com.learn.users.exceptions.TemplateNotFoundException;
import com.learn.users.repositories.TemplateRepository;
import com.learn.users.services.ITemplateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TemplateService implements ITemplateService {
    private final TemplateRepository templateRepository;

    @Override
    public List<TemplateDTO> getTemplates() {
        return templateRepository.findAll()
                .stream()
                .map(TemplateMapper::toTemplateDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TemplateDTO getTemplateById(Long templateId) throws TemplateNotFoundException {
        return TemplateMapper.toTemplateDTO(templateRepository.findById(templateId)
                .orElseThrow(() -> new TemplateNotFoundException("Template not found: " + templateId)));
    }

    @Override
    public TemplateDTO createTemplate(TemplateDTO template) {
        return TemplateMapper
                .toTemplateDTO(templateRepository.save(TemplateMapper.toTemplateEntity(template)));
    }
}
