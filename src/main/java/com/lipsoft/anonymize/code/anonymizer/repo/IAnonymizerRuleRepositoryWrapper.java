/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo;

import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;

import java.util.List;

public interface IAnonymizerRuleRepositoryWrapper {
    void createAnonymizationRule(AnonymizerDTO anonymizerDTO);

    List<AnonymizerDTO> getAnonymizationRules();
}
