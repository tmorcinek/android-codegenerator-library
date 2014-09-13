package com.morcinek.android.codegenerator.writer.builders;

import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;

import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class InterfaceBuilder implements CodeBuilder {

    private Set<String> interfaces = Sets.newHashSet();

    @Override
    public void processResourceProvider(ResourceProvider resourceProvider) {
        if (resourceProvider.provideInterface() != null) {
            interfaces.addAll(resourceProvider.provideInterface());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("implements ");
        for (String interfaceName : interfaces) {
            stringBuilder.append(interfaceName);
            stringBuilder.append(" ,");
        }
        stringBuilder.delete(stringBuilder.length() - 3, stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
