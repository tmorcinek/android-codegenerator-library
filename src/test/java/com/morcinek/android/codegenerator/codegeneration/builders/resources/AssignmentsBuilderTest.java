package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.ResourceTemplatesProvider;
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
    public void builtButtonFieldString() throws Exception {
        // given
        interfaceBuilder = provideAssignmentBuilder(Lists.newArrayList(getMockResourceProvider("button", "Button")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("        findViewById(R.id.button).setOnClickListener(this);\n");
    }

    @Test
    public void builtViewFieldString() throws Exception {
        // given
        interfaceBuilder = provideAssignmentBuilder(Lists.newArrayList(getMockResourceProvider("view", "")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("        view = (View) findViewById(R.id.view);\n");
    }

    @Test
    public void builtTwoFieldString() throws Exception {
        // given
        interfaceBuilder = provideAssignmentBuilder(Lists.newArrayList(getMockResourceProvider("button", "Button"), getMockResourceProvider("view", "")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo(
                "        findViewById(R.id.button).setOnClickListener(this);\n" +
                        "        view = (View) findViewById(R.id.view);\n"
        );
    }

    private ResourceProvider getMockResourceProvider(String name, String assignment) {
        ResourceProvider resourceProvider = Mockito.mock(ResourceProvider.class);
        Map<String, String> treeMap = Maps.newHashMap();
        treeMap.put("RESOURCE_NAME", name);
        treeMap.put("RESOURCE_TYPE", StringUtils.capitalize(name));
        treeMap.put("RESOURCE_ID", "R.id." + name);
        when(resourceProvider.provideValues()).thenReturn(treeMap);
        when(resourceProvider.provideAssignment()).thenReturn(Sets.newHashSet(assignment));
        return resourceProvider;
    }
}