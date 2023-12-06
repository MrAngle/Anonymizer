/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class AnonymizerDTO {
    private String originalText;
    private String replacementText;
}
