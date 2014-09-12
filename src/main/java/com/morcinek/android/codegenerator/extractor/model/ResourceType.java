package com.morcinek.android.codegenerator.extractor.model;

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
}
