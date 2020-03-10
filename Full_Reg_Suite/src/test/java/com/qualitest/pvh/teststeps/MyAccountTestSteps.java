package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.PBActor;
import com.qualitest.pvh.actors.PaypalActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class MyAccountTestSteps { 
	
	@Steps
	CKActor ckUser;
	
	@Steps
	THActor thUser;
	
	@Steps
	SpeedoActor speedoUser;
	
	@Steps
	PaypalActor ppUser;
	
	@Steps
	PBActor pbUser;
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(MyAccountTestSteps.class);
	
	@And("^User edits personal (.*)$")
	public void user_edits_personal_information(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editPersonalInformation(infoFields);
			break;
		case "TH":
			thUser.editPersonalInformation(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editPersonalInformation(infoFields);
			break;
		case "VH":
		case "IZ":
		case "SP":
			pbUser.editPersonalInformation(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User edits mobile personal (.*)$")
	public void user_edits_mobile_personal_information(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editPersonalInformationOnMobile(infoFields);
			break;
		case "TH":
			thUser.editPersonalInformationOnMobile(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editPersonalInformationOnMobile(infoFields);
			break;
		case "VH":
		case "IZ":
		case "SP":
			pbUser.editPersonalInformationOnMobile(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@And("^User uses addressy on mobile to edit personal (.*)$")
	public void user_uses_addressyon_mobile_to_edit_personal_information(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editPersonalInformationWithAddressyOnMobile(infoFields);
			break;
		case "TH":
			thUser.editPersonalInformationWithAddressyOnMobile(infoFields);
			break;
		case "VH":
		case "IZ":
		case "SP":
			pbUser.editPersonalInformationWithAddressyOnMobile(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}	

		
	@And("^User uses addressy to edit personal (.*)$")
	public void user_uses_addressy_to_edit_personal_information(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editPersonalInformationWithAddressy(infoFields);
			break;
		case "TH":
			thUser.editPersonalInformationWithAddressy(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editPersonalInformation(infoFields);
			break;
		case "VH":
		case "IZ":
		case "SP":
			pbUser.editPersonalInformationWithAddressy(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And ("^User navigates to checkout preferences$")
	public void user_navigates_to_checkout_preferences() {
	}
	
	@And ("^User navigates my address book$")
	public void user_navigates_to_address_book() {
	}
	
	@Then("^User verifies personal information updated successfully$")
	public void user_verifies_personal_information_updated() {
		LOGGER.info("Verifying personal information updated...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationUpdated();
			break;
		case "TH":
			thUser.verifyPersonalInformationUpdated();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationUpdated();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPersonalInformationUpdated();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	
	@Then("^User verifies error on account page (.*)$")
	public void user_verifies_error_on_account_page(String error) {
		LOGGER.info("User verifies error on account page...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPageLevelErrorOnEditAccount(error);
			break;
		case "TH":
			thUser.verifyPageLevelErrorOnEditAccount(error);
			break;
		case "SPEEDO":
			speedoUser.verifyPageLevelErrorOnEditAccount(error);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPageLevelErrorOnEditAccount(error);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	
	
	
	@And("User edits checkout preferences (.*)$")
	public void user_edits_checkout_preferences(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToCheckoutPreferences();
			ckUser.editCheckoutInformation(infoFields);
			ckUser.saveCheckoutInformation();
			break;
		case "TH":
			thUser.navigateToCheckoutPreferences();
			thUser.editCheckoutInformation(infoFields);
			thUser.saveCheckoutInformation();
			break;
		case "SPEEDO":
			speedoUser.navigateToCheckoutPreferences();
			speedoUser.editCheckoutInformation(infoFields);
			speedoUser.saveCheckoutInformation();
			break;
		case "VH":
		case "IZ":
		case "SB":
			thUser.navigateToCheckoutPreferences();
			pbUser.editCheckoutInformation(infoFields);
			pbUser.saveCheckoutInformation();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User edits mobile checkout preferences (.*)$")
	public void user_edits_mobile_checkout_preferences(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMobileCheckoutPreferences();
			ckUser.editCheckoutInformation(infoFields);
			ckUser.saveCheckoutInformation();
			break;
		case "TH":
			thUser.navigateToMobileCheckoutPreferences();
			thUser.editCheckoutInformation(infoFields);
			thUser.saveCheckoutInformation();
			break;
		case "SPEEDO":
			speedoUser.navigateToMobileCheckoutPreferences();
			speedoUser.editCheckoutInformation(infoFields);
			speedoUser.saveCheckoutInformation();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMobileCheckoutPreferences();
			pbUser.editCheckoutInformation(infoFields);
			pbUser.saveCheckoutInformation();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User uses addressy to edit checkout preferences (.*)$")
	public void user_uses_addressy_to_edit_checkout_preferences(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToCheckoutPreferences();
			ckUser.editCheckoutInformationWithAddressySelection(infoFields);
			ckUser.saveCheckoutInformation();
			break;
		case "TH":
			thUser.navigateToCheckoutPreferences();
			thUser.editCheckoutInformationWithAddressySelection(infoFields);
			thUser.saveCheckoutInformation();
			break;
		case "SPEEDO":
			speedoUser.navigateToCheckoutPreferences();
			speedoUser.editCheckoutInformationWithAddressySelection(infoFields);
			speedoUser.saveCheckoutInformation();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToCheckoutPreferences();
			pbUser.editCheckoutInformationWithAddressySelection(infoFields);
			pbUser.saveCheckoutInformation();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User uses addressy on mobile to edit checkout preferences (.*)$")
	public void user_uses_addressy_on_mobile_to_edit_checkout_preferences(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMobileMyAccount();
			ckUser.navigateToMobileCheckoutPreferences();
			ckUser.editCheckoutInformationWithAddressySelectionOnMobile(infoFields);
			ckUser.saveCheckoutInformation();
			break;
		case "TH":
			thUser.navigateToMobileMyAccount();
			thUser.navigateToMobileCheckoutPreferences();
			thUser.editCheckoutInformationWithAddressySelectionOnMobile(infoFields);
			thUser.saveCheckoutInformation();
			break;
		case "SPEEDO":
			speedoUser.navigateToMobileMyAccount();
			speedoUser.navigateToMobileCheckoutPreferences();
			speedoUser.editCheckoutInformationWithAddressySelectionOnMobile(infoFields);
			speedoUser.saveCheckoutInformation();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMobileMyAccount();
			pbUser.navigateToMobileCheckoutPreferences();
			pbUser.editCheckoutInformationWithAddressySelectionOnMobile(infoFields);
			pbUser.saveCheckoutInformation();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@And("User edits billing checkout preferences (.*)$")
	public void user_edits_billing_checkout_preferences(String infoFields) {
		LOGGER.info("Editing address information...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editBillingCheckoutInformation(infoFields);
			ckUser.saveCheckoutInformation();
			break;
		case "TH":
			thUser.editBillingCheckoutInformation(infoFields);
			thUser.saveCheckoutInformation();
			break;
		case "SPEEDO":
			speedoUser.editBillingCheckoutInformation(infoFields);
			speedoUser.saveCheckoutInformation();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.editBillingCheckoutInformation(infoFields);
			pbUser.saveCheckoutInformation();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@Then("^User verifies checkout preferences updated$")
	public void user_verifies_checkout_preferences_updated() {
		LOGGER.info("Verifying checkout preferences updated...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyCheckoutPreUpdate();
			break;
		case "TH":
			thUser.verifyCheckoutPreUpdate();
			break;
		case "SPEEDO":
			speedoUser.verifyCheckoutPreUpdate();
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyCheckoutPreUpdate();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User adds checkout preferences with (.*)$")
	public void user_adds_checkout_preferences(String information) {
		LOGGER.info("Adding checkout preferences...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationUpdated();
			break;
		case "TH":
			thUser.verifyPersonalInformationUpdated();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationUpdated();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPersonalInformationUpdated();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User adds shipping address with valid (.*)$")
	public void user_adds_shipping_address(String values) {
		LOGGER.info("Adding shipping address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMyAccount();
			ckUser.navigateToAddressBook();
			ckUser.addShippingAddress(values);
			break;
		case "TH":
			thUser.navigateToMyAccount();
			thUser.navigateToAddressBook();
			thUser.addShippingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToMyAccount();
			speedoUser.navigateToAddressBook();
			speedoUser.addShippingAddress(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMyAccount();
			pbUser.navigateToAddressBook();
			pbUser.addShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@And("^User adds shipping address on mobile with valid (.*)$")
	public void user_adds_shipping_address_on_mobile(String values) {
		LOGGER.info("Adding shipping address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMobileMyAccount();
			ckUser.navigateToAddressBook();
			ckUser.addShippingAddressOnMobile(values);
			break;
		case "TH":
			thUser.navigateToMobileMyAccount();
			thUser.navigateToAddressBook();
			thUser.addShippingAddressOnMobile(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToMobileMyAccount();
			speedoUser.navigateToAddressBook();
			speedoUser.addShippingAddress(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMobileMyAccount();
			pbUser.navigateToAddressBook();
			pbUser.addShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User uses addressy to add shipping address with valid (.*)$")
	public void user_uses_addressy_to_add_shipping_address(String values) {
		LOGGER.info("Adding shipping address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			//ckUser.navigateToMyAccount();
			ckUser.navigateToAddressBook();
			ckUser.addShippingAddressWithAddressySelection(values);
			break;
		case "TH":
			thUser.navigateToMyAccount();
			thUser.navigateToAddressBook();
			thUser.addShippingAddressWithAddressySelection(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToMyAccount();
			speedoUser.navigateToAddressBook();
			speedoUser.addShippingAddressWithAddressySelection(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMyAccount();
			pbUser.navigateToAddressBook();
			pbUser.addShippingAddressWithAddressySelection(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("^User verifies new address was added$")
	public void user_verifies_new_shipping_address() {
		LOGGER.info("Verifying new address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyAddressAdded();
			break;
		case "TH":
			thUser.verifyAddressAdded();
			break;
		case "SPEEDO":
			speedoUser.verifyAddressAdded();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyAddressAdded();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@And("^User adds billing address with valid (.*)$")
	public void user_adds_billing_address(String values) {
		LOGGER.info("Adding new billing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMyAccount();
			ckUser.navigateToAddressBook();
			ckUser.addBillingAddress(values);
			break;
		case "TH":
			thUser.navigateToMyAccount();
			thUser.navigateToAddressBook();
			thUser.addBillingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToMyAccount();
			speedoUser.navigateToAddressBook();
			speedoUser.addBillingAddress(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMyAccount();
			pbUser.navigateToAddressBook();
			pbUser.addBillingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User adds billing address on mobile with valid (.*)$")
	public void user_adds_billing_address_on_mobile(String values) {
		LOGGER.info("Adding new billing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMobileMyAccount();
			ckUser.navigateToAddressBook();
			ckUser.addBillingAddress(values);
			break;
		case "TH":
			thUser.navigateToMobileMyAccount();
			thUser.navigateToAddressBook();
			thUser.addBillingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToMobileMyAccount();
			speedoUser.navigateToAddressBook();
			speedoUser.addBillingAddress(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMobileMyAccount();
			pbUser.navigateToAddressBook();
			pbUser.addBillingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User updates billing fields on account page (.*)$")
	public void user_updates_billing_fields_on_account_page(String values) {
		LOGGER.info("User updates billing fields on account page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.updateBillingAddress(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.updateBillingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.updateBillingAddress(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToAddressBook();
			pbUser.updateBillingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		} 
	}
	
	
	
	@Then("^User verifies existing address has been updated$")
	public void user_verifies_existing_billing_address_has_been_updated() {
		LOGGER.info("User verifies existing address has been updated...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyUpdateAddress();
			break;
		case "TH":
			thUser.verifyUpdateAddress();
			break;
		case "SPEEDO":
			speedoUser.verifyUpdateAddress();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyUpdateAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		} 
	}
		
	@And("^User adds shipping and billing address with valid (.*)$")
	public void user_adds_shipping_and_billing_address(String values) {
		LOGGER.info("Adding new shipping and billing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.addShippingAndBillingAddress(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.addShippingAndBillingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.addShippingAndBillingAddress(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToAddressBook();
			pbUser.addShippingAndBillingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
@And("^User adds shipping and billing address on mobile with valid (.*)$")
public void user_adds_shipping_and_billing_address_on_mobile(String values) {
	LOGGER.info("Adding new shipping and billing address...");
	String brand = Serenity.sessionVariableCalled("brand");
	
	switch (brand.toUpperCase()) {
	case "CKUS":
	case "CKCA":
		ckUser.navigateToAddressBook();
		ckUser.addShippingAndBillingAddress(values);
		break;
	case "TH":
		thUser.navigateToAddressBook();
		thUser.addShippingAndBillingAddress(values);
		break;
	case "SPEEDO":
		speedoUser.navigateToAddressBook();
		speedoUser.addShippingAndBillingAddress(values);
		break;
	case "VH":
	case "IZ":
	case "SB":
		pbUser.navigateToAddressBook();
		pbUser.addShippingAndBillingAddress(values);
		break;
	default:
		LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
	}
}
	@And("^User adds default shipping and billing address with valid (.*)$")
	public void user_adds_default_shipping_and_billing_address(String values) {
		LOGGER.info("Adding new shipping and billing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			break;
		case "TH":
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.addDefaultShippingAndBillingAddress(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	
	@And("^User updates shipping and billing fields (.*)$")
	public void user_updates_shipping_and_billing_fields(String values) {
		LOGGER.info("User updates shipping and billing fields...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.updateBillingAndShippingAddress(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.updateBillingAndShippingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.updateBillingAndShippingAddress(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToAddressBook();
			pbUser.updateBillingAndShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User inputs shipping and billing (.*) four times")
	public void user_inputs_shipping_and_billing_four_times(String values) {
		LOGGER.info("User inputs shipping and billing four times...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.updateBillingAndShippingAddressFourTimes(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.updateBillingAndShippingAddressFourTimes(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.updateBillingAndShippingAddressThreeTimes(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToAddressBook();
			pbUser.updateBillingAndShippingAddressFourTimes(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
	
	@And("^User inputs billing (.*) four times to update$")
	public void user_inputs_billing_info_four_times(String values) {
		LOGGER.info("User inputs billing four times to update...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.enterUpdateBillingAddressFieldsFourTimes(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.enterUpdateBillingAddressFieldsFourTimes(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.enterUpdateBillingAddressFieldsThreeTimes(values);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToAddressBook();
			pbUser.enterUpdateBillingAddressFieldsThreeTimes(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
	
	
	@And("^User inputs shipping data (.*) four times$")
	public void user_inputs_shipping_data_four_times(String values) {
		LOGGER.info("And User inputs shipping data <information> three times...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.enterUpdateShippingAddressFieldsFourTimes(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.enterUpdateShippingAddressFieldsFourTimes(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.enterUpdateShippingAddressFieldsFourTimes(values);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.navigateToAddressBook();
			pbUser.enterUpdateShippingAddressFieldsFourTimes(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	

	@Then("^User verifies updated address with an error on address book$")
	public void user_verifies_updated_address_with_an_error_on_address_book() {
		LOGGER.info("User verifies updated address with an error on address book...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyUpdatedInvalidAddressAddressBook();
			break;
		case "TH":
			thUser.verifyUpdatedInvalidAddressAddressBook();
			break;
		case "SPEEDO":
			speedoUser.verifyUpdatedInvalidAddressAddressBook();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyUpdatedInvalidAddressAddressBook();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User adds invalid address clicks update four times (.*)$")
	public void user_adds_invalid_address(String values) {
		LOGGER.info("Adding new shipping and billing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.addInvalidShippingAddress(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.addInvalidShippingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.addInvalidShippingAddress(values);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.navigateToAddressBook();
			pbUser.addInvalidShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, IZ, SB, VH");
		}
	}
		
		
		
	@And("^User removes an address from address book$")
	public void user_removes_address() {
		LOGGER.info("Removing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.removeSavedAddress();
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.removeSavedAddress();
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.removeSavedAddress();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToAddressBook();
			pbUser.removeSavedAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("^User verifies address has been added$")
	public void user_verifies_address_has_been_added() {
		LOGGER.info("Verifying new invalid address added...");
	String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyInvalidAddressAdded();
			break;
		case "TH":
			thUser.verifyInvalidAddressAdded();
			break;
		case "SPEEDO":
			speedoUser.verifyInvalidAddressAdded();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User adds a new billing address and submits four times (.*)$")
	public void user_adds_a_new_billing_address_and_submits_four_times(String guestInformation) {
		LOGGER.info("And User adds a new billing address and submits four times...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.enterBillingAddressFieldsAndSubmitFourTimes(guestInformation);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.enterBillingAddressFieldsAndSubmitFourTimes(guestInformation);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.enterBillingAddressFieldsAndSubmitFourTimes(guestInformation);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.navigateToAddressBook();
			pbUser.enterBillingAddressFieldsAndSubmitFourTimes(guestInformation);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@And("^User adds shipping and billing address and submits four times (.*)$")
	public void user_adds_shipping_and_billing_address_and_submits_four_times(String guestFields) {
		LOGGER.info("User adds shipping and billing address and submits four times...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.enterShipAndBillAddressFieldsFourTimes(guestFields);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.enterShipAndBillAddressFieldsFourTimes(guestFields);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.enterShipAndBillAddressFieldsThreeTimes(guestFields);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.navigateToAddressBook();
			pbUser.enterShipAndBillAddressFieldsFourTimes(guestFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User adds a shipping address but cancels (.*)$")
	public void user_adds_a_shipping_address_but_cancels(String guestFields) {
		LOGGER.info("User adds a shipping address but cancels...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.enterShipAndBillButCancels(guestFields);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.enterShipAndBillButCancels(guestFields);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.enterShipAndBillButCancels(guestFields);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToAddressBook();
			pbUser.enterShipAndBillButCancels(guestFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("^User verifies that the address worked on is canceled$")
	public void user_verifies_that_the_address_worked_on_is_canceled() {
		LOGGER.info("User verifies that the address worked on is canceled...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyCancelAddress();
			break;
		case "TH":
			thUser.verifyCancelAddress();
			break;
		case "SPEEDO":
			speedoUser.verifyCancelAddress();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyCancelAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User deletes all the addresses saved in the address book$")
	public void user_deletes_all_the_addresses_saved_in_the_address_book() {
		LOGGER.info("User deletes all the address saved in the address book...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.deleteAllAddresses();
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.deleteAllAddresses();
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.deleteAllAddresses();
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToAddressBook();
			pbUser.deleteAllAddresses();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("^User verifies there is only one address in the address book$")
	public void user_verifies_there_is_only_one_address_in_the_address_book() {
		LOGGER.info("User verifies there is only one address in the address book...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyAllAddressesRemoved();
			break;
		case "TH":
			thUser.verifyAllAddressesRemoved();
			break;
		case "SPEEDO":
			speedoUser.verifyAllAddressesRemoved();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyAllAddressesRemoved();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@Then("^User verifies address was removed$")
	public void verify_address_removed() {
		LOGGER.info("Verifying address removed...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyAddressRemoved();
			break;
		case "TH":
			thUser.verifyAddressRemoved();
			break;
		case "SPEEDO":
			speedoUser.verifyAddressRemoved();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyAddressRemoved();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User verifies personal information without address$")
	public void user_verifies_personal_information_without_address() {
		LOGGER.info("Verifying personal information without address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationWithoutAddress();
			break;
		case "TH":
			thUser.verifyPersonalInformationWithoutAddress();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationWithoutAddress();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPersonalInformationWithoutAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}	
	
	@Then("^User verifies mobile personal information without address$")
	public void user_verifies_mobile_personal_information_without_address() {
		LOGGER.info("Verifying personal information without address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationWithoutAddressOnMobile();
			break;
		case "TH":
			thUser.verifyPersonalInformationWithoutAddressOnMobile();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationWithoutAddressOnMobile();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPersonalInformationWithoutAddressOnMobile();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}	
	
	
	@And("^User updates an address from address book (.*)$")
	public void updates_address_existing(String values) {
		LOGGER.info("Updating existing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.updateSavedAddress(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.updateSavedAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.updateSavedAddress(values);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.navigateToAddressBook();
			pbUser.updateSavedAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User updates a shipping address from address book (.*)$")
	public void updates_shippingAddress_existing(String values) {
		LOGGER.info("Updating existing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToAddressBook();
			ckUser.updateShippingAddress(values);
			break;
		case "TH":
			thUser.navigateToAddressBook();
			thUser.updateShippingAddress(values);
			break;
		case "SPEEDO":
			speedoUser.navigateToAddressBook();
			speedoUser.updateShippingAddress(values);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.navigateToAddressBook();
			pbUser.updateShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User updates on mobile a shipping address from address book (.*)$")
	public void updates_shippingAddress_existing_OnMobile(String values) {
		LOGGER.info("Updating existing address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.updateShippingAddress(values);
			break;
		case "TH":
			thUser.updateShippingAddressOnMobile(values);
			break;
		case "SPEEDO":
			speedoUser.updateShippingAddress(values);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.updateShippingAddress(values);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("^User verifies personal information with address$")
	public void user_verifies_personal_information_with_address() {
		LOGGER.info("Verifying personal information with address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationAddress();
			break;
		case "TH":
			thUser.verifyPersonalInformationAddress();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationAddress();
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.verifyPersonalInformationAddress();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
	
	@Then("^User verifies on mobile personal information with address$")
	public void user_verifies_personal_information_with_address_on_mobile() {
		LOGGER.info("Verifying personal information with address...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyPersonalInformationAddressOnMobile();
			break;
		case "TH":
			thUser.verifyPersonalInformationAddressOnMobile();
			break;
		case "SPEEDO":
			speedoUser.verifyPersonalInformationAddress();
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.verifyPersonalInformationAddressOnMobile();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
	
	@And("^User navigates to orders page$")
	public void user_navigates_to_orders_page() {
		LOGGER.info("User navigates to order page...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMyOrders();
			break;
		case "TH":
			thUser.navigateToMyOrders();
			break;
		case "SPEEDO":
			speedoUser.navigateToMyOrders();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMyOrders();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User navigates to mobile orders page$")
	public void user_navigates_to__mobile_orders_page() {
		LOGGER.info("User navigates to order page...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.navigateToMyOrdersOnMobile();
			break;
		case "TH":
			thUser.navigateToMyOrdersOnMobile();
			break;
		case "SPEEDO":
			speedoUser.navigateToMyOrdersOnMobile();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.navigateToMyOrdersOnMobile();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("^User verifies no orders have been placed$")
	public void user_verifies_no_orders_placed() {
		LOGGER.info("User verifies no orders placed...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyNoOrders();
			break;
		case "TH":
			thUser.verifyNoOrders();
			break;
		case "SPEEDO":
			speedoUser.verifyNoOrders();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyNoOrders();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@Then("^User verifies checkout preferences error$")
	public void user_verifies_checkout_preferences_error() {
		LOGGER.info("Verifying checkout preferences error...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyErrorMessage();
			break;
		case "TH":
			thUser.verifyErrorMessage();
			break;
		case "SPEEDO":
			speedoUser.verifyErrorMessage();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyErrorMessage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	
	@Then("^User verifies checkout preferences card error$")
	public void user_verifies_checkout_preferences_card_error() {
		LOGGER.info("Verifying checkout preferences card error...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyCardErrorMessage();
			break;
		case "TH":
			thUser.verifyCardErrorMessage();
			break;
		case "SPEEDO":
			speedoUser.verifyCardErrorMessage();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyCardErrorMessage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@Then("^User verifies checkout preferences empty error$")
	public void user_verifies_checkout_preferences_empty_error() {
		LOGGER.info("Verifying checkout preferences empty error...");
		String brand = Serenity.sessionVariableCalled("brand");
		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyEmptyErrorMessage();
			break;
		case "TH":
			thUser.verifyEmptyErrorMessage();
			break;
		case "SPEEDO":
			speedoUser.verifyEmptyErrorMessage();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyEmptyErrorMessage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("^User verifies personal information field error (.*)$")
	public void user_verifies_personal_information_field_error(String error) {
		LOGGER.info("User verifies personal information field error...");
		String brand = Serenity.sessionVariableCalled("brand");		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyFieldLevelErrorOnEditAccount(error);
			break;
		case "TH":
			thUser.verifyPageLevelErrorOnEditAccount(error);
			break;
		case "SPEEDO":
			speedoUser.verifyFieldLevelErrorOnEditAccount(error);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyFieldLevelErrorOnEditAccount(error);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
		
	}
	
	
	@When("^User navigates to rewards tab$")
	public void user_navigates_to_rewards_tab() {
		LOGGER.info("User navigates to rewards tab...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.clickRewardsTabOnAccountPage();
				break;
		
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS");
		}
	}

	@When("^User navigates to mobile rewards tab$")
	public void user_navigates_to_mobile_rewards_tab() {
		LOGGER.info("User navigates to rewards tab...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.clickRewardsTabOnAccountPageOnMobile();
				break;
		
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS");
		}
	}
	
	@Then("^User verifies user has no rewards on account page$")
	public void user_verifies_user_has_no_rewards_on_account_page() {
		LOGGER.info("User verifies user has no rewards on account page...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyNoRewardAvailable();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	
	@Then("^User verifies wishlist is empty$")
	public void user_verifies_empty_wishlist() {
		LOGGER.info("User verifies wishlist is empty...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyEmptyWishlist();
				break;
			case "TH":
				thUser.verifyEmptyWishlist();
				break;
			case "SPEEDO":
			
				break;
			case "VH":
			case "IZ":
			case "SB":
				pbUser.verifyEmptyWishlist();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@And("^User shares wishlist$")
	public void user_shares_wishlist() {
		LOGGER.info("User shares wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.shareWishlist();
				break;
			case "TH":
				thUser.shareWishlist();
				break;
			case "VH":
			case "IZ":
			case "SB":
				pbUser.shareWishlist();
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, PB");
		}
	}
	@Then("^User verifies mandatory details not provided error$")
	public void user_verifies_details_not_provided() {
		LOGGER.info("User shares wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyWishlistDetailsNotProvided();
				break;
			case "TH":
				thUser.verifyWishlistDetailsNotProvided();
				break;
			case "VH":
			case "IZ":
			case "SB":
				pbUser.verifyWishlistDetailsNotProvided();
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, PB");
		}
	}
	@And("^User provides share wishlist details (.*), (.*), (.*), (.*)$")
	public void user_provides_share_wishlist_details(String toEmail, String name, String fromEmail, String message) {
		LOGGER.info("User enters valid wishlist details...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.enterShareWishlistDetails(toEmail, name, fromEmail, message);
				break;
			case "TH":
				thUser.enterShareWishlistDetails(toEmail, name, fromEmail, message);
				break;
			case "VH":
			case "IZ":
			case "SB":
				pbUser.enterShareWishlistDetails(toEmail, name, fromEmail, message);
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@Then("^User verifies wishlist was shared$")
	public void user_verifies_wishlist_shared() {
		LOGGER.info("User verifies wishlist shared...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyWishlistShared();
				break;
			case "TH":
				thUser.verifyWishlistShared();
				break;
			case "VH":
			case "SB":
			case "IZ":
				pbUser.verifyWishlistShared();
				break;
			case "SPEEDO":
			
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@Then("^User verifies there are existing orders$")
	public void user_verifies_existing_orders() {
		LOGGER.info("User verifies there are existing orders...");
		String brand = Serenity.sessionVariableCalled("brand");
			switch (brand.toUpperCase()) {
			case "CKUS":
			case "CKCA":
				ckUser.verifyExistingOrders();
				break;
			case "TH":
				thUser.verifyExistingOrders();
				break;
			case "VH":
			case "IZ":
			case "SB":
				pbUser.verifyExistingOrders();
				break;
			case "SPEEDO":
				speedoUser.verifyExistingOrders();
				break;
			default:
				LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User updates personal (.*) four times$")
	public void user_updates_personal_info_four_times(String infoFields) {
		LOGGER.info("User verifies personal information field error...");
		String brand = Serenity.sessionVariableCalled("brand");		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editPersonalInformationAndSubmitFourTimes(infoFields);
			break;
		case "TH":
			thUser.editPersonalInformationFourTimes(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editPersonalInformationFourTimes(infoFields);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.editPersonalInformationAndSubmitFourTimes(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User updates personal on mobile (.*) four times$")
	public void user_updates_personal_info_on_mobile_four_times(String infoFields) {
		LOGGER.info("User verifies personal information field error...");
		String brand = Serenity.sessionVariableCalled("brand");		
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.editPersonalInformationOnMobileAndSubmitFourTimes(infoFields);
			break;
		case "TH":
			thUser.editPersonalInformationOnMobileAndSubmitFourTimes(infoFields);
			break;
		case "SPEEDO":
			speedoUser.editPersonalInformationOnMobileAndSubmitFourTimes(infoFields);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.editPersonalInformationOnMobileAndSubmitFourTimes(infoFields);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	
}

