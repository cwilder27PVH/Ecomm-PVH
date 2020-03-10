package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import com.qualitest.pvh.departments.PBDepartment;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class PBSearchResultsPage extends SearchResultsPage {
	
	@FindBy(xpath = "//div[@id='btn-container_3074457345625460203']//a[@class='quick-add primary-button'][contains(text(),'Quick Add')]")
	private List<WebElement> quickViews;
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	protected BaseElement popUpClose;
	
	@FindBy(xpath = "//*[@id = 'SimpleSearchForm_SearchTerm']")
	private BaseElement searchBar;
	
	@FindBy(xpath = "//span[@id='navHeader_Collection_Label']")
	protected BaseElement collectionFilterOption;
	
	@FindBy(xpath = "//*[@id='navHeader_Category_Label']")
	protected BaseElement categoryFilterOption;
	
	@FindBy(xpath = "//*[@id='navHeader_Price_Label']")
	protected BaseElement priceFilterOption;
	
	@FindBy(xpath = "//span[@id='navHeader_Color_Label']")
	protected BaseElement colorFilterOption;
	
	@FindBy(xpath = "//span[@id='navHeader_ParentSize_Label']")
	protected BaseElement sizeFilterOption;
	
	@FindBy(xpath = "//span[@class='dk_label']")
	protected BaseElement sortOption;
	
	@FindBy(xpath = "//span[contains(text(),'Sort')]")
	protected BaseElement mobileSortOption;
	
	@FindBy(xpath = "//*[@id='price_display']/span[contains(@id,'offerPrice')]")
	protected List<WebElement> displayedPrice;

	@FindBy(xpath = "//div[@class='list']/div/a/span")
	protected List<WebElement> mobileTopColumnDepartmentList;
	
	@FindBy(xpath = "//a[@class='refineBy right']")
	protected BaseElement mobileFilterAndSort;
	
	@FindBy(xpath = "//a[@class='closeX button primary fullWidth black']")
	private BaseElement mobileSortDoneButton;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CKSearchResultsPage.class);

	
	
	
	/*
	 * May move this test case
	 */
	@Step
	public void goToFirstProductQuickViewPage() {
		LOGGER.info("Hovering over webelement");
		sleep(1000);
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#quickView_"));
        Actions builder = new Actions(getDriver());
        builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		quickViews.get(0).click();
	}
	
	/**
	 * Method to verify list of department displayed on left column of Calvin Klein
	 * US search result page
	 */
	@Step
	protected void verifyDepartmentListOnLeftColumn() {
		LOGGER.info("Verifying department list displayed on search result left column");
		for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
			String text = leftColumnDepartmentList.get(i).getText();
			System.out.println(text);
			Boolean first = false;
			if (text.equalsIgnoreCase(PBDepartment.MEN.name) || text.equalsIgnoreCase(PBDepartment.WOMEN.name)
					|| text.equalsIgnoreCase(PBDepartment.BIGANDTALL.name) || text.equalsIgnoreCase(PBDepartment.SALE.name)
					|| text.equalsIgnoreCase(PBDepartment.BRANDS.name) || text.equals(PBDepartment.DRESSSHIRTS.name)
					|| text.equalsIgnoreCase(PBDepartment.SUITSANDPANTS.name) || text.equalsIgnoreCase(PBDepartment.SHOESANDACCESSORIES.name)
					|| text.equalsIgnoreCase(PBDepartment.TIES.name) || text.equalsIgnoreCase("All Search Results"))
				{
					first = true;
				} else 
				{
					first = false;
				}
			SA.assertThat(first).as(
					"Department displayed on Left Column: " + text + " matches with PB department list")
					.isTrue();
		}
		SA.assertAll();
	}


	/**
	 * Method to verify no search result message for Calvin Klein
	 */
	@Step
	public void verifyNoSearchResultMessage() {
		boolean first = false;
		if (noSearchResultMessage.getText().contains("Sorry- No results have been found")
				|| noSearchResultMessage.getText().contains("RETURNED 0 RESULTS")) {
			first = true;
		} else {
			first = false;
		}
		assertThat(first).as("Verifying no search results message displayed").isTrue();
	}

	@Override
	/**
	 * Method to verify search result for Calvin Klein
	 */
	@Step
	public void verifySearchResult(String item) {
		verifySearchTerm(item);
		//verifyDepartmentListOnLeftColumn();
		//verifyTotalCount();
	}
	
	@Override
	/**
	 * Method to select first product from search result
	 */
	@Step
	public void selectFirstProduct() {
		
		if(productList.size() == 0) {
			return;
		}
		
		if(productList.get(0).findElements(By.xpath(".//a")).size() < 1) {
			WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.cssSelector("#SimpleSearchForm_SearchTerm"));
			Actions builder = new Actions(getDriver());
			builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
			sleep(1000);
		}
		
		WebElement w = productList.get(0);
		LOGGER.info("Clicking first product: " + w.getAttribute("title") + " from search result ");
		sleep(1000);
		
		WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.className("filterHeading"));
		Actions builder = new Actions(getDriver());
		builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		Actions a = new Actions(getDriver());
    	a.sendKeys(Keys.PAGE_DOWN).build().perform();
    	w.click();
		sleep(500);
		clickOffPopUp();
	}
	
	@Override
	/**
	 * Method to select product from search result
	 */
	@Step
	public void selectProduct(int num) {
		if(productList.size() < 1 ) {
			return;
		}
		pageRefresh();
		clickOffPopUp();
		WebElement w = productList.get(num-1);
		LOGGER.info("Clicking product: " + w.getAttribute("title") + " from search result ");
		sleep(timeout);
		w.click();
	}
	
	/*
	 * May move this test case
	 */
	@Step
	public void clickOffPopUp() {
		if (popUpClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			popUpClose.click();
		}
	}
	
	/**
	 * Method to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home / Sale
	 */
	@Step
	public void selectDepartmentFromLeftNavigationBar(String department) {
		clickOffPopUp();
		for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
			String text = leftColumnDepartmentList.get(i).getText().trim();
			if(text.equalsIgnoreCase(department)) {
				LOGGER.info("Clicking department " + department + " link");
				leftColumnDepartmentList.get(i).click();
				sleep(1000);
				break;
			} else {
				continue;
			}
		}
	}
	
	@Step
	public void selectDepartmentOnMobileFromTopNavigationBar(String department) {
		clickOffPopUp();
		for (int i = 0; i < mobileTopColumnDepartmentList.size(); i++) {
			String text = mobileTopColumnDepartmentList.get(i).getText().trim();
			if(text.equalsIgnoreCase(department)) {
				LOGGER.info("Clicking department " + department + " link");
				mobileTopColumnDepartmentList.get(i).click();
				sleep(1000);
				break;
			} else {
				continue;
			}
		}
	}
	
	
	/**
	 * Method to verify provide option is displayed on search result page
	 * @param option - Option e.g.: filter / sort
	 */
	@Step
	public void verifyOption(String option) {
		if(option.equalsIgnoreCase("FILTER")) {
			LOGGER.info("Verifying filter options");
			sleep(1000);
			SA.assertThat(collectionFilterOption.isDisplayed()).as("Collection Filter Option").isTrue();
		//	SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
		//	SA.assertThat(priceFilterOption.isDisplayed()).as("Price Filter Option").isTrue();
			SA.assertThat(colorFilterOption.isDisplayed()).as("Color Filter Option").isTrue();
			SA.assertThat(sizeFilterOption.isDisplayed()).as("Size Filter Option").isTrue();
		} else if(option.equalsIgnoreCase("SORT")) {
			LOGGER.info("Verifying sort option");
			SA.assertThat(sortOption.isDisplayed()).as("Sort Option").isTrue();
		}
		SA.assertAll();
	}
	

	@Step
	public void verifyOptionOnMobile(String option) {
		clickOffPopUp();
		mobileFilterAndSort.click();
		sleep(500);
		{
		if(option.equalsIgnoreCase("FILTER")) {
			LOGGER.info("Verifying filter options");
			SA.assertThat(collectionFilterOption.isDisplayed()).as("Collection Filter Option").isTrue();
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
	

	
	/**
	 * Method to filter search product list based on provided price range
	 * @param price - Price Range e.g.: $0 - $25
	 */
	public void filterSearchResultUsingPriceRange(String price) {
		clickOffPopUp();
		pageRefresh();
		LOGGER.info("Clicking price filter option");
		priceFilterOption.waitUntilClickable().click();
		switch(price){
		case "$0 - $25":
			LOGGER.info("Selecting $0 - $25 price range option");
			find(By.id("0-25")).click();
			break;
		case "$25 - $50":
			LOGGER.info("Selecting $25 - $50 price range option");
			find(By.id("25-50")).click();
			break;
		case "$50 - $100":
			LOGGER.info("Selecting $50 - $100 price range option");
			find(By.id("50-100")).click();
			break;
		case "$100 - $150":
			LOGGER.info("Selecting $100 - $150 price range option");
			find(By.id("100-150")).click();
			break;
		case "$150 - $300":
			LOGGER.info("Selecting $150 - $300 price range option");
			find(By.id("150-300")).click();
			break;
		case "$300+":
			LOGGER.info("Selecting $300+ price range option");
			find(By.id("300-plus")).click();
			break;
		default:
				LOGGER.info("Provided Price Range: " + price + " option is not available");
		}
	}

	
	/**
	 * Method to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / green / neutral / ivory / red / white
	 */
	public void filterSearchResultUsingColor(String color) {
		
		clickOffPopUp();
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
		
		clickOffPopUp();
		sleep(500);
		mobileFilterAndSort.click();
		sleep(500);
		
		LOGGER.info("Clicking color filter option");
		colorFilterOption.waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + color + " color option");
			sleep(500);
			//String colorXpath = "//span[@class='color "+color+"']";
			String colorXpath = "//div[@id='"+color+"']";
			
			LOGGER.info("Provided Color xpath is " + colorXpath);
			find(By.xpath(colorXpath)).click();
			mobileSortDoneButton.waitUntilClickable().click();
		} catch (Exception e) {
			LOGGER.info("Provided Color: " + color + " option is not available");
		}
		
	}
	
	/**
	 * Method to verify search product list is filtered using provided option
	 * @param option - Option e.g.: black / blue / 
	 */
	public void verifyProductListIsFilteredUsing(String option) {
		clickOffPopUp();
		pageRefresh();
		sleep(2000);
		//String filteredOption = "//div[@class='filterName filterListItem']/span[text()='" + option.toLowerCase() + "']";
		String filteredOption = "//div[@class='filterName filterListItem']/span[text()[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'" + option.toLowerCase() + "')]]"; 
		LOGGER.info(filteredOption);
		assertThat(find(By.xpath(filteredOption)).isVisible()).as("Product List is filtered using " + option + " option").isTrue();
	}


	public void verifyMobileProductListIsFilteredUsing(String option) {
		
		clickOffPopUp();
		sleep(2000);
		String filterCount = mobileFilterAndSort.getAttribute("data-count");
		LOGGER.info( "Number of filters applied are: "+filterCount);
		int result = Integer.parseInt(filterCount);	
		SA.assertThat(result > 0).as("Filter is applied.").isTrue();
	}
	
	/**
	 * Method to filter search product list using provided size
	 * @param size - Size e.g.: s / m / l / xl / xxl / 4xl
	 */
	public void filterSearchResultUsingSize(String size) {
		
		clickOffPopUp();
		pageRefresh();
		sleep(2000);
		
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
		
		clickOffPopUp();
		LOGGER.info("Clicking price refine button");
		sleep(500);
		mobileFilterAndSort.click();
		sleep(500);
		
		LOGGER.info("Clicking size filter option");
		sizeFilterOption.waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + size + " size option");
			sleep(500);
			String sizeXpath = "//div[@id='"+size+"']";
			find(By.xpath(sizeXpath)).click();
			mobileSortDoneButton.waitUntilClickable().click();
		} catch (Exception e) {
			LOGGER.info("Provided Size: " + size + " option is not available");
		}
		
	}
	
	/**
	 * Method to filter search product list using provided category
	 * @param category - Collection e.g.: BIG + TALL / BODY / BODY MODAL / MODERN MODAL / CALVIN KLEIN ID
	 */
	public void filterSearchResultUsingCategory(String category) {
		
		clickOffPopUp();
		pageRefresh();
		
		LOGGER.info("Clicking collection filter option");
		collectionFilterOption.waitUntilClickable().click();
		
		switch(category.toUpperCase()){
		case "BIG + TALL":
			LOGGER.info("Selecting BIG + TALL price range option");
			find(By.xpath("//div[@id='big-plus-tall']")).click();
			break;
		case "BODY":
			LOGGER.info("Selecting BODY price range option");
			find(By.xpath("//div[@id='body']")).click();
			break;
		case "CLASSICS":
			LOGGER.info("Selecting CLASSICS price range option");
			find(By.xpath("//div[@id='classics']")).click();
			break;
		case "BODY MODAL":
			LOGGER.info("Selecting BODY MODAL price range option");
			find(By.xpath("//div[@id='body-modal']")).click();
			break;
		case "CALVIN KLEIN ID":
			LOGGER.info("Selecting CALVIN KLEIN ID price range option");
			find(By.xpath("//div[@id='calvin-klein-id']")).click();
			break;
		case "COTTON STRETCH":
			LOGGER.info("Selecting COTTON STRECTH price range option");
			find(By.xpath("//div[@id='cotton-stretch']")).click();
			break;
		case "MODERN COTTON":
			LOGGER.info("Selecting MODERN COTTON price range option");
			find(By.xpath("//div[@id='modern-cotton']")).click();
			break;
		default:
				LOGGER.info("Provided Collection: " + category + " option is not available");
		}
		
	}
	
	/**
	 * Method to sort searched product list using provide price
	 * @param price - Price e.g.: Price Low to High / Price High to Low
	 */
	public void sortSearchResultUsingPrice(String price) {
		
		clickOffPopUp();
		pageRefresh();
		
		LOGGER.info("Clicking sort option");
		sortOption.waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + price + " sort option");
			String sortOption = "//a[text()='" + price + "']";
			find(By.xpath(sortOption)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Sort option: " + price + " is not available");
		}
		
	}


	public void sortSearchResultOnMobileUsingPrice(String price) {
		
		clickOffPopUp();
		LOGGER.info("Clicking price refine button");
		sleep(5000);
		mobileFilterAndSort.click();
		sleep(5000);
		mobileSortOption.click();
		LOGGER.info("CLICKING REFINE");
		sleep(5000);
		
		try {
			LOGGER.info("Selecting " + price + " sort option");
			String sortOption = "//span[contains(text(),'" + price + "')]";
			find(By.xpath(sortOption)).click();
			mobileSortDoneButton.waitUntilClickable().click();
		} catch (Exception e) {
			LOGGER.info("Provided Sort option: " + price + " is not available");
		}
		
	}

}
