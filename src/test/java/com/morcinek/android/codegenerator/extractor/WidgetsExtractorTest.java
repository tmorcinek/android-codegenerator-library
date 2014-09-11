package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.model.Widget;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class WidgetsExtractorTest {

    private WidgetsExtractor widgetsExtractor;

    @Before
    public void setUp() throws Exception {
        widgetsExtractor = new XMLWidgetsExtractor();
    }

    private InputStream getStreamFromResource(String name) {
        return getClass().getResourceAsStream(name);
    }

    @Test
    public void layoutTest() throws Exception {
        InputStream inputStream = getStreamFromResource("/layout.xml");
        List<Widget> widgets = widgetsExtractor.extractWidgetsFromStream(inputStream);
        Assertions.assertThat(widgets).isNotNull().hasSize(1).containsOnly(new Widget("button","Button"));
    }
}
