@module=myAccountPB
Feature: My Account PB
	Description: This feature allows user to edit account details

@id=1 @positive@myaccount_module @brand=PB @desktop
Scenario Outline: Verify editing personal information with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User edits personal <information>
	Then User verifies personal information updated successfully
	
	Examples:
	| brand | email                     | password | information   																     |
	| VH    | myaccountvh43@gmail.com    | Passw0rd | myaccount;pb3;1130 US Highway 22;;Bridgewater;United States;New Jersey;08807;6094065555 |
	

@id=2 @positive @myaccount_module @brand=PB @desktop
Scenario Outline: Verify adding checkout preference with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences updated 

	Examples:	
	| brand | email                    | password | information   															          				   	             |
	| VH    | myaccountvh43@gmail.com   | Passw0rd | myaccount;vh3;1130 US Highway 22;BOX 15;Bridgewater;United States;New Jersey;08807;6094065555;4111111111111111;04;2022   |

@id=3 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify adding new shipping address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds shipping address with valid <values>
	Then User verifies new address was added
	
	Examples:
	| brand | email                     | password | values   				  					   				             |
	| VH    | myaccountvh43@gmail.com    | Passw0rd | myaccount;pb3;1130 US Highway 22;BOX 15;Bridgewater;New Jersey;08807;6094065555 |

@id=4 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify adding new billing address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds billing address with valid <values>
	Then User verifies new address was added
	
	Examples:
	| brand | email                     | password | values   				  					   							               |
	| VH    | myaccountvh43@gmail.com    | Passw0rd | myaccount;pb3;1200 US Highway 22;BOX 15;Bridgewater;United States;New Jersey;08807;6094065555 |

@id=5 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify adding new shipping and billing address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds shipping and billing address with valid <values>
	Then User verifies new address was added
	
	Examples:
	| brand  | email                      | password  |values                                                                    |
	| VH     | myaccountvh43@gmail.com     | Passw0rd  |myaccount;pb3;1001 Frontier rd;;Bridgewater;New Jersey;08807;1234567890   |
	

#@id=6 @positive @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify removing existing address from address book
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User removes an address from address book
#	Then User verifies address was removed
	

#	Examples:
#	| brand  | email                      | password  |
#	| VH     | myaccountvh43@gmail.com     | Passw0rd  |

	
#@id=7 @positive @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify adding new shipping address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User navigates my address book
#	And User adds invalid address clicks update three times <information>
#	Then User verifies address has been added
	
	
#	@brand=CK @desktopUS
#	Examples:
#	| brand  | email                      | password |information                                                                         |
#	| CKUS   | qualitestmyaccount1@gmail.com  | Calvin1  |myaccount1;Patel1;1200 US 22;BOX 15;Bridgewater;New Jersey;08889;1234569890;4111111111111111;04;2022 |
	
#	@brand=CK @desktopCA
#	Examples: Address Book Option Removed from CKCA
#	| brand  | email                      | password |information                                                                         |
#	| CKCA   | qualitestmyaccount1@gmail.com  |  Calvin1 |myaccount1;Patel1;3932 Richmond Road;BOX 21;Calgary;Alberta;T7T 0C6;1234569890;4111111111111111;04;2022 |
													
#	@brand=TH
#	Examples:
#	| brand  | email                      | password |information                                                                         |
#	| TH     | qualitestmyaccount1@gmail.com  |  Tommy1  |myaccount1;Patel1;1200 US 22;BOX 15;Bridgewater;New Jersey;08889;1234569890;4111111111111111;04;2022 |
	
#	@brand=SPEEDO
#	Examples:
#	| brand  | email                      | password |information            |
#	| SPEEDO | qualitestmyaccount1@gmail.com  |  Speedo1  |myaccount1;Patel1;1200 US 22;BOX 15;Bridgewater;New Jersey;08897;1234569890;4111111111111111;04;2022 |

@id=8 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify personal information on account summary page when user did not provide address during registration
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User verifies personal information without address
	

	Examples:
	| brand | email                     | password |
	| VH    | myaccountvh44@gmail.com    | Passw0rd |
	

