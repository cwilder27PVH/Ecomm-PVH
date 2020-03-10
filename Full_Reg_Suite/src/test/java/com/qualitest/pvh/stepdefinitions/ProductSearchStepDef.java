package com.qualitest.pvh.stepdefinitions;

import com.qualitest.core.uimap.ProductSearch;

import cucumber.api.java.en.When;

public class ProductSearchStepDef {

	@When("^User clicks product search$")
	public void user_clicks_product_serach() throws Throwable 
	{
			new ProductSearch().clickProductSearch();
	}
	
	@When("^User select fiscal year (.*)$$")
	public void user_selects_fiscal_year(String year) throws Throwable 
	{
	 	new ProductSearch().enterFiscalYear(year);
	}
	
	@When("^User selects season (.*)$$")
	public void user_selects_season(String season) throws Throwable 
	{
	 	new ProductSearch().selectSeason(season);
	}

	@When("^User submits search$")
	public void user_submits_serach() throws Throwable 
	{
			new ProductSearch().submitSearch();
	}

	@When("^User closes search popup$")
	public void user_closes_serach_popua() throws Throwable 
	{
			new ProductSearch().closeSearchPopUp();
	}

}
