package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.extractor.string.ResourceIdExtractor;
import com.morcinek.android.codegenerator.extractor.string.ResourceTypeExtractor;
import com.morcinek.android.codegenerator.model.Resource;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceExtractorTest {

    private ResourceExtractor resourceExtractor;

    @Before
    public void setUp() throws Exception {
        resourceExtractor = new XMLResourceExtractor(new ResourceIdExtractor(), new ResourceTypeExtractor());
    }

    private InputStream getStreamFromResource(String name) {
        return getClass().getResourceAsStream("/" + name);
    }

    @Test
    public void layoutTest() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("layout.xml");

        // when
        List<Resource> resources = resourceExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resources).isNotNull().hasSize(1);
        Resource resource = resources.get(0);
        Assertions.assertThat(resource.getResourceType().getClassName()).isEqualTo("Button");
        Assertions.assertThat(resource.getResourceType().getPackageName()).isNull();
        Assertions.assertThat(resource.getResourceId().getName()).isEqualTo("button");
        Assertions.assertThat(resource.getResourceId().getNamespace()).isNull();
    }

    @Test
    public void mainHeader1Test() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("main_header_1.xml");

        // when
        List<Resource> resources = resourceExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resources).isNotNull().hasSize(0);
    }

    @Test
    public void mainHeader2Test() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("main_header_2.xml");

        // when
        List<Resource> resources = resourceExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resources).isNotNull().hasSize(0);
    }

    @Test
    public void mainNoHeaderTest() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("main_no_header.xml");

        // when
        List<Resource> resources = resourceExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resources).isNotNull().hasSize(0);
    }

    @Test
    public void specificTest() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("specific.xml");

        // when
        List<Resource> resources = resourceExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resources).isNotNull().hasSize(1);
        Resource resource = resources.get(0);
        Assertions.assertThat(resource.getResourceType().getClassName()).isEqualTo("ViewPager");
        Assertions.assertThat(resource.getResourceType().getPackageName()).isEqualTo("android.support.v4.view");
        Assertions.assertThat(resource.getResourceId().getName()).isEqualTo("pager");
        Assertions.assertThat(resource.getResourceId().getNamespace()).isNull();
    }
}
