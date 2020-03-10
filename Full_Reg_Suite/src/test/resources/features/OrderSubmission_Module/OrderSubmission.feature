@module=orderSubmission
Feature: Order Submission
	Description: This feature allows to create specified count of orders
	
@id=1 @positive @parallel
Scenario Outline: Create order using VISA, Discover, American Express payment method
	Given User access <brand> website
	And User place <totalOrderCount> orders for product <styleNumber> using billing address <address> and credit card <type>, <number>, <code>, <expMonth>, <expYear>

#	@brand=CKUS
#	Examples:
#	| brand | totalOrderCount | styleNumber | address                                                                                   | type             | number           | code | expMonth | expYear |
#	| CKUS  | 1               | 21297745    | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | VISA             | 4111111111111111 | 456  | 10       | 2020    |
#	| CKUS  | 1               | 14601074    | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | Discover         | 6011123412331112 | 456  | 10       | 2020    |
#	| CKUS  | 1               | 88056001    | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey; ;08807;1234567890 | American Express | 378282246310005  | 4561 | 10       | 2020    |
	
#	@brand=CKCA
#	Examples:
#	| brand | totalOrderCount | styleNumber | address                                                                                        | type             | number           | code | expMonth | expYear |
#	| CKCA  | 100             | 21686417    | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932 Richmond Road;21;Calgary;Alberta; ;T2T 0C6;9085262900 | VISA             | 4111111111111111 | 456  | 10       | 2020    |
#	| CKCA  | 100             | 18808241    | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932 Richmond Road;21;Calgary;Alberta; ;T2T 0C6;9085262900 | Discover         | 6011123412331112 | 456  | 10       | 2020    |
#	| CKCA  | 100             | 80195030    | ckSpeedoTH2@yopmail.com;Cindy;Smith;3932 Richmond Road;21;Calgary;Alberta; ;T2T 0C6;9085262900 | American Express | 378282246310005  | 4561 | 10       | 2020    |
	
#	@brand=TH
#	Examples:
#	| brand | totalOrderCount | styleNumber | address                                                                                               | type             | number           | code | expMonth | expYear |
#	| TH    | 1               | 7870359     | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA             | 4111111111111111 | 456  | 10       | 2020    |
#   | TH    | 1               | 7657820     | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | Discover         | 6011123412331112 | 456  | 10       | 2020    |
#   | TH    | 1               | KG03459     | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005  | 4561 | 10       | 2020    |
    
    @brand=SPEEDO
    Examples:
    | brand  | totalOrderCount | styleNumber | address                                                                                               | type             | number           | code | expMonth | expYear |
	| SPEEDO | 10              | 7482202     | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | VISA             | 4111111111111111 | 456  | 10       | 2020    | 
# 	| SPEEDO | 100             | 7720903     | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | Discover         | 6011123412331112 | 456  | 10       | 2020    |
# 	| SPEEDO | 100             | 7750208     | testing@gmail.com;Anish;Patel;1200 US 22;BOX 15;Bridgewater;New Jersey;United States;08807;1234567890 | American Express | 378282246310005  | 4561 | 10       | 2020    |