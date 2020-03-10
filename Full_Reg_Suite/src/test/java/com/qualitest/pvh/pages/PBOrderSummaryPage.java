package com.qualitest.pvh.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PBOrderSummaryPage extends OrderSummaryPage{
	@FindBy(xpath = "//*[@id=\"shoppingBagColumn2\"]/div[4]")
	private BaseElement cancellationField;
	
	@FindBy(xpath = "//a[@class='cancel primary-button']")
	private BaseElement cancelOrder;
	
	@FindBy(xpath = "//a[contains(text(),'Yes')]")
	private BaseElement agreeToCancel;
	
	@FindBy(xpath = "//h1[@class='large orderThanksMessage']")
	private BaseElement thankMessage;

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSummaryPage.class); 
	
	/**
	 * Method to click cancel order on order summary page
	 */
	public void cancelOrder() {
		LOGGER.info("Clicking cancel order");
		sleep(2000);
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		cancelOrder.waitUntilClickable().click();
		agreeToCancel.waitUntilClickable().click();
	}
}

