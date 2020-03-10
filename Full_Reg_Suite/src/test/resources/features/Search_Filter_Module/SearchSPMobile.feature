@module=searchProductSPMobile
Feature: Search Product SP
	Description: This feature uses search bar to verify search results

@id=1 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search prodcuts using department 
	Given User access <brand> website 
	When User searches on mobile with keyword as <department> 
	Then User should see results for <department>
	
	Examples: Speedo
	| brand	 | department |
	| Speedo | Women      |
#	| Speedo | Men        |
#	| Speedo | Kids       |
#	| Speedo | Goggles    |
#	| Speedo | Gear       |
#	| Speedo | Sale       |
#	| Speedo | Teams      |
	
@id=2 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using category 
	Given  User access <brand> website 
	When User searches on mobile with keyword as <category> 
	Then  User should see results for <category> 
	
	Examples: 
	| brand	 | category   |
	| SPEEDO | Performance|
#	| SPEEDO | Fitness    |
#	| SPEEDO | Elite      |
#	| SPEEDO | Caps       |
#	| SPEEDO | Plus Size  |
#	| SPEEDO | Recreation |
	
@id=3 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using style 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <style> 
	Then  User should see results for <style> 
	
	Examples: 
	| brand	 | style        |
	| SPEEDO | Bottoms      |
#	| Speedo | Jammers      |
#	| Speedo | One Piece    | 
#	| Speedo | Jackets      |
#	| Speedo | Volley       |
#	| Speedo | Cover Ups    |
	
@id=4 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using occasion 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <occasion> 
	Then  User should see results for <occasion> 
	
	Examples: 
	| brand  | occasion   |
	| SPEEDO | Sport      |
#	| SPEEDO | Beach      |
#	| SPEEDO | Work       | 
	
@id=5 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using length 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <length> 
	Then  User should see results for <length> 
	
	Examples: 
	| brand	 | length     |
	| Speedo | Long Sleeve|
	
@id=6 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using color 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <color> 
	Then  User should see results for <color>
	
	Examples: 
	| brand  | color      |
	| SPEEDO | Red        |
#	| SPEEDO | Blue       |
#	| SPEEDO | Yellow     | 
#	| SPEEDO | Green      |
#	| SPEEDO | Black      | 
	
@id=7 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using size 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <size> 
	Then  User should see results for <size> 
	
	Examples: 
	| brand	 | size  |
	| Speedo | XS    |
#	| Speedo | S     |
#	| Speedo | M     |
#	| Speedo | L     | 
	
@id=8 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using Style Number 
	Given  User access <brand> website
	When  User searches on mobile for <styleNumber>
	Then  User should see <styleNumber> product details
	
	Examples: 
	| brand  | styleNumber | 
	| SPEEDO | 7719807     | 
#	| SPEEDO | 7707011     | 
#	| SPEEDO | 7734117     | 
#	| SPEEDO | 7705806     |
#	| SPEEDO | 7050920     |
	
#@id=9 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
#Scenario Outline: Search products using brand 
#	Given  User access <brand> website 
#	When  User searches on mobile with keyword as <brands> 
#	Then  User should see results for <brands> 


@id=10 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using type 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <type> 
	Then  User should see results for <type> 
	
	Examples: 
	| brand  | type       |
	| SPEEDO | Fitness    |
#	| SPEEDO | Performance|
#	| SPEEDO | Recreation | 
	
@id=11 @negative @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using invalid keyword 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <keyword> 
	Then  User should see no search results message
	
	Examples: 
	| brand	 | keyword |
	| Speedo | 1234    |
#	| Speedo | asd1234 |

@id=12 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products using keyword with special character
	character 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <keyword> 
	Then  User should get prohibited characters error 
	
	Examples: 
	| brand  | keyword |
	| Speedo | 123!@#  |
#	| Speedo | !@#     |
#	| Speedo | asd!@#  |
#	| Speedo | !!??@#$ | 
	
#@id=13 @negative @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
#Scenario Outline: Search products without providing search keyword 
#	Given  User access <brand> website 
#	When  User searches on mobile with keyword as <keyword> 
#	Then  User should remain on home page 
	
#	Examples: 
#	| brand	 | keyword |
#	| Speedo |         |
	
@id=14 @negative @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products which are currently not available 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <item> 
	Then  User should see no search results message 
	
	Examples: 
	| brand  | item    | 
	| SPEEDO | 4534018 |
#	| SPEEDO | 45BK322 |
#	| SPEEDO | 20F6541 |
	
@id=15 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search suggestion should match the entered search term 
	Given  User access <brand> website
	When  User mobile inputs search <searchTerm>
	Then  User should see search suggestions related to <searchTerm> 
	
	Examples: 
	| brand  | searchTerm |
	| SPEEDO | tank       |
#	| SPEEDO | Elite      |
#	| SPEEDO | Tankini    |
#	| SPEEDO | Fitness    |
	
#@id=16 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
#Scenario Outline: Search products as guest user from home page
#	Given  User access <brand> website 
#	And  User is not signed in 
#	When  User searches on mobile with keyword as <product> 
#	Then  User should see results for <product> 
	
#	Examples: 
#	| brand  | product |
#	| Speedo | trunks  |
	
@id=17 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products as signed in user from home page
	Given  User access <brand> website 
	When  User navigate to mobile login page 
	And  User try to login using <email> and <password> 
	When  User searches on mobile with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand  | email 			   	 	   | password | product |
	| Speedo | myaccountspeedo43@gmail.com | Passw0rd	| trunks  |
	
@id=18 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products from product details page 
	Given  User access <brand> website 
	When  User searches on mobile with keyword as <product> 
	And  User clicks on product 
	When  User searches on mobile with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand  | product |
	| Speedo | trunks  | 
	
@id=19 @positive @parallel @search_filter_module @brand=SP @brand=SPMobile @mobile
Scenario Outline: Search products from cart/bag page 
	Given  User access <brand> website 
	And  User goes to cart 
	When  User searches on mobile with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand  | product |
	| Speedo | trunks  |
