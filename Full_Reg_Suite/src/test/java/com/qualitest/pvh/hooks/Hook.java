package com.qualitest.pvh.hooks;

import com.qualitest.core.page.BasePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.core.SerenitySystemProperties;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;
import net.thucydides.core.ThucydidesSystemProperty;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class Hook extends BasePage {
	
	@Before
    public void before() {
        SerenityTags.create().tagScenarioWithBatchingInfo();
    }
	
    @After
    public void sessionQuit() {
        getDriver().quit();
    }
}
