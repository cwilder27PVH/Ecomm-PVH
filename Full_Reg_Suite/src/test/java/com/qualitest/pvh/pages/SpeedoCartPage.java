package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.icu.math.BigDecimal;
import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoCartPage extends CartPage {

	public static final Logger LOGGER = LoggerFactory.getLogger(SpeedoCartPage.class);
	
	@FindBy(xpath = "//*[@id='WC_OrderItemDetailsf_links_1_1_']")
	private BaseElement edit;
	
	@FindBy(xpath = "//iframe[@title='expresscheckout']")
	private BaseElement shopRunnerFrame;
	
	@FindBy(xpath = "//*[@class = 'registeredUser link'][1]")
	private BaseElement myAccount;
	
	//@FindBy(id="srd_XC")
	@FindBy (xpath = "//*[@id='srd_XC']")
	private BaseElement shopRunner;
	
	@FindBy(id="sr_signin_email")
	private BaseElement shopRunnerEmail;
	
	@FindBy(id="sr_signin_password")
	private BaseElement shopRunnerPassword;
	
	@FindBy(id="sr_sign_in_button")
	private BaseElement shopRunnerSignIn;
	
	@FindBy(id="pr_complete_btn")
	private BaseElement shopRunnerCompleteCheckout;
	

	@FindBy (xpath = "//*[@id='mini_cart_link']/span")
	private BaseElement ItemsInBag;
	
	public int getNumItemsInBag()
	{
		return Integer.parseInt(ItemsInBag.getText());
	}

	@FindBy(xpath = "//*[@id = 'WC_SingleShipmentOrderTotalsSummary_td_4']")
	private BaseElement totalDiscountedRightColumn;

	public void clickFirstEdit() {
	//	getDriver().navigate().refresh();
		LOGGER.info("Clicking the edit button for the first or top product on cart page");
		edit.click();
	}
	public void verifySignIn() {
		Boolean bool = false;
		if(myAccount.exists()) {
			bool = true;
		}else {
			bool = false;
		}
		assertThat(bool).isTrue();
	}
	
	private String getTotalDiscountedRightColumn() {
		String s = modString(totalDiscountedRightColumn.getText());
		LOGGER.info("Getting the total discounted on the right side as: "+s);
		return s;
	}
	
	private void clickCheckoutWithShopRunner() {
		LOGGER.info("Clicking on checkout with Shoprunner");
		sleep(5000);
		evaluateJavascript("arguments[0].scrollIntoView();", shopRunner);
		shopRunner.waitUntilClickable().click();
	}
	
	private void signInWithShopRunner(String email, String password) {
		LOGGER.info("Entering shoprunner email and password: " + email + "and" + password);
		shopRunnerEmail.type(email);
		shopRunnerPassword.type(password);
		shopRunnerSignIn.click();
	}
	
	private void completeCheckout() {
		LOGGER.info("Completing shoprunner checkout...");
		shopRunnerCompleteCheckout.click();
	}
	
	public void loginWithShoprunner(String email, String password) {
		pageRefresh();
		clickCheckoutWithShopRunner();
		try{
		    Thread.sleep(4000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		signInWithShopRunner(email, password);
	}
	public void checkoutShoprunner() {
		completeCheckout();
	}
	
	private String getDiscountedFirstPrice() {
		String firstPriceFinal = getFirstPriceFinal();
		double firstPriceFinalDouble = Double.parseDouble(firstPriceFinal);
		double discount = firstPriceFinalDouble*(.25);
		String s = String.valueOf(BigDecimal.valueOf(discount).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		if(s.substring(s.indexOf(".")+1).length() == 1) {
			s = s+"0";
		}
		LOGGER.info("Returning a discounted total of: "+s);
		return s;
	}
	
	private String getDiscountedSecondPrice() {
		String secondFinalPrice = getSecondPriceFinal();
		double SecondPriceFinalDouble = Double.parseDouble(secondFinalPrice);
		double discount = SecondPriceFinalDouble*(.25);
		String s = String.valueOf(BigDecimal.valueOf(discount).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
		if(s.substring(s.indexOf(".")+1).length() == 1) {
			s = s+"0";
		}
		LOGGER.info("Returning a discounted total of: "+s);
		return s;
	}
	
	@Override
	public void verifyValidPromoForFirstItem(String code) {
		if(code.equals("LTF25")) {
			assertThat(getDiscountedFirstPrice()).as("The discounted price of the first item").isEqualTo(getTotalDiscountedRightColumn());
		}
	}
	
	@Override
	public void verifyValidPromoForMulitpleItems(String code) {
		if(code.equals("LTF25")) {
			if(listOfItems.size() != 2) {
				LOGGER.info("The List is not equal to 2, so this will not work");
				return;
			}
			double firstPrice = Double.parseDouble(getDiscountedFirstPrice());
			double secondPrice = Double.parseDouble(getDiscountedSecondPrice());
			String finale = String.valueOf(firstPrice+secondPrice);
			if(finale.substring(finale.indexOf(".")+1).length() == 1) {
				finale = finale+"0";
			}
			SA.assertThat(finale).as("The discounted price of the first item").isEqualTo(getTotalDiscountedRightColumn());
		}
	}
	
	private boolean isPromoRemoved() {
		boolean  discountIsThere = false;
		if(!totalDiscountedRightColumn.isVisible()) {
			discountIsThere = true;
		}
		return discountIsThere;
	}

	@Override
	public void verifyNoPromoApplied(String code) {
		if(code.equals("LTF25")) {
			SA.assertThat(getDiscountedFirstPrice()).as("The discounted price of the first item").isEqualTo(getTotalDiscountedRightColumn());
			removePromoCode();
			SA.assertThat(isPromoRemoved()).as("Promo Removed").isTrue();
			SA.assertAll();
		}
	}
	
	//MM4152019 Added method and xpath for the Verifying product price displayed in cart matches to price  
		public void verifyCartNameMatchesItemPage(String name, float price) {
			
			String itemStyle = Serenity.sessionVariableCalled("styleNumber");
			
			LOGGER.info("Verifying name displayed in cart matches to " + name);
			//sleep(50000)
			String namePath="//div[@data-part-number='"+itemStyle+"']//div[@class='product_title']//a";
			String productNameOnCart = find(By.xpath(namePath)).getText();
			LOGGER.info("Comparing " + productNameOnCart + " on cart matches with "+name);
			SA.assertThat(productNameOnCart.equalsIgnoreCase(name));	
			
			
			LOGGER.info("Verifying product price displayed in cart matches to " + price);
			String productPriceOnPDP = Float.toString(price);
			String pricePath = "//div[@data-part-number='"+itemStyle+"']//span[contains(@class,'price')]";
			String productPriceOnCart = find(By.xpath(pricePath)).getText();
			
			productPriceOnCart = productPriceOnCart.replace("$", "");
			productPriceOnCart = productPriceOnCart.replaceAll(",", "");
			if(productPriceOnCart.contains("CAD")) {
				productPriceOnCart = productPriceOnCart.replace("CAD ", "");
			}

			LOGGER.info("Comparing " + productPriceOnCart + " on cart matches with "+productPriceOnPDP);
			SA.assertThat(productPriceOnCart.equalsIgnoreCase(productPriceOnPDP));
			SA.assertAll();
		}
		
}
//end
