package com.learn.users.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditProvider")
public class AuditConfig {
    @Bean
    AuditorAware<String> auditProvider() {
        return () -> Optional.ofNullable("machine");
    }
}
