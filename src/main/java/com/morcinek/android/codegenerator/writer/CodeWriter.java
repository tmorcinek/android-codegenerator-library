package com.morcinek.android.codegenerator.writer;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.writer.builders.BuildersCollection;
import com.morcinek.android.codegenerator.writer.builders.CodeBuilder;
import com.morcinek.android.codegenerator.writer.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplateManager;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class CodeWriter {

    private BuildersCollection buildersCollection;

    private TemplatesProvider templatesProvider;

    private ResourceProvidersFactory resourceProvidersFactory;

    public CodeWriter(ResourceProvidersFactory resourceProvidersFactory, TemplatesProvider templatesProvider) {
        this.resourceProvidersFactory = resourceProvidersFactory;
        this.templatesProvider = templatesProvider;
        this.buildersCollection = new BuildersCollection(templatesProvider);
    }

    public String produceJavaCode(List<Resource> resources, String fileName) {
        buildersCollection.registerCodeBuilders(getResourceProviders(resources), fileName);

        TemplateManager fileTemplate = new TemplateManager(templatesProvider.provideTemplateForName("File_template"));
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
