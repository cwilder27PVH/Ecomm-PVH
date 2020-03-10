@module=wishlistSP
Feature: Wishlist SP
Description: This feature uses Wishlist to verify 

#@id=1 @positive @parallel @wishlist_module
#Scenario Outline: Verify adding a new item to wishlist from cart as signed in user
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#	And User adds item from cart to wishlist
#	And User navigates to wishlist
#	Then User verifies wishlist item matches item from cart
#	And User clear wishlist
	
#@id=2 @negative @parallel @wishlist_module
#Scenario Outline: Verify adding a item to wishlist that is already in wishlist
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#	And User adds item from cart to wishlist
#	And User add <item> to cart
#	And User adds item from cart to wishlist
#	Then User verifies <error> item is already in wishlist
#	And User clear cart
#	And User clear wishlist
		


#@id=3 @positive @parallel @wishlist_module
#Scenario Outline: Verify adding a new item to wishlist from cart as guest user
#	Given User access <brand> website
#    When User searches for <item>
#	And User clicks on product
#	And User chooses random size
#	And User adds the product to their wishlist
#	And User try to login using <email> and <password>
#	And User navigates to wishlist
#	Then User verifies wishlist item matches item from cart
#	And User clear wishlist


#@id=4 @negative @parallel
#Scenario Outline: Verify adding a item to wishlist without selecting a size
#	Given User access <brand> website
#    When User searches for <item>
#	And User clicks on product
#	And User adds the product to their wishlist
#	Then User verifies user is prompted to select a size
