package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;
import java.text.DecimalFormat;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;

public class THCartPage extends CartPage{
	
	/**
	 * Page Objects
	 */
	@FindBy(id="fromMsgText")
	private BaseElement fromText;
	
//	@FindBy(id="addWrap")
	@FindBy(xpath = "//input[@id='addWrap']")
	private BaseElement giftBox;

	@FindBy(id="messageFromInput")
	private BaseElement giftFrom;
	
	@FindBy(id="giftMessageInput")
	private BaseElement giftMessage;

	@FindBy(id="messageToInput")
	private BaseElement giftTo;
	
	@FindBy(id="shopcartSubmitGiftBox")
	private BaseElement submitGiftBox;
	
	@FindBy(xpath= "//a[@class='link wishlistLink']")
	private BaseElement addToWishlist;
	
	@FindBy(xpath = "//*[@id = 'promotion_1']")
	private BaseElement removePromotion;
	
	@FindBy(xpath = "//div[@class='dropKickWrapper clearfix']")
	protected BaseElement quantityDropDown;
	
	@FindBy(xpath = "//a[@id='replaceBtn']")
	private BaseElement updateBag;

	@FindBy (xpath = "//*[@id='mini_cart_link']/span")
	private BaseElement ItemsInBag;
	/**
	 * End Page Objects
	 */
	
	/**
	 * Calling Classes
	 */
	private SoftAssertions SA = new SoftAssertions();
	/**
	 * End Calling Classes
	 */
	
	public void addToWishlist() {
		LOGGER.info("Adding item to wishlist from cart page...");
		addToWishlist.waitUntilClickable().click();
	}
	

	public void verifyAddToWishlistOnMobileForGuestUser() {
		LOGGER.info("Verifying adding item to wishlist is not available from cart page for guest user...");
		SA.assertThat(addToWishlist.isVisible()).as("The Wish List button is not available for guest user").isFalse();
	}
	
	private void insertGiftBoxInfo(String To, String From, String Message) {
		LOGGER.info("Inserting gift box information...");
		giftTo.type(To);
		giftFrom.type(From);
		giftMessage.type(Message);
	}
	
	private void clickSubmitGiftBox() {
		LOGGER.info("Submitting gift box...");
		submitGiftBox.click();
	}
	
	private void clickAddGiftBox() {
		LOGGER.info("Adding gift box...");
		sleep(500);
		//evaluateJavascript("arguments[0].scrollIntoView();", giftBox);
		//evaluateJavascript("arguments[0].scrollIntoView(true);", giftBox); 
		giftBox.click();
	}
	
	public void addGiftBox(String to, String from, String message) {
		clickAddGiftBox();
		insertGiftBoxInfo(to,from,message);
		clickSubmitGiftBox();
	}
	
	public int getNumItemsInBag()
	{
		try {
			return Integer.parseInt(ItemsInBag.getText());
		}catch(Exception E) {
			return 0;
		}
		
	}
	protected String modString(String s) {
		s = s.replaceAll("\\s", "");
		s = s.replace("$", "");
		s = s.replace("-", "");
		LOGGER.info("Returning a modded string of: "+s);
		return s;
	}
	
	public void verifyFirstSize(String size) {
		getDriver().navigate().refresh();
		String pageSize = getFirstSize();
		if(pageSize.equalsIgnoreCase("os")) {
			assertThat(pageSize).as("First Cart Item size").isEqualToIgnoringCase(size);
		}
		else if(pageSize.contains("/")) {
			String[] pageArr = pageSize.split("/");
			String[] savedArr = size.split("/");
			SA.assertThat(pageArr[0]).as("first size").isEqualToIgnoringCase(savedArr[0]);
			SA.assertThat(pageArr[1]).as("second size").isEqualToIgnoringCase(savedArr[1]);
			SA.assertAll();
		}else {
			assertThat(pageSize).as("First Cart item size").isEqualToIgnoringCase(size);
		}
	}
	private String getFirstDiscountedAmount() {
		String s = discountedAmount.get(0).getText();
		LOGGER.info("Returning the first discounted price of: "+s);
		return s;
	}

	private String getTotalPriceOfFinals(double discount) {
		double ret = 0.0;
		for(WebElement w: priceFinal) {
			String price = modString(w.getText());
			double priceDouble = Double.parseDouble(price);
			ret += priceDouble;
		}
		DecimalFormat df = new DecimalFormat(".##");
		ret = ret*discount;
		String s = df.format(ret);
		LOGGER.info("Returning a final price total of: "+s);
		String d = s.substring(s.indexOf('.')+1);
		if(d.equals("0")) {
			s = s+"0";
		}
		return s;
	}
	
