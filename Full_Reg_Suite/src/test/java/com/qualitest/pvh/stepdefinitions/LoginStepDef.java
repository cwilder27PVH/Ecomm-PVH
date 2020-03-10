package com.qualitest.pvh.stepdefinitions;

import com.qualitest.core.page.BasePage;
import com.qualitest.core.uimap.LoginPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class LoginStepDef extends BasePage{
	

	@When("^User clicks on the login button$")
	public void user_clicks_on_the_login_button() throws Throwable 
	{
		new LoginPage().clickLogin();
	}

	@And("^User enters UserID(.*)$")
	public void user_enters_UserID(String userId)
	{
		new LoginPage().enterUserID(userId);	    
	}

	@And("User enters password(.*)")
	public void user_enters_password(String password)
	{
		new LoginPage().enterPassword(password);
	    
	}

}
