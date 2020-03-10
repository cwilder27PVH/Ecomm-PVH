package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;


public class PBItemPage extends ItemPage {

	WebDriver driver;

	public PBItemPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//a[@id='add2CartBtn']")
	private BaseElement addToBag;

	@FindBy(xpath = "//div[@class='action-wrapper']//a[@id='add2CartBtn']")
	private BaseElement addToMobileBag;

	@FindBy(xpath = "//a[@id='productPageAdd2Wishlist']")
	protected BaseElement addToWishlist;

	@FindBy(xpath = "//a[@value='1']")
	private BaseElement quantity_Increase;

	@FindBy(xpath = "//a[@value='-1']")
	private BaseElement quantity_Decrease;

	@FindBy(xpath = "//li[@id='size_S_One_space_Sz']")
	protected BaseElement oneSize;

	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	private BaseElement popUpClose;

	@FindBy(id = "WC_MiniShopCartDisplay_link_1_1")
	private BaseElement firstProductInCartDisplay;

	@FindBy(xpath = "//*[@class = 'inventoryStatus out']")
	private BaseElement outOfStockClass;

	@FindBy(xpath = "//*[@class='sizeSelector']")
	private List<WebElement> sizeList;

	@FindBy(xpath = "//*[@class='sizeSelector']")
	private List<WebElement> sizeSelectors;

	@FindBy (xpath = "//div[@id='sizeContainer']")
	private List<WebElement> sizeContainer;

	@FindBy(xpath = "//*[@id = 'shopping-bag-link']")
	private BaseElement checkOut;

	@FindBy(xpath = "//*[@id = 'product-added-container']//*[contains( text(), 'Edit bag' ) ]")
	private BaseElement productAddedEditBag;

	//	@FindBy(xpath = "//*[@id= 'MiniShopCartAll']//*[contains( text(), 'Edit bag' ) ]")
	@FindBy(xpath = "//*[contains( text(), 'Edit bag' ) ]")
	//	@FindBy(xpath = "//div[@id='shopping-bag-link-container']//a[@id='WC_MiniShopCartDisplay_link_3']")
	private BaseElement miniCartDisplayEditBag;

	@FindBy (xpath = "//a[@value='1']")
	private	BaseElement quantityUP;

	@FindBy (xpath = "//a[@value='-1']")
	private	BaseElement quantityDown;

	@FindBy(xpath = "//a[@id='mini_cart_link_vh']")
	private BaseElement cartVH;
	
	@FindBy(xpath = "//div[@class='productCell processed'][1]")
	protected BaseElement productStyleNumber;

	//MM09082019
	//@FindBy(xpath = "//img[@class='mobile ae-img']")
	//MM10092019
	@FindBy(xpath = "//*[@id= 'mini_cart_link_vh_mobile']")
	private BaseElement mobileCartVH;

	@FindBy(xpath = "//a[@id='mini_cart_link_iz']")
	private BaseElement cartIZ;

	@FindBy(xpath = "//a[@id='mini_cart_link_sb']")
	private BaseElement cartSB;

	@FindBy(xpath = "//*[@id='shopping-bag-link']")
	private BaseElement cartPopUp;

	@FindBy(xpath = "//a[contains( text(), 'Checkout')]")
	private BaseElement checkOutFromItemPagePopUp;

	@FindBy(xpath = "//div[@class='miniCartSummaryButtons']//a[1]")
	private BaseElement checkOutMiniCart;

	@FindBy(xpath = "//input[@class='quantity_input']")
	private BaseElement quantity;

	@FindBy(xpath = "//a[@id='replaceBtn']")
	private BaseElement updateBag;

	@FindBy(xpath = "//ul[@class='productswatches clearfix']//li[@role='radio']")
	private List<WebElement> listOfColors;

	@FindBy(xpath = "//input[contains(@id,'quantity')]")
	protected BaseElement quantityNum;


	//  @FindBy(xpath = "//*[@class = 'productName']") 
	@FindBy(xpath = "//*[@class = 'productNameInner']")
	protected BaseElement
	productName;

	//@FindBy(xpath = "//h1[@class='productName']//span[@class='productNameInner']")
	 @FindBy(xpath = "//*[@class = 'productCell processed'][1]") 
	private BaseElement mobileProductName;

