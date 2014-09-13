package com.morcinek.android.codegenerator.writer.builders;

import org.apache.commons.lang3.StringUtils;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ClassNameBuilder implements CodeBuilder {

    private String fileName;

    public ClassNameBuilder(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String builtString() {
        return StringUtils.capitalize(fileName) + "Activity";
    }
}
