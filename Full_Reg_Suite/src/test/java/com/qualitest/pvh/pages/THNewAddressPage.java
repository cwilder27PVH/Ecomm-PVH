package com.qualitest.pvh.pages;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class THNewAddressPage extends NewAddressPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(THNewAddressPage.class);  
	 
	@FindBy(id="country") 
	private BaseElement country; 
	 
	@FindBy(xpath = "//*[@class= 'errorDisplayDiv  nodisplay pageErrorMessage']")
	private BaseElement newAddressPageLevelError;
	
	@Step
	protected void selectCountry(String count) { 
		LOGGER.info("Selecting country: "+count); 
		Select roledropdown = new Select(country); 
		if(count.equals("United States")){ 
			count = "US"; 
		}else if(count.equals("Canada")) { 
			count = "CA"; 
		} 
		roledropdown.selectByValue(count); 
	}
	
	@Step
	public void enterNewAddress(String newAddress){
		String[] arr = newAddress.split(";");
		enterFirstname(arr[1]); 
		LOGGER.info("new address: " + newAddress);
		enterLastName(arr[2]); 
		clickEnterManually(); 
		enterAddress(arr[3]); 
		enterApartment(arr[4]); 
		enterCity(arr[5]); 
		selectCountry(arr[7]); 
		selectState(arr[6]); 
		enterZip(arr[8]); 
		enterPhone(arr[9]); 
		enterEmail(arr[0]); 
		clickUseForShippingBilling(); 
		clickAddShipToThisAddress(); 
		sleep(5000);
	} 
	
	@Step
	public void enterNewBillingAddress(String newBilling){ 
		String[] arr = newBilling.split(";");
		enterFirstname(arr[1]); 
		enterLastName(arr[2]); 
		clickEnterManually(); 
		enterAddress(arr[3]); 
		enterApartment(arr[4]); 
		enterCity(arr[5]); 
		selectCountry(arr[7]); 
		selectState(arr[6]); 
		enterZip(arr[8]); 
		enterPhone(arr[9]); 
		enterEmail(arr[0]); 
		clickAddShipToThisAddress(); 
		sleep(200);		
	} 
	@Step
	private void clearFirstName() {
		new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id= 'createOrEditAddress']//input[@id = 'firstName']")));
		LOGGER.info("Clearing the first name field");
		firstName.clear();
	}
	@Step
	private void clearLastName() {
		LOGGER.info("Clearing the last name field");
		lastName.clear();
	}
	@Step
	private void clearAddress() {
		LOGGER.info("Clearing the address field");
		address.clear();
	}
	@Step
	private void clearApartment() {
		LOGGER.info("Clearing the apartment field");
		apartment.clear();
	}
	@Step
	private void clearCity() {
		LOGGER.info("Clearing the city field");
		city.clear();
	}
	@Step
	private void clearZip() {
		LOGGER.info("Clearing the zip field");
		zip.clear();
	}
	@Step
	private void clearPhone() {
		LOGGER.info("Clearing the phone field");
		phoneNumber.clear();
	}
	@Step
	private int getRandomNumber() {
		Random r = new Random();
		int low = 10;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		LOGGER.info("Getting a random number of: "+result);
		return result;
	}
	@Step
	public void enterEditedAddress(String newAddress){
		
		String[] arr = newAddress.split(";");
		clearFirstName();
		enterFirstname(arr[1]);
		clearLastName();
		enterLastName(arr[2]);
		clickEnterManuallyEdit();
		clearAddress();
		enterAddress(arr[3]);
		clearApartment();
		enterApartment(arr[4]);
		clearCity();
		enterCity(arr[5]);
		selectCountry(arr[7]);
		selectState(arr[6]);
		clearZip();
		enterZip(arr[8]);
		clearPhone();
		enterPhone(arr[9]);
		clickAddShipToThisAddress();
		if(newAddressPageLevelError.exists()) {
			LOGGER.info("Found the Error on the page level");
			try
			{
			    Thread.sleep(5000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			clickAddShipToThisAddress(); 
			try
			{
			    Thread.sleep(5000);
			}
			catch(InterruptedException ex)
			{
			    Thread.currentThread().interrupt();
			}
			clickAddShipToThisAddress(); 
		}
	}
	@Step
	public void signedInEnterBillingAddress(String newAddress) {
		String[] arr = newAddress.split(";");
		enterFirstname(arr[1]); 
		enterLastName(arr[2]); 
		clickEnterManuallyEdit();
		enterAddress(arr[3]); 
		enterApartment(arr[4]); 
		enterCity(arr[5]); 
		selectCountry(arr[7]); 
		selectState(arr[6]); 
		enterZip(arr[8]); 
		enterPhone(arr[9]); 
		clickAddShipToThisAddress(); 
		sleep(2000);
	}
	
}
