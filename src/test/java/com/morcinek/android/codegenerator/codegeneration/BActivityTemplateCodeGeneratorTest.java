package com.morcinek.android.codegenerator.codegeneration;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.BActivityResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.templates.ResourceTemplatesProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BActivityTemplateCodeGeneratorTest {

    private TemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private TemplateCodeGenerator templateCodeGenerator;

    @Before
    public void setUp() throws Exception {
        templateCodeGenerator = new TemplateCodeGenerator("BActivity_template", new BActivityResourceProvidersFactory(), new ResourceTemplatesProvider());
    }

    @Test
    public void produceSimpleViewCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                createResource("password", "View"),
                createResource("login", "View")
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "main");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/activities/BSimpleViewActivity.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    @Test
    public void produceSimpleButtonCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                createResource("button","Button"),
                createResource("imageButton","ImageButton")
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "main");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/activities/BSimpleButtonActivity.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    @Test
    public void produceSimpleListCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                createResource("button","Button"),
                createResource("list","List")
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "main");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/activities/BSimpleListActivity.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    @Test
    public void produceFormActivityCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                new Resource(new ResourceId("imageButton"), new ResourceType("ImageButton")),
                new Resource(new ResourceId("button"), new ResourceType("Button")),
                new Resource(new ResourceId("edit_text_name"), new ResourceType("EditText")),
                new Resource(new ResourceId("edit_text_city"), new ResourceType("EditText")),
                new Resource(new ResourceId("header_text"), new ResourceType("TextView")),
                new Resource(new ResourceId("list", "android"), new ResourceType("List"))
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "form");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/activities/BFormActivity.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    private Resource createResource(String resourceId, String resourceType) {
        return new Resource(new ResourceId(resourceId), new ResourceType(resourceType));
    }
}