package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.JavascriptExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;

public class THCheckoutPage extends CheckoutPage{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(THCheckoutPage.class);
	
	@FindBy(xpath = "//*[@id=\"contentWrapper\"]/h1")
	private BaseElement titleOfCheckOutPage;

	//@FindBy(id="payWithPayPal")
	//@FindBy(xpath = "//*[@id='payWithPayPal']")
	//*[@id='payWithPayPal']
	@FindBy(xpath = "//*[@id='payWithPayPal']")
	private BaseElement payWithPayPal; 
	
	@FindBy(xpath = "//*[@id='shippingBillingPageNext']")
	private BaseElement reviewOrder;
	
	private String getTitleOfCheckOutPage() {
		String s = titleOfCheckOutPage.getText();
		LOGGER.info("Getting the title of the checkout page as: "+s);
		return s;
	}
	
	public void verifyTitleOfCheckOutPage() {
		assertThat(getTitleOfCheckOutPage()).as("Title of checkout page").isEqualTo("CHECKOUT");
	}
	 
	public void payWithPayPal() {
		LOGGER.info("Selecting PayPal checkout...");
		sleep(sleeptimeout);
		clickNext();
		sleep(sleeptimeout);
		//JavascriptExecutor js = (JavascriptExecutor) getDriver();
		//js.executeScript("window.scrollBy(0,-1000)");
	//	evaluateJavascript("arguments[0].scrollIntoView(true);", payWithPayPal);
		sleep(200);
		payWithPayPal.waitUntilClickable().click();
		sleep(1000);
		reviewOrder.waitUntilClickable().click();
		sleep(1000);
	} 
}
