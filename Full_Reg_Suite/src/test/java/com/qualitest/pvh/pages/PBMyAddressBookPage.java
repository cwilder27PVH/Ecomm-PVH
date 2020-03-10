package com.qualitest.pvh.pages;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PBMyAddressBookPage extends MyAddressBookPage {

	@FindBy(xpath="//label[@for='WC_AccountForm_sbAddress_2']")
	private BaseElement billingAddress;
	
	@FindBy(xpath="//label[@for='WC_AccountForm_sbAddress_1']")
	private BaseElement shippingAddress;
	
	@FindBy(xpath="//div[@id='WC_AccountForm_div_4']//fieldset")
	private BaseElement radioButtonFrame;
	
	@FindBy(xpath="//label[@for='WC_AccountForm_sbAddress_3']")
	private BaseElement shippingAndBillingAddress;		
	
	@FindBy(id="addressId")
	private BaseElement addressDropdown;
	
	@FindBy(xpath = "//div[@class='pcaautocomplete pcatext']/div/div[contains(@class,'pcaitem')]")
	List<WebElement> addressySuggestion;
	
	@FindBy(xpath = "//body/div[@class='pca']/div[4]/div[2]")
	private BaseElement addressyExists;	
	
	@FindBy(id="WC_AccountForm_AddressEntryForm_FormInput_address1_1")
	private BaseElement address;

//	private SoftAssertions 
//	SA = new SoftAssertions();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyAddressBookPage.class);

	public void enterShipAndBillButCancels(String guestFields) {
		String brand = Serenity.sessionVariableCalled("brand");
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAndBillingAddressPB();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(String.valueOf(randomInt())+arr[3]);
		}
		enterCity(arr[4]);
		if(brand.equals("TH")) {
			selectCountry(arr[5]);
		}
		selectState(arr[6]);
		enterZip(arr[7]);
		enterPhone(arr[8]);
		clickCancel();
		sleep(3000);
	}
	
	public void enterUpdateBillingAndShippingAddressFieldsPB(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		String brand = Serenity.sessionVariableCalled("brand");
		if(brand.equals("TH")) {
			selectCountry(arr[5]);
		}
		selectState(arr[6]);
		enterZip(arr[7]);
		enterPhone(arr[8]);
		clickUpdate();
		sleep(5000);
	}
	
	public void enterUpdateBillingAddressFieldsPB(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
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
		clickUpdate();
		sleep(5000);
	}	

	public void enterShippingAndBillingAddressFieldsAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 8) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAndBillingAddressPB();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectState(arr[5]);
		enterZip(arr[6]);
		enterPhone(arr[7]);
		clickSubmit();
		sleep(5000);
	}

	public void enterBillingAddressFieldsAndSubmit (String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnBillingAddressPB();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
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
		clickSubmit();
		sleep(5000);
	}
	

	public void enterShippingAddressFieldsAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 8) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAddressPB();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectState(arr[5]);
		enterZip(arr[6]);
		enterPhone(arr[7]);
		clickSubmit();
		sleep(5000);
	}

	public void addInvalidShippingAddress(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 8) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAddressPB();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectState(arr[5]);
		enterZip(arr[6]);
		enterPhone(arr[7]);
		clickSubmit();
		sleep(5000);
	
	try{
	    Thread.sleep(1500);
	}
	catch(InterruptedException ex)
	{
	    Thread.currentThread().interrupt();
	}
	
	clickSubmit();
	try{
	    Thread.sleep(1500);
	}
	catch(InterruptedException ex)
	{
	    Thread.currentThread().interrupt();
	}
	clickSubmit();
	try{
	    Thread.sleep(1500);
	}
	catch(InterruptedException ex)
	{
	    Thread.currentThread().interrupt();
	}
	clickSubmit();
	sleep(5000);
}

	public void enterShippingAddressWithAddressySuggestionAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 8) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAddressPB();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			String address1 = arr[2];
			address.clear();
			    for (int i = 0; i < address1.length(); i++){
			        char c = address1.charAt(i);
			        String s = new StringBuilder().append(c).toString();
			        address.sendKeys(s);
			    }
			    sleep(3000);
			if (addressyExists.exists()) {
				LOGGER.info("Addressy suggestion is displayed");
				addressySuggestion.get(0).click();
				sleep(3000);
					if (addressyExists.exists()) {
						addressySuggestion.get(0).click();
						sleep(3000);
					}
				
			}
		}
		enterPhone(arr[7]);
		clickSubmit();
		sleep(5000);
	}
	
	public void enterShipAndBillAddressFields(String guestFields) {
		String brand = Serenity.sessionVariableCalled("brand");
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAndBillingAddressPB();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(String.valueOf(randomInt())+arr[3]);
		}
		enterCity(arr[4]);
		if(brand.equals("TH")) {
			selectCountry(arr[5]);
		}
		selectState(arr[6]);
		enterZip(arr[7]);
		enterPhone(arr[8]);
		clickSubmit();
		sleep(5000);
		
	}
	protected void clickOnShippingAndBillingAddressPB() {
		LOGGER.info("Adding shipping and billing address...");
		sleep(3000);
		shippingAndBillingAddress.click();
	}
	
	protected void clickOnBillingAddressPB() {
		LOGGER.info("Adding Billing Address...");
		sleep(3000);
		billingAddress.click();
	}
	protected void clickOnShippingAddressPB() {
		LOGGER.info("Adding shipping address...");
		sleep(3000);
		shippingAddress.click();
	}
	public void enterShipAndBillAddressFieldsFourTimes(String guestFields) {
		enterShipAndBillAddressFields(guestFields);
		sleep(3000);
		clickSubmit();
		sleep(3000);
		clickSubmit();
		sleep(3000);
		clickSubmit();
		sleep(3000);
	}
}
