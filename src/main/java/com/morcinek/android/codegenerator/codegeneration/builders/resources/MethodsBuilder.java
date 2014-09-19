package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.google.common.collect.Maps;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplateManager;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import org.apache.commons.lang3.StringUtils;

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
        stringBuilders = Maps.newLinkedHashMap();
    }

    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
        if (resourceProvider.provideMethod() != null) {
            for (String method : resourceProvider.provideMethod()) {
                StringBuilder stringBuilder = getStringBuilder(method);
                TemplateManager templateManager = getTemplateManagerForMethodCase(method);
                templateManager.addTemplateValues(resourceProvider.provideValues());
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
            String methodCases = StringUtils.stripEnd(stringBuilders.get(method).toString(), null);
            templateManager.addTemplateValue("CASES", methodCases);
            stringBuilder.append(templateManager.getResult());
            stringBuilder.append("\n");
        }
        return prepareBuildString(stringBuilder.toString());
    }

    @Override
    public String getKey() {
        return "METHODS";
    }
}
