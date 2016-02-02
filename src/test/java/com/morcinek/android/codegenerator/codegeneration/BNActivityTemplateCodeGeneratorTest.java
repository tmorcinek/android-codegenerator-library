package com.morcinek.android.codegenerator.codegeneration;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.ActivityResourceProvidersFactory;
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
    public void produceMainActivityCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(new Resource(new ResourceId("button"), new ResourceType("Button")));

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "main");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/activities/BNMainActivity.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }
}