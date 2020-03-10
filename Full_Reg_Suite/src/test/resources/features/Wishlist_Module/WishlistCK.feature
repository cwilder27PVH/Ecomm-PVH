@module=wishlistCK
Feature: Wishlist CK
Description: This feature uses Wishlist to verify 

Background:
	Given User navigates to Calvin Klein US Webstore
	And User logs out if already logged in

@id=1 @positive @parallel @wishlist_module @brand=CK
Scenario Outline: Verify adding a new item to wishlist from cart as signed in user
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
#    And User add <item> to cart
	And User goes to cart page
	And User removes all items in cart
    And User searches an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to wishlist
	Then User verifies wishlist item matches item from cart
	And User clear wishlist
	
	Examples:
	| brand	| email                      | password | item 	        |
	| CKUS  | myaccountckus425@gmail.com | Passw0rd | 33014357      |
#	| CKCA  | myaccountckca428@gmail.com | Passw0rd | 45003293      |

@id=2 @negative @parallel @wishlist_module @brand=CK
Scenario Outline: Verify adding an item to wishlist that is already in wishlist
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User goes to cart page
	And User removes all items in cart
    And User searches an <item> with style number and adds it to cart
#    And User add <item> to cart
	And User adds item from cart to wishlist
    And User searches an <item> with style number and adds it to cart
#	And User add <item> to cart
	And User adds item from cart to wishlist
	Then User verifies <error> item is already in wishlist
#	And User clear cart
	And User removes all items in cart
	And User clear wishlist
		
	Examples:
	| brand	| email                      | password | item          | error                                         |
	| CKUS  | myaccountckus425@gmail.com | Passw0rd | 33014357      | This item already exists in your saved items. |
#	| CKCA  | myaccountckca428@gmail.com | Passw0rd | 45003293      | This item already exists in your saved items. |

@id=3 @positive @parallel @wishlist_module @brand=CK
Scenario Outline: Verify adding a new item to wishlist from PDP as guest user
#	Given User access <brand> website
    When User searches for <item>
#	And User clicks on product
#	And User chooses random size
	And User adds the product to their wishlist
	And User try to login using <email> and <password>
	And User navigates to wishlist
	Then User verifies wishlist item matches item from cart
	And User clear wishlist
	
	Examples:
	| brand | email                      | password | item 	   |
	| CKUS  | myaccountckus425@gmail.com | Passw0rd | 33014357 |
#	| CKCA  | myaccountckca428@gmail.com | Passw0rd | 45003293 |


@id=4 @negative @parallel @brand=CK
Scenario Outline: Verify adding a item to wishlist without selecting a size
#	Given User access <brand> website
    When User searches for <item>
#	And User clicks on product
	And User adds the product to their wishlist
	Then User verifies user is prompted to select a size
	
	Examples:
	| brand	| item         |
	| CKUS  | 11008092-400 |
#	| CKCA  | 11008092-400 |