package com.morcinek.android.codegenerator.extractor.model;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceId {

    private String name;

    private String namespace;

    public ResourceId(String name) {
        this.name = name;
    }

    public ResourceId(String name, String namespace) {
        this.name = name;
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public String getNamespace() {
        return namespace;
    }
}
