package com.morcinek.android.codegenerator.writer.builders.resources;

import com.morcinek.android.codegenerator.writer.builders.CodeBuilder;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;

import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface ResourceCodeBuilder extends CodeBuilder {

    void processResourceProviders(List<ResourceProvider> resourceProviders);
}
