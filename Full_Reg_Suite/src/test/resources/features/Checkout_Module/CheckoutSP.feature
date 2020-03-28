@module=checkoutSP
Feature: Checkout SP
	Description: This feature allows user to checkout
	
Background:
	Given User navigates to Speedo Webstore
	And User logs out if already logged in
	
@id=1 @positive @parallel @checkout_module @desktop @checkOut @brand=SP @addressy
Scenario Outline: Adding new shipping address during guest checkout
#    Given User access <brand> website
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User adds new address <newAddress> into fields
    Then User verifies that new address has been selected <newAddress>
	
	Examples:
	| brand  | item    | guestFields                                                                               | newAddress                                                                                          |
	| SPEEDO | 7530477 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=2 @positive @parallel @checkout_module @desktop @checkOut @brand=SP @addressy
Scenario Outline: Editing shipping address during checkout with signed in user
#    Given User access <brand> website
    When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User adds default shipping and billing address with valid <values>
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    When User edits and adds the address fields <editAddress>
    Then User verifies the editted address is selected <editAddress>
    
	Examples:
	| brand  | email                       | password | item    | editAddress                                                                                        | firstName | lastName | address    | apartment | city | country | state | zip | phone           | gender | bMonth | bDay | prefCountry | prefState | prefStore | communication | type |values                                                                          |	
	| SPEEDO | myaccountspeedo43@gmail.com | Passw0rd | 7530477 | ckSpeedoTH2@yopmail.com;Bobby;Smith;1200 US Highway 22; ;Bridgewater;New Jersey; ;08807;1234567890 | myaccount | speedo3  |            |           |      |         |       |     |  7324567890     |        |        |      |             |           |           |               |      |myaccount;speedo3;1200 US Highway 22;15;Bridgewater;New Jersey;08807;7324567890 |
	
@id=3 @positive @parallel @checkout_module @desktop @checkOut @brand=SP @addressy
Scenario Outline: Adding new billing address during guest checkout
#	Given User access <brand> website
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
	And User adds new address <newBilling> into billing fields
	Then User verifies that new billing address is selected <newBilling>
	
	Examples:
	| brand  | item    | guestFields                                                                               | newBilling                                                                                          |
	| SPEEDO | 7530477 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |

@id=4 @positive @parallel @checkout_module @desktop @checkOut @brand=SP @addressy
Scenario Outline: Editing billing address during checkout with signed in user
#    Given User access <brand> website
    When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User adds default shipping and billing address with valid <values>
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User adds new address <newBilling> into billing fields signed in
    When User edits and adds the billing address fields <editAddress>
    Then User verifies the editted billing address is selected <editAddress>
    
	Examples: 
	| brand | email                       | password | item    | editAddress                                                                                          | newBilling                                                                                         | firstName | lastName | address    | apartment | city | country | state | zip | phone           | gender | bMonth | bDay | prefCountry | prefState | prefStore | communication | type |values                                                                          |	
	| SPEEDO| myaccountspeedo44@gmail.com | Passw0rd | 7530477 | ckSpeedoTH2@yopmail.com;Alex;Smith;2222 Quail Ridge Drive; ;Plainsboro;New Jersey; ;08536;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road; ;Bridgewater;New Jersey; ;08807;9082316660 | myaccount | speedo3  |            |           |      |         |       |     |  7324567890     |        |        |      |             |           |           |               |      |myaccount;speedo3;1200 US Highway 22;15;Bridgewater;New Jersey;08807;7324567890 |

@id=5 @positive @parallel @checkout_module @desktop @checkOut @brand=SP @addressy
Scenario Outline: Selecting existing shipping and existing billing address during checkout for registered user
#	Given User access <brand> website
	#And User add <item> to cart
	#When User provides <guestFields> into address fields
    When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User adds default shipping and billing address with valid <values>
	And User adds shipping address with valid <values>
	And User adds billing address with valid <newBilling>
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    #And User adds new address <newAddress> into fields
	Then User should verify selecting another shipping address applies to order
	Then User should verify selecting another billing address applies to order <newBilling>

	Examples:
	| brand  | item    | guestFields                                                                                     | newAddress                                                                                          |values                                                                      |newBilling                                                                                    | email                       | password | firstName | lastName | address    | apartment | city | country | state | zip | phone           | gender | bMonth | bDay | prefCountry | prefState | prefStore | communication | type |
	| SPEEDO | 7530477 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |myaccount;speedo3;1001 frontier rd;;Bridgewater;New Jersey;08807;7324567890 |myaccount;speedo3;1001 Frontier Road;15;Bridgewater;United States;New Jersey;08807;7324567890 | myaccountspeedo44@gmail.com  | Passw0rd | myaccount | speedo3  |            |           |      |         |       |     |  7324567890     |        |        |      |             |           |           |               |      |
	
