package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class THMyAddressBookPage extends MyAddressBookPage{

	@FindBy(id="WC_AccountForm_sbAddress_1")
	private BaseElement shippingAddress;
	
	@FindBy(id="WC_AccountForm_sbAddress_2")
	private BaseElement billingAddress;
	
	@FindBy(id="WC_AccountForm_sbAddress_3")
	private BaseElement shippingAndBillingAddress;
	
	@FindBy(id="WC_AjaxAddressBookForm_links_1")
	private BaseElement addNew;
	
	@FindBy(id="WC_AjaxAddressBookForm_links_4")
	private BaseElement update;
	
	@FindBy(id="WC_AccountForm_NameEntryForm_FormInput_firstName_1")
	private BaseElement firstName;
	
	@FindBy(id="WC_AccountForm_NameEntryForm_FormInput_lastName_1")
	private BaseElement lastName;
	
	@FindBy(id="WC_AccountForm_AddressEntryForm_FormInput_address1_1")
	private BaseElement address;
	
	@FindBy(id="WC_AccountForm_AddressEntryForm_FormInput_address2_1")
	private BaseElement apartment;
	
	@FindBy(id="WC_AccountForm_AddressEntryForm_FormInput_city_1")
	private BaseElement city;
	
	@FindBy(id="WC_AccountForm_AddressEntryForm_FormInput_state_1")
	private BaseElement stateSelect;
	
	@FindBy(id="WC_AccountForm_AddressEntryForm_FormInput_zipCode_1")
	private BaseElement zipCode;
	
	@FindBy(id="WC_AccountForm_AddressEntryForm_FormInput_phone1_1")
	private BaseElement phone;
	
	@FindBy(id="country")
	private BaseElement countrySelect;
	
	@FindBy(id="WC_AjaxAddressBookForm_links_2")
	private BaseElement remove;
	
	@FindBy(id="WC_AjaxAddressBookForm_links_4a")
	private BaseElement submit;
	
	@FindBy(xpath ="//div[contains(text(),'Submit')]")
	private BaseElement mobileSubmit;
	
	@FindBy(xpath ="//div[contains(text(),'Update')]")
	private BaseElement mobileUpdate;
	
	@FindBy(id="pageLevelMessage")
	private BaseElement pageLevelMessage;
	
	@FindBy(xpath = "//a[contains(text(), 'Enter your address manually ')]")
	private List<WebElement> enterManual;
	
	@FindBy(xpath = "//div[@class='pcaautocomplete pcatext']/div/div[contains(@class,'pcaitem')]")
	List<WebElement> addressySuggestion;
	
	@FindBy(xpath = "//body/div[@class='pca']/div[4]/div[2]")
	private BaseElement addressyExists;	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MyAddressBookPage.class);
	
	protected void clickOnShippingAddress() {
		LOGGER.info("Adding shipping address...");
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		shippingAddress.click();
	}
	
	protected void clickOnBillingAddress() {
		LOGGER.info("Adding Billing Address...");
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		billingAddress.click();
	}
	
	protected void clickOnShippingAndBillingAddress() {
		LOGGER.info("Adding shipping and billing address...");
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		shippingAndBillingAddress.click();
	}
	
	protected void clickRemove() {
		LOGGER.info("Removing selected address...");
		remove.click();
	}
	
	protected void clickSubmit() {
		LOGGER.info("Submitting address...");
		submit.click();
	}
	
	protected void clickMobileSubmit() {
		LOGGER.info("Submitting address...");
		mobileSubmit.click();
	}
	
	protected void clickAddNew() {
		LOGGER.info("Adding new address...");
		addNew.click();
	}
	
	protected void enterFirstName(String first) {
		firstName.type(first);
	}
	
	protected void enterLastName(String last) {
		lastName.type(last);
	}
	
	protected void enterAddress(String input) {
		address.type(input);
	}
	
	protected void enterCity(String cityName) {
		city.type(cityName);
	}
	
	protected void enterApartment(String apartmentInfo) {
		apartment.type(apartmentInfo);
	}
	
	protected void selectState(String state) {
		LOGGER.info("Selecting state: " + state);
		Select roledropdown = new Select(stateSelect);
		roledropdown.selectByVisibleText(state);
	}
	
	protected void selectCountry(String country) {
		LOGGER.info("Selecting country: " + country);
		Select roledropdown = new Select(countrySelect);
		roledropdown.selectByVisibleText(country);
	}
	
	protected void enterZip(String zip) {
		zipCode.type(zip);
	}
	
	protected void enterPhone(String phoneNumber) {
		phone.type(phoneNumber);
	}
	
	protected void clickEnterManual() {
		if(enterManual.size()>0) {
			LOGGER.info("Clicking enter manual address info");
			enterManual.get(0).click();
		} else {
			LOGGER.info("Enter manual address link is not displayed");
		}
	}
	
	public void enterShippingAddressFieldsAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAddress();
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
	
	public void enterShippingAddressFieldsAndSubmitOnMobile(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAddress();
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
		clickMobileSubmit();
		sleep(5000);
	}
	
	public void enterShippingAddressWithAddressySuggestionAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAddress();
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
			    sleep(1500);
			if (addressyExists.exists()) {
				LOGGER.info("Addressy suggestion is displayed");
				addressySuggestion.get(0).click();
				sleep(2000);
				
					if (addressyExists.exists()) {
						addressySuggestion.get(0).click();
						sleep(2000);
					}
				}
		}
		enterPhone(arr[8]);
		clickSubmit();
		sleep(5000);
	}
	
	public void enterBillingAddressFieldsAndSubmitTH(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnBillingAddress();
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
	}
	
	public void enterShippingAndBillingAddressFieldsAndSubmitTH(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAndBillingAddress();
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
	}
	
	protected void clickMobileUpdate() {
		LOGGER.info("Clicking update");
		mobileUpdate.click();
	}
	
	public void updateExisitingShippingAddressFieldsAndSubmitOnMobile(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length < 8) {
			LOGGER.info("Incomplete address information provided");
		}
	
		sleep(1500);
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
		clickMobileUpdate();
		sleep(5000);
	}	
}
