package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;

public abstract class CartPage extends BasePage{
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CartPage.class);
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	protected BaseElement popUpClose;
	
	
	@FindBy(xpath = "//*[@id='ShopCartPagingDisplay']/div[1]/h1")
	private BaseElement cartTitle;
	
	@FindBy(xpath = "//*[@id='WC_OrderItemDetailsf_links_1_1_']/span[1]")
	private BaseElement edit;
	
	@FindBy(xpath = "//*[@class='formField']/a[text()='Edit']")
	private BaseElement editGiftBox;
	
	@FindBy(xpath = "//*[@class = 'emptyCartMessage']")
	private BaseElement emptyCartMessage;
	
	@FindBy(xpath = "//*[@id= 'fieldErrorMessage']")
	private BaseElement fieldErrorMessage;
	
	@FindBy(xpath = "//*[@class = 'linkGroup clearfix']/a[2]")
	private List<WebElement> removeList;
	
	@FindBy(xpath = "//*[@class = 'productRow clearfix   '][1]/div/div/div/div[3]/span[2]")
	private BaseElement firstSize;
	
	@FindBy(xpath = "//*[@class = 'clearfix priceAndQuantity']/div[3]/span")
	protected List<WebElement> priceFinal;
	
	@FindBy(xpath = "//*[@class = 'cost tommyRed negativeValue right']")
	protected List<WebElement> discountedAmount;
	
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

	@FindBy(xpath = "//*[@class = 'product_title']/h3/a")
	protected List<WebElement> listOfItems;
	
	@FindBy(xpath = "//*[@class= 'low']")
	private BaseElement lowStock;
	
	@FindBy(id="messageMsgText")
	private BaseElement messageText;
	
	@FindBy(xpath = "//*[@class= 'total']")
	private List<WebElement> prices;
	
	@FindBy(xpath = "//span[contains(text(),'PROCEED TO SECURE CHECKOUT')]")
	private BaseElement proceedCheckOut;
	
	@FindBy(id="OrderItemDetailsf_div_2_1")
	private BaseElement product;
	
	@FindBy(xpath = "//*[@id = 'WC_PromotionCodeDisplay_links_1']")
	private BaseElement promoCodeApply;
	
