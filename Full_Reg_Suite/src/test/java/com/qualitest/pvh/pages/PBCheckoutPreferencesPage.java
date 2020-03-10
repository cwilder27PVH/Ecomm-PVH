package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class PBCheckoutPreferencesPage extends CheckoutPreferences {

	
	@FindBy(id="WC_AjaxMyAccountQuickCheckoutProfileForm_links_7")
	private BaseElement update;
	
	public void clickUpdate() {
		LOGGER.info("Clicking update button");
		update.click();
		try {
			Thread.sleep(5000);
		} catch(Exception e) {
			e.printStackTrace();
		}
}
	
	@FindBy(xpath="//label[@class='unregisteredCheckbox checkbox']")
    private BaseElement SameAsShipCheckBox;	
	
	@FindBy(xpath="//input[@id='SameShippingAndBillingAddress']")
    private BaseElement SameAsShipCheckBox1;	
	
	public void clickOffSameAsBillingPB_notworking()
	{
		sleep(2000);
		//Scroll.to(SameAsShipCheckBox);
		Scroll.to(SameAsShipCheckBox1);
		SameAsShipCheckBox1.waitUntilClickable().click();
//		Boolean checkBoxSelected = SameAsShipCheckBox1.isSelected();
//		System.out.println(checkBoxSelected);
//		if (checkBoxSelected==true) {
//			SameAsShipCheckBox1.click();
//		sleep(2000);
		
	}
	
	public void clickOffSameAsBillingPB()
	{
		sleep(2000);
		Scroll.to(SameAsShipCheckBox);
		//List<WebElement> checkBoxes = this.getDriver().findElements(By.xpath("//input[@type='checkbox']"));//input[@id='SameShippingAndBillingAddress']
        List<WebElement> checkBoxes = this.getDriver().findElements(By.xpath("//input[@id='SameShippingAndBillingAddress']"));
		int size = checkBoxes.size();
		System.out.println(size);
		Boolean checkBoxSelected = checkBoxes.get(0).isSelected();
		System.out.println(checkBoxSelected);
		if (checkBoxSelected==true) {
			SameAsShipCheckBox.click();
		sleep(2000);
		}
	}
	

}