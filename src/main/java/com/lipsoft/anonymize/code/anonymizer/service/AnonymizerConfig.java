/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.service;

import com.lipsoft.anonymize.code.anonymizer.IAnonymizerRepositoryActions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AnonymizerConfig {
    @Bean
    AnonymizerAdapter anonymizerAdapter(IAnonymizerRepositoryActions anonymizerRepositoryActions) {
        return new AnonymizerAdapter(anonymizerRepositoryActions);
    }
}
