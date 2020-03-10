package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import net.thucydides.core.annotations.Step;

public class PBAccountUpdatedConfirmationPage extends AccountUpdateConfirmationPage{
	
	/**
	 * Method to verify the title of Calvin Klein account update confirmation page
	 */
	@Override
	@Step
	public void verifyPageTitle() {
		String text = promptHeader.getText();
		assertThat(text).as("Account Update Confirmation Page Title").isEqualTo("Your account has been updated.");	
	}
	
}