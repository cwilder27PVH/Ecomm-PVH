package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class PBAccountSummaryPage extends AccountSummaryPage {

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
	
	@FindBy(xpath="//div[@id='logoutMenu']")
	private BaseElement logOutMenu;
	
	@FindBy(xpath="//a[@id='headerLogout_vh']")
	private BaseElement mobileLogOutMenu;
	
	@FindBy(xpath="//div[@id='logoutMenu']//div//a[@id='headerLogout']")
	private BaseElement signOut;
	
	@FindBy(xpath = "//h3[@class='myaccount_header']//a[@id='WC_MyAccountCenterLinkDisplay_inputs_1']")
	private BaseElement edit;
	@FindBy(id="WC_MyAccountSidebarDisplayf_links_5")
	private BaseElement myAddressBook;
	
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
		assertThat(title).as("Account Summary Page Title").isEqualTo("Partner Brands - My Account");
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
	 * Method to click edit link
	 */
	
	public void clickEdit() {
		LOGGER.info("Clicking edit link and navigating to Personal Information Page");
		edit.click();
	}	
	
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
		 
	


		/*
		 * String strJavaScript = "var element = arguments[0];" +
		 * "var mouseEventObj = document.createEvent('MouseEvents');" +
		 * "mouseEventObj.initEvent( 'mouseover', true, true );" +
		 * "element.dispatchEvent(mouseEventObj);"; Object web_Element_To_Be_Hovered =
		 * null; ((JavascriptExecutor) getDriver()).executeScript(strJavaScript,
		 * web_Element_To_Be_Hovered);
		 * LOGGER.info("Clicking My Orders from account dropdown"); sleep(5000);
		 * clickLogout();
		 */
		  
		 
	

	
	//MM//started
		//Added the Action class the page to be scrolled UP
	// Mattie: I removed the Actions class here, since it wasn't working on Firefox or IE. Not sure if the scroll is even needed.
	//Mamatha: I commented the scrollview implementation, it is working for chrome and firefox
	
	public void navigateToMyAddressBook() {
		LOGGER.info("Navigating to user address book...");
		sleep(1500);
		//evaluateJavascript("window.scrollTo(0, -document.body.scrollHeight)");
		/*
		 * evaluateJavascript("arguments[0].scrollIntoView();", myAddressBook);
		 * myAddressBook.waitUntilClickable(); myAddressBook.click();
		 */
		/*
		 * Actions a = new Actions(getDriver());
		 * a.sendKeys(Keys.PAGE_UP).build().perform();
		 */
		evaluateJavascript("arguments[0].scrollIntoViewIfNeeded();", myAddressBook);
    	myAddressBook.waitUntilClickable().click();	
		
		
	}

	//end

	public void clickMobileLogout() {
		LOGGER.info("Clicking LogOut link");
		mobileLogOutMenu.click();
	}
}
