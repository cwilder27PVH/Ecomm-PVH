@module=myAccountCKMobile
Feature: My Account CK Mobile
	Description: This feature allows user to edit account details

@id=1 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify editing personal information with valid values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User edits mobile personal <information>
	Then User verifies personal information updated successfully
	
	Examples:
	| brand | email                     | password | information                                                                               |
	| CKUS  | myaccountckus43@gmail.com | Passw0rd | myaccount;ckus3;1200 US Highway 22;;Bridgewater;United States;New Jersey;08807;6094065792 |
	| CKCA  | myaccountckca43@gmail.com | Passw0rd | myaccount;ckca3;6730 University Drive;;Lacombe;Canada;Alberta;T4L 2E5;6094065792          |
	
@id=2 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify adding checkout preference with valid values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User edits checkout preferences <information>
	Then User verifies checkout preferences updated 
	
	Examples:
	| brand | email                    | password | information                                                                                               		     |
	| CKUS  | myaccountckus443@gmail.com | Passw0rd | myaccount;ckus3;1200 US Highway 22;15;Bridgewater;United States;New Jersey;08807;6094065792;4111111111111111;04;2022 |
#	| CKCA  | myaccountckca43@gmail.com | Passw0rd | myaccount;ckca3;6730 University Drive;;Lacombe;Canada;Alberta;T4L 2E5;6094065792;4111111111111111;04;2022        	 |
													
@id=3 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify adding new shipping address with valid values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User adds shipping address on mobile with valid <values>
	Then User verifies new address was added

	Examples:
	| brand  | email                       | password  |values                                                                        |
	| CKUS   | myaccountckus43@gmail.com   | Passw0rd  |myaccount;ckus3;1200 US Highway 22;15;Bridgewater;New Jersey;08807;1234567890 |

@id=4 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify adding new billing address with valid values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User adds billing address on mobile with valid <values>
	Then User verifies new address was added
	
	Examples:
	| brand  | email                      | password  |values                                                                                      |
	| CKUS   | myaccountckus43@gmail.com   | Passw0rd  |myaccount;ckus3;1200 US Highway 22;15;Bridgewater;United States;New Jersey;08807;1234567890 |
	
@id=5 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify adding new shipping and billing address with valid values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User adds shipping and billing address with valid <values>
	Then User verifies new address was added
	
	Examples:
	| brand  | email                      | password  |values                                                                     |
	| CKUS   | myaccountckus43@gmail.com   | Passw0rd  |myaccount;ckus4;1001 Frontier rd;;Bridgewater;New Jersey;08807;1234567890  |

#@id=6 @positive @parallel @myaccount_module @brand=CKMobile @mobile
#Scenario Outline: Verify removing existing address from address book
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User removes an address from address book
#	Then User verifies address was removed
	
#	Examples:
#	| brand  | email                      | password  |
#	| CKUS   | myaccountckus43@gmail.com   | Passw0rd  |
	
#@id=7 @positive @parallel @myaccount_module @brand=CKMobile @mobile
#Scenario Outline: Verify adding new shipping address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User navigates my address book
#	And User adds invalid address clicks update three times <information>
#	Then User verifies address has been added
	
#	Examples:
#	| brand  | email                          | password |information                                                                                             |
#	| CKUS   | qualitestmyaccount1@gmail.com  | Calvin1  |myaccount1;Patel1;1200 US Highway 22;15;Bridgewater;New Jersey;08889;1234569890;4111111111111111;04;2022    |
#	| CKCA   | qualitestmyaccount1@gmail.com  |  Calvin1 |myaccount1;Patel1;3932 Richmond Road;21;Calgary;Alberta;T7T 0C6;1234569890;4111111111111111;04;2022 |

@id=8 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify personal information on account summary page when user did not provide address during registration
	Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	Then User verifies mobile personal information without address
	
	Examples:
	| brand | email                     | password |
	| CKUS  | myaccountckus44@gmail.com  | Passw0rd |
	
@id=9 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify updating existing shipping address with valid information
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User adds shipping address on mobile with valid <values>
	And User updates on mobile a shipping address from address book <information>
	Then User verifies existing address has been updated
	
	Examples:
	| brand | email                      | password | information                                                                                        | values                                                                        |   
	| CKUS  | myaccountckus43@gmail.com   | Passw0rd | myaccount;ckus5;1001 frontier rd;;Bridgewater;New Jersey;08807;6094065792;4111111111111111;04;2022 | Cindy;Smith;656 Saint George Avenue; ;Woodbridge;New Jersey;07095;7324567890  |
	
