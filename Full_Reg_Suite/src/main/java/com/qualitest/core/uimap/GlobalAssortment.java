package com.qualitest.core.uimap;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class GlobalAssortment {

	/**
	 *  Page objects start here
	 */

	@FindBy (id ="ProdSeasonGSA")
	private WebElementFacade allSeasonsDropDown;

	@FindBy (id ="MilestoneGSA")
	private WebElementFacade allMilestonesDropDown;

	@FindBy (xpath = "//div[@id='trAssortment']//div[@class='innerTables col-lg-12 col-md-12 col-xl-6']//span[@class='search']")
	private WebElementFacade searchIcon;

	@FindBy (id ="SelectedSearchGSA")
	private WebElementFacade documentDropDown;

	@FindBy (id ="txtSearchGSA")
	private WebElementFacade documentNameText;

	@FindBy (id ="ddlCreatedByGSA")
	private WebElementFacade createByDropDown;

	@FindBy (id ="ddlSharingGSA")
	private WebElementFacade sharingTypeDropDown;

	@FindBy (xpath = "//div[@id='trAssortment']//div[@class='innerTables col-lg-12 col-md-12 col-xl-6']//div[@class='expandableTbl']//table//tbody//tr//td[@class='tableTitle']//div[@class='DivSearch']//div[@class='DivSearchTbl']//table//tbody//tr//td//input[@class='searchBtn']")
	private WebElementFacade searchDocumentButton;

	@FindBy (xpath = "//div[@id='trAssortment']//div[@class='innerTables col-lg-12 col-md-12 col-xl-6']//div[@class='expandableTbl']//table//tbody//tr//td[@class='tableTitle']//div[@class='DivSearch']//div[@class='DivSearchTbl']//table//tbody//tr//td//input[@class='showAllBtn']")
	private WebElementFacade resetSearchButton;

	@FindBy (id ="spnFilterGSA")
	private WebElementFacade globalFilterIcon;

	@FindBy(xpath = "//*[@id=\"pvhOverlayContentWrapper\"]/div[2]")
	//@FindBy(xpath = "//*[@class='pvhOverlayCloseX']")
	protected BaseElement popUpClose;

	@FindBy (xpath = "//div[@id='trAssortment']//div[@class='innerTables col-lg-12 col-md-12 col-xl-6']//span[@class='expandTable']")
	private WebElementFacade expandIcon;

	@FindBy (id ="spnZoomExpand_Collapse")
	private WebElementFacade collapseIcon;

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalAssortment.class);

	/**
	 *  Page objects ends here
	 */

	/** 
	 * Start of click functions 
	 */

	public void fliterGlobalAssortmentBySeason(String season) {


		Select seasonDropdown = new Select(allSeasonsDropDown);

		if (!season.isEmpty()) {
			seasonDropdown.selectByVisibleText(season);
		} else {
			LOGGER.info("No season selected");
		}

	}

	public void fliterGlobalAssortmentByMilestones(String milestone) {

		Select mielstoneDropdown = new Select(allSeasonsDropDown);

		if (!milestone.isEmpty()) {
			mielstoneDropdown.selectByVisibleText(milestone);
		} else {
			LOGGER.info("No milestone selected");
		}

	}


	public void clickSearchIcon() throws InterruptedException {
		clickOffPopUp();
		Thread.sleep(3000);
		searchIcon.waitUntilClickable().click();
	}

	public void clickOffPopUp() throws InterruptedException {
		/*
		 * if (popUpClose.isVisible()) { LOGGER.info("Closing pop up window"); //
		 * sleep(3000); Thread.sleep(3000); popUpClose.waitUntilClickable().click(); }
		 */		
		if(popUpClose.exists()) {
			 LOGGER.info("Closing pop up window"); 
			 // sleep(3000);
			 Thread.sleep(3000);
			 popUpClose.waitUntilClickable().click();
		 }
	}




	public void clickSearchdocumentButton() {
		searchDocumentButton.click();
	}

	public void selectDocumentSearchDrodown(String dropDownValue) {


		Select documentsearchType = new Select(documentDropDown);
		if (!dropDownValue.isEmpty()) {
			documentsearchType.selectByVisibleText(dropDownValue);
		} else {
			System.out.println("No document search type selected");
		}

	}

	public void selectDocumentCreatedByDrodown(String name) {

		Select createdByName = new Select(createByDropDown);
		if (!name.isEmpty()) {
			createdByName.selectByVisibleText(name);
		} else {
			System.out.println("No created by name is selected to filter documents");
		}

	}

	public void selectDocumentSharingDrodown(String type) {

		Select sharingType = new Select(sharingTypeDropDown);
		if (!type.isEmpty()) {
			sharingType.selectByVisibleText(type);
		} else {
			System.out.println("No document sharing type is selected to filter documents");
		}

	}

	public void clickSearchResetButton() {

		resetSearchButton.click();

	}

	public void clickSearchtButton() {

		searchDocumentButton.click();

	}

	public void clickOnDocumentFilerIcon() {

		globalFilterIcon.click();

	}

	public void expandGlobalSearch() {

		expandIcon.click();

	}

	public void collapseGlobalSearch() {

		collapseIcon.click();		
	}


	/**
	 *  End of click functions
	 */


	/**
	 *  Start of text functions 
	 */

	public void enterDocumentName(String documentName) {
		documentNameText.sendKeys(documentName);
	}

	/** 
	 * End of text functions
	 */

}
