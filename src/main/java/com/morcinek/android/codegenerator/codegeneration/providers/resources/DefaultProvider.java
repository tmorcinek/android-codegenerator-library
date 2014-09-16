package com.morcinek.android.codegenerator.codegeneration.providers.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.codegeneration.providers.generic.AbstractResourceProvider;

import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class DefaultProvider extends AbstractResourceProvider {

    public DefaultProvider(Resource resource) {
        super(resource);
    }

    @Override
    public Set<String> provideInterface() {
        return null;
    }

    @Override
    public Set<String> provideAssignment() {
        return Sets.newHashSet("");
    }

    @Override
    public Set<String> provideField() {
        return Sets.newHashSet("");
    }

    @Override
    public Set<String> provideMethod() {
        return null;
    }
}
