package com.morcinek.android.codegenerator.extractor.string;

import com.morcinek.android.codegenerator.extractor.model.ResourceId;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceIdExtractor implements StringExtractor<ResourceId> {

    /**
     * Extracts resource id from <code>android:id</code> attribute of layout widget.
     * Attribute values can look like:
     * - <code>@+id/list</code>
     * - <code>@android:id/list</code>
     *
     * @param idAttribute String value of <code>android:id</code> attribute.
     * @return ResourceId object
     */
    @Override
    public ResourceId extractFromString(String idAttribute) {
        IdAttributeUnion attributeUnion = new IdAttributeUnion(idAttribute);

        ResourceId resourceId = new ResourceId(attributeUnion.name);
        resourceId.setNamespace(getNamespace(attributeUnion.prefix));
        return resourceId;
    }

    private String getNamespace(String prefix) {
        Matcher matcher = Pattern.compile("@([\\w]+):id").matcher(prefix);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    private class IdAttributeUnion {

        String prefix;
        String name;

        IdAttributeUnion(String idAttribute) {
            String[] split = idAttribute.split("\\/");
            prefix = split[0];
            name = split[1];
        }
    }
}
