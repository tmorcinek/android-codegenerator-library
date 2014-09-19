package com.morcinek.android.codegenerator.codegeneration.providers.resources;

import com.google.common.collect.Maps;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public abstract class AbstractResourceProvider implements ResourceProvider {

    private final Map<String, String> values;

    protected AbstractResourceProvider(Resource resource) {
        values = createValues(resource);
    }

    @Override
    public Map<String, String> provideValues() {
        return values;
    }

    public void putExtra(String key, String value) {
        values.put(key, value);
    }

    private Map<String, String> createValues(Resource resource) {
        Map<String, String> values = Maps.newHashMap();
        values.put("RESOURCE_ID", getResourceId(resource));
        values.put("RESOURCE_TYPE", resource.getResourceType().getClassName());
        values.put("RESOURCE_NAME", getResourceName(resource));
        values.put("RESOURCE_NAME_CAPITALIZED", StringUtils.capitalize(getResourceName(resource)));
        values.put("RESOURCE_PACKAGE", getPackageName(resource));
        return values;
    }

    private String getResourceName(Resource resource) {
        String idName = resource.getResourceId().getName();
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : idName.split("_")) {
            stringBuilder.append(StringUtils.capitalize(word));
        }
        return StringUtils.uncapitalize(stringBuilder.toString());
    }

    private String getResourceId(Resource resource) {
        ResourceId resourceId = resource.getResourceId();
        if (resourceId.getNamespace() != null) {
            return resourceId.getNamespace().concat(".R.id.").concat(resourceId.getName());
        }
        return "R.id." + resourceId.getName();
    }

    private String getPackageName(Resource resource) {
        String packageName = resource.getResourceType().getPackageName();
        if (packageName == null) {
            if (resource.getResourceType().getClassName().equals("View")) {
                return "android.view";
            } else {
                return "android.widget";
            }
        }
        return packageName;
    }
}
