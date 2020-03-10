package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class CKAccountSummaryPage extends AccountSummaryPage {

	@FindBy(xpath="//div[@id='logoutMenuWrapper']")
	private BaseElement logOutMenuHeader;
	
	@FindBy(id="logoutMenu")
	private BaseElement logOutMenu;	
	
	@FindBy(xpath="//a[@title='Sign Out']")
	private BaseElement signOut;

	@FindBy(xpath = "//*[@id = 'WC_MyAccountSidebarDisplayf_links_3']")
	private BaseElement sideTabRewards;
	
	@FindBy(xpath = "//*[@class = 'rewardsOuterDiv']")
	private List<WebElement> availableRewards;
	
	@FindBy(xpath = "//input[@id = 'signUpEmailFooter']")
	private BaseElement newsletterEmailSignUpInput;
	
	@FindBy(xpath = "//input[@id = 'agreeFooter']")
	private BaseElement agreeNewsLetterButton;
	
	@FindBy(xpath = "//*[@id = 'fieldErrorMessage']")
	private BaseElement footerPageErrorMessage;
	
	@FindBy(xpath = "//*[@id = 'footerPageErrorMessage']")
	private BaseElement footerPageErrorMessageCA;
	
	@FindBy(xpath = "//*[@id = 'footerPageSuccessMessage']")
	private BaseElement footerPageSuccessMessage;
	
	@FindBy(xpath = "//*[@class= 'rewardsAndPoints']/span[2]")
	private BaseElement rewardMoneyAvailable;
	
	@FindBy(xpath = "//p[@class='myaccount_desc']")
	private BaseElement noRewardEnrollment;
	
	@FindBy(id="WC_MyAccountSidebarDisplayf_links_5")
	private BaseElement myAddressBook;
	
	@FindBy(xpath="//a[@class='my-account']//*[@id='Combined-Shape']")
	private BaseElement myAccountMobile;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CKAccountSummaryPage.class);
	
	public void clickSideTabRewards() {
		LOGGER.info("Clicking the side rewards tab");
		sideTabRewards.click();
	}
	
	private int getNumberOfRewards() {
		int size = availableRewards.size();
		LOGGER.info("Getting the size of the amount of rewards as: "+size);
		return size;
	}
	
	private void displayNameOfAllAwardsAvailable() {
		for(WebElement w : availableRewards) {
			String s = w.findElement(By.xpath(".//div/span[1]")).getText();
			LOGGER.info("Name of the reward: "+s);
		}
	}
	
	public void verifyRewardsAvailable() {
		assertThat(getNumberOfRewards()).as("Number of Rewards").isGreaterThan(0);
		displayNameOfAllAwardsAvailable();
	}
	
	/**
	 * Method to verify Calvin Klein account summary page
	 */
	@Override
	public void verifyPageTitle() {
		String title = this.getTitle();
		assertThat(title).as("Account Summary Page Title").isEqualTo("Account Summary | Calvin Klein");
	}

	@Step
	private void clickNewsLetterAgreeFooter() {
		LOGGER.info("Clicking the agreement to newsletter in footer");
		agreeNewsLetterButton.click();
	}
	
	@Step
	private void enterNewsLetterEmailAndSubmit(String email) {
		LOGGER.info("Entering and submitting email: "+email);
		newsletterEmailSignUpInput.typeAndEnter(email);
	}
	
	@Step
	public void enterNewLetterAndSubmit(String email) {
		if(agreeNewsLetterButton.exists()) {
			clickNewsLetterAgreeFooter();
		}
		enterNewsLetterEmailAndSubmit(email);
		sleep(3000);
	}
	public void enterNoEmailforNewsLetterAndSubmit() {
		if(agreeNewsLetterButton.exists()) {
			clickNewsLetterAgreeFooter();
		}
		
	}
	
	@Step
	private String getFooterSignUpErrorText() {
		String s = footerPageErrorMessage.getText();
		LOGGER.info("The text of the footer error message is: "+s);
		return s;
	}
	
	@Step
	private String getFooterSignUpErrorTextCA() {
		String s = footerPageErrorMessageCA.getText();
		LOGGER.info("The text of the footer error message on CA is: "+s);
		return s;
	}
	
	@Step
	public void verifyNoEmailNewsLetterSignUpOnAccount(String error) {
		String brand = Serenity.sessionVariableCalled("brand");
		if(brand.equals("CKCA")) {
			assertThat(getFooterSignUpErrorTextCA()).as("Footer error").isEqualToIgnoringCase(error);
		}else {
			assertThat(getFooterSignUpErrorText()).as("Footer error").isEqualToIgnoringCase(error);
		}
	}
	
	private String getFooterSuccessMessage() {
		String s = footerPageSuccessMessage.getText();
		LOGGER.info("Getting the footer success message as: "+s);
		return s;
	}
	
	private boolean footerPageSuccessMessageExists() {
		boolean itExists = false;
		itExists = footerPageSuccessMessage.exists();
		LOGGER.info("footerMessage is there: "+itExists);
		return itExists;
		
	}
	public void verifyNoRewards() {
		LOGGER.info("Verifying that " + noRewardEnrollment.getText());
		assertThat(noRewardEnrollment.getText()).containsIgnoringCase("You are not currently enrolled");
	}
	private String getRewardAvailable() {
		String s = rewardMoneyAvailable.getText();
		s = s.replace("$", "");
		LOGGER.info("Returning a reward available as: "+s);
		return s;
	}
	
	public void verifyRewardAmount(String reward) {
		assertThat(getRewardAvailable()).as("reward").isEqualTo(reward);
	}
	
	public void verifyEmailNewsLetterSignUpOnAccount() {
		LOGGER.debug("Footer success message is: "+getFooterSuccessMessage());
		assertThat(footerPageSuccessMessageExists()).as("Email newsletter sign up success").isTrue();
	}
	
	/**
	 * Method to click logout link
	 */
	
	public void clickLogout() {
		LOGGER.info("Clicking LogOut link");
		
		// NOTE(Mattie): This is more stable on IE than using Actions.moveToElement to hover over the account menu.
		
		/*
		 * JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		 * jse.executeScript("document.getElementById('logoutMenuWrapper').focus();");
		 */
		
		//MM4252019 added javascriptexecutor method for mouseover
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#headerLogout"));
		String strJavaScript = "var element = arguments[0];"
	            + "var mouseEventObj = document.createEvent('MouseEvents');"
	            + "mouseEventObj.initEvent( 'mouseover', true, true );"
	           + "element.dispatchEvent(mouseEventObj);";
	((JavascriptExecutor) getDriver()).executeScript(strJavaScript, web_Element_To_Be_Hovered);
		  sleep(1000); 
		  Actions actions = new Actions(getDriver());
		  actions.moveToElement(signOut).click().build().perform(); 
		  }
	
	
	public void clickMobileLogout() {
		LOGGER.info("Clicking LogOut link");
		sleep(5000);
		//LOGGER.info(myAccountMobile.getText());
		myAccountMobile.waitUntilClickable().click();
		signOut.waitUntilClickable().click();
		//logOutMenuHeader.click();
	}
	public void navigateToMyAddressBook() {
		LOGGER.info("Navigating to user address book...");
		sleep(1500);
		//evaluateJavascript("window.scrollTo(0, -document.body.scrollHeight)");
		evaluateJavascript("arguments[0].scrollIntoViewIfNeeded();", myAddressBook);
		myAddressBook.waitUntilClickable().click();
	}
	
}