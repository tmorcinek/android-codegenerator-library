package com.morcinek.android.codegenerator.extractor.string;

import com.morcinek.android.codegenerator.extractor.string.StringExtractor;
import com.morcinek.android.codegenerator.model.ResourceType;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceTypeExtractor implements StringExtractor<ResourceType> {

    @Override
    public ResourceType extractFromString(String typeName) {
        int lastDot = typeName.lastIndexOf(".");
        if (lastDot == -1) {
            return new ResourceType(typeName);
        } else {
            return new ResourceType(typeName.substring(lastDot + 1), typeName.substring(0, lastDot));
        }
    }
}
