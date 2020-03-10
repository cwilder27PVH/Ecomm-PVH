@module=searchProductTHMobile
Feature: Search Product TH
	Description: This feature uses search bar to verify search results

@id=1 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search prodcuts using department 
	Given User access <brand> website 
	When User searches on mobile with keyword as <department> 
	Then User should see results for <department>
	
	Examples: Tommy Hilfiger
	| brand	 | department  |
	| TH	 | Women       |
#	| TH     | Men         |
#	| TH	 | Tommy Jeans |
#	| TH	 | Kids        |
#	| TH	 | Sale        |


@id=2 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using category 
	Given  User access <brand> website 
	When User searches on mobile with keyword as <category> 
	Then  User should see results for <category> 
	
	Examples: 
	| brand	 | category   |
#	| TH	 | All        |
#	| TH	 | Denims     |
#	| TH     | Leggings   |
#	| TH	 | Socks      |
#	| TH	 | OuterWear  |
	| TH	 | Sunglasses |
	
@id=3 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using style 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <style> 
	Then  User should see results for <style> 
	
	Examples: 
	| brand	| style     |
	| TH	| Active    |
#	| TH	| Crew Neck |
#	| TH	| V-Neck    |
#	| TH	| Henley    |


@id=4 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using occasion 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <occasion> 
	Then  User should see results for <occasion> 
	
	Examples: 
	| brand  | occasion   |
	| TH     | Casual     |
#	| TH     | Beach      |
#	| TH     | Work       |
	
@id=5 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using length 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <length> 
	Then  User should see results for <length> 

	Examples: 
	| brand	 | length     |
	| TH     | Long Sleeve|
#	| TH     | 3/4 sleeve |


@id=6 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using color 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <color> 
	Then  User should see results for <color>
	
	Examples: 
	| brand  | color      |
	| TH     | Red        |
#	| TH     | Blue       |
#	| TH     | Yellow     |
#	| TH     | Green      |
#	| TH     | Black      |
	
@id=7 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using size 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <size> 
	Then  User should see results for <size> 
	
	Examples: 
	| brand	 | size  |
	| TH     | XS    |
#	| TH     | S     |
#	| TH     | M     |
#	| TH     | L     |


@id=8 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using Style Number 
	Given  User access <brand> website
	When  User searches on mobile for <styleNumber>
	Then  User should see <styleNumber> product details
	
	Examples: 
	| brand  | styleNumber | 
	| TH     | aw04302     | 
#	| TH     | MW02972     | 
#	| TH     | UW00982     | 
#	| TH     | 7906016     |
#	| TH     | UW00983     |

@id=9 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using brand 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <brands> 
	Then  User should see results for <brands> 
	
	Examples: 
	| brand	 | brands              |
	| TH     | Hilfiger Collection |
#	| TH     | Tommy Jeans         |
#	| TH     | Tommy Hilfiger      |

@id=10 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using type 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <type> 
	Then  User should see results for <type> 

	Examples: 
	| brand  | type       |
	| TH     | Fitness    |
#	| TH     | Performance|
#	| TH     | Recreation |
	
@id=11 @negative @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using invalid keyword 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <keyword> 
	Then  User should see no search results message

	Examples: 
	| brand	| keyword |
	| TH    | 6666    |
#	| TH  	| asd1234 |


@id=12 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products using keyword with special character
	character 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <keyword> 
	Then  User should get prohibited characters error 

	Examples: 
	| brand | keyword |
	| TH 	| 123!@#  |
#	| TH	| !@#     |
#	| TH	| asd!@#  |
#	| TH	| !!??@#$ |
	 
@id=13 @negative @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products without providing search keyword 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <keyword> 
	Then  User should remain on home page 

	Examples: 
	| brand	| keyword |
	| TH    |         |
	
@id=14 @negative @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products which are currently not available 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <item> 
	Then  User should see no search results message 

	Examples: 
	| brand | item    | 
	| TH    | 4534018 | 
#	| TH    | 45BK322 |
#	| TH    | 20F6541 |
	
@id=15 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search suggestion should match the entered search term 
	Given  User access <brand> website
	When  User mobile inputs search <searchTerm>
	Then  User should see search suggestions related to <searchTerm> 
	
	Examples: 
	| brand | searchTerm | 
	| TH    | Men        | 
#	| TH    | Women      |
#	| TH    | red        |
#	| TH    | hot        |
#	| TH    | summer     |
	
#@id=16 @positive @parallel @search_filter_module @brand=THMobile @mobile
#Scenario Outline: Search products as guest user from home page
#	Given  User access <brand> website 
#	And  User is not signed in 
#	When  User searches on mobile with keyword as <product> 
#	Then  User should see results for <product> 
	
#	Examples: 
#	| brand  | product |
#	| TH     | t-shirt |
	
@id=17 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products as signed in user from home page
	Given  User access <brand> website 
	When  User navigate to mobile login page 
	And  User try to login using <email> and <password> 
	When  User searches on mobile with keyword as <product> 
	Then  User should see results for <product> 

	Examples: 
	| brand | email                   | password | product | 
	| TH    | myaccountth43@gmail.com | Passw0rd | t-shirt |

	
@id=18 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products from product details page 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <product> 
	And  User clicks on product 
	When  User searches on mobile with keyword as <product> 
	Then  User should see results for <product> 

	Examples: 
	| brand | product |
	| TH    | t-shirt |
	
@id=19 @positive @parallel @search_filter_module @brand=THMobile @mobile
Scenario Outline: Search products from cart/bag page 
	Given  User access <brand> website 
	And  User goes to cart 
	When  User searches on mobile with keyword as <product> 
	Then  User should see results for <product> 
 
	Examples: 
	| brand | product |
	| TH    | t-shirt |