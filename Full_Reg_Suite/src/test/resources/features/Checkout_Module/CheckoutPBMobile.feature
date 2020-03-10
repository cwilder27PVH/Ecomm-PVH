@module=checkoutPBMobile
Feature: Checkout PB Mobile
	Description: This feature allows user to checkout
	
@id=1 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile @addressy
Scenario Outline: Adding new shipping address during guest checkout
    Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User adds new address <newAddress> into fields
    Then User verifies that new address has been selected <newAddress>
	
	Examples:
	| brand | item    | guestFields                                                                                | newAddress                                                                                      |
	| VH    | A7992409 | testpb@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | test3+pb@testmail.com;Cindy;Smith;1001 Fronhatr Road;;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=2 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile @addressy
Scenario Outline: Editing shipping address during checkout with signed in user
    Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    When User edits and adds the address fields <editAddress>
    Then User verifies the editted address is selected <editAddress>
    
    Examples:
	| brand | email                    | password | item     | editAddress                                                                                       | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay |
	| VH    | myaccountvh4@gmail.com   | Passw0rd | A7992409  | myaccountvh4@gmail.com;Bobby;Smith;1200 US Highway 22; ;Bridgewater;New Jersey; ;08807;1234567890 | Test PVH  | User     | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |

@id=3 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile @addressy
Scenario Outline: Adding new billing address during guest checkout
	Given User access <brand> website
	And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    When User provides <guestFields> into address fields
	And User adds new address <newBilling> into billing fields
	Then User verifies that new billing address is selected <newBilling>
	
	Examples:
	| brand | item    | guestFields                                                                                     | newBilling                                                                                        |
	| VH    | A7992409 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+VH@testmail.com;Cindy;Smith;1001 Fronhatr Road;;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=4 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile @addressy
Scenario Outline: Editing billing address during checkout with signed in user
    Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User adds new address <newBilling> into billing fields signed in
    When User edits and adds the billing address fields <editAddress>
    Then User verifies the editted billing address is selected <editAddress>
    
    Examples:
    | brand | email                  | password | item    | newBilling                                                                                          | editAddress                                                                                       | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay |
	| VH    | myaccountvh4@gmail.com | Passw0rd | A7992409 | myaccountvh4@gmail.com;Alex;Smith;2222 Quail Ridge Drive; ;Plainsboro;New Jersey; ;08536;1234567890 | myaccountvh4@gmail.com;Shaun;Smith;1001 Frontier Road; ;Bridgewater;New Jersey; ;08807;9082316660 | Test PVH  | User     | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |	
	

@id=5 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile @addressy
Scenario Outline: Selecting existing shipping and existing billing address during checkout for registered user
	Given User access <brand> website
    When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User adds shipping address on mobile with valid <values>
	And User adds billing address on mobile with valid <newBilling>
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
	Then User should verify selecting another shipping address applies to order
	Then User should verify selecting another billing address applies to order <newBilling>

	Examples:
	| brand | item    | guestFields                                                                                 | newAddress                                                                                  | values   				  					   	    		                    | newBilling   				  					   							                    | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay |
	| VH    | A7992409 | testpb1@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | vh01@testmail.com;Cindy;Smith;1001 Frontier Road;;Bridgewater;New Jersey; ;08807;9082316660 | myaccount;pb3;1130 US Highway 22;BOX 15;Bridgewater;New Jersey;08807;6094065555 | myaccount;pb3;1200 US Highway 22;BOX 15;Bridgewater;United States;New Jersey;08807;6094065555 | vhtest@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |
	
#@id=6 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile @addressy
#Scenario Outline: Selecting existing billing address during guest user checkout
#	Given User access <brand> website
#	When User searches on mobile for <item>
#	And User clicks on product on mobile
#	And User chooses random size
#	And User clicks add to bag
#	And User goes to cart page
#	When User provides <guestFields> into address fields
#	And User adds new address <newBilling> into billing fields
#	And User adds new address <secondNewBilling> into billing fields
#	Then User should verify selecting another billing address applies to order <newBilling>

#	Examples:
#	| brand | item   | guestFields                                                                                | newBilling                                                                                   | secondNewBilling                                                                             |
#	| VH    | A7992409   | testvh@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | test1@testmail.com;Shaun;Smith;1001 Fronhatr Road;;Bridgewater;New Jersey; ;08807;9082316660 | test2@testmail.com;Cindy;Smith;1001 Fronhatr Road;;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=7 @positive @smokeT @parallel @checkout_module @checkOut @brand=PBMobile @mobile @addressy
Scenario Outline: Checkout using Visa card for guest user
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
	Then User verify summary of order submitted using credit card <type>
