package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.morcinek.android.codegenerator.codegeneration.builders.CodeBuilder;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;

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

    protected String prepareBuildString(String string) {
        if (string.isEmpty()) {
            return string;
        } else {
            return string.trim();
        }
    }

    protected void initializeFields() {
    }

    protected abstract void processResourceProvider(ResourceProvider resourceProvider);
}
