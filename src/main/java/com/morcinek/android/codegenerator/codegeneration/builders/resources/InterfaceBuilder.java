package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;

import java.util.List;
import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class InterfaceBuilder extends ResourceCodeBuilder {

    private Set<String> interfaces;

    public InterfaceBuilder(List<ResourceProvider> resourceProviders, TemplatesProvider templatesProvider) {
        super(resourceProviders, templatesProvider);
    }

    @Override
    protected void initializeFields() {
        interfaces = Sets.newTreeSet();
    }

    @Override
    protected void processResourceProvider(ResourceProvider resourceProvider) {
        if (resourceProvider.provideInterface() != null) {
            interfaces.addAll(resourceProvider.provideInterface());
        }
    }

    @Override
    public String builtString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object[] objects = interfaces.toArray();
        for (int i = 0; i < objects.length; i++) {
            if (i == 0) {
                stringBuilder.append("implements ");
            }
            stringBuilder.append(objects[i]);
            if (i < objects.length - 1) {
                stringBuilder.append(", ");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String getKey() {
        return "INTERFACES";
    }
}
