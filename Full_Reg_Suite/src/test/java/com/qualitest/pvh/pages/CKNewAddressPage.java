package com.qualitest.pvh.pages;

import java.util.Random;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class CKNewAddressPage extends NewAddressPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(CKNewAddressPage.class);
	
	@FindBy(xpath = "//*[@id= 'createOrEditAddress']//input[@id = 'firstName']")
	protected BaseElement firstName;
	
	@FindBy(xpath = "//*[@class= 'errorDisplayDiv  nodisplay pageErrorMessage']")
	private BaseElement newAddressPageLevelError;
	
	private void clearFirstName() {
		new WebDriverWait(getDriver(), 3).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id= 'createOrEditAddress']//input[@id = 'firstName']")));
		LOGGER.info("Clearing the first name field");
		firstName.clear();
	}
	
	private void clearLastName() {
		LOGGER.info("Clearing the last name field");
		lastName.clear();
	}
	
	private void clearAddress() {
		LOGGER.info("Clearing the address field");
		address.clear();
	}
	
	private void clearApartment() {
		LOGGER.info("Clearing the apartment field");
		apartment.clear();
	}
	
	private void clearCity() {
		LOGGER.info("Clearing the city field");
		city.clear();
	}
	
	private void clearZip() {
		LOGGER.info("Clearing the zip field");
		zip.clear();
	}
	
	private void clearPhone() {
		LOGGER.info("Clearing the phone field");
		phoneNumber.clear();
	}
	
	public int getRandomNumber() {
		Random r = new Random();
		int low = 10;
		int high = 100;
		int result = r.nextInt(high-low) + low;
		LOGGER.info("Getting a random number of: "+result);
		return result;
	}
	
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
	
	
}
