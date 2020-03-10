package com.qualitest.core.uimap;

import org.openqa.selenium.support.ui.Select;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class UserPreferencesPage {
	
	/**
	 *  Page objects start here
	 */
	
	@FindBy (id ="ContentPlaceHolder1_txtName")
	private WebElementFacade name;
	
	@FindBy (id ="ContentPlaceHolder1_txtCompany")
	private WebElementFacade company;
	
	@FindBy (id ="ContentPlaceHolder1_txtEmailID")
	private WebElementFacade email;
	
	@FindBy (xpath = "//div[contains(text(),'Select Avatar')]")
	private WebElementFacade selectAvatar;
	
	@FindBy (xpath = "//div[contains(text(),'Use My Name')]")
	private WebElementFacade selectUserMyName;
	
	@FindBy (id ="ContentPlaceHolder1_txtAddress")
	private WebElementFacade address;
	
	@FindBy (id ="ContentPlaceHolder1_txtCity")
	private WebElementFacade city;
	
	@FindBy (id ="ContentPlaceHolder1_txtState")
	private WebElementFacade state;
	
	@FindBy (id ="ContentPlaceHolder1_txtPostalCode")
	private WebElementFacade postalCode;
	
	@FindBy (id ="ContentPlaceHolder1_ddlCountry")
	private WebElementFacade countryDropDown;
	
	@FindBy (id ="ContentPlaceHolder1_txtPhone")
	private WebElementFacade homePhoneNo;
	
	@FindBy (id ="ContentPlaceHolder1_txtOfficeno")
	private WebElementFacade officePhoneNo;
	
	@FindBy (id ="ContentPlaceHolder1_txtMobileNo")
	private WebElementFacade cellePhoneNo;
	
	@FindBy (id ="ContentPlaceHolder1_txtFax")
	private WebElementFacade fax;
	
	@FindBy (id ="ddlPushNotifications")
	private WebElementFacade pushNotificationDropDown;
	
	@FindBy (id ="ContentPlaceHolder1_txtUserLoginId")
	private WebElementFacade userLoginId;
	
	@FindBy (id ="ContentPlaceHolder1_txtUserPassword")
	private WebElementFacade userPassword;
	
	@FindBy (id ="ContentPlaceHolder1_txtConfirmPassword")
	private WebElementFacade confirmPassword;
	
	@FindBy (id ="ContentPlaceHolder1_lnkbtnUpdate")
	private WebElementFacade updateButton;
	
	@FindBy (id ="ContentPlaceHolder1_lnkbtnBack")
	private WebElementFacade cancelButton;
	
	@FindBy (id ="ContentPlaceHolder1_imgArrows")
	private WebElementFacade hideUnhideProfile;
	
	
	@FindBy (xpath = "//tr[@id='ContentPlaceHolder1_trNotifications1']//div[@class='cpHeader']//table//tbody//tr//td//img")
	private WebElementFacade hideUnhideNotification;
	
	@FindBy (id ="ContentPlaceHolder1_imgArrow2")
	private WebElementFacade hideUnhideAccount;
	

	/**
	 *  Page objects ends here
	 */
	
	
	/**
	 *  Start of click functions 
	 */
	
	public void selectAvatar() {
				
		selectAvatar.click();		
	}			
	
	public void selectPicture(String picNo) {
				
		String picPath="//div[@id='AllProfileAvtar']/img["+picNo+"]";
		//find(By.xpath(picPath)).click();
	}	
	
	
	public void selectMyName() {
				
		selectUserMyName.click();
	}	
	
	public void selectCountry(String country) {
		
		
		Select countryValue = new Select(countryDropDown);
		
		if (!country.isEmpty()) {
			countryValue.selectByVisibleText(country);
		} else {
			System.out.println("Default Country selected");
		}
		
	}
	
	public void selectNotification(String notification) {
		
		
		Select notificationValue = new Select(pushNotificationDropDown);
		
		if (!notification.isEmpty()) {
			notificationValue.selectByVisibleText(notification);
		} else {
			System.out.println("Default notification selected");
		}
		
	}
	
	public void updateUserPreferenceUpdate() {
				
		updateButton.click();		
	}

	
	public void cancelUserPreferenceUpdate() {
				
		cancelButton.click();		
	}

	
	public void hideUnhideProfileSection() {
				
		hideUnhideProfile.click();		
	}

	
	public void hideUnhideNotificationSection() {
				
		hideUnhideNotification.click();		
	}


	
	public void hideUnhideAccountnSection() {
				
		hideUnhideAccount.click();		
	}

	

	/**
	 *  End of click functions
	 */
	

	/**
	 *  Start of text functions
	 */
	
	public void enterName(String name) {
		
		address.sendKeys(name);		
	}		
	
	public void enterAddress(String addressValue) {
		
		address.sendKeys(addressValue);		
	}		
	
	public void enterCity(String cityValue) {
		
		city.sendKeys(cityValue);		
	}	
	
	public void enterState(String stateValue) {
		
		state.sendKeys(stateValue);		
	}

	
	public void enterPostalCode(String code) {
		
		postalCode.sendKeys(code);		
	}
	
	public void enterHomePhoneNo(String home) {
		
		homePhoneNo.sendKeys(home);		
	}	
	
	public void enterOfficePhoneNo(String officeNo) {
				
		officePhoneNo.sendKeys(officeNo);		
	}
	
	public void enterCellPhoneNo(String cellNo) {
				
		cellePhoneNo.sendKeys(cellNo);		
	}

	public void enterFax(String faxNo) {
				
		fax.sendKeys(faxNo);		
	}
		
	public void enterUserPassword(String password) {
				
		userPassword.sendKeys(password);		
	}
	
	public void enterConfirmPassword(String password) {
				
		confirmPassword.sendKeys(password);		
	}

	/**
	 *  End of text functions
	 */

	/**
	 *  Start of read functions
	 */
	
	public String readCompanyName() {
				
		String companyName = company.getText();
		return companyName;
	}	
	
	public String reademailID() {
				
		String emailID = email.getText();
		return emailID;
	}	
	
	public String readUserLoginID() {
				
		String userID = userLoginId.getText();
		return userID;
	}	

	/**
	 *  End of read functions
	 */


}
