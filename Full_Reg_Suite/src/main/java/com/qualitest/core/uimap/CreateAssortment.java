package com.qualitest.core.uimap;

import java.util.Random;

import org.openqa.selenium.support.ui.Select;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreateAssortment {
	
	/* Page objects start here
	 * 
	 */
	
	@FindBy (id ="btnNewAssortment")
	private WebElementFacade createAssortmentButton;

	@FindBy (id ="createSavePopup")
	private WebElementFacade createNewAssortmentPopUp;

	@FindBy (id ="txtDocumentName")
	private WebElementFacade assortmentName;

	@FindBy (id ="ddlFiscalYear_CreatePopup")
	private WebElementFacade fiscalYearDropDown;

	@FindBy (xpath = "//div[contains(text(),'Fall')]")
	private WebElementFacade fallSeason;

	@FindBy (xpath = "//div[contains(text(),'Spring')]")
	private WebElementFacade springSeason;

	@FindBy (xpath = "//div[@class='radioBtnProxyDiv'][contains(text(),'Summer')]")
	private WebElementFacade summerSeason;

	@FindBy (xpath = "//div[@class='radioBtnProxyDiv radioBtnProxyDivActive'] ")
	private WebElementFacade holidaySeason;

	@FindBy (id ="ddlFiscalYear_CreatePopup")
	private WebElementFacade milestoneDropDown;

	@FindBy (id ="personal")
	private WebElementFacade privateRadioButton;

	@FindBy (id ="team")
	private WebElementFacade teamRadioButton;

	@FindBy (id ="chkIsStandard")
	private WebElementFacade globalAssortmentCheckBox;

	@FindBy (id ="btnCreateDocument")
	private WebElementFacade proceedButton;
	
	@FindBy (xpath = "//div[@id='createSavePopup']//div[@class='closePopup']")
	private WebElementFacade closePopup;	
	
	/**
	 *  Page objects ends here
	 */
	
	/**
	 *  Variable declaration
	 */
	
	private enum AvaialbleSeasons {
	    Spring,
	    Summer,
	    Fall,
	    Holiday
	}
		
	/**
	 *  end of variable declaration
	 */
	
	/** 
	 * Start of click functions
	 */
	
	public void clickCreateAssortment() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		createAssortmentButton.click();
		
	}
	
	public void selectSeason(String season) {
		
		
		AvaialbleSeasons myVar = AvaialbleSeasons.valueOf(season);

		    switch(myVar) {
		      case Spring:
		    	  springSeason.click();
		        break;
		      case Summer:
		    	  summerSeason.click();
		        break;
		      case Fall:
		    	  fallSeason.click();
		      case Holiday:
		    	  holidaySeason.click();
		        break;
		    }
	}

	
	public void selectMilestones(String milestone) {
		
		
		Select msdropdown = new Select(milestoneDropDown);
		
		if (!milestone.isEmpty()) {
			msdropdown.selectByVisibleText(milestone);
		} else {
			System.out.println("No milestone selected");
		}
		
	}

	
	public void selectGlobalAssortment() {
		
		globalAssortmentCheckBox.click();
	}
		
		
	public void submitAssortment() {
		
		proceedButton.click();
	}
	
	public void closeCreateAssortmentPopUp() {
		
		closePopup.click();
	}
	

	/**
	 *  End of click functions
	 */
	

	/**
	 *  Start of text functions
	 */
	
	
	public void enterAssortmentName(String name) {
		
		Random rand = new Random();
		
		name = name+rand.nextInt(99);
		assortmentName.sendKeys(name);
		
	}
	
	public void enterFiscalYear(String year) {
		
		
		Select yeardropdown = new Select(fiscalYearDropDown);
		
		if (!year.isEmpty()) {
			yeardropdown.selectByVisibleText(year);
		} else {
			System.out.println("No year selected");
		}
		
	}
		

	/**
	 *  End of text functions
	 */
}
