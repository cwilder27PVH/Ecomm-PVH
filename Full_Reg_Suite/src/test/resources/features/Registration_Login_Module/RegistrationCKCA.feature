@module=registrationCKCA
Feature: Registration CKCA
Description: This feature allows user to create an account

Background:
	Given User navigates to Calvin Klein CA Webstore
	And User logs out if already logged in

@id=1 @positive @parallel @registration_login_module @brand=CK @desktop
Scenario Outline: Partial registration with valid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should be registered successfully without complete details


	Examples:
	| brand | email                 | password  |
#	| CKUS  | testckus@testmail.com | abcdef123 |
	| CKCA  | testckca@testmail.com | abcdef123 |

@id=2 @positive @smokeT @prod @parallel @registration_login_module @brand=CK @desktop  @addressy
Scenario Outline: Complete registration with valid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should be registered successfully with complete details
	
	Examples:
	| brand  | email                   | password  | firstName | lastName | address            | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
#	| CKUS   | ckustest@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1         | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | 
	| CKCA   | ckcatest@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1         | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      |
	

@id=3 @negative @parallel @registration_login_module @brand=CK @desktop  @addressy
Scenario Outline: Complete registration without providing details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>

	Examples:
	| brand  | email                    | password  | firstName |  lastName  |     address            |    apartment    |         city         |      country      |    state    |   zip    |    phone      |  gender |  bMonth   |  bDay  |  prefCountry  | prefState  |                          prefStore                              | communication | type | error                                |
#	| CKUS   | miss1+ckus@yopmail.com   | abcdef123 | test      |   User     |   1200 US Highway 22   |    1            |     Bridgewater      |   United States   |  New Jersey |  088072  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The first name field cannot be empty |
#	| CKUS   | miss2+ckus@yopmail.com   | abcdef123 | Test PVH  |            |   1200 US Highway 22   |    1            |     Bridgewater      |   United States   |  New Jersey |  088072  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The last name field cannot be empty. |
	| CKCA   | miss1+ckca@yopmail.com   | abcdef123 | test      |   User     |   1200 US Highway 22   |    1            |     Bridgewater      |   United States   |  New Jersey |  088072  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The first name field cannot be empty |
#	| CKCA   | miss2+ckca@yopmail.com   | abcdef123 | Test PVH  |            |   1200 US Highway 22   |    1            |     Bridgewater      |   United States   |  New Jersey |  088072  |   1234567890  |   Male  |     1     |    1   |               |            |                                                                 |               |      | The last name field cannot be empty  |
	
@id=4 @positive @parallel @registration_login_module @brand=CK @desktop
Scenario Outline: Register with valid details post checkout as Guest User
#	Given User access <brand> website
    And User searches an <item> with style number and adds it to cart
#    When User provides <guestFields> into address fields
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
#	Then User verify summary of order submitted using credit card <type>
	And User provide <email> , <firstName> , <lastName> , <address> , <apartment> , <city> , <state> , <country> , <zip> , <phone> into shipping information
	When User provide <password> on checkout page
	Then User should be registered successfully
	
	Examples:
	| brand  | item     | email                     | password | firstName | lastName | address            | apartment | city        | state      | country       | zip    | phone      |guestFields                                                                                      | type | number           | code | expMonth | expYear |
#	| CKUS   | 33014357 | testingUser@yopmail.com   | 1qaz@WSX | Bobby     | Smith    | 1200 US Highway 22 | 1         | Bridgewater | New Jersey |               | 08807  | 1234567890 |testingUser@yopmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890| VISA | 4111111111111111 | 456  | 10       | 2020    |

@id=5 @negative @parallel @registration_login_module @brand=CK @desktop  @addressy
Scenario Outline: Complete Registration when providing invalid address and submitting 4 times
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	When User submits invalid address 4 times
	Then User should be registered successfully with complete details
	
	Examples:
	| brand | email                    | password  | firstName | lastName | address            | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
#	| CKUS  | invadd1+ckus@yopmail.com | abcdef123 | Test PVH  | User     | 1200               | 4         | Woodbridge  | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      |
	| CKCA  | invadd2+ckca@yopmail.com | abcdef123 | Test PVH  | User     | 1200 US Highway 22 |           | Bridgewater | Canada        | Alberta    | 08806 | 1234567890 |        |         |      |               |            |                                                            |               |      |

@id=6 @negative @parallel @registration_login_module @brand=CK @desktop
Scenario Outline: Partial registration with invalid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should get error message <error>

	Examples:
	| brand | email                   | password | error                                       |
#	| CKUS  | testregisterckca1       | 1qaz@WSX | The email entered is not in a valid format. |
#	| CKUS  | testregisterckca1@gmail | 1qaz@WSX | The email entered is not in a valid format. |
	| CKCA  | testregisterckca1       | 1qaz@WSX | The email entered is not in a valid format. |
#	| CKCA  | testregisterckca1@gmail | 1qaz@WSX | The email entered is not in a valid format. |
	
@id=7 @negative @parallel @registration_login_module @brand=CK @desktop
Scenario Outline: Registration without providing details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should get error message <error>
	
	Examples:
	| brand | email | password | error                            |
	| CKCA  |       |          | The email field cannot be empty. |
#	| CKUS  |       |          | The email field cannot be empty. |
	
@id=8 @negative @parallel @registration_login_module @brand=CK @desktop  @addressy
Scenario Outline: Complete registration with invalid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>
	
	Examples:
	| brand  | email                    | password  | firstName | lastName | address            | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                                              |
#	| CKUS   | inv1+ckus@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1 		| Bridgewater | United States | New Jersey | abcde | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | The Zip code entered is not in a valid format      |
#	| CKUS   | inv2+ckus@testmail.com   | abcdef123 | Test PVH  | User     | 22        			| 1 		| Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | Invalid Address                                    |
	| CKCA   | inv1+ckca@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1 		| Bridgewater | United States | New Jersey | abcde | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | The Zip code entered is not in a valid format      |
#	| CKCA   | inv2+ckca@testmail.com   | abcdef123 | Test PVH  | User     | 22 		        | 1 		| Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |                                                            |               |      | Invalid Address                                    |