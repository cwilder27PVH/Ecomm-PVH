package com.qualitest.pvh.stepdefinitions;

import com.qualitest.core.uimap.DocumentFilter;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class DocumentFilterStepDef {


	@When("^User clicks created by me checkbox$")
	public void user_clicks_created_by_me_checkbox() throws Throwable 
	{
		new DocumentFilter().clickCreatedByMeCheckBox();
	}

	@And("^User selects private checkbox$")
	public void user_selects_private_checkbox() throws Throwable
	{
		new DocumentFilter().selectPrivateCheckBox();
	    
	}

	@And("^User selects team checkbox$")
	public void user_selects_team_checkbox() throws Throwable
	{
		new DocumentFilter().selectTeamCheckBox();
	}

	@When("^User selects Spring checkbox$")
	public void user_selects_spring_checkbox() throws Throwable 
	{
		new DocumentFilter().selectSpringCheckBox();
	}

	@When("^User selects Summer checkbox$")
	public void user_selects_summer_checkbox() throws Throwable 
	{
		new DocumentFilter().selectSummerCheckBox();
	}

	@When("^User selects Fall checkbox$")
	public void user_selects_fall_checkbox() throws Throwable 
	{
		new DocumentFilter().selectFallCheckBox();
	}

	@When("^User selects holiday checkbox$")
	public void user_selects_holiday_checkbox() throws Throwable 
	{
		new DocumentFilter().selectHolidayCheckBox();
	}

	@And("^User selects CMilestore checkbox$")
	public void user_selects_CMilestore_checkbox() throws Throwable
	{
		new DocumentFilter().selectCMilestoneCheckBox();
	    
	}

	@And("^User selects ColorMilestone checkbox$")
	public void user_selects_ColorMilestone_checkbox() throws Throwable
	{
		new DocumentFilter().selectColorMilestoneCheckBox();
	}

	@And("^User selects RangeMilestone checkbox$")
	public void user_selects_RangeMilestonee_checkbox() throws Throwable
	{
		new DocumentFilter().selectRangeMilestoneCheckBox();
	}

	@And("^User selects SketchReviewMilestone checkbox$")
	public void user_selects_SketchReviewMilestone_checkbox() throws Throwable
	{
		new DocumentFilter().selectSketchReviewMilestoneCheckBox();
	}

	@And("^User selects CFTSketchReviewMilestone checkbox$")
	public void user_selects_CFTSketchReviewMilestone_checkbox() throws Throwable
	{
		new DocumentFilter().selectCFTSketchReviewMilestoneCheckBox();
	}

	@And("^User selects PhotoReviewShowbackMilestone checkbox$")
	public void user_selects_PhotoReviewShowbackMilestone_checkbox() throws Throwable
	{
		new DocumentFilter().selectPhotoReviewMilestoneCheckBox();
	}

	@And("^User selects CFTPhotoShowbackMilestone checkbox$")
	public void user_selects_CFTPhotoShowbackMilestone_checkbox() throws Throwable
	{
		new DocumentFilter().selectCFTPhotoShowbackMilestoneCheckBox();
	}

	@And("^User selects BuyReviewFinalMilestoneMilestone checkbox$")
	public void user_selects_BuyReviewFinalMilestoneMilestone_checkbox() throws Throwable
	{
		new DocumentFilter().selectBuyReviewFinalMilestoneCheckBox();
	}

	@And("^User clicks apply button$")
	public void user_clicks_apply_button() throws Throwable
	{
		new DocumentFilter().clickApplyButton();
	}

	@And("^User clicks cancel button$")
	public void user_clicks_cancel_button() throws Throwable
	{
		new DocumentFilter().clickCancelButton();
	}

	@And("^User closes document filter popus$")
	public void user_closes_document_filter_popup_button() throws Throwable
	{
		new DocumentFilter().closeDocumentFilterPopUp();
	}


	@And("^User enters Product Count Lower Rage (.*)$")
	public void user_enters_product_count_lower_range(String greaterThan) throws Throwable 
	{
			new DocumentFilter().enterProductCountLowerRage(greaterThan);
	}


	@And("^User enters Product Count Higher Rage (.*)$")
	public void user_enters_product_count_higher_range(String lessThan) throws Throwable 
	{
			new DocumentFilter().enterProductCountHigherRage(lessThan);
	}


	@And("^User enters Whiteboard Count Lower Rage (.*)$")
	public void user_enters_Whiteboard_count_lower_range(String greaterThan) throws Throwable 
	{
			new DocumentFilter().enterWhiteboardCountLowerRage(greaterThan);
	}


	@And("^User enters Whiteboard Count Higer Rage (.*)$")
	public void user_enters_Whiteboard_count_higher_range(String lessThan) throws Throwable 
	{
			new DocumentFilter().enterWhiteboardCountHigherRage(lessThan);
	}

}