@id=10 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify personal information on account summary page with provided address during registration
	Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User verifies on mobile personal information with address
	
	Examples:
	| brand  | email                    | password | firstName | lastName | address                | apartment | city        | country       | state      | zip     | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| CKUS   | myaccountckus46@gmail.com | Passw0rd | myaccount | ckus6    | 1200 US Highway 22             | 1 | Bridgewater | United States | New Jersey | 08807   | 7326368321 | Male   |   1     | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |
    | CKCA   | myaccountckca46@gmail.com | Passw0rd | myaccount | ckca6    |  6730 University Drive |           | Lacombe     | Canada        | Alberta    | T4L 2E5 | 7326368321 | Male   |   1     | 1    | Canada        | Alberta    |                                                            |               |      |

@id=11 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify my order page when no orders are placed
	Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User navigates to mobile orders page
	Then User verifies no orders have been placed

	Examples:
	| brand  | email                      | password |
	| CKUS   | myaccountckus44@gmail.com   | Passw0rd |
	| CKCA   | myaccountckca44@gmail.com   | Passw0rd |
	

@id=12 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify my order page when account has existing orders
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
    And User searches on mobile an <item> with style number and adds it to cart
	And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User navigates to mobile orders page
	Then User verifies there are existing orders

	Examples:
	| brand | email                     | password | item       | type | number           | code | expMonth | expYear |
	| CKUS  | myaccountckus43@gmail.com | Passw0rd | 33014357   | VISA | 4111111111111111 | 456  | 10       | 2020    |
	| CKCA  | myaccountckca43@gmail.com | Passw0rd | 45003293   | VISA | 4111111111111111 | 456  | 10       | 2020    |

@id=13 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify my rewards when user has no rewards available
	Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	When User navigates to mobile rewards tab
	Then User verifies user has no rewards on account page
	
	Examples:
	| brand | email                    | password |
	| CKUS  | myaccountckus43@gmail.com | Passw0rd |	
	
@id=15 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify editing personal information with invalid values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User edits mobile personal <information>
	Then User verifies error on account page <error>
	
	Examples:
	| brand  | email                     | password |information                                                                               | error                                        |
	| CKUS   | myaccountckus47@gmail.com  | Passw0rd |myaccount;ckus7;1200 US Highway 22;15;#$#@!#@$!;United States;New Jersey;08807;1234567890 | Did you mean city of Bridgewater ? Please correct the city/town and try again. |
    | CKCA   | myaccountckca47@gmail.com  | Passw0rd |myaccount;ckca7;1200 US Highway 22;15;!@!@#!#;United States;New Jersey;08807;1234567890   | Did you mean city of Bridgewater ? Please correct the city/town and try again. |
	

@id=16 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify updating blank personal information in required fields
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User edits mobile personal <information>
	Then User verifies personal information field error <error>
	
	Examples:
	| brand  | email                     | password |information                                                                                                 | error                           |
	| CKUS   | myaccountckus417@gmail.com | Passw0rd |myaccount;ckcu17;1200 US Highway 22;15; ;United States;New Jersey;08807;1234567890;4111111111111111;04;2022 | The city field cannot be empty. |
	| CKCA   | myaccountckca417@gmail.com | Passw0rd |myaccount;ckca17;6730 University Drive;;;Canada;Alberta;T4L 2E5;6094065792;4111111111111111;04;2022         | The city field cannot be empty. |

@id=17 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify updating blank personal information in optional fields
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User edits mobile personal <information>
	Then User verifies personal information updated successfully

	Examples:
	| brand | email                     | password | information                                                                                                        |
	| CKCA  | myaccountckca418@gmail.com | Passw0rd | myaccount;ckca15;6730 University Drive;;Lacombe;Canada;Alberta;T4L 2E5;6094065792;4111111111111111;04;2022         |
    | CKUS  | myaccountckus48@gmail.com  | Passw0rd | myaccount;ckus8;1200 US Highway 22;;Bridgewater;United States;New Jersey;08807;1234567890;4111111111111111;04;2022 |

#@id=18 @positive @parallel @myaccount_module @brand=CKMobile @mobile
#Scenario Outline: Verify updating address with address verification check failling more then 3 times
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User updates personal <information> three times
#	Then User verifies personal information updated successfully
	
