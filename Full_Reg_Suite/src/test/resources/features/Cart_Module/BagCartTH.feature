@module=bagCartTH
Feature: Bag and Cart TH
Description: This feature uses Bag and Cart to verify 

Background:
	Given User navigates to Tommy Hilfiger Webstore
	And User logs out if already logged in

@id=1 @positive @parallel @cart_module @cart @brand=TH @desktop
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
	| brand | item    | firstquantity |
	| TH    | aw08418 | 1             |

	
@id=2 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Add product to cart from quick view page as guest user
#	Given User access <brand> website
	When User searches with keyword as <product>
	And User navigates to quick view page of first product and adds it to bag
	And User goes to cart page
#	Then User verifies title on product page matches item on cart page

	Examples:
	| brand | product |
	| TH    | sweater |

@id=3 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Verify searching and adding an item to cart from cart page as guest user
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
	| brand | item    | product | firstquantity |
	| TH    | aw08418 | AW04974  | 1             |
	
	
@id=4 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Add quantity of product from cart page as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	And User adjusts the quantity to <secondquantity>
	Then User verifies title on product page matches item on cart page


	Examples:
	| brand | item      | firstquantity | secondquantity |
	| TH    | aw08418   | 2             | 3              |
	
	
@id=5 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Removing 1 product as guest user when cart has more than 1 product as guest user
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
	| brand | item    | product   | firstquantity |
	| TH    | aw08418 | AW04974   | 1             |


@id=6 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Add product from wishlist to cart as signed in user
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
	When User searches with keyword as <product>
#	And User clicks on product
#	And User chooses random size
	And User adds the product to their wishlist
	And User navigates to their wishlist and adds the first item to cart
	And User goes to cart page
	Then User verifies title on product page matches item on cart page
	And User removes all items in cart
	And User clear wishlist

	Examples:
	| brand	| email                   | password | product   |
	| TH    | myaccountth45@gmail.com | Passw0rd | aw08418   |

@id=7 @positive @parallel @cart_module @cart @brand=TH @desktop
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
	| brand | product  | firstquantity | email                   | password |
	| TH    | sweater  | 1             | myaccountth45@gmail.com | Passw0rd |

#@id=8 @positive @parallel @cart_module @cart @brand=TH @desktop
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
#	| TH    | aw08418   | 1        | William | Anish | Happy Birthday! |

@id=9 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Remove gift box as guest user
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
	And User removes the gift box
	Then User verifies gift box has been removed

	Examples:
	| brand | item    | quantity | to    | from  | message        |
	| TH    | aw08418 | 1        | Anish | Bilal | Happy belated! |

@id=10 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Edit gift box as guest user
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

	Examples:
	| brand | item    | quantity | to      | from  | message         | newTo   | newFrom | newMessage      |
	| TH    | aw08418 | 1        | William | Anish | Happy Birthday! | Anish   | William | Happy day!      |

@id=11 @negative @parallel @cart_module @cart @brand=TH @desktop
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
	| brand | item     | quantity | code    | text                       |
	| TH    | aw08418  | 1        | ABCDEFG | ABCDEFG is an invalid code |

#@id=12 @positive @parallel @cart_module
#Scenario Outline: Verify applying valid promo code which is applicable to more then 1 item in cart as guest user
#	Given User access <brand> website
#	And User add <item> to cart
#    And User add <secondItem> to cart
#    And User applies promo <code>
#    Then User verifies promo code added for multiple items <code>
#    
#    @brand=CKUS
#    Examples:
#    | brand | item     | secondItem | code   |
#    | CKUS  | 11599403 | 12866431   | FALL20 |
#
#    @cart
#    Examples: 
#    | brand | item    | secondItem | code      |
#    | TH    | UU00003 | 78C4161    | CCP2B61QF |
#
#    @brand=SPEEDO
#    Examples:
#    | brand  | item    | secondItem | code  | 
#    | SPEEDO | 7719727 |  8051504   | LTF25 |

#@id=13 @positive @parallel @cart_module
#Scenario Outline: Veriy removing applied promo code from cart as guest user
#	Given User access <brand> website
#	And User add <item> to cart
#	And User applies promo <code>
#	Then User verifies that removing promo code removes discount <code>
#
#	@brand=CKUS
#    Examples:
#    | brand | item     | secondItem | code   |
#    | CKUS  | 11599403 | 12866431   | FALL20 |
#
#	@cart
#    Examples: 
#    | brand | item    | secondItem | code      |
#    | TH    | UU00003 | 78C4161    | CCP2B61QF |
#	
#	@brand=SPEEDO
#    Examples:
#    | brand  | item    | secondItem | code  | 
#    | SPEEDO | 7719727 |  8051504   | LTF25 |
	
#@id=14 @positive @parallel @cart_module @cart
#Scenario Outline: Verify adding bundle product to cart
#	Given User access <brand> website
#	And User add <item> to cart
#	Then User verifies title on product page matches item on cart page
	
#	Examples:
#	| brand | item    |
#	| TH    | UG00044 |
	
@id=15 @negative @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Add product without selecting a size
#	Given User access <brand> website
	When User searches with keyword as <product>
#	And User clicks on product
	And User adds item to bag
	Then User verifies user is prompted to select a size
	
	Examples:
	| brand | product |
	| TH    | mw04628 |

@id=16 @positive @parallel @cart_module @cart @brand=TH @desktop
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
	| brand | item    |
	| TH    | aw08418 |
	
