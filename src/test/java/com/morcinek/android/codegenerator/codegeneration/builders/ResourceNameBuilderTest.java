package com.morcinek.android.codegenerator.codegeneration.builders;

import com.morcinek.android.codegenerator.codegeneration.builders.file.ResourceNameBuilder;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class ResourceNameBuilderTest {

    private ResourceNameBuilder resourceNameBuilder;

    @Test
    public void builtStringTest() throws Exception {
        // given
        resourceNameBuilder = new ResourceNameBuilder("main");

        // when
        String layout = resourceNameBuilder.builtString();

        // then
        Assertions.assertThat(layout).isNotNull().isEqualTo("main");
    }
}