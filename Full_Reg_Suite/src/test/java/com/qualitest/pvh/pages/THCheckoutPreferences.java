package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class THCheckoutPreferences extends CheckoutPreferences {

	//@Override
	//protected void selectState(String state) {
	//	stateSelect.type(state);
	//}
	
	@FindBy(id="WC_AjaxMyAccountQuickCheckoutProfileForm_links_7")
	private BaseElement update;
	
	@FindBy(xpath="//label[@class='unregisteredCheckbox checkbox']")
    private BaseElement SameAsShipCheckBox;	
	
	@FindBy(id="WC_QuickCheckoutAddressForm_AddressEntryForm_FormInput_shipping_address1_1")
	private BaseElement address;
	
	@FindBy(xpath = "//div[@class='pcaautocomplete pcatext']/div/div[contains(@class,'pcaitem')]")
	List<WebElement> addressySuggestion;
	
	@FindBy(xpath = "//div[@class='pcaautocomplete pcatext']")
	private BaseElement addressyExists;	
	
	@Override
	public void enterCheckoutInformation(String guestFields) {
		// TODO Auto-generated method stub
		checkForEnterAddrMan();
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectCountry(arr[5]);
		selectState(arr[6]);
		enterZip(arr[7]);
		enterPhone(arr[8]);
		if(checkForCreditCardInfo())
		{
			enterCreditCard(arr[9]);
			selectExpMonth(arr[10]);
			selectExpYear(arr[11]);
		}
	}
	
	@Override
	public void enterCheckoutInformationWithAddressySelection(String guestFields) {
		// TODO Auto-generated method stub
		checkForEnterAddrMan();
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		if(!arr[2].equals(" ")) {
			String address1 = arr[2];
			address.clear();
			    for (int i = 0; i < address1.length(); i++){
			        char c = address1.charAt(i);
			        String s = new StringBuilder().append(c).toString();
			        address.sendKeys(s);
			    }
			    sleep(1000);
			if (addressyExists.exists()) {
				LOGGER.info("Addressy suggestion is displayed");
				addressySuggestion.get(0).click();
				sleep(1000);
					if (addressyExists.exists()) {
						addressySuggestion.get(0).click();
						sleep(1000);
					}
				
			}
		}
		enterPhone(arr[8]);
		if(checkForCreditCardInfo())
		{
			enterCreditCard(arr[9]);
			selectExpMonth(arr[10]);
			selectExpYear(arr[11]);
		}
	}
	
	public void clickUpdate() {
		LOGGER.info("Clicking update button");
		update.click();
		try {
			Thread.sleep(5000);
		} catch(Exception e) {
			e.printStackTrace();
		}
}
@Override
	public void clickOffSameAsBilling()
	{
		sleep(2000);
		List<WebElement> checkBoxes = this.getDriver().findElements(By.xpath("//input[@type='checkbox']"));
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
