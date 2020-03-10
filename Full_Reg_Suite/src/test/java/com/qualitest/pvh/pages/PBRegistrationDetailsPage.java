package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;

import net.thucydides.core.annotations.Step;

public class PBRegistrationDetailsPage extends RegistrationDetailsPage{

	
	/**
	 * Method to verify title of Calvin Klein registration details page
	 */
	@Step
	public void verifyPageTitle() {
		String title = this.getTitle();
		assertThat(title).as("Registration Details Page Title").isEqualTo("Van Heusen - Register");
	}
	

}