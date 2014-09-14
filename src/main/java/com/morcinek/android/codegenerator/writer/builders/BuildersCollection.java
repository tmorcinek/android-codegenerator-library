package com.morcinek.android.codegenerator.writer.builders;

import com.google.common.collect.Maps;
import com.morcinek.android.codegenerator.writer.builders.file.ClassNameBuilder;
import com.morcinek.android.codegenerator.writer.builders.file.LayoutBuilder;
import com.morcinek.android.codegenerator.writer.builders.resources.AssignmentsBuilder;
import com.morcinek.android.codegenerator.writer.builders.resources.FieldsBuilder;
import com.morcinek.android.codegenerator.writer.builders.resources.InterfaceBuilder;
import com.morcinek.android.codegenerator.writer.builders.resources.MethodsBuilder;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;

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
        registerCodeBuilder(builderMap, new LayoutBuilder(fileName));
        registerCodeBuilder(builderMap, new InterfaceBuilder(resourceProviders, templatesProvider));
        registerCodeBuilder(builderMap, new FieldsBuilder(resourceProviders, templatesProvider));
        registerCodeBuilder(builderMap, new AssignmentsBuilder(resourceProviders, templatesProvider));
        registerCodeBuilder(builderMap, new MethodsBuilder(resourceProviders, templatesProvider));
    }

    private void registerCodeBuilder(Map<String, CodeBuilder> codeBuilderMap, CodeBuilder codeBuilder) {
        codeBuilderMap.put(codeBuilder.getKey(), codeBuilder);
    }

}
