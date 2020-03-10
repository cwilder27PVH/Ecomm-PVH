package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.PBActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class BagCartTestSteps { 

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;

	@Steps
	PBActor pbUser;

	public static final Logger LOGGER = LoggerFactory.getLogger(BagCartTestSteps.class);


	@And("^User adds item to bag$")
	public void user_adds_item_to_bag() {
		LOGGER.info("Adding item to bag...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.addToBag();
			break;
		case "TH":
			thUser.addToBag();
			break;
		case "SPEEDO":
			speedoUser.addToBag();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.addToBag();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User chooses random size$")
	public void user_chooses_random_size() {
		LOGGER.info("Choosing random size...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.chooseRandomSize();
			// ckUser.saveFirstItemInfo();
			break;
		case "TH":
			thUser.chooseRandomSize();
			//thUser.saveFirstItemInfo();
			break;
		case "SPEEDO":
			speedoUser.chooseRandomSize();
			//speedoUser.saveFirstItemInfo();
			//speedoUser.savePDPProductInfo();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.chooseRandomSize();
			//pbUser.saveFirstItemInfo();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User verifies user is on product page$")
	public void user_verifies_user_is_on_product_page() {
		LOGGER.info("Verifying User is on Product Page...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyUserIsOnPDP();
			break;
		case "TH":
			thUser.verifyUserIsOnPDP();
			break;
		case "SPEEDO":
			speedoUser.verifyUserIsOnPDP();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyUserIsOnPDP();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User verifies title on product page matches item on cart page$")
	public void user_verifies_item_name_matches_cart_item() {
		LOGGER.info("Verifying added item matches item in cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyItemNameMatchesCart();
			break;
		case "TH":
			thUser.verifyItemNameMatchesCart();
			break;
		case "SPEEDO":
			speedoUser.verifyItemNameMatchesCart();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyItemNameMatchesCart();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}


	@Then("^User verifies the second item on cart page is left$")
	public void user_verifies__the_second_item_on_cart_page_is_left() {
		LOGGER.info("User verifies the second item on cart page is left...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifySecondItemNameMatchesCart();
			break;
		case "TH":
			thUser.verifySecondItemNameMatchesCart();
			break;
		case "SPEEDO":
			speedoUser.verifySecondItemNameMatchesCart();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}


	@And("^User quickviews product and replaces item with random size$")
	public void user_quickviews_product_and_replaces() {
		LOGGER.info("Quickviewing product and replacing with random size...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.goToEdit();
			//ckUser.getRandomSizeAndReplace();
			break;
		case "TH":
			thUser.verifyItemNameMatchesCart();
			break;
		case "SPEEDO":
			speedoUser.verifyItemNameMatchesCart();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User searches a second item (.*)$")
	public void user_searches_for_second_product(String second) {
		LOGGER.info("User is searching for a second item...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.searchForItemAfterFirst(second);
			//        	  	 ckUser.saveSecondItemInfo();
			break;
		case "TH":
			thUser.searchForItemInCart(second);
			//                thUser.saveSecondItemInfo();
			break;
		case "SPEEDO":
			speedoUser.searchForItemInCart(second);
			//       	  	 speedoUser.saveSecondItemInfo();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.searchForItemInCart(second);
			//     	  	 pbUser.saveSecondItemInfo();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User adjusts the quantity to (.*)$")
	public void user_adjusts_quantity(String quant) {
		LOGGER.info("The user adjusts the quantity to: " + quant+" ...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.adjustQuantity(quant);
			break;
		case "TH":
			thUser.adjustQuantity(quant);
			break;
		case "SPEEDO":
			speedoUser.adjustQuantity(quant);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.adjustQuantity(quant);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User adjusts the quantity on mobile to (.*)$")
	public void user_adjusts_quantity_on_mobile(String quant) {
		LOGGER.info("The user adjusts the quantity to: " + quant+" ...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.adjustQuantityOnMobile(quant);
			break;
		case "TH":
			thUser.adjustQuantityOnMobile(quant);
			break;
		case "SPEEDO":
			speedoUser.adjustQuantity(quant);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.adjustQuantityOnMobile(quant);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User selects the quantity and sets it to (.*)")
	public void user_selects_quantity(String quant) {
		LOGGER.info("Selecting quantity: " + quant +" ...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.selectQuantityItemPage(quant);
			break;
		case "TH":
			thUser.selectQuantityItemPage(quant);
			break;
		case "SPEEDO":
			speedoUser.selectQuantityItemPage(quant);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.selectQuantityItemPage(quant);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User selects the quantity on mobile and sets it to (.*)")
	public void user_selects_quantity_on_mobile(String quant) {
		LOGGER.info("Selecting quantity: " + quant +" ...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.selectQuantityItemPageOnMobile(quant);
			break;
		case "TH":
			thUser.selectQuantityItemPageOnMobile(quant);
			break;
		case "SPEEDO":
			speedoUser.selectQuantityItemPageOnMobile(quant);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.selectQuantityItemPageOnMobile(quant);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User searches an (.*) with style number and adds it to cart$")
	public void user_add_product_to_cart_with_styleNumber_search(String item) {
		LOGGER.info("Searching for " + item + " and adding it to cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			//ckUser.searchForProductAndAddToCart(item);
			ckUser.searchFor(item);
			ckUser.savePDPProductInfo();
			ckUser.addToBag(); 
			ckUser.goToCartFromHome();
			break;
		case "TH":
			//thUser.searchForProductAndAddToCart(item);
			thUser.searchFor(item);
			thUser.savePDPProductInfo();
			thUser.addToBag(); 
			thUser.goToCartFromHome();
			break;
		case "SPEEDO":
			//speedoUser.searchForProductAndAddToCart(item);
			speedoUser.searchFor(item);
			speedoUser.savePDPProductInfo();
			speedoUser.addToBag(); 
			speedoUser.goToCartFromHome();
			break;
		case "VH":
		case "IZ":
		case "SB":
			//pbUser.searchForProductAndAddToCart(item);
			pbUser.searchFor(item);
			pbUser.savePDPProductInfo();
			pbUser.addToBag(); 
			pbUser.goToCartFromHome();
			break;

		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");

		}
	}


	@And("^User searches on mobile an (.*) with style number and adds it to cart$")
	public void user_add_product_on_mobile_to_cart_with_styleNumber_search(String item) {
		LOGGER.info("Searching for " + item + " and adding it to cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			//ckUser.searchForProductAndAddToCart(item);
			ckUser.mobileSearchFor(item);
			ckUser.savePDPProductInfo();
			ckUser.mobileAddToBag(); 
			ckUser.goToCartFromHome();
			break;
		case "TH":
			//thUser.searchForProductAndAddToCart(item);
			thUser.mobileSearchFor(item);
			thUser.saveMobilePDPProductInfo();
			thUser.addToBag(); 
			thUser.goToCartFromHome();
			break;
		case "SPEEDO":
			//speedoUser.searchForProductAndAddToCart(item);
			speedoUser.mobileSearchFor(item);
			speedoUser.savePDPProductInfo();
			speedoUser.addToBag(); 
			speedoUser.goToCartFromHome();
			break;
		case "VH":
		case "IZ":
		case "SB":
			//pbUser.searchForProductAndAddToCart(item);
			pbUser.mobileSearchFor(item);
			pbUser.saveMobilePDPProductInfo();
			pbUser.mobileAddToBag();
			//pbUser.addToBag();
			pbUser.goToCartFromMobileHome();
			break;

		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");

		}
	}

	@And("^User searches another (.*) with style number and adds it to cart$")
	public void user_add_another_product_to_cart_with_styleNumber_search(String item) {
		LOGGER.info("Searching for " + item + " and adding it to cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			//ckUser.searchForProductAndAddToCart(item);
			ckUser.searchFor(item);
			ckUser.savePDPSecondProductInfo();
			ckUser.addToBag(); 
			ckUser.goToCartFromHome();
			break;
		case "TH":
			//thUser.searchForProductAndAddToCart(item);
			thUser.searchFor(item);
			thUser.savePDPSecondProductInfo();
			thUser.addToBag(); 
			thUser.goToCartFromHome();
			break;
		case "SPEEDO":
			//speedoUser.searchForProductAndAddToCart(item);
			speedoUser.searchFor(item);
			speedoUser.savePDPSecondProductInfo();
			speedoUser.addToBag(); 
			speedoUser.goToCartFromHome();
			break;
		case "VH":
		case "IZ":
		case "SB":
			//pbUser.searchForProductAndAddToCart(item);
			pbUser.searchFor(item);
			pbUser.savePDPSecondProductInfo();
			pbUser.addToBag(); 
			pbUser.goToCartFromHome();
			break;

		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");

		}
	}

	@And("^User searches on mobile another (.*) with style number and adds it to cart$")
	public void user_add_another_product_on_mobile_to_cart_with_styleNumber_search(String item) {
		LOGGER.info("Searching for " + item + " and adding it to cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			//ckUser.searchForProductAndAddToCart(item);
			ckUser.mobileSearchFor(item);
			ckUser.savePDPSecondProductInfo();
			ckUser.mobileAddToBag(); 
			ckUser.goToCartFromHome();
			break;
		case "TH":
			//thUser.searchForProductAndAddToCart(item);
			thUser.mobileSearchFor(item);
			thUser.savePDPSecondProductInfo();
			thUser.addToBag(); 
			thUser.goToCartFromHome();
			break;
		case "SPEEDO":
			//speedoUser.searchForProductAndAddToCart(item);
			speedoUser.mobileSearchFor(item);
			speedoUser.saveMobilePDPSecondProductInfo();
			speedoUser.addToBag(); 
			speedoUser.goToCartFromHome();
			break;
		case "VH":
		case "IZ":
		case "SB":
			//pbUser.searchForProductAndAddToCart(item);
			pbUser.mobileSearchFor(item);
			pbUser.savePDPSecondProductInfo();
			pbUser.mobileAddToBag(); 
			pbUser.goToCartFromMobileHome();
			break;

		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");

		}
	}

	@And("^User clicks add to bag$")
	public void user_clicks_addtobag() {
		LOGGER.info("Adding to Cart");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.addToBag();
			break;
		case "TH":
			thUser.addToBag();
			break;
		case "SPEEDO":
			speedoUser.addToBag();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.addToBag();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User should verify that both items are in bag$")
	public void user_should_verify_that_both_items_are_in_bag() {
		LOGGER.info("User is verifying that two items are in the bag...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyTwoItemsMatchesCart();
			break;
		case "TH":
			thUser.verifyTwoItemsMatchesCart();
			break;
		case "SPEEDO":
			speedoUser.verifyTwoItemsMatchesCart();
			break;
		case "VH":
		case "IZ":
			//MM04092019
		case "SB":
			pbUser.verifyTwoItemsMatchesCart();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User removes the second item$")
	public void user_removes_second_item_from_cart() {
		LOGGER.info("User is removing the second item...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.removeSecondItemFromCart();
			break;
		case "TH":
			thUser.removeSecondItemFromCart();
			break;
		case "SPEEDO":
			speedoUser.removeSecondItemFromCart();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.removeSecondItemFromCart();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User removes the first item$")
	public void user_removes_first_item_from_cart() {
		LOGGER.info("Removing the first or only item in the cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.removeFirstItemFromCart();
			break;
		case "TH":
			speedoUser.removeFirstItemFromCart();
			break;
		case "SPEEDO":
			speedoUser.removeFirstItemFromCart();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.removeFirstItemFromCart();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User verifies that the cart is empty$")
	public void user_verifies_that_the_cart_is_empty() {
		LOGGER.info("Removing the first or only item in the cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyEmptyCart();
			break;
		case "TH":
			speedoUser.verifyEmptyCart();
			break;
		case "SPEEDO":
			speedoUser.verifyEmptyCart();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyEmptyCart();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@And("^User is signed in")
	public void user_is_signed_in() {
		LOGGER.info("Verifying user is signed in...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 

			break;
		case "TH":
			speedoUser.verifySignedIn();
			break;
		case "SPEEDO":
			speedoUser.verifySignedIn();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User goes to cart page$")
	public void go_to_cart() {
		LOGGER.info("Going to cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.goToCartFromHome();
			break;
		case "TH":
			thUser.goToCartFromHome();
			break;
		case "SPEEDO":
			speedoUser.goToCartFromHome();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.goToCartFromHome();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User goes to mobile cart page$")
	public void go_to_mobile_cart() {
		LOGGER.info("Going to cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.goToCartFromHome();
			break;
		case "TH":
			thUser.goToCartFromHome();
			break;
		case "SPEEDO":
			speedoUser.goToCartFromHome();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.goToCartFromMobileHome();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User removes all items in cart$")
	public void user_removes_all_items_in_cart() {
		LOGGER.info("Removing all items in cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.clearCart();
			break;
		case "TH":
			thUser.clearCart();
			break;
		case "SPEEDO":
			speedoUser.removeFirstItemFromCart();
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.removeFirstItemFromCart();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User adds a gift box to (.*) from (.*) with message (.*)$")
	public void user_adds_gift_box(String to, String from, String message) {
		LOGGER.info("Adding a gift box...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.addGiftBox(to, from, message);
			break;
		case "TH":
			thUser.addGiftBox(to, from, message);
			break;
		case "SPEEDO":
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.addGiftBox(to, from, message);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@And("^User edits the gift box with new to (.*) from (.*) with new message (.*)$")
	public void user_edits_gift_box(String newTo, String newFrom, String newMessage) {
		LOGGER.info("Adding a gift box...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.editGiftBox(newTo, newFrom, newMessage);
			break;
		case "TH":
			thUser.editGiftBox(newTo, newFrom, newMessage);
			break;
		case "SPEEDO":
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.editGiftBox(newTo, newFrom, newMessage);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, Sb, IZ");
		}
	}
	@Then("^User verifies gift box text (.*) (.*) and (.*) matches provided$")
	public void user_verifies_gift_box_texts_matches_provided(String to, String from, String message) {
		LOGGER.info("Verifying gift box text matches provided...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyGiftBoxText(to, from, message);
			break;
		case "TH":
			thUser.verifyGiftBoxText(to, from, message);
			break;
		case "SPEEDO":
			//MM04092019
			speedoUser.verifyGiftBoxText(to, from, message);
			break;
		case "SB":
		case "IZ":
		case "VH":
			pbUser.verifyGiftBoxText(to, from, message);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User removes the gift box$")
	public void user_removes_gift_box() {
		LOGGER.info("Removing the gift box...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.removeGiftBox();
			break;
		case "TH":
			thUser.removeGiftBox();
			break;
		case "SPEEDO":
			speedoUser.removeGiftBox();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.removeGiftBox();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
	@Then("^User verifies gift box has been removed$")
	public void user_verifies_gift_box_removed() {
		LOGGER.info("Verifying the gift box has been removed...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyGiftBoxRemoved();
			break;
		case "TH":
			thUser.verifyGiftBoxRemoved();
			break;
		case "SB":
		case "VH":
			pbUser.verifyGiftBoxRemoved();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@And("^User navigates to quick view page of first product and adds it to bag$")
	public void user_goes_to_quick_view_and_adds_product() {
		LOGGER.info("Navigating to first product quick view and adding random size...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			break;
		case "TH":
			thUser.addItemFromQuickViewPage();
			break;
		case "SPEEDO":
			speedoUser.addItemFromQuickViewPage();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.addItemFromQuickViewPage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@And("^User edits product to another size from edit page$")
	public void user_edits_product_to_quant_from_edit_page() {
		LOGGER.info("Editing the product in the edit page on the cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.saveSizeInfo();
			ckUser.goToCartFromCartCornerLink();
			ckUser.clickEditItemFromCartForFirst();
			break;
		case "TH":
			thUser.saveSizeInfo();
			thUser.goToCartFromCartCornerLink();
			thUser.clickEditItemFromCartForFirst();
			break;
		case "SPEEDO":
			speedoUser.saveSizeInfo();
			speedoUser.goToCartFromCartCornerLink();
			speedoUser.clickEditItemFromCartForFirst();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.saveSizeInfo();
			pbUser.goToCartFromCartCornerLink();
			pbUser.clickEditItemFromCartForFirst();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User selects to edits product to on mobile cart$")
	public void user_selects_to_edits_product_to_on_mobile_cart() {
		LOGGER.info("Editing the product in the edit page on the cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			//ckUser.saveSizeInfo();
			// ckUser.goToCartFromCartCornerLink();
			ckUser.selectToEditItemFromCartForFirst();
			break;
		case "TH":
			// thUser.saveSizeInfo();
			//thUser.goToCartFromCartCornerLink();
			thUser.selectToEditItemFromCartForFirst();
			break;
		case "SPEEDO":
			//speedoUser.saveSizeInfo();
			//speedoUser.goToCartFromCartCornerLink();
			speedoUser.selectToEditItemFromCartForFirst();
			break;
		case "VH":
		case "IZ":
		case "SB":
			//pbUser.saveSizeInfo();
			// pbUser.goToCartFromCartCornerLink();
			pbUser.selectToEditItemFromCartForFirst();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@Then("^User verify edit change in bag$")
	public void user_verify_edit_change_in_bag() {
		LOGGER.info("Verifying the change made in the edit option in cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifySizesAfterEdit();
			break;
		case "TH":
			thUser.verifySizesAfterEdit();
			break;
		case "SPEEDO":
			speedoUser.verifySizesAfterEdit();
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.verifySizesAfterEdit();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
	@And("^User applies promo (.*)$")
	public void user_applies_promo_code(String code) {
		LOGGER.info("Applying promo code...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.applyPromoCode(code);
			break;
		case "TH":
			thUser.applyPromoCode(code);
			break;
		case "SPEEDO":
			speedoUser.applyPromoCode(code);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.applyPromoCode(code);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User should get promo error message (.*)$")
	public void user_validates_promo_code_error(String message){
		LOGGER.info("Validating promo code error");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyPromoMessage(message);
			break;
		case "TH":
			thUser.verifyPromoMessage(message);
			break;
		case "SPEEDO":
			speedoUser.verifyPromoMessage(message);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPromoMessage(message);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@And("^User adds the product to their wishlist$")
	public void user_adds_product_to_wishlist() {
		LOGGER.info("Adding the product to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.savePDPProductInfo();
			ckUser.addToWishlist();
			break;
		case "TH":
			thUser.savePDPProductInfo();
			thUser.addToWishlist();
			break;
		case "SPEEDO":
			break;
		case "VH":
		case "IZ": 
		case "SB": 
			pbUser.savePDPProductInfo();
			pbUser.addToWishlist();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}


	@And("^User adds the product to their mobile wishlist$")
	public void user_adds_product_to_mobile_wishlist() {
		LOGGER.info("Adding the product to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.saveMobilePDPProductInfo();
			ckUser.addToMobileWishlist();
			break;
		case "TH":
			thUser.savePDPProductInfo();
			thUser.addToMobileWishlist();
			break;
		case "SPEEDO":
			break;
		case "VH":
		case "IZ": 
		case "SB": 
			pbUser.saveMobilePDPProductInfo();
			pbUser.addToWishlist();
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@And("^User navigates to their wishlist and adds the first item to cart$")
	public void user_navigates_to_wishlist() {
		LOGGER.info("Navigating to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.goToWishlist();
			ckUser.addToBagFromWishlist();
			break;
		case "TH":
			thUser.goToWishlist();
			thUser.addToBagFromWishlist();
			break;
		case "SPEEDO":
			break;
		case "VH":
		case "IZ": 
		case "SB": 
			pbUser.goToWishlist();
			pbUser.addToBagFromWishlist();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}	


	@And("^User navigates to their mobile wishlist and adds the first item to cart$")
	public void user_navigates_to_mobile_wishlist() {
		LOGGER.info("Navigating to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.goToMobileWishlist();
			ckUser.addToBagFromWishlist();
			break;
		case "TH":
			thUser.goToMobileWishlist();
			thUser.addToBagFromWishlist();
			break;
		case "SPEEDO":
			break;
		case "VH":
		case "IZ": 
		case "SB": 
			pbUser.goToMobileWishlist();
			pbUser.addToBagFromMobileWishlist();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}	

	@And("^User adds (.*) of items (.*) to cart$")
	public void user_adds_quantity_items(String num, String item) {
		LOGGER.info("Adding Items to Bag...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.addAmountOfItems(Integer.parseInt(num), item);
			break;
		case "TH":
			thUser.addAmountOfItems(Integer.parseInt(num), item);
			break;
		case "SPEEDO":
			speedoUser.addAmountOfItems(Integer.parseInt(num), item);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@Then("^User verifies error on item page (.*)$")
	public void user_verifies_error_on_item_page(String error) {
		LOGGER.info("User verifies error on item page...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyPageLevelMessageOnItemPage(error);
			break;
		case "TH":
			thUser.verifyPageLevelMessageOnItemPage(error);
			break;
		case "SPEEDO":
			speedoUser.verifyPageLevelMessageOnItemPage(error);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}



	@Then("^User verifies (.*) quantity not available$")
	public void user_verifies_quantity_not_available(String error) {
		LOGGER.info("Navigating to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyQuantityNotAvailableError();
			break;
		case "TH":
			thUser.verifyQuantityNotAvailableError();
			break;
		case "SPEEDO":
			speedoUser.verifyQuantityNotAvailableError();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}




	@And("^User adds (.*) to the cart$")
	public void user_adds_to_cart(String code) {
		LOGGER.info("Applying promo code...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.addItemToCartTwice(code);
			break;
		case "TH":
			thUser.addItemToCartTwice(code);
			break;
		case "SPEEDO":
			speedoUser.addItemToCartTwice(code);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}


	@Then("^User adds items till quantity left less than twelve$")
	public void user_adds_items_till_quantityless() {
		LOGGER.info("Adding items until quantity less than twelve...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.addItemsForQuantityLess12Check();
			break;
		case "TH":
			thUser.addItemsForQuantityLess12Check();
			break;
		case "SPEEDO":
			speedoUser.addItemsForQuantityLess12Check();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}



	@Then("^User verifies item still in cart$")
	public void user_verifies_item_still_incart() {
		LOGGER.info("Adding items until quantity less than twelve...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyItemWasAdded();
			break;
		case "TH":
			thUser.verifyItemWasAdded();
			break;
		case "SPEEDO":
			speedoUser.verifyItemWasAdded();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

	@And("^User adjusts the quantity of (.*) without checking stock$")
	public void user_adjusts_quantity_without_checking_stock(String quant) {
		LOGGER.info("The user adjusts the quantity to: " + quant+" ...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.adjustQuantityWithoutCheckStock(quant);
			break;
		case "TH":
			thUser.adjustQuantityWithoutCheckStock(quant);
			break;
		case "SPEEDO":
			speedoUser.adjustQuantityWithoutCheckStock(quant);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}
	@Then("^User verifies user is prompted to select a size$")
	public void user_verifies_prompt_to_select_size() {
		LOGGER.info("Verifying prompt to select size");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyPleaseSelectASize();
			break;
		case "TH":
			thUser.verifyPleaseSelectASize();
			break;
		case "SPEEDO":
			speedoUser.verifyPleaseSelectASize();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPleaseSelectASize();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	@Then("^User verifies that clicking edit bag navigates to cart$")
	public void user_verifies_that_clicking_edit_bag_navigates_to_cart() {
		LOGGER.info("User verifies that clicking edit bag navigates to cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyCartPage();
			break;
		case "TH":
			break;
		case "SPEEDO":
			break;
		case "VH": 
		case "IZ":
		case "SB":
			pbUser.verifyCartPage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@When("User finds item and selects size (.*)")
	public void user_searches_for_item_and_selects_size(String item) {
		LOGGER.info("User searches for item and selects size");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.searchForItemInCart(item);
			break;
		case "TH":

			break;
		case "SPEEDO":

			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}



	@Then("^User verifies page level message for less quantity displayed$")
	public void user_searches_for_item_and_selects_size() {
		LOGGER.info("User searches for item and selects size");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyQuantityPageLevelMessage();
			break;
		case "TH":
			thUser.verifyQuantityPageLevelMessage();
			break;
		case "SPEEDO":
			speedoUser.verifyQuantityPageLevelMessage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}



	@Then("^User adjusts (.*) and adds to bag$")
	public void user_adjusts_quant_adds_toBag(int quant) {
		LOGGER.info("User searches for item and selects size");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.adjustQuantityAddToBag(quant);
			break;
		case "TH":
			thUser.adjustQuantityAddToBag(quant);
			break;
		case "SPEEDO":
			speedoUser.adjustQuantityAddToBag(quant);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}


	@Then("^User verifies (.*) of items in cart less$")
	public void user_verifies_less_items(String code) {
		LOGGER.info("Checking Number of Items in Cart...");
		String brand = Serenity.sessionVariableCalled("brand");	
		switch(brand.toUpperCase()) {
		case "CKUS":
		case "CKCA": 
			ckUser.verifyNumItemsInCart(code);
			break;
		case "TH":
			thUser.verifyNumItemsInCart(code);
			break;
		case "SPEEDO":
			speedoUser.verifyNumItemsInCart(code);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.verifyNumItemsInCart(code);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

}