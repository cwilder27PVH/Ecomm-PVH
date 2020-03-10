package com.qualitest.pvh.teststeps;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.PBActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;


public class BackgroundSteps {

		@Steps
		CKActor ckUser;

		@Steps 
		THActor thUser;

		@Steps
		SpeedoActor spUser;
		
		@Steps
		PBActor pbUser;
		
		@Steps
		SpeedoActor speedoUser;
		
		private static final Logger LOGGER = LoggerFactory.getLogger(BackgroundSteps.class);
		
		@Given("^User navigates to Heritage Brands Webstore")
		public void user_wants_to_access_HeritageBrands() {
			LOGGER.info("Starting test session for Heritage Brands");	
			Serenity.setSessionVariable("brand").to("VH");
			pbUser.navigateToVH();		
		}
		
		@Given("^User navigates to Speedo Webstore")
		public void user_wants_to_access_Speedo() {
			LOGGER.info("Starting test session for Speedo");	
			Serenity.setSessionVariable("brand").to("SPEEDO");
			spUser.navigateToSP();		
		}
		
		@Given("^User navigates to Calvin Klein CA Webstore")
		public void user_wants_to_access_CalvinKleinCA() {
			LOGGER.info("Starting test session for CKCA");	
			Serenity.setSessionVariable("brand").to("CKCA");
			ckUser.navigateToCKCA();		
		}
		
		@Given("^User navigates to Calvin Klein US Webstore")
		public void user_wants_to_access_CalvinKleinUS() {
			LOGGER.info("Starting test session for CK");	
			Serenity.setSessionVariable("brand").to("CKUS");
			ckUser.navigateToCK();		
		}
		
		@Given("^User navigates to Tommy Hilfiger Webstore")
		public void user_wants_to_access_TommyHilfiger() {
			LOGGER.info("Starting test session for TH");			
			Serenity.setSessionVariable("brand").to("TH");
			thUser.navigateToTH();			
		}
		
		@When("^User clicks on signin from header for HB$")
		public void user_clicks_signin_HBHeader() {
			LOGGER.info("Navigating to Heritage Signin page...");		
				pbUser.clickSignIn();
			}
		
		@When("^User clicks on signin from header for SP$")
		public void user_clicks_signin_SPHeader() {
			LOGGER.info("Navigating to Speedo Signin page...");		
				spUser.clickSignIn();
				
			}
		
		@When("^User clicks on signin from header for CKCA$")
		public void user_clicks_signin_CKCAHeader() {
			LOGGER.info("Navigating to CKCA Signin page...");		
				ckUser.clickSignIn();
			}
		
		@When("^User clicks on signin from header for CK$")
		public void user_clicks_signin_CKHeader() {
			LOGGER.info("Navigating to CK Signin page...");		
				ckUser.clickSignIn();
			}
		
		@When("^User clicks on signin from header for TH$")
		public void user_clicks_signin_THHeader() {
			LOGGER.info("Navigating to TH Signin page...");		
				thUser.clickSignIn();
			}
		
		
		
}