#	And User cancels the order

	Examples:
	| brand | item      | guestFields                                                                          		   | type | number           | code | expMonth | expYear |
	| VH    | A7992409 	| testing@gmail.com;Anish;Patel;1200 US Highway 22; ;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    |

 
@id=8 @positive @smokeT @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Checkout using MasterCard for guest user
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
	Then User verify summary of order submitted using credit card <type>
#	And User cancels the order

	Examples:
	| brand | item    | guestFields                                                                                 | type       | number           | code | expMonth | expYear |
	| VH    | A7992409 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
   

@id=9 @positive @smokeT @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Checkout using Discover card for guest user
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

	Examples:
	| brand | item    | guestFields                                                                                 | type     | number           | code | expMonth | expYear |
    | VH    | A7992409 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | Discover | 6011123412331112 | 456  | 10       | 2020    |
 

@id=10 @positive @smokeT @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify checkout using American Express card for guest user
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

	Examples:
	| brand | item    | guestFields                                                                                 | type             | number          | code | expMonth | expYear |
	| VH    | A7992409 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | American Express | 378282246310005 | 4561 | 10       | 2020    | 

@id=11 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify checkout using PaypalScenario Outline: Verify checkout using Paypal
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
	And User select shipping method <shippingMethod>
	And User submit order using paypal account <email> and <password>
	Then User verify summary of order submitted using paypal
	And User cancels the order
		
	Examples:
	| brand | item    | guestFields                                                                                                  | email                | password | shippingMethod |
	| VH    | A7992409 | Testerpvh1@gmail.com;Anish;Patel;2284 Polk Avenue;;North Brunswick;New Jersey;United States;08902;7323257940 | Testerpvh1@gmail.com | passw0rd | standard       |
	
	
@id=12 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify checkout using GiftCard for guest user
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    When User provides <guestFields> into address fields
	And User provides GiftCard information <number> and <pin>
	Then User verifies GiftCard was applied

	Examples:
	| brand | item    | guestFields                                                                                             | number           | pin      |
	| VH    | A7992409 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | 7777127677516507 | 68726267 |


#@id=14 @parallel @positive @checkout_module @checkOut @brand=PBMobile @mobile
#Scenario Outline: Verify checkout using Shoprunner
#	Given User access <brand> website
#	And User add <item> to cart
#	And User checkout using Shoprunner <email> and <password>
#	And User checkout Shoprunner
#	Then User verifies order summary page matches purchase and shoprunner
#	And User cancels the order
	
#	Examples:
#	| brand | item   | email                  | password    |
#	| VH    | hat    | testatech123@gmail.com | password123 |

#@id=15 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
#Scenario Outline: Checkout using CreditCard and GiftCard for guest user
#	Given User access <brand> website
#	When User searches on mobile for <item>
#	And User clicks on product on mobile
#	And User chooses random size
#	And User clicks add to bag
#	And User goes to cart page
#    When User provides <addressFields> into address fields 
#	And User provides GiftCard information <giftCardNumber> and <giftCardPin>
#	Then User verifies GiftCard was applied
#	And User submit order using credit card <creditCardType>, <creditCardNumber>, <creditCardCode>, <creditCardExpMonth>, <creditCardeExpYear>
#	Then User verify summary of order submitted using credit card <creditCardType>
#	And User cancels the order
		
#	Examples:
#	| brand | item    | addressFields                                                                                           | creditCardType   | creditCardNumber | creditCardCode | creditCardExpMonth | creditCardeExpYear | giftCardNumber   | giftCardPin |
#	| VH  | hat       | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | VISA             | 4111111111111111 | 456            | 10                 | 2020               | 7777063816087566 | 67910187    |
#	| VH  | hat       | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard       | 5555555555554444 | 456            | 10                 | 2020               | 7777063816087566 | 67910187    |
#	| VH  | hat       | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | Discover         | 6011123412331112 | 456            | 10                 | 2020               | 7777063816087566 | 67910187    |
#	| VH  | hat       | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005  | 4561           | 10                 | 2020               | 7777063816087566 | 67910187    |
	
