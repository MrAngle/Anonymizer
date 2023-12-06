/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo;

import com.lipsoft.anonymize.code.anonymizer.IAnonymizerRepositoryActions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AnonymizerRepoConfig {

    @Bean
    IAnonymizerRepositoryActions repositoryJPAFacade(IAnonymizerRuleRepositoryWrapper anonymizationRuleRepository) {
        return AnonymizerRepositoryFacadeFactory.anonymizerFacadeFacade(anonymizationRuleRepository);
    }
}
