package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.PBActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class LoginTestSteps {

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;
	
	@Steps
	PBActor pbUser;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginTestSteps.class);

	@Given("^User access (.*) website$")
	public void user_wants_to_access_brand(String brand) {
		LOGGER.info("Starting test session for Brand: " + brand + "...");
		Serenity.setSessionVariable("brand").to(brand);

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateTo(brand);
			break;
		case "TH":
			thUser.navigateTo();
			break;
		case "SPEEDO":
			speedoUser.navigateTo();
			break;	
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateTo(brand);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@When("^User navigate to mobile login page$")
	public void user_accessing_login_pageMobile() {
		LOGGER.info("Navigating to LogIn page...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.mobileSignIn();
			break;
		case "TH":
			thUser.mobileSignIn();
			break;
		case "SPEEDO":
			speedoUser.mobileSignIn();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.mobileSignIn();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@When("^User navigate to login page$")
	public void user_accessing_login_page() {
		LOGGER.info("Navigating to LogIn page...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.clickSignIn();
			break;
		case "TH":
			thUser.clickSignIn();
			break;
		case "SPEEDO":
			speedoUser.clickSignIn();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.clickSignIn();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User try to login using (.*) and (.*)$")
	public void user_try_to_login(String email, String password) {
		LOGGER.info("Signing in...");
		String brand = Serenity.sessionVariableCalled("brand");
		Serenity.setSessionVariable("email").to(email);
		Serenity.setSessionVariable("password").to(password);

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.accountSignIn(email, password);
			break;
		case "TH":
			thUser.accountSignIn(email, password);
			break;
		case "SPEEDO":
			speedoUser.accountSignIn(email, password);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.accountSignIn(email, password);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@And("^User try to login using old password$")
	public void user_try_to_login_using_old_password() {
		LOGGER.info("Signing in using old password...");
		String brand = Serenity.sessionVariableCalled("brand");
		String email = Serenity.sessionVariableCalled("email");
		String password = Serenity.sessionVariableCalled("password");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.accountSignInWithNewPassword(email, password);
			break;
		case "TH":
			thUser.accountSignInWithNewPassword(email, password);
			break;
		case "SPEEDO":
			speedoUser.accountSignInWithNewPassword(email, password);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.accountSignInWithNewPassword(email, password);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}
	@And("^User try to login using new password$")
	public void user_try_to_login_using_new_password() {
		LOGGER.info("Signing in using old password...");
		String brand = Serenity.sessionVariableCalled("brand");
		String email = Serenity.sessionVariableCalled("email");
		String newPassword = Serenity.sessionVariableCalled("newPassword");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.accountSignInWithNewPassword(email, newPassword);
			break;
		case "TH":
			thUser.accountSignInWithNewPassword(email, newPassword);
			break;
		case "SPEEDO":
			speedoUser.accountSignInWithNewPassword(email, newPassword);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.accountSignInWithNewPassword(email, newPassword);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@Then("^User should be login successfully$")
	public void verify_user_is_loggedIn() {
		LOGGER.info("Verifying LogIn is successful...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyLoginIsSuccessful();
			break;
		case "TH":
			thUser.verifyLoginIsSuccessful();
			break;
		case "SPEEDO":
			speedoUser.verifyLoginIsSuccessful();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyLoginIsSuccessful();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User should get error message (.*)$")
	public void user_should_get_error_message(String error) {
		LOGGER.info("Verifying error message...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyLoginError(error);
			break;
		case "TH":
			thUser.verifyLoginError(error);
			break;
		case "SPEEDO":
			speedoUser.verifyLoginError(error);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyLoginError(error);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User reset password (.*)$")
	public void user_reset_password(String newPassword) {
		LOGGER.info("Resetting password and Logging Out...");
		String brand = Serenity.sessionVariableCalled("brand");
		String email = Serenity.sessionVariableCalled("email");
		String password = Serenity.sessionVariableCalled("password");

		switch (brand) {
		case "CKUS":
  	    case "CKCA":
			ckUser.resetPassword(brand, email, password, newPassword);
			ckUser.logOut();
			break;
		case "TH":
			thUser.resetPassword(brand, email, password, newPassword);
			thUser.logOut();
			break;
		case "SPEEDO":
			speedoUser.resetPassword(brand, email, password, newPassword);
			speedoUser.logOut();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.resetPasswordPB(brand, email, password, newPassword);
			pbUser.logOut();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}



	@And("^User reset mobile password (.*)$")
	public void user_reset_mobile_password(String newPassword) {
		LOGGER.info("Resetting password and Logging Out...");
		String brand = Serenity.sessionVariableCalled("brand");
		String email = Serenity.sessionVariableCalled("email");
		String password = Serenity.sessionVariableCalled("password");

		switch (brand) {
		case "CKUS":
  	    case "CKCA":
			ckUser.mobileResetPassword(brand, email, password, newPassword);
			ckUser.mobileLogOut();
			break;
		case "TH":
			thUser.mobileResetPassword(brand, email, password, newPassword);
			thUser.mobileLogOut();
			break;
		case "SPEEDO":
			speedoUser.mobileResetPassword(brand, email, password, newPassword);
			speedoUser.mobileLogOut();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.mobileResetPassword(brand, email, password, newPassword);
			pbUser.mobileLogOut();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

		@And("^User login using (.*) and (.*) more then (.*) times$")
	public void user_login_more_than_5_times(String email, String password, int numOfTimes) {
		LOGGER.info("Signing in more then " + numOfTimes + " times...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.signInWithInvalidPasswordCKUS(email, password, numOfTimes);
			break;
		case "CKCA":
			ckUser.signInWithInvalidPassword(email, password, numOfTimes);
			break;
		case "TH":
			thUser.signInWithInvalidPassword(email, password, numOfTimes);
			break;
		case "SPEEDO":
			speedoUser.signInWithInvalidPassword(email, password, numOfTimes);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.signInWithInvalidPasswordCKUS(email, password, numOfTimes);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
		
	@And("^User logs out if already logged in")
	public void user_logs_out_if_logged_in() {
		LOGGER.info("Checking if user is already logged in.");
	
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			if(ckUser.isSignedIn()) {
				ckUser.logOut();
			}
			break;
		case "TH":
			if(thUser.isSignedIn()) {
				thUser.logOut();
			}
			break;
		case "SPEEDO":
			if(speedoUser.isSignedIn()) {
				speedoUser.logOut();
			}
			break;
		case "VH":
		case "IZ":
		case "SB":
			if(pbUser.isSignedIn()) {
				pbUser.logOut();
			}
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
		

}