#@id=16 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
#Scenario Outline: Verify checkout using Paypal and GiftCard
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
#	And User provides GiftCard information <number> and <pin>
#	Then User verifies GiftCard was applied
#	And User navigates to Paypal Checkout
#	And User pays with Paypal <email> and <password>
#	Then User verifies order summary page matches purchase and paypal
#	And User cancels the order
	
#	Examples:
#	| brand | item   | guestFields                                                                                              | number           | pin      | email                | password |
#	| VH  | jacket | Testerpvh1@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | 7777063816079827 | 42679890 | Testerpvh1@gmail.com | passw0rd |
	
#@id=17 @positive @parallel @checkout_module
#Scenario Outline: Verify checkout using CreditCard and Loyalty
#	Given User access <brand> website
#    When User navigate to mobile login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#    And User selects loyalty rewards <rewardAmount>
#    And User provides payment information for loyalty <Type>, <Number>, <Code>, <expMonth>, <expYear>
#    Then User verifies that the award was applied with valid billing information <rewardAmount>
#	And User cancels the order
#	
#	@brand=VH
#	Examples:
#	| brand | item           | email                          | password  | rewardAmount | Type             | Number           | Code | expMonth | expYear |
#	| VH  | textured skirt | badrinathvenusep11@yopmail.com | Passw0rd  | 15.00        | VISA             | 4111111111111111 | 456  | 10       | 2020    |
#	| VH  | textured skirt | badrinathvenusep11@yopmail.com | Passw0rd  | 15.00        | MasterCard       | 5555555555554444 | 456  | 10       | 2020    |
#	| VH  | textured skirt | badrinathvenusep11@yopmail.com | Passw0rd  | 15.00        | Discover         | 6011123412331112 | 456  | 10       | 2020    |
#	| VH  | textured skirt | badrinathvenusep11@yopmail.com | Passw0rd  | 15.00        | American Express | 341111111111111  | 4563 | 10       | 2020    |
#
#@id=19 @positive @parallel @checkout_module
#Scenario Outline: Verify checkout using Credit Card, GiftCard, Loyalty
#	Given User access <brand> website
#    When User navigate to mobile login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#    And User selects loyalty rewards <rewardAmount>
#    And User enters gift card fields <giftNumber>, <giftPin>
#    And User provides payment information for loyalty <Type>, <Number>, <Code>, <expMonth>, <expYear>
#    Then User will verify gift card, credit card and loyalty used <rewardAmount>, <Type>
#    And User cancels the order
#    
#	
#	@brand=VH
#	Examples:
#	| brand | item     | email                          | password | rewardAmount | Type             | Number           | Code | expMonth | expYear | giftNumber       | giftPin  |
#	| VH  | 11866570 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        | VISA             | 4111111111111111 | 456  | 10       | 2020    | 7777063816079827 | 42679890 |
#	| VH  | 11866570 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        | MasterCard       | 5555555555554444 | 456  | 10       | 2020    | 7777063816079827 | 42679890 |
#	| VH  | 11866570 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        | Discover         | 6011123412331112 | 456  | 10       | 2020    | 7777063816079827 | 42679890 |
#	| VH  | 11866570 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        | American Express | 341111111111111  | 4563 | 10       | 2020    | 7777063816079827 | 42679890 |

#@id=21 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
#Scenario Outline: Verify checkout using Shoprunner and Giftcard
#	Given User access <brand> website
#	And User add <item> to cart
#	And User checkout using Shoprunner <email> and <password>
#	And User applies giftcard in Shoprunner with giftcard <number> and <pin>
#	And User checkout Shoprunner
#	Then User verifies order summary page matches purchase and shoprunner
#	And User cancels the order
	
#	Examples:
#	| brand | item  | email                  | password    | number           | pin      |
#	| VH  | watch | testatech123@gmail.com | password123 | 7777063816087566 | 67910187 |
	
	
@id=24 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Selecting to edit on checkout page and verify user gets navigated to Product Page
    Given User access <brand> website
    When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User goes to mobile cart page
	And User removes all items in cart
    And User searches on mobile an <item> with style number and adds it to cart
    And User proceeds to secure checkout
    And User edits an item on mobile at checkout
	Then User verifies user is on product page
    
	Examples:
    | brand | email                   | password | item     |         
	| VH    | myaccountVH44@gmail.com | Passw0rd | A7992409  |  
	
