package com.morcinek.android.codegenerator.writer.builders.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;

import java.util.List;
import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class InterfaceBuilder extends ResourceCodeBuilder {

    private Set<String> interfaces;

    public InterfaceBuilder(List<ResourceProvider> resourceProviders) {
        super(resourceProviders);
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
        stringBuilder.append("implements ");
        for (String interfaceName : interfaces) {
            stringBuilder.append(interfaceName);
            stringBuilder.append(", ");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }

    @Override
    public String getKey() {
        return "INTERFACES";
    }
}
