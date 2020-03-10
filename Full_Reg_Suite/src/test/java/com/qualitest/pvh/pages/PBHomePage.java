package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://vh-b2cna-pq1.pvh.com/en")
public class PBHomePage extends HomePage {

	/**
	 * These are page objects
	 */
	
	@FindBy(xpath = "//div[@class='links']//img[@alt='Search']")
	protected BaseElement mobileSearchButton;
	
	@FindBy(xpath = "//body/div[@id='page']/header[@id='headerWrapper']/div[@class='headerTopWrapper mobileNav']/div[@id='searchBar']/form[@id='CatalogSearchForm']/div[@class='searchInputWrapper clearfix']/a[2]/img")
	protected BaseElement mobileSearchButton2;

	@FindBy(xpath = "//body/div[@id='page']/header[@id='headerWrapper']/div[@class='headerTopWrapper mobileNav']/div[@id='searchBar']/form[@id='CatalogSearchForm']/div[@class='searchInputWrapper clearfix']/input[1]")
	protected BaseElement mobileSearchInput;
	
	//MM09082019
	//@FindBy(xpath = "//div[@id='loginMenuWrapper_vh']//a[@title='Sign In']")
	@FindBy(xpath = "//div[@id='myAccountGuest_vh']//a[@title='Sign In']")
	protected BaseElement signInMobile;
	
	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	private BaseElement popUpClose;
	
	@FindBy(xpath = "//*[@class = 'productImage focusParent']/a")
	protected List<WebElement> productList; 
	
	@FindBy(xpath = "//*[@id='breadcrumb']/a[2]")
	private BaseElement deptBreadCrumb;
	
	List<WebElement> ck205CatList = new ArrayList<WebElement>();
	
	@FindBy(xpath = " ((//*[@id='ck_205W39NYC']//*[@class = 'dropDownColumn'])[2])/div/a")
	private List<WebElement> ck205CatList1;
	@FindBy(xpath = " ((//*[@id='ck_205W39NYC']//*[@class = 'dropDownColumn'])[3])/div/a")
	private List<WebElement> ck205CatList2;
	@FindBy(xpath = " ((//*[@id='ck_205W39NYC']//*[@class = 'dropDownColumn'])[4])/div/a")
	private List<WebElement> ck205CatList3;
	@FindBy(xpath = " ((//*[@id='ck_205W39NYC']//*[@class = 'dropDownColumn'])[5])/div/a")
	private List<WebElement> ck205CatList4;
	@FindBy( id = "breadcrumb")
	private BaseElement breadCrumb;
	
