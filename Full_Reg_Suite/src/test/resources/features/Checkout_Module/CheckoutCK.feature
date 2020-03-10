@module=checkoutCK
Feature: Checkout CK
	Description: This feature allows user to checkout
	
Background:
	Given User navigates to Calvin Klein US Webstore
	And User logs out if already logged in
	
@id=1 @positive @parallel @checkout_module @desktop @checkOut @brand=CK @addressy
Scenario Outline: Adding new shipping address during guest checkout
#    Given User access <brand> website
#    And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
    And User adds new address <newAddress> into fields
    Then User verifies that new address has been selected <newAddress>
	
	Examples:
	| brand | item         | guestFields                                                                                     | newAddress                                                                                          |
	| CKUS  | 37403933-618 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=2 @positive @parallel @checkout_module @desktop @checkOut @brand=CK @addressy
Scenario Outline: Editing shipping address during checkout with signed in user
#    Given User access <brand> website
    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    When User edits and adds the address fields <editAddress>
    Then User verifies the editted address is selected <editAddress>
    
    Examples:
	| brand | email                     | password | item         | editAddress                                                                                        | firstName | lastName | address                | apartment | city        | country       | state      | zip     | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS  | myaccountckus44@gmail.com | Passw0rd | 37403933-618 | ckSpeedoTH2@yopmail.com;Bobby;Smith;1200 US Highway 22; ;Bridgewater;New Jersey; ;08807;1234567890 | myaccount | ckus6    | 1200 US Highway 22             | 1 | Bridgewater | United States | New Jersey | 08807   | 7326368321 | Male   |   1     | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |
	
@id=3 @positive @parallel @checkout_module @desktop @checkOut @brand=CK @addressy
Scenario Outline: Adding new billing address during guest checkout
#	Given User access <brand> website
#	And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
	And User adds new address <newBilling> into billing fields
	Then User verifies that new billing address is selected <newBilling>
	
	Examples:
	| brand | item         | guestFields                                                                                     | newBilling                                                                                          |
	| CKUS  | 37403933-618 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=4 @positive @parallel @checkout_module @desktop @checkOut @brand=CK @addressy
Scenario Outline: Editing billing address during checkout with signed in user
#    Given User access <brand> website
    When User navigate to login page
#	And User try to login using <email> and <password>
#  	And User add <item> to cart
#    And User goes to check out from cart
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User adds new address <newBilling> into billing fields signed in
    When User edits and adds the billing address fields <editAddress>
    Then User verifies the editted billing address is selected <editAddress>
    
    Examples:
	| brand | email                     | password | item         | editAddress                                                                                          | newBilling                                                                                         | firstName | lastName | address                | apartment | city        | country       | state      | zip     | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS  | myaccountckus44@gmail.com | Passw0rd | 37403933-618 | ckSpeedoTH2@yopmail.com;Alex;Smith;2222 Quail Ridge Drive; ;Plainsboro;New Jersey; ;08536;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road; ;Bridgewater;New Jersey; ;08807;9082316660 | myaccount | ckus6    | 1200 US Highway 22             | 1 | Bridgewater | United States | New Jersey | 08807   | 7326368321 | Male   |   1     | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |
    

#@id=4 @positive @parallel @checkout_module @desktop
#Scenario Outline: Editing billing address during checkout for CKCA
#	Given User access <brand> website
#    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
#    And User sends editted <billingAddress> and <shippingAddress> into CKCA fields
#	And User sends payment information for CKCA
#	Then User verifies the editted billing address is selected <billingAddress>
#	
#	@brand=CKCA
#    Examples:
#	| brand | email                   | password | item          | shippingAddress                                                                                 | billingAddress                                                                                  |
#	| CKCA  | checkoutckca4@gmail.com | Passw0rd | 3-pack combed | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932  Richmond Road; ;Calgary;Alberta; ;T2T 0C6;19085262900 | chck3+ckus@testmail.com;Shaun;Smith;461  Goyeau Ave; ;Windsor;Ontario;Canada;N9A 1H9;9082316660 |
	
