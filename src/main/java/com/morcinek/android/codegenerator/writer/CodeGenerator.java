package com.morcinek.android.codegenerator.writer;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.writer.builders.CodeBuilder;
import com.morcinek.android.codegenerator.writer.builders.InterfaceBuilder;
import com.morcinek.android.codegenerator.writer.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplateManager;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class CodeGenerator {

    private TemplatesProvider templatesProvider;

    private ResourceProvidersFactory resourceProvidersFactory;

    private List<ResourceProvider> resourceProviders;

    public CodeGenerator(ResourceProvidersFactory resourceProvidersFactory, TemplatesProvider templatesProvider) {
        this.resourceProvidersFactory = resourceProvidersFactory;
        this.templatesProvider = templatesProvider;
    }

    public String produceJavaCode(List<Resource> resources, String fileName) {
        resourceProviders = Lists.newArrayList();
        for (Resource resource : resources) {
            resourceProviders.add(resourceProvidersFactory.getResourceProvider(resource));
        }
        TemplateManager fileTemplate = new TemplateManager(templatesProvider.provideTemplateForName("File_template"));

        String interfaces;
        CodeBuilder interfaceBuilder = new InterfaceBuilder();
        for (ResourceProvider resourceProvider : resourceProviders) {
            interfaceBuilder.processResourceProvider(resourceProvider);
        }
        fileTemplate.addTemplateValue("INTERFACES",interfaceBuilder.toString());
        fileTemplate.addTemplateValue("CLASS_NAME", StringUtils.capitalize(fileName) + "Activity");
        fileTemplate.addTemplateValue("LAYOUT", "R.layout." +fileName);

        return fileTemplate.getTemplate();
    }
}
