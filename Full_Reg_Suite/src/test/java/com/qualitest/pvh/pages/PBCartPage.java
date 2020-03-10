package com.qualitest.pvh.pages;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;

public class PBCartPage extends CartPage{
	
	
	
	/**
	 * Page Objects 
	 */
	@FindBy(xpath="//a[@class='primary focusListener'][contains(text(),'Remove')]")
	private BaseElement removeGiftBox;
	
	@FindBy(xpath = "//a[contains(text(),'Edit')]")
	private BaseElement editGiftBox;
	
	@FindBy(xpath = "//a[@id='WC_OrderItemDetailsf_links_2_1']")
	private List<WebElement> removeList;
	
	@FindBy(xpath ="//div[@class='noGiftNote']//label[@class='checkbox']")
	private BaseElement noGiftNote;
	
	@FindBy(xpath ="//div[@class='giftBoxingLabelWrapper']//label[@class=")
	private BaseElement addGiftReceipt;
	
	@FindBy(xpath ="//a[@id='shopcartSubmitGiftBox']")
	private BaseElement submitGiftBox;
	
	@FindBy(xpath ="//input[@id='messageFromInput']")
	private BaseElement giftFrom;
	
	@FindBy(xpath ="//textarea[@id='giftMessageInput']")
	private BaseElement giftMessage;
	
	@FindBy(xpath ="//input[@id='messageToInput']")
	private BaseElement giftTo;
	
	//@FindBy(xpath ="//input[@id='addWrap']")
	@FindBy(xpath ="//body/div[@id='page']/main[@id='contentWrapper']/div[@class='content_wrapper']/div[@class='content_left_shadow']/div[@class='content_right_shadow']/div[@class='main_content']/div[@class='container_content_rightsidebar shop_cart']/div[@class='left_column clearfix']/div[@id='ShopCartDisplay']/div[@id='box']/div[@id='WC_ShopCartDisplay_div_5']/div[@id='ShopCartPagingDisplay']/div[@id='shoppingBagColumn2']/div[@class='giftOptionsWrapper']/div[@id='giftOptionsWrpr']/div[@class='checkoutContent']/div[1]/label[1]")
	private BaseElement giftBox;
	
	@FindBy(xpath = "//body//div[@id='page']//main[@id='contentWrapper']//div[contains(@class,'content_wrapper')]//div[contains(@class,'content_left_shadow')]//div[contains(@class,'content_right_shadow')]//div[contains(@class,'main_content')]//div[contains(@class,'container_content_rightsidebar shop_cart')]//div[contains(@class,'left_column clearfix')]//div[@id='ShopCartDisplay']//div[@id='box']//div[@id='WC_ShopCartDisplay_div_5']//div[@id='ShopCartPagingDisplay']//div[contains(@class,'content_wrapper')]//div[contains(@class,'orderSummaryTable')]//div[contains(@class,'orderProducts')]//div[contains(@class,'')]//div[contains(@class,'productLeft clearfix')]//div[contains(@class,'info')]//div//div[contains(@class,'linkGroup clearfix')]//a[2]//span[1]")
//	@FindBy(xpath = "//div[contains(@class,'linkGroup clearfix')]/a[1]")
	private BaseElement edit;
	
	@FindBy(xpath = "//a[@id='WC_OrderItemDetailsf_links_2_2']")
	private BaseElement secondRemove;
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	private BaseElement closePopUp;
	
	@FindBy(xpath = "//*[@class = 'product_title']/h3/a")
	private List<WebElement> listOfItems;
	
	@FindBy(xpath = "//*[@class= 'low']")
	private BaseElement lowStock;
	
	@FindBy(xpath = "//*[@class= 'total']")
	private List<WebElement> prices;
	
	@FindBy(xpath = " //span[contains(text(),'Proceed to Secure Checkout')]")
//	@FindBy(xpath = "//a[@class='primary green checkoutBttn fullWidth tall bold focusListener']")
//	WebElement proceedCheckOut = driver.findElement(By.xpath("//a[@id='guestShopperContinue']"));
	private BaseElement proceedCheckOut;
	
//	@FindBy(xpath = "//*[@id = 'qty_']")
	@FindBy(xpath = "//select[@id='qty_']")
	private List<WebElement> quantities;
	
	@FindBy(xpath = "//*[@id = 'shopping-bag-link']")
	private BaseElement checkOut;
	
	private SoftAssertions SA = new SoftAssertions();
	
	@FindBy(xpath = "//*[@id = 'SimpleSearchForm_SearchTerm']")
	private BaseElement search;
	
	@FindBy(xpath = "//*[@class = 'searchLink magGlass']")
	private BaseElement searchEnter;
	
