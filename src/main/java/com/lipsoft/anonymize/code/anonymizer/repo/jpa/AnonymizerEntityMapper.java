/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo.jpa;

import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;

class AnonymizerEntityMapper {
    static AnonymizationRuleEntity toAnonymizationRuleEntity(final AnonymizerDTO anonymizerDTO) {
        return AnonymizationRuleEntity.builder()
                .originalText(anonymizerDTO.getOriginalText())
                .replacementText(anonymizerDTO.getReplacementText())
                .build();
    }

    static AnonymizerDTO toAnonymizerDTO(final AnonymizationRuleEntity anonymizationRuleEntity) {
        return AnonymizerDTO.builder()
                .originalText(anonymizationRuleEntity.getOriginalText())
                .replacementText(anonymizationRuleEntity.getReplacementText())
                .build();
    }
}
