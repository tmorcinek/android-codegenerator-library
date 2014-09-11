package com.morcinek.android.codegenerator.extractor;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class StringExtractorTest {

    private StringExtractor stringExtractor;

    @Before
    public void setUp() throws Exception {
        stringExtractor = new StringExtractor();
    }

    @Test
    public void simpleIdTest() throws Exception {
        String nameFromIdAttribute = stringExtractor.extractIdNameFromIdAttribute("@+id/list");
        Assertions.assertThat(nameFromIdAttribute).isEqualTo("list");
    }

    @Test
    public void simpleIdTest2() throws Exception {
        String nameFromIdAttribute = stringExtractor.extractIdNameFromIdAttribute("@+id/this_is_resource");
        Assertions.assertThat(nameFromIdAttribute).isEqualTo("this_is_resource");
    }

    @Test
    public void androidIdTest() throws Exception {
        String nameFromIdAttribute = stringExtractor.extractIdNameFromIdAttribute("@android:id/list");
        Assertions.assertThat(nameFromIdAttribute).isEqualTo("list");
    }

    @Test
    public void androidIdTest2() throws Exception {
        String nameFromIdAttribute = stringExtractor.extractIdNameFromIdAttribute("@android:id/content_view");
        Assertions.assertThat(nameFromIdAttribute).isEqualTo("content_view");
    }
}