	@FindBy(xpath = "//*[@id='ck_womens_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckWomensList;
	
	@FindBy(xpath = "//*[@id='ck_mens_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckMensList;
	
	@FindBy(xpath = "//*[@id='ck_kids_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckKidsList;
	
	@FindBy(xpath = "//*[@id='ck_underwear']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckUnderwearList;
	
	@FindBy(xpath = "//*[@id='home_LSV_BRD']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckHomeList;
	
	@FindBy(xpath = "//*[@id='ck_sale-COL']//*[@class = 'dropDownLink']/a")
	private List<WebElement> ckSaleList;
	
	//@FindBy(xpath = "//*[@id=\'headerNavList\']/div")
	@FindBy(xpath = "//div[@class='headerNavItem']")
	private List<WebElement> HeaderDeptList;
	
	@FindBy(xpath = "//*[@id='contentRecommendationWidget_Logo']/div/a/img")
	private BaseElement homeImage;
	
	@FindBy(id = "ck_205W39NYC")
	private BaseElement header205;
	
	@FindBy(id = "ck_womens_BRD")
	private BaseElement headerWomen;
	
	@FindBy(id = "ck_mens_BRD")
	private BaseElement headerMen;
	
	@FindBy(id = "ck_kids_BRD")
	private BaseElement headerKids;
	
	@FindBy(id = "ck_underwear")
	private BaseElement headerUnderwear;
	
	@FindBy(id = "home_LSV_BRD")
	private BaseElement headerHome;
	
	@FindBy(id = "ck_sale-COL")
	private BaseElement headerSale;
	
	@FindBy(id = "ck_projects")
	private BaseElement headerProj;
	
	@FindBy(xpath = "//*[@id = 'signUpEmail']")
	private BaseElement signUpEmailInput;
	
	@FindBy(xpath = "//*[@id = 'ckEmailCaptureContainerSuccess']")
	private BaseElement popUpThankYou;
	
	@FindBy(xpath = "//*[@id ='navWrapper']/h3")
	private BaseElement categoryLink;
	
	@FindBy(xpath = "//*[@id = 'agree']")
	private BaseElement popUpAgreeCKCA;
	
	@FindBy(xpath = "//*[@id = 'fieldErrorMessage']")
	protected BaseElement signUpError;
	
	@FindBy(xpath = "//*[@class = 'logo']/a")
	private BaseElement homePageButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Sign up')]")
	private BaseElement signUpButton;

	@FindBy(xpath = "//a[@id='headerLogin']")
	private BaseElement signIn;

	public boolean isUserSignedIn() {
		return !signIn.exists();
	}

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
	
	/**
	 * End of page objects
	 */
	
	/**
	 * Calling Private & Protected classes
	 */	
	protected SoftAssertions SA = new SoftAssertions();
	private CurrentPage currentPage;
	private static final Logger LOGGER = LoggerFactory.getLogger(PBHomePage.class);
	
	/**
	 * End of Private & Protected classes
	 */	
	
	@Override
	/**
	 * Method to launch Van Heusen website
	 */
	
	public void navigateTo(String vhURL) {
		LOGGER.info("Navigating to Van Heusen website");
		getDriver().get(vhURL);
	}
	
	@Override
	/**
	 * Method to verify Van Heusen home page title
	 */
	
	public void verifyPageTitle() {
		LOGGER.info("Verifying Van Heusen Home Page is displayed");
		assertThat(currentPage.getTitle()).as("Van Heusen Home Page Title")
				.isEqualTo("Van Heusen | Official Site and Online Store");
		
	}
	
	/**
	 * Method to enter search term and perform search
	 * 
	 * @param item - search term
	 */
	
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
	
	public void submitSearchFor(String item) {
		enterSearchTerm(item);
		clickSearch_PB();
		sleep(3000);
	}
	
	public void submitMobileSearchFor(String item) {
		enterMobileSearchTerm(item);
		clickMobileSearch2();
		sleep(3000);
		//pageRefresh();
	}
	
	protected void clickSearch_PB() {
		
		LOGGER.info("Clicking search button");
		searchInput.sendKeys(Keys.ENTER);
		//if(searchButton.isVisible()) {
		//	searchButton.click();
		//} else {
			//pageRefresh();
			//clickOffPopUp();
			//searchButton.withTimeoutOf(timeout, TimeUnit.MILLISECONDS).waitUntilClickable().click();
		//}
	}
	
	/**
	 * Method to enter search term in search field
	 * 
	 * @param searchTerm - search term
	 */
	
	protected void clickMobileSearch() {
		
		LOGGER.info("Clicking search button");
		if(mobileSearchButton.isVisible()) {
			mobileSearchButton.click();
		} else {
			//pageRefresh();
			clickOffPopUp();
			mobileSearchButton.waitUntilClickable().click();
		}
	}
	
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
	
	
/*	public void verifyAllHeaderLinks()
	{
		for(int i = 0; i < HeaderDeptList.size(); i++)
		{	
			if(!(HeaderDeptList.get(i).getText().equalsIgnoreCase("projects")))
			{
				if(HeaderDeptList.get(i).getText().equalsIgnoreCase("kids"))
				{
					//change back to girls
					verifyHeaderLink(HeaderDeptList.get(i),"GIRLS", categoryLink);
					
				}
				else
				{
					verifyHeaderLink(HeaderDeptList.get(i), HeaderDeptList.get(i).getText().toUpperCase(), categoryLink);
				}
			}
		}
		assertALL();
	}*/
	
	public void verifyAllHeaderLinks()
	{
		System.out.println("The list of dept : "+ HeaderDeptList.size());
		for(int i = 0; i < HeaderDeptList.size(); i++)
		{
			
			HeaderDeptList.get(i).click();
			sleep(500);
			String urlText = getDriver().getCurrentUrl();
			System.out.println(urlText);
			getDriver().navigate().back();
			sleep(500);
			String[] dividedURL = urlText.split("/");
			System.out.println("The URL IS: "+dividedURL);
			System.out.println("The URL IS: "+dividedURL[dividedURL.length-1]);
			SA.assertThat(dividedURL[dividedURL.length-1].toUpperCase()).as("Navigate bar text").isEqualToIgnoringWhitespace(HeaderDeptList.get(i).getAttribute("id").toUpperCase());
		}

		SA.assertAll();
		
	}
	
	public void clickHomePageButton() {
		LOGGER.info("Clicking the homepage button");
		homePageButton.click();
	}
	
	

	public void capturePopUp() {
		LOGGER.info("Starting the look for a pop up");
		if(popUpClose.isVisible()) {
			return;
		}else {
			for(WebElement w: HeaderDeptList) {
				String name = w.findElement(By.xpath(".//a/span")).getText();
				LOGGER.info("Clicking the department: "+name);
				w.findElement(By.xpath(".//a")).click();
				if(popUpClose.isVisible()) {
					LOGGER.info("Pop up located");
					break;
				}
				getDriver().navigate().back();
				LOGGER.info("Going back to the home page");
				if(popUpClose.isVisible()) {
					LOGGER.info("Pop up located");
					break;
				}
				pageRefresh();
				if(popUpClose.isVisible()) {
					LOGGER.info("Pop up located");
					break;
				}
			}
		}
		LOGGER.info("Could not find Pop up");
	}

	
	private void enterSignUpEmail(String email) {
		LOGGER.info("Inputting the email: "+email+ " into the sign up");
		sleep(50);
		signUpEmailInput.type(email);
	}
	
	
	public void clickSignUpPopUp() {
		LOGGER.info("Clicking the Sign up button for the pop up");
		String brand = Serenity.sessionVariableCalled("brand");
		if(brand.equals("CKCA")) {
			clickPopUpAgree();
		}
		signUpButton.click();
	}
	
	
	public void enterAndSubmitSignUpPopUp(String email) {
		String i = String.valueOf(randomInt());
		enterSignUpEmail(i+"+"+email);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		clickSignUpPopUp();
	}
	
	
	private void clickPopUpAgree() {
		LOGGER.info("Click on the pop up agree on CKCA");
		popUpAgreeCKCA.click();
	}
	
	
	public void verifyCongratsPopUpSignUp() {
		boolean isTrue = popUpThankYou.isVisible();
		assertThat(isTrue).as("Congrats pop up exists").isTrue();
	}

	@Override
	
	public void verifyNoEmailUnSuccessfulPopUp() {
		assertThat(getSignUpErrorMessage()).as("Error Exists").isEqualToIgnoringCase("Please enter a valid email address.");
	}
	
	
	private String getSignUpErrorMessage() {
		if(signUpError.exists()) {
			String s = signUpError.getText();
			LOGGER.info("Field Error Message is: "+s);
			return s;
		}else {
			LOGGER.info("There is no field error message");
			return "";
		}
	}
	
	public void verifyAllHeaderCategoryLinks(String dept, String links) {
		
		if(dept.equalsIgnoreCase("205w39nyc"))
		{
			Actions action = new Actions(getDriver());
			WebElement we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
			action.moveToElement(we).build().perform();
			we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
			action.moveToElement(we).build().perform();

			ck205CatList.addAll(ck205CatList1);
			ck205CatList.addAll(ck205CatList2);
			ck205CatList.addAll(ck205CatList3);
			ck205CatList.addAll(ck205CatList4);
			verifyHeaderCategoryLinks("//*[@id='ck_205W39NYC']/a",  ck205CatList, links);
		}
		else if(dept.equalsIgnoreCase("women"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_womens_BRD']/a",  ckWomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_mens_BRD']/a",  ckMensList, links);
		}
		else if(dept.equalsIgnoreCase("kids"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_kids_BRD']/a",  ckKidsList, links);
		}
		else if(dept.equalsIgnoreCase("underwear"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_underwear']/a",  ckUnderwearList, links);	
		}
		else if(dept.equalsIgnoreCase("home"))
		{
			verifyHeaderCategoryLinks("//*[@id='home_LSV_BRD']/a",  ckHomeList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{
			verifyHeaderCategoryLinks("//*[@id='ck_sale-COL']/a",  ckSaleList, links);
		}
		
	}

	
	public void verifyAllDeptBreadCrumbLinks(String dept, String links) {
		
		if(dept.equalsIgnoreCase("205w39nyc"))
		{
			Actions action = new Actions(getDriver());
			WebElement we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
			action.moveToElement(we).build().perform();
			we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
			action.moveToElement(we).build().perform();
			
			ck205CatList.addAll(ck205CatList1);
			ck205CatList.addAll(ck205CatList2);
			ck205CatList.addAll(ck205CatList3);
			ck205CatList.addAll(ck205CatList4);
			verifyDeptBreadCrumbLinks("//*[@id='ck_205W39NYC']/a",  ck205CatList, links);
		}
		else if(dept.equalsIgnoreCase("women"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_womens_BRD']/a",  ckWomensList, links);
		}
		else if(dept.equalsIgnoreCase("men"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_mens_BRD']/a",  ckMensList, links);
		}
		else if(dept.equalsIgnoreCase("kids"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_kids_BRD']/a",  ckKidsList, links);
		}
		else if(dept.equalsIgnoreCase("underwear"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_underwear']/a",  ckUnderwearList, links);	
		}
		else if(dept.equalsIgnoreCase("home"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='home_LSV_BRD']/a",  ckHomeList, links);
		}
		else if(dept.equalsIgnoreCase("sale"))
		{
			verifyDeptBreadCrumbLinks("//*[@id='ck_sale-COL']/a",  ckSaleList, links);
		}
	}
	
	
	public void verifyAllCatPageGoToItemPage(String dept, String links) {
	
	if(dept.equalsIgnoreCase("205w39nyc"))
	{
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
		action.moveToElement(we).build().perform();
		we = getDriver().findElement(By.xpath("//*[@id='ck_205W39NYC']/a"));
		action.moveToElement(we).build().perform();
		
		ck205CatList.addAll(ck205CatList1);
		ck205CatList.addAll(ck205CatList2);
		ck205CatList.addAll(ck205CatList3);
		ck205CatList.addAll(ck205CatList4);
		verifyCatPageGoToItemPage("//*[@id='ck_205W39NYC']/a",  ck205CatList, links);
	}
	else if(dept.equalsIgnoreCase("women"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_womens_BRD']/a",  ckWomensList, links);
	}
	else if(dept.equalsIgnoreCase("men"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_mens_BRD']/a",  ckMensList, links);
	}
	else if(dept.equalsIgnoreCase("kids"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_kids_BRD']/a",  ckKidsList, links);
	}
	else if(dept.equalsIgnoreCase("underwear"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_underwear']/a",  ckUnderwearList, links);	
	}
	else if(dept.equalsIgnoreCase("home"))
	{
		verifyCatPageGoToItemPage("//*[@id='home_LSV_BRD']/a",  ckHomeList, links);
	}
	else if(dept.equalsIgnoreCase("sale"))
	{
		verifyCatPageGoToItemPage("//*[@id='ck_sale-COL']/a",  ckSaleList, links);
	}
}
	

	
	public void verifyHeaderCategoryLinks(String xPathS,  List<WebElement> list, String links) {
		// TODO Auto-generated method stub
		String[] arr = links.split(";");
		List<String> linksList = Arrays.asList(arr);
		
		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath(xPathS));
		action.moveToElement(we).build().perform();
		int counter = 0;
		String text;
		

		for(int i = 0; i < list.size(); i++)
		{
			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			try
			{
				text = list.get(i).getText().toLowerCase();
			}
			catch(StaleElementReferenceException e)
			{
				getDriver().navigate().refresh();
				ck205CatList.clear();
				we = getDriver().findElement(By.xpath(xPathS));
				action.moveToElement(we).build().perform();
				ck205CatList.addAll(ck205CatList1);
				ck205CatList.addAll(ck205CatList2);
				ck205CatList.addAll(ck205CatList3);
				ck205CatList.addAll(ck205CatList4);
				text = ck205CatList.get(i).getText().toLowerCase();
			}
			if(linksList.contains(text))
			{
				counter++;
				LOGGER.info(text);
				list.get(i).click();
						
						if(breadCrumb.isVisible())
						{
							if(text.equals("modern cotton bedding"))
							{
								assertThat(breadCrumb.getText().toLowerCase().contains("duvet covers + sheets")).isTrue();
							}
							else
							{
								assertThat(breadCrumb.getText().toLowerCase().contains(text)).isTrue();
							}
							
							//assertThat(breadCrumb.getText().toLowerCase().contains(headerName)).isTrue();
							LOGGER.info("breadcrumb : " + breadCrumb.getText().toLowerCase());
						}
	
							getDriver().navigate().back();

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				clickOffPopUp();
				if(counter >= linksList.size())
				{
					break;
				}

				we = getDriver().findElement(By.xpath(xPathS));
				action.moveToElement(we).build().perform();
			}
		}
		
		if(counter != linksList.size())
		{
			LOGGER.info("One or more links could not be found in the dept given");
			assertThat("One or more links could not be found in the dept given").isEmpty();
		}
		assertALL();
	}
	
	
	public void verifyDeptBreadCrumbLinks(String xPathS,  List<WebElement> list, String links) {
		// TODO Auto-generated method stub

		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath(xPathS));
		action.moveToElement(we).build().perform();
		
		String[] arr = links.split(";");
		List<String> linksList = Arrays.asList(arr);
		int counter = 0;
		String text;
		LOGGER.info("list size : " + list.size());
		for(int i = 0; i < list.size(); i++)
		{
			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			try
			{
				text = list.get(i).getText().toLowerCase();
			}
			catch(StaleElementReferenceException e)
			{
				getDriver().navigate().refresh();
				ck205CatList.clear();
				we = getDriver().findElement(By.xpath(xPathS));
				action.moveToElement(we).build().perform();
				ck205CatList.addAll(ck205CatList1);
				ck205CatList.addAll(ck205CatList2);
				ck205CatList.addAll(ck205CatList3);
				ck205CatList.addAll(ck205CatList4);
				text = ck205CatList.get(i).getText().toLowerCase();
			}
			
			LOGGER.info("current item : " + text);
				if(linksList.contains(text))
				{
						counter++;
						LOGGER.info(text);
						list.get(i).click();
						
						if(breadCrumb.isVisible())
						{
							String linkText = deptBreadCrumb.getText();
							LOGGER.info("bcrumb : " +  linkText);
							deptBreadCrumb.click();
							clickOffPopUp();
							String pageTitle = getDriver().getTitle().toLowerCase();
							SA.assertThat(pageTitle.contains(linkText.toLowerCase()));
							LOGGER.info("pagetitle : " + pageTitle);
							getDriver().navigate().back();
						}
							getDriver().navigate().back();
							
							if(counter >= linksList.size())
							{
								break;
							}
				}
			
			clickOffPopUp();
			

			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			
		}
		
		if(counter != linksList.size())
		{
			LOGGER.info("One or more links could not be found in the dept given");
			assertThat("One or more links could not be found in the dept given").isEmpty();
		}
		assertALL();
	}

	public void verifyCatPageGoToItemPage(String xPathS,  List<WebElement> list, String links) {
		// TODO Auto-generated method stub

		Actions action = new Actions(getDriver());
		WebElement we = getDriver().findElement(By.xpath(xPathS));
		action.moveToElement(we).build().perform();
		
		String[] arr = links.split(";");
		List<String> linksList = Arrays.asList(arr);
		int counter = 0;
		String text;
		
		for(int i = 0; i < list.size(); i++)
		{
			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			try
			{
				text = list.get(i).getText().toLowerCase();
			}
			catch(StaleElementReferenceException e)
			{
				getDriver().navigate().refresh();
				ck205CatList.clear();
				we = getDriver().findElement(By.xpath(xPathS));
				action.moveToElement(we).build().perform();
				ck205CatList.addAll(ck205CatList1);
				ck205CatList.addAll(ck205CatList2);
				ck205CatList.addAll(ck205CatList3);
				ck205CatList.addAll(ck205CatList4);
				text = ck205CatList.get(i).getText().toLowerCase();
			}
			if(linksList.contains(text))
			{
						counter++;
						LOGGER.info(text);
						list.get(i).click();
						
						if(!productList.isEmpty())
						{
							
							WebElement w = productList.get(0);
							LOGGER.info("Clicking first product: " + w.getAttribute("title") + " from search result ");
							String itemName = w.getText();
							w.click();
							
							clickOffPopUp();
							String pageTitle = getDriver().getTitle().toLowerCase();
							SA.assertThat(pageTitle.contains(itemName.toLowerCase()));
							LOGGER.info("pagetitle : " + pageTitle);
							getDriver().navigate().back();
						}
						else
						{
							LOGGER.info("No Product List To Test For : " + text);
						}
						getDriver().navigate().back();
			
			
						clickOffPopUp();
			}
			if(counter >= linksList.size())
			{
				break;
			}

			we = getDriver().findElement(By.xpath(xPathS));
			action.moveToElement(we).build().perform();
			
		}
		
		assertALL();
	}

	public void clickSignInMobile() {
		LOGGER.info("Click Sign In");
		try {
			 signInMobile.click();
		} catch (Exception e) {
			//LOGGER.info("Sign In was not visible so refreshing page");
			//pageRefresh();
			sleep(5000);
			evaluateJavascript("arguments[0].scrollIntoViewIfNeeded(true);", signInMobile);
			sleep(5000);
			signInMobile.waitUntilEnabled().click();
		}
		clickOffPopUp();
	}
}
