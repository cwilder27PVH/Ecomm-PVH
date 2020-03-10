package com.qualitest.core.uimap;

import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class MyAssortment {
	
	/**
	 *  Page objects start here
	 */
	
	@FindBy (id ="ProdSeasonMYA")
	private WebElementFacade allSeasonsDropDown;
	
	@FindBy (id ="MilestoneMYA")
	private WebElementFacade allMilestonesDropDown;
	
	@FindBy (xpath = "//div[@id='trAssortment']//div[@class='innerTables2 col-lg-12 col-md-12 col-xl-6']//span[@class='search']")
	private WebElementFacade searchIcon;
	
	@FindBy (id ="spnFilterMYA")
	private WebElementFacade documentDropDown;
	
	@FindBy (id ="txtSearchMYA")
	private WebElementFacade documentNameText;
	
	@FindBy (id ="ddlCreatedByMYA")
	private WebElementFacade createByDropDown;
	
	@FindBy (id ="ddlSharingMYA")
	private WebElementFacade sharingTypeDropDown;
	
	@FindBy (xpath = "//div[@id='trAssortment']//div[@class='innerTables2 col-lg-12 col-md-12 col-xl-6']//div[@class='expandableTbl']//table//tbody//tr//td[@class='tableTitle']//div[@class='DivSearch']//div[@class='DivSearchTbl']//table//tbody//tr//td//input[@class='searchBtn']")
	private WebElementFacade searchDocumentButton;
	
	@FindBy (xpath = "//div[@id='trAssortment']//div[@class='innerTables2 col-lg-12 col-md-12 col-xl-6']//div[@class='expandableTbl']//table//tbody//tr//td[@class='tableTitle']//div[@class='DivSearch']//div[@class='DivSearchTbl']//table//tbody//tr//td//input[@class='showAllBtn']")
	private WebElementFacade resetSearchButton;
	
	@FindBy (id ="spnFilterMYA")
	private WebElementFacade globalFilterIcon;
	
	@FindBy (xpath = "//div[@id='trAssortment']//div[@class='innerTables2 col-lg-12 col-md-12 col-xl-6']//span[@class='expandTable']")
	private WebElementFacade expandIcon;
	
	@FindBy (id ="spnZoomExpand_Collapse")
	private WebElementFacade collapseIcon;
	

	/**
	 *  Page objects ends here
	 */
	

	/**
	 *  Start of click functions
	 */

	public void fliterMyAssortmentBySeason(String season) {
		
		
		Select seasonDropdown = new Select(allSeasonsDropDown);
		
		if (!season.isEmpty()) {
			seasonDropdown.selectByVisibleText(season);
		} else {
			System.out.println("No season selected");
		}
		
	}

	public void fliterMyAssortmentByMilestones(String milestone) {
		
		Select mielstoneDropdown = new Select(allSeasonsDropDown);
	
		if (!milestone.isEmpty()) {
			mielstoneDropdown.selectByVisibleText(milestone);
		} else {
			System.out.println("No milestone selected");
		}
		
	}


	public void clickSearchIcon() {
		searchIcon.click();
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
	

	/** Start of text functions
	 * 
	 */
	
	public void enterDocumentName(String documentName) {
		documentNameText.sendKeys(documentName);
		}
	
	/**
		 *  End of text functions
	*/

}