	@FindBy(id = "WC_SingleShipmentOrderTotalsSummary_td_2")
	private BaseElement subtotal;
	
	@FindBy(xpath = "//*[@class = 'unitPrice']")
	private List<WebElement> totals;
	
	@FindBy(xpath = "//*[@class='productRight']/div[2]/div[2]")
	private List<WebElement> discountPrice;
	
	@FindBy(xpath = "//*[@class = 'productRight']")
	private List<WebElement> productOrderDetails;

	@FindBy(xpath = "//*[@class = 'shoppingBagHeader clearfix']/h1")
	private BaseElement shoppingBagTitle;
	
	@FindBy(xpath = "//div[@id = 'page']/*[@id = 'pageLevelMessage']")
	private BaseElement pageLevelError;

	/**
	 * End of Page Objects 
	 */
	
	/**
	 * Calling Various Classes 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(CKCartPage.class); 
	/**
	 * End of Calling Various Classes 
	 */
	
	public void removeFirstItem() {
		sleep(1500);
		try {
		int size = removeList.size();
		LOGGER.info("Total line items in cart are "+size);
		for (int i=size; i > 0; i--) {
			LOGGER.info("Removing line item number"+i);
			removeList.get(i-1).click();
		}
		/*if(removeList.size() == 2) {
			LOGGER.info("Clicking the second remove");
			removeList.get(1).click();
			sleep(1000);
			removeList.get(0).click();
			sleep(500);
		}else {
			LOGGER.info("Clicking the first remove");
			removeList.get(0).click();
			sleep(1000);
		}*/
		}catch(Exception e) {	
		}
	}
	
	private void clickSubmitGiftBox() {
		LOGGER.info("Submitting gift box...");
		submitGiftBox.click();
	}
	
	private void insertGiftBoxInfo(String To, String From, String Message) {
		LOGGER.info("Inserting gift box information...");
		sleep(5000);
		giftTo.type(To);
		giftFrom.type(From);
		giftMessage.type(Message);
	}
	
	private void clickEditGiftBox() {
		LOGGER.info("Editing gift box...");
		//pageRefresh();
		sleep(5000);
		evaluateJavascript("arguments[0].scrollIntoView();", giftBox);
		editGiftBox.waitUntilClickable().click();
	 // editGiftBox.waitUntilClickable();
	}
	
	public void editGiftBox(String newTo, String newFrom, String newMessage) {
		clickEditGiftBox();
		insertGiftBoxInfo(newTo, newFrom, newMessage);
		clickSubmitGiftBox();
	}

	public void removeGiftBox() {
		LOGGER.info("Removing gift box...");
		sleep(500);
	 //   evaluateJavascript("arguments[0].scrollIntoViewIfNeeded(true);", giftBox);
		evaluateJavascript("arguments[0].scrollIntoView();", giftBox);
		removeGiftBox.waitUntilClickable().click();
	}
	private void clickAddGiftBox() {
		LOGGER.info("Adding gift box...");
//		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
//		((JavascriptExecutor) driver).executeScript(
//	            "arguments[0].scrollIntoView();", giftBox);
//		Scroll.to(giftBox);
//		driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
//		WebElement lastElement = 
//				driver.findElement(By.xpath("//input[@id='addWrap']"));
//				int y = lastElement.getLocation().getY();
//				JavascriptExecutor js = (JavascriptExecutor)driver;
//				js.executeScript("window.scrollTo(0,"+y+")");
//		giftBox.waitUntilVisible();
//		giftBox.waitUntilClickable();
		sleep(500);
	   // evaluateJavascript("arguments[0].scrollIntoViewIfNeeded(true);", giftBox);
		giftBox.click();
	}
	
	public void addGiftBox(String to, String from, String message) {
		clickAddGiftBox();
		insertGiftBoxInfo(to,from,message);
		clickSubmitGiftBox();
	}
	
	public void clickFirstEdit() {
		LOGGER.info("Clicking the edit button for the first or top product on cart page");
		sleep(500);
		String editXpath = "//div[@data-part-number='"+Serenity.sessionVariableCalled("styleNumber")+"']//div[contains(@class,'linkGroup clearfix')]//a[2]//span[1]"; 
		find(By.xpath(editXpath)).click();
				//edit.click();
	}
	
	public void removeSecondItem() {
		LOGGER.info("Clicking the second remove");
		secondRemove.click();
	}
	
	public Float checkStock() {
		if(lowStock.exists()) {
			LOGGER.info("Lowstock message: " + lowStock.getText());
			String str = lowStock.getText();
			
			str = str.replaceAll("\\D+", "");
			Float stock = Float.parseFloat(str);
			return stock;
		}else {
			return (float) 0.0;
		}
	
	}
	
	
	public void clickClosePopUp() {
		LOGGER.info("Clicking to close pop up");
		try{
			closePopUp.click();
		}catch(Exception e) {
		}
	}
	
	
	/**
	 * Method to click proceed to checkout on cart page
	 */
	
