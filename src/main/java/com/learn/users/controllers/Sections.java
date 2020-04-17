package com.learn.users.controllers;

import com.learn.users.services.ISectionService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sections")
@AllArgsConstructor
public class Sections {
    private final ISectionService sectionService;

    @GetMapping
    public void getSections() {

    }
}
