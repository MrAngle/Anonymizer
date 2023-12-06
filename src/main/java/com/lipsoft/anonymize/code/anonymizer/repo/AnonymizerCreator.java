/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo;

import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class AnonymizerCreator {
    private IAnonymizerRuleRepositoryWrapper anonymizationRuleRepository;

    public void createAnonymizationRule(AnonymizerDTO anonymizerDTO) {
        anonymizationRuleRepository.createAnonymizationRule(anonymizerDTO);
    }

}
