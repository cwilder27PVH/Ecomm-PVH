@module=checkoutTH
Feature: Checkout TH
	Description: This feature allows user to checkout
	
Background:
	Given User navigates to Tommy Hilfiger Webstore
	And User logs out if already logged in
	
@id=1 @positive @parallel @checkout_module @desktop @checkOut @addressy
Scenario Outline: Adding new shipping address during guest checkout
#    Given User access <brand> website
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User adds new address <newAddress> into fields
    Then User verifies that new address has been selected <newAddress>

	Examples:
	| brand | item    | guestFields                                                                                                 | newAddress                                                                              					    |
	| TH    | aw08418 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;;Bridgewater;New Jersey;United States;08807;9082316660 |
	
@id=2 @positive @parallel @checkout_module @desktop @checkOut @addressy
Scenario Outline: Editing shipping address during checkout with signed in user
#    Given User access <brand> website
    When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    When User edits and adds the address fields <editAddress>
    Then User verifies the editted address is selected <editAddress>
    
	Examples:
	| brand | email                   | password | item    | editAddress                                                                                                    | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |	
	| TH    | myaccountth44@gmail.com | Passw0rd | aw08418 | ckSpeedoTH2@yopmail.com;Bobby;Smith;1200 US Highway 22; ;Bridgewater;New Jersey;United States;08807;1234567890 | myaccount | th6      | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 1    | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ |  web          | men  |

@id=3 @positive @parallel @checkout_module @desktop @checkOut @addressy
Scenario Outline: Adding new billing address during guest checkout
#	Given User access <brand> website
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
	And User adds new address <newBilling> into billing fields
	Then User verifies that new billing address is selected <newBilling>
	
	Examples:
	| brand | item    | guestFields                                                                                                 | newBilling                                                                                                      |
	| TH    | aw08418 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |

@id=4 @positive @parallel @checkout_module @desktop @checkOut @addressy
Scenario Outline: Editing billing address during checkout with signed in user
#    Given User access <brand> website
    When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User adds new address <newBilling> into billing fields signed in
    When User edits and adds the billing address fields <editAddress>
    Then User verifies the editted billing address is selected <editAddress>
    
	Examples:
	| brand | email                   | password | item    | editAddress                                                                                                      | newBilling                                                                                                     | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |	
	| TH    | myaccountth44@gmail.com | Passw0rd | aw08418 | ckSpeedoTH2@yopmail.com;Alex;Smith;2222 Quail Ridge Drive; ;Plainsboro;New Jersey;United States;08536;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road; ;Bridgewater;New Jersey;United States;08807;9082316660 | myaccount | th6      | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 1    | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ |  web          | men  |	

	
@id=5 @positive @parallel @checkout_module @desktop @checkOut @addressy
Scenario Outline: Selecting existing shipping and existing billing address during checkout for registered user
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
#    And User adds new address <newAddress> into fields
    When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User adds shipping address with valid <values>
	And User adds billing address with valid <newBilling>
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
	Then User should verify selecting another shipping address applies to order
	Then User should verify selecting another billing address applies to order <newBilling>

	Examples:
	| brand | item    | guestFields                                                                                                 | newAddress                                                                                                      |values                                                                                      | newBilling                                                                                | email                   | password | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| TH    | aw08418 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |myaccount;th3;1001 Frontier Road;15;Bridgewater;United States;New Jersey;08807;7324567890   | myaccount;th3;1001 Frontier Road;15;Bridgewater;United States;New Jersey;08807;7324567890 | myaccountth6@gmail.com  | Passw0rd | myaccount | th6      | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 1    | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ |  web          | men  |

#@id=6 @positive @parallel @checkout_module @desktop @checkOut @addressy
#Scenario Outline: Selecting existing billing address during checkout
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
#	And User adds new address <newBilling> into billing fields
#	And User adds new address <secondNewBilling> into billing fields
#	Then User should verify selecting another billing address applies to order <newBilling>

#	Examples:
#	| brand | item          | guestFields                                                                                           | newBilling                                                                                                      | secondNewBilling                                                                                                |
#	| TH    | joggers women | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |

@id=7 @positive @smokeT @parallel @checkout_module @desktop @checkOut @addressy
Scenario Outline: Checkout using Visa card
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <addressFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
#	And User cancels the order

	Examples:
	| brand | item    | guestFields                                                                                              | type | number           | code | expMonth | expYear |
	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22; ;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    |
    
   
