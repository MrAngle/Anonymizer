/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "anonymization_rule")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
class AnonymizationRuleEntity {

    @Id
    @SequenceGenerator(
            name = "anonymization_rule_id_sequence",
            sequenceName = "anonymization_rule_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "anonymization_rule_id_sequence"
    )
    private Long id;

    @Column(name = "original_text", nullable = false)
    private String originalText;

    @Column(name = "replacement_text", nullable = false)
    private String replacementText;



}
