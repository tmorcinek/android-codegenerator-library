package com.morcinek.android.codegenerator.model;

import com.google.common.base.Objects;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceId {

    private String name;

    private String namespace;

    public ResourceId(String name) {
        this.name = name;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public String getNamespace() {
        return namespace;
    }
}
