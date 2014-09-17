package com.morcinek.android.codegenerator;

import com.morcinek.android.codegenerator.codegeneration.TemplateCodeGenerator;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.ActivityResourceProvidersFactory;
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

public class ActivityCodeGeneratorTest {

    private CodeGenerator codeGenerator;

    private InputStreamProvider inputStreamProvider = new InputStreamProvider();

    private TemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    @Before
    public void setUp() throws Exception {
        codeGenerator = new CodeGenerator(XMLResourceExtractor.createResourceExtractor(), new FileNameExtractor(), new TemplateCodeGenerator("Activity_template", new ActivityResourceProvidersFactory(), new ResourceTemplatesProvider()));
    }

    @Test
    public void viewPagerProduceCodeTest() throws Exception {
        // given
        // when
        String producedCode = produceCodeFromFilePath("layouts/view_pager.xml");

        // then
        Assertions.assertThat(producedCode).isNotNull().isEqualTo(templatesProvider.provideTemplateForName("results/ViewPagerActivity.java"));
    }

    @Test
    public void searchListProduceCodeTest() throws Exception {
        // given
        // when
        String producedCode = produceCodeFromFilePath("layouts/search_list.xml");

        // then
        Assertions.assertThat(producedCode).isNotNull().isEqualTo(templatesProvider.provideTemplateForName("results/SearchListActivity.java"));
    }

    @Test
    public void createGameProduceCodeTest() throws Exception {
        // given
        // when
        String producedCode = produceCodeFromFilePath("layouts/create_game.xml");

        // then
        Assertions.assertThat(producedCode).isNotNull().isEqualTo(templatesProvider.provideTemplateForName("results/CreateGameActivity.java"));
    }

    @Test
    public void appendPackageTest() throws Exception {
        // given
        String packageName = "com.morcinek.grouplaying";
        String body = "private class MainActivity {}";

        // when
        String appendPackage = codeGenerator.appendPackage(packageName, body);

        // then
        Assertions.assertThat(appendPackage).isNotNull().isEqualTo(
                "package com.morcinek.grouplaying;\n" +
                        "\n" +
                        "private class MainActivity {}"
        );
    }

    @Test
    public void appendEmptyPackageTest() throws Exception {
        // given
        String packageName = "";
        String body = "private class MainActivity {}";

        // when
        String appendPackage = codeGenerator.appendPackage(packageName, body);

        // then
        Assertions.assertThat(appendPackage).isNotNull().isEqualTo(
                "private class MainActivity {}"
        );
    }

    @Test
    public void getJavaFileNameTest() throws Exception {
        // given
        String filename = "this_file.xml";

        // when
        String javaFileName = codeGenerator.getJavaFileName(filename, "Activity");

        // then
        Assertions.assertThat(javaFileName).isNotNull().isEqualTo("ThisFileActivity.java");
    }

    @Test
    public void getJavaFileNamePathTest() throws Exception {
        // given
        String filename = "this/is/path/to/this_file.xml";

        // when
        String javaFileName = codeGenerator.getJavaFileName(filename, "Activity");

        // then
        Assertions.assertThat(javaFileName).isNotNull().isEqualTo("ThisFileActivity.java");
    }

    private String produceCodeFromFilePath(String filePath) throws ParserConfigurationException, SAXException, XPathExpressionException, IOException {
        return codeGenerator.produceCode(inputStreamProvider.getStreamFromResource(filePath), filePath);
    }
}