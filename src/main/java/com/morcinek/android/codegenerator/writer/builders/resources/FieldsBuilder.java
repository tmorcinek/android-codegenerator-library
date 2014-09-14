package com.morcinek.android.codegenerator.writer.builders.resources;

import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplateManager;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class FieldsBuilder extends ResourceCodeBuilder {

    private StringBuilder stringBuilder;

    public FieldsBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        super(resourceProviders, templatesProvider);
    }

    @Override
    protected void initializeFields() {
        stringBuilder = new StringBuilder();
    }

    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
        if (resourceProvider.provideField() != null) {
            for (String field : resourceProvider.provideField()) {
                TemplateManager templateManager = getTemplateManager(field);
                templateManager.addTemplateValues(resourceProvider.provideValues());
                stringBuilder.append(templateManager.getResult());
            }
        }
    }

    private TemplateManager getTemplateManager(String assignment) {
        return new TemplateManager(templatesProvider.provideTemplateForName("Field_"+ assignment +"_template"));
    }

    @Override
    public String builtString() {
        return stringBuilder.toString();
    }

    @Override
    public String getKey() {
        return "FIELDS";
    }
}
