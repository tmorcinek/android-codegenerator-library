package com.morcinek.android.codegenerator.model;

import com.google.common.base.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Widget widget = (Widget) o;
        return Objects.equal(id, widget.id) && Objects.equal(typeName, widget.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, typeName);
    }
}
