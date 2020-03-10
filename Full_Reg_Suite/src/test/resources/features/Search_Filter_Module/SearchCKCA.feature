@module=searchProductCKCA
Feature: Search Product CKCA
	Description: This feature uses search bar to verify search results

Background:
	Given User navigates to Calvin Klein CA Webstore
	And User logs out if already logged in

@id=1 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search prodcuts using department 
#	Given User access <brand> website 
	When User searches with keyword as <department> 
	Then User should see results for <department>
	
	Examples: 
	| brand	 | department |
#	| CKUS	 | Men        |
	| CKCA	 | Men        |

@id=2 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using category 
#	Given  User access <brand> website 
	When  User searches with keyword as <category> 
	Then  User should see results for <category> 
	
	Examples: 
	| brand	 | category   |
#	| CKUS	 | All        |
	| CKCA	 | All        |
	
@id=3 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using style 
#	Given  User access <brand> website 
	When  User searches with keyword as <style> 
	Then  User should see results for <style> 
	
	Examples: 
	| brand	 | style        |
#	| CKUS	 | Active Tops  |
	| CKCA	 | Active Tops  |

@id=4 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using occasion 
#	Given  User access <brand> website 
	When  User searches with keyword as <occasion> 
	Then  User should see results for <occasion> 
	
	Examples: 
	| brand  | occasion   |
#	| CKUS   | Casual     |
	| CKCA   | Casual     |
	
@id=5 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using length 
#	Given  User access <brand> website 
	When  User searches with keyword as <length> 
	Then  User should see results for <length> 
	
	Examples: 
	| brand	 | length     |	
#	| CKUS   | Long Sleeve|
	| CKCA   | Long Sleeve|
	
@id=6 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using color 
#	Given  User access <brand> website 
	When  User searches with keyword as <color> 
	Then  User should see results for <color>
	
	Examples: 
	| brand  | color      |
#	| CKUS   | Red        |
	| CKCA   | Red        |
	
@id=7 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using size 
#	Given  User access <brand> website 
	When  User searches with keyword as <size> 
	Then  User should see results for <size> 

	Examples: 
	| brand	 | size  |	
#	| CKUS   | XS    |
	| CKCA   | XS    |

@id=8 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using Style Number 
#	Given  User access <brand> website
	When  User searches for <styleNumber>
	Then  User should see <styleNumber> product details
	
	Examples: 
	| brand  | styleNumber  | 
#	| CKUS   | 37403933-618 | 
	| CKCA   | 37403933-618 | 

#@id=9 @positive @parallel @search_filter_module @desktop
#Scenario Outline: Search products using brand 
#	Given  User access <brand> website 
#	When  User searches with keyword as <brands> 
#	Then  User should see results for <brands> 
	


@id=10 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using type 
#	Given  User access <brand> website 
	When  User searches with keyword as <type> 
	Then  User should see results for <type> 
	
	Examples: 
	| brand  | type       |
#	| CKUS   | Fitness    |
	| CKCA   | Fitness    |

@id=11 @negative @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using invalid keyword 
#	Given  User access <brand> website 
	When  User searches with keyword as <keyword> 
	Then  User should see no search results message
	
	Examples: 
	| brand	| keyword |
#	| CKUS  | 6666    |
	| CKCA  | 6666    |

@id=12 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products using keyword with special character
	character 
#	Given  User access <brand> website 
	When  User searches with keyword as <keyword> 
	Then  User should get prohibited characters error 
	
	Examples: 
	| brand | keyword | 
#	| CKUS	| 123!@#  |
	| CKCA	| 123!@#  |

@id=13 @negative @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products without providing search keyword 
#	Given  User access <brand> website 
	When  User searches with keyword as <keyword> 
	Then  User should remain on home page 
	
	Examples: 
	| brand	| keyword |
#	| CKUS  |         |
	| CKCA  |         |


@id=14 @negative @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products which are currently not available 
#	Given  User access <brand> website 
	When  User searches with keyword as <item> 
	Then  User should see no search results message 
	
	Examples: 
	| brand | item    |          
#	| CKUS  | 4534018 | 
	| CKCA  | 4534018 | 

@id=15 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search suggestion should match the entered search term 
#	Given  User access <brand> website
	When  User inputs search <searchTerm>
	Then  User should see search suggestions related to <searchTerm> 
	
	Examples: 
	| brand | searchTerm | 
#	| CKUS  | Men        | 
	| CKCA  | Men        | 

@id=16 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products as guest user from home page
#	Given  User access <brand> website 
	And  User is not signed in 
	When  User searches with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand  | product | 
#	| CKUS   | t-shirt |
	| CKCA   | t-shirt |

	
@id=17 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products as signed in user from home page
#	Given  User access <brand> website 
	When  User navigate to login page 
	And  User try to login using <email> and <password> 
	When  User searches with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand | email                     | password  | product |
#	| CKUS  | myaccountckus43@gmail.com | Passw0rd  | t-shirt |
	| CKCA  | myaccountckca43@gmail.com | Passw0rd  | t-shirt |


@id=18 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products from product details page 
#	Given  User access <brand> website 
	When  User searches with keyword as <product> 
	And  User clicks on product 
	When  User searches with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand | product |
#	| CKUS  | t-shirt |
	| CKCA  | t-shirt |


@id=19 @positive @parallel @search_filter_module @brand=CK @desktop
Scenario Outline: Search products from cart/bag page 
#	Given  User access <brand> website 
	And  User goes to cart 
	When  User searches with keyword as <product> 
	Then  User should see results for <product> 
	
	Examples: 
	| brand | product | 
#	| CKUS  | t-shirt |
	| CKCA  | t-shirt |