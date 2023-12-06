/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.service;

import com.lipsoft.anonymize.code.anonymizer.Anonymizer;
import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class AnonymizerFactory {

    public static Anonymizer anonymizerManagerFactory(final Set<AnonymizerDTO> anonymizers) {
        final Map<String, String> anonymizerData = anonymizers.stream()
                .collect(Collectors.toMap(
                        AnonymizerDTO::getOriginalText,
                        AnonymizerDTO::getReplacementText
                ));

        return new AnonymizerManager(anonymizerData);
    }

    public static Anonymizer anonymizerManagerFactory(final Map<String, String> anonymizerData) {
        return new AnonymizerManager(anonymizerData);
    }

}
