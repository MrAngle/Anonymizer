package com.lipsoft.anonymize.code.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
class JpaAuditConfig {
    @Bean
    public AuditingEntityListener createAuditingListener() {
        return new AuditingEntityListener();
    }
}
