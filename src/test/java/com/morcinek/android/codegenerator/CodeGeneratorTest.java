package com.morcinek.android.codegenerator;

import com.morcinek.android.codegenerator.extractor.XMLResourceExtractor;
import com.morcinek.android.codegenerator.extractor.string.FileNameExtractor;
import com.morcinek.android.codegenerator.extractor.string.ResourceIdExtractor;
import com.morcinek.android.codegenerator.extractor.string.ResourceTypeExtractor;
import com.morcinek.android.codegenerator.writer.CodeWriter;
import com.morcinek.android.codegenerator.writer.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.writer.templates.ResourceTemplatesProvider;
import com.morcinek.android.codegenerator.writer.templates.TemplatesProvider;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.*;

public class CodeGeneratorTest {

    private CodeGenerator codeGenerator;

    private TemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    @Before
    public void setUp() throws Exception {
        codeGenerator = new CodeGenerator(XMLResourceExtractor.createResourceExtractor(), new FileNameExtractor(), new CodeWriter(new ResourceProvidersFactory(), new ResourceTemplatesProvider()));
    }

    @Test
    public void viewPagerProduceCode() throws Exception {

        // given
        // when
        String producedCode = produceCodeFromFilePath("layouts/view_pager.xml");

        // then
        Assertions.assertThat(producedCode).isNotNull().isEqualTo(templatesProvider.provideTemplateForName("results/ViewPagerActivity.java"));
    }

    private InputStream getStreamFromResource(String name) {
        return getClass().getResourceAsStream("/" + name);
    }

    private String produceCodeFromFilePath(String filePath) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        return codeGenerator.produceCode(getStreamFromResource(filePath), filePath);
    }
}