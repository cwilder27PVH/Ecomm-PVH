package com.qualitest.pvh.stepdefinitions;

import com.qualitest.core.uimap.UserPreferencesPage;

import cucumber.api.java.en.When;

public class UserPreferencesPageStepDef {

	@When("^User clicks on select avtar$")
	public void user_clicks_selects_avtar() throws Throwable 
	{
			new UserPreferencesPage().selectAvatar();
	}

	@When("^User selects picture for avtar (.*)$$")
	public void user_selects_picture_for_avtar(String picNo) throws Throwable 
	{
			new UserPreferencesPage().selectPicture(picNo);
	}
	
	@When("^User clicks on select my name$")
	public void user_clicks_select_my_name() throws Throwable 
	{
			new UserPreferencesPage().selectMyName();
	}
	
	@When("^User selects country (.*)$$")
	public void user_selects_country(String country) throws Throwable 
	{
	 	new UserPreferencesPage().selectCountry(country);
	}
	
	@When("^User selects notification (.*)$$")
	public void user_selects_notification(String notification) throws Throwable 
	{
	 	new UserPreferencesPage().selectNotification(notification);
	}

	@When("^User clicks update button$")
	public void user_clicks_update_button() throws Throwable 
	{
			new UserPreferencesPage().updateUserPreferenceUpdate();
	}

	@When("^User cancels user preference update$")
	public void user_cancels_user_preference_update() throws Throwable 
	{
			new UserPreferencesPage().cancelUserPreferenceUpdate();
	}

	@When("^User hides unhides user profile section$")
	public void user_hides_unhides_user_profile_section() throws Throwable 
	{
			new UserPreferencesPage().hideUnhideProfileSection();
	}

	@When("^User hides unhides notification section$")
	public void user_hides_unhides_notification_section() throws Throwable 
	{
			new UserPreferencesPage().hideUnhideNotificationSection();
	}

	@When("^User hides unhides account section$")
	public void user_hides_unhides_account_section() throws Throwable 
	{
			new UserPreferencesPage().hideUnhideNotificationSection();
	}
	
	@When("^User enters name (.*)$$")
	public void user_enters_name(String name) throws Throwable 
	{
	 	new UserPreferencesPage().enterName(name);
	}
	
	@When("^User enters address (.*)$$")
	public void user_enters_address(String address) throws Throwable 
	{
	 	new UserPreferencesPage().enterAddress(address);
	}
	
	@When("^User enters city (.*)$$")
	public void user_enters_city(String city) throws Throwable 
	{
	 	new UserPreferencesPage().enterCity(city);
	}
	
	@When("^User enters postal code (.*)$$")
	public void user_enters_state(String zipcode) throws Throwable 
	{
	 	new UserPreferencesPage().enterPostalCode(zipcode);
	}
	
	@When("^User enters home phone number (.*)$$")
	public void user_enters_home_phone_number(String number) throws Throwable 
	{
	 	new UserPreferencesPage().enterHomePhoneNo(number);
	}
	
	@When("^User enters office phone number (.*)$$")
	public void user_enters_office_phone_number(String number) throws Throwable 
	{
	 	new UserPreferencesPage().enterOfficePhoneNo(number);
	}
	
	@When("^User enters home cell number (.*)$$")
	public void user_enters_home_cell_number(String number) throws Throwable 
	{
	 	new UserPreferencesPage().enterCellPhoneNo(number);
	}
	
	@When("^User enters home fax number (.*)$$")
	public void user_enters_home_fax_number(String number) throws Throwable 
	{
	 	new UserPreferencesPage().enterFax(number);
	}
	
	@When("^User edits password (.*)$$")
	public void user_enters_password(String password) throws Throwable 
	{
	 	new UserPreferencesPage().enterUserPassword(password);
	}
	
	@When("^User enters confirm password (.*)$$")
	public void user_enters_confirm_password(String password) throws Throwable 
	{
	 	new UserPreferencesPage().enterConfirmPassword(password);
	}

}
