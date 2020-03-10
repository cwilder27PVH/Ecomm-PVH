@module=filterSortProductCK
Feature: Filter Sort Product CK
	Description: This feature allows user to filter and sort product
	
Background:
	Given User navigates to Calvin Klein US Webstore
	And User logs out if already logged in

@id=1 @positive @parallel @search_filter_module @brand=CK
Scenario Outline: Verify option to filter product list is displayed on search result page
#	Given User access <brand> website 
	When User searches with keyword as <keyword>
	And User select <department> from search result
	Then User should see option to "filter" product list
	 
	Examples: 
	| brand	| keyword | department |
	| CKUS	| Shirt   | Men        |
#	| CKCA	| Shirt   | Men        |
		
@id=2 @positive @parallel @search_filter_module @brand=CK
Scenario Outline: Verify option to sort product list is displayed on search result page 
#	Given User access <brand> website 
	When User searches with keyword as <keyword>
	And User select <department> from search result
	Then User should see option to "sort" product list
	 
	Examples: 
	| brand	| keyword | department |
	| CKUS	| Shirt   | Men        |
#	| CKCA	| Shirt   | Men        |
	
@id=3 @positive @parallel @search_filter_module @brand=CK
Scenario Outline: Verify filtering product list based on Price 
#	Given User access <brand> website 
	When User searches with keyword as <keyword>
	And User select <department> from search result
	And User filter product using price range <priceRange>
	Then User should see products within price range <priceRange>
	 
	Examples: 
	| brand	| keyword | department | priceRange  |
	| CKUS	| Shirt   | Men        | $0 - $25    |
#	| CKCA	| Shirt   | Men        | CAD $0 - CAD $100   | 


@id=4 @positive @parallel @search_filter_module @brand=CK
Scenario Outline: Verify filtering product list based on Color 
#	Given User access <brand> website
	When User searches with keyword as <keyword>
	And User select <department> from search result
	And User filter product using color <color>
	Then User should see products list filtered using <color>
	
	Examples: 
	| brand	| keyword | department | color |
	| CKUS	| Shirt   | Men        | black |
#	| CKCA	| Shirt   | Men        | black |

@id=5 @positive @parallel @search_filter_module @brand=CK
Scenario Outline: Verify filtering product list based on Size 
#	Given User access <brand> website 
	When User searches with keyword as <keyword>
	And User select <department> from search result
	And User filter product using size <size>
	Then User should see products list filtered using <size>
	
	Examples: 
	| brand	| keyword | department | size |
	| CKUS	| Shirt   | Men        | 4xl  |
#	| CKCA	| Shirt   | Men        | 4xl  |

@id=6 @positive @parallel @search_filter_module @brand=CK
Scenario Outline: Verify filtering product list based on Category 
#	Given User access <brand> website 
	When User searches with keyword as <keyword>
	And User select <department> from search result
	And User filter product using category <collections>	
	Then User should see products list filtered using <collections>
	
	Examples: 
	| brand	| keyword | department | collections |
	| CKUS	| Shirt   | Men        | CLASSICS |
#	| CKCA	| Shirt   | Men        | BODY     |
	
@id=7 @positive @parallel @search_filter_module @brand=CK
Scenario Outline: Verify sorting product list based on Price Low to High
#	Given User access <brand> website 
	When User searches with keyword as <keyword>
	And User select <department> from search result
	And User sort product using price <price>
#	Then User should see product list sorted based on <price>
	
	Examples: 
	| brand	| keyword | department | price             |
	| CKUS	| Shirt   | Men        | Price Low To High |
#	| CKCA	| Shirt   | Men        | Price Low To High |
	
@id=8 @positive @parallel @search_filter_module @brand=CK
Scenario Outline: Verify sorting product list based on Price High to Low
#	Given User access <brand> website 
	When User searches with keyword as <keyword>
	And User select <department> from search result
	And User sort product using price <price>
#	Then User should see product list sorted based on <price> 
	
	Examples: 
	| brand	| keyword | department | price             |
	| CKUS	| Shirt   | Men        | Price High To Low |
#	| CKCA	| Shirt   | Men        | Price High To Low |
