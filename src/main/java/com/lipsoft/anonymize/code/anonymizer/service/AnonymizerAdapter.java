/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.service;

import com.lipsoft.anonymize.code.anonymizer.Anonymizer;
import com.lipsoft.anonymize.code.anonymizer.IAnonymizerRepositoryActions;
import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import lombok.AllArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
class AnonymizerAdapter implements Anonymizer {

    private IAnonymizerRepositoryActions anonymizerFacade;

    @Override
    public String anonymizeText(String textToAnonymize) {
        Set<AnonymizerDTO> anonymizerDTOS = new HashSet<>(anonymizerFacade.getAnonymizationRules());

        Anonymizer anonymizerManager = Anonymizer.createAnonymizerManager(anonymizerDTOS);

        return anonymizerManager.anonymizeText(textToAnonymize);
    }


}
