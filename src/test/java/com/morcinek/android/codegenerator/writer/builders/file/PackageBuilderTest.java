package com.morcinek.android.codegenerator.writer.builders.file;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class PackageBuilderTest {

    @Test
    public void testBuiltString() throws Exception {
        // given
        PackageBuilder packageBuilder = new PackageBuilder("com.morcinek.grouplaying");

        // when
        String builtString = packageBuilder.builtString();

        // then
        Assertions.assertThat(builtString).isNotNull().isEqualTo("package com.morcinek.grouplaying;\n\n");
    }
}