	public void clickProceedCheckOut() {
		LOGGER.info("Clicking Proceed To Secure Checkout");
		Scroll.to(proceedCheckOut);
		proceedCheckOut.waitUntilClickable().click();
	}
	
	
	public void editProduct() {
		edit.click();
	}
	
	
	public String getNameOfProduct(int i) {
		String s = listOfItems.get(i).getText();
		LOGGER.info("Returning an item on the place: "+i+" cart item of: "+s);
		return s;
	}
	
	
	public float getProductTotal(int num) {
		String s = "";
		if(totals.get(num).findElements(By.xpath(".//*[@class = 'price offerPriceRed']")).size() > 0) {
			s = totals.get(num).findElement(By.xpath(".//*[@class = 'price offerPriceRed']")).getText();
		} else {
			s = totals.get(num).getText();
		}
//		if(getDriver().findElements(By.xpath("//*[@class = 'cost right']")).size() > 0){
//			WebElement itemOfFocus = productOrderDetails.get(num);
//			if( itemOfFocus.findElements(By.xpath(".//*[@class = 'cost right']")).size()  > 0) {
//				s = itemOfFocus.findElement(By.xpath(".//*[@class = 'cost right']")).getText();
//			}
//			else {
//				s = totals.get(num).getText();
//			}
//		}else {
//			if(totals.get(num).findElements(By.xpath(".//*[@class = 'price offerPriceRed']")).size() > 0) {
//				s = totals.get(num).findElement(By.xpath(".//*[@class = 'price offerPriceRed']")).getText();
//			}else {
//				s = totals.get(num).getText();
//			}	
//		}
		LOGGER.info("Returning a total in the cart page of: "+s);
		s = s.replace("$", "");
		s = s.replaceAll(",", "");
		s = s.replace("CAD ", "");
		LOGGER.info("Modded string value is: "+s);
		float f = Float.parseFloat(s);
		return f;
	}
	
	
//	public float getQuantity(int iteration) {
//		WebElement w = quantities.get(iteration);
//		Select wsel = new Select(w);
//		wsel.getFirstSelectedOption();
//		return Float.parseFloat(wsel.getFirstSelectedOption().getText());
//		List<WebElement> list = w.findElements(By.xpath(".//option"));
//		for(WebElement l: list) {
//			
//			try {
//				if(l.isSelected()) {
//					String s = l.getText();
//					LOGGER.info("Getting the quantity of placement "+iteration+" item in the cart as: "+s);
//					float i = Float.parseFloat(s);
//					return i;
//				}	
//			}catch(Exception E) {
//			}
//		}
//		LOGGER.info("There is no selected number");
//		return 0;
//	}
	
	
	public float getSubtotal() {
		String s = subtotal.getText();
		s = s.replace("$", "");
		s = s.replace(",", "");
		s = s.replace("CAD ", "");
		LOGGER.info("Returning a modded subtotal of: "+s);
		float f = Float.parseFloat(s);
		return f;
	}
	
	/**
	 * Method to calculate total discount in cart
	 * @return - total discount in cart
	 */
	public float getTotalDiscount() {
		float f = 0;
		if(discountPrice.size()>0) {
			for(WebElement w : discountPrice) {
				f = f + Float.parseFloat(w.getText().replace("$", "").replace("CAD ", "").replace("-", ""));
			}
		}
		LOGGER.info("Total discount in cart: " + f);
		return f;
	}
	
	/*
	public void adjustQuantity(String name, String quant) {
		pageRefresh();
		int iteration = -1;
		Float quantfloat = Float.parseFloat(quant);
		LOGGER.info("The list of items is size: " + listOfItems.size());
		for(int i = 0; i<listOfItems.size(); i++) {
			String s = listOfItems.get(i).getText();
			if(s.equalsIgnoreCase(name)) {
				LOGGER.info("The name found here: " + s);
				iteration = i;
			}
		}
		if(iteration < 0) {
			LOGGER.info("The name of the item is not in the cart");
		}else {
			LOGGER.info("Found the name in the cart, selecting quantity");
			WebElement w = quantities.get(iteration);
			LOGGER.info("Selecting "+quant+ " in the dropdown");
			LOGGER.info("The amount of stock left is: " + checkStock());
			if(checkStock() != 0 & checkStock() < quantfloat) {
				int stock = checkStock().intValue();
				Select quantdropdown = new Select(w);
				quantdropdown.selectByVisibleText(Integer.toString(stock));
			}else {
			Select roledropdown = new Select(w);
			roledropdown.selectByVisibleText(quant);
		}
		}
	}*/
	
