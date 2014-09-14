package com.morcinek.android.codegenerator.writer;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import com.morcinek.android.codegenerator.writer.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.writer.templates.ResourceTemplatesProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CodeWriterTest {

    private TemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private CodeWriter codeWriter;

    @Before
    public void setUp() throws Exception {
        codeWriter = new CodeWriter(new ResourceProvidersFactory(), new ResourceTemplatesProvider());
    }

    @Test
    public void produceMainActivytCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(new Resource(new ResourceId("button"), new ResourceType("Button")));

        // when
        String generatedCode = codeWriter.produceJavaCode(resources, "main");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("MainActivity.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }
}