package com.morcinek.android.codegenerator.writer.builders.resources;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;

import java.util.List;
import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class InterfaceBuilder implements ResourceCodeBuilder {

    private Set<String> interfaces = Sets.newHashSet();

    @Override
    public void processResourceProviders(List<ResourceProvider> resourceProviders) {
        for (ResourceProvider resourceProvider : resourceProviders) {
            if (resourceProvider.provideInterface() != null) {
                interfaces.addAll(resourceProvider.provideInterface());
            }
        }
    }

    @Override
    public String builtString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("implements ");
        for (String interfaceName : interfaces) {
            stringBuilder.append(interfaceName);
            stringBuilder.append(" ,");
        }
        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        return stringBuilder.toString();
    }
}
