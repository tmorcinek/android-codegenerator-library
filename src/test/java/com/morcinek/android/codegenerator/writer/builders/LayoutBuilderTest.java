package com.morcinek.android.codegenerator.writer.builders;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class LayoutBuilderTest {

    private LayoutBuilder layoutBuilder;

    @Test
    public void builtStringTest() throws Exception {
        // given
        layoutBuilder = new LayoutBuilder("main");

        // when
        String layout = layoutBuilder.builtString();

        // then
        Assertions.assertThat(layout).isNotNull().isEqualTo("R.layout.main");
    }
}