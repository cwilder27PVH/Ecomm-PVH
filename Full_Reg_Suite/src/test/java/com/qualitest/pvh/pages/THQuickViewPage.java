package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;


public class THQuickViewPage extends quickViewPage {
	private static final Logger LOGGER = LoggerFactory.getLogger(THQuickViewPage.class);
	//start MM 3/25/19 -- added new xpath for style number of product
		@FindBy(xpath = "//span[@itemprop='productID']")
		private BaseElement styleNumber;
		
		//start MM 3/25/19 -- added method to get the style number of product
		@Step
		public String getStyleNumber() {
			String name  = styleNumber.getText();
			LOGGER.info("Getting the name of product as: "+name);
			return name;
		}

}
