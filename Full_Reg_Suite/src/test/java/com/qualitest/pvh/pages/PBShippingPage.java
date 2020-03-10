package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class PBShippingPage extends ShippingPage {

	/**
	 * Page Objects
	 */
	@FindBy(xpath = "//a[@id='guestEmailContinue']")
	private BaseElement continueAsGuest;
	/**
	 * End Page Objects
	 */
	
	
	/**
	 * Method to select continue as guest option during checkout
	 */
	@Step
	public void clickContinueAsGuest() {
		LOGGER.info("Clicking continue as guest button");
		continueAsGuest.click();
	}
	
}
