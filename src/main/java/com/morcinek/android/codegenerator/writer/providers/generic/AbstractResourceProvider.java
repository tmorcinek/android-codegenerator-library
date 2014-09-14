package com.morcinek.android.codegenerator.writer.providers.generic;

import com.google.common.collect.Maps;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public abstract class AbstractResourceProvider implements ResourceProvider {

    protected Resource resource;

    protected AbstractResourceProvider(Resource resource) {
        this.resource = resource;
    }

    @Override
    public Map<String, String> provideValues() {
        Map<String, String> values = Maps.newHashMap();
        values.put("RESOURCE_ID", getResourceId());
        values.put("RESOURCE_TYPE", resource.getResourceType().getClassName());
        values.put("RESOURCE_NAME", getResourceName());
        return values;
    }

    protected String getResourceName() {
        String idName = resource.getResourceId().getName();
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : idName.split("_")) {
            stringBuilder.append(StringUtils.capitalize(word));
        }
        return StringUtils.uncapitalize(stringBuilder.toString());
    }

    protected String getResourceId() {
        ResourceId resourceId = resource.getResourceId();
        if (resourceId.getNamespace() != null) {
            return resourceId.getNamespace().concat(".R.id.").concat(resourceId.getName());
        }
        return "R.id." + resourceId.getName();
    }
}