@id=9 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify updating existing shipping address with valid information
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User updates a shipping address from address book <information>
	Then User verifies existing address has been updated
	
	Examples:
	| brand | email                      | password | information                                                                                      | values                                                                                     |
	| VH    | myaccountvh43@gmail.com     | Passw0rd | myaccount;th5;1001 frontier rd;;Bridgewater;New Jersey;08807;6094065792;4111111111111111;04;2022 | Cindy;Smith;656 Saint George Avenue; ;Woodbridge;United States;New Jersey;07095;7324567890 |
	

@id=10 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify personal information on account summary page with provided address during registration
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User verifies personal information with address
	
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay |
	| VH     | vhtest@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1 | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |
	

@id=11 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify my order page when no orders are placed
	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User navigates to orders page
	Then User verifies no orders have been placed

	Examples:
	| brand  | email                      | password |
	| VH     | myaccountvh44@gmail.com     | Passw0rd |



@id=12 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify my order page when account has existing orders
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
#	When User searches for <item>
#	And User clicks on product
#	And User chooses random size
#	And User clicks add to bag
#	And User goes to cart page
	And User proceeds to secure checkout
    And User clicks next
    And User enters payment information using credit card <type>, <number>, <code>, <expMonth>, <expYear>
    And User proceeds to review order page
    And User submit order from review order page
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User navigates to orders page
	Then User verifies there are existing orders

	Examples:
	| brand | email                    | password | item   | type | number           | code | expMonth | expYear |
	| VH    | myaccountvh43@gmail.com   | Passw0rd | izo5079    | VISA | 4111111111111111 | 456  | 10       | 2020    |
	
# */@id=13 @negative @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify my rewards when user has no rewards available
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	When User navigates to rewards tab
#	Then User verifies user has no rewards on account page
	

@id=15 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify editing personal information with invalid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User edits personal <information>
	Then User verifies error on account page <error>
	
	Examples:
	| brand  | email                      | password |information                                                                               | error                                                                          |
	| VH     | myaccountvh47@gmail.com    | Passw0rd |myaccount;pb7;1200 US Highway 22;15;#$#@!#@$!;United States;New Jersey;08807;1234567890   | Did you mean city of Bridgewater ? Please correct the city/town and try again. |


@id=16 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify updating blank personal information in required fields
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User edits personal <information>
	Then User verifies personal information field error <error>
	
	Examples:
	| brand  | email                       | password |information                                                                                           | error                |
	| VH     | myaccountvh417@gmail.com     | Passw0rd |myaccount;th8;1200 US Highway 22;15; ;United States;New Jersey;08807;7324567890;4111111111111111;04;2022  | PLEASE ENTER A CITY. |

@id=17 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify updating blank personal information in optional fields
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User edits personal <information>
	Then User verifies personal information updated successfully
	
	Examples:
	| brand | email                    | password | information                                                                                                |
	| VH    | myaccountvh48@gmail.com   | Passw0rd | myaccount;pb8;1200 US Highway 22;;Bridgewater;United States;New Jersey;08807;1234567890;4111111111111111;04;2022   |

#@id=18 @positive @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify updating address with address verification check failling more then 3 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User updates personal <information> three times
#	Then User verifies personal information updated successfully
	
#	@brand=CK @desktopUS
#	Examples:
#	| brand | email                     | password | information                                                                  |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22;;Camden;United States;New Jersey;08807;1234567890 |
	
#	@brand=CK @desktopCA
#	Examples:
#	| brand | email                     | password | information                                                                     |
#	| CKCA  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22;;safawasdf;United States;New Jersey;08807;1234567890 |
	
#	@brand=TH
#	Examples:
#	| brand | email              | password | information                                                              |
#	| TH    | pvhedit1@gmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22;;Camden;United States;New Jersey;08807;7324567890 |
	
@id=19 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify updating existing billing address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds billing address with valid <values2>
	And User updates billing fields on account page <values>
	Then User verifies existing address has been updated

	Examples:
	| brand | email                    | password | values                                                                             | values2                                                                                     |
	| VH    | myaccountvh43@gmail.com   | Passw0rd | myaccount;pb3;1200 US Highway 22; ;Bridgewater;United States;New Jersey;08807;1234567890   | myaccount;pb3;1001 Frontier rd;BOX 15;Bridgewater;United States;New Jersey;08807;6094065555 |


