/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo.jpa;

import com.lipsoft.anonymize.code.anonymizer.repo.IAnonymizerRuleRepositoryWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SpringAnonymizerRuleRepositoryConfig {

    @Bean
    IAnonymizerRuleRepositoryWrapper anonymizationRuleRepository(ISpringAnonymizerRuleRepository anonymizationRuleRepository) {
        return new SpringAnonymizerRuleRepository(anonymizationRuleRepository);
    }

}