@id=8 @positive @smokeT @parallel @checkout_module @desktop @checkOut
Scenario Outline: Checkout using MasterCard
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <addressFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
#	And User cancels the order

	Examples:
	| brand | item    | guestFields                                                                                             | type       | number           | code | expMonth | expYear |
    | TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |


@id=9 @positive @smokeT @parallel @checkout_module @desktop @checkOut
Scenario Outline: Checkout using Discover card
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <addressFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

	Examples:
	| brand | item    | guestFields                                                                                             | type     | number           | code | expMonth | expYear |
    | TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | Discover | 6011123412331112 | 456  | 10       | 2020    |
    
	
@id=10 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=TH
Scenario Outline: Verify checkout using American Express card
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <addressFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User verify summary of order submitted using credit card <type>
	And User cancels the order

	Examples:
	| brand | item    | guestFields                                                                                             | type             | number          | code | expMonth | expYear |	
	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005 | 4561 | 10       | 2020    |

	
@id=11 @positive @smokeT @parallel @checkout_module @desktop @checkOut
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
	| brand | item     | guestFields                                                                                                | email                | password | shippingMethod |
	| TH    | aw08418  | Testerpvh1@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | Testerpvh1@gmail.com | passw0rd | standard       |
	
	
@id=12 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify checkout using GiftCard#	Given User access <brand> website
#	And User add <item> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
	And User provides GiftCard information <number> and <pin>
	Then User verifies GiftCard was applied

	Examples:   
	| brand | item    | guestFields                                                                                             | number              | pin  |   
	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | 6006492136503706713 | 1256 |
	
#@id=13 @positive @parallel @checkout_module @desktop
#Scenario Outline: Verify checkout using Loyalty
#	Given User access <brand> website
#    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#    And User selects loyalty rewards <rewardAmount>
#    Then User verifies that a hundred dollar loyalty award is applied
#    And User cancels the order
#	
#	@brand=CKUS
#	Examples:
#	| brand | item   | email                          | password | rewardAmount |
#	| CKUS  | wallet | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        |

@id=14 @parallel @positive @checkout_module @desktop @checkOut
Scenario Outline: Verify checkout using Shoprunner
#	Given User access <brand> website
#	And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
	And User checkout using Shoprunner <email> and <password>
	And User checkout Shoprunner
#	Then User verifies order summary page matches purchase and shoprunner
	And User cancels the order
	
	Examples:
	| brand | item    | email                  | password    |
	| TH    | aw08418 | testatech123@gmail.com | password123 |
	
#@id=15 @positive @parallel @checkout_module @desktop @checkOut
#Scenario Outline: Checkout using CreditCard and GiftCard
#	Given User access <brand> website
#	And User add <item> to cart
#    When User provides <addressFields> into address fields 
 #   And User searches an <item> with style number and adds it to cart
#    When User proceeds to secure checkout
#    And User proceeds to guest checkout
#    And User provides <guestFields> into address fields
#	And User provides GiftCard information <giftCardNumber> and <giftCardPin>
#	Then User verifies GiftCard was applied
#    And User clicks next
#	And User submit order using credit card <creditCardType>, <creditCardNumber>, <creditCardCode>, <creditCardExpMonth>, <creditCardeExpYear>
#	Then User verify summary of order submitted using credit card <creditCardType>
#	And User cancels the order
		
#	Examples: Tommy Hilfiger
#	| brand | item    | guestFields                                                                                             | creditCardType   | creditCardNumber | creditCardCode | creditCardExpMonth | creditCardeExpYear | giftCardNumber     | giftCardPin |
#	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | VISA             | 4111111111111111 | 456            | 10                 | 2020               | 6006492136503706713| 1256        |
#	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard       | 5555555555554444 | 456            | 10                 | 2020               | 6006492136503706713| 1256        |
#	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | Discover         | 6011123412331112 | 456            | 10                 | 2020               | 6006492136503706713| 1256        |
#	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005  | 4561           | 10                 | 2020               | 6006492136503706713| 1256        |

#@id=16 @positive @parallel @checkout_module @desktop @checkOut
#Scenario Outline: Verify checkout using Paypal and GiftCard
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
#    And User searches an <item> with style number and adds it to cart
#   When User proceeds to secure checkout
#    And User proceeds to guest checkout
#    And User provides <guestFields> into address fields
#	And User provides GiftCard information <number> and <pin>
#	Then User verifies GiftCard was applied
#	And User navigates to Paypal Checkout
#	And User pays with Paypal <email> and <password>
#	Then User verifies order summary page matches purchase and paypal
#	And User cancels the order
	
