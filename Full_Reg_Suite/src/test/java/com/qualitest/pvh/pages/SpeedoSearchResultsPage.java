package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class SpeedoSearchResultsPage extends SearchResultsPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(SearchResultsPage.class);

	@FindBy(xpath = "//*[@id=\"products\"]/h1")
	private BaseElement noSearchResults;

	@FindBy(xpath = "//h1[@class='searchTitle']/following-sibling::div/span[@class='searchCount']")
	private BaseElement searchResultTotalCount;

	@FindBy(xpath = "//div[@class='gridTotal']/span[@class='totalCount']")
	private BaseElement resultCount;
	
	@FindBy(xpath = "//a[@class='refineBy primary whiteButton white right']")
	protected BaseElement mobileRefineBy;
	
	@FindBy(xpath = "//span[@id='navHeader_Color_Label']")
	protected BaseElement colorFilterOption;
	
	@FindBy(xpath = "//span[@id='navHeader_Size_Label']")
	protected BaseElement sizeFilterOption;
	
	@FindBy(xpath = "//span[@id='navHeader_Category_Label']")
	protected BaseElement categoryFilterOption;
	
	@FindBy(xpath = "//span[contains(text(),'Sort')]")
	protected BaseElement mobileSortOption;
	
	@FindBy(xpath = "//span[@id='navHeader_Price_Label']")
	protected BaseElement priceFilterOption;
	
	@FindBy(xpath = "//a[@class='closeX right']")
	protected BaseElement mobileApplyButton;
	
	@FindBy(xpath = "//a[@title='CLEAR ALL']")
	protected BaseElement mobileClearAllButton;

	/**
	 * Method to verify no search result message for Speedo
	 */
	public void verifyNoSearchResultMessage() {
		boolean first = false;
		if (noSearchResults.getText().contains("WE FOUND NO RESULTS")
				|| noSearchResults.getText().contains("RETURNED 0 RESULTS")) {
			first = true;
		} else {
			first = false;
		}
		assertThat(first).as("Verifying no search results message displayed").isTrue();
	}

	/**
	 * Method to verify total search result from each department matches with total
	 * count in search result header
	 */
	protected void verifyTotalCount() {
		LOGGER.info("Verifying total count");
		assertThat(resultCount.getText()).as("Search result count").isEqualTo(searchResultTotalCount.getText());
	}

	/**
	 * Method to verify search result for Speedo
	 */
	public void verifySearchResult(String item) {
		verifySearchTerm(item);
		// verifyDepartmentListOnLeftColumn();
		//verifyTotalCount();
	}

	/**
	 * Method to verify list of department displayed on left column of Speedo search
	 * result page
	 */
	protected void verifyDepartmentListOnLeftColumn() {}
	
	/**
	 * Method to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home / Sale
	 */
	@Step
	public void selectDepartmentFromLeftNavigationBar(String department) {
		LOGGER.info("Speedo doesn't have department selection available in search result, hence skipping department selection");
	}
	
	/**
	 * Method to filter search product list based on provided price range
	 * @param price - Price Range e.g.: $0 - $25 / $25 - $50 / $300+
	 */
	public void filterSearchResultUsingPriceRange(String price) {
		
		pageRefresh();
		
		LOGGER.info("Clicking price filter option");
		priceFilterOption.waitUntilClickable().click();
		
		if(price.trim().equals("$10.00 - $19.99")) {
			LOGGER.info("Selecting $10.00 - $19.99 price range option");
			find(By.xpath("//div[@id='10-00-19-99']")).click();
			
		} else if(price.trim().equals("$20.00 - $29.99")) {
			LOGGER.info("Selecting $20.00 - $29.99 price range option");
			find(By.xpath("//div[@id='20-00-29-99']")).click();
			
		} else if(price.trim().equals("$30.00 - $49.99")) {
			LOGGER.info("Selecting $30.00 - $49.99 price range option");
			find(By.xpath("//div[@id='30-00-49-99']")).click();
			
		} else {
			LOGGER.info("Provided Price Range: " + price + " option is not available");
			
		}
		
	}
	

	public void filterSearchResultOnMobileUsingPriceRange(String price) {
		
		mobileRefineBy.click();
		sleep(500);
		
		LOGGER.info("Clicking price filter option");
		priceFilterOption.waitUntilClickable().click();
		sleep(500);
		
		if(price.trim().equals("$10.00 - $19.99")) {
			LOGGER.info("Selecting $10.00 - $19.99 price range option");
			find(By.xpath("//span[contains(text(),'$10.00 – $19.99')]")).click();
			mobileApplyButton.click();
			
			
		} else if(price.trim().equals("$20.00 - $29.99")) {
			LOGGER.info("Selecting $20.00 - $29.99 price range option");
			find(By.xpath("//span[@class='text'][contains(text(),'$20.00 – $29.99')]")).click();
			mobileApplyButton.click();
			
		} else if(price.trim().equals("$30.00 - $49.99")) {
			LOGGER.info("Selecting $30.00 - $49.99 price range option");
			find(By.xpath("//span[contains(text(),'30-00-49-99']")).click();
			mobileApplyButton.click();
			
		} else {
			LOGGER.info("Provided Price Range: " + price + " option is not available");
			
		}
		
	}
	
	/**
	 * Method to verify price of filtered product list is within provided price range
	 * @param priceRange - Price Range e.g.: $10.00 - $19.99 / $30.00 - $49.99
	 */
	public void verifyFilteredProductPrice(String priceRange) {
		
		String[] price = priceRange.split("-");
		int lowerLimit = Math.round(Float.parseFloat(price[0].replace("$", "").trim()));
		int upperLimit = Math.round(Float.parseFloat(price[1].replace("$", "").trim()));
		
		if(displayedPrice.size()>0) {
			for(int i=0; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("$", "").split("-")[0]));
				LOGGER.info("Verifying displayed price of products: " + dprice + " is between " + lowerLimit + " and " + upperLimit);
				SA.assertThat((lowerLimit <= dprice) && (dprice <= upperLimit)).as("Displayed Price: " + dprice + " is within range: " + priceRange).isTrue();
			}
			SA.assertAll();
		}
		
	}
	
	/**
	 * Method to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / green / neutral / ivory / red / white
	 */
	public void filterSearchResultUsingColor(String color) {
		
		pageRefresh();
		
		LOGGER.info("Clicking color filter option");
		colorFilterOption.waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + color + " color option");
			find(By.id(color)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Color: " + color + " option is not available");
		}
		
	}
	

	public void filterSearchResultOnMobileUsingColor(String color) {

		mobileRefineBy.click();
		sleep(500);
		
		LOGGER.info("Clicking color filter option");
		colorFilterOption.waitUntilClickable().click();
		sleep(500);
		
		try {
			LOGGER.info("Selecting " + color + " color option");
			String colorXpath = "//span[contains(text(),'"+color+"')]"; 
			find(By.xpath(colorXpath)).click();
			mobileApplyButton.click();
		} catch (Exception e) {
			LOGGER.info("Provided Color: " + color + " option is not available");
		}
		
	}
	/**
	 * Method to filter search product list using provided size
	 * @param size - Size e.g.: s / m / l / xl / xxl / 4xl
	 */
	public void filterSearchResultUsingSize(String size) {
		
		pageRefresh();
		
		LOGGER.info("Clicking size filter option");
		sizeFilterOption.waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + size + " size option");
			find(By.id(size)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Size: " + size + " option is not available");
		}
		
	}
	

	public void filterSearchResultOnMobileUsingSize(String size) {

		mobileRefineBy.click();
		sleep(500);
		
		LOGGER.info("Clicking size filter option");
		sizeFilterOption.waitUntilClickable().click();
		sleep(500);
		
		try {
			LOGGER.info("Selecting " + size + " size option");
			find(By.id(size)).click();
			mobileApplyButton.click();
		} catch (Exception e) {
			LOGGER.info("Provided Size: " + size + " option is not available");
		}
		
	}
	
	/**
	 * Method to filter search product list using provided category
	 * @param category - Category e.g.: accessories / apparel / swimwear
	 */
	public void filterSearchResultUsingCategory(String category) {
		
	//	pageRefresh();
		
		LOGGER.info("Clicking category filter option");
	//	categoryFilterOption.waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + category + " category option");
			find(By.id(category)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Category: " + category + " option is not available");
		}
		
	}
	
	//MM472019 added new method to verify the filter
		public void verifyProductListIsFilteredUsing(String option) {
			
			String filteredOption = "//div[contains(@class,'filterName filterListItem')]/span[text()='" + option.toLowerCase() + "' or text()='" + option.toUpperCase() + "']";
//			String filteredOption = "//div[contains(@class,'filterName filterListItem')]/span[translate(text(),'" + option.toLowerCase() + "','" + option.toUpperCase() +"')]";
			assertThat(find(By.xpath(filteredOption)).isVisible()).as("Product List is filtered using " + option + " option").isTrue();
			
		}
		//END
	
	

	public void filterSearchResultOnMobileUsingCategory(String category) {
		


		mobileRefineBy.click();
		sleep(500);
		
		LOGGER.info("Clicking category filter option");
		categoryFilterOption.waitUntilClickable().click();
		sleep(500);
		
		try {
			LOGGER.info("Selecting " + category + " category option");
			find(By.id(category)).click();
			mobileApplyButton.click();
		} catch (Exception e) {
			LOGGER.info("Provided Category: " + category + " option is not available");
		}
		
	}
	/**
	 * Method to verify product price in search result is sorted based on provided price option
	 * @param priceRange - Price option e.g.: Price Low to High / Price High to Low
	 */
	public void verifyProductListIsSorted(String priceRange) {
		
		pageRefresh();
		
		boolean result = true;
		
		if(displayedPrice.size()>0 && priceRange.equalsIgnoreCase("Price: Low To High")) {
			int previous = Math.round(Float.parseFloat(displayedPrice.get(0).getText().replace("$", "").split("-")[0]));
			
			for(int i=1; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("$", "").split("-")[0]));
				LOGGER.info("Verifying Price: " + previous + " is less than or equal to Price: " + dprice);
				if(previous > dprice) {
					result = false;
					break;
				}
				previous = dprice;
			}
			
			assertThat(result).as("Product List is sorted in ascending order").isTrue();
			
		} else if (displayedPrice.size()>0 && priceRange.equalsIgnoreCase("Price: High To Low")) {
			int previous = Math.round(Float.parseFloat(displayedPrice.get(0).getText().replace("$", "").split("-")[0]));
			
			for(int i=1; i< displayedPrice.size(); i++) {
				int dprice = Math.round(Float.parseFloat(displayedPrice.get(i).getText().replace("$", "").split("-")[0]));
				LOGGER.info("Verifying Price: " + previous + " is greater than or equal to Price: " + dprice);
				if(previous < dprice) {
					result = false;
					break;
				}
				previous = dprice;
			}
			
			assertThat(result).as("Product List is sorted in descending order").isTrue();
			
		} 
		
	}

	public void verifyOptionOnMobile(String option) {
		mobileRefineBy.click();
		sleep(500);
		{
		if(option.equalsIgnoreCase("FILTER")) {
			LOGGER.info("Verifying filter options");
			SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
			//SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
			//SA.assertThat(priceFilterOption.isDisplayed()).as("Price Filter Option").isTrue();
			SA.assertThat(colorFilterOption.isDisplayed()).as("Color Filter Option").isTrue();
			SA.assertThat(sizeFilterOption.isDisplayed()).as("Size Filter Option").isTrue();
		} else if(option.equalsIgnoreCase("SORT")) {
			LOGGER.info("Verifying sort option");
			SA.assertThat(mobileSortOption.isDisplayed()).as("Sort Option").isTrue();
		}
		SA.assertAll();
		}
	}
		

	public void verifyProductListOnMobileIsFilteredUsing(String option) {
		sleep(2000);		
		SA.assertThat(mobileClearAllButton.isVisible()).as("Filter is applied.").isTrue();
	}

	public void sortSearchResultOnMobileUsingPrice(String price) {
		
		mobileRefineBy.click();
		sleep(500);
		
		LOGGER.info("Clicking sort option");
		mobileSortOption.waitUntilClickable().click();
		sleep(500);
		
		try {
			LOGGER.info("Selecting " + price + " sort option");
			String sortOption = "//span[contains(text(),'" + price + "')]";
			find(By.xpath(sortOption)).click();
			mobileApplyButton.click();
		} catch (Exception e) {
			LOGGER.info("Provided Sort option: " + price + " is not available");
		}
		
	}
		
}
