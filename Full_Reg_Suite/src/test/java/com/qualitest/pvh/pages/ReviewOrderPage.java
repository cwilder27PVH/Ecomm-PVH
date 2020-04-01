package com.qualitest.pvh.pages;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class ReviewOrderPage extends BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReviewOrderPage.class);

	@FindBy(id="WC_SingleShipmentOrderTotalsSummary_td_10")
	private BaseElement orderTotal;

	@FindBy(id = "singleOrderSummary")
	private BaseElement submitOrder;

	//@FindBy(id = "WC_SingleShipmentSummary_links_4")
	@FindBy(xpath="//div[@id='WC_SingleShipmentSummary_div_31']")
	public BaseElement backButton;
	
	//@FindBy(xpath="//*[@id='submitButtonWrapper']/a")
	@FindBy(xpath="//*[@class='paypal-button-label-container']")
	private BaseElement proceedToPaypal;
	
	//@FindBy(xpath="//*[@class='paypal-button-label-container']")
	//private List<BaseElement> proceedToPaypalList;
	
	
	@FindBy(xpath="//*[@class='right editOrder link']")
	private BaseElement editOrderLink;
	
	@FindBy(id="WC_ShippingAddressSelectSingle_link_1")
	private BaseElement changeAddress;
	
	@FindBy(id="editBillingAddressLink_a_edit_1")
	private BaseElement changeBillingAddress;

	
	@FindBy(xpath = "//*[@id = 'billingAddressList']//a[contains( text(), 'EDIT')]")
	private List<WebElement> editBillingAddressList;
	
	@FindBy(xpath = "//*[@class = 'checkoutBG clearfix']/a")
	private BaseElement editPayment;
	
	@FindBy(xpath = "//*[@class = 'checkoutBG']/a")
	private BaseElement editShippingMethod;
	
	@FindBy(xpath = "//*[@class = 'billing_method_card_new']/span")
	private List<WebElement> cardInformation;
	
	@FindBy(xpath = "//*[@class = 'billing_method_card_new']/span[1]")
	private BaseElement cardType;
	
	@FindBy(xpath = "//*[@class = 'billing_method_card_new']/span[2]")
	private BaseElement cardDigit;
	
	@FindBy(id="expiration")
	private BaseElement expiration;
	
	@FindBy(id="shippingInfo")
	private BaseElement shippingType;
	
	protected SoftAssertions SA = new SoftAssertions();
	
	/**
	 * Method to retrieve order total from cart page
	 */
	public float getOrderTotal() {
		try {
			String s = orderTotal.getText();
			s = s.replace("$", "");
			s = s.replace(",", "");
			LOGGER.info("Order total displayed on cart page is: " + s);
			float f = Float.parseFloat(s);
			return f;
		} catch (StaleElementReferenceException e) {
			sleep(sleeptimeout);
			pageRefresh();
			String s = orderTotal.getText();
			s = s.replace("$", "");
			s = s.replace(",", "");
			LOGGER.info("Order total displayed on cart page is: " + s);
			float f = Float.parseFloat(s);
			return f;
		}
	}

	/**
	 * Method to click submit order button
	 */
	public void clickSubmitOrder() {
		if(submitOrder.isVisible()) {
			LOGGER.info("Clicking submit order");
			submitOrder.waitUntilClickable().click();
			sleep(500);
		}
	}

	/**
	 * Method to click proceed to paypal button
	 */
	public void clickProceedToPaypal() {
		LOGGER.info("Clicking Proceed to paypal button");
		sleep(10000);
		proceedToPaypal.waitUntilClickable().click();
	}
	
	public void clickBackButton() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
		sleep(500);
		backButton.click();
	}
	
	public void clickEditButton() {
		// TODO Auto-generated method stub
		LOGGER.info("Clicking edit order");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		editOrderLink.click();
	}
	
	public void clickChangeAddress() {
		try {
			LOGGER.info("Clicking the change address button");
			changeAddress.click();
		} catch (Exception e) {
			LOGGER.info("Cannot find the change address button, so refreshing page");
			pageRefresh();
			pageRefresh();
			changeAddress.click();
		}
	}
	
	public void clickChangeBillingAddress() {
		try {
			LOGGER.info("Clicking the change billing address button");
			changeBillingAddress.click();
		} catch (Exception e) {
			LOGGER.info("Cannot find the change billing address button, so refreshing page");
			pageRefresh();
			pageRefresh();
			changeBillingAddress.click();
		}
	}
	public void clickSecondBillingAddressEdit() {
		LOGGER.info("Clicking the second edit button in the list of billing addresses");
		editBillingAddressList.get(1).click();
	}
	public void clickEditPayment() {
		LOGGER.info("Editing payment information...");
		editPayment.waitUntilClickable().click();
	}
	public void clickEditShippingMethod() {
		LOGGER.info("Editing shipping method...");
		editShippingMethod.click();
	}
	public void verifyPaymentInformation(String type, String cardNumber, String expMonth, String expYear) {
		sleep(500);
		SA.assertThat(cardType.getText()).isEqualTo(type);
		SA.assertThat(cardDigit.getText()).contains(cardNumber.substring(cardNumber.length()-4, cardNumber.length()));
		SA.assertThat(expiration.getText()).contains(expMonth);
		SA.assertThat(expiration.getText()).contains(expYear);
		SA.assertAll();
		
	}
	public void verifyShippingMethod(String shippingMethod) {
		SA.assertThat(shippingType.getText()).containsIgnoringCase(shippingMethod);
		SA.assertAll();
	}
	
}
