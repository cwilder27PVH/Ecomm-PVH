package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.*;
import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class HomePage extends BasePage {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomePage.class);

	protected SoftAssertions SA = new SoftAssertions();
	
	@FindBy(xpath = "//a[@id='headerLogin']")
	protected BaseElement signInMobile;
		
	@FindBy(xpath = "//a[@id='menuButton']")
	protected BaseElement menuButton;
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	protected BaseElement popUpClose;
	
	@FindBy(xpath="(//img[@alt='Close Dialog'])[2]")
	private BaseElement popUpTwoClose;
	
	@FindBy(xpath = "//a[@title='Go to the Sign In page']")
	private BaseElement signIn;

	@FindBy(xpath = "//div[@class='searchInputWrapper clearfix']/a")
	//*[@class='searchButtonWrapper']
//	@FindBy(xpath = "//*[@class='searchButtonWrapper']")
	protected BaseElement searchButton;

	@FindBy(xpath = "//a[@title='Search']/img")
	protected BaseElement searchButtonImage;

	@FindBy(xpath = "//a[@id='searchButton']")
	private BaseElement mobileSearchButton;

	@FindBy(xpath = "//body/div[@id='page']/header[@id='headerWrapper']/div[@id='searchBar']/form[@id='CatalogSearchForm']/div[@class='searchInputWrapper clearfix']/a[@title='Search']/span[1]/following-sibling::img[1]")
	private BaseElement mobileSearchButton2;
	
	@FindBy(xpath = "//*[@id = 'SimpleSearchForm_SearchTerm']")
	protected BaseElement searchInput;

	@FindBy(xpath = "//body/div[@id='page']/header[@id='headerWrapper']/div[@id='searchBar']/form[@id='CatalogSearchForm']/div[@class='searchInputWrapper clearfix']/input[1]")
	protected BaseElement mobileSearchInput;

	@FindBy(xpath = "//*[@id= 'mini_cart_link']")
	private BaseElement cart;