	//@FindBy(xpath = "//div[@class='productCell processed']") 
	@FindBy(xpath = "//ul[@class='productswatches clearfix']")
	//@FindBy(xpath = "//div[@class='clearfix swatchWrapper ']")
	protected  BaseElement colorSwatch;

	//MM04092019 
	@FindBy(xpath = "//*[@class = 'active']")
	//@FindBy(xpath = "//div[@class='clearfix swatchWrapper ']")
	//@FindBy(xpath = "//div[@class='productCell processed'][1]")
	protected  BaseElement colorMobileSwatch;

	public String getProductName() { 
		sleep(5000); 
		String name =	 productName.getText(); 
		LOGGER.info("Product name retrieved: " + name); 
		return name; 
	}

	public String getMobileProductName() {
		String name = mobileProductName.getText();
		LOGGER.info("Returning a product name of: "+name);
		return name;
	}
	/*
	 * public String getMobileProductStyleNumber() { clickOffPopUp(); sleep(1000);
	 * String a =
	 * productStyleNumber.waitUntilEnabled().getAttribute("data-part-number");
	 * LOGGER.info("the number is : "+a); return a; }
	 */
	
	
	  public String getMobileProductStyleNumber() { 
		  //MM09042019 
		  clickOffPopUp();
	  String a =
	  colorMobileSwatch.waitUntilEnabled().getAttribute("data-part-number");
	  LOGGER.info("the number is : "+a); return a; }
	 

	public String getProductStyleNumber() { 
		sleep(5000); 
		WebElement csElement=  colorSwatch.findElement(By.className("productswatches")).findElement(By.className("active")); 
		String a = csElement.getAttribute("data-part-number");
		System.out.println("the number is: "+a); 
		return a; 
	}









	private static final Logger LOGGER = LoggerFactory.getLogger(PBItemPage.class);


	public void addToWishList() {
		LOGGER.info("Adding item to wishlist...");
		WebElement addToWishlistPDP = getDriver().findElement(By.cssSelector("#productPageAdd2Wishlist"));
		//evaluateJavascript("arguments[0].scrollIntoView();", addToWishlistPDP);
		sleep(sleeptimeout);
		//sleep(5000);
		//addToWishlistPDP.withTimeoutOf(timeout, TimeUnit.MILLISECONDS).waitUntilVisible().click();
		addToWishlistPDP.click();
	}

	public void addToMobileWishList() {
		LOGGER.info("Adding item to wishlist...");
		WebElement addToWishlistPDP = getDriver().findElement(By.cssSelector("#productPageAdd2Wishlist"));
		//evaluateJavascript("arguments[0].scrollIntoView();", addToWishlistPDP);
		sleep(sleeptimeout);
		//sleep(5000);
		//addToWishlistPDP.withTimeoutOf(timeout, TimeUnit.MILLISECONDS).waitUntilVisible().click();
		addToWishlistPDP.click();
	}

	public void selectQuantity(String quant) {	
		//	Float quantfloat = Float.parseFloat(quant);
		/*quantity_Increase.click();
		quantity_Increase.click();
		clickAddToBag();
		sleep(sleeptimeout);*/


		quantityNum.type(quant);
		sleep(500);
		clickOffPopUp();
	}

	public void selectQuantityOnMobile(String quant) {	
		quantityNum.type(quant);
		sleep(500);
		clickOffPopUp();
	}

	public String getSizesSelected() {

		LOGGER.info("Retrieving size of the item");
		/*if (oneSize.exists()) {
			LOGGER.info("Returning a size of 0 because there weren't any sizes to choose from");
			return "One Size";
		} else if (sizeSelectors.size() == 1) {
			try {
				String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'selected available']/span"))
						.getText();
				LOGGER.info("Returning a size of: " + i);
				return i;
			} catch (Exception e) {
				String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'available selected']/span"))
						.getText();
				LOGGER.info("Returning a size of: " + i);
				return i;
			}
		} else {
			String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'selected available']/span")).getText();
			String j = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'available selected']/span")).getText();
			String ret = i + "/" + j;
			LOGGER.info("Returning a size of: " + ret);
			return ret;
		}*/
		//		String sizeXpath = "//ul[@data-part-number='"+Serenity.sessionVariableCalled("styleNumber")+"']//div[@class='size']/span[2]";
		//		String sizeXpath = "//div[@data-part-number='"+Serenity.sessionVariableCalled("styleNumber")+"']//div[@class='size']/span[2]";

		String sizeXpath = "//div[@data-part-number='"+Serenity.sessionVariableCalled("styleNumber")+"']/div/div/div/div[4]/span[2]";
		String size = find(By.xpath(sizeXpath)).getText();
		LOGGER.info("Returning a size of: " + size);
		Serenity.setSessionVariable("size").to(size);
		System.out.println("session size variable is : " +Serenity.sessionVariableCalled("size"));
		return size;
	}

