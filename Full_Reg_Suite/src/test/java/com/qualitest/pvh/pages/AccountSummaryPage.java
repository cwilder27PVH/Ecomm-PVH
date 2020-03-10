package com.qualitest.pvh.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class AccountSummaryPage extends BasePage{
	
	@FindBy(id="WC_MyAccountCenterLinkDisplay_div_38")
	private BaseElement welcome;
	
	@FindBy(id="WC_MyAccountCenterLinkDisplay_inputs_1")
	private BaseElement edit;
	
	@FindBy(xpath="//div[@id='WC_MyAccountCenterLinkDisplay_div_5']//a[@id='WC_MyAccountCenterLinkDisplay_inputs_1']")
	private BaseElement mobileEdit;
	
//	@FindBy(xpath = "//*[@id='WC_MyAccountSidebarDisplayf_links_2']")
	@FindBy(xpath = "//a[@id='WC_MyAccountSidebarDisplayf_links_2']")
	private BaseElement myOrders;
	
	@FindBy(xpath="//*[@id='logoutMenu']/div[2]/a")
	private BaseElement myOrdersThruDropDown;

	@FindBy(id="WC_MyAccountSidebarDisplayf_links_5")
	private BaseElement myAddressBook;
	
	@FindBy(id="WC_MyAccountSidebarDisplayf_links_6")
	private BaseElement checkoutPreferences;
	
	@FindBy(id="//a[@id='WC_MyAccountSidebarDisplayf_links_6']")
	private BaseElement mobileCheckoutPreferences;
	
	@FindBy(xpath = "WC_UserRegistrationAddForm_links_2")
	private BaseElement goToAccount;
	
	@FindBy(xpath = "//*[@id='WC_MyAccountCenterLinkDisplay_div_5']//*[contains (text(), 'Address')]")
	private BaseElement savedAddressInformation;
	

	private SoftAssertions SA = new SoftAssertions();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountSummaryPage.class);
	
	/**
	 * Method to verify account summary page title
	 */
	public abstract void verifyPageTitle(); 
	
	/**
	 * Method to click edit link
	 */
	public void clickEdit() {
		LOGGER.info("Clicking edit link and navigating to Personal Information Page");
		edit.click();
	}

	public void clickMobileEdit() {
		LOGGER.info("Clicking edit link and navigating to Personal Information Page");
		sleep(500);
		mobileEdit.click();
	}
	
	public void navigateToMyOrders() {
		LOGGER.info("Navigating to my orders...");
		sleep(3000);
		if(myOrders.exists()==true)
		{
			myOrders.click();
		}
		else
		{
			WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#headerLogout"));
			Actions builder = new Actions(getDriver());
			builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
			LOGGER.info("Clicking My Orders from account dropdown");
			myOrdersThruDropDown.click();
		}
		//myOrders.click();
	}
	
	public void navigateToMobileMyOrders() {
		LOGGER.info("Navigating to my orders...");
		myOrders.click();
		}

	public void navigateToMyAddressBook() {
		LOGGER.info("Navigating to user address book...");
		sleep(1500);
		//evaluateJavascript("window.scrollTo(0, -document.body.scrollHeight)");
		evaluateJavascript("arguments[0].scrollIntoView();", myAddressBook);
		myAddressBook.click();
	}
	
	public void navigateToCheckoutPreferences() {
		LOGGER.info("Navigating to user checkout preferences...");
		checkoutPreferences.click();
	}
	
	public void navigateToCheckoutPreferencesOnMobile() {
		LOGGER.info("Navigating to user checkout preferences...");
		mobileCheckoutPreferences.click();
		LOGGER.info("Clicked checkout preferences...");
	}
	
	public void verifyNoSavedAddress() {
		LOGGER.info("Verifying that no address is saved in new account...");
		SA.assertThat(savedAddressInformation.exists()).isEqualTo(false);
		SA.assertAll();
	}
	
	public void verifySavedAddress() {
		LOGGER.info("Verifying that address is saved in new account...");
		SA.assertThat(savedAddressInformation.exists()).isEqualTo(true);
		SA.assertAll();
	}

	
}