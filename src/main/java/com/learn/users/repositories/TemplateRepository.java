package com.learn.users.repositories;

import com.learn.users.entities.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, Long> { }