	public void clickOffPopUp() {
		if (popUpClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			popUpClose.click();
		}
	}


	public void increaseQuantity() {
		quantityUP.click();
		clickAddToBag();
		sleep(sleeptimeout);
	}

	public void decreaseQuantity() {
		quantityDown.click();
		clickAddToBag();
		sleep(sleeptimeout);
	}

	public void addToBag() {
		clickAddToBag();
		sleep(sleeptimeout);
	}

	public void clickEditBagFromMiniCart() {
		LOGGER.info("Clicking on the edit bag option in the mini cart display");
		sleep(5000);
		Actions a = new Actions(getDriver());
		a.moveToElement(getDriver().findElement(org.openqa.selenium.By.xpath("(//img[@alt='Shopping Bag icon'])[2]"))).perform();
		miniCartDisplayEditBag.waitUntilClickable();
		miniCartDisplayEditBag.click();
	}


	public Float checkStock() {
		if (lowStock.exists()) {
			LOGGER.info("Lowstock message: " + lowStock.getText());
			String str = lowStock.getText();

			str = str.replaceAll("\\D+", "");
			Float stock = Float.parseFloat(str);
			return stock;
		} else {
			return (float) 0.0;
		}
	}


	public int checkToBagIfEmpty() {
		int i = itemsInBag.size();
		if (i == 0) {
			LOGGER.info("The bag is empty");
		} else {
			LOGGER.info("The bag contains: " + i + " items");
		}
		return i;
	}


	public void clickAddToMobileBag() {
		LOGGER.info("Clicking add to bag");
		sleep(5000);
		addToMobileBag.waitUntilClickable().click();
	}

	public void clickCheckout() {
		LOGGER.info("Clicking go to cart");
		sleep(5000);
		if (cartPopUp.isVisible()) {
			LOGGER.info("Clicking the go to cart button on the popup window on the top right");
			try {
				cartPopUp.waitUntilClickable().click();
			} catch (ElementNotVisibleException e) {
				cartVH.waitUntilClickable().click();
			}
		} else {
			LOGGER.info("Clicking on the standard cart link on the top right");
			cartVH.waitUntilClickable().click();
		}
	}



	public void clickMobileCheckout() {
		LOGGER.info("Clicking go to cart");
		if (cartPopUp.isVisible()) {
			LOGGER.info("Clicking the go to cart button on the popup window on the top right");
			try {
				cartPopUp.waitUntilClickable().click();
			} catch (ElementNotVisibleException e) {
				cartVH.waitUntilClickable().click();
			}
		} else {
			LOGGER.info("Clicking on the standard cart link on the top right");
			mobileCartVH.waitUntilClickable().click();
		}
	}

	/**
	 * Method to add product to cart for first size available in stock
	 */

