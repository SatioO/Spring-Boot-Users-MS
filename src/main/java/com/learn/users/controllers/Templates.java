package com.learn.users.controllers;

import com.learn.users.dto.models.TemplateDTO;
import com.learn.users.services.ITemplateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("templates")
@AllArgsConstructor
public class Templates {
    private final ITemplateService templateService;

    @GetMapping
    public List<TemplateDTO> getTemplates() {
        return templateService.getTemplates();
    }

    @GetMapping("/{templateId}")
    public TemplateDTO getTemplateById(@PathVariable Long templateId) {
        return templateService.getTemplateById(templateId);
    }

    @PostMapping
    public TemplateDTO createTemplate(@RequestBody @Valid TemplateDTO template) {
        return templateService.createTemplate(template);
    }
}
