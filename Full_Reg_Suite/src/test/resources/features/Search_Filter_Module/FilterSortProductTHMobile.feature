@module=filterSortProductTHMobile
Feature: Filter Sort Product TH Mobile
	Description: This feature allows user to filter and sort product

@id=1 @positive @parallel @search_filter_module @brand=THMobile @mobileMobile @mobile
Scenario Outline: Verify option to filter product list is displayed on search result page
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	Then User should see option on mobile to "filter" product list
	
	Examples: 
	| brand	| keyword | department |
	| TH	| Shirt   | Men        |
		
@id=2 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Verify option to sort product list is displayed on search result page 
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	Then User should see option on mobile to "sort" product list
	
	Examples: 
	| brand	| keyword | department |
	| TH	| Shirt   | Men        |
	
@id=3 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Verify filtering product list based on Price 
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User filter product on mobile using price range <priceRange>
	Then User should see products in mobile within price range <priceRange>
	
	Examples: 
	| brand	| keyword | department | priceRange  |
#	| TH	| Shirt   | Men        | $0 - $25    |
	| TH    | Shirt   | Men        | $25 - $50   |
#	| TH    | Shirt   | Men        | $50 - $100  |
#	| TH	| Jeans   | Men        | $100 - $150 |

@id=4 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Verify filtering product list based on Color 
	Given User access <brand> website
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User filter product on mobile using color <color>
	Then User should see mobile products list filtered using <color>
	
	Examples: 
	| brand	| keyword | department | color |
	| TH	| Shirt   | Men        | black |

@id=5 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Verify filtering product list based on Size 
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User filter mobile product using size <size>
	Then User should see mobile products list filtered using <size>
	
	Examples: 
	| brand	| keyword | department | size |
	| TH	| Shirt   | Men        | xxs  |
	
@id=7 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Verify sorting product list based on Price Low to High
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User sort product on mobile using price <price>
#	Then User should see product list sorted based on <price>
	
	Examples: 
	| brand	| keyword | department | price            |
	| TH	| Shirt   | Men        | Price Low - High |
	
@id=8 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Verify sorting product list based on Price High to Low
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User sort product on mobile using price <price>
#	Then User should see product list sorted based on <price> 

	Examples: 
	| brand	| keyword | department | price            |
	| TH	| Shirt   | Men        | Price High - Low |
