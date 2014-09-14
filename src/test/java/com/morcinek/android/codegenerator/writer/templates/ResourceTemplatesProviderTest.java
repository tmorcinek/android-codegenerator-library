package com.morcinek.android.codegenerator.writer.templates;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceTemplatesProviderTest {

    private TemplatesProvider templatesProvider;

    @Before
    public void setUp() throws Exception {
        templatesProvider = new ResourceTemplatesProvider();
    }

    @Test
    public void provideAssignmentTemplateTest() throws Exception {
        String template = templatesProvider.provideTemplateForName("Assignment__template");
        Assertions.assertThat(template).isNotNull().isNotEmpty().isEqualTo(
                "        ${RESOURCE_NAME} = (${RESOURCE_TYPE}) findViewById(${RESOURCE_ID});\n" +
                        "        ${RESOURCE_ASSIGNMENT}");
    }
}