#	Examples:
#	| brand | email                     | password | information                                                                             |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US Highway 22;;Camden;United States;New Jersey;08807;1234567890    |
#	| CKCA  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US Highway 22;;safawasdf;United States;New Jersey;08807;1234567890 |
	

@id=19 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify updating existing billing address with valid values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User adds billing address on mobile with valid <values2>
	And User updates billing fields on account page <values>
	Then User verifies existing address has been updated

	Examples:
	| brand | email                    | password | values                                                                                     | values2                                                                                   |
	| CKUS  | myaccountckus45@gmail.com | Passw0rd | myaccount;ckus3;1200 US Highway 22; ;Bridgewater;United States;New Jersey;08807;1234567890 | myaccount;ckus3;1001 Frontier rd;15;Bridgewater;United States;New Jersey;08807;1234567890 |
	
@id=20 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify updating existing shipping and billing address with valid values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User adds shipping and billing address with valid <values2>
	And User updates shipping and billing fields <values>
	Then User verifies existing address has been updated

	Examples:
	| brand | email                     | password | values                                                                                     | values2                                                                    |
	| CKUS  | myaccountckus45@gmail.com  | Passw0rd | myaccount;ckus3;1200 US Highway 22; ;Bridgewater;United States;New Jersey;08807;1234567890 | myaccount;ckus4;1001 Frontier rd;;Bridgewater;New Jersey;08807;1234567890  |

#@id=21 @positive @parallel @myaccount_module @brand=CKMobile @mobile
#Scenario Outline: Verify updating existing shipping address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User inputs shipping data <information> three times
#	Then User verifies updated address with an error on address book
	
#	Examples:
#	| brand | email                     | password | information                                                                   |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US Highway 22; ;Batboy;United States;New Jersey;08807;1234567890 |
	
#@id=22 @positive @parallel @myaccount_module @brand=CKMobile @mobile
#Scenario Outline: Verify updating existing billing address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User inputs billing <information> three times to update
#	Then User verifies updated address with an error on address book
	
#	Examples:
#	| brand | email                     | password | information                                                                 |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US Highway 22; ;Supi;United States;New Jersey;08807;1234567890 |
	
#@id=23 @positive @parallel @myaccount_module @brand=CKMobile @mobile
#Scenario Outline: Verify updating existing shipping and billing address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User inputs shipping and billing <information> three times
#	Then User verifies updated address with an error on address book
	
#	Examples:
#	| brand | email                     | password | information                                                                     |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US Highway 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
#@id=24 @positive @parallel @myaccount_module @brand=CKMobile @mobile
#Scenario Outline: Verify adding new billing address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User adds a new billing address and submits three times <information>
#	Then User verifies address has been added

#	Examples:
#	| brand | email                     | password | information                                                                     |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US Highway 22; ;Superman;United States;New Jersey;08807;1234567890 |

#@id=25 @positive @parallel @myaccount_module @brand=CKMobile @mobile
#Scenario Outline: Verify adding new shipping and billing address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User try to login using <email> and <password>
#	And User adds shipping and billing address and submits three times <information>
#	Then User verifies address has been added

#	Examples:
#	| brand | email                     | password | information                                                                     |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US Highway 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
@id=26 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify user is able to cancel adding new address in address book
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User adds a shipping address but cancels <information>
	Then User verifies that the address worked on is canceled

	Examples:
	| brand | email                     | password | information                                                                              |
	| CKUS  | myaccountckus410@gmail.com | Passw0rd | myaccount;ckus10;1200 US Highway 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
@id=27 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify removing all existing addresses in address book
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User adds shipping address on mobile with valid <values>
	And User adds shipping address on mobile with valid <values2>
	And User deletes all the addresses saved in the address book
	Then User verifies there is only one address in the address book

	Examples:
	| brand  | email                      | password | values                                                                         | values2                                                                       |
	| CKUS   | myaccountckus43@gmail.com  | Passw0rd | Steve;Smith;1120 US Highway 22;11;Bridgewater;New Jersey;08807;7324567890      | Cindy;Smith;656 Saint George Avenue; ;Woodbridge;New Jersey;07095;7324567890  |
	
