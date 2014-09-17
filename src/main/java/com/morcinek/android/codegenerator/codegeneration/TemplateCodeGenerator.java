package com.morcinek.android.codegenerator.codegeneration;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.builders.BuildersCollection;
import com.morcinek.android.codegenerator.codegeneration.builders.CodeBuilder;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplateManager;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class TemplateCodeGenerator {

    private BuildersCollection buildersCollection;

    private String templateName;

    private ResourceProvidersFactory resourceProvidersFactory;

    private TemplatesProvider templatesProvider;

    public TemplateCodeGenerator(String templateName, ResourceProvidersFactory resourceProvidersFactory, TemplatesProvider templatesProvider) {
        this.templateName = templateName;
        this.resourceProvidersFactory = resourceProvidersFactory;
        this.templatesProvider = templatesProvider;
        this.buildersCollection = new BuildersCollection(templatesProvider);
    }

    public String generateCode(List<Resource> resources, String fileName) {
        buildersCollection.registerCodeBuilders(getResourceProviders(resources), fileName);

        TemplateManager fileTemplate = new TemplateManager(templatesProvider.provideTemplateForName(templateName));
        Map<String, CodeBuilder> builderMap = buildersCollection.getBuilderMap();
        for (String key : builderMap.keySet()) {
            fileTemplate.addTemplateValue(key, builderMap.get(key).builtString());
        }

        return fileTemplate.getResult();
    }

    private List<ResourceProvider> getResourceProviders(List<Resource> resources) {
        List<ResourceProvider> resourceProviders = Lists.newArrayList();
        for (Resource resource : resources) {
            resourceProviders.add(resourceProvidersFactory.createResourceProvider(resource));
        }
        return resourceProviders;
    }
}
