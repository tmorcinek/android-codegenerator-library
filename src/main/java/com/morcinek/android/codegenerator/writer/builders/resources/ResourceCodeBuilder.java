package com.morcinek.android.codegenerator.writer.builders.resources;

import com.morcinek.android.codegenerator.writer.builders.CodeBuilder;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;

import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public abstract class ResourceCodeBuilder implements CodeBuilder {

    protected ResourceCodeBuilder(List<ResourceProvider> resourceProviders) {
        initializeFields();
        for (ResourceProvider resourceProvider : resourceProviders) {
            processResourceProvider(resourceProvider);
        }
    }

    protected void initializeFields() {
    }

    protected abstract void processResourceProvider(ResourceProvider resourceProvider);
}
