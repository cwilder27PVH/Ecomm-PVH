package com.qualitest.pvh.hooks;

import com.qualitest.core.page.BasePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.serenitybdd.cucumber.suiteslicing.SerenityTags;

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
