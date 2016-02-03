package com.morcinek.android.codegenerator;

import com.morcinek.android.codegenerator.codegeneration.TemplateCodeGenerator;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.BActivityResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.templates.ResourceTemplatesProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import com.morcinek.android.codegenerator.extractor.XMLResourceExtractor;
import com.morcinek.android.codegenerator.extractor.string.FileNameExtractor;
import com.morcinek.android.codegenerator.util.InputStreamProvider;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

public class BActivityCodeGeneratorTest {

    private CodeGenerator codeGenerator;

    private InputStreamProvider inputStreamProvider = new InputStreamProvider();

    private TemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    @Before
    public void setUp() throws Exception {
        codeGenerator = new CodeGenerator(XMLResourceExtractor.createResourceExtractor(), new FileNameExtractor(), new TemplateCodeGenerator("BActivity_template", new BActivityResourceProvidersFactory(), new ResourceTemplatesProvider()));
    }

    @Test
    public void viewPagerProduceCodeTest() throws Exception {
        // given
        // when
        String producedCode = produceCodeFromFilePath("codegeneration/layouts/butterknife_simple.xml");

        // then
        Assertions.assertThat(producedCode).isNotNull().isEqualTo(templatesProvider.provideTemplateForName("results/activities/BSimpleActivity.java"));
    }

    private String produceCodeFromFilePath(String filePath) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        return codeGenerator.produceCode(inputStreamProvider.getStreamFromResource(filePath), filePath);
    }
}