	public void chooseRandomSizeandAddToBag() {

		if(getDriver().findElements(By.xpath("//div[@id='sizeContainer']")).size() > 0) {
			//LOGGER.info("We don't see the title ");
			WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#sizeContainer"));
			Actions builder = new Actions(getDriver());
			builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
			sleep(5000);
		}

		if(!oneSize.exists() && sizeContainer.size() == 0) {
			LOGGER.info("There is no size selection, or one size selection");
		}

		if (oneSize.exists()) {
			LOGGER.info("There is only one size, which is the one that is selected and added");
			if (pageLevelMessage.exists() || outOfStock.exists()) {
				LOGGER.info("Error exists: " + pageLevelMessage.getText());
			}
		} else if ( sizeContainer.size()== 1) {
			LOGGER.info("There is only one selction of sizes available");
			List<WebElement> size = sizeContainer.get(0).findElements(By.className("available"));
			for (WebElement s : size) {
				LOGGER.info("Selecting size: " + s.getText());
				s.click();

				System.out.println("Selected size is : "+size);
				if (outOfStock.exists() || pageLevelMessage.exists()) {
					LOGGER.info("No stock available for size: " + s.getText());
					continue;
				} else {
					LOGGER.info("Stock available for size: " + s.getText());

					break;
				}
			}
		} else {
			List<WebElement> length = sizeContainer.get(1).findElements(By.className("available"));
			for (WebElement l : length) {
				LOGGER.info("List of avilable lengths: " + l.getText());
			}
			for (WebElement l : length) {
				LOGGER.info("Selecting length: " + l.getText());
				l.click();
				List<WebElement> waist = sizeContainer.get(0).findElements(By.className("available"));
				for (WebElement w : waist) {
					LOGGER.info("List of available waists: " + w.getText());
				}
				for (WebElement w : waist) {
					LOGGER.info("Selecting waist: " + w.getText());
					w.click();
					if (outOfStock.exists() || pageLevelMessage.exists()) {
						LOGGER.info("No stock available for waist: " + w.getText());
						continue;
					} else {
						LOGGER.info("Stock is avilable for length: " + l.getText() + " and waist: " + w.getText());
						break;
					}
				}
				if (outOfStock.exists() || pageLevelMessage.exists()) {
					l.click();
					continue;
				} else {
					break;
				}
			}
		}
	}


	public String getNameOfFirstItemInBagDisplay() {
		String name = firstProductInCartDisplay.getText();
		LOGGER.info("Getting the name of the first product in cart display as: " + name);
		return name;
	}


	public void verifyItemInCartDisplayInCorner() {
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#mini_cart_link"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();

		if (firstProductInCartDisplay.exists()) {
			assertThat(getProductName()).isEqualTo(getNameOfFirstItemInBagDisplay());
		} else {
			assertThat(getProductName()).contains("nothing");
			LOGGER.debug("The cart is empty");
		}
	}

	public void clickGoToCheckOut() {
		if (checkOut.exists()) {
			LOGGER.info("Clicking on go to checkout");
			checkOut.click();
		} else {
			LOGGER.info("No checkout button to click");
		}

	}

	public void updateBag() {
		updateBag.click();
		LOGGER.info("Updated the cart");
	}

	public void clickColorOption(int num)
	{
		if(listOfColors.size()>0) {
			String selectedColor = listOfColors.get(num).getAttribute("data-color-swatch");
			Serenity.setSessionVariable("item1Color").to(selectedColor);
			LOGGER.info("Changing the color to : "+Serenity.sessionVariableCalled("item1Color"));
			listOfColors.get(num).click();
		}
		else
			LOGGER.info("No color options available");

	}
	public void selectQuantityInPopup(String quant) {
		LOGGER.info("Entering quantity ="+Serenity.sessionVariableCalled("item1Quant"));
		quantity.type(quant);
	}

	public void adjustQuantityAddToBag()
	{
		LOGGER.info("Entering quantity ="+Serenity.sessionVariableCalled("item1Quant"));
		//quantity.click();
		//String str1 = Integer.toString(quant); 
		quantityNum.type(Serenity.sessionVariableCalled("item1Quant"));
		sleep(500);
		clickOffPopUp();
		try{
			Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
		clickAddToBag();
	}

	public void updateQuantityAddToBag()
	{
		LOGGER.info("Entering quantity ="+Serenity.sessionVariableCalled("item1Quant"));
		//quantity.click();
		//String str1 = Integer.toString(quant); 
		quantityNum.type(Serenity.sessionVariableCalled("item1Quant"));
		sleep(500);
		clickOffPopUp();
		updateBag();
		LOGGER.info("Clicked on the Update button.");
	}

	public void clickAddToBag() {
		LOGGER.info("Clicking add to bag");
		//	evaluateJavascript("arguments[0].scrollIntoViewIfNeeded(true);", addToBag);
		//		evaluateJavascript("arguments[0].scrollIntoView();", addToBag);
		sleep(5000);
		//addToBag.click();
		addToBag.waitUntilClickable().click();
		//addToBag.click();
	}

}