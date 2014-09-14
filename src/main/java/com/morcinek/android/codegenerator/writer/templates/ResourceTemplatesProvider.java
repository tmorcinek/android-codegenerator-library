package com.morcinek.android.codegenerator.writer.templates;

import com.google.common.io.Resources;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceTemplatesProvider implements TemplatesProvider {

    @Override
    public String provideTemplateForName(String templateName) {
        URL url = Resources.getResource(templateName);
        try {
            return Resources.toString(url, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
