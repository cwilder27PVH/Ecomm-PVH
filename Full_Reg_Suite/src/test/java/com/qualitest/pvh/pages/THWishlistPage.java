package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class THWishlistPage extends WishlistPage {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(THWishlistPage.class);
	
	public void verifyWishlistNameMatchesItemPage(String name, float price) {
		LOGGER.info("The name of product in wishlist is: " + getNameOfProduct(0));
		SA.assertThat(getNameOfProduct(0)).isEqualToIgnoringCase(name);
		
		LOGGER.info("The price of the product in wishlist is: " + getProductTotal(0));
		SA.assertThat(getProductTotal(0)).isEqualTo(price);
		
		SA.assertAll();
		//removeFromWishlist();
	}

}
