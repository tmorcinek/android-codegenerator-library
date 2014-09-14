package com.morcinek.android.codegenerator.writer.builders;

import com.morcinek.android.codegenerator.writer.builders.file.ClassNameBuilder;
import org.fest.assertions.Assertions;
import org.junit.Test;

public class ClassNameBuilderTest {

    private ClassNameBuilder classNameBuilder;

    @Test
    public void builtStringTest() throws Exception {
        // given
        classNameBuilder = new ClassNameBuilder("main");

        // when
        String className = classNameBuilder.builtString();

        // then
        Assertions.assertThat(className).isNotNull().isEqualTo("MainActivity");
    }
}