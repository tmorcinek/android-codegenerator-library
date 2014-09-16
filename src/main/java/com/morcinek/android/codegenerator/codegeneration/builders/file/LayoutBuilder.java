package com.morcinek.android.codegenerator.codegeneration.builders.file;

import com.morcinek.android.codegenerator.codegeneration.builders.CodeBuilder;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class LayoutBuilder implements CodeBuilder {

    private String fileName;

    public LayoutBuilder(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String builtString() {
        return "R.layout." + fileName;
    }

    @Override
    public String getKey() {
        return "LAYOUT";
    }
}
