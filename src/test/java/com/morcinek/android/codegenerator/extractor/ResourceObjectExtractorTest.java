package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.extractor.id.ResourceIdExtractor;
import com.morcinek.android.codegenerator.extractor.type.ResourceTypeExtractor;
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
        resourceObjectExtractor = new XMLResourceObjectExtractor(new ResourceIdExtractor(), new ResourceTypeExtractor());
    }

    private InputStream getStreamFromResource(String name) {
        return getClass().getResourceAsStream("/" + name);
    }

    @Test
    public void layoutTest() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("layout.xml");

        // when
        List<ResourceObject> resourceObjects = resourceObjectExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resourceObjects).isNotNull().hasSize(1);
        ResourceObject resourceObject = resourceObjects.get(0);
        Assertions.assertThat(resourceObject.getResourceType().getClassName()).isEqualTo("Button");
        Assertions.assertThat(resourceObject.getResourceType().getPackageName()).isNull();
        Assertions.assertThat(resourceObject.getResourceId().getName()).isEqualTo("button");
        Assertions.assertThat(resourceObject.getResourceId().getNamespace()).isNull();
    }

    @Test
    public void mainHeader1Test() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("main_header_1.xml");

        // when
        List<ResourceObject> resourceObjects = resourceObjectExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resourceObjects).isNotNull().hasSize(0);
    }

    @Test
    public void mainHeader2Test() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("main_header_2.xml");

        // when
        List<ResourceObject> resourceObjects = resourceObjectExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resourceObjects).isNotNull().hasSize(0);
    }

    @Test
    public void mainNoHeaderTest() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("main_no_header.xml");

        // when
        List<ResourceObject> resourceObjects = resourceObjectExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resourceObjects).isNotNull().hasSize(0);
    }

    @Test
    public void specificTest() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("specific.xml");

        // when
        List<ResourceObject> resourceObjects = resourceObjectExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resourceObjects).isNotNull().hasSize(1);
        ResourceObject resourceObject = resourceObjects.get(0);
        Assertions.assertThat(resourceObject.getResourceType().getClassName()).isEqualTo("ViewPager");
        Assertions.assertThat(resourceObject.getResourceType().getPackageName()).isEqualTo("android.support.v4.view");
        Assertions.assertThat(resourceObject.getResourceId().getName()).isEqualTo("pager");
        Assertions.assertThat(resourceObject.getResourceId().getNamespace()).isNull();
    }
}
