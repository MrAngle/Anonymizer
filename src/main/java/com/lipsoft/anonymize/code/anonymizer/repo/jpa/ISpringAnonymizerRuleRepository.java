/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ISpringAnonymizerRuleRepository extends JpaRepository<AnonymizationRuleEntity, Long> {
}
