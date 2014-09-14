package com.morcinek.android.codegenerator.writer.builders.resources;

import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplateManager;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class AssignmentsBuilder extends ResourceCodeBuilder {

    private StringBuilder stringBuilder;

    private String template;

    public AssignmentsBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        super(resourceProviders, templatesProvider);
    }

    @Override
    protected void initializeFields() {
        stringBuilder = new StringBuilder();
        template = templatesProvider.provideTemplateForName("Assignment_template");
    }

    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
        TemplateManager templateManager = new TemplateManager(template);
        if (resourceProvider.provideAssignment() != null) {
            Map<String, String> stringStringMap = resourceProvider.provideAssignment();
            for (String key : stringStringMap.keySet()) {
                templateManager.addTemplateValue(key, stringStringMap.get(key));
            }
        }
        stringBuilder.append(templateManager.getResult());
    }

    @Override
    public String builtString() {
        return stringBuilder.toString();
    }

    @Override
    public String getKey() {
        return "ASSIGNMENTS";
    }
}
