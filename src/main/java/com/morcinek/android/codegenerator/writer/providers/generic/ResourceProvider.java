package com.morcinek.android.codegenerator.writer.providers.generic;

import java.util.Map;
import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface ResourceProvider {

    public Map<String, String> provideValues();

    public Set<String> provideInterface();

    public Set<String> provideMethod();

    public Set<String> provideAssignment();
}
