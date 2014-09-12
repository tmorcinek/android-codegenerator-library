package com.morcinek.android.codegenerator.extractor.string;

import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceTypeExtractorTest {

    private StringExtractor<ResourceType> resourceTypeExtractor;

    @Before
    public void setUp() throws Exception {
        resourceTypeExtractor = new ResourceTypeExtractor();
    }

    @Test
    public void simpleButtonTest() throws Exception {
        ResourceType resourceType = resourceTypeExtractor.extractFromString("Button");
        Assertions.assertThat(resourceType.getClassName()).isEqualTo("Button");
        Assertions.assertThat(resourceType.getPackageName()).isNull();
    }

    @Test
    public void simpleEditTextTest() throws Exception {
        ResourceType resourceType = resourceTypeExtractor.extractFromString("EditText");
        Assertions.assertThat(resourceType.getClassName()).isEqualTo("EditText");
        Assertions.assertThat(resourceType.getPackageName()).isNull();
    }

    @Test
    public void pagerTest() throws Exception {
        ResourceType resourceType = resourceTypeExtractor.extractFromString("android.support.v4.view.ViewPager");
        Assertions.assertThat(resourceType.getClassName()).isEqualTo("ViewPager");
        Assertions.assertThat(resourceType.getPackageName()).isEqualTo("android.support.v4.view");
    }

    @Test
    public void actionBarTest() throws Exception {
        ResourceType resourceType = resourceTypeExtractor.extractFromString("com.sunbelt.ui.widgets.ActionBar");
        Assertions.assertThat(resourceType.getClassName()).isEqualTo("ActionBar");
        Assertions.assertThat(resourceType.getPackageName()).isEqualTo("com.sunbelt.ui.widgets");
    }
}
