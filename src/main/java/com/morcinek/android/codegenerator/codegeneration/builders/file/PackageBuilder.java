package com.morcinek.android.codegenerator.codegeneration.builders.file;

import com.morcinek.android.codegenerator.codegeneration.builders.CodeBuilder;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class PackageBuilder implements CodeBuilder {

    private String packageName;

    public PackageBuilder(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public String builtString() {
        return String.format("package %s;\n\n", packageName);
    }

    @Override
    public String getKey() {
        return "PACKAGE";
    }
}