	private void clickRemovePromotion() {
		LOGGER.info("Clicking the removal of promotion");
		removePromotion.click();
		try
		{
		    Thread.sleep(2000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	public void verifyRemovalOfPromotion() {
		SA.assertThat(discountedAmount.size()).isGreaterThan(0);
		clickRemovePromotion();
		SA.assertThat(discountedAmount.size()).isEqualTo(0);
		SA.assertAll();
	}
	
	
	private String getTotalDiscountedMoney() {
		double ret = 0.0;
		for(WebElement w: discountedAmount) {
			String price = modString(w.getText());
			double priceDouble = Double.parseDouble(price);
			ret += priceDouble;
		}
		DecimalFormat df = new DecimalFormat(".##");
		String s = df.format(ret);
		LOGGER.info("Returning a discounted total of: "+s);
		String d = s.substring(s.indexOf('.')+1);
		if(d.equals("0")) {
			s = s+"0";
		}
		return s;
	}
	
	public void verifyPromoAppliedForMultiple(String code) {
		for(WebElement w: listOfItems) {
			LOGGER.debug("Verifying: "+w.getText()+" and "+code +" are valid");
		}
		if(code.equalsIgnoreCase("EXTRAEXTRA")) {
			String discount = getTotalDiscountedMoney();
			String price = getTotalPriceOfFinals(.3);
			
			assertThat(discount).as("Discounted Price").isEqualTo(price);
		}
		
	}
	
	public void verifyPromoApplied(String code) {
		String topItemName = getNameOfProduct(0);
		LOGGER.debug("Verifying: "+topItemName+" and "+code +" are valid");
		if(code.equalsIgnoreCase("EXTRAEXTRA")) {
			String price = modString(getFirstPriceFinal());
			double priceDouble = Double.parseDouble(price);
			String discount = modString(getFirstDiscountedAmount());
			double answer = priceDouble*(.3);
			DecimalFormat df = new DecimalFormat(".##");
			String check = df.format(answer);
			LOGGER.info("The discount that was displayed was: "+check);
			String s = check.substring(check.indexOf('.')+1);
			if(s.equals("0")) {
				check = check+"0";
			}
			assertThat(discount).as("Discounted Price").isEqualTo(check);
		}
	}


	public void updateQuantityWithoutCheckStock() {
		LOGGER.info("Selecting quantity ="+Serenity.sessionVariableCalled("item1Quant"));
		sleep(300);
	    evaluateJavascript("arguments[0].scrollIntoView();", updateBag);
	  	sleep(500);
	  	quantityDropDown.click();
		String dropdown = "//div[@class='dropKickWrapper clearfix']//ul/li["+Serenity.sessionVariableCalled("item1Quant")+"]";
		find(By.xpath(dropdown)).click();
		sleep(500);
		updateBag.click();
		}
	
	public void verifyCartNameMatchesItemPage(String name, float price) {
		/*float i = getQuantity(0);
		i = i * getProductTotal(0);
		
		SA.assertThat(getNameOfProduct(0)).isEqualToIgnoringCase(name);
		SA.assertThat(i).isEqualTo(price *getQuantity(0));
		SA.assertAll();*/


		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		
		LOGGER.info("Verifying name displayed in cart matches to " + name);
		String namePath="//div[@data-part-number='"+itemStyle+"']//div[@class='product_title']//a";
		String productNameOnCart = find(By.xpath(namePath)).getText();
		LOGGER.info("Comparing " + productNameOnCart + " on cart matches with "+name);
		SA.assertThat(productNameOnCart.equalsIgnoreCase(name));	
		
		
		LOGGER.info("Verifying product price displayed in cart matches to " + price);
		String productPriceOnPDP = Float.toString(price);
		String offerPricePath = "//div[@data-part-number='"+itemStyle+"']//span[contains(@class,'price offer')]";
		String pricePath = "//div[@data-part-number='"+itemStyle+"']//span[contains(@class,'price')]";
		if(find(By.xpath(offerPricePath)).isPresent()) {
		String productPriceOnCart = find(By.xpath(offerPricePath)).getText();
		
		productPriceOnCart = productPriceOnCart.replace("$", "");
		productPriceOnCart = productPriceOnCart.replaceAll(",", "");
		if(productPriceOnCart.contains("CAD")) {
			productPriceOnCart = productPriceOnCart.replace("CAD ", "");
		}

		LOGGER.info("Comparing " + productPriceOnCart + " on cart matches with "+productPriceOnPDP);
		SA.assertThat(productPriceOnCart.equalsIgnoreCase(productPriceOnPDP));
		}
		else
		{
			String productPriceOnCart = find(By.xpath(pricePath)).getText();
			
			productPriceOnCart = productPriceOnCart.replace("$", "");
			productPriceOnCart = productPriceOnCart.replaceAll(",", "");
			if(productPriceOnCart.contains("CAD")) {
				productPriceOnCart = productPriceOnCart.replace("CAD ", "");
			}

			LOGGER.info("Comparing " + productPriceOnCart + " on cart matches with "+productPriceOnPDP);
			SA.assertThat(productPriceOnCart.equalsIgnoreCase(productPriceOnPDP));
		}
		SA.assertAll();
	}
	
	public void clickMobileEditButton()
	{
		String styleNumber = Serenity.sessionVariableCalled("styleNumber");
		//LOGGER.info("item number is: "+styleNumber);
		try {
		    evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
		    sleep(500);
			LOGGER.info("Clicking the edit item button");
			//editButtonList.get(0).click();
			String itemXpath = "//div[@data-part-number='"+styleNumber+"']//a[contains(@id,'WC_OrderItemDetailsf_links')]//span[contains(text(),'Edit')]";
			find(By.xpath(itemXpath)).click();
		} catch (Exception e) {
			LOGGER.info("Cannot find edit item button refreshing");
			pageRefresh();
			pageRefresh();
		    evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)");
		    sleep(500);
			String itemXpath = "//div[@data-part-number='"+styleNumber+"']//a[contains(@id,'WC_OrderItemDetailsf_links')]//span[contains(text(),'Edit')]";
			find(By.xpath(itemXpath)).click();
			//editButtonList.get(0).click();
		}
		
	}	
	
	public void verifyMultipleItemsInCart(String firstItem, String secondItem, float firstPrice, float secondPrice) {
		
		LOGGER.info("Verifying both product names displayed in cart matches to " + firstItem +" and " +secondItem);
		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		String secondItemStyle = Serenity.sessionVariableCalled("secondStyleNumber");
	
		String firstproductNamePath="//div[@data-part-number='"+itemStyle+"']//div[@class='product_title']//a";
		String secondproductNamePath="//div[@data-part-number='"+secondItemStyle+"']//div[@class='product_title']//a";
		String firstProductNameOnCart = find(By.xpath(firstproductNamePath)).getText();
		String secondProductNameOnCart = find(By.xpath(secondproductNamePath)).getText();
		LOGGER.info("Verifying first product name from PDP :"+ firstItem+" is matching to the name in cart :"+firstProductNameOnCart);
		LOGGER.info("Verifying second product name from PDP :"+ secondItem+" is matching to the name in cart :"+secondProductNameOnCart);
		SA.assertThat(firstProductNameOnCart.equalsIgnoreCase(firstItem));
		SA.assertThat(secondProductNameOnCart.equalsIgnoreCase(secondItem));
		
		LOGGER.info("Verifying both product prices displayed in cart matches to product prices in PDP");
		String firstProductPriceOnPDP = Float.toString(firstPrice);
		String secondProductPriceOnPDP = Float.toString(secondPrice);		
		String firstProductPricePath = "//div[@data-part-number='"+itemStyle+"']//span[contains(@class,'price')]";
		String secondProductPricePath = "//div[@data-part-number='"+secondItemStyle+"']//span[contains(@class,'price')]";
		String firstProductPriceOnCart = find(By.xpath(firstProductPricePath)).getText();
		String secondProductPriceOnCart = find(By.xpath(secondProductPricePath)).getText();
		
		firstProductPriceOnCart = firstProductPriceOnCart.replace("$", "");
		firstProductPriceOnCart = firstProductPriceOnCart.replaceAll(",", "");
		if(firstProductPriceOnCart.contains("CAD")) {
			firstProductPriceOnCart = firstProductPriceOnCart.replace("CAD ", "");
		}
		secondProductPriceOnCart = secondProductPriceOnCart.replace("$", "");
		secondProductPriceOnCart = secondProductPriceOnCart.replaceAll(",", "");
		if(secondProductPriceOnCart.contains("CAD")) {
			secondProductPriceOnCart = secondProductPriceOnCart.replace("CAD ", "");
		}
		LOGGER.info("Verifying first product price from PDP :"+ firstProductPriceOnPDP+" is matching to the price in cart :"+firstProductPriceOnCart);
		LOGGER.info("Verifying second product price from PDP :"+ secondProductPriceOnPDP+" is matching to the price in cart :"+secondProductPriceOnCart);
		SA.assertThat(firstProductPriceOnPDP.equalsIgnoreCase(firstProductPriceOnCart));
		SA.assertThat(secondProductPriceOnPDP.equalsIgnoreCase(secondProductPriceOnCart));
		SA.assertAll();
		
		
	}
}
