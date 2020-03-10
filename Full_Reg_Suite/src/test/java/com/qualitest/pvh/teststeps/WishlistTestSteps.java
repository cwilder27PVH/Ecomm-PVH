package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.PBActor;
import com.qualitest.pvh.actors.PaypalActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class WishlistTestSteps { 
	
	@Steps
	CKActor ckUser;
	
	@Steps
	THActor thUser;
	
	@Steps
	SpeedoActor speedoUser;
	
	@Steps
	PaypalActor ppUser;
	
	@Steps
	PBActor pbUser;
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(WishlistTestSteps.class);
	
	@And("^User adds item from cart to wishlist$")
	public void add_item_from_cart_to_wishlist() {
		LOGGER.info("Adding item from cart to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.addCartItemToWishlist();
			break;
		case "TH":
			thUser.addCartItemToWishlist();
			break;
		case "SPEEDO":
			
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.addCartItemToWishlist();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}


	@Then("^User verifies adding item from cart to wishlist for guest user$")
	public void add_item_from_cart_to_wishlist_for_guest_user() {
		LOGGER.info("Adding item from cart to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyAddingCartItemToWishlistForGuestUser();
			break;
		case "TH":
			thUser.verifyAddingCartItemToMobileWishlistForGuestUSer();
			break;
		case "SPEEDO":
			
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.addCartItemToWishlist();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}

	@And("^User navigates to wishlist$")
	public void user_navigates_to_wishlist() {
		LOGGER.info("Navigating to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.goToWishlist();
			break;
		case "TH":
			thUser.goToWishlist();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.goToWishlist();
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	
	@And("^User navigates to mobile wishlist$")
	public void user_navigates_to_mobile_wishlist() {
		LOGGER.info("Navigating to wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.goToMobileWishlist();
			break;
		case "TH":
			thUser.goToMobileWishlist();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.goToMobileWishlist();
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@Then("^User verifies wishlist item matches item from cart$")
	public void user_verifies_wishlist_item_matches_cart() {
		LOGGER.info("Verifying wishlist item matches item added from cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyWishlistNameMatchesCart();
			break;
		case "TH":
			thUser.verifyWishlistNameMatchesCart();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyWishlistNameMatchesCart();
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("^User verifies (.*) item is already in wishlist$")
	public void user_verifies_error_item_already_in_wishlist(String error) {
		LOGGER.info("Verifying error wishlist item already in wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyWishlistError(error);
			break;
		case "TH":
			thUser.verifyWishlistError(error);
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.verifyWishlistError(error);
			break;
		case "SPEEDO":
			
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("^User clear wishlist$")
	public void user_clear_wishlist() {
		LOGGER.info("Removing item from wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.goToWishlist();
			ckUser.clearWishlist();
			break;
		case "TH":
			thUser.goToWishlist();
			thUser.clearWishlist();
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.goToWishlist();
			pbUser.clearWishlist();
			break;
		case "SPEEDO":
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
	
	@And("^User clear mobile wishlist$")
	public void user_clear_mobile_wishlist() {
		LOGGER.info("Removing item from wishlist...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.clearMobileWishlist();
			break;
		case "TH":
			thUser.clearMobileWishlist();
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.clearMobileWishlist();
			break;
		case "SPEEDO":
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
	
	@And("^User clear cart$")
	public void user_clear_cart() {
		LOGGER.info("Removing item from cart...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.clearCart();
			break;
		case "TH":
			thUser.clearCart();
			break;
		case "VH":
		case "SB":
		case "IZ":
			pbUser.clearCart();
			break;
		case "SPEEDO":
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, SB, IZ");
		}
	}
}