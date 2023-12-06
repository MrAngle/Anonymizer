/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.service;

import com.lipsoft.anonymize.code.anonymizer.Anonymizer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
class AnonymizerManager implements Anonymizer {

    final private Map<String, String> anonymizerData;

    @Override
    public String anonymizeText(final String textToAnonymize) {
        if (textToAnonymize == null || anonymizerData == null) {
            throw new IllegalArgumentException("Input text or anonymizer data cannot be null.");
        }

        final List<String> sortedKeys = anonymizerData.keySet().stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();

        String anonymizedText = textToAnonymize;

        for (String key : sortedKeys) {
            anonymizedText = anonymizedText.replace(key, anonymizerData.get(key));
        }

        return anonymizedText;
    }
}
