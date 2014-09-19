package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplateManager;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;

import java.util.List;
import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ImportsBuilder extends ResourceCodeBuilder {

    public Set<String> imports;

    public ImportsBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        super(resourceProviders, templatesProvider);
    }

    @Override
    protected void initializeFields() {
        imports = Sets.newLinkedHashSet();
    }

    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
        TemplateManager templateManager = getTemplateManager();
        templateManager.addTemplateValues(resourceProvider.provideValues());
        imports.add(templateManager.getResult());
    }

    private TemplateManager getTemplateManager() {
        return new TemplateManager(templatesProvider.provideTemplateForName("Import_template"));
    }

    @Override
    public String builtString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String objectImport : imports) {
            stringBuilder.append(objectImport);
        }
        return prepareBuildString(stringBuilder.toString());
    }

    @Override
    public String getKey() {
        return "IMPORTS";
    }
}
