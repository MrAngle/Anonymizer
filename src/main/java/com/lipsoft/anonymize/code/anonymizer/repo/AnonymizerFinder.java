/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo;

import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class AnonymizerFinder {
    private IAnonymizerRuleRepositoryWrapper anonymizationRuleRepository;

    public List<AnonymizerDTO> getAllAnonymizationRule() {
        return anonymizationRuleRepository.getAnonymizationRules();
    }

}
