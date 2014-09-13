package com.morcinek.android.codegenerator.writer.builders.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import org.fest.assertions.Assertions;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class InterfaceBuilderTest {

    private ResourceCodeBuilder interfaceBuilder;

    @Test
    public void builtOnClickListenerStringTest() throws Exception {
        // given
        interfaceBuilder = new InterfaceBuilder();
        interfaceBuilder.processResourceProviders(Lists.newArrayList(getMockResourceProvider("OnClickListener")));

        // when
        String value = interfaceBuilder.builtString();

        // then
        Assertions.assertThat(value).isNotNull().isEqualTo("implements OnClickListener");
    }

    @Test
    public void builtAdvancedStringTest() throws Exception {
        // given
        interfaceBuilder = new InterfaceBuilder();
        ResourceProvider buttonResourceProvider = getMockResourceProvider("OnClickListener");
        ResourceProvider checkBoxResourceProvider = getMockResourceProvider("OnValueChanged");
        interfaceBuilder.processResourceProviders(Lists.newArrayList(buttonResourceProvider, checkBoxResourceProvider));

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