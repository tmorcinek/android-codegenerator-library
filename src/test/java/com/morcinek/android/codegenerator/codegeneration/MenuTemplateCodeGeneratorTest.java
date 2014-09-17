package com.morcinek.android.codegenerator.codegeneration;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.MenuResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.templates.ResourceTemplatesProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MenuTemplateCodeGeneratorTest {

    private TemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private TemplateCodeGenerator templateCodeGenerator;

    @Before
    public void setUp() throws Exception {
        templateCodeGenerator = new TemplateCodeGenerator("Menu_template", new MenuResourceProvidersFactory(), new ResourceTemplatesProvider());
    }

    @Test
    public void produceCreateGameMenuCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(new Resource(new ResourceId("action_done"), new ResourceType("item")));

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "create_game");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/menus/CreateGame.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    @Test
    public void produceGameSessionMenuCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                new Resource(new ResourceId("action_refresh"), new ResourceType("item")),
                new Resource(new ResourceId("action_edit"), new ResourceType("item"))
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "game_session");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/menus/GameSession.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    @Test
    public void produceGamesMenuCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                new Resource(new ResourceId("action_refresh"), new ResourceType("item")),
                new Resource(new ResourceId("action_settings"), new ResourceType("item"))
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "games");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/menus/Games.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }
}