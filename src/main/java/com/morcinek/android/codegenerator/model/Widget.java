package com.morcinek.android.codegenerator.model;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class Widget {

    private String id;

    private String typeName;

    public Widget(String id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public String getId() {
        return id;
    }

    public String getTypeName() {
        return typeName;
    }
}