	public void verifyCartNameMatchesItemPage(String name, float price) {
		/*LOGGER.info("Expected Name: " + name + " ,Expected Price: " + price);
		float i = getProductTotal(0) * getQuantity(0);
		float o = Serenity.sessionVariableCalled("firstListPrice");
		if(o != price) {
			price=o;
			LOGGER.info("Correct Expected List Price: " + price);
		}
		String actualName = getNameOfProduct(0);
		LOGGER.info("Acutal Name: " + actualName + " ,Actual Price: " + i);
		SA.assertThat(actualName).isEqualTo(name);
		SA.assertThat(i).isEqualTo(price *getQuantity(0));
		SA.assertAll();
		*/
		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		
		LOGGER.info("Verifying name displayed in cart matches to " + name);
		String namePath="//div[@data-part-number='"+itemStyle+"']//div[@class='product_title']//a";
		String productNameOnCart = find(By.xpath(namePath)).getText();
		//sleep(10000);
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
	
	
	public void verifyWishlistNameMatchesItemPage(String name, float price) {
		float i = getQuantity(0);
		i = i * getProductTotal(0);
		
		SA.assertThat(getNameOfProduct(0)).isEqualTo(name);
		SA.assertThat(i).isEqualTo(price);
		SA.assertAll();
	}
	
	
	public void verifyMultipleItemsInCart(String firstItem, String secondItem, float firstPrice, float secondPrice) {
		
/*		float i = getQuantity(0) * getProductTotal(0);
		float j = getQuantity(1) * getProductTotal(1);
		//i = i * getProductTotal(0);
		//j = j * getProductTotal(1);
		
		float total = i+j;
		total = total - getTotalDiscount();
		String savedPrice = new DecimalFormat("#.##").format(total);
		
		String totalOnPage = new DecimalFormat("#.##").format(getSubtotal());
		
		String firstProduct = getNameOfProduct(0);
		String secondProduct = getNameOfProduct(1);
		
		SA.assertThat(firstProduct).isEqualTo(firstItem);
		SA.assertThat(secondProduct).isEqualTo(secondItem);
		
		float o = Serenity.sessionVariableCalled("firstListPrice");
		if(o != firstPrice) {
			firstPrice=o;
			LOGGER.info("Correct Expected List Price: " + firstPrice);
		}
		SA.assertThat(i).isEqualTo(firstPrice);
		
		o = Serenity.sessionVariableCalled("secondListPrice");
		if(o != secondPrice) {
			secondPrice=o;
			LOGGER.info("Correct Expected List Price: " + secondPrice);
		}
		SA.assertThat(j).isEqualTo(secondPrice);
		
		SA.assertThat(savedPrice).as("Subtotal").isEqualTo(totalOnPage);
		SA.assertAll();*/
		
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

	
	public void verifyPromotionsApplied(String code) {
		String topItemName = getNameOfProduct(0);
		LOGGER.debug("Verifying: "+topItemName+" and "+code +" are valid");
		if(topItemName.equalsIgnoreCase("205W39NYC TURTLENECK") && code.equalsIgnoreCase("GWPORDER")) {
			boolean isThere = false;
			for(WebElement w: listOfItems) {
				String text = w.getText();
				if(text.equalsIgnoreCase("GIRLS SKINNY PATCHWORK ANKLE JEANS")) {
					isThere = true;
					break;
				}
			}
			assertThat(isThere).isTrue();
		}
	}
	
	
	private String getTitleOfShoppingBag() {
		String s = shoppingBagTitle.getText();
		LOGGER.info("Getting the title of the shopping bag as: "+s);
		return s;
	}
	
	public void verifyCartPage() {
		assertThat(getTitleOfShoppingBag()).as("Shopping Bag title").isEqualToIgnoringCase("Shopping Bag");
	}
	
	public void verifyNumItemsInCart(int numItems) {
		sleep(3000);
		LOGGER.debug("verifying item list " + listOfItems.size() + " is equal to less one item " + numItems);
		assertThat((int)getQuantity(0)).as("Number of quantity").isEqualTo(numItems);
	}
	
	private String getPageLevelError() {
		String s = pageLevelError.getText();
		LOGGER.info("Getting the page level error as: "+s);
		System.out.println(s);
		return s.toUpperCase();
	}
	
	public void verifyWishlistError(String error) {
		assertThat(getPageLevelError()).as("Page Level Error").contains(error.toUpperCase());;
	}
	
	public void verifyOnPage() {
		SA.assertThat(proceedCheckOut.exists() && proceedCheckOut.getText().toLowerCase().contains("secure")).isTrue();
		//SA.assertAll();
	}

}