#@id=17 @positive @parallel @cart_module @cart @brand=TH @desktop
#Scenario Outline: Reduce quantity of product from cart page as guest user
#	Given User access <brand> website
#	When User searches with keyword as <product> 
#	And User clicks on product
#	And User chooses random size
#	And User selects the quantity and sets it to <firstquantity>
#	And User clicks add to bag 
#	And User goes to cart page
#	And User adjusts the quantity to <secondquantity>
#	Then User verifies title on product page matches item on cart page

#	Examples:
#	| brand | product | firstquantity | secondquantity |
#	| TH    | sweater | 3             | 1              |
	
@id=18 @positive @parallel @cart_module @cart @brand=TH @desktop
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
	| brand | item     | email                   | password   | quantity |
	| TH    | aw08418  | myaccountth45@gmail.com | Passw0rd   | 1        |
		
	
@id=19 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Verify sign in users can add products to cart
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
#	When User searches with keyword as <product>
#	And User saves product details from PDP 
#	And User clicks on product
#	And User chooses random size
#	And User clicks add to bag
#	And User goes to cart page
    And User searches an <item> with style number and adds it to cart
	Then User verifies title on product page matches item on cart page
	And User removes all items in cart
		
	Examples:
	| brand	 | email                   | password | item      | firstquantity | secondquantity |
	| TH     | myaccountth45@gmail.com | Passw0rd | aw08418   | 1             | 3              |

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
#	| brand | product | firstquantity | secondquantity |
#	| TH    | RW00902 | 1             | 5              |

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
	| brand | item    | email                   | password | firstquantity | secondquantity |
	| TH    | aw08418 | myaccountth45@gmail.com | Passw0rd |          2    |        3       |
		

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
#	| brand | item        | email                  | password | quantity	| quantityLess |
#	| TH    | blue shirts | myaccountth5@gmail.com | Passw0rd | 2           | 1            |

#@id=23 @negative @parallel @cart_module @cart
#Scenario Outline: Add an item with a quantity lower than the quantity requested
#	Given User access <brand> website
#	When User searches with keyword as <item>
#	And User clicks on product
#	And User chooses random size
#	And User adjusts <quantity> and adds to bag
#	Then User verifies page level message for less quantity displayed
	
#	Examples:
#	| brand | item    | quantity |	
#	| TH    | RW00802 | 4        |
		
@id=24 @positive @parallel @cart_module @cart @brand=TH @desktop
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
	| brand | item    | quantity | 
	| TH    | aw08418 | 2        | 
		

@id=25 @negative @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Adding more then 50 items to cart
#	Given User access <brand> website
	And User adds <quantity> of items <item> to cart
	Then User verifies error on item page <error>
	
	Examples:
	| brand | quantity | item  | error                                                                                                                                                                                                                  |
	| TH    | 50       | shirt | ERROR: THE MAXIMUM NUMBER OF ITEMS IN THE SHOPPING CART IS 50. YOU CURRENTLY HAVE 50 ITEMS AND HAVE ATTEMPTED TO ADD 1 MORE. REMOVE SOME ITEMS AND TRY AGAIN, OR CHECKOUT AND ADD THE ITEMS TO AN EMPTY SHOPPING CART. |
	
#@id=26 @negative @parallel @cart_module
#Scenario Outline: Verify applying valid promo code but not applicable for an item in cart as guest user
#	Given User access <brand> website
#	And User add <item> to cart
#	And User applies promo <code>
#	Then User should verify valid promo code is not applicable for item
#  
#  @cart 
#  Examples: 
#  | brand | item    | code       |
#  | TH    | FM01016 | EXTRAEXTRA |

#@id=27 @negative @parallel @cart_module
#Scenario Outline: Verify applying valid promo code which is applicable to only one item in cart as guest user
#	Given User access <brand> website
#	And User add <item> to cart
#	And User add <secondItem> to cart
#	And User applies promo <code> 
#	Then User should verify valid promo code <code> is applicable for one item
#   
#  Examples: 
#  | brand | item    | code      | secondItem |
#  | TH    | FM01016 | CCP2B61QF | UU00004    |


@id=28 @negative @parallel @cart_module @cart @brand=TH @desktop
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
	| brand | email                   | password | item    | code   | text                      |
	| TH    | myaccountth45@gmail.com | Passw0rd | aw08418 | TTTEEE | TTTEEE is an invalid code |
	

#@id=29 @positive @parallel @cart_module
#Scenario Outline: Verify adding an item to cart as signed in user and apply valid promo code
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User add <item> to cart
#	And User applies promo <code>
#	Then User should verify valid promo code <code> is applicable for one item
#	And User removes promo code
#	And User removes all items in cart
#	
#	Examples:
#	| brand | email                 | password | item    | code      | 
#	| TH    | willtest1@yopmail.com | Passw0rd | WW24162 | CCP2B61QF | 

@id=30 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Verify adding a item to wishlist that is already present in cart
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
#    When User searches with keyword as <product> 
#	And User saves product details from PDP 
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
	| brand	| email                   | password | item    |
	| TH    | myaccountth45@gmail.com | Passw0rd | aw08418 |
	
@id=31 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Verify hazmat message is displaying on the shopping bag page.
#	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
    When User searches with keyword as <product> 
#	And User saves product details from PDP 
	And User clicks on product
#	And User chooses random size
	And User clicks add to bag 
	And User goes to cart page
   
	
	Examples:
	| brand	| email                   | password | product    |
	| TH    | myaccountth45@gmail.com | Passw0rd | fragrance |


