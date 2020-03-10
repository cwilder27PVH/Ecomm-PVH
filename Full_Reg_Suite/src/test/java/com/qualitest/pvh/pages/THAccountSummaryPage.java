package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class THAccountSummaryPage extends AccountSummaryPage {
	
	@FindBy(xpath="//*[@id=\"headerLinks\"]/div[2]/a[1]")
	private BaseElement logOut;
	
	@FindBy(xpath="//body[@class='liveChatClosed']/div[@id='page']/header[@class='clearfix']/div[@id='headerNavWrapperOuter']/div[@id='headerNavWrapper']/div[@id='headerNavInner']/div[@id='headerNavList']/nav[@class='clearfix']/div[@id='headerNavMyAccount']/div[@id='myAccountRegistered']/div[6]/a[1]")
	private BaseElement mobileLogOut;
	
	@FindBy(id="WC_MyAccountCenterLinkDisplay_inputs_1")
	private BaseElement edit;
	
	@FindBy(id="WC_MyAccountSidebarDisplayf_links_7")
	private BaseElement Wishlist;
	
	@FindBy(id="WC_MyAccountSidebarDisplayf_links_5")
	private BaseElement myAddressBook;
	
	@FindBy(xpath = "//*[@class = 'newsletterSignup']")
	private BaseElement newLetterSignUpFooter;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(THAccountSummaryPage.class);
	
	/**
	 * Method to click edit link
	 */
	public void clickEdit() {
		LOGGER.info("Navigating to Personal information page...");
		edit.click();
	}
	
	public void navigateToMyAddressBook() {
		LOGGER.info("Navigating to user address book...");
		sleep(1500);
		//evaluateJavascript("window.scrollTo(0, -document.body.scrollHeight)");
		//evaluateJavascript("arguments[0].scrollIntoView();", myAddressBook);s
		myAddressBook.waitUntilClickable().click();
	}
	
	
	
	/**
	 * Method to click logout link
	 */
	public void clickLogOut() {
		LOGGER.info("Logging out....");
		getDriver().navigate().refresh();
		logOut.click();
	}
	

	public void clickMobileLogout() {
		LOGGER.info("Logging out....");
		//Actions actions = new Actions(getDriver());
		//actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		//Scroll.to(mobileLogOut);
		sleep(1000);
		mobileLogOut.click();
		//getDriver().findElement(By.cssSelector("#headerLogout")).click();;
	}
	/**
	 * Method to verify Tommy Hilfiger account summary page
	 */
	@Override
	public void verifyPageTitle() {
		String title = this.getTitle();
		assertThat(title).as("Account Summary Page Title").isEqualTo("Account Summary | Tommy Hilfiger");
	}
	
	/**
	 * Method to click wish list option from left navigation bar
	 */
	public void goToWishlist() {
		LOGGER.info("Clicking Wishlist");
		Wishlist.waitUntilClickable().click();
	}
	

	public void goToMobileWishlist() {
		LOGGER.info("Clicking Wishlist");
		Wishlist.waitUntilClickable().click();
	}
	@Step
	public void clickNewsLetterSignUp() {
		LOGGER.info("Clicking the newsletter in the footer.");
		sleep(3000);
		newLetterSignUpFooter.click();
	}
	
}