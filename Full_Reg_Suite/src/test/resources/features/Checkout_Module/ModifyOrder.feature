@module=modifyOrder
Feature: Order
Description: This feature completes orders and cancels or edits them

@id=1 @positive @parallel @checkout_module
Scenario Outline: Verify editing order as guest user
	Given User access <brand> website
	And User add <product> to cart
	When User provides <addressFields> into address fields
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User clicks edit from order summary page
	When User edits from checkout and continues to review order page
	Then User verify edit change in bag
	And User removes all items in cart
	
	@brand=CKUS
	Examples:
	| brand | product  | addressFields                                                                        | type       | number           | code | expMonth | expYear |
	| CKUS  | 14611705 | testing123@gmail.com;Dan;Smith;1200 US 22;;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |

@id=2 @positive @parallel @checkout_module
Scenario Outline: Verify editing order as signed in user
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User add <product> to cart
	And User proceeds to secure checkout
	And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User clicks edit from order summary page
	When User edits from checkout and continues to review order page
	Then User verify edit change in bag
	And User removes all items in cart
	
	@brand=CKUS
	Examples:
	| brand | product  | type | number           | code | expMonth | expYear | email                      | password |
	| CKUS  | 14611705 | VISA | 4111111111111111 | 456  | 10       | 2020    | modifyorderckus2@gmail.com | Passw0rd |

@id=3 @positive @parallel @checkout_module
Scenario Outline: Verify cancelling order as guest user
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User cancels order and verifys

	@brand=CKUS
	Examples:
	| brand | product | addressFields                                                                          | type       | number           | code | expMonth | expYear |
	| CKUS  | skirt   | testing123@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
#    @brand=CKCA
#	Examples:
#	| brand | product       | addressFields                                                                                     | type       | number           | code | expMonth | expYear |
#	| CKCA  | men red jeans | testing123@gmail.com;Anish;Patel;6730 University Drive;;Lacombe;Alberta;Canada;T4L 2E5;7323310898 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
	
    @brand=TH
	Examples:
	| brand | product | addressFields                                                                                   | type       | number           | code | expMonth | expYear |
    | TH    | pants   | testing@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand  | product  | addressFields                                                                                   | type       | number           | code | expMonth | expYear |
	| SPEEDO | swimsuit | testing@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | 
	
@id=4 @positive @parallel @checkout_module
Scenario Outline: Order Item and Cancel as Signed in User
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User add <product> to cart
	And User proceeds to secure checkout
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	Then User cancels order and verifys

	@brand=CKUS
	Examples:
	| brand | email                    | password | product | type       | number           | code | expMonth | expYear |
	| CKUS  | myaccountckus4@gmail.com | Passw0rd | skirt   | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=TH
	Examples:
	| brand | email                  | password | product    | type       | number           | code | expMonth | expYear |
    | TH    | myaccountth4@gmail.com | Passw0rd | mens pants | MasterCard | 5555555555554444 | 456  | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand  | email                      | password | product  | type       | number           | code | expMonth | expYear |
	| SPEEDO | myaccountspeedo4@gmail.com | Passw0rd | swimsuit | MasterCard | 5555555555554444 | 456  | 10       | 2020    | 
    
#@id=4 @parallel @positive @checkout_module
#Scenario Outline: Order Item and Cancel as Signed in User
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User add <product> to cart
#	When User provides <addressFields> into address fields
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
#	Then User cancels order and verifys
#    
#    @brand=CKCA
#	Examples:
#	| brand | email                      | addressFields                                                                                     | password | product    | type       | number           | code | expMonth | expYear |
#	| CKCA  | modifyorderckca4@gmail.com | testing123@gmail.com;Anish;Patel;6730 University Drive;;Lacombe;Alberta;Canada;T4L 2E5;6094065792 | Passw0rd | kids tanks | MasterCard | 5555555555554444 | 456  | 10       | 2020    |

@id=5 @positive @parallel @checkout_module
Scenario Outline: Check order status as a guest user
	Given User access <brand> website
	And User add <product> to cart
    When User provides <addressFields> into address fields
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User cancels the order
	And User navigates to guest orders and searches <email>
	Then Guest user confirms that order is there and <status> is correct

	
	@brand=CKUS
	Examples:
	| brand | email                      | status   | addressFields                                                                          | type       | number           | code | expMonth | expYear | product |
	| CKUS  | modifyorderckus5@gmail.com | CANCELED | testing123@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | shirt   |
     
#    @brand=CKCA
#	Examples:
#	| brand | email                      | status   | addressFields                                                                                     | type       | number           | code | expMonth | expYear | product |
#	| CKCA  | modifyorderckca5@gmail.com | CANCELED | testing123@gmail.com;Anish;Patel;6730 University Drive;;Lacombe;Alberta;Canada;T4L 2E5;6094065792 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | shirt   |
	
    @brand=TH
	Examples:
	| brand | email                    | status   | addressFields                                                                                   | type       | number           | code | expMonth | expYear | product  |
	| TH    | modifyorderth5@gmail.com | CANCELED | testing@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey;United States;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | sweaters |
	
    @brand=SPEEDO
    Examples:
    | brand  | email                        | status   | addressFields                                                                          | type       | number           | code | expMonth | expYear | product  |
    | SPEEDO | modifyorderspeedo5@gmail.com | CANCELED | testing123@gmail.com;Anish;Patel;1200 US 22;;Bridgewater;New Jersey; ;08807;1234567890 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | swimsuit |
	
@id=6 @positive @parallel @checkout_module
Scenario Outline: Verify order status as Signed in user
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User add <product> to cart
	And User proceeds to secure checkout
	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User cancels the order
	And User navigates to my orders
	Then User confirms order is there and <status> is correct

	@brand=CKUS
	Examples:
	| brand | email                      | status   | type | number           | code | expMonth | expYear | product | password |
	| CKUS  | myaccountckus4@gmail.com | CANCELED | VISA | 4111111111111111 | 456  | 10       | 2020    | shirt   | Passw0rd |
     
    @brand=TH
	Examples:
	| brand | email                    | status   | type       | number           | code | expMonth | expYear | product | password |
	| TH    | myaccountth4@gmail.com | CANCELED | MasterCard | 5555555555554444 | 456  | 10       | 2020    | sweats  | Passw0rd |
	
    @brand=SPEEDO
    Examples:
    | brand  | email                        | status   | type       | number           | code | expMonth | expYear | product  | password |
    | SPEEDO | myaccountspeedo4@gmail.com | CANCELED | MasterCard | 5555555555554444 | 456  | 10       | 2020    | swimsuit | Passw0rd |
    
    
#@id=6 @positive @parallel @checkout_module
#Scenario Outline: Verify order status as Signed in user
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User add <product> to cart
#	When User provides <addressFields> into address fields
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
#	And User cancels the order
#	And User navigates to my orders
#	Then User confirms order is there and <status> is correct
#     
#    @brand=CKCA
#	Examples:
#	| brand | email                      | status   | addressFields                                                                                     | type       | number           | code | expMonth | expYear | product     | password | 
#	| CKCA  | modifyorderckca6@gmail.com | CANCELED | testing123@gmail.com;Anish;Patel;6730 University Drive;;Lacombe;Alberta;Canada;T4L 2E5;6094065792 | MasterCard | 5555555555554444 | 456  | 10       | 2020    | blue shirts | Passw0rd |
