package com.morcinek.android.codegenerator.writer.builders.resources;

import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplateManager;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class MethodsBuilder extends ResourceCodeBuilder {

    public MethodsBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        super(resourceProviders, templatesProvider);
    }

    @Override
    protected void initializeFields() {
    }

    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
    }

    @Override
    public String builtString() {
        return "";
    }

    @Override
    public String getKey() {
        return "METHODS";
    }
}
