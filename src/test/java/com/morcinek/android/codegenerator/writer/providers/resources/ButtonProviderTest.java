package com.morcinek.android.codegenerator.writer.providers.resources;

import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import com.morcinek.android.codegenerator.writer.providers.generic.ResourceProvider;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class ButtonProviderTest {

    private ResourceProvider resourceProvider;

    @Before
    public void setUp() throws Exception {
        resourceProvider = new ButtonProvider(new Resource(new ResourceId("button"), new ResourceType("Button")));
    }

    @Test
    public void provideImportTest() throws Exception {
        Assertions.assertThat(resourceProvider.provideImport()).isNull();
    }

    @Test
    public void provideInterfaceTest() throws Exception {
        Assertions.assertThat(resourceProvider.provideInterface()).hasSize(1).contains("OnClickListener");
    }

    @Test
    public void provideFieldSimpleTest() throws Exception {
        // given
        resourceProvider = new ButtonProvider(new Resource(new ResourceId("button"), new ResourceType("Button")));

        // when
        Map<String, String> values = resourceProvider.provideField();

        // then
        Assertions.assertThat(values.get("RESOURCE_ID")).isNotNull().isEqualTo("R.id.button");
        Assertions.assertThat(values.get("RESOURCE_TYPE")).isNotNull().isEqualTo("Button");
        Assertions.assertThat(values.get("RESOURCE_NAME")).isNotNull().isEqualTo("button");
    }

    @Test
    public void provideFieldAdvancedTest() throws Exception {
        // given
        resourceProvider = new ButtonProvider(new Resource(new ResourceId("done_button"), new ResourceType("Button")));

        // when
        Map<String, String> values = resourceProvider.provideField();

        // then
        Assertions.assertThat(values.get("RESOURCE_ID")).isNotNull().isEqualTo("R.id.done_button");
        Assertions.assertThat(values.get("RESOURCE_TYPE")).isNotNull().isEqualTo("Button");
        Assertions.assertThat(values.get("RESOURCE_NAME")).isNotNull().isEqualTo("doneButton");
    }

    @Test
    public void provideFieldAdvanced2Test() throws Exception {
        // given
        resourceProvider = new ButtonProvider(new Resource(new ResourceId("done_job_button"), new ResourceType("Button")));

        // when
        Map<String, String> values = resourceProvider.provideField();

        // then
        Assertions.assertThat(values.get("RESOURCE_ID")).isNotNull().isEqualTo("R.id.done_job_button");
        Assertions.assertThat(values.get("RESOURCE_TYPE")).isNotNull().isEqualTo("Button");
        Assertions.assertThat(values.get("RESOURCE_NAME")).isNotNull().isEqualTo("doneJobButton");
    }

    @Test
    public void provideFieldNamespaceIdTest() throws Exception {
        // given
        ResourceId resourceId = new ResourceId("list");
        resourceId.setNamespace("android");
        resourceProvider = new ButtonProvider(new Resource(resourceId, new ResourceType("List")));

        // when
        Map<String, String> values = resourceProvider.provideField();

        // then
        Assertions.assertThat(values.get("RESOURCE_ID")).isNotNull().isEqualTo("android.R.id.list");
        Assertions.assertThat(values.get("RESOURCE_TYPE")).isNotNull().isEqualTo("List");
        Assertions.assertThat(values.get("RESOURCE_NAME")).isNotNull().isEqualTo("list");
    }
}