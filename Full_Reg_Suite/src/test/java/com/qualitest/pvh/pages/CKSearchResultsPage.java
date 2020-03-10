package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import com.qualitest.pvh.departments.CKDepartment;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class CKSearchResultsPage extends SearchResultsPage {
	CKHomePage ckHP;
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	protected BaseElement popUpClose;
	
	@FindBy(xpath = "//*[@id = 'SimpleSearchForm_SearchTerm']")
	private BaseElement searchBar;
	
	@FindBy(xpath = "//a[@class='closeX button primary fullWidth black']")
	private BaseElement mobileSortDoneButton;

	private static final Logger LOGGER = LoggerFactory.getLogger(CKSearchResultsPage.class);

	/**
	 * Method to verify list of department displayed on left column of Calvin Klein
	 * US search result page
	 */
	@Step
	protected void verifyDepartmentListOnLeftColumn() {
		LOGGER.info("Verifying department list displayed on search result left column");
		for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
			String text = leftColumnDepartmentList.get(i).getText();
			Boolean first = false;
			if (text.equalsIgnoreCase(CKDepartment.NYC.name) || text.equalsIgnoreCase(CKDepartment.WOMEN.name)
					|| text.equalsIgnoreCase(CKDepartment.MEN.name) || text.equals(CKDepartment.KIDS.name)
					|| text.equalsIgnoreCase(CKDepartment.UNDERWEAR.name)
					|| text.equalsIgnoreCase(CKDepartment.HOME.name) 
					|| text.equalsIgnoreCase(CKDepartment.SALE.name))
					//|| text.equalsIgnoreCase(CKDepartment.PROJECTS.name)
					
			{
				first = true;
			} else {
				first = false;
			}
			SA.assertThat(first).as(
					"Department displayed on Left Column: " + text + " matches with Clavin Klein US department list").isTrue();
		}
		SA.assertAll();
	}


	/**
	 * Method to verify no search result message for Calvin Klein
	 */
	@Step
	public void verifyNoSearchResultMessage() {
		boolean first = false;
		if (noSearchResultMessage.getText().contains("WE FOUND NO RESULTS")
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
		verifyDepartmentListOnLeftColumn();
		//verifyTotalCount();
	}
	
	@Override
	/**
	 * Method to select first product from search result
	 */
	@Step
	public void selectFirstProduct() {
		sleep(5000);
		ckHP.clickOffPopUp();
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
		w.click();
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
	
	/**
	 * Method to close pop up window
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
		
		if(topColumnDepartmentList.size()!=0) {
			LOGGER.info( " Top Navigation ");
			for (int i = 0; i < topColumnDepartmentList.size(); i++) {
				String text = topColumnDepartmentList.get(i).getText().trim();
				//System.out.println("The text is : "+ text);
				if(text.equalsIgnoreCase(department)) {
					LOGGER.info("Clicking department " + department + " link");
					//sleep(10000);
					topColumnDepartmentList.get(i).click();
					sleep(1000);
					break;
				} else {
					continue;
				}
			}
		}else {
			LOGGER.info( " Left Navigation ");
			//System.out.println("number of depts: "+leftColumnDepartmentList.size());
			for (int i = 0; i < leftColumnDepartmentList.size(); i++) {
				String text = leftColumnDepartmentList.get(i).getText().trim();
				//System.out.println("The text is : "+ text);
				if(text.equalsIgnoreCase(department)) {
					LOGGER.info("Clicking department " + department + " link");
					//sleep(10000);
					leftColumnDepartmentList.get(i).click();
					sleep(1000);
					break;
				} else {
					continue;
				}
			}

		}	
	}

	public void selectDepartmentFromMobileTopBar(String department) {
		sleep(1000);
		clickOffPopUp();
		sleep(1000);
		System.out.println("number of depts: "+mobileTopColumnDepartmentList.size());
		for (int i = 0; i < mobileTopColumnDepartmentList.size(); i++) {
			String text = mobileTopColumnDepartmentList.get(i).getText().trim();
			System.out.println("The text is : "+ text);
			if(text.equalsIgnoreCase(department)) {
				LOGGER.info("Clicking department " + department + " link");
				mobileTopColumnDepartmentList.get(i).click();
				sleep(1000);
				clickOffPopUp();
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
			clickOffPopUp();
			sleep(1000);
			SA.assertThat(collectionFilterOption.isDisplayed()).as("Collection Filter Option").isTrue();
			SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
			//SA.assertThat(priceFilterOption.isDisplayed()).as("Price Filter Option").isTrue();
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
		if(option.equalsIgnoreCase("FILTER")) {
			LOGGER.info("Verifying filter options");
			mobileRefine.click();
			SA.assertThat(collectionFilterOption.isDisplayed()).as("Collection Filter Option").isTrue();
			//SA.assertThat(categoryFilterOption.isDisplayed()).as("Category Filter Option").isTrue();
			SA.assertThat(priceFilterOption.isDisplayed()).as("Price Filter Option").isTrue();
			SA.assertThat(colorFilterOption.isDisplayed()).as("Color Filter Option").isTrue();
			SA.assertThat(sizeFilterOption.isDisplayed()).as("Size Filter Option").isTrue();
		} else if(option.equalsIgnoreCase("SORT")) {
			LOGGER.info("Verifying sort option");
			sleep(500);
			SA.assertThat(mobileSort.isDisplayed()).as("Sort Option").isTrue();
		}
		SA.assertAll();
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


	public void filterSearchResultOnMobileUsingPriceRange(String price) {
		clickOffPopUp();
		LOGGER.info("Clicking price refine button");
		sleep(500);
		mobileRefine.click();
		sleep(500);
		//priceFilterOption.click();
		mobilePriceFilterOption.waitUntilClickable().click();
		switch(price){
		case "$0 - $25":
			LOGGER.info("Selecting $0 - $25 price range option");
			find(By.xpath("//div[@id='0-25']")).click();
			mobileSortDoneButton.click();
			break;
		case "$25 - $50":
			LOGGER.info("Selecting $25 - $50 price range option");
			find(By.xpath("//div[@id='25-50']")).click();
			mobileSortDoneButton.click();
			break;
		case "$50 - $100":
			LOGGER.info("Selecting $50 - $100 price range option");
			find(By.xpath("//div[@id='50-100']")).click();
			mobileSortDoneButton.click();
			break;
		case "$100 - $150":
			LOGGER.info("Selecting $100 - $150 price range option");
			find(By.xpath("//div[@id='100-150']")).click();
			mobileSortDoneButton.click();
			break;
		case "$150 - $300":
			LOGGER.info("Selecting $150 - $300 price range option");
			find(By.xpath("//div[@id='150-300']")).click();
			mobileSortDoneButton.click();
			break;
		case "$300+":
			LOGGER.info("Selecting $300+ price range option");
			find(By.xpath("//div[@id='300-plus']")).click();
			mobileSortDoneButton.click();
			break;
		case "CAD $0 - CAD $100":
			LOGGER.info("Selecting CAD $0 - CAD $100 price range option");
			find(By.xpath("//div[@id='0-cad-100']")).click();
			mobileSortDoneButton.click();
			break;
		case "CAD $100 - CAD $200":
			LOGGER.info("Selecting CAD $100 - CAD $200 price range option");
			find(By.xpath("//div[@id='cad-100-cad-200']")).click();
			mobileSortDoneButton.click();
			break;
		case "CAD $200 - CAD $300":
			LOGGER.info("Selecting CAD $200 - CAD $300 price range option");
			find(By.xpath("//div[@id='cad-200-cad-300']")).click();
			mobileSortDoneButton.click();
			break;
		case "CAD $300 - CAD $400":
			LOGGER.info("Selecting CAD $300 - CAD $400 price range option");
			find(By.xpath("//div[@id='cad-300-cad-400']")).click();
			mobileSortDoneButton.click();
			break;
		case "CAD $400 - CAD $500":
			LOGGER.info("Selecting CAD $400 - CAD $500 price range option");
			find(By.xpath("//div[@id='cad-400-cad-500']")).click();
			mobileSortDoneButton.click();
			break;
		default:
				LOGGER.info("Provided Price Range: " + price + " option is not available");
		}
	}
/**
	 * Method to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / green / neutral / ivory / red / white
	 */
	
	//MM472019 added new method to verify the filter
			public void verifyProductListIsFilteredUsing(String option) {
				
				//String filteredOption = "//div[contains(@class,'filterName filterListItem')]";
						//+ "/span[text()='" + option.toLowerCase() + "' or text()='" + option.toUpperCase() + "']";
	String filteredOption = "//div[contains(@class,'filterName filterListItem')]/span[translate(text(),'" + option.toLowerCase() + "','" + option.toUpperCase() +"')]";
				assertThat(find(By.xpath(filteredOption)).isVisible()).as("Product List is filtered using " + option + " option").isTrue();
				
			}
			//END
		
	
	
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
	
	public void filterSearchResultonMobileUsingColor(String color) {
		
		clickOffPopUp();
		sleep(500);
		mobileRefine.click();
		sleep(500);
		
		LOGGER.info("Clicking color filter option");
		colorFilterOption.waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + color + " color option");
			sleep(500);
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

	public void verifyMobileProductListIsFilteredUsing(String option) {
		clickOffPopUp();
		sleep(1000);
		String filterCount = mobileRefine.getAttribute("data-count");
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
		sleep(1000);
		
		LOGGER.info("Clicking size filter option");
		sizeFilterOption.waitUntilClickable().click();
		
		try {
			LOGGER.info("Selecting " + size + " size option");
			find(By.id(size)).click();
		} catch (Exception e) {
			LOGGER.info("Provided Size: " + size + " option is not available");
		}
		
	}
	

	public void filterMobileSearchResultUsingSize(String size) {

		clickOffPopUp();
		LOGGER.info("Clicking price refine button");
		sleep(500);
		mobileRefine.click();
		sleep(500);
		
		LOGGER.info("Clicking size filter option");
		Actions actions = new Actions(getDriver());
		actions.sendKeys(Keys.PAGE_DOWN).perform();
		sleep(5000);

   
		//Scroll.to(mobileSizeFilterOption);
		mobileSizeFilterOption.waitUntilClickable().click();
		
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
	
	public void filterMobileSearchResultUsingCategory(String category) {
		
		clickOffPopUp();
		sleep(500);
		mobileRefine.click();
		sleep(500);
		LOGGER.info("Clicking price filter option");
		categoryFilterOption.waitUntilClickable().click();
		sleep(500);
		
		switch(category.toUpperCase()){
		case "BIG + TALL":
			LOGGER.info("Selecting BIG + TALL category option");
			find(By.xpath("//div[@id='big-plus-tall_3074457345617376768']")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;
		case "SWEATER":
			LOGGER.info("Selecting SWEATER category option");
			find(By.xpath("//span[@class='text'][contains(text(),'Sweaters')]")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;
		case "OUTERWEAR":
			LOGGER.info("Selecting OUTERWEAR category option");
			find(By.xpath("//span[@class='text'][contains(text(),'Outerwear')]")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;
		case "TSHIRTS":
			LOGGER.info("TSHIRTS");
			find(By.xpath("//div[@id='t-shirts_130779']")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;
		case "POLOS":
			LOGGER.info("Selecting POLOS category option");
			find(By.xpath("//div[@id='polos_130778']")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;
		case "PANTS":
			LOGGER.info("Selecting PANTS category option");
			find(By.xpath("//div[@id='pants_130780']")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;
		case "CASUAL SHIRTS":
			LOGGER.info("Selecting CASUAL SHIRTS category option");
			find(By.xpath("//div[@id='casual-shirts_130781']")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;
		case "DRESS SHIRTS":
			LOGGER.info("Selecting CASUAL SHIRTS category option");
			find(By.xpath("//div[@id='dress-shirts_130775']")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;			
		case "SWIM":
			LOGGER.info("Selecting SWIM category option");
			find(By.xpath("//div[@id='swim_3074457345617331768']")).click();
			mobileSortDoneButton.waitUntilClickable().click();
			break;
		case "ACTIVEWEAR":
			LOGGER.info("Selecting ACTIVEWEAR category option");
			find(By.xpath("//div[@class='filterListItem activewear']")).click();
			mobileSortDoneButton.waitUntilClickable().click();
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
		sleep(500);
		
		LOGGER.info("Clicking sort option");
		mobileSort.waitUntilClickable().click();
		sleep(500);
		
		try {
			LOGGER.info("Selecting " + price + " sort option");
			if (price.equals("Price Low To High")) {
				LOGGER.info("clicking on selected price ");
					mobileSortList.get(2).click();
					sleep(500);
				}
					else if (price.equals("Price High To Low")) {
						LOGGER.info("clicking on selected price ");
						mobileSortList.get(3).click();
						sleep(500);					
				}
			
		} catch (Exception e) {
			LOGGER.info("Provided Sort option: " + price + " is not available");
		}
		
	}

}
