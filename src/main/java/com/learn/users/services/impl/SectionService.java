package com.learn.users.services.impl;

import com.learn.users.dto.mappers.SectionMapper;
import com.learn.users.dto.models.SectionDTO;
import com.learn.users.exceptions.SectionNotFoundException;
import com.learn.users.repositories.SectionRepository;
import com.learn.users.services.ISectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class SectionService implements ISectionService {
    private final SectionRepository sectionRepository;

    @Override
    public List<SectionDTO> getSections() {
        return sectionRepository.findAll()
                .stream()
                .map(SectionMapper::toSectionDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SectionDTO getSectionById(Long id) {
        return SectionMapper.toSectionDTO(sectionRepository.findById(id)
                .orElseThrow(() -> new SectionNotFoundException("Section not found: " + id)));
    }

    @Override
    public SectionDTO createSection() {
        return null;
    }
}
