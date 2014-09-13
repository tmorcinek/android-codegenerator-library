package com.morcinek.android.codegenerator.writer.builders.resources;

import com.morcinek.android.codegenerator.writer.builders.CodeBuilder;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface ResourceCodeBuilder extends CodeBuilder {

    void processResourceProvider(ResourceProvider resourceProvider);
}
