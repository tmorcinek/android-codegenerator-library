package com.morcinek.android.codegenerator.extractor.string;

import com.morcinek.android.codegenerator.extractor.string.StringExtractor;

import java.io.File;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class FileNameExtractor implements StringExtractor<String> {

    @Override
    public String extractFromString(String filePath) {
        return new File(filePath).getName().replaceFirst(".xml", "");
    }
}
