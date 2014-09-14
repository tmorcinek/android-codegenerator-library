package com.morcinek.android.codegenerator.writer.templates;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class TemplateManagerTest {

    @Test
    public void getTemplateTest() throws Exception {
        // given
        String template = "${RESOURCE_NAME} = (${RESOURCE_TYPE}) findViewById(${RESOURCE_ID});";
        TemplateManager templateManager = new TemplateManager(template);

        // when
        templateManager.addTemplateValue("RESOURCE_NAME", "doneButton");
        templateManager.addTemplateValue("RESOURCE_TYPE", "Button");
        templateManager.addTemplateValue("RESOURCE_ID", "R.id.done_button");

        // then
        String result = templateManager.getTemplate();
        Assertions.assertThat(result).isNotNull().isEqualTo("doneButton = (Button) findViewById(R.id.done_button);");
    }

    @Test
    public void getEmptyTemplateTest() throws Exception {
        // given
        String template = "${RESOURCE_NAME}";
        TemplateManager templateManager = new TemplateManager(template);

        // when
        // then
        String templateManagerTemplate = templateManager.getTemplate();
        Assertions.assertThat(templateManagerTemplate).isNotNull().isEmpty();
    }

    @Test
    public void getMixedTemplateTest() throws Exception {
        // given
        String template = "${RESOURCE_NAME} = (${RESOURCE_TYPE})";
        TemplateManager templateManager = new TemplateManager(template);

        // when
        templateManager.addTemplateValue("RESOURCE_NAME", "doneButton");

        // then
        String templateManagerTemplate = templateManager.getTemplate();
        Assertions.assertThat(templateManagerTemplate).isNotNull().isEqualTo("doneButton = ()");
    }
}