#	Examples:
#	| brand | item     | guestFields                                                                                                | number              | pin  | email                | password |
#	| TH    | aw08418  | Testerpvh1@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | 6006492136503706713 | 1256 | Testerpvh1@gmail.com | passw0rd |
		
#@id=17 @positive @parallel @checkout_module @desktop
#Scenario Outline: Verify checkout using CreditCard and Loyalty
#	Given User access <brand> website
#    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#    And User selects loyalty rewards <rewardAmount>
#    And User provides payment information for loyalty <Type>, <Number>, <Code>, <expMonth>, <expYear>
#    Then User verifies that the award was applied with valid billing information <rewardAmount>
#	And User cancels the order
#	
#	@brand=CKUS
#	Examples:
#	| brand | item           | email                          | password  | rewardAmount | Type             | Number           | Code | expMonth | expYear |
#	| CKUS  | textured skirt | badrinathvenusep11@yopmail.com | Passw0rd  | 15.00        | VISA             | 4111111111111111 | 456  | 10       | 2020    |
#	| CKUS  | textured skirt | badrinathvenusep11@yopmail.com | Passw0rd  | 15.00        | MasterCard       | 5555555555554444 | 456  | 10       | 2020    |
#	| CKUS  | textured skirt | badrinathvenusep11@yopmail.com | Passw0rd  | 15.00        | Discover         | 6011123412331112 | 456  | 10       | 2020    |
#	| CKUS  | textured skirt | badrinathvenusep11@yopmail.com | Passw0rd  | 15.00        | American Express | 341111111111111  | 4563 | 10       | 2020    |
#
#@id=19 @positive @parallel @checkout_module @desktop
#Scenario Outline: Verify checkout using Credit Card, GiftCard, Loyalty
#	Given User access <brand> website
#    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#    And User selects loyalty rewards <rewardAmount>
#    And User enters gift card fields <giftNumber>, <giftPin>
#    And User provides payment information for loyalty <Type>, <Number>, <Code>, <expMonth>, <expYear>
#    Then User will verify gift card, credit card and loyalty used <rewardAmount>, <Type>
#    And User cancels the order
#    
#	
#	@brand=CKUS
#	Examples:
#	| brand | item     | email                          | password | rewardAmount | Type             | Number           | Code | expMonth | expYear | giftNumber       | giftPin  |
#	| CKUS  | 11866570 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        | VISA             | 4111111111111111 | 456  | 10       | 2020    | 7777063816079827 | 42679890 |
#	| CKUS  | 11866570 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        | MasterCard       | 5555555555554444 | 456  | 10       | 2020    | 7777063816079827 | 42679890 |
#	| CKUS  | 11866570 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        | Discover         | 6011123412331112 | 456  | 10       | 2020    | 7777063816079827 | 42679890 |
#	| CKUS  | 11866570 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        | American Express | 341111111111111  | 4563 | 10       | 2020    | 7777063816079827 | 42679890 |

#@id=21 @positive @parallel @checkout_module @desktop @checkOut
#Scenario Outline: Verify checkout using Shoprunner and Giftcard
#	Given User access <brand> website
#	And User add <item> to cart
#	And User checkout using Shoprunner <email> and <password>
#	And User applies giftcard in Shoprunner with giftcard <number> and <pin>
#	And User checkout Shoprunner
#	Then User verifies order summary page matches purchase and shoprunner
#	And User cancels the order
	
	
@id=23 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify checkout from minicart
#	Given User access <brand> website
	When User searches for <item> 
	Then User verifies they are on the checkout page

	Examples:
	| brand | item    |
	| TH    | aw08418 |
	
@id=24 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify editing ite quantity and removing an item during checkout
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
	| brand | email                   | password | item    |
	| TH    | myaccountth44@gmail.com | Passw0rd | aw08418 |
    

#@id=25 @positive @parallel @checkout_module @desktop @checkOut
#Scenario Outline: Verify removing an item during checkout
#    Given User access <brand> website
#    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#    And User proceeds to secure checkout
#    Then User removes and verifies that item is removed
    
#	Examples:
#	| brand | email                  | password | item    |        
#	| TH    | myaccountth44@gmail.com | Passw0rd | 7646083 | 
	
#@id=26 @positive @parallel @checkout_module @desktop @checkOut
#Scenario Outline: Verify applying a promo code during checkout
#	Given User access <brand> website
#	And User add <item> to cart
 #   And User searches an <item> with style number and adds it to cart
