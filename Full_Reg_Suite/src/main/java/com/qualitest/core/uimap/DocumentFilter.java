package com.qualitest.core.uimap;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class DocumentFilter {
	
	/**
	 *  Page objects start here
	 */

	@FindBy (id ="chkfilterCretedby")
	private WebElementFacade createdBy;

	@FindBy (id ="rdbSharingPrivateFilter")
	private WebElementFacade privateSharing;

	@FindBy (id ="team")
	private WebElementFacade teamSharing;

	@FindBy (id ="chkFilterProdSeason0")
	private WebElementFacade springSeason;

	@FindBy (id ="chkFilterProdSeason1")
	private WebElementFacade summerSeason;

	@FindBy (id ="chkFilterProdSeason2")
	private WebElementFacade fallSeason;

	@FindBy (id ="chkFilterProdSeason3")
	private WebElementFacade holidaySeason;

	@FindBy (id ="chkFilterMilestone0")
	private WebElementFacade mileStoneC;

	@FindBy (id ="chkFilterMilestone1")
	private WebElementFacade mileStoneColorPalletes;

	@FindBy (id ="chkFilterMilestone2")
	private WebElementFacade mileStoneRangePlan;

	@FindBy (id ="chkFilterMilestone3")
	private WebElementFacade mileStonesketchReview;

	@FindBy (id ="chkFilterMilestone4")
	private WebElementFacade mileStonecftSketchReview;

	@FindBy (id ="chkFilterMilestone5")
	private WebElementFacade mileStonecftSketchReviewShowback;

	@FindBy (id ="chkFilterMilestone6")
	private WebElementFacade milestonePhotoReview;


	@FindBy (id ="chkFilterMilestone7")
	private WebElementFacade milestonCFTPhotoShowback;

	@FindBy (id ="chkFilterMilestone8")
	private WebElementFacade milestonBuyReviewFinal;

	@FindBy (id ="txtprodcountlessfilter")
	private WebElementFacade productCountGreaterThanText;

	@FindBy (id ="txtprodcountgreaterfilter")
	private WebElementFacade productCountLessThanText;

	@FindBy (id ="txtwbcountlessfilter")
	private WebElementFacade whiteboardCountGreaterThanText;

	@FindBy (id ="txtwbcountgreaterfilter")
	private WebElementFacade whiteboardCountLessThanText;

	@FindBy (id ="btnApplyFilter")
	private WebElementFacade applyButton;

	@FindBy (id ="btnCancelFilter")
	private WebElementFacade cancelButton;

	@FindBy (xpath = "//div[@class='modernPopup homeFilterDocs']//span[@class='modernPopupCloseIcon']")
	private WebElementFacade closeDocumentFilterPopup;
	

	/**
	 *  Page objects ends here
	 */
	

	/**
	 *  Start of click functions 
	 */
	
	public void clickCreatedByMeCheckBox() {
		
		createdBy.click();
		
	}
	
	public void selectPrivateCheckBox() {
		
		privateSharing.click();
		
	}
	
	public void selectTeamCheckBox() {
		
		teamSharing.click();
		
	}
	
	public void selectSpringCheckBox() {
		
		springSeason.click();
		
	}
	
	public void selectSummerCheckBox() {
		
		summerSeason.click();
		
	}
	
	public void selectFallCheckBox() {
		
		fallSeason.click();
		
	}
	
	public void selectHolidayCheckBox() {
		
		holidaySeason.click();
		
	}
	
	public void selectCMilestoneCheckBox() {
		
		mileStoneC.click();
		
	}
	
	public void selectColorMilestoneCheckBox() {
		
		mileStoneColorPalletes.click();
		
	}
	
	public void selectRangeMilestoneCheckBox() {
		
		mileStoneRangePlan.click();
		
	}
	
	public void selectSketchReviewMilestoneCheckBox() {
		
		mileStonesketchReview.click();
		
	}
	
	public void selectCFTSketchReviewMilestoneCheckBox() {
		
		mileStonecftSketchReview.click();
		
	}
	
	public void selectCFTSketchReviewShowbackMilestoneCheckBox() {
		
		mileStonecftSketchReviewShowback.click();
		
	}
	
	public void selectPhotoReviewMilestoneCheckBox() {
		
		milestonePhotoReview.click();
		
	}
	
	public void selectCFTPhotoShowbackMilestoneCheckBox() {
		
		milestonCFTPhotoShowback.click();
		
	}
	
	public void selectBuyReviewFinalMilestoneCheckBox() {
		
		milestonBuyReviewFinal.click();
		
	}
	
	public void clickApplyButton() {
	
		applyButton.click();
	
	}
	
	public void clickCancelButton() {
	
		cancelButton.click();
	
	}
	
	public void closeDocumentFilterPopUp() {
	
		closeDocumentFilterPopup.click();
	
	}
	

	/**
	 *  End of click functions
	 */
	

	/**
	 *  Start of text functions
	 */
	
	public void enterProductCountLowerRage(String GreaterThan) {
		
		productCountGreaterThanText.sendKeys(GreaterThan);
		
	}
	
	public void enterProductCountHigherRage(String LessThan) {
	
		productCountLessThanText.sendKeys(LessThan);
	
	}
	
	
	public void enterWhiteboardCountLowerRage(String GreaterThan) {
		
		whiteboardCountGreaterThanText.sendKeys(GreaterThan);
		
	}
	
	public void enterWhiteboardCountHigherRage(String LessThan) {
	
		whiteboardCountLessThanText.sendKeys(LessThan);
	
	}
	

	/**
	 *  End of text functions
	 */

}
