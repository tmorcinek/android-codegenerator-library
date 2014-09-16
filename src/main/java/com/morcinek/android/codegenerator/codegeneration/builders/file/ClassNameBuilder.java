package com.morcinek.android.codegenerator.codegeneration.builders.file;

import com.morcinek.android.codegenerator.codegeneration.builders.CodeBuilder;
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
        return getResourceName(fileName) + "Activity";
    }

    private String getResourceName(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : fileName.split("_")) {
            stringBuilder.append(StringUtils.capitalize(word));
        }
        return stringBuilder.toString();
    }

    @Override
    public String getKey() {
        return "CLASS_NAME";
    }
}
