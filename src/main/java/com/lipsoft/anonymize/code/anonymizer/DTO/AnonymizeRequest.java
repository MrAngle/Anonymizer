/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AnonymizeRequest {
    String textToAnonymize;
}
