package com.morcinek.android.codegenerator.writer;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.writer.builders.ClassNameBuilder;
import com.morcinek.android.codegenerator.writer.builders.CodeBuilder;
import com.morcinek.android.codegenerator.writer.builders.LayoutBuilder;
import com.morcinek.android.codegenerator.writer.builders.resources.AssignmentsBuilder;
import com.morcinek.android.codegenerator.writer.builders.resources.FieldsBuilder;
import com.morcinek.android.codegenerator.writer.builders.resources.InterfaceBuilder;
import com.morcinek.android.codegenerator.writer.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplateManager;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class CodeWriter {

    private TemplatesProvider templatesProvider;

    private ResourceProvidersFactory resourceProvidersFactory;

    public CodeWriter(ResourceProvidersFactory resourceProvidersFactory, TemplatesProvider templatesProvider) {
        this.resourceProvidersFactory = resourceProvidersFactory;
        this.templatesProvider = templatesProvider;
    }

    public String produceJavaCode(List<Resource> resources, String fileName) {
        List<ResourceProvider> resourceProviders = getResourceProviders(resources);
        Map<String, CodeBuilder> buildersMap = registerCodeBuilders(resourceProviders, fileName);
        TemplateManager fileTemplate = new TemplateManager(templatesProvider.provideTemplateForName("File_template"));

        for (String key : buildersMap.keySet()) {
            fileTemplate.addTemplateValue(key, buildersMap.get(key).builtString());
        }

        return fileTemplate.getResult();
    }

    private List<ResourceProvider> getResourceProviders(List<Resource> resources) {
        List<ResourceProvider> resourceProviders = Lists.newArrayList();
        for (Resource resource : resources) {
            resourceProviders.add(resourceProvidersFactory.getResourceProvider(resource));
        }
        return resourceProviders;
    }

    private Map<String, CodeBuilder> registerCodeBuilders(List<ResourceProvider> resourceProviders, String fileName) {
        Map<String, CodeBuilder> codeBuilderMap = Maps.newHashMap();
        registerCodeBuilder(codeBuilderMap, new ClassNameBuilder(fileName));
        registerCodeBuilder(codeBuilderMap, new LayoutBuilder(fileName));
        registerCodeBuilder(codeBuilderMap, new InterfaceBuilder(resourceProviders, templatesProvider));
        registerCodeBuilder(codeBuilderMap, new FieldsBuilder(resourceProviders, templatesProvider));
        registerCodeBuilder(codeBuilderMap, new AssignmentsBuilder(resourceProviders, templatesProvider));
        return codeBuilderMap;
    }

    private void registerCodeBuilder(Map<String, CodeBuilder> codeBuilderMap, CodeBuilder codeBuilder) {
        codeBuilderMap.put(codeBuilder.getKey(), codeBuilder);
    }
}