@id=25 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify removing an item during checkout
    Given User access <brand> website
    When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User searches on mobile an <item> with style number and adds it to cart
	 And User proceeds to secure checkout
    Then User removes and verifies that item is removed
    
	Examples:
	| brand | email                     | password | item    |        
	| VH    | myaccountVH44@gmail.com   | Passw0rd | A7992409 | 
	
#@id=26 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
#Scenario Outline: Verify applying a promo code during checkout
#	Given User access <brand> website
#	And User add <item> to cart
#	When User applies checkout promo code <code>
#	Then User verifies that promo code is applied in checkout
	
#	Examples: 
#	| brand | item | code   | secondItem |
#	| VH    | hat  | FALL20 | 72253719   |

#@id=27 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
#Scenario Outline: Verify removing a promo code during checkout
#	Given User access <brand> website
#	And User add <item> to cart
#	When User applies checkout promo code <code>
#	Then User verifies removing promo code applied
	
#	Examples: 
#	| brand | item         | code   | secondItem |
#	| VH    | hat          | FALL20 | 72253719   |

#@id=28 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
#Scenario Outline: Verify updating quantity during checkout
#	Given User access <brand> website
#	And User add <product> to cart
#	And User adjusts to <quantity> on checkout page
#	Then User verifies item quantity is updated to <quantity>
	
#	Examples:
#	| brand | product | quantity |
#	| VH  | shirt   | 2        |

@id=29 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify adding new shipping address during checkout from review order page
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User proceeds to review order page
    And User adds new address <newAddress> into fields from review order page
    Then User verifies that new address has been selected <newAddress>

	Examples:
	| brand | item    | guestFields                                                                                 | type | number           | code | expMonth | expYear | newAddress                                                                                      |
	| VH    | A7992409 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+VH@testmail.com;Cindy;Smith;1001 Frontier Road;;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=30 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify adding new billing address during checkout from review order page
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User proceeds to review order page
    And User adds new address <newBilling> into billing fields from review order page
	Then User verifies that new billing address is selected <newBilling>

	Examples:
	| brand | item    | guestFields                                                                               | type | number           | code | expMonth | expYear | newBilling                                                                                      |
	| VH    | A7992409 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+VH@testmail.com;Cindy;Smith;1001 Frontier Road;;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=31 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify editing shipping method during checkout from review order page
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
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
	| brand | item    | guestFields                                                                                 | shippingMethod | type | number           | code | expMonth | expYear | shippingMethod2 |
	| VH    | A7992409 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;7323257940 | standard       | VISA | 4111111111111111 | 456  | 10       | 2020    | overnight       |
	
@id=32 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify editing payment method during checkout from review order page
	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <addressFields> into address fields
    And User searches on mobile an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User edits payment information on review order page
 #   And User clicks next
	And User enters payment information using credit card <type2>, <number2>, <code2>, <expMonth2>, <expYear2>
    And User proceeds to review order page
    Then User verifies the payment information was updated with <type2>, <number2>, <expMonth2>, <expYear2>
    
	Examples:
	| brand | item     | guestFields                                                                                 | type | number           | code | expMonth | expYear | type2       | number2          | code2 | expMonth2 | expYear2 |
	| VH    | A7992409  | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | MasterCard  | 5555555555554444 | 456   | 10        | 2020     |
	
@id=33 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify navigating back from review order page
    Given User access <brand> website
    When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User searches on mobile an <item> with style number and adds it to cart
    And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
 #   Then User verifies can navigate back
	
	Examples:
	| brand | email                   |  password | item    | type | number           | code | expMonth | expYear | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay |     	
	| VH    | myaccountVH44@gmail.com |  Passw0rd | A7992409 | VISA | 4111111111111111 | 456  | 10       | 2020    | Test PVH  | User     | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    | 	

@id=34 @positive @parallel @checkout_module @checkOut @brand=PBMobile @mobile
Scenario Outline: Verify editing order item from review order page
    Given User access <brand> website
    When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
#	And User try to login using <email> and <password>
#    And User add <item> to cart
    And User searches on mobile an <item> with style number and adds it to cart
    And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User verifies can edit order
#    And User edits product to another color 
#    And User proceeds to secure checkout
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
#	Then User verify updated product color
	
	Examples:
	| brand | email                   | password | item     | type | number           | code | expMonth | expYear | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay |       	
	| VH    | myaccountvh43@gmail.com | Passw0rd | A7992409  | VISA | 4111111111111111 | 456  | 10       | 2020    | Test PVH  | User     | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |  