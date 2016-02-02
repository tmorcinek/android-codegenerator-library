package com.morcinek.android.codegenerator.codegeneration;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.BNActivityResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.templates.ResourceTemplatesProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BNActivityTemplateCodeGeneratorTest {

    private TemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private TemplateCodeGenerator templateCodeGenerator;

    @Before
    public void setUp() throws Exception {
        templateCodeGenerator = new TemplateCodeGenerator("BNActivity_template", new BNActivityResourceProvidersFactory(), new ResourceTemplatesProvider());
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
        String expectedCode = templatesProvider.provideTemplateForName("results/activities/BNSimpleViewActivity.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    @Test
    public void produceSimpleButtonCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                createResource("button","Button")
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "main");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/activities/BNSimpleButtonActivity.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    private Resource createResource(String resourceId, String resourceType) {
        return new Resource(new ResourceId(resourceId), new ResourceType(resourceType));
    }
}