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

public class AssignmentsBuilderTest {

    private ResourceTemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private ResourceCodeBuilder interfaceBuilder;

    private ResourceCodeBuilder provideAssignmentBuilder(List<ResourceProvider> resourceProviders) {
        return new AssignmentsBuilder(resourceProviders, templatesProvider);
    }

    @Test
    public void builtNoFieldString() throws Exception {
        // given
        interfaceBuilder = provideAssignmentBuilder(Lists.<ResourceProvider>newArrayList());

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("");
    }

    @Test
    public void builtOneFieldString() throws Exception {
        // given
        interfaceBuilder = provideAssignmentBuilder(Lists.newArrayList(getMockResourceProvider("button")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo(
                "button = (Button) findViewById(R.id.button);\n" +
                "button.setOnClickListener(this);\n");
    }

    @Test
    public void builtTwoFieldString() throws Exception {
        // given
        interfaceBuilder = provideAssignmentBuilder(Lists.newArrayList(getMockResourceProvider("button"), getMockResourceProvider("view")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo(
                "button = (Button) findViewById(R.id.button);\n" +
                        "button.setOnClickListener(this);\n" +
                "view = (View) findViewById(R.id.view);\n" +
                        "view.setOnClickListener(this);\n"
        );
    }

    private ResourceProvider getMockResourceProvider(String name) {
        ResourceProvider resourceProvider = Mockito.mock(ResourceProvider.class);
        Map<String, String> treeMap = Maps.newTreeMap();
        treeMap.put("RESOURCE_NAME", name);
        treeMap.put("RESOURCE_TYPE", StringUtils.capitalize(name));
        treeMap.put("RESOURCE_ID", "R.id." + name);
        treeMap.put("RESOURCE_ASSIGNMENT", name + ".setOnClickListener(this);\n");
        when(resourceProvider.provideAssignment()).thenReturn(treeMap);
        return resourceProvider;
    }
}