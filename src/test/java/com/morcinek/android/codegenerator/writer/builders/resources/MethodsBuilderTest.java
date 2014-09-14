package com.morcinek.android.codegenerator.writer.builders.resources;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.ResourceTemplatesProvider;
import org.fest.assertions.Assertions;
import org.junit.Test;

import java.util.List;

public class MethodsBuilderTest {

    private ResourceTemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private ResourceCodeBuilder methodsBuilder;

    private ResourceCodeBuilder provideMethodsBuilder(List<ResourceProvider> resourceProviders) {
        return new MethodsBuilder(resourceProviders, templatesProvider);
    }

    @Test
    public void builtNoMethodsString() throws Exception {
        // given
        methodsBuilder = provideMethodsBuilder(Lists.<ResourceProvider>newArrayList());

        // when
        String value = methodsBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("");
    }
}