//	@FindBy(xpath = "//*[@id = 'promoCode']")
//	@FindBy(xpath = "//*[@class = 'input focuslistener']")
//	@FindBy(xpath = "//*[contains(text('Enter Promo Code')]")
	@FindBy(xpath = "//*[@name = 'promoCode'][1]")
	
	private BaseElement promoCodeInput;
	
	@FindBy(xpath = "//*[@id = 'qty_']")
	private List<WebElement> quantities;
	
	@FindBy(id="giftMsgFormRemove")
	private BaseElement removeGiftBox;
	
	protected SoftAssertions SA = new SoftAssertions();
	
	@FindBy(xpath = "//*[@id = 'SimpleSearchForm_SearchTerm']")
	private BaseElement search;
	
	@FindBy(xpath = "//*[@class = 'searchLink magGlass']")
	private BaseElement searchEnter;
	
	@FindBy(id = "WC_OrderItemDetailsf_links_2_2")
	private BaseElement secondRemove;
	
	@FindBy(id="shopcartSubmitGiftBox")
	private BaseElement submitGiftBox;

	@FindBy(id = "WC_SingleShipmentOrderTotalsSummary_td_2")
	private BaseElement subtotal;
	
	@FindBy(xpath = "//*[@class = 'unitPrice']")
	private List<WebElement> totals;
	
	@FindBy(id="toMsgText")
	private BaseElement toText;
	
	@FindBy(id="WC_SingleShipmentOrderTotalsSummary_td_13")
	private BaseElement orderTotal;
	
	//@FindBy(id="sr_payRunnerCartDiv")
	@FindBy(id="payRunnerContainerCart")
	private BaseElement shopRunner;
	
	@FindBy(id="sr_signin_email")
	private BaseElement shopRunnerEmail;
	
	@FindBy(id="sr_signin_password")
	private BaseElement shopRunnerPassword;
	
	@FindBy(id="sr_sign_in_button")
	private BaseElement shopRunnerSignIn;
	
	@FindBy(id="sr_ec_apply_gift_card")
	private BaseElement applyShoprunnerGiftcard;
	
	@FindBy(id="pr_complete_btn")
	private BaseElement shopRunnerCompleteCheckout;
	
	@FindBy(xpath= "//*[@class='sr_center sr_edit_bag']")
	private BaseElement edit1shoppingbag;
	
	@FindBy(id="storeCardNumber")
	private BaseElement enterGiftcardNumber;
	
	@FindBy(id="pinNumber")
	private BaseElement enterGiftcardPin;
	
	@FindBy(id="pr_add_gift_card_btn")
	private BaseElement addGiftCard;
	
	@FindBy(xpath= "//*[@class='link wishlistLink']")
	private BaseElement addToWishlist;
	

	@FindBy (xpath = "//*[@id='mini_cart_link']/span[2]")
	private BaseElement ItemsInBag;
	
	@FindBy(xpath = "//select[contains(@id,'quantity')]")
	protected BaseElement quantityNum;
	
	@FindBy(xpath = "//a[@id='replaceBtn']")
	private BaseElement updateBag;
	
	
	public int getNumItemsInBag()
	{
		return Integer.parseInt(ItemsInBag.getText());
	}

	@FindBy(id="pageLevelMessage")
	private BaseElement cartPageError;
	
	@FindBy(xpath = "//*[@class = 'currentPromoCode']//a[contains(text(), \"Remove\")]")
	private BaseElement removePromoCode;
	
	private void clickAddGiftBox() {
		LOGGER.info("Adding gift box...");
		sleep(500);
		giftBox.click();
	}
	
	public void addGiftBox(String to, String from, String message) {
		clickAddGiftBox();
		insertGiftBoxInfo(to,from,message);
		clickSubmitGiftBox();
	}
	
	protected String modString(String s) {
		s = s.replaceAll("\\s", "");
		s = s.replace("$", "");
		s = s.replace("-", "");
		LOGGER.info("Returning a modded string of: "+s);
		return s;
	}
	
	public void adjustQuantityOnMobile(String quant) {
		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		//String quantityXpath = "//div[@data-part-number='"+itemStyle+"']//select[@aria-label='Quantity']";
		//String quantityXpath = "//div[@data-part-number='"+itemStyle+"']//select[contains(@aria-label,'quantity')]";
		String quantityXpath = "//div[@data-part-number='"+itemStyle+"']//select";
		Select dropdown = new Select(find(By.xpath(quantityXpath)));
		dropdown.selectByVisibleText(quant);
		sleep(100);
				
	}
	
	
	public void adjustQuantity(String name, String quant) {
		/*int iteration = -1;
		Float quantfloat = Float.parseFloat(quant);
		LOGGER.info("The size of the item list is: " + listOfItems.size());
		for(int i = 0; i<listOfItems.size(); i++) {
			String s = listOfItems.get(i).getText();
			LOGGER.info("The item name is: " + s);
			if(s.equalsIgnoreCase(name)) {
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
		}*/
		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		String quantityXpath = "//div[@data-part-number='"+itemStyle+"']//select[contains(@aria-label,'Quantity')]";
		
		Select dropdown = new Select(find(By.xpath(quantityXpath)));
		dropdown.selectByVisibleText(quant);
		sleep(100);
	}
	
	public void adjustQuantityWithoutCheckStock(String name, String quant) {
		getDriver().navigate().refresh();
		int iteration = -1;
		//Float quantfloat = Float.parseFloat(quant);
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
			Select roledropdown = new Select(w);
			roledropdown.selectByVisibleText(quant);
		}
		}

	public void updateQuantityWithoutCheckStock() {
		LOGGER.info("Selecting quantity ="+Serenity.sessionVariableCalled("item1Quant"));
		sleep(300);
	   // evaluateJavascript("window.scrollTo(0, document.body.scrollHeight)",quantityNum);
	    evaluateJavascript("arguments[0].scrollIntoView();", updateBag);
	   // evaluateJavascript("arguments[0].scrollIntoView(true);",quantityNum);
		sleep(500);
		Select dropdown = new Select(quantityNum);
		dropdown.selectByVisibleText(Serenity.sessionVariableCalled("item1Quant"));
		sleep(500);
		updateBag.click();
		}

	public void applyPromoCode(String code) {
		try {
			LOGGER.info("No promo code entry located. Clicking cancel promo code");
			removePromoCode();
		}catch(Exception E) {		
		}
		enterPromoCode(code);
		clickPromoCodeApply();
	}
	
	/**
	 * Method to close pop up
	 */
	
	
	  public void clickOffPopUp() { 
		  if (popUpClose.isVisible()) {
	  LOGGER.info("Closing pop up window"); 
	  popUpClose.click(); 
	  } 
		  }
	 
	
	
	public Float checkStock() {
		if(lowStock.exists()) {
			String str = lowStock.getText();
			LOGGER.info("Lowstock message: " + lowStock.getText());
			str = str.replaceAll("\\D+", "");
			Float stock = Float.parseFloat(str);
			return stock;
		}else {
			return (float) 0.0;
		}
	
	}
	
	public void clickFirstEdit() {
		LOGGER.info("Clicking the edit button for the first or top product on cart page");
		edit.click();
	}
	
	public void clickProceedCheckOut() {
		LOGGER.info("Clicking Proceed To Secure Checkout");
		getDriver().navigate().refresh();
		proceedCheckOut.click();
	}
	
	public void clickPromoCodeApply() {
		LOGGER.info("Clicking promo code apply");
		sleep(10000);
		//promoCodeApply.waitUntilClickable();
		promoCodeApply.click();
	}

	public void clickSearchButton() {
		LOGGER.info("Submitting search query");
		searchEnter.click();
	}
	
	private void clickEditGiftBox() {
		LOGGER.info("Editing gift box...");
		pageRefresh();
		sleep(100);
		editGiftBox.click();
	}
	
	private void insertGiftBoxInfo(String To, String From, String Message) {
		LOGGER.info("Inserting gift box information...");
		giftTo.type(To);
		giftFrom.type(From);
		giftMessage.type(Message);
	}
	
	protected String getFirstPriceFinal() {
		String s = modString(priceFinal.get(0).getText());
		LOGGER.info("Getting the first final price as: "+s);
		return s;
	}
	
	protected String getSecondPriceFinal() {
		String s = modString(priceFinal.get(1).getText());
		LOGGER.info("Getting the second final price as: "+s);
		return s;
	}
	
	
	private void clickSubmitGiftBox() {
		LOGGER.info("Submitting gift box...");
		submitGiftBox.click();
	}
	
	public void editGiftBox(String newTo, String newFrom, String newMessage) {
		clickEditGiftBox();
		insertGiftBoxInfo(newTo, newFrom, newMessage);
		clickSubmitGiftBox();
	}
	
	public void editProduct() {
		LOGGER.info("Editing product...");
		edit.click();
	}
	
	public void enterPromoCode(String code) {
		LOGGER.info("Inputing promo code: "+code);
		sleep(10000);
		
		/*
		 * WebDriverWait wait = new WebDriverWait(driver, 3000); WebElement
		 * enterPromoCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//*[@name = 'promoCode'][1]"))); enterPromoCode.click();
		 */
		promoCodeInput.type(code);
	}

	public void enterSearch(String item) {
		LOGGER.info("Inputting search item: "+item);
		search.type(item);
	}
	
	public String getFieldErrorMessage() {
		String s = fieldErrorMessage.getText();
		LOGGER.info("Getting the field level message as: "+s);
		return s;
	}
	
	public String getFirstSize() {
		String s = firstSize.getText();
		LOGGER.info("Getting the size of the first size as: "+s);
		return s;
	}
	
	public String getNameInCart() {
		return product.getText();
	}
	
	public String getNameOfProduct(int i) {
		String s = listOfItems.get(i).getText();
		LOGGER.info("Returning a cart item of: "+s);
		return s;
	}
	
	public float getProductTotal(int num) {
		WebElement w = totals.get(num);
		List<WebElement> l = w.findElements(By.tagName("span"));
		String s = "";
		if(l.size() == 1) {
			s = l.get(0).getText();
		}else {
			s = l.get(1).getText();
		}
		LOGGER.info("Returning a total in the cart page of: "+s);
		s = s.replace("$", "");
		LOGGER.info("Modded string value is: "+s);
		float f = Float.parseFloat(s);
		return f;
	}
	
	public float getQuantity(int iteration) {
		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		String quantityDropdownXpath = "//div[@data-part-number='"+itemStyle+"']//select";
		Select select = new Select(find(By.xpath(quantityDropdownXpath)));
		WebElement option = select.getFirstSelectedOption();
		String selectedItem = option.getText();
		float f = Float.parseFloat(selectedItem);
		LOGGER.info("Current quantity in cart is "+f);
		return f;
//		WebElement w = quantities.get(iteration);
//		Select wsel = new Select(w);
//		wsel.getFirstSelectedOption();
//		return Float.parseFloat(wsel.getFirstSelectedOption().getText());
		
//		List<WebElement> list = w.findElements(By.xpath(".//option"));
//		for(WebElement l: list) {
//			
//			try {
//				l.getAttribute("selected");
//				String s = l.getText();
//				LOGGER.info("Getting the quantity of the first item in the cart as: "+s);
//				float i = Float.parseFloat(s);
//				return i;
//			}catch(Exception E) {
//			}
//			
//		}
//		LOGGER.info("There is not selected number");
//		return 0;
	}
	
	
	public float getSubtotal() {
		String s = subtotal.getText();
		s = s.replace("$", "");
		s = s.replaceAll(",", "");
		LOGGER.info("Returning a subtotal of: "+s);
		float f = Float.parseFloat(s);
		return f;
	}
	
	/**
	 * Method to retrieve order total from cart page
	 */
	public float getOrderTotal() {
		String s = orderTotal.getText();
		s = s.replace("$", "");
		s = s.replace(",", "");
		s = s.replace("CAD", "");
		LOGGER.info("Order total displayed on cart page is: " + s);
		float f = Float.parseFloat(s);
		return f;
	}
	
	public void quickViewProduct() {
		product.click();
	}
	
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

	public void removeGiftBox() {
		sleep(200);
		removeGiftBox.click();
	}

	public void removeSecondItem() {
		LOGGER.info("Clicking the second remove");
		secondRemove.click();
		sleep(100);
	}

	
	public void searchFor(String item) {
		sleep(1000);
		enterSearch(item);
		clickSearchButton();
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
	
	public void verifyEmptyCart() {
		Boolean bool = false;
		if(emptyCartMessage.exists()) {
			bool = true;
		}else {
			bool = false;
		}
		assertThat(bool).isTrue();
	}
	public void verifyFirstSize(String size) {
		getDriver().navigate().refresh();
		String pageSize = getFirstSize();
		if(pageSize.equalsIgnoreCase("One Size")) {
			assertThat(pageSize).as("First Cart Item size").isEqualToIgnoringCase(size);
		}
		else if(pageSize.contains(" ")) {
			String[] pageArr = pageSize.split(" ");
			String[] savedArr = size.split("/");
			SA.assertThat(pageArr[0]).as("first size").isEqualToIgnoringCase(savedArr[0]);
			SA.assertThat(pageArr[1]).as("second size").isEqualToIgnoringCase(savedArr[1]);
			SA.assertAll();
		}else {
			assertThat(pageSize).as("First Cart item size").isEqualToIgnoringCase(size);
		}
	}

	public void verifyGiftBox(String to, String from, String message) {
		//pageRefresh();
		sleep(5000);
		toText.waitUntilVisible();
		SA.assertThat(toText.getText()).isEqualToIgnoringCase(to);
		SA.assertThat(fromText.getText()).isEqualToIgnoringCase(from);
		SA.assertThat(messageText.getText()).isEqualToIgnoringCase(message);
		SA.assertAll();
	}
	
	public void verifyMultipleItemsInCart(String firstItem, String secondItem, float firstPrice, float secondPrice) {
		
	/*	float i = getQuantity(0);
		float j = getQuantity(1);
		i = i * getProductTotal(0);
		LOGGER.info("Total with quantity for first item: "+ i);
		j = j * getProductTotal(1);
		LOGGER.info("Total with quantity for second item: "+j);
		float total = i+j;
		LOGGER.info("Total of both items togther: "+total);
		String savedPrice = new DecimalFormat("#.##").format(total);
		String totalOnPage = new DecimalFormat("#.##").format(getSubtotal());
		
		
		String firstProduct = getNameOfProduct(0);
		String secondProduct = getNameOfProduct(1);
		
		SA.assertThat(firstProduct).isEqualToIgnoringCase(firstItem);
		SA.assertThat(secondProduct).isEqualToIgnoringCase(secondItem);
		SA.assertThat(i).isEqualTo(firstPrice);
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
	
	public void verifyPromoCodeError(String message) {
		assertThat(getFieldErrorMessage()).as("Field Error Message").isEqualToIgnoringCase(message);
	}
	
	public void verifyRemovalGiftBox() {
		SA.assertThat(!(toText.exists()));
		SA.assertThat(!(fromText.exists()));
		SA.assertThat(!(messageText.exists()));
		SA.assertAll();
	}
	
	private void clickCheckoutWithShopRunner() {
		LOGGER.info("Clicking on checkout with Shoprunner");
		shopRunner.click();
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
		sleep(3000);
		clickCheckoutWithShopRunner();
		sleep(4000);
		signInWithShopRunner(email, password);
	}
	
	public void clickApplyShoprunnerGiftcard() {
		LOGGER.info("Applying giftcard in shoprunner window...");
		applyShoprunnerGiftcard.click();
	}
	
	public void enterGiftcard(String number, String pin) {
		LOGGER.info("Entering giftcard number " + number + "with pin " + pin);
		enterGiftcardNumber.sendKeys(number);
		enterGiftcardPin.sendKeys(pin);
		addGiftCard.click();
	}
	
	public void checkoutShoprunner() {
		completeCheckout();
	}
	
	
	/*
	 * public void edit1shopingBag() {
	 * LOGGER.info("clikcing on edit shopping Bag..."); //WebElement
	 * edit1shoppingbag = null; edit1shoppingbag.click(); }
	 * 
	 * protected abstract void edit1shoppingbag();
	 */

	/**
	 * Method to move item to Wish list from cart
	 */
	public void addToWishlist() {
		LOGGER.info("Adding item to wishlist from cart page...");
		addToWishlist.waitUntilClickable().click();
	}
	

	public void verifyAddToWishlistForGuestUser() {
			LOGGER.info("Verifying adding item to wishlist is not available from cart page for guest user...");
			SA.assertThat(addToWishlist.isVisible()).as("The Wish List button is not available for guest user").isFalse();
	}
	/**
	 * Method to verify provided error message displayed for wish list
	 * @param error - Error Message
	 */
	public void verifyWishlistError(String error) {
		assertThat(verifyErrorExists(error)).as("This item already exists in your").isTrue();
		//LOGGER.info("Added same item twice to the wishlist...");
		//SA.assertAll();
	}
	
	public void verifyQuantityNotAvailableError() {
		LOGGER.info("Verifying quantity not available...");
		SA.assertThat(cartPageError.getText()).containsIgnoringCase("is no longer available in the quantity you requested.");
		SA.assertAll();
	}
	

	
	public void verifyNumItemsInCart(int numItems) {
		sleep(2000);
		assertThat((int)getQuantity(0)).as("Number of quantity").isEqualTo(numItems);
	}
	
	
	public void verifyItemWasAdded() {
		
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("verifying item was added that had low quantity " + Serenity.sessionVariableCalled("firstItem") + "  " +listOfItems.get(listOfItems.size()-1).getText());
		SA.assertThat(listOfItems.get(listOfItems.size()-1).getText().toLowerCase().contains(Serenity.sessionVariableCalled("firstItem").toString().toLowerCase())).isTrue();

		SA.assertAll();
		
		for(int i = 0; i < listOfItems.size(); i++)
		{
			removeFirstItem();
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void verifyOnPage() {
		SA.assertThat(proceedCheckOut.exists() && proceedCheckOut.getText().toLowerCase().contains("secure")).isTrue();
		//SA.assertAll();
	}


	public void verifyValidPromoWrongRequirement() {
		String error = getFieldErrorMessage();
		assertThat(error.trim()).as("Promo error").isEqualToIgnoringCase("The promotional code entered is valid, but your order does not meet the requirements. Details");
	}
	
	private int getSizeOfNumberOfDiscounts() {
		int i = discountedAmount.size();
		LOGGER.info("The number of discounted items is: "+i);
		return i;
	}
	
	public void verifyValidPromoForFirstItem(String code) {
		assertThat(getSizeOfNumberOfDiscounts()).as("Number of discounted items").isEqualTo(1);
	}
	
	public void verifyValidPromoForMulitpleItems(String code) {
		assertThat(getSizeOfNumberOfDiscounts()).as("Number of discounted items").isGreaterThan(1);
	}
	
	public void removePromoCode() {
		LOGGER.info("Clicking to remove promo code");
		removePromoCode.click();
		try
		{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	public void verifyNoPromoApplied(String code) {
		SA.assertThat(getSizeOfNumberOfDiscounts()).as("Number of discounted items").isEqualTo(1);
		removePromoCode();
		SA.assertThat(getSizeOfNumberOfDiscounts()).as("Number of discounted items").isEqualTo(0);
	}
	
	public void verifyOnCartPage()
	{
		if(emptyCartMessage.exists())
		{
			assertThat(emptyCartMessage.exists()).isTrue();
		}
		else
		{
			assertThat(cartTitle.exists()).isTrue();
		}
	}
	
}
