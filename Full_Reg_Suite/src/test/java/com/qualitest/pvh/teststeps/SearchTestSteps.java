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

public class SearchTestSteps {

	public static final Logger LOGGER = LoggerFactory.getLogger(SearchTestSteps.class);

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;
	
	@Steps
	PBActor pbUser;

	@When("^User searches with keyword as (.*)$")
	public void user_searches_with_keyword_as(String search) {
		LOGGER.info("Searching product with search keyword: " + search + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.searchFor(search);
			break;
		case "TH":
			thUser.searchFor(search);
			break;
		case "SPEEDO":
			speedoUser.searchFor(search);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.searchFor(search);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@When("^User searches on mobile with keyword as (.*)$")
	public void user_searches_on_mobile_with_keyword_as(String search) {
		LOGGER.info("Searching product with search keyword: " + search + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.mobileSearchFor(search);
			break;
		case "TH":
			thUser.mobileSearchFor(search);
			break;
		case "SPEEDO":
			speedoUser.mobileSearchFor(search);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.mobileSearchFor(search);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@When("^User searches for (.*)$")
	public void user_searches_for(String search) {
		LOGGER.info("Searching product with search keyword: " + search + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.searchFor(search);
			ckUser.savePDPProductInfo();
			break;
		case "TH":
			thUser.searchFor(search);
			thUser.savePDPProductInfo();
			break;
		case "SPEEDO":
			speedoUser.searchFor(search);
			speedoUser.savePDPProductInfo();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.searchFor(search);
			pbUser.savePDPProductInfo();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@When("^User searches on mobile for (.*)$")
	public void user_searches_on_mobile_for(String search) {
		LOGGER.info("Searching product with search keyword: " + search + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.mobileSearchFor(search);
			ckUser.savePDPProductInfo();
			break;
		case "TH":
			thUser.mobileSearchFor(search);
			thUser.savePDPProductInfo();
			break;
		case "SPEEDO":
			speedoUser.mobileSearchFor(search);
			speedoUser.saveMobilePDPProductInfo();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.mobileSearchFor(search);
			pbUser.savePDPProductInfo();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}
	

	@Then("^User verifies for search suggestion$")
	public void User_verifies_for_search_suggestion() {
		LOGGER.info("Checking if search suggestions are displayed");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
//			ckUser.searchFor();
			break;
		case "TH":
//			thUser.searchFor();
			break;
		case "SPEEDO":
//			speedoUser.searchFor();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.validateSearchSuggestion();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@Then("^User verifies for search correction$")
	public void User_verifies_for_search_correction() {
		LOGGER.info("Checking if typehead is displayed");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
//			ckUser.searchFor();
			break;
		case "TH":
//			thUser.searchFor();
			break;
		case "SPEEDO":
//			speedoUser.searchFor();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.validateSearchCorrection();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@Then("^User should see results for (.*)$")
	public void user_should_see_search_result_for(String searchTerm) {
		LOGGER.info("Verifying search result...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifySearchResults(searchTerm);
			break;
		case "TH":
			thUser.verifySearchResults(searchTerm);
			break;
		case "SPEEDO":
			speedoUser.verifySearchResults(searchTerm);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifySearchResults(searchTerm);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@Then("^User should see search results for selected search suggestion(.*)$")
	public void user_should_see_search_result_for_selected_search_uggestion(String searchTerm) {
		LOGGER.info("Verifying search result...");
		String brand = Serenity.sessionVariableCalled("brand");
		String selectedSearchSuggestion = Serenity.sessionVariableCalled("selectedSearchSuggestion");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
//			ckUser.verifySearchResults(searchTerm);
			break;
		case "TH":
//			thUser.verifySearchResults(searchTerm);
			break;
		case "SPEEDO":
//			speedoUser.verifySearchResults(searchTerm);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifySearchResults(selectedSearchSuggestion);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@Then("^User should see (.*) product details")
	public void user_should_see_product_details(String styleNumber) {
		LOGGER.info("Verifying search result for style number: " + styleNumber + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		case "TH":
			thUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		case "SPEEDO":
			speedoUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, IZ, SB, VH");
		}

	}
	

	@Then("^User should view mobile(.*) product details")
	public void user_should_view_mobile_product_details(String styleNumber) {
		LOGGER.info("Verifying search result for style number: " + styleNumber + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifySearchResultsForStyleNumberOnMobile(styleNumber);
			break;
		case "TH":
			thUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		case "SPEEDO":
			speedoUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifySearchResultsForStyleNumber(styleNumber);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, IZ, SB, VH");
		}

	}
	
	@Then("^User should see no search results message$")
	public void user_should_see_no_search_result_message() {
		LOGGER.info("Verifying no search result message...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyNoResults();
			break;
		case "TH":
			thUser.verifyNoResults();
			break;
		case "SPEEDO":
			speedoUser.verifyNoResults();
		case "VH":
		case "SB":
		case "IZ":
			pbUser.verifyNoResults();
		}
	}

	@Then("^User should have items displayed related to item$")
	public void user_should_have_an_item_displayed_related_to() {
		LOGGER.info("User is verifying if items are being displayed related to the query...");
		String brand = Serenity.sessionVariableCalled("brand");
		String search = Serenity.sessionVariableCalled("search");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyStyleID(search);
			break;
		case "CKCA":
			ckUser.verifyStyleID(search);
			break;
		case "TH":
			thUser.verifyStyleID(search);
			break;
		case "SPEEDO":
			speedoUser.verifyStyleID(search);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyStyleID(search);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@Then("^User should remain on home page$")
	public void user_should_remain_on_home_page() {
		LOGGER.info("Verifying search is not initiated and home page is displayed...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyCKUSHomePage();
			break;
		case "CKCA":
			ckUser.verifyCKCAHomePage();
			break;
		case "TH":
			thUser.verifyTHHomePage();
			break;
		case "SPEEDO":
			//speedoUser.verifySpeedoHomePage();
			speedoUser.verifyProhibitedCharacters();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyCKUSHomePage();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@When("^User inputs search (.*)$")
	public void user_inputs_search(String text) {
		LOGGER.info("Entering search term...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.search(text);
			break;
		case "TH":
			thUser.search(text);
			break;
		case "SPEEDO":
			speedoUser.search(text);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.search(text);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@When("^User mobile inputs search (.*)$")
	public void user_mobile_inputs_search(String text) {
		LOGGER.info("Entering search term...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.mobileSearch(text);
			break;
		case "TH":
			thUser.mobileSearch(text);
			break;
		case "SPEEDO":
			speedoUser.mobileSearch(text);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.mobileSearch(text);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User should see search suggestions related to (.*)$")
	public void user_should_see_search_suggestions_related_to(String searchTerm) {
		LOGGER.info("Verifying search suggestions...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifySearchSuggestion(searchTerm);
			break;
		case "TH":
			thUser.verifySearchSuggestion(searchTerm);
			break;
		case "SPEEDO":
			speedoUser.verifySearchSuggestion(searchTerm);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifySearchSuggestion(searchTerm);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}

	}

	@And("^User selects from search suggestions$")
	public void user_selects_from_search_uggestions() {
		LOGGER.info("Selecting from search suggestions");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyUserIsNotSignedIn();
			break;
		case "TH":
			thUser.verifyUserIsNotSignedIn();
			break;
		case "SPEEDO":
			speedoUser.verifyUserIsNotSignedIn();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.selectSearchSuggestion();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User is not signed in$")
	public void user_is_not_signed_in() {
		LOGGER.info("Verifying user is guest user...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyUserIsNotSignedIn();
			break;
		case "TH":
			thUser.verifyUserIsNotSignedIn();
			break;
		case "SPEEDO":
			speedoUser.verifyUserIsNotSignedIn();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyUserIsNotSignedIn();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@Then("^User should get prohibited characters error$")
	public void user_gets_prohibited_character_error() {
		LOGGER.info("Verifying prohibited characters message...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyProhibitedCharacters();
			break;
		case "TH":
			thUser.verifyProhibitedCharacters();
			break;
		case "SPEEDO":
			speedoUser.verifyProhibitedCharacters();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyProhibitedCharacters();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User goes to cart$")
	public void user_goes_to_cart() {
		LOGGER.info("Navigating to cart...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
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

	@And("^User goes to mobile cart$")
	public void user_goes_to_mobile_cart() {
		LOGGER.info("Navigating to cart...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
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

	@And("^User clicks on product$")
	public void user_goes_to_product_details_page() {
		LOGGER.info("Navigating to product details page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.clickFirstProduct();
			break;
		case "TH":
			thUser.clickFirstProduct();
			break;
		case "SPEEDO":
			speedoUser.clickFirstProduct();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.clickFirstProduct();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User saves product details from PDP$")
	public void user_saves_product_details_on_PDP() {
		LOGGER.info("Navigating to product details page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.savePDPProductInfo();
			break;
		case "TH":
			thUser.savePDPProductInfo();
			break;
		case "SPEEDO":
			speedoUser.savePDPProductInfo();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.savePDPProductInfo();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}

	@And("^User saves second product details from PDP$")
	public void user_saves_second_product_details_on_PDP() {
		LOGGER.info("Navigating to product details page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.savePDPSecondProductInfo();
			break;
		case "TH":
			thUser.savePDPSecondProductInfo();
			break;
		case "SPEEDO":
			speedoUser.savePDPSecondProductInfo();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.savePDPSecondProductInfo();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	


	@And("^User clicks on product on mobile$")
	public void user_goes_to_mobile_product_details_page() {
		LOGGER.info("Navigating to product details page...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.clickFirstProductOnMobile();
			break;
		case "TH":
			thUser.clickFirstProduct();
			break;
		case "SPEEDO":
			speedoUser.clickFirstProduct();
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.clickFirstProduct();
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User select (.*) from search result")
	public void user_select_department_from_search_result(String department) {
		LOGGER.info("Selecting department " + department + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.selectDepartment(department);
			break;
		case "TH":
			thUser.selectDepartment(department);
			break;
		case "SPEEDO":
			speedoUser.selectDepartment(department);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.selectDepartment(department);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User select (.*) from mobile search result")
	public void user_select_department_from_mobile_search_result(String department) {
		LOGGER.info("Selecting department " + department + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.selectDepartmentOnMobile(department);
			break;
		case "TH":
			thUser.selectDepartment(department);
			break;
		case "SPEEDO":
			speedoUser.selectDepartment(department);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.selectDepartmentOnMobile(department);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@Then("User should see option to \"(.*)\" product list")
	public void user_should_see_option_to_filter_product_list(String option) {
		LOGGER.info("Verifying option to " + option + " product list is displayed...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyOptionIsDisplayed(option);
			break;
		case "TH":
			thUser.verifyOptionIsDisplayed(option);
			break;
		case "SPEEDO":
			speedoUser.verifyOptionIsDisplayed(option);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyOptionIsDisplayed(option);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	
	@Then("User should see option on mobile to \"(.*)\" product list")
	public void user_should_see_option_on_mobile_to_filter_product_list(String option) {
		LOGGER.info("Verifying option to " + option + " product list is displayed...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyOptionIsDisplayedOnMobile(option);
			break;
		case "TH":
			thUser.verifyOptionIsDisplayedOnMobile(option);
			break;
		case "SPEEDO":
			speedoUser.verifyOptionIsDisplayedOnMobile(option);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyOptionIsDisplayedOnMobile(option);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User filter product using price range (.*)")
	public void user_filter_product_using_priceRange(String price) {
		LOGGER.info("Filtering product list using Price Range: " + price + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultUsingPriceRange(price);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingPriceRange(price);
			break;
		case "TH":
			thUser.filterSearchResultUsingPriceRange(price);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultUsingPriceRange(price);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.filterSearchResultUsingPriceRange(price);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, IZ, SB, VH");
		}
	}
	

	
	@And("User filter product on mobile using price range (.*)")
	public void user_filter_product_on_mobile_using_priceRange(String price) {
		LOGGER.info("Filtering product list using Price Range: " + price + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultOnMobileUsingPriceRange(price);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultOnMobileUsingPriceRange(price);
			break;
		case "TH":
			thUser.filterSearchResultOnMobileUsingPriceRange(price);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultOnMobileUsingPriceRange(price);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.filterSearchResultUsingPriceRange(price);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, IZ, SB, VH");
		}
	}
	
	@Then("User should see products within price range (.*)")
	public void user_should_see_product_within_priceRange(String priceRange) {
		LOGGER.info("Verifying filtered product list is within price range: " + priceRange + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		case "CKCA":
			ckUser.verifyCKCAPriceOfProductsInFilteredList(priceRange);
			break;
		case "TH":
			thUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		case "SPEEDO":
			speedoUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, IZ, SB, VH");
		}
	}

	
	@Then("User should see products in mobile within price range (.*)")
	public void user_should_see_product_in_mobile_within_priceRange(String priceRange) {
		LOGGER.info("Verifying filtered product list is within price range: " + priceRange + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifyMobilePriceOfProductsInFilteredList(priceRange);
			break;
		case "CKCA":
			ckUser.verifyCKCAMobilePriceOfProductsInFilteredList(priceRange);
			break;
		case "TH":
			thUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		case "SPEEDO":
			speedoUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyPriceOfProductsInFilteredList(priceRange);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, IZ, SB, VH");
		}
	}

	@And("User filter product using color (.*)")
	public void user_filter_product_using_color(String color) {
		LOGGER.info("Filtering product list using Color: " + color + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultUsingColor(color);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingColor(color);
			break;
		case "TH":
			thUser.filterSearchResultUsingColor(color);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultUsingColor(color);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.filterSearchResultUsingColor(color);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}


	@And("User filter product on mobile using color (.*)")
	public void user_filter_product_on_mobile_using_color(String color) {
		LOGGER.info("Filtering product list using Color: " + color + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultOnMobileUsingColor(color);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingColor(color);
			break;
		case "TH":
			thUser.filterSearchResultOnMobileUsingColor(color);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultOnMobileUsingColor(color);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.filterSearchResultOnMobileUsingColor(color);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User filter product using size (.*)")
	public void user_filter_product_using_size(String size) {
		LOGGER.info("Filtering product list using Size: " + size + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultUsingSize(size);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingSize(size);
			break;
		case "TH":
			thUser.filterSearchResultUsingSize(size);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultUsingSize(size);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.filterSearchResultUsingSize(size);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	

	
	@And("User filter mobile product using size (.*)")
	public void user_filter_mobile_product_using_size(String size) {
		LOGGER.info("Filtering product list using Size: " + size + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterMobileSearchResultUsingSize(size);
			break;
		case "CKCA":
			ckUser.filterCKCAMobileSearchResultUsingSize(size);
			break;
		case "TH":
			thUser.filterMobileSearchResultUsingSize(size);
			break;
		case "SPEEDO":
			speedoUser.filterMobileSearchResultUsingSize(size);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.filterMobileSearchResultUsingSize(size);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User filter product using category (.*)")
	public void user_filter_product_using_category(String category) {
		LOGGER.info("Filtering product list using Category: " + category + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterSearchResultUsingCategory(category);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultUsingCategory(category);
			break;
		case "SPEEDO":
			speedoUser.filterSearchResultUsingCategory(category);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.filterSearchResultUsingCategory(category);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User filter mobile product using category (.*)")
	public void user_filter_mobile_product_using_category(String category) {
		LOGGER.info("Filtering product list using Category: " + category + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.filterMobileSearchResultUsingCategory(category);
			break;
		case "CKCA":
			ckUser.filterCKCASearchResultoOnMobileUsingCategory(category);
			break;
		case "SPEEDO":
			speedoUser.filterMobileSearchResultUsingCategory(category);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.filterSearchResultUsingCategory(category);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("User should see products list filtered using (.*)")
	public void user_should_see_product_list_filtered_using(String option) {
		LOGGER.info("Verifying product list is filtered using: " + option + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyProductsListIsFiltered(option);
			break;
		case "TH":
			thUser.verifyProductsListIsFiltered(option);
			break;
		case "SPEEDO":
			speedoUser.verifyProductsListIsFiltered(option);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyProductsListIsFiltered(option);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@Then("User should see mobile products list filtered using (.*)")
	public void user_should_see_mobile_product_list_filtered_using(String option) {
		LOGGER.info("Verifying product list is filtered using: " + option + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
		case "CKCA":
			ckUser.verifyMobileProductsListIsFiltered(option);
			break;
		case "TH":
			thUser.verifyMobileProductsListIsFiltered(option);
			break;
		case "SPEEDO":
			speedoUser.verifyMobileProductsListIsFiltered(option);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifyMobileProductsListIsFiltered(option);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
	@And("User sort product using price (.*)")
	public void user_sort_product_using_price(String price) {
		LOGGER.info("Sorting product list using Price: " + price + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.sortSearchResultUsingPrice(price);
			break;
		case "CKCA":
			ckUser.sortCKCASearchResultUsingPrice(price);
			break;
		case "TH":
			thUser.sortSearchResultUsingPrice(price);
			break;
		case "SPEEDO":
			speedoUser.sortSearchResultUsingPrice(price);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.sortSearchResultUsingPrice(price);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, PB");
		}
	}
	

	
	@And("User sort product on mobile using price (.*)")
	public void user_sort_product_on_mobile_using_price(String price) {
		LOGGER.info("Sorting product list using Price: " + price + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.sortSearchResultOnMobileUsingPrice(price);
			break;
		case "CKCA":
			ckUser.sortCKCASearchResultOnMobileUsingPrice(price);
			break;
		case "TH":
			thUser.sortSearchResultOnMobileUsingPrice(price);
			break;
		case "SPEEDO":
			speedoUser.sortSearchResultOnMobileUsingPrice(price);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.sortSearchResultOnMobileUsingPrice(price);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, PB");
		}
	}

	@Then("User should see product list sorted based on (.*)")
	public void user_should_see_product_list_sorted(String priceRange) {
		LOGGER.info("Verifying sorted product list based on: " + priceRange + "...");
		String brand = Serenity.sessionVariableCalled("brand");
		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.verifySortedProductList(priceRange);
			break;
		case "CKCA":
			ckUser.verifyCKCASortedProductList(priceRange);
			break;
		case "TH":
			thUser.verifySortedProductList(priceRange);
			break;
		case "SPEEDO":
			speedoUser.verifySortedProductList(priceRange);
			break;
		case "VH":
		case "IZ":
		case "SB":
			pbUser.verifySortedProductList(priceRange);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO, VH, IZ, SB");
		}
	}
	
}
