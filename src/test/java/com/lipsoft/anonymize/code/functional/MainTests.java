/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.functional;

import com.lipsoft.anonymize.code.anonymizer.Anonymizer;
import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import com.lipsoft.anonymize.code.anonymizer.IAnonymizerRepositoryActions;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MainTests {

    @Autowired
    private IAnonymizerRepositoryActions anonymizerRepositoryActions;
    @Autowired
    private Anonymizer anonymizerHandler;

    @Test
    void testowy() {
        anonymizerRepositoryActions.createAnonymizationRule(AnonymizerDTO.builder().originalText("testNowy").replacementText("X2x2").build());
        anonymizerRepositoryActions.createAnonymizationRule(AnonymizerDTO.builder().originalText("testNowy2").replacementText("X2x22").build());
        List<AnonymizerDTO> anonymizationRules = anonymizerRepositoryActions.getAnonymizationRules();

        for (AnonymizerDTO anonymizerDTO : anonymizationRules) {
            System.out.println(anonymizerDTO);
        }

        String s = anonymizerHandler.anonymizeText("""
                John Doe class testNowy {
                                 
                                     @Autowired
                                     private IAnonymizerRepositoryActions anonymizerRepositoryActions;
                                     @Autowired John Doe 
                                     private Anonymizer anonymizerHandler;
                """);

        System.out.println(s);
    }
}
