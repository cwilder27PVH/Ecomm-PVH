@module=wishlistPBMobile
Feature: Wishlist PB Mobile
Description: This feature uses Wishlist to verify 

@id=1 @positive @parallel @wishlist_module @brand=PBMobile @mobile
Scenario Outline: Verify adding a new item to wishlist from cart as signed in user
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User goes to cart page
	And User removes all items in cart
	And User searches on mobile an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to mobile wishlist
#	Then User verifies wishlist item matches item from cart
	And User clear mobile wishlist
	
	Examples:
	| brand	| email                    | password | item    |
	| VH    | myaccountvh410@gmail.com | Passw0rd | izo5079 |

#@id=2 @negative @parallel @wishlist_module
#Scenario Outline: Verify adding a item to wishlist that is already in wishlist
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User goes to cart page
#	And User removes all items in cart
#   And User searches on mobile an <item> with style number and adds it to cart
#	And User adds item from cart to wishlist
#   And User searches on mobile an <item> with style number and adds it to cart
#	And User adds item from cart to wishlist
#	Then User verifies <error> item is already in wishlist
#	And User clear cart
#	And User clear mobile wishlist
		
#	Examples:
#	| brand	| email                      | password | item    | error                                         |
#	| VH    | myaccountvh411@gmail.com   | Passw0rd | izo5079 | This item already exists in your saved items. |


#@id=3 @positive @parallel @wishlist_module
#Scenario Outline: Verify adding a new item to wishlist from PDP as guest user
#	Given User access <brand> website
#   When User searches on mobile for <item>
#	And User adds the product to their wishlist
#	And User try to login using <email> and <password>
#	And User navigates to mobile wishlist
#	Then User verifies wishlist item matches item from cart
#	And User clear mobile wishlist
	
#	Examples:
#	| brand | email                      | password | item 	  |
#	| VH    | myaccountvh411@gmail.com   | Passw0rd | izo5079 |

@id=4 @negative @parallel @brand=PBMobile @mobile
Scenario Outline: Verify adding a item to wishlist without selecting a size
	Given User access <brand> website
	When User searches on mobile for <item>
	And User clicks on product on mobile
	And User adds the product to their wishlist
	Then User verifies user is prompted to select a size
	
	Examples:
	| brand	| item    |
	| VH    | 20f7795 |