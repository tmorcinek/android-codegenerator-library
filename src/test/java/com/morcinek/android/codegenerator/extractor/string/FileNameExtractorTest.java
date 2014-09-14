package com.morcinek.android.codegenerator.extractor.string;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

public class FileNameExtractorTest {

    private StringExtractor<String> stringExtractor;

    @Before
    public void setUp() throws Exception {
        stringExtractor = new FileNameExtractor();
    }

    @Test
    public void extractFilenameTest() throws Exception {
        // given
        String fileName = "this/is/path/to/file/main.xml";

        // when
        String name = stringExtractor.extractFromString(fileName);

        // then
        Assertions.assertThat(name).isNotNull().isEqualTo("main");
    }

    @Test
    public void extractFilenameTest2() throws Exception {
        // given
        String fileName = "new_file.xml";

        // when
        String name = stringExtractor.extractFromString(fileName);

        // then
        Assertions.assertThat(name).isNotNull().isEqualTo("new_file");
    }
}