//	@FindBy(xpath = "//*[@class = 'autoSuggestDivNestedList clearfix']/li/a/span")
//	private List<WebElement> searchSuggestionList;

	@FindBy(xpath = "//a[@class='autoSuggestLink']")
	private List<WebElement> searchSuggestionList;

	@FindBy(xpath = "//*[@id = 'WC_MiniShopCartDisplay_link_3'][1]")
	private BaseElement editCart;

	@FindBy(xpath = "//a[text()='Store Locator']")
	private BaseElement storeLocator;

	@FindBy(xpath = "//div[@class='list_section']//ul[@class='autoSuggestDivNestedList clearfix']")
	private BaseElement typehead;

	@FindBy(xpath = "//span[contains(text(),'Did you mean')]")
	private BaseElement searchCorrection;
	
	/**
	 * Method to click store locator link from footer
	 */
	public void clickStoreLocator() {
		LOGGER.info("Clicking Store Locator link from footer");
		storeLocator.click();
	}

	/**
	 * Abstract method to launch provided url
	 * 
	 * @param url - URL
	 */
	public abstract void navigateTo(String url);

	public abstract void verifyCongratsPopUpSignUp();
	
	/**
	 * Method to close pop up
	 */
	
	public void clickOffPopUp() {
		if (popUpClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			//added sleep method here
			sleep(5000);
			popUpClose.waitUntilClickable().click();
		}
	}
	
	
	public void tryClosePopUp() {
		try {
			if(popUpClose.isEnabled()) {
				LOGGER.info("Closing pop up");
				popUpClose.click();
				sleep(1000);
			}
		}catch(Exception E) {
		}
	}
	
	/**
	 * Helper Method to verify header links
	 */
	public void verifyHeaderLink(WebElement link, String linkTxt, BaseElement categoryLink)
	{
			sleep(1500);
			clickOffPopUp();
			sleep(1500);
			link.click();
			String catTxt = categoryLink.getAttribute("className").toUpperCase();
			LOGGER.info("Checking Department Link : " + linkTxt + " Against :" + catTxt);
			LOGGER.info("value " + catTxt.contains(linkTxt));
			SA.assertThat(catTxt).contains(linkTxt);
			//assertThat(false).isTrue();
			//SA.assertAll();
			getDriver().navigate().back();
			//SA.assertThat(footerLinks.get(i).getText().isEmpty() == false);
	}
	
	public void assertALL()
	{
		SA.assertAll();
	}
	
	/**
	 * Helper method to clean up searching each list of links in the footer
	 * @param tempList
	 */
			public void CheckFooterText(List<WebElement> tempList)
			{

				SA.assertThat(tempList.isEmpty() == false);
				//Runs thru the list of elements in the footer checks if theyre text isnt empty 
				for(int i = 0;i < tempList.size(); i++)
				{
					LOGGER.info("Checking Text of Link : " + tempList.get(i).getText());
					SA.assertThat(tempList.get(i).getText().isEmpty() == false);
						
				}
			}
			
			
			
			/**
			*Helper method to clean up searching each list of links in the footer
			*/
			public void ClickFooterLinks(List<WebElement> tempList)
			{
				int temp = 0;
				//Handles unique case where speedo has a value in its link which is not a link
				if(tempList.get(0).getText().equalsIgnoreCase( "Call 1-888-4SPEEDO"))
				{
					temp++;
				}
				for(int x = temp;x < tempList.size(); x++)
				{
					
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					LOGGER.info("Checking Link : " + tempList.get(x).getText());
					clickOffPopUp();
					
					try {
						Thread.sleep(1500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					tempList.get(x).click();
					//*********Should somehow check here if link brings to proper page
					getDriver().navigate().back();
					//SA.assertThat(footerLinks.get(i).getText().isEmpty() == false);
					
				} 
				
			}
			
			/**
			*Helper method to clean up searching each list of links in the footer
			*/
	
	protected int randomInt() {
		int i = (int)(Math.random() * ((1000 - 1) + 1)) + 1;
		LOGGER.info("Getting a random number of: "+i);
		return i;
	}
			
	public void clickOffPopUpTwo() {
		if (popUpTwoClose.isVisible()) {
			LOGGER.info("Closing pop up window");
			popUpTwoClose.click();
		}
	}
	
	
	public void clickMenuButtonMobile() {
		LOGGER.info("Click Menu Button");
		clickOffPopUp();
		try {
			 menuButton.click();
		} catch (Exception e) {
			LOGGER.info("Menu Button was not visible so refreshing page");
			pageRefresh();
			menuButton.click();
		}
		clickOffPopUp();
	}
	
	
	/**
	 * Method to click signIn/Register link
	 */
	
	public void clickSignInRegister() {
		LOGGER.info("Click SignIn / Register link");
		try {
			signIn.click();
		} catch (Exception e) {
			LOGGER.info("Sign in button was not visible so refreshing page");
			pageRefresh();
			signIn.click();
		}
		clickOffPopUp();
	}	
	
	public void clickSignInMobile() {
		LOGGER.info("Click Sign In");
		try {
			 signInMobile.click();
		} catch (Exception e) {
			LOGGER.info("Sign In was not visible so refreshing page");
			pageRefresh();
			signInMobile.waitUntilClickable().click();
		}
		clickOffPopUp();
	}
	
	/**
	 * Abstract method to verify home page title
	 */
	public abstract void verifyPageTitle();

	/**
	 * Method to click on search button
	 */
	
	protected void clickSearch() {
		
		LOGGER.info("Clicking search button");
		if(searchButton.isVisible()) {
			searchButton.click();
		} else {
			LOGGER.info("Refreshing page");
			//pageRefresh();
			clickOffPopUp();
			sleep(4000);
			//searchButton.waitUntilEnabled();
			searchButton.waitUntilClickable().click();
			sleep(3000);
		}
	}
	
//	protected void clickSearchAgain() {
//		
//		LOGGER.info("Clicking search button after entering search creteria");
//			sleep(4000);
//			Actions actions = new Actions(getDriver());
//			actions.sendKeys(Keys.ENTER).build().perform();
//			sleep(3000);
//		
//	}
	
	protected void clickMobileSearch() {
		
		LOGGER.info("Clicking search button");
		if(mobileSearchButton.isVisible()) {
			mobileSearchButton.click();
		} else {
			pageRefresh();
			clickOffPopUp();
			mobileSearchButton.waitUntilClickable().click();
		}
	}
	
	protected void clickMobileSearch2() {
		
		LOGGER.info("Clicking search button");
		if(mobileSearchButton2.isVisible()) {
			mobileSearchButton2.click();
		} else {
			pageRefresh();
			clickOffPopUp();
			mobileSearchButton2.waitUntilClickable().click();
		}
	}
	
	/**
	 * Method to enter search term in search field
	 * 
	 * @param searchTerm - search term
	 */
	
	public void enterSearchTerm(String searchTerm) {
		clickSearch();
		LOGGER.info("Entering search term: " + searchTerm);
		searchInput.type(searchTerm);
	}

	
	public void enterMobileSearchTerm(String searchTerm) {
		clickMobileSearch();
		LOGGER.info("Entering search term: " + searchTerm);
		mobileSearchInput.type(searchTerm);
	}
	/**
	 * Method to click on cart from header
	 */
	
	public void clickCart() {
		LOGGER.info("Clicking cart from header");
		sleep(5000);
		if (editCart.isPresent()) {
			editCart.click();
		} else {
			cart.waitUntilClickable().click();
		}
	}
	

	/**
	 * Method to enter search term and perform search
	 * 
	 * @param item - search term
	 */
	
	public void submitSearchFor(String item) {
		enterSearchTerm(item);
		clickSearch();
	}
	
	public void submitMobileSearchFor(String item) {
		enterSearchTerm(item);
		clickSearch();
	}
	
	public void verifySearchSuggestion() {
		LOGGER.info("Verifying if Search Suggestions exist");
		assertThat(typehead.isDisplayed()).as("Search Suggestions are displayed").isTrue();
	}
	
	
	public void verifySearchCorrection() {
		LOGGER.info("Verifying if Did you mean exists");
		assertThat(searchCorrection.isDisplayed()).as("Did you mean is displayed").isTrue();
	}
	/**
	 * Method to verify user is not signed in
	 */
	public void verifyUserIsNotSignedIn() {
		assertThat(signIn.exists()).as("User is not Signned in").isTrue();
	}
	
	public boolean isUserSignedIn() {
		return !signIn.exists();
	}
	
	/**
	 * Method to verify search suggestions displayed matches provided search term
	 * @param searchTerm - Search Term
	 */
	
	public void verifySearchSuggestions(String searchTerm) {
		for (WebElement w : searchSuggestionList) {
			String s = w.getText();
			LOGGER.info("Verifying suggestion: " + s);
			SA.assertThat(s.toUpperCase()).as("Search Suggestion").contains(searchTerm.toUpperCase());
		}
		SA.assertAll();
	}
	
	public void selectFromSearchSuggestions() { 
//			int size = searchSuggestionList.size();
			LOGGER.info("Selecting Search suggestion.");
			String SearchSuggestion = searchSuggestionList.get(1).getAttribute("title");
			Serenity.setSessionVariable("selectedSearchSuggestion").to(SearchSuggestion);
			searchSuggestionList.get(1).click();
	}	
	
	protected boolean pageTitleOrLinkContainsWord(String word) {
		String url = getDriver().getCurrentUrl();
		String title = getDriver().getTitle();
		
		url = url.replaceAll("-", "");
		url = url.toLowerCase();
		title = title.toLowerCase();
		title = title.replaceAll(" ", "");
		title = title.replaceAll("'", "");
		title = title.replaceAll("-", "");
		String noSpacesWord = word.replaceAll(" ", "");
		noSpacesWord = noSpacesWord.toLowerCase();
		noSpacesWord = noSpacesWord.replaceAll("'", "");
		LOGGER.info("Getting the page URL: "+url);
		LOGGER.info("Getting the page title: "+title);
		LOGGER.info("Word with no spaces is: "+noSpacesWord);
		if(url.contains(noSpacesWord) || title.contains(noSpacesWord)) {
			LOGGER.info("Returning true");
			return true;
		}else {
			LOGGER.info("Returning false");
			return false;
		}
		
	}
	
	public abstract void verifyNoEmailUnSuccessfulPopUp();

	
	public int CheckFooterTextWithNames(List<WebElement> tempList, String Names, int q)
	{

		String[] arr = Names.split(";");
		int temp = 0;;
		SA.assertThat(tempList.isEmpty() == false);
		//Runs thru the list of elements in the footer checks if theyre text isnt empty 
		for(int i = 0;i < tempList.size(); i++)
		{
			//if(arr.length <= i+q)
			//{
				temp = i;
				LOGGER.info("Checking Text of Link : " + tempList.get(i).getText().toLowerCase());
				LOGGER.info("Against Given Link    : " + arr[i+	q]);
				SA.assertThat(tempList.get(i).getText().toLowerCase().contentEquals(arr[i+q])).isTrue();
			//}
		}
		SA.assertAll();
		return q+temp+1;
	}
	
	
	public void clickCartSimple() {
		LOGGER.info("Clicking cart from header");

			cart.click();
	} 
}