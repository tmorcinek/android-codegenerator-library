package com.morcinek.android.codegenerator.codegeneration.providers;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface ResourceProvidersFactory {

    ResourceProvider createResourceProvider(Resource resource);
}
