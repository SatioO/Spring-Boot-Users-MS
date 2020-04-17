package com.learn.users.services;


import com.learn.users.dto.models.SectionDTO;

import java.util.List;

public interface ISectionService {
    List<SectionDTO> getSections();
    SectionDTO getSectionById(Long id);
    SectionDTO createSection(SectionDTO section);
}
