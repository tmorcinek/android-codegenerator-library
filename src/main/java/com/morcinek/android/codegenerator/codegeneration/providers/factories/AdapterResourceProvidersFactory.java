package com.morcinek.android.codegenerator.codegeneration.providers.factories;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.DefaultProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class AdapterResourceProvidersFactory implements ResourceProvidersFactory {

    @Override
    public ResourceProvider createResourceProvider(Resource resource) {
        DefaultProvider defaultProvider = new DefaultProvider(resource);
        defaultProvider.putExtra("RESOURCE_PREFIX", "    viewHolder.");
        defaultProvider.putExtra("CONTAINER_PREFIX", "convertView.");
        return defaultProvider;
    }
}