#    And User proceeds to secure checkout
#	When User applies checkout promo code <code>
#	Then User verifies that promo code is applied in checkout
	

#	Examples: 
#	| brand | item    | code      | secondItem |
#	| TH    | FM01016 | CCP2B61QF | UU00004    |
	  

#@id=27 @positive @parallel @checkout_module @desktop @checkOut
#Scenario Outline: Verify removing a promo code during checkout
#	Given User access <brand> website
#    And User searches an <item> with style number and adds it to cart
#    And User proceeds to secure checkout
#	When User applies checkout promo code <code>
#	Then User verifies that promo code is applied in checkout
#	Then User verifies removing promo code applied
	
#	Examples: 
#	| brand | item    | code      | secondItem |
#	| TH    | aw08418 | CCP2B61QF | UU00004    |

#@id=28 @positive @parallel @checkout_module @desktop @checkOut
#Scenario Outline: Verify updating quantity during checkout
#	Given User access <brand> website
#	And User add <product> to cart
#	And User adjusts to <quantity> on checkout page
#	Then User verifies item quantity is updated to <quantity>
	
#	Examples:
#	| brand | product       | quantity |
#	| TH    | jogger womens | 2        |

@id=29 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify adding new shipping address during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <addressFields> into address fields
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
	| brand | item    | guestFields                                                                                             | type | number           | code | expMonth | expYear | newAddress                                                                                                      |
	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
    
@id=30 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify adding new billing address during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <addressFields> into address fields
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
	| brand | item    | guestFields                                                                                             | type | number           | code | expMonth | expYear | newBilling                                                                                                      |
	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey;United States;08807;9082316660 |
    
@id=31 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify editing shipping method during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#	When User provides <addressFields> into address fields
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
	| brand | item    | guestFields                                                                                             | shippingMethod | type | number           | code | expMonth | expYear | shippingMethod2 |
	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | standard       | VISA | 4111111111111111 | 456  | 10       | 2020    | overnight       |
  	
@id=32 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify editing payment method during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#    When User provides <addressFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
#	And User select shipping method <shippingMethod>
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User edits payment information on review order page
#    And User clicks next
	And User enters payment information using credit card <type2>, <number2>, <code2>, <expMonth2>, <expYear2>
    And User proceeds to review order page
    Then User verifies the payment information was updated with <type2>, <number2>, <expMonth2>, <expYear2>
    
	Examples:
	| brand | item    | guestFields                                                                                             | type | number           | code | expMonth | expYear | type2      | number2          | code2 | expMonth2 | expYear2 |
	| TH    | aw08418 | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | MasterCard | 5555555555554444 | 456   | 10        | 2020     |
 
@id=33 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify navigating back from review order page
#    Given User access <brand> website
    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User searches an <item> with style number and adds it to cart
    And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    Then User verifies can navigate back
	
	Examples:
	| brand | email                   | password | item    | type | number           | code | expMonth | expYear | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |             	
	| TH    | myaccountth44@gmail.com | Passw0rd | aw08418 | VISA | 4111111111111111 | 456  | 10       | 2020    | myaccount | th6      | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 1    | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ |  web          | men  |
	
@id=34 @positive @parallel @checkout_module @desktop @checkOut
Scenario Outline: Verify editing order item from review order page
#    Given User access <brand> website
    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User searches an <item> with style number and adds it to cart
    And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User verifies can edit order
#   And User edits product to another size 
#	Then User verify edit change in bag
	
	Examples:
	| brand | email                   | password | item    | type | number           | code | expMonth | expYear | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |             	
	| TH    | myaccountth44@gmail.com | Passw0rd | aw08418 | VISA | 4111111111111111 | 456  | 10       | 2020    | myaccount | th6      | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 1    | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ |  web          | men  |
	
@id=35 @positive @parallel @cart_module @cart @brand=TH @desktop
Scenario Outline: Verify hazmat message is displaying on the shopping bag page.
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	Then User should be login successfully
    When User searches with keyword as <product> 
#	And User saves product details from PDP 
	And User clicks on product
#	And User chooses random size
	And User clicks add to bag 
	And User goes to cart page
  And User checkout using Shoprunner <email> and <password> 
  And User clicks on edit shopping bag on shopprunner express checkout page
  
	Examples:
	| brand	| email              | password | product    |
	| TH    | testatech123@gmail.com | password123 | fragrance |