@id=5 @positive @parallel @checkout_module @desktop @checkOut @brand=CK @addressy
Scenario Outline: Selecting existing shipping and existing billing address during checkout for registered user
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
 #   And User adds new address <newAddress> into fields
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
	| brand | item         | guestFields                                                                                     | newAddress                                                                                          |values                                                                      | newBilling                                                                                  | email                    | password | firstName | lastName | address                | apartment | city        | country       | state      | zip     | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS  | 37403933-618 | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |myaccount;ckus3;1001 Frontier Road;;Bridgewater;New Jersey;08807;1234567890 | myaccount;ck3;1001 Frontier rd;BOX 15;Bridgewater;United States;New Jersey;08807;7324567890 | myaccountckus6@gmail.com | Passw0rd | myaccount | ckus6    | 1200 US Highway 22             | 1 | Bridgewater | United States | New Jersey | 08807   | 7326368321 | Male   |   1     | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |
	
#@id=6 @positive @parallel @checkout_module @desktop @checkOut @brand=CK @addressy
#Scenario Outline: Selecting existing billing address during checkout
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
#	And User adds new address <newBilling> into billing fields
#	And User adds new address <secondNewBilling> into billing fields
#	Then User should verify selecting another billing address applies to order <newBilling>

#	Examples:
#	| brand | item          | guestFields                                                                               | newBilling                                                                                          | secondNewBilling                                                                                    |
#	| CKUS  | 3-pack combed | chck1speedo@gmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | chck3+ckus@testmail.com;Shaun;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=7 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=CK @addressy
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
	| brand | item         | guestFields                                                                                  | type | number           | code | expMonth | expYear |
	| CKUS  | 37403933-618 | testing@gmail.com;Anish;Patel;1200 US Highway 22; ;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    |
	
#@id=7 @positive @parallel @checkout_module @desktop
#Scenario Outline: Checkout using visa card CKCA
#    Given User access <brand> website
#    And User add <item> to cart
#    When User edits CKCA shipping and adds the address fields <Address>
#    And User enters CKCA payment information using credit card <name>, <number>, <code>, <expMonth>, <expYear>
#    Then User verifies CKCA checkout
    
#    @brand=CKCA
#	Examples:
#	| brand | item     | Address                                                                                        | name        | number           | code | expMonth | expYear |
#	| CKCA  | 25016876 | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932 Richmond Road;;Calgary;Alberta; ;T2T 0C6;9085262900 | Cindy Smith | 4111111111111111 | 456  | 10       | 2020    |
    
@id=8 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=CK
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
	| brand | item          | guestFields                                                                                 | type       | number           | code | expMonth | expYear |
	| CKUS  | 37403933-618  | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
  
#@id=8 @positive @parallel @checkout_module @desktop
#Scenario Outline: Checkout using mastercard CKCA
#    Given User access <brand> website
#    And User add <item> to cart
#    When User edits CKCA shipping and adds the address fields <Address>
#    And User enters CKCA payment information using credit card <name>, <number>, <code>, <expMonth>, <expYear>
#    Then User verifies CKCA checkout
#    
#    @brand=CKCA
#	Examples:
#	| brand | item     | Address                                                                                        | name        | number           | code | expMonth | expYear |
#	| CKCA  | 25016876 | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932 Richmond Road;;Calgary;Alberta; ;T2T 0C6;9085262900 | Cindy Smith | 5555555555554444 | 456  | 10       | 2020    |

@id=9 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=CK
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
	| brand | item 	    	| guestFields                                                                                  | type     | number           | code | expMonth | expYear |
    | CKUS  | 37403933-618  | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey; ;08807;1234567890 | Discover | 6011123412331112 | 456  | 10       | 2020    |
    
#@id=9 @positive @parallel @checkout_module @desktop
#Scenario Outline: Checkout using Discover card CKCA
#    Given User access <brand> website
#    And User add <item> to cart
#    When User edits CKCA shipping and adds the address fields <Address>
#    And User enters CKCA payment information using credit card <name>, <number>, <code>, <expMonth>, <expYear>
#    Then User verifies CKCA checkout
#    
#    @brand=CKCA
#	Examples:
#	| brand | item     | Address                                                                                        | name        | number           | code | expMonth | expYear |
#	| CKCA  | 25016876 | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932 Richmond Road;;Calgary;Alberta; ;T2T 0C6;9085262900 | Cindy Smith | 6011123412331112 | 456  | 10       | 2020    |
	
