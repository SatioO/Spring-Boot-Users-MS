package com.learn.users.controllers;

import com.learn.users.dto.models.SectionDTO;
import com.learn.users.services.ISectionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("sections")
@AllArgsConstructor
public class Sections {
    private final ISectionService sectionService;

    @GetMapping
    public List<SectionDTO> getSections() {
        return sectionService.getSections();
    }

    @GetMapping("/{id}")
    public SectionDTO getSection(Long id) {
        return sectionService.getSectionById(id);
    }

    @PostMapping
    public SectionDTO createSection(SectionDTO section) {
        return sectionService.createSection(section);
    }
}
