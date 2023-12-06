/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo.jpa;

import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import com.lipsoft.anonymize.code.anonymizer.repo.IAnonymizerRuleRepositoryWrapper;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidParameterException;
import java.util.List;

@AllArgsConstructor
class SpringAnonymizerRuleRepository implements IAnonymizerRuleRepositoryWrapper
{
    private ISpringAnonymizerRuleRepository anonymizationRuleRepository;

    @Override
    @Transactional
    public void createAnonymizationRule(AnonymizerDTO anonymizerDTO) {
        if (anonymizerDTO != null) {
            anonymizationRuleRepository.save(AnonymizerEntityMapper.toAnonymizationRuleEntity(anonymizerDTO));
        } else {
            throw new InvalidParameterException("AnonymizerDTO should not be null");
        }
    }

    @Override
    public List<AnonymizerDTO> getAnonymizationRules() {
        return anonymizationRuleRepository.findAll().stream()
                .map(AnonymizerEntityMapper::toAnonymizerDTO)
                .toList();
    }

}

