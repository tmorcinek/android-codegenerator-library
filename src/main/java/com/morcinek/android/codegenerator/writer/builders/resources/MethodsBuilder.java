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
        if (resourceProvider.provideInterface() != null) {
            for (String interfaceName : resourceProvider.provideInterface()) {
                StringBuilder stringBuilder = getStringBuilder(interfaceName);
                TemplateManager templateManager = getTemplateManagerForInterfaceCase(interfaceName);
                templateManager.addTemplateValues(resourceProvider.provideMethodParams());
                stringBuilder.append(templateManager.getResult());
            }
        }

    }

    private StringBuilder getStringBuilder(String interfaceName) {
        StringBuilder stringBuilder = stringBuilders.get(interfaceName);
        if (stringBuilder == null) {
            stringBuilder = new StringBuilder();
            stringBuilders.put(interfaceName, stringBuilder);
        }
        return stringBuilder;
    }

    private TemplateManager getTemplateManagerForInterfaceCase(String interfaceName) {
        return new TemplateManager(templatesProvider.provideTemplateForName(interfaceName + "_Case_template"));
    }

    private TemplateManager getTemplateManagerForInterface(String interfaceName) {
        return new TemplateManager(templatesProvider.provideTemplateForName(interfaceName + "_template"));
    }

    @Override
    public String builtString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String interfaceName : stringBuilders.keySet()) {
            TemplateManager templateManager = getTemplateManagerForInterface(interfaceName);
            templateManager.addTemplateValue("CASES", stringBuilders.get(interfaceName).toString());
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
