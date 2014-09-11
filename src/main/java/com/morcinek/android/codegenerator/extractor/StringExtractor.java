package com.morcinek.android.codegenerator.extractor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class StringExtractor {

    /**
     * Extracts resource id from <code>android:id</code> attribute of layout widget.
     * Attribute values can look like:
     * - <code>@+id/list</code>
     * - <code>@android:id/list</code>
     *
     * @param idAttribute String value of <code>android:id</code> attribute.
     * @return
     */
    public String extractIdNameFromIdAttribute(String idAttribute) {
        return idAttribute.split("\\/")[1];
    }
}
