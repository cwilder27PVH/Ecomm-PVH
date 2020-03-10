package com.qualitest.pvh.stepdefinitions;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.uimap.LoginPage;
import com.qualitest.core.util.EnvConfig;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Steps;

public class BackGround extends PageObject{
	
	private static final EnvConfig ENV = ConfigFactory.create(EnvConfig.class);
	private static final Logger LOGGER = LoggerFactory.getLogger(BackGround.class);

	@Steps 
	THActor thUser;
	
	@Given("^User opens the website$")
	public void user_opens_the_website() throws Throwable 
	{
		
		  LOGGER.info("Launching Visulon website"); 
		  LOGGER.info(ENV.visulonqaurl());
		  openUrl(ENV.visulonqaurl());
	}
	
	@When("^User navigates to login page$")
	public void user_navigates_to_login_page() throws Throwable 
	{
		LOGGER.info("Navigating to Login Page");
		Thread.sleep(5000);
		new LoginPage().navigateToTommy();
		//LoginPage page = new LoginPage();
		//LOGGER.info("Page title: " + page.getTitle());
		//thUser.navigateToTH();
		
	}


}
