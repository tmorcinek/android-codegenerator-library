package com.morcinek.android.codegenerator.writer.providers;

import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.providers.resources.ButtonProvider;
import com.morcinek.android.codegenerator.writer.providers.resources.CheckBoxProvider;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceProvidersFactory {

    public ResourceProvider getResourceProvider(Resource resource) {
        if (resource.getResourceType().equals(new ResourceType("Button"))) {
            return new ButtonProvider(resource);
        } else if (resource.getResourceType().equals(new ResourceType("CheckBox"))) {
            return new CheckBoxProvider(resource);
        }
        return null;
    }
}
