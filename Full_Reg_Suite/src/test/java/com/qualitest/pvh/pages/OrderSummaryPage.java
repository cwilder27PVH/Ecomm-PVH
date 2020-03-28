package com.qualitest.pvh.pages;

import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class OrderSummaryPage extends BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderSummaryPage.class); 
	
	@FindBy(xpath = "//*[@class='large orderThanksMessage']")
	private BaseElement pageHeader;
	
	@FindBy(id = "shopcartHomepage")
	private BaseElement continueShopping;
	
	@FindBy(xpath = "//*[@id = 'orderCancelMessage']/a[2]")
	//@FindBy(xpath = "//*[@id = 'orderCancelButton']")
	private BaseElement cancelOrder;

	@FindBy(xpath = "//*[@id = 'orderCancelMessage']/a")
	private BaseElement cancelOrder2;
	
	@FindBy(className = "headerMyAccount")
	private BaseElement nameOfAccount;
	
	@FindBy(xpath = "//*[@id='orderCancelSection']/div/a[1]")
	private BaseElement agreeToCancel;
	
	@FindBy(xpath = "//*[@title=\"Go to the My Account page\"]")
	private BaseElement accountPage;
	
	@FindBy(xpath = "//*[@id=\"WC_CheckoutPaymentAndBillingAddressSummaryf_div_3_\"]/div/div/span[1]")
	private BaseElement cardType;
	
	@FindBy(xpath = "//*[@class='product_title']")
	private List <WebElement> productTitles;
	
	@FindBy(id="WC_SingleShipmentOrderTotalsSummary_td_10")
	private BaseElement finalOrderTotal;
	
	@FindBy(xpath = "//span[contains(text(), 'Gift Card')]")
	protected BaseElement appliedGiftCard;
	
	 @FindBy(xpath = "//*[@class = 'shippingMethod']")   
	 private BaseElement shippingMethodText;
	 
	 @FindBy(xpath = "//*[@id=\"WC_CheckoutPaymentAndBillingAddressSummaryf_div_3_\"]/div/div/span")
	 private BaseElement paypalBilling;
	
	@FindBy(xpath = "//*[@id = 'discountDetailsSection']/div/div[2]")
	private List<WebElement> listOfDiscounts;
	
	@FindBy(xpath = "//*[@class = 'youSaved clearfix']/div[2]/div")
	private BaseElement totalSavings;
	
	protected SoftAssertions SA = new SoftAssertions();

	@FindBy(xpath = "//*[@id='pvhOverlayContentWrapper']/div[2]")
	private BaseElement popUp;
	
	@FindBy(xpath = "//*[@id=\"shoppingBagColumn2\"]/div[4]")
	private BaseElement cancellationField;
	
	@FindBy(xpath = "//*[contains( text(), 'Edit Order')]")
	private BaseElement editOrderButton;
	
	@FindBy(xpath = "//*[@id = 'continueOrderEditBtn']")
	private BaseElement editOrderConfirmButton;
	
	@FindBy(xpath = "//*[@class = 'orderDetailDetail'][1]")
	private BaseElement orderNumber;
	
	@FindBy(xpath = "//*[@class = 'receiptOrderNumber ng-binding']")
	private BaseElement orderNumberCKCA;
	
	
	public void verifyCancellation()
	{
		cancelOrder();
		SA.assertThat(cancellationField.getText().contains("THE ORDER HAS BEEN CANCELED SUCCESSFULLY")).isTrue();
		SA.assertAll();
	}
	
	
	/**
	 * Method to close pop up displayed on order summary page
	 */
	protected void clickOffPopUp() {
		LOGGER.info("Closing pop up displayed on order summary page");
		sleep(5000);
	    popUp.waitUntilVisible();
		popUp.click();
	}
	
	/**
	 * Method to click continue shopping on order summary page
	 */
	public void clickContinueShopping() {
		LOGGER.info("Clicking continue shopping");
		continueShopping.click();
	}
	
	/**
	 * Method to click cancel order on order summary page
	 */
	public void cancelOrder() {
		LOGGER.info("Clicking cancel order");
		sleep(5000);
		Actions a = new Actions(getDriver());
		 a.sendKeys(Keys.PAGE_UP).build().perform();
		cancelOrder.waitUntilVisible();
		cancelOrder.click();
		agreeToCancel.waitUntilClickable().click();
	}
	
	public void saveOrderNumber() {
		LOGGER.info("clicking pop up close");
		sleep(5000);
		//clickOffPopUp();
		String number = orderNumber.getText();
		LOGGER.info("Getting the order number as: "+number);
		Serenity.setSessionVariable("orderNumber").to(number);
	}
	
	public void saveOrderNumberCKCA() {
		String number = orderNumberCKCA.getText();
		LOGGER.info("Getting the order number as: "+number);
		Serenity.setSessionVariable("orderNumber").to(number);
	}
	
	/**
	 * Method to retrieve account name on order summary page
	 * @return - Account Name
	 */
	public String getNameOfAccount() {
		String text = nameOfAccount.getText();
		LOGGER.info("Getting the text of the account name: "+text);
		return text;
	}
	
	/**
	 * Method to navigate to my account page from order summary page
	 */
	public void clickOnAccountPage() {
		LOGGER.info("Clicking to go to account page");
		sleep(2000);
		accountPage.click();
	}
	
	/**
	 * Method to retrieve name of first product on order summary page
	 * @param i 
	 * @return - Name of product / order item
	 */
	protected String getNameOfProduct(int i) {
		String s = productTitles.get(i).getText();
		LOGGER.info("Returning a top cart item of: "+s);
		return s;
	}
	
	public String getTotalSavings() {
		String s = totalSavings.getText();
		s = s.replace("$", "");
		s = s.replace(",", "");
		LOGGER.info("Getting the modded total of savings as: "+s);
		return s;
	}
	public float getOrderTotal() {
		String s = finalOrderTotal.getText();
		s = s.replace("$", "");
		s = s.replace(",", "");
		LOGGER.info("Returning a modded subtotal of: "+s);
		float f = Float.parseFloat(s);
		return f;
	}
	
	public String getOrderTotalString() {
		String s = finalOrderTotal.getText();
		s = s.replaceAll("$", "");
		s = s.replaceAll(",", "");
		LOGGER.info("Returning a modded subtotal of: "+s);
		return s;
	}
	
	public String getCardType() {
		String type = cardType.getText();
		LOGGER.info("Returning a the card type as: "+type);
		return type;
	}

	private String getAmountTotalOfDiscounts() {
		double f = 0;
		for(WebElement w: listOfDiscounts) {
			String text = w.getText();
			text = text.replace("-", "");
			text = text.replace("$", "");
			LOGGER.info("Getting a discount of: "+text);
			double wDouble = Double.parseDouble(text);
			f+=wDouble;
		}
		String t = String.valueOf(f);
		LOGGER.info("The total number of discounts is: "+t);
		int index = t.indexOf('.');
		if(t.substring(index+1).equals("0")) {
			t=t+"0";
		}
		return t;
	}
	
	/**
	 * Method to verify details on order summary page
	 * @param name - Name of product
	 * @param price - Order total
	 * @param cardType - Credit Card Type
	 */
	public void verifyOrderDetails(String name, float price, String cardType) {
		if(!finalOrderTotal.isVisible())
		{
			clickOffPopUp();
		}
		LOGGER.info("Previously saved product information is : " + name + ":" + price + ":" + cardType);
		LOGGER.info("Name of first product displayed on order summary page is: " + getNameOfProduct(0));
		//SA.assertThat(getNameOfProduct(0)).isEqualTo(name);
		SA.assertThat(getNameOfProduct(0)).isEqualToIgnoringCase(name);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0, 500)");
		float i = getOrderTotal();
		LOGGER.info("Order total displayed on order summary page is: " + i);
		if(!appliedGiftCard.exists()) {
			SA.assertThat(i).isEqualTo(price);
		}else if(appliedGiftCard.exists()) {
			SA.assertThat(i).isEqualTo(price-100);
		}
		
		String card = getCardType();
		LOGGER.info("Credit card type displayed on order summary page is: " + card);
		SA.assertThat(card).isEqualTo(cardType);
		
		SA.assertAll();
	}
		
	
	public void verifyFinalOrderDetailsWithShopRunner(String name, float price, String cardType) {

		float i = getOrderTotal();
		LOGGER.info("The order total is: " + i);
		String card = getCardType();
		LOGGER.info("The card type is: " + card);
		LOGGER.info("The name of the product is: " + getNameOfProduct(0));
		SA.assertThat(getNameOfProduct(0)).isEqualTo(name);
		if(!appliedGiftCard.exists()) {
			SA.assertThat(i).isEqualTo(price);
		}else if(appliedGiftCard.exists()) {
			SA.assertThat(i).isEqualTo(price-100);
		}
		SA.assertThat(card).isEqualTo(cardType);
		SA.assertThat(removeSpacesInString(getShippingMethodText())).as("Shipping method text").isEqualToIgnoringCase("ShopRunnerFree2DayShipping$0.00");
		SA.assertAll();
	}
	   private String getShippingMethodText() {
	        String s = shippingMethodText.getText();
	        LOGGER.info("Getting the shipping method text as: "+s);
	        return s;
	    }
	   public String removeSpacesInString(String l) {
	        String s = l.replaceAll("\\s", "");
	        LOGGER.info("Modded string returned is: "+s);
	        return s;
	    }
	   
	public void verifyFinalOrderDetailsWithShopRunner(String name, float price) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0, 500)"); 
        float i = getOrderTotal();
        LOGGER.info("The order total is: " + i);
        LOGGER.info("The name of the product is: " + getNameOfProduct(0));
        SA.assertThat(getNameOfProduct(0)).isEqualTo(name);
        if(!appliedGiftCard.exists()) {
            SA.assertThat(i).isEqualTo(price);
        }else if(appliedGiftCard.exists()) {
            SA.assertThat(i).isEqualTo(price-100);
        }
        SA.assertThat(removeSpacesInString(getShippingMethodText())).as("Shipping method text").contains("ShopRunnerFree2Day");
        SA.assertAll();
    }
	
	public void verifyFinalOrderDetailsWithPaypal(String name, float price) {
		 
        float i = getOrderTotal();
        LOGGER.info("The order total is: " + i);
        LOGGER.info("The name of the product is: " + getNameOfProduct(0));
        SA.assertThat(getNameOfProduct(0)).isEqualTo(name);
        if(!appliedGiftCard.exists()) {
            SA.assertThat(i).isEqualTo(price);
        }else if(appliedGiftCard.exists()) {
            SA.assertThat(i).isEqualTo(price-100);
        }
        SA.assertThat(paypalBilling.getText()).isEqualTo("PayPal");
        SA.assertAll();
    }
	public void verifyLoyaltyAppliedToTotal(String expectedTotal, String expectedTotalDiscounted) {
		
		SA.assertThat(getOrderTotalString()).isEqualTo(expectedTotal);
		SA.assertThat(getAmountTotalOfDiscounts()).isEqualTo(expectedTotalDiscounted);
		SA.assertAll();
		
	}
	
	public void verifyLoyaltySavingsApplied(String savings, String expSavings) {
		try
		{
		    Thread.sleep(5000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		SA.assertThat(getAmountTotalOfDiscounts()).isEqualTo(expSavings);
		SA.assertThat(getTotalSavings()).isEqualTo(savings);
		SA.assertAll();
	}
	
	public void verifyLoyaltySavingsAndGiftCard(String expSavings, String savings, String name, float price, String cardType) {
		clickOffPopUp();
		try
		{
		    Thread.sleep(5000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		
		LOGGER.info("Name of first product displayed on order summary page is: " + getNameOfProduct(0));
		SA.assertThat(getNameOfProduct(0)).isEqualTo(name);
		
		float i = getOrderTotal();
		LOGGER.info("Order total displayed on order summary page is: " + i);
		if(!appliedGiftCard.exists()) {
			SA.assertThat(i).isEqualTo(price);
		}else if(appliedGiftCard.exists()) {
			SA.assertThat(i).isEqualTo(price);
		}
		
		String card = getCardType();
		LOGGER.info("Credit card type displayed on order summary page is: " + card);
		SA.assertThat(card).isEqualTo(cardType);
		
		SA.assertThat(getAmountTotalOfDiscounts()).isEqualTo(expSavings);
		SA.assertThat(getTotalSavings()).isEqualTo(savings);
		SA.assertAll();
	}
	
	private void clickEdit() {
		LOGGER.info("Clicking the edit button");
		editOrderButton.click();
	}
	
	private void clickEditConfirm() {
		LOGGER.info("Clicking the edit confirm button");
		editOrderConfirmButton.click();
	}
	
	public void editOrder() {
		sleep(1000);
		clickEdit();
		clickEditConfirm();
	}

	public String getColorText(String sizeNumber) {
		// TODO Auto-generated method stub
		String colorXpath = "//div[@data-part-number='"+sizeNumber+"']//div[@class='color']";
		String color = find(By.xpath(colorXpath)).getText();
		String updatedColor = color.replaceAll("Color: ", "");
		return updatedColor;
	}
	
	public String getProductQunt(String sizeNumber) {
		// TODO Auto-generated method stub
		String quntXpath = "//div[@data-part-number='"+sizeNumber+"']//div//div//div[@class='quantity']/span";
		String quantity = find(By.xpath(quntXpath)).getText();
		//String updatedColor = color.replaceAll("Color: ", "");
		return quantity;
	}
	
	public void verifyUpdatedProductColor() {
		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		LOGGER.info("The product color on Order Summary page is: "+getColorText(itemStyle));
		SA.assertThat(getColorText(itemStyle)).isEqualTo(Serenity.sessionVariableCalled("item1Color"));
		SA.assertAll();
	}
	
	public void verifyUpdatedProductQuanity() {
		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		LOGGER.info("The product quanity on Order Summary page is: "+getProductQunt(itemStyle));
		SA.assertThat(getProductQunt(itemStyle)).isEqualTo(Serenity.sessionVariableCalled("item1Quant"));
		SA.assertAll();
	}
	
}
