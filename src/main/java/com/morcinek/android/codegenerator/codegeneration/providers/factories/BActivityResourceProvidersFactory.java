package com.morcinek.android.codegenerator.codegeneration.providers.factories;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.*;
import com.morcinek.android.codegenerator.extractor.model.Resource;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class BActivityResourceProvidersFactory implements ResourceProvidersFactory {

    @Override
    public ResourceProvider createResourceProvider(Resource resource) {
        if (isApplicable(resource, "Button", "ImageButton")) {
            return new BButtonProvider(resource);
        } else if (isApplicable(resource, "List")) {
            return new BListProvider(resource);
        }
        return new BDefaultProvider(resource);
    }

    private boolean isApplicable(Resource resource, String... resourcesNames) {
        return Lists.newArrayList(resourcesNames).contains(resource.getResourceType().getFullName());
    }
}
