package com.morcinek.android.codegenerator.codegeneration.builders;

import com.google.common.collect.Maps;
import com.morcinek.android.codegenerator.codegeneration.builders.file.ClassNameBuilder;
import com.morcinek.android.codegenerator.codegeneration.builders.file.ResourceNameBuilder;
import com.morcinek.android.codegenerator.codegeneration.builders.resources.AssignmentsBuilder;
import com.morcinek.android.codegenerator.codegeneration.builders.resources.FieldsBuilder;
import com.morcinek.android.codegenerator.codegeneration.builders.resources.InterfaceBuilder;
import com.morcinek.android.codegenerator.codegeneration.builders.resources.MethodsBuilder;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;

import java.util.List;
import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class BuildersCollection {

    private TemplatesProvider templatesProvider;

    private Map<String, CodeBuilder> builderMap = Maps.newHashMap();

    public BuildersCollection(TemplatesProvider templatesProvider) {
        this.templatesProvider = templatesProvider;
    }

    public Map<String, CodeBuilder> getBuilderMap() {
        return builderMap;
    }

    public void registerCodeBuilders(List<ResourceProvider> resourceProviders, String fileName) {
        registerCodeBuilder(builderMap, new ClassNameBuilder(fileName));
        registerCodeBuilder(builderMap, new ResourceNameBuilder(fileName));
        registerCodeBuilder(builderMap, new InterfaceBuilder(resourceProviders, templatesProvider));
        registerCodeBuilder(builderMap, new FieldsBuilder(resourceProviders, templatesProvider));
        registerCodeBuilder(builderMap, new AssignmentsBuilder(resourceProviders, templatesProvider));
        registerCodeBuilder(builderMap, new MethodsBuilder(resourceProviders, templatesProvider));
    }

    private void registerCodeBuilder(Map<String, CodeBuilder> codeBuilderMap, CodeBuilder codeBuilder) {
        codeBuilderMap.put(codeBuilder.getKey(), codeBuilder);
    }

}
