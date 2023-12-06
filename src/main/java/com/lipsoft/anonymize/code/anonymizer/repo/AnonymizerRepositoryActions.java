/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo;

import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import com.lipsoft.anonymize.code.anonymizer.IAnonymizerRepositoryActions;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
class AnonymizerRepositoryActions implements IAnonymizerRepositoryActions {
    private AnonymizerFinder anonymizerFinder;
    private AnonymizerCreator anonymizerCreator;

    public void createAnonymizationRule(AnonymizerDTO anonymizerDTO)
    {
        anonymizerCreator.createAnonymizationRule(anonymizerDTO);
    }

    public List<AnonymizerDTO> getAnonymizationRules()
    {
        return anonymizerFinder.getAllAnonymizationRule();
    }

}
