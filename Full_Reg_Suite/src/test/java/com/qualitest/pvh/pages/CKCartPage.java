package com.qualitest.pvh.pages;

import java.util.List;
import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;

public class CKCartPage extends CartPage{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CKCartPage.class); 
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	private BaseElement closePopUp;
	
	@FindBy(xpath = "//*[@id=\"WC_OrderItemDetailsf_links_1_1_\"]/span[1]")
	private BaseElement edit;
	
	@FindBy(xpath = "//*[@class = 'product_title']/h3/a")
	private List<WebElement> listOfItems;
	
	@FindBy(xpath = "//*[@class= 'low']")
	private BaseElement lowStock;
	
	@FindBy(xpath = "//*[@class= 'total']")
	private List<WebElement> prices;
	
	@FindBy(xpath = "//span[contains(text(),'PROCEED TO SECURE CHECKOUT')]")
	private BaseElement proceedCheckOut;
	
	@FindBy(xpath = "//*[@id = 'qty_']")
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
	
	@FindBy(xpath="//div[@id='payRunnerContainerCart']")
	private BaseElement shopRunner;
	
	@FindBy(id="sr_signin_email")
	private BaseElement shopRunnerEmail;
	
	@FindBy(id="sr_signin_password")
	private BaseElement shopRunnerPassword;
	
	@FindBy(id="sr_sign_in_button")
	private BaseElement shopRunnerSignIn;
	
	
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
	
	
	public void clickCartOffCKCA() {
		while(closePopUp.exists()) {
			LOGGER.info("Closing pop up ");
			closePopUp.click();
		}
	}
	
	/**
	 * Method to click proceed to checkout on cart page
	 */
	
	public void clickProceedCheckOut() {
		LOGGER.info("Clicking Proceed To Secure Checkout");
		pageRefresh();
		proceedCheckOut.waitUntilClickable().click();
	}
	
	
	public void clickSearchButton() {
		LOGGER.info("Submitting search query");
		searchEnter.click();
	}
	
	
	public void editProduct() {
		edit.click();
	}
	
	
	public void enterSearch(String item) {
		LOGGER.info("Inputting search item: "+item);
		search.type(item);
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
	}
	
	
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
	
	public boolean popUpExists() {
		return closePopUp.exists();
	}
	
	
	public void searchFor(String item) {
		getDriver().navigate().refresh();
		clickClosePopUp();
		sleep(1000);
		clickSearchButton();
		enterSearch(item);
		clickSearchButton();
	}
	
	/*public void adjustQuantity(String name, String quant) {
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
	
/*	public void verifyCartNameMatchesItemPage(String name, float price) {
		
		LOGGER.info("Expected Name: " + name + " ,Expected Price: " + price);
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
		

		String itemStyle = Serenity.sessionVariableCalled("styleNumber");
		String capturedName = Serenity.sessionVariableCalled("firstItem");
		Float capturedPrice = Serenity.sessionVariableCalled("firstListPrice");
		String str1 = Float.toString(capturedPrice);
		String namePath="//div[@data-part-number='"+itemStyle+"']//div[@class='product_title']//a";
		String productName = find(By.xpath(namePath)).getText();
		String pricePath = "//div[@data-part-number='"+itemStyle+"']//span[contains(@class,'price')]";
		String productPrice = find(By.xpath(pricePath)).getText();
		
		productPrice = productPrice.replace("$", "");
		productPrice = productPrice.replaceAll(",", "");
		if(productPrice.contains("CAD")) {
			productPrice = productPrice.replace("CAD ", "");
		}
	
		float f = Float.parseFloat(productPrice);
		String str2 = Float.toString(f);
		//LOGGER.info("Expected Name: " + name + " ,Expected Price: " + price);
		SA.assertThat(productName.equalsIgnoreCase(capturedName));
		SA.assertThat(str1.equalsIgnoreCase(str2));
		SA.assertAll();
	}*/
	
	public void verifyWishlistNameMatchesItemPage(String name, float price) {
		float i = getQuantity(0);
		i = i * getProductTotal(0);
		
		SA.assertThat(getNameOfProduct(0)).isEqualTo(name);
		SA.assertThat(i).isEqualTo(price);
		SA.assertAll();
	}
	
	
	/*public void verifyMultipleItemsInCart(String firstItem, String secondItem, float firstPrice, float secondPrice) {
		
		float i = getQuantity(0) * getProductTotal(0);
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
		SA.assertAll();
	}*/

	
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
		//LOGGER.debug("verifying item list " + listOfItems.size() + " is equal to less one item " + numItems);
		assertThat((int)getQuantity(0)).as("Number of quantity").isEqualTo(numItems);
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
	
	public void loginWithShoprunner(String email, String password) {
		sleep(3000);
		clickCheckoutWithShopRunner();
		sleep(4000);
		signInWithShopRunner(email, password);
	}

}
	