@id=20 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify updating existing shipping and billing address with valid values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds shipping and billing address with valid <values2>
	And User updates shipping and billing fields <values>
	Then User verifies existing address has been updated

	Examples:
	| brand | email                    | password | values                                                                             | values2                                                                 |
	| VH    | myaccountvh43@gmail.com   | Passw0rd | myaccount;pb3;1200 US Highway 22; ;Bridgewater;United States;New Jersey;08807;1234567890   | myaccount;pb3;1001 Frontier rd;;Bridgewater;New Jersey;08807;1234567890 |


#@id=21 @positive @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify updating existing shipping address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User inputs shipping data <information> three times
#	Then User verifies updated address with an error on address book
	
#	@brand=CK @desktopUS
#	Examples:
#	| brand | email                     | password | information                                                               |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Batboy;United States;New Jersey;08807;1234567890 |
	
#	@brand=TH
#	Examples:
#	| brand | email                     | password | information                                                               |
#	| TH    | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Batboy;United States;New Jersey;08807;7324567890 |
	
#	@brand=SPEEDO
#	Examples:
#	| brand  | email                      | password | information                                                               |
#	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Batboy;United States;New Jersey;08807;7324567890 |	

#@id=22 @positive @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify updating existing billing address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User inputs billing <information> three times to update
#	Then User verifies updated address with an error on address book
	
#	@brand=CK @desktopUS
#	Examples:
#	| brand | email                     | password | information                                                             |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Supi;United States;New Jersey;08807;1234567890 |
	
#	@brand=TH
#	Examples:
#	| brand | email                     | password | information                                                             |
#	| TH    | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Supi;United States;New Jersey;08807;7324567890 |
	
#	@brand=SPEEDO
#	Examples:
#	| brand  | email                     | password | information                                                             |
#	| SPEEDO | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Supi;United States;New Jersey;08807;7324567890 |	

#@id=23 @positive @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify updating existing shipping and billing address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User inputs shipping and billing <information> three times
#	Then User verifies updated address with an error on address book
	
#	@brand=CK @desktopUS
#	Examples:
#	| brand | email                     | password | information                                                                 |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
#	@brand=TH
#	Examples:
#	| brand | email                     | password | information                                                                 |
#	| TH    | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |
	
#	@brand=SPEEDO
#	Examples:
#	| brand  | email                     | password | information                                                                 |
#	| SPEEDO | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |	

#@id=24 @positive @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify adding new billing address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User adds a new billing address and submits three times <information>
#	Then User verifies address has been added

#	@brand=CK @desktopUS
#	Examples:
#	| brand | email                     | password | information                                                                 |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
#	@brand=TH
#	Examples:
#	| brand | email                     | password | information                                                                 |
#	| TH    | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |
	
#	@brand=SPEEDO
#	Examples:
#	| brand  | email                     | password | information                                                                 |
#	| SPEEDO | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |	

#@id=25 @positive @myaccount_module @brand=PB @desktop 
#Scenario Outline: Verify adding new shipping and billing address with address verification check failure more then 3 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User try to login using <email> and <password>
#	And User adds shipping and billing address and submits three times <information>
#	Then User verifies address has been added

#	@brand=CK @desktopUS
#	Examples:
#	| brand | email                     | password | information                                                                 |
#	| CKUS  | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;1234567890 |
	
#	@brand=TH
#	Examples:
#	| brand | email                     | password | information                                                                 |
#	| TH    | testingpvh123@yopmail.com | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |
	
#	@brand=SPEEDO
#	Examples:
#	| brand  | email                      | password | information                                                                 |
#	| SPEEDO | testingpvh123@yopmail.com  | 1qaz@WSX | myaccount;Patel;1200 US 22; ;Superman;United States;New Jersey;08807;7324567890 |	
	
@id=26 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify user is able to cancel adding new address in address book
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds a shipping address but cancels <information>
	Then User verifies that the address worked on is canceled

	Examples:
	| brand | email                     | password | information                                                                      |
	| VH    | myaccountvh410@gmail.com   | Passw0rd | myaccount;pb10;1200 US Highway 22; ;Superman;United States;New Jersey;08807;1234567890   |


