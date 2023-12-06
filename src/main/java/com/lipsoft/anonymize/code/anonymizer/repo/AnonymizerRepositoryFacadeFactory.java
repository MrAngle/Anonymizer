/*
 * Copyright (c) 2023.
 */

package com.lipsoft.anonymize.code.anonymizer.repo;

import com.lipsoft.anonymize.code.anonymizer.IAnonymizerRepositoryActions;

public class AnonymizerRepositoryFacadeFactory {
    public static IAnonymizerRepositoryActions anonymizerFacadeFacade(IAnonymizerRuleRepositoryWrapper repository)
    {
        final AnonymizerFinder finder = new AnonymizerFinder(repository);
        final AnonymizerCreator creator = new AnonymizerCreator(repository);

        return new AnonymizerRepositoryActions(finder, creator);
    }

}
