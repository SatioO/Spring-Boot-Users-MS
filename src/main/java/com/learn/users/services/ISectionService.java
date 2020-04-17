package com.learn.users.services;


import com.learn.users.dto.models.SectionDTO;
import com.learn.users.exceptions.SectionNotFoundException;

import java.util.List;

public interface ISectionService {
    List<SectionDTO> getSections();
    SectionDTO getSectionById(Long id) throws SectionNotFoundException;
    SectionDTO createSection(SectionDTO section);
}
