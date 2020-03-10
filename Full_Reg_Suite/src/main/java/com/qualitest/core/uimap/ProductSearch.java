package com.qualitest.core.uimap;

import org.openqa.selenium.support.ui.Select;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductSearch {

/**
 *  Page objects start here
 */
	
	@FindBy (id ="btnProductSearch")
	private WebElementFacade productSearchButton;

	@FindBy (id ="createSavePopup")
	private WebElementFacade productSearchPopUp;

	@FindBy (xpath = "//div[@id='createSavePopup']//div[@class='closePopup']")
	private WebElementFacade productSearchPopUpCloseIcon;

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

	@FindBy (id ="btnCreateDocument")
	private WebElementFacade proceedButton;
	
	@FindBy (xpath = "//div[@id='createSavePopup']//div[@class='closePopup']")
	private WebElementFacade closePopup;
	


	/**
	 *  Page objects ends here
	 */
	
	/** 
	 * Variable declaration 
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
	 * start if click functions
	 */
	
	
	public void clickProductSearch(){
		productSearchButton.click();		
	}
	
	public void enterFiscalYear(String year) {
		
		
		Select yeardropdown = new Select(fiscalYearDropDown);
		
		if (!year.isEmpty()) {
			yeardropdown.selectByVisibleText(year);
		} else {
			System.out.println("No year selected");
		}
		
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
	
	public void submitSearch() {
		
		proceedButton.click();
	}
	
	public void closeSearchPopUp() {
		
		closePopup.click();
	}


	
	/**
	 *  End of click functions
	 */
	

}
