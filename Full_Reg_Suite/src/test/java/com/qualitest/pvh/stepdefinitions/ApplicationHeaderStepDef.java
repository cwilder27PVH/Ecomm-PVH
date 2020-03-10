package com.qualitest.pvh.stepdefinitions;

import com.qualitest.core.uimap.ApplicationHeader;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ApplicationHeaderStepDef {
	  
    
	@When("^User clicks Home icon$")
	public void user_clicks_home_icon() throws Throwable 
	{
			new ApplicationHeader().clickHomeIcon();
	   
	}

	@When("^User navigates to Account Settings$")
	public void user_navigates_to_login_page() throws Throwable 
	{
			new ApplicationHeader().navigateToAccountSettings();
	}

	@When("^User navigates to Change Password$")
	public void user_navigates_to_change_password() throws Throwable 
	{
			new ApplicationHeader().navigateChangePassword();
	}

	@When("^User logs out of the application$")
	public void user_logs_out() throws Throwable 
	{
			new ApplicationHeader().logOut();
	}

	@When("^User clicks on the notification$")
	public void user_clicks_on_notification() throws Throwable 
	{
			new ApplicationHeader().clickNotificationIcon();
	}


	@When("^User closes the notification window$")
	public void user_closes_notification_window() throws Throwable 
	{
			new ApplicationHeader().closeNotificationIcon();
	}


	@When("^User clicks on the imported plans icon$")
	public void user_clicks_on_imported_plans_icon() throws Throwable 
	{
			new ApplicationHeader().clickImportedPlansIcon();
	}


	@And("^User clicks to close imported plans$")
	public void user_closes_imported_plans_icon() throws Throwable 
	{
			new ApplicationHeader().closeImportedPlansIcon();
	}


	@Then("^User verifies welcome username (.*)$")
	public void user_verifies_welcome_username(String name) throws Throwable 
	{
			new ApplicationHeader().verifyWelcomeUserName(name);
	}

}