@id=28 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Add Checkout Preferences With Invalid Values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences error
	
	Examples:
	| brand  | email                      | password |information                                                                                                       |
	| CKUS   | myaccountckus415@gmail.com  | Passw0rd | adfs;test;1200 US Highway 22;15;Bridgewater;United States;New Jersey;088078;1234569890;4111111111111111;04;2022  |
	| CKCA   | myaccountckca417@gmail.com  | Passw0rd |myaccount1;test;3932 Richmond Road;21;Calgary;Canada;Alberta;T2T TDC6;1234569890;4111111111111111;04;2022         |
											
@id=29 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Add Checkout Preferences With Invalid Billing Values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <shipping>
	And User edits billing checkout preferences <information>
	Then User verifies checkout preferences error
													
	Examples:
	| brand  | email                      | password  |information                                                                                           | shipping                                                                                                       |
	| CKCA   | myaccountckca417@gmail.com  |  Passw0rd |myaccount1;test1;  ;21;Calgary;Canada;Alberta;T2T 0C6;1234569890;4111111111111111;04;2022             | myaccount1;test;6730 University Drive;;Lacombe;Canada;Alberta;T4L 2E5;6094065792;4111111111111111;04;2022      |
	| CKUS   | myaccountckus415@gmail.com  | Passw0rd  |myaccount1;test1;  ;15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 | adfs;test;1200 US Highway 22;15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	 
@id=30 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Add Checkout Preferences With invalid Credit Card Values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences card error
	

	Examples:
	| brand  | email                      | password |information                                                                                                          |
	| CKUS   | myaccountckus49@gmail.com   | Passw0rd |myaccount1;Patel1;1200 US Highway 22;15;Bridgewater;United States;New Jersey;08807;1234569890;41111111111111;04;2022 |
	| CKCA   | myaccountckca417@gmail.com  | Passw0rd |myaccount1;Patel1;3932 Richmond Road;21;Calgary;Canada;Alberta;T2T 0C6;1234569890;41111111111111;04;2022             |
	
@id=31 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Add Checkout Preferences With Empty Values
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences empty error

	Examples:
	| brand  | email                      | password |information                                                                                        |
	| CKUS   | myaccountckus418@gmail.com  | Passw0rd |myaccount1;  ;  ;15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	| CKCA   | myaccountckca418@gmail.com  | Passw0rd |myaccount1;  ;  ;21;Calgary;Canada;Alberta;T2T 0C6;1234569890;4111111111111111;04;2022             |
													
@id=32 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify saved items when user has no saved items
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	And User navigates to mobile wishlist
	Then User verifies wishlist is empty
	
	Examples:
	| brand	| email                      | password |
	| CKUS  | myaccountckus418@gmail.com | Passw0rd |
	| CKCA  | myaccountckca418@gmail.com | Passw0rd |
	
@id=33 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify adding a new item to wishlist from cart as signed in user
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
    And User searches on mobile an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to mobile wishlist
	Then User verifies wishlist item matches item from cart
	And User clear wishlist
		
	Examples:
	| brand	| email                      | password | item      |
	| CKUS  | myaccountckus419@gmail.com | Passw0rd | 33014357  |
	| CKCA  | myaccountckca428@gmail.com | Passw0rd | 45003293  |

@id=34 @negative @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify sharing saved items without providing mandatory details
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
    And User searches on mobile an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to mobile wishlist
	And User shares wishlist
	Then User verifies mandatory details not provided error
	And User clear mobile wishlist
	
	Examples:
	| brand	 | email                      | password | item      |
	| CKUS   | myaccountckus419@gmail.com | Passw0rd | 33014357  |
	| CKCA   | myaccountckca428@gmail.com | Passw0rd | 45003293  |
	
@id=35 @positive @parallel @myaccount_module @brand=CKMobile @mobile
Scenario Outline: Verify sharing saved items with valid details
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
    And User searches on mobile an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to mobile wishlist
	And User provides share wishlist details <toEmail>, <fromName>, <fromEmail>, <message>
	And User shares wishlist
	Then User verifies wishlist was shared
	And User clear mobile wishlist
	
	Examples:
	| brand	 | email                      | password |        toEmail            | fromName  |       fromEmail            |   message    | item      |
	| CKUS   | myaccountckus419@gmail.com | Passw0rd | myaccountckus43@gmail.com | myaccount | myaccountckus418@gmail.com | Look at this | 33014357  |
	| CKCA   | myaccountckca428@gmail.com | Passw0rd | myaccountckca43@gmail.com | myaccount |myaccountckca418@gmail.com  | Look at this | 4500329   |