package com.qualitest.pvh.pages;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class SpeedoItemPage extends ItemPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpeedoItemPage.class);

	@FindBy(id = "add2CartBtn")
	private BaseElement addToBag;

	@FindBy(id = "WC_MiniShopCartDisplay_link_3")
	private BaseElement cart;

	@FindBy(id = "swatchcontainer")
	private BaseElement colorSelector;

	@FindBy(id = "WC_MiniShopCartDisplay_link_1_1")
	private BaseElement firstItemInBagDisplay;

	@FindBy(xpath = "//*[@id=\"contentRecommendationWidget_Logo\"]/div[1]/a/img")
	private BaseElement goToHomePage;

	@FindBy(xpath = "//*[@id= 'netotiate-arena-limited-offer']/div[2]/a")
	private BaseElement limitedTimeOffer;

	@FindBy(xpath = "//*[@id=\"product\"]/div[2]/div[1]/div[1]/div[2]/div[1]/h1/span")
	private BaseElement nameOfProduct;

	@FindBy(xpath = "//*[@id = 'price_display']/span")
	private List<WebElement> offerPrices;

	@FindBy(id = "size_S_One_space_Size")
	private BaseElement oneSize;

	@FindBy(xpath = "//*[@id='pageLevelMessage']/b")
	private BaseElement pageLevelError;

	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	private BaseElement popUpClose;

	@FindBy(xpath = "//*[@id = 'pageLevelMessage']")
	private BaseElement pageLevelMessage;
	//ph1MM3222019
	@FindBy(xpath = "//*[normalize-space(@class ='columncolumnRight')]/div/h1/span")
	protected BaseElement productName;

	//	@FindBy(xpath = "//div[@class='productCell processed']")
	//	protected BaseElement colorSwatch;
	//@FindBy(xpath = "//ul[@class='productswatches clearfix']")
	@FindBy(xpath = "//div[@class='clearfix swatchWrapper ']")
	protected BaseElement colorSwatch;

	//MM04092019 
	@FindBy(xpath = "//*[@class = 'active']")
	//@FindBy(xpath = "//div[@class='clearfix swatchWrapper ']")
	protected  BaseElement colorMobileSwatch;

	@FindBy(xpath = "//h1[@class='productName']//span[@class='productNameInner']")
	private BaseElement mobileProductName;

	@FindBy(id = "size_S_L")
	private BaseElement sizeLarge;

	@FindBy(id = "size_S_M")
	private BaseElement sizeMed;

	@FindBy(className = "sizeSelector")
	private BaseElement sizeSelector;

	@FindBy(id = "size_S_S")
	private BaseElement sizeSmall;

	@FindBy(xpath = "//*[@itemprop = 'productID']")
	private BaseElement styleNumber;
	
	@FindBy(xpath = "//div[@class='productCell processed'][1]")
	protected BaseElement productStyleNumber;

	@FindBy(xpath = "//*[@class='sizeSelector']")
	private List<WebElement> sizeSelectors;

	@FindBy(xpath = "//*[@id='productPageAdd2Wishlist']")
	private WebElement addToWishlist;

	@FindBy(xpath = "//select[contains(@id,'quantity')]")
	private BaseElement quantityPopup;

	@Step
	public void chooseRandomSizeandAddToBag() {

		List<WebElement> size = sizeSelector.findElements(By.className("available"));

		if(!colorSelector.exists() || getColorSelectorSize() == 0) {
			if(oneSize.exists()) {
				LOGGER.info("Only one size and color selection");
				if(pageLevelError.exists()) {
					LOGGER.info("Found the page level error "+pageLevelMessage.getText());
				}
			}else {
				LOGGER.info("Only one color selection, but choosing a random size");
				for(int i = 0; i<size.size(); i++) {
					WebElement s = size.get(i);
					LOGGER.info("Clicking the size element of: "+s.getText());
					s.click();
					if(pageLevelError.exists()) {
						LOGGER.info("Found the page level error "+pageLevelMessage.getText());
					}else {
						break;
					}
				}
			}
		}else{
			for(WebElement s: size) {
				LOGGER.info("List of sizes are: "+s.getText());
			}
			for(WebElement s: size) {
				LOGGER.info("clicking the size of: "+s.getText());
				s.click();
				List<WebElement> color = colorSelector.findElements(By.className("available"));
				WebElement ele = color.get(0);
				LOGGER.info("Clicking on the color element of: "+ele.getText());
				ele.click();
				if(verifyErrorExists("Error:")) {
					LOGGER.info("Found the page level error: "+pageLevelMessage.getText());
				}else {
					break;
				}
			}
		}
	}

	public void closeLimitedTimeOffer() {
		getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@name='netotiate_iframe']")));
		if(limitedTimeOffer.exists()) {
			LOGGER.info("Closing limited time offer");
			limitedTimeOffer.click();
		}	
		getDriver().switchTo().defaultContent();

	}

	@Step
	public int getColorSelectorSize() {
		List<WebElement> l = colorSelector.findElements(By.className("available"));
		int size = l.size();
		LOGGER.info("Returning an int size of: "+size);
		return size;
	}
	public String getNameOfFirstItemInBagDisplay() {
		String name = firstItemInBagDisplay.getText();
		LOGGER.info("Returning a product in bag display with name: "+name);
		return name;
	}
	public String getNameOfProduct() {
		String name = nameOfProduct.getText();
		LOGGER.info("Getting the name of product as: "+name);
		return name;
	}


	@Step
	public String getProductName() {
		//sleep(10000);
		String name = productName.getText();
		LOGGER.info("Returning a product name of: "+name);
		return name;
	}

	/*
	 * cretaed a method for style number only for speedo instead of using itemspage
	 * method ..and added xpath for colorSwatch
	 */
	/*
	 * public String getProductStyleNumber() { String a =
	 * colorSwatch.getAttribute("data-part-number");
	 * System.out.println("the number is"+a); return a; }
	 */

	public String getProductStyleNumber() {
		sleep(5000);
		WebElement csElement= colorSwatch.findElement(By.className("productswatches")).findElement(By.className("active"));
		String a = csElement.getAttribute("data-part-number");
		System.out.println("the number is: "+a);
		return a;
	}

	
	public void clickOffPopUp() {
		if (popUpClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			popUpClose.click();
		}
	}

	//@Step
	public String getMobileProductName() {
		String name = mobileProductName.getText();
		LOGGER.info("Returning a product name of: "+name);
		return name;
	}
	/**
	 * click the large button for size
	 */
	public void clickLarge() {
		LOGGER.info("Clicking Large");
		sizeLarge.click();
	}
	/**
	 * Click the medium button for size
	 */
	public void clickMed() {
		LOGGER.info("Clicking medium");
		sizeMed.click();
	}
	/**
	 * Click the small button for size
	 */
	public  void clickSmall() {
		LOGGER.info("Clicking small");
		sizeSmall.click();
	}
	public int getSizeSelectorSize() {
		List<WebElement> l = sizeSelector.findElements(By.className("available"));
		int size = l.size();
		LOGGER.info("Retunring an int size of: "+size);
		return size;
	}
	public String getStyleNumber() {
		String text = styleNumber.getText();
		LOGGER.info("Getting the style number: "+text);
		return text;
	}
	
	public String getMobileProductStyleNumber() {
		clickOffPopUp();
		sleep(1000);
		String a = productStyleNumber.waitUntilEnabled().getAttribute("data-part-number");
		LOGGER.info("the number is : "+a);
		return a; 
	}
	
	
	
	
	

	public String getURL() {
		String url = getDriver().getCurrentUrl();
		LOGGER.info("Getting the URL: "+url);
		return url;
	}

	@Step
	public float returnOfferPrice() {
		WebElement w;
		if(offerPrices.size() == 1) {
			w = offerPrices.get(0);
		}else {
			w = offerPrices.get(1);
		}
		LOGGER.info("Returning an offer price of: "+w.getText());
		String s = w.getText();
		s = s.replace("$", "").split("-")[0];
		//s = s.replace("$", "");
		LOGGER.info("Modded string value is: "+s);
		float f = Float.parseFloat(s);
		return f;	
	}

	public void selectItemToCart(String size) {
		LOGGER.info("Selecting item of size "+size);
		if(size.equalsIgnoreCase("small")) {
			clickSmall();
		}else if(size.equalsIgnoreCase("medium")) {
			clickMed();
		}else if(size.equalsIgnoreCase("large")) {
			clickLarge();
		}else{
			LOGGER.info("Must pick small, med or large");
		}
		clickAddToBag();
		clickGoToCart();
	}

	public void verifyItemInCartDisplayInCorner() {
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#mini_cart_link"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		if(firstItemInBagDisplay.exists()) {
			assertThat(getProductName()).contains(getNameOfFirstItemInBagDisplay());
		}else {
			LOGGER.debug("The bag is empty");
		}

	}

	@Step
	public String getSizesSelected(){/*

		LOGGER.info("Getting the size of the item");
		if(oneSize.exists()) {
			LOGGER.info("Returning a size of 0 because there weren't any sizes to choose from");
			return "One Size";
		}else if(sizeSelectors.size() == 1) {
			try {
				String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'selected available']/span")).getText();
				LOGGER.info("Returning a size of: "+i);
				return i;
			}catch(Exception e) {
				String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'available selected']/span")).getText();
				LOGGER.info("Returning a size of: "+i);
				return i;
			}
		}else {
			String i = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'selected available']/span")).getText();
			String j = sizeSelectors.get(0).findElement(By.xpath("//*[@class = 'available selected']/span")).getText();
			String ret=  i+"/"+j;
			LOGGER.info("Returning a size of: "+ret);
			return ret;
		}*/
		String sizeXpath = "//div[@data-part-number='"+Serenity.sessionVariableCalled("styleNumber")+"']//div[@class='size']/span[2]";
		String size = find(By.xpath(sizeXpath)).getText();
		LOGGER.info("Returning a size of: " + size);
		return size;
	}

	/**
	 * Method to verify product details page displayed for provided style number
	 * @param styleNum - Style Number of the product
	 */
	public void verifyProductDetailsPageForSpecificStyleNumber(String styleNum) {
		LOGGER.info("Verifying stlye number on product details page");
		String pdpStyleNumber = styleNumber.getText();
		assertThat(pdpStyleNumber).as("Product Details Page displayed for product with Style Number").isEqualTo(styleNum);
	}


	@Override
	public void selectQuantityInPopup(String quant) {
		/*Float quantfloat = Float.parseFloat(quant);
		quantityPopup.click();
		if (checkStock() != 0 & checkStock() < quantfloat) {
			int stock = checkStock().intValue();
			for (int i = 0; i < quantityNum.size(); i++) {
				if (i == stock) {
					LOGGER.info("Selecting quantity: " + i);
					quantityNum.get(i - 1).click();
					break;
				}
			}
		} else {
			for (int i = 0; i < quantityNum.size(); i++) {
				if (i == quantfloat) {
					LOGGER.info("Selecting quantity: " + i);
					quantityNum.get(i - 1).click();
					break;
				}
			}
		}
		replaceButton.click();*/

		Select dropdown = new Select(quantityPopup);
		dropdown.selectByVisibleText(quant);
		sleep(100);
		replaceButton.click();
		sleep(1500);

	}

	public void addToWishList() {
		LOGGER.info("Adding item to wishlist...");
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView(true);", addToWishlist);
		waitABit(5000);
		addToWishlist.click();
	}

}
