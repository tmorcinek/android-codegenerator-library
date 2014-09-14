package com.morcinek.android.codegenerator.writer.providers.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.writer.providers.generic.AbstractResourceProvider;

import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class CheckBoxProvider extends AbstractResourceProvider {

    public CheckBoxProvider(Resource resource) {
        super(resource);
    }

    @Override
    public Set<String> provideInterface() {
        return null;
    }

    @Override
    public Set<String> provideAssignment() {
        return null;
    }

    @Override
    public Set<String> provideField() {
        return null;
    }

    @Override
    public Set<String> provideMethod() {
        return Sets.newHashSet("Getter");
    }
}