@id=10 @positive @smokeT @parallel @checkout_module @desktop @checkOut @brand=CK
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
	| brand | item 	    	| guestFields                                                                                  | type             | number          | code | expMonth | expYear |
	| CKUS  | 37403933-618  | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey; ;08807;1234567890 | American Express | 378282246310005 | 4561 | 10       | 2020    | 

#@id=10 @positive @parallel @checkout_module @desktop
#Scenario Outline: Checkout using American Express card CKCA
#    Given User access <brand> website
#    And User add <item> to cart
#    When User edits CKCA shipping and adds the address fields <Address>
#    And User enters CKCA payment information using credit card <name>, <number>, <code>, <expMonth>, <expYear>
#    Then User verifies CKCA checkout
#    
#    @brand=CKCA
#	Examples:
#	| brand | item     | Address                                                                                        | name        | number          | code | expMonth | expYear |
#	| CKCA  | 25016876 | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932 Richmond Road;;Calgary;Alberta; ;T2T 0C6;9085262900 | Cindy Smith | 378282246310005 | 4561 | 10       | 2020    |
	
@id=11 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify checkout using Paypal
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
#	And User select shipping method <shippingMethod>
	And User submit order using paypal account <email> and <password>
	Then User verify summary of order submitted using paypal
	And User cancels the order
		
	Examples:
	| brand | item         | guestFields                                                                                                  | email                | password | shippingMethod |
	| CKUS  | 37403933-618 | Testerpvh1@gmail.com;Anish;Patel;2284 Polk Avenue;;North Brunswick;New Jersey;United States;08902;7323257940 | Testerpvh1@gmail.com | passw0rd | standard       |
	
#@id=11 @positive @parallel @checkout_module @desktop
#Scenario Outline: Verify checkout using Paypal
#	Given User access <brand> website
#    And User add <item> to cart
#    When User edits CKCA shipping and adds the address fields <editAddress>
#    And User navigates to Paypal Checkout	
#    And User pays with Paypal <email> and <password>
#    And User cancels the order
#		
#	@brand=CKCA
#	Examples:
#	| brand | item | editAddress                                                                                     | email                | password |
#	| CKCA  | bag  | chck3+ckus@testmail.com;Shaun;Smith;461 Goyeau Ave;22;Windsor;Ontario;Canada;N9A 1H9;9082316660 | Testerpvh1@gmail.com | passw0rd |
	
@id=12 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify checkout using GiftCard
#	Given User access <brand> website
#	And User add <item> to cart
#    When User provides <guestFields> into address fields
    And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
	And User provides GiftCard information <number> and <pin>
	Then User verifies GiftCard was applied

	Examples:
	| brand | item         | guestFields                                                                                              | number           | pin      |
	| CKUS  | 37403933-618 | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey;United States;08807;1234567890 | 7777063816079827 | 42679890 |
	
#	@brand=CKCA
#	Examples:
#	| brand | item   | guestFields                                                                                           | number           | pin      |
#	| CKCA  | 37403933-618 | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey;United States;08807;1234567890 | 7777063816079827 | 42679890 |

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
#	| CKUS  | 37403933-618 | badrinathvenusep11@yopmail.com | Passw0rd | 15.00        |

@id=14 @parallel @positive @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify checkout using Shoprunner
#	Given User access <brand> website
#	And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
	And User checkout using Shoprunner <email> and <password>
	And User checkout Shoprunner
	Then User verifies order summary page matches purchase and shoprunner
	And User cancels the order
	
	Examples:
	| brand | item         | email                  | password    |
	| CKUS  | 37403933-618 | testatech123@gmail.com | password123 |

#@id=15 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
#Scenario Outline: Checkout using CreditCard and GiftCard
#	Given User access <brand> website
#	And User add <item> to cart
#    When User provides <addressFields> into address fields 
#    And User searches an <item> with style number and adds it to cart
#    When User proceeds to secure checkout
#    And User proceeds to guest checkout
#    And User provides <guestFields> into address fields
#	And User provides GiftCard information <giftCardNumber> and <giftCardPin>
#	Then User verifies GiftCard was applied
#    And User clicks next
#	And User submit order using credit card <creditCardType>, <creditCardNumber>, <creditCardCode>, <creditCardExpMonth>, <creditCardeExpYear>
#	Then User verify summary of order submitted using credit card <creditCardType>
#	And User cancels the order
		
