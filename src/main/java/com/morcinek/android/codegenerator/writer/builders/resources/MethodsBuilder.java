package com.morcinek.android.codegenerator.writer.builders.resources;

import com.google.common.collect.Maps;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplateManager;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class MethodsBuilder extends ResourceCodeBuilder {

    private Map<String, StringBuilder> stringBuilders;

    public MethodsBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        super(resourceProviders, templatesProvider);
    }

    @Override
    protected void initializeFields() {
        stringBuilders = Maps.newTreeMap();
    }

    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
        if (resourceProvider.provideMethod() != null) {
            for (String method : resourceProvider.provideMethod()) {
                StringBuilder stringBuilder = getStringBuilder(method);
                TemplateManager templateManager = getTemplateManagerForMethodCase(method);
                templateManager.addTemplateValues(resourceProvider.provideMethodParams());
                stringBuilder.append(templateManager.getResult());
            }
        }

    }

    private StringBuilder getStringBuilder(String method) {
        StringBuilder stringBuilder = stringBuilders.get(method);
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
            stringBuilders.put(method, stringBuilder);
        }
        return stringBuilder;
    }

    private TemplateManager getTemplateManagerForMethodCase(String method) {
        return new TemplateManager(templatesProvider.provideTemplateForName(method + "_Case_template"));
    }

    private TemplateManager getTemplateManagerForMethod(String method) {
        return new TemplateManager(templatesProvider.provideTemplateForName(method + "_template"));
    }

    @Override
    public String builtString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String method : stringBuilders.keySet()) {
            TemplateManager templateManager = getTemplateManagerForMethod(method);
            templateManager.addTemplateValue("CASES", stringBuilders.get(method).toString());
            stringBuilder.append(templateManager.getResult());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String getKey() {
        return "METHODS";
    }
}
