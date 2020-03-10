@module=bagCartCK
Feature: Bag and Cart CK
Description: This feature uses Bag and Cart to verify 

Background:
	Given User navigates to Calvin Klein US Webstore 
	And User logs out if already logged in

@id=1 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Add product to cart from product details page as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User saves product details from PDP
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	Then User verifies title on product page matches item on cart page
	
	Examples:
	| brand	| item     |
	| CKUS  | 46301423 |
#	| CKCA  | 45003293 |
	
@id=3 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Verify cart page is updated when adding mulitple items to cart as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User saves product details from PDP
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag
    And User searches an <item> with style number and adds it to cart
#	And User searches with keyword as <secondProduct>
#	And User saves second product details from PDP
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag
#	And User goes to cart page
    And User searches another <product> with style number and adds it to cart
	Then User should verify that both items are in bag

	Examples:
	| brand | item     | product       | 
	| CKUS  | 46301423 |  37403933-618 |
#	| CKCA  | 45003293 |  46301423     |
	
@id=4 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Update quantity of product from cart page as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User saves product details from PDP
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	And User adjusts the quantity to <secondquantity>
	Then User verifies title on product page matches item on cart page

	Examples:
	| brand | item         | firstquantity | secondquantity |
	| CKUS  | 46301423     | 2             | 3              |
#	| CKCA  | 45003293     | 2             | 3              |
	
@id=5 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Removing 1 product as guest user when cart has more than 1 product
#	Given User access <brand> website
#	When User searches with keyword as <product>
#	And User saves product details from PDP 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag
    And User searches an <item> with style number and adds it to cart
#	And User searches with keyword as <secondProduct>
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag
#	And User goes to cart page
    And User searches another <product> with style number and adds it to cart
	And User removes the second item
	Then User verifies title on product page matches item on cart page

	Examples:
	| brand | item       | product   |
	| CKUS  | 46301423   |  33014357 |
#	| CKCA  | 45003293   |  46301423 |
	
@id=6 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Add product from wishlist to cart as signed in user
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
   When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
   # And User searches an <product> with style number and adds it to cart
   # And User searches an <item> with style number and adds it to cart
	And User adds the product to their wishlist
	And User navigates to their wishlist and adds the first item to cart
	And User goes to cart page
	Then User verifies title on product page matches item on cart page
	And User removes all items in cart
	And User clear wishlist

	Examples:
	| brand	| email                      | password | product   |
	| CKUS  | myaccountckus45@gmail.com  | Passw0rd | 46301423  |
#	| CKCA  | myaccountckca45@gmail.com  | Passw0rd | 45003293  |
	
@id=7 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Add product with size selection as guest user then edit product size in cart as signed in user
#	Given User access <brand> website
	When User searches with keyword as <product> 
	And User clicks on product
	And User chooses random size
	And User saves product details from PDP
	And User selects the quantity and sets it to <firstquantity>
	And User clicks add to bag
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
	And User goes to cart page
	And User edits product to another size from edit page
	Then User verify edit change in bag
	And User removes all items in cart
	
	Examples:
	| brand	| product    | firstquantity | email                     | password |
	| CKUS  | sweater    |  1	  	     | myaccountckus45@gmail.com | Passw0rd |
#	| CKCA  | sweater    |  1			 | myaccountckca45@gmail.com | Passw0rd |
	
#@id=8 @positive @parallel @cart_module @cart @brand=CK @desktop
#Scenario Outline: Add gift box as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <quantity>
#	And User clicks add to bag
#	And User goes to cart page
#	And User adds a gift box to <to> from <from> with message <message>
#	Then User verifies gift box text <to> <from> and <message> matches provided
	
#	Examples:
#	| brand | product   | quantity | to      | from  | message         |
#	| CKUS  | 46301423  | 1        | William | Anish | Happy Birthday! |
	
#@id=9 @positive @parallel @cart_module @brand=CK @desktop
#Scenario Outline: Remove gift box as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <quantity>
#	And User clicks add to bag
#	And User goes to cart page
 #   And User searches an <item> with style number and adds it to cart
