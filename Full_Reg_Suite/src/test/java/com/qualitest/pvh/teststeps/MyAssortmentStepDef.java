package com.qualitest.pvh.teststeps;

import com.qualitest.core.uimap.MyAssortment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class MyAssortmentStepDef {

	@When("^User filters My Assortment By Season (.*)$$")
	public void user_filters_Global_Assortment_By_Season(String season) throws Throwable 
	{
	 	new MyAssortment().fliterMyAssortmentBySeason(season);
	}

	@When("^User filters My Assortment By Milestones (.*)$$")
	public void user_filters_Global_Assortment_By_Milestones(String milestore) throws Throwable 
	{
	 	new MyAssortment().fliterMyAssortmentByMilestones(milestore);
	}

	@And("^User clicks on searchs icon$")
	public void user_clicks_on_search_icon() throws Throwable 
	{
		new MyAssortment().clickSearchIcon();
	}

	@And("^User clicks search document button$")
	public void user_clicks_search_document_button() throws Throwable 
	{
		new MyAssortment().clickSearchdocumentButton();
	}

	@When("^User selects document by search dropdown(.*)$$")
	public void user_selects_document_by_search_dropdown(String dropDownValue) throws Throwable 
	{
	 	new MyAssortment().selectDocumentSearchDrodown(dropDownValue);
	}

	@When("^User selects document by created by dropdown(.*)$$")
	public void user_selects_document_created_by_dropdown(String name) throws Throwable 
	{
	 	new MyAssortment().selectDocumentCreatedByDrodown(name);
	}

	@When("^User selects document by sharing type dropdown(.*)$$")
	public void user_selects_document_by_shairng_type_dropdown(String type) throws Throwable 
	{
	 	new MyAssortment().selectDocumentSharingDrodown(type);
	}

	@And("^User clicks search reset button$")
	public void user_clicks_search_reset_button() throws Throwable 
	{
		new MyAssortment().clickSearchResetButton();
	}

	@And("^User clicks search button$")
	public void user_clicks_search_button() throws Throwable 
	{
		new MyAssortment().clickSearchtButton();
	}


	@And("^User clicks document filter icon$")
	public void user_clicks_document_filter_icon() throws Throwable 
	{
		new MyAssortment().clickOnDocumentFilerIcon();
	}


	@And("^User expands global search$")
	public void user_expands_global_search() throws Throwable 
	{
		new MyAssortment().expandGlobalSearch();
	}


	@And("^User collapses global search$")
	public void user_collapses_global_search() throws Throwable 
	{
		new MyAssortment().collapseGlobalSearch();
	}


	@And("^User enters document name(.*)$$")
	public void user_enters_document_name(String name) throws Throwable 
	{
		new MyAssortment().enterDocumentName(name);
	}
}
