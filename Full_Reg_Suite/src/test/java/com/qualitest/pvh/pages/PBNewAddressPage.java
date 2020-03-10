package com.qualitest.pvh.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PBNewAddressPage extends NewAddressPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(CKNewAddressPage.class);
	
	@FindBy(xpath = "//*[@id= 'createOrEditAddress']//input[@id = 'firstName']")
	protected BaseElement firstName;
	
	@FindBy(xpath = "//*[@class= 'errorDisplayDiv  nodisplay pageErrorMessage']")
	private BaseElement newAddressPageLevelError;
	 
	//@FindBy(xpath = "//div[@class='editSelectControls']/div[contains(text(),'Ship To This Address')]/preceding-sibling::div/a[1]")
	//private List<WebElement> editShippingAddressList;
	
	//@FindBy(xpath = "//div[@class='editSelectControls']//div[contains(text(),'Use This Address')]/preceding-sibling::div/a[1]")
	//div/a[@class='link blue edit'][1]
	//@FindBy(xpath = "//div/a[@class='link blue edit'][1]")
	//private List<WebElement> editBillingAddressList;
	
	@FindBy(xpath = "//div/a[@class='link blue edit'][1]")
	private List<WebElement> editShippingAddressList;
	
	@FindBy(xpath = "//*[@id = 'billingAddressList']//a[@class='link blue edit']")
	//@FindBy(xpath = "//*[@class='link blue edit']")
	private List<WebElement> editBillingAddressList;
	 
	@FindBy(xpath = "//div[@class='editSelectControls']/*[contains(text(),'Use This Address')]") 
	private List<WebElement> useThisBillingAddressList; 
	
	@FindBy(xpath = "//div[@class='editSelectControls']/div[contains(text(),'Ship To This Address')]") 
	private List<WebElement> shipToThisAddressList; 
	
	@FindBy(xpath = "//*[@id ='billingAddressList']/div[1]/div")
	private List<WebElement> listOfBillingAddresses;
	
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
	
	public void clickFirstBillingAddressEdit() {
		LOGGER.info("Clicking the first edit button in the list of billing addresses");
		sleep(5000);
		editBillingAddressList.get(0).click();
	}
	
	/*
	 * public void clickSecondBillingAddressEdit() { LOGGER.
	 * info("Clicking the second edit button in the list of billing addresses");
	 * editBillingAddressList.get(1).click(); }
	 */
	
	
	
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
	
	/**
	 * Clicks the first shipping address edit
	 */
	public void clickFirstShippingAddressEdit() {
		LOGGER.info("Clicking the first edit button in the list of shipping addresses");
		sleep(5000);
		int size =  editShippingAddressList.size();
		System.out.println("the size is: "+size);
		editShippingAddressList.get(0).click();
		sleep(6000);
	}
	
	/**
	 * Clicks the second billing address edit
	 */
	public void clickSecondBillingAddressEdit() {
		LOGGER.info("Clicking the second edit button in the list of billing addresses");
		sleep(2000);
		int size =  editBillingAddressList.size();
		System.out.println("the size is: "+size);
		editBillingAddressList.get(1).click();
		sleep(6000);
	}
	
	/**
	 * Getting a number of addresses in the billing list of shipping addresses
	 * @return
	 */
	public int getNumberOfBillingAddresses() { 
		int num = useThisBillingAddressList.size(); 
		LOGGER.info("Getting the size of the billing address list as: "+num); 
		return num; 
	} 
	 
	/**
	 * Clicking a second address
	 */
	public void clickSecondAddress() { 
		try { 
			LOGGER.info("Clicking the second address, which isn't the current"); 
			shipToThisAddressList.get(1).click(); 
		}catch(Exception e) { 
			LOGGER.info("Cannot find a second address to click"); 
		} 
	} 
	public void clickBillingAddressByFirstName(String firstName, String lastName) {
		try { 
			for(WebElement w : listOfBillingAddresses) {
				String text = w.findElement(By.xpath(".//*[@class = 'address']")).getText();
				if(text.contains(firstName) && text.contains(lastName)) {
					LOGGER.info("Using the address with first name and last name as: "+firstName+""+lastName);
					sleep(1000);
					w.findElement(By.xpath(".//div[@class='editSelectControls']//div[contains(text(),'Use This Address')]")).click();
					break;
				}
			}
		}catch(Exception e) { 
			LOGGER.info("Cannot find a second address to click"); 
		} 
	}
}
