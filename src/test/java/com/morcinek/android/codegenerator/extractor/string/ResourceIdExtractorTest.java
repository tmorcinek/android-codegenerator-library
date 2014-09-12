package com.morcinek.android.codegenerator.extractor.string;

import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceIdExtractorTest {

    private ResourceIdExtractor resourceIdExtractor;

    @Before
    public void setUp() throws Exception {
        resourceIdExtractor = new ResourceIdExtractor();
    }

    @Test
    public void simpleIdTest() throws Exception {
        ResourceId resourceId = resourceIdExtractor.extractFromString("@+id/list");
        Assertions.assertThat(resourceId.getName()).isEqualTo("list");
        Assertions.assertThat(resourceId.getNamespace()).isNull();
    }

    @Test
    public void simpleIdTest2() throws Exception {
        ResourceId resourceId = resourceIdExtractor.extractFromString("@+id/this_is_resource");
        Assertions.assertThat(resourceId.getName()).isEqualTo("this_is_resource");
        Assertions.assertThat(resourceId.getNamespace()).isNull();
    }

    @Test
    public void androidIdTest() throws Exception {
        ResourceId resourceId = resourceIdExtractor.extractFromString("@android:id/list");
        Assertions.assertThat(resourceId.getName()).isEqualTo("list");
        Assertions.assertThat(resourceId.getNamespace()).isEqualTo("android");
    }

    @Test
    public void androidIdTest2() throws Exception {
        ResourceId resourceId = resourceIdExtractor.extractFromString("@android:id/content_view");
        Assertions.assertThat(resourceId.getName()).isEqualTo("content_view");
        Assertions.assertThat(resourceId.getNamespace()).isEqualTo("android");
    }
}