#	Examples: Calvin Klein - US
#	| brand | item         | guestFields                                                                                              | creditCardType   | creditCardNumber | creditCardCode | creditCardExpMonth | creditCardeExpYear | giftCardNumber   | giftCardPin |
#	| CKUS  | 74019206-815 | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey;United States;08807;1234567890 | VISA             | 4111111111111111 | 456            | 10                 | 2020               | 7777063816087566 | 67910187    |
#	| CKUS  | 74019206-815 | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard       | 5555555555554444 | 456            | 10                 | 2020               | 7777063816087566 | 67910187    |
#	| CKUS  | 74019206-815 | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey;United States;08807;1234567890 | Discover         | 6011123412331112 | 456            | 10                 | 2020               | 7777063816087566 | 67910187    |
#	| CKUS  | 74019206-815 | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005  | 4561           | 10                 | 2020               | 7777063816087566 | 67910187    |

#@id=16 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
#Scenario Outline: Verify checkout using Paypal and GiftCard
#	Given User access <brand> website
#	And User add <item> to cart
#	When User provides <guestFields> into address fields
 #   And User searches an <item> with style number and adds it to cart
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
#	| brand | item     | guestFields                                                                                              | number           | pin      | email                | password |
#	| CKUS  | 37403933-618 | Testerpvh1@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey;United States;08807;1234567890 | 7777063816079827 | 42679890 | Testerpvh1@gmail.com | passw0rd |
	
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

#@id=21 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
#Scenario Outline: Verify checkout using Shoprunner and Giftcard
#	Given User access <brand> website
#	And User add <item> to cart
#    And User searches an <item> with style number and adds it to cart
#	And User checkout using Shoprunner <email> and <password>
#	And User applies giftcard in Shoprunner with giftcard <number> and <pin>
#	And User checkout Shoprunner
#	Then User verifies order summary page matches purchase and shoprunner
#	And User cancels the order
	
#	Examples:
#	| brand | item     | email                  | password    | number           | pin      |
#	| CKUS  | 37403933-618 | testatech123@gmail.com | password123 | 7777063816087566 | 67910187 |
	
@id=24 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify editing item quantity and removing an item during checkout
#    Given User access <brand> website
    When User navigate to login page
	And User try to login using <email> and <password>
	And User goes to cart page
	And User removes all items in cart
    And User searches an <item> with style number and adds it to cart
    And User proceeds to secure checkout
    And User edits an item at checkout
    Then User verifies that the item has been edited
    Then User removes and verifies that item is removed
	Then User verifies that the cart is empty
    
	Examples:
	| brand | email                     | password | item     |        
	| CKUS  | myaccountckus44@gmail.com | Passw0rd | 37403933-618 | 
	
#@id=25 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
#Scenario Outline: Verify removing an item during checkout
#    Given User access <brand> website
#    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User searches an <item> with style number and adds it to cart
#    And User proceeds to secure checkout
#    Then User removes and verifies that item is removed
    
#	Examples:#	| brand | email                     | password | item         |
#	            | CKUS  | myaccountckus44@gmail.com | Passw0rd | 37403933-618 | 	

#@id=26 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
#Scenario Outline: Verify applying a promo code during checkout
#	Given User access <brand> website
#	And User add <item> to cart
#	When User applies checkout promo code <code>
#	Then User verifies that promo code is applied in checkout
	
#	Examples: 
#	| brand | item         | code   | secondItem     |
#	| CKUS  | 21801776-438 | FALL20 | 37403933-618   |

#@id=27 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
#Scenario Outline: Verify removing and applying a promo code during checkout
#	Given User access <brand> website
#   And User searches an <item> with style number and adds it to cart
#   And User proceeds to secure checkout
#	When User applies checkout promo code <code>
#	Then User verifies that promo code is applied in checkout
#	Then User verifies removing promo code applied
	
#	Examples: 
#	| brand | item         | code   | secondItem     |
#	| CKUS  | 37403933-618 | FALL20 | 37403933-618   |

