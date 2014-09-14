package com.morcinek.android.codegenerator.writer.builders.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.writer.templates.ResourceTemplatesProvider;
import org.apache.commons.lang3.StringUtils;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

public class FieldsBuilderTest {

    private ResourceTemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private ResourceCodeBuilder interfaceBuilder;

    private ResourceCodeBuilder provideFieldsBuilder(List<ResourceProvider> resourceProviders) {
        return new FieldsBuilder(resourceProviders, templatesProvider);
    }

    @Test
    public void builtNoFieldString() throws Exception {
        // given
        interfaceBuilder = provideFieldsBuilder(Lists.<ResourceProvider>newArrayList());

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("");
    }

    @Test
    public void builtOneFieldString() throws Exception {
        // given
        interfaceBuilder = provideFieldsBuilder(Lists.newArrayList(getMockResourceProvider("button")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("    private Button button;\n");
    }

    @Test
    public void builtTwoFieldString() throws Exception {
        // given
        interfaceBuilder = provideFieldsBuilder(Lists.newArrayList(getMockResourceProvider("button"), getMockResourceProvider("view")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo(
                "    private Button button;\n" +
                "    private View view;\n"
        );
    }

    private ResourceProvider getMockResourceProvider(String name) {
        ResourceProvider resourceProvider = Mockito.mock(ResourceProvider.class);
        Map<String, String> treeMap = Maps.newHashMap();
        treeMap.put("RESOURCE_TYPE", StringUtils.capitalize(name));
        treeMap.put("RESOURCE_NAME", name);
        when(resourceProvider.provideValues()).thenReturn(treeMap);
        return resourceProvider;
    }
}