#@id=6 @positive @parallel @checkout_module @desktop @checkOut @brand=SP @addressy
#Scenario Outline: Selecting existing billing address during checkout
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
#	And User adds new address <newBilling> into billing fields
#	And User adds new address <secondNewBilling> into billing fields
#	Then User should verify selecting another billing address applies to order <newBilling>

#	Examples:
#	| brand  | item    | guestFields                                                                               | newBilling                                                                                          | secondNewBilling                                                                                    |
#	| SPEEDO | joggers | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |

@id=7 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=SP @addressy
Scenario Outline: Checkout using Visa card
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    When User saves order total from checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
#	And User cancels the order

    Examples:
    | brand  | item    | guestFields                                                                                              | type | number           | code | expMonth | expYear |
	| SPEEDO | 7530477 | testing@gmail.com;Anish;Patel;1200 US Highway 22; ;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | 
 
@id=8 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Checkout using MasterCard
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    When User saves order total from checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
#	And User cancels the order

    Examples:
    | brand  | item    | guestFields                                                                                             | type       | number           | code | expMonth | expYear |
	| SPEEDO | 7530477 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | 

@id=9 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Checkout using Discover card
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    When User saves order total from checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

    Examples:
    | brand  | item    | guestFields                                                                                             | type     | number           | code | expMonth | expYear |
	| SPEEDO | 7530477 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | Discover | 6011123412331112 | 456  | 10       | 2020    | 
        
@id=10 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify checkout using American Express card
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    When User saves order total from checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

    Examples:
    | brand  | item    | guestFields                                                                                             | type             | number          | code  | expMonth | expYear |
	| SPEEDO | 7530477 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005 | 4561  | 10       | 2020    | 

@id=11 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify checkout using Paypal
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
	And User select shipping method <shippingMethod>
	And User submit order using paypal account <email> and <password>
	Then User verify summary of order submitted using paypal
	And User cancels the order
		
	Examples:
	| brand  | item    | guestFields                                                                                                | email                | password | shippingMethod |
	| SPEEDO | 7530477 | Testerpvh1@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | Testerpvh1@gmail.com | passw0rd | OVERNIGHT      |

@id=14 @parallel @positive @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify checkout using Shoprunner
#	Given User access <brand> website
#	And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
	And User checkout using Shoprunner <email> and <password>
	And User checkout Shoprunner
#	Then User verifies order summary page matches purchase and shoprunner
	And User cancels the order
	
	Examples:
	| brand  | item    | email                  | password    |
	| SPEEDO | 7530477 | testatech123@gmail.com | password123 |

@id=24 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify editing item quantity and removing an item during checkout
#    Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
	And User goes to cart page
	And User removes all items in cart
    And User searches an <item> with style number and adds it to cart
#    And User add <item> to cart
    And User proceeds to secure checkout
    And User edits an item at checkout
    Then User verifies that the item has been edited
    Then User removes and verifies that item is removed
	Then User verifies that the cart is empty

	Examples:
	| brand | email                       | password | item    |	
	| SPEEDO| myaccountspeedo44@gmail.com | Passw0rd | 7530477 |
		
#@id=25 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
#Scenario Outline: Verify removing an item during checkout
#    Given User access <brand> website
#    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#    And User proceeds to secure checkout
#    Then User removes and verifies that item is removed
    
#	Examples:
#	| brand  | email                       | password | item     |        
#	| SPEEDO | myaccountspeedo44@gmail.com | Passw0rd | 7530477  | 
	
#@id=26 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
#Scenario Outline: Verify applying a promo code during checkout
#	Given User access <brand> website
#	And User add <item> to cart
#	When User applies checkout promo code <code>
#	Then User verifies that promo code is applied in checkout
	
#	Examples:
#	| brand  | item      | code  | secondItem |
#	| SPEEDO | 7719782-2 | LTF25 | 7723019    |

#@id=27 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
#Scenario Outline: Verify removing a promo code during checkout
#	Given User access <brand> website
#	And User searches an <item> with style number and adds it to cart
#	And User proceeds to secure checkout
#	When User applies checkout promo code <code>
#	Then User verifies that promo code is applied in checkout
#	Then User verifies removing promo code applied
	
