@module=filterSortProductPBMobile
Feature: Filter Sort Product PB Mobile
	Description: This feature allows user to filter and sort product

@id=1 @positive @parallel @search_filter_module @brand=PBMobile @mobile
Scenario Outline: Verify option to filter product list is displayed on search result page
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	Then User should see option on mobile to "filter" product list
	
	Examples: 
	| brand	| keyword | department |
	| VH	| Shirt   | Men        |
	| IZ	| Shirt   | Men        |
#	| SB	| Shirt   | Brands     |
		
@id=2 @positive @parallel @search_filter_module @brand=PBMobile @mobile
Scenario Outline: Verify option to sort product list is displayed on search result page 
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	Then User should see option on mobile to "sort" product list
	
	
	Examples: 
	| brand	| keyword | department |
#	| VH	| Shirt   | Men        |
#	| SB	| Shirt   | Brands     |
	| IZ	| Shirt   | Men        |
	
#@id=3 @positive @parallel @search_filter_module @brand=PBMobile @mobile
#Scenario Outline: Verify filtering product list based on Price 
#	Given User access <brand> website 
#	When User searches on mobile for <keyword>
#	And User select <department> from mobile search result
#	And User filter product using price range <priceRange>
#	Then User should see products within price range <priceRange>
	
	 
#	Examples: 
#	| brand	| keyword | department | priceRange  |
#	| VH	| Shirt   | Men        | $0 - $25    |

@id=4 @positive @parallel @search_filter_module @brand=PBMobile @mobile
Scenario Outline: Verify filtering product list based on Color 
	Given User access <brand> website
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User filter product on mobile using color <color>
	Then User should see mobile products list filtered using <color>
	
	Examples: 
	| brand	| keyword | department | color |
#	| VH 	| Shirt   | Men        | black |
	| IZ 	| Shirt   | Men        | black |
#	| SB 	| Shirt   | Brands     | black |

@id=5 @positive @parallel @search_filter_module @brand=PBMobile @mobile
Scenario Outline: Verify filtering product list based on Size 
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User filter mobile product using size <size>
	Then User should see mobile products list filtered using <filteredsize>
	
	Examples: 
	| brand	| keyword | department | size      | filteredsize |
#	| VH 	| Shirt   | Men        | xl_Size   | xl           |
	| SB 	| Shirt   | Brands     | xl-t_Size | xl/ t        |
#	| IZ 	| Shirt   | Men        | xl_Size   | xl           |

#@id=6 @positive @parallel @search_filter_module @brand=PBMobile @mobile
#Scenario Outline: Verify filtering product list based on Category 
#	Given User access <brand> website 
#	When User searches on mobile for <keyword>
#	And User select <department> from mobile search result
#	And User filter product using category <category>	
#	Then User should see products list filtered using <category>
	
#	Examples: 
#	| brand	| keyword | department | category |
#	| VH	| Shirt   | Men        | CLASSIC  |
	
@id=7 @positive @parallel @search_filter_module @brand=PBMobile @mobile
Scenario Outline: Verify sorting product list based on Price Low to High
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User sort product on mobile using price <price>
	Then User should see product list sorted based on <price>
	
	Examples: 
	| brand	| keyword | department | price             |
	| VH	| Shirt   | Men        | Price Low To High |
#	| SB	| Shirt   | Men        | Price Low To High |
#	| IZ	| Shirt   | Men        | Price Low To High |
	
@id=8 @positive @parallel @search_filter_module @brand=PBMobile @mobile
Scenario Outline: Verify sorting product list based on Price High to Low
	Given User access <brand> website 
	When User searches on mobile for <keyword>
	And User select <department> from mobile search result
	And User sort product using price <price>
	Then User should see product list sorted based on <price> 
	
	Examples: 
	| brand	| keyword | department | price             |
	| VH	| Shirt   | Men        | Price High To Low |
#	| SB	| Shirt   | Brands     | Price High To Low |
#	| IZ	| Shirt   | Men        | Price High To Low |