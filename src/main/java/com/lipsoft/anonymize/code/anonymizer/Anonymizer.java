/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer;

import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import com.lipsoft.anonymize.code.anonymizer.service.AnonymizerFactory;

import java.util.Map;
import java.util.Set;

public interface Anonymizer {

    String anonymizeText(String textToAnonymize);

    static Anonymizer createAnonymizerManager(final Set<AnonymizerDTO> anonymizers) {
        return AnonymizerFactory.anonymizerManagerFactory(anonymizers);
    }

    static Anonymizer createAnonymizerManager(final Map<String, String> anonymizerData) {
        return AnonymizerFactory.anonymizerManagerFactory(anonymizerData);
    }

}
