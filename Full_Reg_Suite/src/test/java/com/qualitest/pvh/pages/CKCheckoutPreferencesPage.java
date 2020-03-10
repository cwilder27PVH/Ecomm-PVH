package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class CKCheckoutPreferencesPage extends CheckoutPreferences {


	
	@FindBy(id="WC_AjaxMyAccountQuickCheckoutProfileForm_links_7")
	private BaseElement update;
	
/*    @FindBy(xpath="//label[@class='unregisteredCheckbox checkbox checked']")
    private BaseElement SameAsShipCheckBox;	
	public void clickOffSameAsBillingPB()
	{
		SameAsShipCheckBox.click();
	}*/
	
	public void clickUpdate() {
		LOGGER.info("Clicking update button");
		update.click();
		try {
			Thread.sleep(5000);
		} catch(Exception e) {
			e.printStackTrace();
		}
}
}