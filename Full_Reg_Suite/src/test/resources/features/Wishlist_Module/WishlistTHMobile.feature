@module=wishlistTHMobile
Feature: Wishlist TH Mobile
Description: This feature uses Wishlist to verify 

@id=1 @positive @parallel @wishlist_module @brand=THMobile @mobile
Scenario Outline: Verify adding a new item to wishlist from cart as signed in user
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password> 
	And User goes to cart page
	And User removes all items in cart
	And User searches on mobile an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to mobile wishlist
	Then User verifies wishlist item matches item from cart
	And User clear mobile wishlist
	
	Examples:
	| brand	| email                    | password | item  		    |
	| TH    | myaccountth425@gmail.com | Passw0rd | aw04548         |

@id=2 @negative @parallel @wishlist_module @brand=THMobile @mobile
Scenario Outline: Verify adding a item to wishlist that is already in wishlist
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>  
	And User goes to cart page
	And User removes all items in cart
	And User searches on mobile an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User searches on mobile an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	Then User verifies <error> item is already in wishlist
	And User removes all items in cart
	And User clear mobile wishlist
		
	Examples:
	| brand | email                    | password | item    | error                                       |
	| TH    | myaccountth425@gmail.com | Passw0rd | aw04548 | THIS ITEM ALREADY EXISTS IN YOUR WISH LIST. |

@id=3 @positive @parallel @wishlist_module @brand=THMobile @mobile
Scenario Outline: Verify adding a new item to wishlist from PDP as guest user
	Given User access <brand> website
	When User searches on mobile for <item>
	And User adds the product to their wishlist
	And User try to login using <email> and <password>
	And User navigates to mobile wishlist
	Then User verifies wishlist item matches item from cart
	And User clear mobile wishlist
	And User clear cart
	
	Examples:
	| brand	| email                    | password | item    |
	| TH    | myaccountth425@gmail.com | Passw0rd | aw04548 |

@id=4 @negative @parallel @brand=THMobile @mobile
Scenario Outline: Verify adding a item to wishlist without selecting a size
	Given User access <brand> website
	When User searches on mobile for <item>
	And User adds the product to their wishlist
	Then User verifies user is prompted to select a size
	
	Examples:
	| brand	| item   |
	| TH    | mw04628|
