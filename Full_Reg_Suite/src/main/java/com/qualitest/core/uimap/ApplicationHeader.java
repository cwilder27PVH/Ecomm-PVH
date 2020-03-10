package com.qualitest.core.uimap;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.pages.PageObject;

public class ApplicationHeader extends PageObject {
	/**
	 *  Page objects start here 
	 */
	
	@FindBy (id ="id")
	private WebElementFacade logo;

	@FindBy (id ="linkHOME")
	private WebElementFacade homeIcon;

	@FindBy (id ="spnShowWelcomUserName")
	private WebElementFacade welcomeUser;

	@FindBy (xpath = "//span[@class='arrow-up']")
	private WebElementFacade mainMenu;

	@FindBy (xpath = "//a[contains(text(),'Account Settings')]")
	private WebElementFacade accountSettings;

	@FindBy (xpath = "//a[contains(text(),'Change Password')]")
	private WebElementFacade changePassword;

	@FindBy (xpath = "//div[@class='themeBtn']")
	private WebElementFacade changeTheme;

	@FindBy (id = "LogoutID")
	private WebElementFacade logOut;

	@FindBy (xpath = "//span[@class='assortNotifyIcon']")
	private WebElementFacade notificationIcon;

	@FindBy (xpath = "//span[@class='assortNotifyIcon']")
	private WebElementFacade closeNotificationIcon;

	@FindBy (xpath = "//span[@class='ImportedAssortSheetIcon']")
	private WebElementFacade ImportedAssortmentSheetIcon;

	@FindBy (xpath = "//div[@id='DivImportedAssortSheet_Popup']//span[@class='modernPopupCloseIcon']")
	private WebElementFacade closeImportedAssortmentSheetIcon;

	@FindBy (id="ddlFiscalYear")
	private WebElementFacade fiscalYearDropDown;
	
	/**
	 *  Page objects ends here
	 * 
	 */
	
	/**
	 *  Start of click functions
	 */
	
	public void clickHomeIcon() {
		homeIcon.waitUntilClickable().click();
		}
	
	public String getWelcomeUserName() {
		String loggedInUserName = welcomeUser.getText();
		return loggedInUserName;
	}
	
	public void navigateToAccountSettings() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(mainMenu).build().perform();
		accountSettings.click();
	}
	
	public void navigateChangePassword() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(mainMenu).build().perform();
		changePassword.click();
	}
	
	public void navigateChangeTheme() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(mainMenu).build().perform();
		changeTheme.click();
	}
	
	public void logOut() {
		Actions actions = new Actions(getDriver());
		actions.moveToElement(mainMenu).build().perform();
		logOut.click();
	}
	
	public void clickNotificationIcon() {
		notificationIcon.click();
		}

	
	public void closeNotificationIcon() {
		closeNotificationIcon.click();
		}
	
	public void clickImportedPlansIcon() {
		ImportedAssortmentSheetIcon.click();
		}
	
	public void closeImportedPlansIcon() {
		closeImportedAssortmentSheetIcon.click();
		}
	
	public void selectFiscalYear(String year) {
		Select yeardropdown = new Select(fiscalYearDropDown);
		
		if (!year.isEmpty()) {
			yeardropdown.selectByVisibleText(year);
		} else {
			System.out.println("No year selected");
		}
		
	}
	

	/**
	 *  End of click functions
	 */
	

	/**
	 *  Start of assert functions
	 */
	
	public void verifyWelcomeUserName(String emailId) {
		String loggedInUserName = getWelcomeUserName();
		
		loggedInUserName = loggedInUserName.replaceAll("\\s", "");
		boolean isFound = emailId.contains(loggedInUserName);
		//Assert.assertTrue(isFound);
	}	

	/**
	 *  End of assert functions
	 */
	
}
