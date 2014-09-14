package com.morcinek.android.codegenerator.writer.builders.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.ResourceTemplatesProvider;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

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

    @Test
    public void builtOnClickListenerMethodString() throws Exception {
        // given
        methodsBuilder = provideMethodsBuilder(Lists.newArrayList(getMockResourceProvider("done_button", "OnClickListener")));

        // when
        String value = methodsBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo(
                "    @Override\n" +
                        "    public void onClick(View view) {\n" +
                        "        switch (view.getId()) {\n" +
                        "            case R.id.done_button:\n" +
                        "                //TODO implement\n" +
                        "                break;\n" +
                        "\n" +
                        "        }\n" +
                        "    }\n"
        );
    }

    @Test
    public void builtOnClickListenerMethodWithTwoButtonsString() throws Exception {
        // given
        methodsBuilder = provideMethodsBuilder(Lists.newArrayList(
                getMockResourceProvider("cancel_button", "OnClickListener"),
                getMockResourceProvider("exit_button", "OnClickListener")
        ));

        // when
        String value = methodsBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo(
                "    @Override\n" +
                        "    public void onClick(View view) {\n" +
                        "        switch (view.getId()) {\n" +
                        "            case R.id.cancel_button:\n" +
                        "                //TODO implement\n" +
                        "                break;\n" +
                        "            case R.id.exit_button:\n" +
                        "                //TODO implement\n" +
                        "                break;\n" +
                        "\n" +
                        "        }\n" +
                        "    }\n"
        );
    }

    @Test
    public void builtOnClickListenerMethodWithGetterString() throws Exception {
        ResourceProvider resourceProvider = Mockito.mock(ResourceProvider.class);
        Map<String, String> treeMap = Maps.newHashMap();
        treeMap.put("RESOURCE_ID", "R.id.edit_text_name");
        treeMap.put("RESOURCE_TYPE", "EditText");
        treeMap.put("RESOURCE_NAME_CAPITALIZED", "EditTextName");
        when(resourceProvider.provideMethodParams()).thenReturn(treeMap);
        when(resourceProvider.provideMethod()).thenReturn(Sets.newHashSet("Getter"));

        // given
        methodsBuilder = provideMethodsBuilder(Lists.newArrayList(
                getMockResourceProvider("cancel_button", "OnClickListener"),
                resourceProvider
        ));

        // when
        String value = methodsBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo(
                "    @Override\n" +
                        "    public void onClick(View view) {\n" +
                        "        switch (view.getId()) {\n" +
                        "            case R.id.cancel_button:\n" +
                        "                //TODO implement\n" +
                        "                break;\n" +
                        "\n" +
                        "        }\n" +
                        "    }\n" +
                        "\n" +
                        "    private EditText getEditTextName(){\n" +
                        "        return (EditText) findViewById(R.id.edit_text_name);\n" +
                        "    }" +
                        "\n"
        );
    }

    private ResourceProvider getMockResourceProvider(String resourceId, String methodName) {
        ResourceProvider resourceProvider = Mockito.mock(ResourceProvider.class);
        Map<String, String> treeMap = Maps.newHashMap();
        treeMap.put("RESOURCE_ID", "R.id." + resourceId);
        when(resourceProvider.provideMethodParams()).thenReturn(treeMap);
        when(resourceProvider.provideMethod()).thenReturn(Sets.newHashSet(methodName));
        return resourceProvider;
    }

}