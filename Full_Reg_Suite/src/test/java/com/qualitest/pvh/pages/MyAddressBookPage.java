package com.qualitest.pvh.pages;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class MyAddressBookPage extends BasePage {

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

	@FindBy(xpath="//*[@id = 'pageLevelMessage']")
	private BaseElement pageLevelMessage;
	
	@FindBy(xpath = "//a[contains(text(), 'Enter your address manually ')]")
	private List<WebElement> enterManual;
	
	@FindBy(id="addressId")
	private BaseElement addressDropdown;
	
	@FindBy(xpath = "//*[@id='addressId']/option")
	private List<WebElement> savedAddresses;
	
	@FindBy(xpath = "//*[@id = 'WC_AjaxAddressBookForm_links_2c']")
	private BaseElement cancel;
	
	@FindBy(xpath = "//div[@class='pcaautocomplete pcatext']/div/div[contains(@class,'pcaitem')]")
	List<WebElement> addressySuggestion;
	
	@FindBy(xpath = "//body/div[@class='pca']/div[4]/div[2]")
	private BaseElement addressyExists;	
	
	private SoftAssertions SA = new SoftAssertions();

	private enum SelectAddressType {
	    Shipping,
	    Billing,
	    ShippingAndBilling
	}
	private static final Logger LOGGER = LoggerFactory.getLogger(MyAddressBookPage.class);
	
	protected int randomInt() {
		int i = (int)(Math.random() * ((3000 - 1) + 1)) + 1;
		LOGGER.info("Getting a random number of: "+i);
		return i;
	}
	
	protected void clickOnShippingAddress() {
		LOGGER.info("Adding shipping address...");
		sleep(3000);
		shippingAddress.click();
	}
	
	protected void clickOnBillingAddress() {
		LOGGER.info("Adding Billing Address...");
		sleep(3000);
		billingAddress.click();
	}
	
	protected void clickOnShippingAndBillingAddress() {
		LOGGER.info("Adding shipping and billing address...");
		sleep(3000);
		shippingAndBillingAddress.click();
	}
	
	protected void clickRemove() {
		LOGGER.info("Removing selected address...");
		remove.click();
	}
	
	protected void clickSubmit() {
		LOGGER.info("Submitting address...");
		sleep(3000);
		evaluateJavascript("arguments[0].scrollIntoViewIfNeeded();", submit);
		submit.waitUntilClickable().click();
	}
	
	protected void clickAddNew() {
		LOGGER.info("Adding new address...");
		addNew.click();
	}
	
	protected void clickCancel() {
		LOGGER.info("Clicking the cancel button");
		evaluateJavascript("arguments[0].scrollIntoViewIfNeeded();", cancel);
		cancel.waitUntilClickable().click();
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
	
	private int getNumberOfAddresses() {
		clickAddressDropDown();
		List<WebElement> addresses = addressDropdown.findElements(By.xpath(".//option"));
		int size = addresses.size();
		LOGGER.info("The number of addresses is: "+size);
		return size;
	}
	
	private void clickAddressDropDown() {
		LOGGER.info("Clicking the address dropdown");
		sleep(1000);
	//	pageRefresh();
		addressDropdown.waitUntilClickable().click();
	}
	
	public void deleteAllAddresses() {
		while(getNumberOfAddresses() > 1) {
			pageRefresh();
			clickAddressDropDown();
			sleep(4000);
			List<WebElement> addresses = addressDropdown.findElements(By.xpath(".//option"));
			addresses.get(1).click();
			sleep(5000);
			clickRemove();
			sleep(4000);
			evaluateJavascript("window.scrollTo(0, -document.body.scrollHeight)");
			clickAddressDropDown();
		}
	}
	
	public void verifyAllAddressesRemoved() {
		assertThat(getNumberOfAddresses()).as("Number of addresses").isLessThan(2);
	}
	
	
	  protected void selectState(String state) { LOGGER.info("Selecting state: " +
	 state); 
	  sleep(5000); 
	 Select roledropdown = new Select(stateSelect);
	  roledropdown.selectByVisibleText(state); }
	 
	
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
		if(arr.length != 8) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAddress();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		    sleep(500);
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

	public void enterShippingAddressWithAddressySuggestionAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 8) {
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
			    sleep(4000);
			if (addressyExists.exists()) {
				LOGGER.info("Addressy suggestion is displayed");
				addressySuggestion.get(0).click();
				sleep(2000);
				
					if (addressyExists.exists()) {
						addressySuggestion.get(0).click();
						sleep(4000);
					}
				
			}
		}
		enterPhone(arr[7]);
		clickSubmit();
		sleep(5000);
	}
	
	
	public void enterBillingAddressFieldsAndSubmit(String guestFields) {
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
		    sleep(500);
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
	
	public void enterBillingAddressFieldsAndSubmitFourTimes(String guestFields) {
		enterBillingAddressFieldsAndSubmit(guestFields);
		sleep(3000);
		clickSubmit();
		sleep(3000);
		clickSubmit();
		sleep(3000);
		clickSubmit();
		sleep(3000);
	}
	
	public void enterUpdateBillingAddressFields(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
//		clickOnBillingAddress();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		    sleep(500);
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
	
	public void enterUpdateBillingAddressFieldsFourTimes(String guestFields) {
		if (findAddress(SelectAddressType.Billing)==true) {
			LOGGER.info("Updating Billing address");
			enterUpdateBillingAddressFields(guestFields);
		}
		else {
			LOGGER.info("No Billing address found");
		}
		sleep(3000);
		clickUpdate();
		sleep(3000);
		clickUpdate();
		sleep(3000);
		clickUpdate();
		sleep(3000);
	}
	
	public void enterUpdateBillingAndShippingAddressFields(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
		//clickOnShippingAndBillingAddress();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		    sleep(500);
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
	
	public void enterUpdateShippingAddressFields(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 9) {
			LOGGER.info("Incomplete address information provided");
		}
//		clickOnShippingAddress();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		    sleep(500);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(String.valueOf(randomInt())+arr[3]);
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
	
	public void updateShippingAddressFieldsFourTimes(String guestFields) {
		if (findAddress(SelectAddressType.Shipping)==true) {
			LOGGER.info("Updating Shipping address");
		enterUpdateShippingAddressFields(guestFields);
		}
		else {
			LOGGER.info("No shipping address found");
		}
		sleep(1500);
		clickUpdate();
		sleep(1500);
		clickUpdate();
		sleep(1500);
		clickUpdate();
		sleep(1500);
	}
	
	
	public void enterShippingAndBillingAddressFieldsAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 8) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAndBillingAddress();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		    sleep(500);
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
	
	public void enterShipAndBillAddressFields(String guestFields) {
		String brand = Serenity.sessionVariableCalled("brand");
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
		    sleep(500);
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
	
	public void enterShipAndBillButCancels(String guestFields) {
		String brand = Serenity.sessionVariableCalled("brand");
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
		    sleep(500);
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
	}
	
	private boolean updateExists() {
		boolean isThere = false;
		isThere = update.isEnabled();
		LOGGER.info("The update button is enabled: "+isThere);
		return isThere;
		
	}
	
	public void verifyCancel() {
		assertThat(updateExists()).as("Cancel works").isTrue();
	}
	
	public void updateExisitingShippingAndBillingAddressFieldsAndSubmitFourTimes(String guestFields) {
		if (findAddress(SelectAddressType.ShippingAndBilling)==true) {
			LOGGER.info("Updating Shipping snd Billing address");
			enterUpdateBillingAndShippingAddressFields(guestFields);
		}
		else {
			LOGGER.info("No shipping address found");
		}
		sleep(3000);
		clickUpdate();
		sleep(3000);
		clickUpdate();
		sleep(3000);
		clickUpdate();
		sleep(3000);
	}
	
	
	public void updateExisitingShippingAddressFieldsAndSubmit(String guestFields) {
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
		    sleep(500);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectState(arr[5]);
		enterZip(arr[6]);
		enterPhone(arr[7]);
		clickUpdate();
		sleep(5000);
	}
	public void verifyAddressAdded() {
		SA.assertThat(getPageLevelMessage()).isEqualToIgnoringCase("The new address has been successfully added to the address book.");
		SA.assertAll();
	}
	public void verifyAddressRemoved() {
		SA.assertThat(getPageLevelMessage()).isEqualToIgnoringCase("The selected address has been removed from the address list");
		SA.assertAll();
	}
	
	public void verifyInvalidAddressAdded()
	{
		SA.assertThat(getPageLevelMessage()).isEqualToIgnoringCase("The address has been added, but it cannot be verified. This may result in problems for order delivery.");
		SA.assertAll();
	}
	
	public void verifyUpdatedInvalidAddress() {
		assertThat(getPageLevelMessage()).isEqualToIgnoringCase("The address has been updated, but it cannot be verified. This may result in problems for order delivery.");
	}
	
	public String getPageLevelMessage() {
		String s = pageLevelMessage.getText();
		LOGGER.info("Getting the page level message as: "+s);
		return s;
	}
	
	public void verifyUpdateAddress() {
		sleep(3000);
		assertThat(getPageLevelMessage()).isEqualToIgnoringCase("The address has been updated successfully");
	}
	
	protected void clickUpdate() {
		LOGGER.info("Clicking update");
		sleep(3000);
		evaluateJavascript("arguments[0].scrollIntoViewIfNeeded();", update);
		update.waitUntilClickable().click();
		sleep(3000);
	}
	
	//Adds a shipping address not found by the system and uses their 3 click override feature to have the system accept it
	public void addInvalidShippingAddress(String guestFields) {
		// TODO Auto-generated method stub
		String[] arr = guestFields.split(";");
		if(arr.length != 8) {
			LOGGER.info("Incomplete address information provided");
		}
		clickAddNew();
		clickOnShippingAddress();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		    sleep(500);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectState(arr[5]);
		enterZip(arr[6]);
		enterPhone(arr[7]);
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
		try{
		    Thread.sleep(1500);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		clickSubmit();
		sleep(4000);
	}
	
	public void selectExistingAddress() {
		LOGGER.info("Selecting existing addresses...");
		addressDropdown.click();
		savedAddresses.get(2).click();
	}
	public void removeAddress() {
		clickRemove();
	}
	
	public void findAndUpdateShippingAddress(String guestFields) {
		if (findAddress(SelectAddressType.Shipping)==true) {
			LOGGER.info("Updating Shipping address");
			updateExisitingShippingAddressFieldsAndSubmit(guestFields);
		}
		else {
			LOGGER.info("No shipping address found");
		}
	}
	
	public void findAndUpdateShippingAddressOnMobile(String guestFields) {
		if (findAddress(SelectAddressType.Shipping)==true) {
			LOGGER.info("Updating Shipping address");
			updateExisitingShippingAddressFieldsAndSubmit(guestFields);
		}
		else {
			LOGGER.info("No shipping address found");
		}
	}

	public void findAndUpdateBillingAddress(String guestFields) {
		if (findAddress(SelectAddressType.Billing)==true) {
			LOGGER.info("Updating Billing address");
			enterUpdateBillingAddressFields(guestFields);
		}
		else {
			LOGGER.info("No billing address found");
		}
	}
	
	public void findAndUpdateShippingAndBillingAddress(String guestFields) {
		if (findAddress(SelectAddressType.ShippingAndBilling)==true) {
			LOGGER.info("Updating Shipping snd Billing address");
			enterUpdateBillingAndShippingAddressFields(guestFields);
		}
		else {
			LOGGER.info("No shipping address found");
		}
	}
	
	
	
	public boolean findAddress(SelectAddressType shipping) {
		Boolean addressExists = false;
		int count = getNumberOfAddresses();
			if (count > 0) {
				for (int i=0; i<count; i++) {
					clickAddressDropDown();
					sleep(5000);
					List<WebElement> addresses = addressDropdown.findElements(By.xpath(".//option"));
					addresses.get(i).click();
					sleep(6000);
					
					List<WebElement> radioButtons = this.getDriver().findElements(By.xpath("//input[@type='radio']"));
					addressExists = radioButtons.get(shipping.ordinal()).isSelected();			
						
								if (addressExists == true) {
									return addressExists;
									}
						
								else if (i== count) {
										return addressExists;
										}
						
					}
				}
		
			return addressExists;
	}	
}
