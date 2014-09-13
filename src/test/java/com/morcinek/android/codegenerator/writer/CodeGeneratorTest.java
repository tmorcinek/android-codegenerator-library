package com.morcinek.android.codegenerator.writer;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import com.morcinek.android.codegenerator.writer.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.writer.templates.ResourceTemplatesProvider;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CodeGeneratorTest {

    private CodeGenerator codeGenerator;

    @Before
    public void setUp() throws Exception {
        codeGenerator = new CodeGenerator(new ResourceProvidersFactory(), new ResourceTemplatesProvider());
    }

    @Test
    public void produceJavaCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(new Resource(new ResourceId("button"), new ResourceType("Button")));

        // when
        String generatedCode = codeGenerator.produceJavaCode(resources, "main");

        // then
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(
                "\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "public class MainActivity extends Activity implements OnClickListener {\n" +
                        "\n" +
                        "    \n" +
                        "\n" +
                        "    @Override\n" +
                        "    protected void onCreate(Bundle savedInstanceState) {\n" +
                        "        super.onCreate(savedInstanceState);\n" +
                        "        setContentView(R.layout.main);\n" +
                        "\n" +
                        "        \n" +
                        "    }\n" +
                        "\n" +
                        "    \n" +
                        "}\n");
    }
}