#	Examples:
#	| brand  | item    | code  | secondItem |
#	| SPEEDO | 7530477 | LTF25 | 7723019    |

#@id=28 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
#Scenario Outline: Verify updating quantity during checkout
#	Given User access <brand> website
#	And User add <product> to cart
#	And User adjusts to <quantity> on checkout page
#	Then User verifies item quantity is updated to <quantity>
	
#	Examples:
#	| brand  | item      | quantity |
#	| SPEEDO | 7530477    | 2        |

@id=29 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify adding new shipping address during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User proceeds to review order page
    And User adds new address <newAddress> into fields from review order page
    Then User verifies that new address has been selected <newAddress>

    Examples:
    | brand  | item    | guestFields                                                                                             | type | number           | code | expMonth | expYear | newAddress                                                                                          |
	| SPEEDO | 7530477 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
    
@id=30 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify adding new billing address during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User proceeds to review order page
    And User adds new address <newBilling> into billing fields from review order page
	Then User verifies that new billing address is selected <newBilling>

    Examples:
    | brand  | item      | guestFields                                                                                 | type | number           | code | expMonth | expYear | newBilling                                                                                          |
	| SPEEDO | 7530477   | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
    
@id=31 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify editing shipping method during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#	When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
	And User select shipping method <shippingMethod>
    And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User proceeds to review order page
    And User selects shipping method <shippingMethod2> from review order page
    And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User proceeds to review order page
    Then User verifies shipping method has been edited to <shippingMethod2>
		
	Examples:
	| brand  | item    | guestFields                                                                                             | shippingMethod | type | number           | code | expMonth | expYear | shippingMethod2 |
	| SPEEDO | 7530477 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | standard       | VISA | 4111111111111111 | 456  | 10       | 2020    | overnight       |
	
@id=32 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify editing payment method during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User edits payment information on review order page
#    And User clicks next
	And User enters payment information using credit card <type2>, <number2>, <code2>, <expMonth2>, <expYear2>
    And User proceeds to review order page
    Then User verifies the payment information was updated with <type2>, <number2>, <expMonth2>, <expYear2>
    
    Examples:
    | brand  | item    | guestFields                                                                                                 | type | number           | code | expMonth | expYear | type2      | number2          | code2 | expMonth2 | expYear2 |
	| SPEEDO | 7530477 | testing@gmail.com;Anish11;Patel11;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | MasterCard | 5555555555554444 | 456   | 10        | 2020     |

@id=33 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify navigating back from review order page
#    Given User access <brand> website
    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
    And User provide <email> , <password> and register
  	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User adds default shipping and billing address with valid <values>
    And User searches an <item> with style number and adds it to cart
    And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    Then User verifies can navigate back
	
	Examples:
	| brand  | email                       | password | item     | type | number           | code | expMonth | expYear | firstName | lastName | address    | apartment | city | country | state | zip | phone           | gender | bMonth | bDay | prefCountry | prefState | prefStore | communication | type |values                                                                          |          	
	| SPEEDO | myaccountspeedo44@gmail.com | Passw0rd | 7530477  | VISA | 4111111111111111 | 456  | 10       | 2020    | myaccount | speedo3  |            |           |      |         |       |     |  7324567890     |        |        |      |             |           |           |               |      |myaccount;speedo3;1200 US Highway 22;15;Bridgewater;New Jersey;08807;7324567890 |	

@id=34 @positive @parallel @checkout_module @desktop @checkOut @brand=SP
Scenario Outline: Verify editing order item from review order page
#    Given User access <brand> website
    When User navigate to login page
#	And User try to login using <email> and <password>
#   And User add <item> to cart 
    And User provide <email> , <password> and register
  	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User adds default shipping and billing address with valid <values>
    And User searches an <item> with style number and adds it to cart    
    And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User verifies can edit order
#    And User edits product to another size 
#	Then User verify edit change in bag
	
	Examples:
	| brand  | email                       | password | item     | type | number           | code | expMonth | expYear | firstName | lastName | address    | apartment | city | country | state | zip | phone           | gender | bMonth | bDay | prefCountry | prefState | prefStore | communication | type |values                                                                          |                   	
	| SPEEDO | myaccountspeedo44@gmail.com | Passw0rd | 7530477  | VISA | 4111111111111111 | 456  | 10       | 2020    | myaccount | speedo3  |            |           |      |         |       |     |  7324567890     |        |        |      |             |           |           |               |      |myaccount;speedo3;1200 US Highway 22;15;Bridgewater;New Jersey;08807;7324567890 | 