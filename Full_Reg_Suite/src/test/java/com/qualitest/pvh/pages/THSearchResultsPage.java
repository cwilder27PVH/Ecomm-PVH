package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import com.qualitest.pvh.departments.THDepartment;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class THSearchResultsPage extends SearchResultsPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(THSearchResultsPage.class);
//ph1MM3262019: Added new xpath and method for mouseover and click
	@FindBy(id="quickView_")
	private List<WebElement> quickViews;
	
	@FindBy(xpath = "//*[@class='searchTotalCount']/*[@class='searchTerm']")
	private BaseElement searchResultTerm;
	
	@FindBy(xpath = "//*[@class='noSearchMessage']")
	protected BaseElement noSearchResultMessage;
	
	@FindBy(xpath = "//*[@id=\"products\"]/div[1]/div[1]")
	private BaseElement noSearchResults;

	@FindBy(xpath = "//h1[@class='searchTitle']/following-sibling::div/span[@class='searchCount']")
	private BaseElement searchResultTotalCount;

	@FindBy(xpath = "//*[contains(@class,'column columnLeft')]/div/div[@class = 'header']/a/span")
	protected List<WebElement> leftColumnDepartmentList;
	
	@FindBy(xpath = "//div[@class='Search_Result_Summary_Text_Wrapper clearfix']/div[@class='gridTotal']/span[@class='desktop']")
	private List<WebElement> rightColumnDepartmentTotalList;
	
	@FindBy(xpath = "//a[@class='refineBy primary whiteButton white right']")
	protected BaseElement mobileFilterAndSort;
	
	@FindBy(xpath = "//span[contains(text(),'Sort by')]")
	protected BaseElement mobileSortOption;
	
	@FindBy(xpath = "//a[@class='closeX button primary fullWidth black']")
	protected BaseElement mobileApplyButton;

	
	//added new method (MM3262019)
	@Step
	public void goToFirstProductQuickViewPage() {
		LOGGER.info("Hovering over webelement");
//		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#quickView_"));
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.xpath("//a[@class='productThumbnail requested']/img"));
		evaluateJavascript("arguments[0].scrollIntoView();", web_Element_To_Be_Hovered);
        Actions builder = new Actions(getDriver());
        builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		quickViews.get(0).click();
	}
	/**
	 * Method to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home / Sale
	 */
	@Step
	public void selectDepartmentFromLeftNavigationBar(String department) {
		for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
			String text = leftColumnDepartmentList.get(i).getText().trim();
			if(text.equalsIgnoreCase(department)) {
				LOGGER.info("Clicking department " + department + " link");
				leftColumnDepartmentList.get(i).click();
				break;
			} else {
				continue;
			}
		}
	}	
	

	public void selectDepartmentOnMobileFromLeftNavigationBar(String department) {
		LOGGER.info("Tommy Mobile doesn't have department selection available in search result, hence skipping department selection");
	}	
	
	/**
	 * Method to retrieve total search result count from each department
	 * 
	 * @return - total count of search result from each department
	 */
	@Step
	private int getTotalSearchResultUsingEachDepartmentTotal() {
		LOGGER.info("Retrieving total search result count from each department");
		int total = 0, num;
		for (int i = 0; i < rightColumnDepartmentTotalList.size(); i++) {
			String n = rightColumnDepartmentTotalList.get(i).getText();
			num = Integer.parseInt(n.split(" OF ")[1]);
			total += num;
		}
		return total;
	}

	/**
	 * Method to verify total search result from each department matches with total count in search result header
	 */
	@Step
	protected void verifyTotalCount() {
		LOGGER.info("Verifying total count");
		assertThat(getTotalSearchResultUsingEachDepartmentTotal()).as("Search result total count from each department").isEqualTo(Integer.parseInt(searchResultTotalCount.getText()));
	}
	
	/**
	 * Method to verify list of department displayed on left column of Tommy
	 * Hilfiger search result page
	 */
	@Step
	protected void verifyDepartmentListOnLeftColumn() {
		LOGGER.info("Verifying department list displayed on search result left column");
		for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
			String text = leftColumnDepartmentList.get(i).getText();
			Boolean first = false;
			if (text.equalsIgnoreCase(THDepartment.WOMEN.name) || text.equalsIgnoreCase(THDepartment.MEN.name)
					|| text.equals(THDepartment.KIDS.name) || text.equalsIgnoreCase(THDepartment.TOMMY_JEANS.name)
					|| text.equalsIgnoreCase(THDepartment.TOMMYNOW.name)
					|| text.equalsIgnoreCase(THDepartment.TOMMY_ADAPTIVE.name)
					|| text.equalsIgnoreCase(THDepartment.SALE.name)
					|| text.equalsIgnoreCase(THDepartment.UNISEX.name)) {
				first = true;
			} else {
				first = false;
			}
			SA.assertThat(first)
					.as("Department displayed on Left Column: " + text + " matches with Tommy Hilfiger department list")
					.isTrue();
		}
		SA.assertAll();
	}

	/**
	 * Method to verify no search result message for Tommy Hilfiger
	 */
	@Step
	public void verifyNoSearchResultMessage() {
		String noSearch = noSearchResultMessage.getText();
		LOGGER.info("captured text:"+noSearch);
		assertThat(noSearch).as("Verifying no search results message contains")
				.contains("we could not find any matching entries");
	}

	/**
	 * Method to verify search term in the search result header
	 * @param searchTerm - Search Term
	 */
	@Override
	protected void verifySearchTerm(String searchTerm) {
		LOGGER.info("Verifying provided search term: " + searchTerm + " in search result header");
		if(searchTerm.contains("/")) {
			searchTerm = searchTerm.replace("/", "");
		}
		assertThat(searchResultTerm.getText()).as("Search term displayed on the search result header").isEqualToIgnoringCase(searchTerm);
	}
	
	/**
	 * Method to verify search result for Tommy Hilfiger
	 */
	@Step
	public void verifySearchResult(String item) {
		verifySearchTerm(item);
		//verifyDepartmentListOnLeftColumn();
		//verifyTotalCount();
	}
	
	/**
	 * Method to verify provide option is displayed on search result page
	 * @param option - Option e.g.: filter / sort
	 */
	@Step
	public void verifyOption(String option) {
		if(option.equalsIgnoreCase("FILTER")) {
			LOGGER.info("Verifying filter options");
			//SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
			SA.assertThat(priceFilterOption.isDisplayed()).as("Price Filter Option").isTrue();
			SA.assertThat(colorFilterOption.isDisplayed()).as("Color Filter Option").isTrue();
			SA.assertThat(sizeFilterOption.isDisplayed()).as("Size Filter Option").isTrue();
		} else if(option.equalsIgnoreCase("SORT")) {
			LOGGER.info("Verifying sort option");
			SA.assertThat(sortOption.isDisplayed()).as("Sort Option").isTrue();
		}
		SA.assertAll();
	}

	@Step
	public void verifyMobileOption(String option) {
		mobileFilterAndSort.click();
		sleep(500);
		
		if(option.equalsIgnoreCase("FILTER")) {
			LOGGER.info("Verifying filter options");
			//SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
			SA.assertThat(priceFilterOption.isDisplayed()).as("Price Filter Option").isTrue();
			SA.assertThat(colorFilterOption.isDisplayed()).as("Color Filter Option").isTrue();
			SA.assertThat(sizeFilterOption.isDisplayed()).as("Size Filter Option").isTrue();
		} else if(option.equalsIgnoreCase("SORT")) {
			LOGGER.info("Verifying sort option");
			SA.assertThat(mobileSortOption.isDisplayed()).as("Sort Option").isTrue();
		}
		SA.assertAll();
	}
	
	/**
	 * Method to filter search product list based on provided price range
	 * @param price - Price Range e.g.: $0 - $25 / $25 - $50 / $300+
	 */
	@Step
	public void filterSearchResultUsingPriceRange(String price) {
		pageRefresh();
		LOGGER.info("Clicking price filter option");
		priceFilterOption.waitUntilClickable().click();
		if(price.trim().equals("$0 – $25")) {
			LOGGER.info("Selecting $0 - $25 price range option");
			find(By.xpath("//div[@id='0-25']")).click();
			
		} else if(price.trim().equals("$25 - $50")) {
			LOGGER.info("Selecting $25 - $50 price range option");
			find(By.xpath("//div[@id='25-50']")).click();
			
		} else if(price.trim().equals("$50 - $100")) {
			LOGGER.info("Selecting $50 - $100 price range option");
			find(By.xpath("//div[@id='50-100']")).click();
			
		} else if(price.trim().equals("$100 - $150")) {
			LOGGER.info("Selecting $100 - $150 price range option");
			find(By.xpath("//div[@id='100-150']")).click();
			
		} else if (price.trim().equals("$150 - $300")) {
			LOGGER.info("Selecting $150 - $300 price range option");
			find(By.xpath("//div[@id='150-300']")).click();
			
		} else if (price.trim().equals("$300+")) {
			LOGGER.info("Selecting $300+ price range option");
			find(By.xpath("//div[@id='300-plus']")).click();
			
		} else {
			LOGGER.info("Provided Price Range: " + price + " option is not available");
			
		}
	}
	

	@Step
	public void filterSearchResultUsingOnMobilePriceRange(String price) {
		mobileFilterAndSort.click();
		sleep(500);
		
		LOGGER.info("Clicking price filter option");
		priceFilterOption.waitUntilClickable().click();
		sleep(500);
		//LOGGER.info("the price is "+price.trim());
		
		if(price.trim().equals("$0 - $25")) {
			LOGGER.info("Selecting $0 - $25 price range option");
			find(By.xpath("//div[@id='0-25']")).click();
			mobileApplyButton.click();
			
		} else if(price.trim().equals("$25 - $50")) {
			LOGGER.info("Selecting $25 - $50 price range option");
			find(By.xpath("//div[@id='25-50']")).click();
			mobileApplyButton.click();
			
		} else if(price.trim().equals("$50 - $100")) {
			LOGGER.info("Selecting $50 - $100 price range option");
			find(By.xpath("//div[@id='50-100']")).click();
			mobileApplyButton.click();
			
		} else if(price.trim().equals("$100 - $150")) {
			LOGGER.info("Selecting $100 - $150 price range option");
			find(By.xpath("//div[@id='100-150']")).click();
			mobileApplyButton.click();
			
		} else if (price.trim().equals("$150 - $300")) {
			LOGGER.info("Selecting $150 - $300 price range option");
			find(By.xpath("//div[@id='150-300']")).click();
			mobileApplyButton.click();
			
		} else if (price.trim().equals("$300+")) {
			LOGGER.info("Selecting $300+ price range option");
			find(By.xpath("//div[@id='300-plus']")).click();
			mobileApplyButton.click();
			
		} else {
			LOGGER.info("Provided Price Range: " + price + " option is not available");
			
		}
	}
	
	/**
	 * Method to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / green / neutral / ivory / red / white
	 */
	@Step
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

	@Step
	public void filterSearchResultOnMobileUsingColor(String color) {

		String totalProducts = find(By.xpath("//div[@class='gridTotal']/span[@class='totalCount']")).getAttribute("data-total-count");
		Serenity.setSessionVariable("productCountBeforeFilter").to(totalProducts);
		mobileFilterAndSort.click();
		sleep(500);
		
		LOGGER.info("Clicking color filter option");
		colorFilterOption.waitUntilClickable().click();
		sleep(500);
		
		try {
			LOGGER.info("Selecting " + color + " color option");
			find(By.id(color)).click();
			mobileApplyButton.click();
		} catch (Exception e) {
			LOGGER.info("Provided Color: " + color + " option is not available");
		}
		
	}
	
	/**
	 * Method to filter search product list using provided size
	 * @param size - Size e.g.: s / m / l / xl / xxl / 4xl
	 */
	@Step
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
	

	@Step
	public void filterSearchResultOnMobileUsingSize(String size) {
		
		String totalProducts = find(By.xpath("//div[@class='gridTotal']/span[@class='totalCount']")).getAttribute("data-total-count");
		Serenity.setSessionVariable("productCountBeforeFilter").to(totalProducts);
		mobileFilterAndSort.click();
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
	 * Method to verify product price in search result is sorted based on provided price option
	 * @param priceRange - Price option e.g.: Price Low to High / Price High to Low
	 */
	@Step
	public void verifyProductListIsSorted(String priceRange) {
		
		pageRefresh();
		
		boolean result = true;
		
		if(displayedPrice.size()>0 && priceRange.equalsIgnoreCase("Price Low - High")) {
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
			
		} else if (displayedPrice.size()>0 && priceRange.equalsIgnoreCase("Price High - Low")) {
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

	public void verifyProductListOnMobileIsFilteredUsing(String option) {
		sleep(2000);
		String beforeValue = Serenity.sessionVariableCalled("productCountBeforeFilter");
		int beforeProductCount = Integer.parseInt(beforeValue);	
		LOGGER.info("Product count before filter " + beforeProductCount);
		String afterValue =find(By.xpath("//div[@class='gridTotal']/span[@class='totalCount']")).getAttribute("data-total-count");
		int afterProductCount = Integer.parseInt(afterValue);	
		LOGGER.info("Product count after filter " + afterProductCount);
		
		SA.assertThat(beforeProductCount > afterProductCount).as("Product List is filtered using " + option + " option").isTrue();
	}
	

	public void sortSearchResultOnMobileUsingPrice(String price) {
		
		mobileFilterAndSort.click();
		sleep(2000);
		
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
	
	
	//MM472019 added new method to verify the filter
			public void verifyProductListIsFilteredUsing(String option) {
				
				String filteredOption = "//div[contains(@class,'filterName filterListItem')]/span[text()='" + option.toLowerCase() + "' or text()='" + option.toUpperCase() + "']";
//				String filteredOption = "//div[contains(@class,'filterName filterListItem')]/span[translate(text(),'" + option.toLowerCase() + "','" + option.toUpperCase() +"')]";
				assertThat(find(By.xpath(filteredOption)).isVisible()).as("Product List is filtered using " + option + " option").isTrue();
				
			}
			//END
}
