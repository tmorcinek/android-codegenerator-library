package com.morcinek.android.codegenerator.codegeneration.providers;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.codegeneration.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.ButtonProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.DefaultProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.GetterProvider;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceProvidersFactory {

    public ResourceProvider createResourceProvider(Resource resource) {
        if (isApplicable(resource, "Button", "ImageButton")) {
            return new ButtonProvider(resource);
        } else if (isApplicable(resource, "CheckBox", "EditText", "View")) {
            return new GetterProvider(resource);
        }
        return new DefaultProvider(resource);
    }

    private boolean isApplicable(Resource resource, String... resourcesNames) {
        return Lists.newArrayList(resourcesNames).contains(resource.getResourceType().getFullName());
    }
}
