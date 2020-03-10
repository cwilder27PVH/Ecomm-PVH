package com.qualitest.pvh.stepdefinitions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.uimap.GlobalAssortment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

public class GlobalAssortmentStepDef {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalAssortmentStepDef.class);

	@When("^User filters Global Assortment By Season (.*)$$")
	public void user_filters_Global_Assortment_By_Season(String season) throws Throwable 
	{
	 	new GlobalAssortment().fliterGlobalAssortmentBySeason(season);
	}

	@When("^User filters Global Assortment By Milestones (.*)$$")
	public void user_filters_Global_Assortment_By_Milestones(String milestore) throws Throwable 
	{
	 	new GlobalAssortment().fliterGlobalAssortmentByMilestones(milestore);
	}

	@And("^User clicks on searchs icon$")
	public void user_clicks_on_search_icon() throws Throwable 
	{
		LOGGER.info("global assortment click search icon! ");
		new GlobalAssortment().clickSearchIcon();
	}

	@And("^User clicks search document button$")
	public void user_clicks_search_document_button() throws Throwable 
	{
		new GlobalAssortment().clickSearchdocumentButton();
	}

	@When("^User selects document by search dropdown(.*)$$")
	public void user_selects_document_by_search_dropdown(String dropDownValue) throws Throwable 
	{
	 	new GlobalAssortment().selectDocumentSearchDrodown(dropDownValue);
	}

	@When("^User selects document by created by dropdown(.*)$$")
	public void user_selects_document_created_by_dropdown(String name) throws Throwable 
	{
	 	new GlobalAssortment().selectDocumentCreatedByDrodown(name);
	}

	@When("^User selects document by sharing type dropdown(.*)$$")
	public void user_selects_document_by_shairng_type_dropdown(String type) throws Throwable 
	{
	 	new GlobalAssortment().selectDocumentSharingDrodown(type);
	}

	@And("^User clicks search reset button$")
	public void user_clicks_search_reset_button() throws Throwable 
	{
		new GlobalAssortment().clickSearchResetButton();
	}

	@And("^User clicks search button$")
	public void user_clicks_search_button() throws Throwable 
	{
		new GlobalAssortment().clickSearchtButton();
	}


	@And("^User clicks document filter icon$")
	public void user_clicks_document_filter_icon() throws Throwable 
	{
		new GlobalAssortment().clickOnDocumentFilerIcon();
	}


	@And("^User expands global search$")
	public void user_expands_global_search() throws Throwable 
	{
		new GlobalAssortment().expandGlobalSearch();
	}


	@And("^User collapses global search$")
	public void user_collapses_global_search() throws Throwable 
	{
		new GlobalAssortment().collapseGlobalSearch();
	}


	@And("^User enters document name(.*)$$")
	public void user_enters_document_name(String name) throws Throwable 
	{
		new GlobalAssortment().enterDocumentName(name);
	}

}