#	And User adds a gift box to <to> from <from> with message <message>
#	Then User verifies gift box text <to> <from> and <message> matches provided
#	And User removes the gift box
#	Then User verifies gift box has been removed

#	Examples:
#	| brand | item      | quantity | to    | from  | message        |
#	| CKUS  | 46301423  | 1        | Anish | Bilal | Happy belated! |
	
@id=10 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Add, Edit and Remove gift box as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <quantity>
#	And User clicks add to bag
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	And User adds a gift box to <to> from <from> with message <message>
	Then User verifies gift box text <to> <from> and <message> matches provided
	And User edits the gift box with new to <newTo> from <newFrom> with new message <newMessage>
	Then User verifies gift box text <newTo> <newFrom> and <newMessage> matches provided
	And User removes the gift box
	Then User verifies gift box has been removed

	Examples:
	| brand | item     | quantity | to      | from  | message         | newTo   | newFrom | newMessage     | 
	| CKUS  | 46301423 | 1        | William | Anish | Happy Birthday! | Anish   | William | Happy day!     |
	
@id=11 @negative @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Apply invalid promo code as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <quantity>
#	And User clicks add to bag
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	And User applies promo <code>
	Then User should get promo error message <text>
	
	Examples:
	| brand | item      | code    | text                       |
	| CKUS  | 46301423  | ABCDEFG | ABCDEFG is an invalid code |
#	| CKCA  | 45003293  | ABCDEFG | ABCDEFG is an invalid code |
	
#@id=14 @positive @parallel @cart_module @cart 
#Scenario Outline: Verify adding bundle product to cart
#	Given User access <brand> website
#	And User add <item> to cart
#	Then User verifies title on product page matches item on cart page
	
#	Examples:
#	| brand	| item         |
#	| CKUS  | 38010531-136 |
#	| CKCA  | 38010531-136 | 
	
@id=15 @negative @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Add product without selecting a size
#	Given User access <brand> website
	When User searches with keyword as <product>
#	And User clicks on product
	And User adds item to bag
	Then User verifies user is prompted to select a size
	
	Examples:
	| brand | product        |
	| CKUS  |  11008092-400   |
#	| CKCA  | 11008092-400   |
	
@id=16 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Remove 1 product from cart as guest user when cart has only 1 product as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product>
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <quantity>
#	And User clicks add to bag
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	And User removes all items in cart
	Then User verifies that the cart is empty
	
	Examples:
	| brand | item       |
	| CKUS  | 46301423   |
#	| CKCA  | 45003293   |
	
#@id=17 @positive @parallel @cart_module @cart @brand=CK @desktop
#Scenario Outline: Reduce quantity of product from cart page as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User saves product details from PDP
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag 
#	And User goes to cart page
#	And User adjusts the quantity to <secondquantity>
#	Then User verifies title on product page matches item on cart page
	
#	Examples:
#	| brand | product     | firstquantity | secondquantity |
#	| CKUS  | 46301423    | 3             | 1              |
#	| CKCA  | 46301423    | 3             | 1              |
	
@id=18 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Verify products added as a guest user are prevalent in the cart upon signing in
#	Given User access <brand> website
#	When User searches with keyword as <product>
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <quantity>
#	And User clicks add to bag
    And User searches an <item> with style number and adds it to cart
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
	And User goes to cart page
	Then User verifies title on product page matches item on cart page
	And User removes all items in cart
	
	Examples:
	| brand | item       | email                     | password | quantity |
	| CKUS  | 46301423   | myaccountckus45@gmail.com | Passw0rd | 1        |
#	| CKCA  | 45003293   | myaccountckca45@gmail.com | Passw0rd | 1        |
	
@id=19 @positive @parallel @cart_module @cart 
Scenario Outline: Verify sign in users can add products to cart
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
#	When User searches with keyword as <product>
#	And User clicks on product
#	And User chooses random size
#	And User clicks add to bag
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	Then User verifies title on product page matches item on cart page
	And User removes all items in cart
		
	Examples:
	| brand	| email                     | password | item     |
	| CKUS  | myaccountckus45@gmail.com | Passw0rd | 46301423 |
#	| CKCA  | myaccountckca45@gmail.com | Passw0rd | 45003293 |
	
