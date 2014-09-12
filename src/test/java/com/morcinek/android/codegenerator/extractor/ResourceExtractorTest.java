package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.extractor.string.ResourceIdExtractor;
import com.morcinek.android.codegenerator.extractor.string.ResourceTypeExtractor;
import com.morcinek.android.codegenerator.extractor.model.Resource;
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
        assertResource(resources.get(0), "Button", null, "button", null);
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
        assertResource(resources.get(0), "ViewPager", "android.support.v4.view", "pager", null);
    }

    @Test
    public void locationsMapTest() throws Exception {
        // given
        InputStream inputStream = getStreamFromResource("locations_map.xml");

        // when
        List<Resource> resources = resourceExtractor.extractResourceObjectsFromStream(inputStream);

        // then
        Assertions.assertThat(resources).isNotNull().hasSize(4);
        assertResource(resources.get(0), "ActionBar", "com.morcinek.budget.ui.widgets", "actionbar", null);
        assertResource(resources.get(1), "RelativeLayout", null, "map_frame_layout", null);
        assertResource(resources.get(2), "FrameLayout", null, "map_container", null);
        assertResource(resources.get(3), "ImageButton", null, "home_button", null);
    }

    private void assertResource(Resource resource, String className, String packageName, String idName, String idNamespace) {
        Assertions.assertThat(resource.getResourceType().getClassName()).isEqualTo(className);
        Assertions.assertThat(resource.getResourceType().getPackageName()).isEqualTo(packageName);
        Assertions.assertThat(resource.getResourceId().getName()).isEqualTo(idName);
        Assertions.assertThat(resource.getResourceId().getNamespace()).isEqualTo(idNamespace);
    }
}
