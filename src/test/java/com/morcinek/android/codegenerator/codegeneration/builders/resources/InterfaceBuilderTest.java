package com.morcinek.android.codegenerator.codegeneration.builders.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.codegeneration.providers.generic.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.ResourceTemplatesProvider;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

public class InterfaceBuilderTest {

    private ResourceTemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private ResourceCodeBuilder interfaceBuilder;

    private ResourceCodeBuilder provideFieldsBuilder(List<ResourceProvider> resourceProviders) {
        return new InterfaceBuilder(resourceProviders, templatesProvider);
    }

    @Test
    public void builtOnClickListenerStringTest() throws Exception {
        // given
        interfaceBuilder = provideFieldsBuilder(Lists.newArrayList(getMockResourceProvider("OnClickListener")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("implements OnClickListener");
    }

    @Test
    public void builtNoStringTest() throws Exception {
        // given
        ResourceProvider resourceProvider = Mockito.mock(ResourceProvider.class);
        when(resourceProvider.provideInterface()).thenReturn(null);
        interfaceBuilder = provideFieldsBuilder(Lists.newArrayList(resourceProvider));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("");
    }

    @Test
    public void builtAdvancedStringTest() throws Exception {
        // given
        ResourceProvider buttonResourceProvider = getMockResourceProvider("OnClickListener");
        ResourceProvider checkBoxResourceProvider = getMockResourceProvider("OnValueChanged");
        interfaceBuilder = provideFieldsBuilder(Lists.newArrayList(buttonResourceProvider, checkBoxResourceProvider));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("implements OnClickListener, OnValueChanged");
    }

    private ResourceProvider getMockResourceProvider(String interfaceName) {
        ResourceProvider resourceProvider = Mockito.mock(ResourceProvider.class);
        when(resourceProvider.provideInterface()).thenReturn(Sets.newHashSet(interfaceName));
        return resourceProvider;
    }
}