#@id=20 @negative @parallel @cart_module @cart  
#Scenario Outline: Add more than 5 quantity of product with less than 5 quantity available on cart page
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity> and adds it to bag
#	And User goes to cart page
#	And User adjusts the quantity of <secondquantity> without checking stock
#	Then User verifies <error> quantity not available
	
#	Examples:
#	| brand | product      | firstquantity | secondquantity |
#	| CKUS  | 21891957     | 1             | 6              |
#	| CKCA  | 13407023-100 | 1             | 6              |
	
@id=21 @positive @parallel @cart_module @cart 
Scenario Outline: Verify signed in users can edit quantity of product in pdp and cart
#	Given User access <brand> website
	And User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag 
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	Then User verifies title on product page matches item on cart page
	And User adjusts the quantity to <secondquantity>
	And User removes all items in cart
	Then User verifies that the cart is empty

	Examples:
	| brand | item     | email                     | password  | firstquantity | secondquantity |
	| CKUS  | 46301423 | myaccountckus45@gmail.com | Passw0rd  | 2             | 3              |
#	| CKCA  | 45003293 | myaccountckca45@gmail.com | Passw0rd  | 2             | 3              |
	
#@id=22 @positive @parallel @cart_module @cart 
#Scenario Outline: Add product with more than 1 quantity as guest user to cart then reduce quantity as signed in user
#	Given User access <brand> website
#	When User searches with keyword as <item>
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <quantity> and adds it to bag
#	And User navigate to login page
#	And User try to login using <email> and <password>
#	And User goes to cart page
#	And User adjusts the quantity to <quantityLess>
#	Then User verifies <quantityLess> of items in cart less
#	And User removes all items in cart

#	Examples:
#	| brand | item  | email                    | password | quantity | quantityLess |
#	| CKUS  | shirt | myaccountckus5@gmail.com | Passw0rd | 2        | 1            |
#	| CKCA  | shirt | myaccountckca5@gmail.com | Passw0rd | 2        | 1            |
	
#@id=23 @negative @parallel @cart_module @cart 
#Scenario Outline: Add an item with a quantity lower than the quantity requested
#	Given User access <brand> website
#	When User searches with keyword as <item>
#	And User clicks on product
#	And User chooses random size
#	And User adjusts <quantity> and adds to bag
#	Then User verifies page level message for less quantity displayed
	
#	Examples:
#	| brand | item         | quantity |	
#	| CKUS  | 21884232-029 | 10       |	
#	| CKCA  | 40ZW995      | 10       |
	
@id=24 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Add the same item to a cart twice and check cart for quantity
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User clicks add to bag 
    And User searches an <item> with style number and adds it to cart
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User clicks add to bag 
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	Then User verifies <quantity> of items in cart less
	
	Examples:
	| brand | item       | quantity | 
#	| CKUS  | 46301423   | 2        |  
#	| CKCA  | 45003293   | 2        | 
	
@id=28 @negative @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Verify adding an item to cart as signed in user and apply invalid promo code
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User clicks add to bag 
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	And User applies promo <code> 
	Then User should get promo error message <text>
	And User removes all items in cart
	
	Examples:
	| brand | email                     | password | item     | code   | text                      |
	| CKUS  | myaccountckus45@gmail.com | Passw0rd | 46301423 | TTTEEE | TTTEEE is an invalid code |
	
@id=30 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Verify adding a item to wishlist that is already present in cart
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
#    When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User clicks add to bag 
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to wishlist
	Then User verifies wishlist item matches item from cart
	And User clear wishlist
	
	Examples:
	| brand	| email                     | password | item     |
	| CKUS  | myaccountckus45@gmail.com | Passw0rd | 46301423 |
#	| CKCA  | myaccountckca45@gmail.com | Passw0rd | 45003293 |	
	
@id=31 @positive @parallel @cart_module @cart @brand=CK @desktop
Scenario Outline: Verify clicking edit button from mini cart navigates user to cart page
#	Given User access <brand> website
	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
	And User clicks add to bag 
	Then User verifies that clicking edit bag navigates to cart
	
	Examples:
	| brand	| product  |
	| CKUS  | 46301423 |
#	| CKCA  | 45003293 |