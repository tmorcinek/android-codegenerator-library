package com.morcinek.android.codegenerator.model;

import com.google.common.base.Objects;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceObject {

    private String id;

    private String typeName;

    public ResourceObject(String id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ResourceObject resourceObject = (ResourceObject) o;
        return Objects.equal(id, resourceObject.id) && Objects.equal(typeName, resourceObject.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, typeName);
    }
}