@id=27 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify removing all existing addresses in address book
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User adds shipping address with valid <values>
	And User adds shipping address with valid <values2>
	And User deletes all the addresses saved in the address book
	Then User verifies there is only one address in the address book

	Examples:
	| brand  | email                     | password | values                                                                     | values2                                                                       |
	| VH     | myaccountvh43@gmail.com    | Passw0rd | Steve;Smith;1120 US Highway 22;Box 11;Bridgewater;New Jersey;08807;7324567890      | Cindy;Smith;656 Saint George Avenue; ;Woodbridge;New Jersey;07095;7324567890  |


@id=28 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Add Checkout Preferences With Invalid Values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences error

	Examples:
	| brand  | email                      | password |information                                                                                                  |
	| VH     | myaccountvh415@gmail.com    | Passw0rd | adfs;test;1200 US Highway 22;15;Bridgewater;United States;New Jersey;088078;1234569891;4111111111111111;04;2022 |

@id=29 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Add Checkout Preferences With Invalid Billing Values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <shipping>
	And User edits billing checkout preferences <information>
	Then User verifies checkout preferences error
													
	Examples:
	| brand  | email                      | password |information                                                                                                         | shipping                                                                                                  |
	| VH     | myaccountvh415@gmail.com    | Passw0rd |myaccount15;test1;1200 US Highway 22;5;Bridgewater;United States;New Jersey;088078;1234569890;4111111111111111;04;2022 | adfs;test;1130 US Highway 22;BOX 15;Bridgewater;United States;New Jersey;08807;6094065555;4111111111111111;04;2022|	

 
@id=30 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Add Checkout Preferences With invalid Credit Card Values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences card error

	Examples:
	| brand  | email                         | password |information                                                                                                       |
	| VH     | myaccountvh417@gmail.com       | Passw0rd |myaccount17;Patel1;1200 US Highway 22;15;Bridgewater;United States;New Jersey;08807;1234569890;41111111111111;04;2022 |
	

@id=31 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Add Checkout Preferences With Empty Values
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to checkout preferences
	And User edits checkout preferences <information>
	Then User verifies checkout preferences empty error
	
	Examples:
	| brand  | email                      | password |information                                                                                            |
	| VH     | myaccountvh418@gmail.com    | Passw0rd |myaccount1;  ;  ;15;Bridgewater;United States;New Jersey;08807;1234569890;4111111111111111;04;2022 |
	

@id=32 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify saved items when user has no saved items
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
	And User navigates to wishlist
	Then User verifies wishlist is empty

	Examples:
	| brand	| email                     | password |
	| VH    | myaccountvh48@gmail.com   | Passw0rd |

@id=33 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify adding a new item to wishlist from cart as signed in user
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
#    And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to wishlist
#	Then User verifies wishlist item matches item from cart
	And User clear wishlist
		
	Examples:
	| brand	| email                      | password  | item  |
	| VH    | myaccountvh418@gmail.com   | Passw0rd  | izo5079 |

@id=34 @negative @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify sharing saved items without providing mandatory details
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
#    And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to wishlist
	And User shares wishlist
	Then User verifies mandatory details not provided error
	And User clear wishlist
	
	Examples:
	| brand	 | email                      | password | item     |
	| VH     | myaccountvh418@gmail.com   | Passw0rd | izo5079  |
	

@id=35 @positive @myaccount_module @brand=PB @desktop 
Scenario Outline: Verify sharing saved items with valid details
	Given User access <brand> website
	When User navigate to login page
	And User try to login using <email> and <password>
#    And User add <item> to cart
    And User searches an <item> with style number and adds it to cart
	And User adds item from cart to wishlist
	And User navigates to wishlist
	And User provides share wishlist details <toEmail>, <fromName>, <fromEmail>, <message>
	And User shares wishlist
	Then User verifies wishlist was shared
	And User clear wishlist
	
	Examples:
	| brand	 | email                     | password |        toEmail           | fromName  |       fromEmail           |   message    | item |
	| VH     | myaccountvh418@gmail.com  | Passw0rd | myaccountpb3@gmail.com   | myaccount | myaccountpb18@gmail.com   | Look at this | izo5079  |
	
