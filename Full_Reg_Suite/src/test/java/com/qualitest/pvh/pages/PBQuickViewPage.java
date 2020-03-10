package com.qualitest.pvh.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class PBQuickViewPage extends quickViewPage {

	@FindBy(id = "pageLevelMessage")
	private BaseElement pageLevelMessage;
	
	@FindBy(xpath = "//*[@class = 'inventoryStatus out']")
	private BaseElement outOfStock;
	
	@FindBy(xpath = "//div[@id='productSizesContainer_3074457345625460318']//div[@id='sizeContainer']")
	private List<WebElement> sizeSelectors;
	//ul[@id='sizes_3074457345625460318']
//	@FindBy(xpath = "//div[@id='btn-container_3074457345625587169']//a[@id='add2CartBtn']")
	@FindBy(xpath = "//div[@class='btn-right primary']//a[@id='add2CartBtn']")
	private BaseElement addToBag;
	
	@FindBy(className = "productName")
	private BaseElement productName;

@FindBy(xpath = "//div[@id='price_display']/span")
	private List<WebElement> offerPrices;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(quickViewPage.class);
	
	
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
		s = s.replace("$", "");
		s = s.replaceAll(",", "");
		LOGGER.info("Modded string value is: "+s);
		if(s.contains("-")) {
			LOGGER.info("There is an issue where even though we selected size and color, there is no exact price displayed. Only a range");
		}
		float f = Float.parseFloat(s);
		return f;	
	}
	@Step
	public String getProductName() {
		String name  = productName.getText();
		LOGGER.info("Getting the name of product as: "+name);
		return name;
	}
	
	@Step
	public void chooseRandomSizeWithStock() {
			
			if(sizeSelectors.size() == 0) {
				LOGGER.info("There is only one size, which is the one that is selected and added");
				addToBag.click();
				if(pageLevelMessage.exists() || outOfStock.exists()) {
					LOGGER.info("Error exists: "+pageLevelMessage.getText());
				}
			} else if(sizeSelectors.size() == 1) {
				LOGGER.info("There is only one selction of sizes and user is selecting from");
				List<WebElement> size = sizeSelectors.get(0).findElements(By.className("available"));
				for(WebElement s: size) {
					LOGGER.info("Clicking the size of: "+s.getText());
					s.click();
					if(outOfStock.exists()) {
						LOGGER.info("There is no inventory for: "+s.getText());
						continue;
					}
					if(!outOfStock.exists()) {
						LOGGER.info("Stopping cycle of searching for size");
						break;
					}
				}
			}else{
				List<WebElement> length = sizeSelectors.get(1).findElements(By.className("available"));
				for(WebElement l: length) {
					LOGGER.info("List of lengths are: "+l.getText());
				}
				for(WebElement l: length) {
					LOGGER.info("Clicking length size "+l.getText() );
					l.click();
					List<WebElement> waist = sizeSelectors.get(0).findElements(By.className("available"));		
					for(WebElement w: waist) {
						LOGGER.info("List of waists are: "+w.getText());
					}
					for(WebElement w: waist) {
						LOGGER.info("Clicking waist size: "+w.getText());
						w.click();
						if(outOfStock.exists()) {
							LOGGER.info("There is no inventory for: "+w.getText());
							continue;
						}
						if(!outOfStock.exists()) {
							break;
						}
					}	
					if(outOfStock.exists()) {
						l.click();
						continue;
					}
					if(!outOfStock.exists()) {
						break;
					}
				}
			}
		}
	
	
	@Step
	public void clickAddToBag() {
		LOGGER.info("Clicking add to bag");
		addToBag.click();
		}
	}

