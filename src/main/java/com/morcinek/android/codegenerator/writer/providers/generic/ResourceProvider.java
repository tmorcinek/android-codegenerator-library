package com.morcinek.android.codegenerator.writer.providers.generic;

import java.util.Map;
import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public interface ResourceProvider {

    public Map<String, String> provideImport();

    public Set<String> provideInterface();

    public Map<String, String> provideField();

    public Map<String, String> provideAssignment();

    public Set<String> provideMethod();

    public Map<String, String> provideMethodParams();
}
