package com.morcinek.android.codegenerator.writer;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.writer.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;

import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class CodeGeneration {

    private ResourceProvidersFactory resourceProvidersFactory;

    private List<ResourceProvider> resourceProviders;

    public String produceJavaCode(List<Resource> resources, String fileName) {
        resourceProviders = Lists.newArrayList();
        for (Resource resource : resources) {
            resourceProviders.add(resourceProvidersFactory.getResourceProvider(resource));
        }

        return null;
    }
}
