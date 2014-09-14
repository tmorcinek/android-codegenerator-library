package com.morcinek.android.codegenerator.writer.providers.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.writer.providers.generic.AbstractResourceProvider;

import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ButtonProvider extends AbstractResourceProvider {

    public ButtonProvider(Resource resource) {
        super(resource);
    }

    @Override
    public Set<String> provideInterface() {
        return Sets.newHashSet("OnClickListener");
    }

    @Override
    public Set<String> provideAssignment() {
        return Sets.newHashSet("Button");
    }

    @Override
    public Set<String> provideMethod() {
        return Sets.newHashSet("OnClickListener");
    }
}
