package com.qualitest.pvh.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;


public class PBHeader extends PBHomePage {

	protected SoftAssertions SA = new SoftAssertions();

	@FindBy(xpath = "//div[@id='myAccountRegistered_vh']//div[@class='registeredHeader']")
	private BaseElement mobileMyAccount;

	@FindBy(xpath = "//*[@id = 'headerLogout']")
	private BaseElement goToAccountButton;

	//@FindBy(xpath = "//*[@class = 'myaccount_header']/a[1]")
	@FindBy(xpath = "//a[text()='Go To My Account']")
	private BaseElement goToAccountOnPage;

	@FindBy(id = "headerLogout")
	private BaseElement logoutDropDown;

	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	private BaseElement popUpClose;

	@FindBy(xpath = "//a[@title='Wishlist']")
	private BaseElement wishListFromDropDown;

	@FindBy(xpath = "//div[@id='myAccountRegistered_vh']//a[contains(text(),'Wishlist')]")
	private BaseElement mobileWishList;

	@FindBy(xpath = "//div[@id='logoutMenuWrapper']//div[1]//div[1]")
	private BaseElement wishList;

	//	private CurrentPage currentPage;

	private static final Logger LOGGER = LoggerFactory.getLogger(PBHeader.class);


	/**
	 * Method to select wish list option from my account drop down on header
	 */
	//Added JavascriptExecutor method for mouseover on the element
	public void goToMyWishlist() {
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#headerLogout"));
		/*
		 * Actions builder = new Actions(getDriver());
		 * builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		 * LOGGER.info("Clicking Wishlist from account dropdown");
		 * wishListFromDropDown.click();
		 */
		String strJavaScript = "var element = arguments[0];"
				+ "var mouseEventObj = document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );"
				+ "element.dispatchEvent(mouseEventObj);";
		((JavascriptExecutor) getDriver()).executeScript(strJavaScript, web_Element_To_Be_Hovered);
		LOGGER.info("Clicking My Orders from account dropdown");
		sleep(5000);
		wishListFromDropDown.click();
	}



	public void goToMyMobileWishlist() {
		LOGGER.info("mobile Wish List");
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#headerLogout"));
		String strJavaScript = "var element = arguments[0];"
				+ "var mouseEventObj = document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );"
				+ "element.dispatchEvent(mouseEventObj);";
		((JavascriptExecutor) getDriver()).executeScript(strJavaScript, web_Element_To_Be_Hovered);
		mobileWishList.click();

	}
	/**
	 * Method to select wishlist from header
	 */

	public void clickWishlist() {
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#headerLogout"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		LOGGER.info("Clicking Wishlist from account dropdown");
		wishList.click();
	}



	public void goToMyAccount() {
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#headerLogout"));
		/*
		 * Actions builder = new Actions(getDriver());
		 * //builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		 * builder.moveToElement(web_Element_To_Be_Hovered).click().build().perform();
		 * logoutDropDown.click();
		 */
		String strJavaScript = "var element = arguments[0];"
				+ "var mouseEventObj = document.createEvent('MouseEvents');"
				+ "mouseEventObj.initEvent( 'mouseover', true, true );"
				+ "element.dispatchEvent(mouseEventObj);";
		((JavascriptExecutor) getDriver()).executeScript(strJavaScript, web_Element_To_Be_Hovered);
		LOGGER.info("Clicking My Orders from account dropdown");
		sleep(3000);
		logoutDropDown.click();
	}



	public void goToMobileMyAccount() {
		mobileMyAccount.click();
	}


	public void clickGoToAccount() {
		LOGGER.info("Go to account click");
		sleep(3000);
		goToAccountButton.click();
	}
	//MM//started
	//Added the Action class the page to be scrolled UP
	public void clickGoToAccountOnPage() {
		LOGGER.info("Go to account click");
		sleep(3000);
		Actions a = new Actions(getDriver());
		a.sendKeys(Keys.PAGE_UP).build().perform();
		goToAccountOnPage.waitUntilClickable().click();
	}
	//end
}


