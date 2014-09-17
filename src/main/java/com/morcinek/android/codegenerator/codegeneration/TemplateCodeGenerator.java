package com.morcinek.android.codegenerator.codegeneration;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.builders.BuildersCollection;
import com.morcinek.android.codegenerator.codegeneration.builders.CodeBuilder;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
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

    private ResourceProvidersFactory resourceProvidersFactory;

    private TemplateManager templateManager;

    public TemplateCodeGenerator(String templateName, ResourceProvidersFactory resourceProvidersFactory, TemplatesProvider templatesProvider) {
        this.resourceProvidersFactory = resourceProvidersFactory;
        this.buildersCollection = new BuildersCollection(templatesProvider);
        this.templateManager = new TemplateManager(templatesProvider.provideTemplateForName(templateName));
    }

    public String generateCode(List<Resource> resources, String fileName) {
        buildersCollection.registerCodeBuilders(getResourceProviders(resources), fileName);

        Map<String, CodeBuilder> builderMap = buildersCollection.getBuilderMap();
        for (String key : builderMap.keySet()) {
            templateManager.addTemplateValue(key, builderMap.get(key).builtString());
        }

        return templateManager.getResult();
    }

    private List<ResourceProvider> getResourceProviders(List<Resource> resources) {
        List<ResourceProvider> resourceProviders = Lists.newArrayList();
        for (Resource resource : resources) {
            resourceProviders.add(resourceProvidersFactory.createResourceProvider(resource));
        }
        return resourceProviders;
    }
}
