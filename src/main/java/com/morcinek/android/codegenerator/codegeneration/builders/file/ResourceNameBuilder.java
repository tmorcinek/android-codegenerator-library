package com.morcinek.android.codegenerator.codegeneration.builders.file;

import com.morcinek.android.codegenerator.codegeneration.builders.CodeBuilder;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceNameBuilder implements CodeBuilder {

    private String fileName;

    public ResourceNameBuilder(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String builtString() {
        return fileName;
    }

    @Override
    public String getKey() {
        return "RESOURCE_NAME";
    }
}
