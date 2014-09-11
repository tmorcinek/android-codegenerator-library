package com.morcinek.android.codegenerator.model;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceObject {

    private ResourceId resourceId;

    private String typeName;

    public ResourceObject(ResourceId resourceId, String typeName) {
        this.resourceId = resourceId;
        this.typeName = typeName;
    }

    public ResourceId getResourceId() {
        return resourceId;
    }

    public String getTypeName() {
        return typeName;
    }
}
