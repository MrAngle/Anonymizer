/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.service;

import com.lipsoft.anonymize.code.anonymizer.Anonymizer;
import com.lipsoft.anonymize.code.anonymizer.DTO.AnonymizerDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

class AnonymizationServiceTest {

    private static Stream<Arguments> provideTextsForAnonymization() {
        return Stream.of(
                Arguments.of(
                        "public class User { private String username; private String password; }",
                        new AnonymizerDTO[]{
                                new AnonymizerDTO("User", "AnonymizedClass"),
                                new AnonymizerDTO("username", "userAlias"),
                                new AnonymizerDTO("password", "passAlias")
                        },
                        "public class AnonymizedClass { private String userAlias; private String passAlias; }"
                ),
                Arguments.of(
                        "// This method calculates the sum of two integers",
                        new AnonymizerDTO[]{
                                new AnonymizerDTO("sum", "addition"),
                                new AnonymizerDTO("integers", "numbers")
                        },
                        "// This method calculates the addition of two numbers"
                ),
                Arguments.of(
                        "int result = operandOne + operandTwo;",
                        new AnonymizerDTO[]{
                                new AnonymizerDTO("result", "output"),
                                new AnonymizerDTO("operandOne", "firstOperand"),
                                new AnonymizerDTO("operandTwo", "secondOperand")
                        },
                        "int output = firstOperand + secondOperand;"
                ),
                Arguments.of(
                        "John Cleese is one of the Monty Python members and starred in the Holy Grail.",
                        new AnonymizerDTO[]{new AnonymizerDTO("John Cleese", "JC"), new AnonymizerDTO("Holy Grail", "HG")},
                        "JC is one of the Monty Python members and starred in the HG."
                ),
                Arguments.of(
                        "The Ministry of Silly Walks is another famous sketch.",
                        new AnonymizerDTO[]{new AnonymizerDTO("Silly Walks", "SW"), new AnonymizerDTO("Ministry", "M")},
                        "The M of SW is another famous sketch."
                ),
                Arguments.of(
                        "Spam & Eggs can be found in one of the sketches.",
                        new AnonymizerDTO[]{new AnonymizerDTO("Spam", "***"), new AnonymizerDTO("Eggs", "+++")},
                        "*** & +++ can be found in one of the sketches."
                ),
                Arguments.of(
                        "Function calculateSum calculates the sum of two numbers.",
                        new AnonymizerDTO[]{
                                new AnonymizerDTO("calculateSum", "computeTotal"),
                                new AnonymizerDTO("sum", "total"),
                                new AnonymizerDTO("calculates", "computes")
                        },
                        "Function computeTotal computes the total of two numbers."
                ),
                Arguments.of(
                        "The identifier userIdentification should be anonymized.",
                        new AnonymizerDTO[]{
                                new AnonymizerDTO("userIdentification", "userAnon"),
                                new AnonymizerDTO("user", "usr"),
                                new AnonymizerDTO("id", "ID")
                        },
                        "The IDentifier usrAnon should be anonymized."
                ),
                Arguments.of(
                        "The identifier userIdentification should be anonymized.",
                        new AnonymizerDTO[]{
                                new AnonymizerDTO("userIdentification", "userAnon"),
                                new AnonymizerDTO(" user ", " usr "),
                                new AnonymizerDTO(" id ", " ID ")
                        },
                        "The identifier userAnon should be anonymized."
                ),
                Arguments.of(
                        "Replace the substring in the string with a new substring.",
                        new AnonymizerDTO[]{
                                new AnonymizerDTO("substring", "portion"),
                                new AnonymizerDTO("string", "str"),
                                new AnonymizerDTO("new substring", "newPortion")
                        },
                        "Replace the portion in the str with a newPortion."
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTextsForAnonymization")
    void anonymizeText(String text, AnonymizerDTO[] anonymizerDTOs, String expected) {
        Set<AnonymizerDTO> dtoSet = new HashSet<>(Arrays.asList(anonymizerDTOs));
        Anonymizer anonymizerManager = Anonymizer.createAnonymizerManager(dtoSet);

        String anonymizedText = anonymizerManager.anonymizeText(text);

        Assertions.assertEquals(expected, anonymizedText);
    }

    private static Stream<Arguments> provideDataForNullArguments() {
        Map<String, String> anonymizerData = new HashMap<>();
        anonymizerData.put("John Cleese", "JC");

        return Stream.of(
                Arguments.of(null, anonymizerData),
                Arguments.of("Some text", null),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("provideDataForNullArguments")
    void anonymizeTextShouldThrowExceptionWhenArgumentsAreNull(String textToAnonymize, Map<String, String> anonymizerData) {
        Anonymizer anonymizerManager = Anonymizer.createAnonymizerManager(anonymizerData);
        Assertions.assertThrows(IllegalArgumentException.class, () -> anonymizerManager.anonymizeText(textToAnonymize));
    }



    @Test
    void quickFunctionalTest() {
        Set<AnonymizerDTO> anonymizerData = Set.of(new AnonymizerDTO("John Doe", "XXXX"));
        Anonymizer anonymizerManager = Anonymizer.createAnonymizerManager(anonymizerData);

        String s = anonymizerManager.anonymizeText("""
                John Doe class MainTests {
                                 
                                     @Autowired
                                     private IAnonymizerRepositoryActions anonymizerRepositoryActions;
                                     @Autowired John Doe 
                                     private Anonymizer anonymizerHandler;
                """);

        System.out.println(s);
    }

}