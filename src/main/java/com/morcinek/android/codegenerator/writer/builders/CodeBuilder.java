package com.morcinek.android.codegenerator.writer.builders;

import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface CodeBuilder {

    void processResourceProvider(ResourceProvider resourceProvider);

    @Override
    String toString();
}
