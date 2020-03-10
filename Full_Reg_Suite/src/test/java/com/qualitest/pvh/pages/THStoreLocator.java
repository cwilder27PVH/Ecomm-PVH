package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class THStoreLocator extends StoreLocator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(THStoreLocator.class);
	
	@FindBy(xpath = "//*[@class='errormap']")
	private BaseElement noresultMessage;
	
	/**
	 * Method to switch focus to store locator frame
	 */
	@Step
	public void switchFocusToStoreLocator() {
		LOGGER.info("Switching focus to Store Locator Frame");
		getDriver().switchTo().frame(getDriver().findElement(By.xpath("//iframe[@title='storelocator']")));
	}
	
	/**
	 * Method to verify no search result error message
	 * @param message - Expected No search result error message
	 */
	@Step
	public void verifyNoResultError(String message) {
		LOGGER.info("Verifying no search result message");
		if(noresultMessage.isVisible()) {
			assertThat(noresultMessage.getText().toUpperCase()).as("No Result Error Message").contains(message.toUpperCase());
		} else {
			sleep(15*1000);
			assertThat(noresultMessage.getText().toUpperCase()).as("No Result Error Message").contains(message.toUpperCase());
		}
		
	}
	
	/**
	 * Method to verify valid search result map is displayed
	 */
	@Step
	public void verifyStoreLocatorResult(String location) {
		LOGGER.info("Verifying valid search result is displayed");
		try {
			if(noresultMessage.isDisplayed()) {
				assertThat(noresultMessage.isDisplayed()).as("No Search Result Message").isFalse();
			}
		} catch (Exception e) {
			verifySearchLocation(location);
		}
	}
	
}
