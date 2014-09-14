package com.morcinek.android.codegenerator.writer.builders.resources;

import com.morcinek.android.codegenerator.writer.builders.CodeBuilder;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;

import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public abstract class ResourceCodeBuilder implements CodeBuilder {

    protected final TemplatesProvider templatesProvider;

    protected ResourceCodeBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        this.templatesProvider = templatesProvider;
        initializeFields();
        for (ResourceProvider resourceProvider : resourceProviders) {
            processResourceProvider(resourceProvider);
        }
    }

    protected void initializeFields() {
    }

    protected abstract void processResourceProvider(ResourceProvider resourceProvider);
}
