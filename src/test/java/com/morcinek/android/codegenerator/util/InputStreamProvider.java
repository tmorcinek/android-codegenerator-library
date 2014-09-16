package com.morcinek.android.codegenerator.util;

import java.io.InputStream;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class InputStreamProvider {

    public InputStream getStreamFromResource(String name) {
        return getClass().getResourceAsStream("/" + name);
    }
}
