package com.qualitest.pvh.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;

public class PBWishlistPage extends WishlistPage {
	
	@FindBy(xpath = "//a[@id='WC_MyAccountSidebarDisplayf_links_7']")
	private BaseElement myAccountWishlist;
	
	@FindBy(id="WishListEmailSucMsg_Div")
	private BaseElement successfulShare;
	
	@FindBy(xpath = "//div[@class='clearfix priceAndQuantity']//div[@class='deleteLink']//a[@class='hover_underline'][contains(text(),'Remove')]")
	private BaseElement removeItemFromMobileWishlist;
	//MM492019 Added new xpath for add to bag to be clickable
	//@FindBy(xpath="//div[@class='productRight wishlistDesktop']//div[@id='WC_CatalogEntryDBThumbnailDisplayJSPF_3074457345626778676_div_11']//div[@class='button_text primary-button'][contains(text(),'Add To Bag')]")
	@FindBy(xpath="(//div[@class='button_text primary-button'][contains(text(),'Add To Bag')])[2]")
	private BaseElement addToBag;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WishlistPage.class);
	
	public void verifySharedWishlistPB() {

			SA.assertThat(successfulShare.getText()).containsIgnoringCase("Your wishlist will be sent to");

		SA.assertAll();
		//removeFromWishlist();
	}
	
	public void removeFromMobileWishlist() {
		LOGGER.info("Removing item from wishlist");
		removeItemFromMobileWishlist.click();
	}
	
	public void addFirstItemToCart() {
		LOGGER.info("Adding first item from wishlist to cart...");
		getDriver().navigate().refresh();
		addToBag.click();
	}


}