#@id=28 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
#Scenario Outline: Verify updating quantity during checkout
#	Given User access <brand> website
#	#And User add <product> to cart
#	And User adjusts to <quantity> on checkout page
#	Then User verifies item quantity is updated to <quantity>

#	Examples:
#	| brand | product        | quantity |
#	| CKUS  | 37403933-618   | 2        |
	

@id=29 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify adding new shipping address during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
	And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
#    When User provides <addressFields> into address fields
	And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
	And User adds new address <newAddress> into fields from review order page
    Then User verifies that new address has been selected <newAddress>

	Examples:
	| brand | item          | guestFields                                                                                  | type | number           | code | expMonth | expYear | newAddress                                                                                          |
	| CKUS  | 37403933-618  | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=30 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
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
	| brand | item          | guestFields                                                                                  | type | number           | code | expMonth | expYear | newBilling                                                                                          |
	| CKUS  | 37403933-618  | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | chck3+ckus@testmail.com;Cindy;Smith;1001 Frontier Road;22;Bridgewater;New Jersey; ;08807;9082316660 |
	
@id=31 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify editing shipping method during checkout from review order page
#	Given User access <brand> website
#	And User add <product> to cart
#	When User provides <addressFields> into address fields
	And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User proceeds to guest checkout
    And User provides <guestFields> into address fields
#	And User select shipping method <shippingMethod>
    And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User proceeds to review order page
    And User selects shipping method <shippingMethod2> from review order page
    And User clicks next
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User proceeds to review order page
    Then User verifies shipping method has been edited to <shippingMethod2>
		
	Examples:
	| brand | item          | guestFields                                                                                 | shippingMethod | type | number           | code | expMonth | expYear | shippingMethod2 |
	| CKUS  | 37403933-618  | testing@gmail.com;Anish;Patel;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;7323257940 | standard       | VISA | 4111111111111111 | 456  | 10       | 2020    | overnight       |
	
@id=32 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify editing payment method during checkout from review order page
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
    And User edits payment information on review order page
	And User enters payment information using credit card <type2>, <number2>, <code2>, <expMonth2>, <expYear2>
    And User proceeds to review order page
    Then User verifies the payment information was updated with <type2>, <number2>, <expMonth2>, <expYear2>
    
	Examples:
	| brand | item         | guestFields                                                                                  | type | number           | code | expMonth | expYear | type2       | number2          | code2 | expMonth2 | expYear2 |
	| CKUS  | 37403933-618 | testing@gmail.com;Anish;Patel;1200 US Highway 22;1;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | MasterCard  | 5555555555554444 | 456   | 10        | 2020     |
	
@id=33 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify navigating back from review order page
#    Given User access <brand> website
    When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    #	And User try to login using <email> and <password>
#   And User add <item> to cart
#   And User proceeds to secure checkout
	And User searches an <item> with style number and adds it to cart
    When User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    Then User verifies can navigate back
	And User removes all items in cart
	
	Examples:
	| brand | email                     |  password | item         | type | number           | code | expMonth | expYear | firstName | lastName | address                | apartment | city        | country       | state      | zip     | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS  | myaccountckus44@gmail.com |  Passw0rd | 37403933-618 | VISA | 4111111111111111 | 456  | 10       | 2020    | myaccount | ckus6    | 1200 US Highway 22     | 1         | Bridgewater | United States | New Jersey | 08807   | 7326368321 | Male   |   1     | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | 	

	
@id=34 @positive @parallel @checkout_module @desktop @checkOut @brand=CK
Scenario Outline: Verify editing order item from review order page
#    Given User access <brand> website
    When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
#    When User navigate to login page
#	And User try to login using <email> and <password>
#    And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
    And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User verifies can edit order
#   And User edits product to another size 
#	Then User verify edit change in bag
	
	Examples:
	| brand | email                     | password | item         | type | number           | code | expMonth | expYear | firstName | lastName | address                | apartment | city        | country       | state      | zip     | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS  | myaccountckus44@gmail.com | Passw0rd | 37403933-618 | VISA | 4111111111111111 | 456  | 10       | 2020    | myaccount | ckus6    | 1200 US Highway 22     | 1         | Bridgewater | United States | New Jersey | 08807   | 7326368321 | Male   |   1     | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | 