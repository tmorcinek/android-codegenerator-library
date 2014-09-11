package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.model.ResourceObject;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceObjectExtractorTest {

    private ResourceObjectExtractor resourceObjectExtractor;

    @Before
    public void setUp() throws Exception {
        resourceObjectExtractor = new XMLResourceObjectExtractor();
    }

    private InputStream getStreamFromResource(String name) {
        return getClass().getResourceAsStream(name);
    }

    @Test
    public void layoutTest() throws Exception {
        InputStream inputStream = getStreamFromResource("/layout.xml");
        List<ResourceObject> resourceObjects = resourceObjectExtractor.extractResourceObjectsFromStream(inputStream);
        Assertions.assertThat(resourceObjects).isNotNull().hasSize(1).containsOnly(new ResourceObject("button", "Button"));
    }
}
