@module=searchProductPB
Feature: Search Product PB
	Description: This feature uses search bar to verify search results
	
Background:
	Given User navigates to Heritage Brands Webstore
	And User logs out if already logged in

@id=1 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products using department 
#	Given User access <brand> website 
	When User searches with keyword as <department> 
	Then User should see results for <department>
	
	Examples: 
	| brand	 | department |
	| VH 	 | Men        |
	
@id=2 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products using category 
#	Given  User access <brand> website 
	When  User searches with keyword as <category> 
	Then  User should see results for <category> 
	
	Examples: 
	| brand	 | category     |
	| VH	 | Dress Shirts |
	
@id=3 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products using words with spaces 
#	Given  User access <brand> website 
	When  User searches with keyword as <usingspaces> 
	Then  User should see results for <usingspaces> 
	
	Examples: 
	| brand	 | usingspaces  |
	| VH	 | black shirt  |
	

@id=4 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products using color 
#	Given  User access <brand> website 
	When  User searches with keyword as <color> 
	Then  User should see results for <color>
	
	Examples: 
	| brand  | color      |
	| VH     | Red        |
	
@id=5 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Verify if Search suggestions are displayed 
#	Given  User access <brand> website
	When  User inputs search <searchTerm>
	Then  User verifies for search suggestion
		
	Examples: 
	| brand	 | searchTerm  |	
	| VH     | black       |
	
@id=6 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search suggestion should match the entered search term 
#	Given  User access <brand> website
	When  User inputs search <searchTerm>
	Then  User should see search suggestions related to <searchTerm> 
	
	Examples: 
	| brand | searchTerm | 
	| VH    | Men        |
	 
@id=7 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Select from search suggestions
#	Given  User access <brand> website
	When  User inputs search <searchTerm>
	And User selects from search suggestions
	Then User should see search results for selected search suggestion <searchTerm> 
	
	Examples: 
	| brand | searchTerm | 
	| VH    | Black      |
		
@id=8 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Verify if search criteria correction is displayed 
#	Given  User access <brand> website
	When  User searches with keyword as <search>
	Then  User verifies for search correction
	
	Examples: 
	| brand  | search    | 
	| VH     | patn      | 

	
@id=9 @negative @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products using invalid keyword 
#	Given  User access <brand> website 
	When  User searches for <keyword> 
	Then  User should see no search results message
	
	Examples: 
	| brand	| keyword |
	| VH    | 6666    |
	
@id=10 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products using valid special characters 
#	Given  User access <brand> website 
	When  User searches with keyword as <specialchar> 
	Then  User should see results for <specialchar> 
	
	Examples: 
	| brand	 | specialchar |
	| VH     | Big & Tall  |

@id=11 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products using keyword with invalid special character
	character 
#	Given  User access <brand> website 
	When  User searches with keyword as <keyword> 
	Then  User should get prohibited characters error 
	
	Examples: 
	| brand | keyword | 
	| VH	| 123!@#  |
	
@id=12 @negative @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products without providing search keyword 
#	Given  User access <brand> website 
	When  User searches with keyword as <keyword> 
	Then  User should remain on home page 
	
	Examples: 
	| brand	| keyword |
	| VH    |         |
	
@id=13 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products as signed in user from home page
#	Given  User access <brand> website 
	When  User navigate to login page 
	And  User try to login using <email> and <password> 
	When  User searches with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand | email                      | password | product |
	| VH    | myaccountvh43@gmail.com    | Passw0rd | t-shirt |
	
@id=14 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products from product details page 
#	Given  User access <brand> website 
	When  User searches with keyword as <product> 
	And  User clicks on product 
	When  User searches with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand | product |
	| VH    | shirt   |
	
@id=15 @positive @parallel @search_filter_module @brand=PB @desktop
Scenario Outline: Search products from cart/bag page 
#	Given  User access <brand> website 
	And  User goes to cart 
	When  User searches with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand | product | 
	| VH    | shirt   |
	
#@id=3 @positive @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products using style 
#	Given  User access <brand> website 
#	When  User searches with keyword as <style> 
#	Then  User should see results for <style> 
	
#	Examples: 
#	| brand	 | style        |

#@id=4 @positive @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products using occasion 
#	Given  User access <brand> website 
#	When  User searches with keyword as <occasion> 
#	Then  User should see results for <occasion> 
	
#	Examples: 
#	| brand  | occasion   |
#	| CKUS   | Casual     |
#	| CKUS   | Beach      |
#	| CKUS   | Work       |
	
		
#@id=7 @positive @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products using size 
#	Given  User access <brand> website 
#	When  User searches with keyword as <size> 
#	Then  User should see results for <size> 

#	Examples: 
#	| brand	 | size  |	
#	| VH     | XS    |
	
#@id=5 @positive @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products using length 
#	Given  User access <brand> website 
#	When  User searches with keyword as <length> 
#	Then  User should see results for <length> 
	
#	Examples: 
#	| brand	 | length     |	
#	| CKUS   | Long Sleeve|
#	| CKUS   | 3/4 sleeve |
	
#@id=10 @positive @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products using type 
#	Given  User access <brand> website 
#	When  User searches with keyword as <type> 
#	Then  User should see results for <type> 
	
#	Examples: 
#	| brand  | type       |
#	| CKUS   | Fitness    |
#	| CKUS   | Performance|
	
#@id=16 @positive @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products as guest user from home page
#	Given  User access <brand> website 
#	And  User is not signed in 
#	When  User searches with keyword as <product> 
#	Then  User should see results for <product> 
	
#	Examples: 
#	| brand  | product | 
#	| CKUS   | t-shirt |
	
#@id=14 @negative @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products which are currently not available 
#	Given  User access <brand> website 
#	When  User searches with keyword as <item> 
#	Then  User should see no search results message 
	
#	Examples: 
#	| brand | item    |          
#	| CKUS  | 4534018 | 
#	| CKUS  | 45BK322 | 
#	| CKUS  | 20F6541 |

#@id=8 @positive @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products using Style Number 
#	Given  User access <brand> website
#	When  User searches with keyword as <styleNumber>
#	Then  User should see <styleNumber> product details
	
#	Examples: 
#	| brand  | styleNumber  | 
#	| VH     | 15193484     | 

#@id=9 @positive @parallel @search_filter_module @brand=PB @desktop
#Scenario Outline: Search products using brand 
#	Given  User access <brand> website 
#	When  User searches with keyword as <brands> 
#	Then  User should see results for <brands> 
	
