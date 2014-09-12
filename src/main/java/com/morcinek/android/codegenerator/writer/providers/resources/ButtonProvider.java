package com.morcinek.android.codegenerator.writer.providers.resources;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.writer.providers.generic.AbstractResourceProvider;

import java.util.Map;
import java.util.Set;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ButtonProvider extends AbstractResourceProvider {

    public ButtonProvider(Resource resource) {
        super(resource);
    }

    @Override
    public Map<String, String> provideImport() {
        return null;
    }

    @Override
    public Set<String> provideInterface() {
        return Sets.newHashSet("OnClickListener");
    }

    @Override
    public Map<String, String> provideField() {
        Map<String, String> values = Maps.newHashMap();
        values.put("RESOURCE_ID", getResourceId());
        values.put("RESOURCE_TYPE", resource.getResourceType().getClassName());
        values.put("RESOURCE_NAME", getResourceName());
        return values;
    }

    @Override
    public Map<String, String> provideAssignment() {
        Map<String, String> values = Maps.newHashMap();
        values.put("RESOURCE_ID", getResourceId());
        values.put("RESOURCE_NAME", getResourceName());
        values.put("RESOURCE_ASSIGNMENT", getResourceName() + ".setOnClickListener(this);");
        return values;
    }

    @Override
    public Set<String> provideMethod() {
        return Sets.newHashSet("OnClickListener");
    }

    @Override
    public Map<String, String> provideMethodParams() {
        Map<String, String> values = Maps.newHashMap();
        values.put("RESOURCE_ID", getResourceId());
        return values;
    }
}
