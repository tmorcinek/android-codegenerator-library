package com.morcinek.android.codegenerator.extractor.model;

import com.google.common.base.Objects;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceType {

    private String className;

    private String packageName;

    public ResourceType(String className) {
        this.className = className;
    }

    public ResourceType(String className, String packageName) {
        this.className = className;
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getPackageName() {
        return packageName;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(className, packageName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResourceType)) return false;

        ResourceType that = (ResourceType) o;
        return Objects.equal(className, that.className) && Objects.equal(packageName, that.packageName);
    }
}
