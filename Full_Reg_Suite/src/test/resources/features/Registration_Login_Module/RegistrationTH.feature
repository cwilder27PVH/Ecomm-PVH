@module=registrationTH
Feature: Registration TH
Description: This feature allows user to create an account

Background:
	Given User navigates to Tommy Hilfiger Webstore
	And User logs out if already logged in

@id=1 @positive @parallel @registration_login_module @brand=TH @desktop
Scenario Outline: Partial registration with valid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should be registered successfully without complete details

	Examples:
	| brand | email                 | password  |
	| TH    | testth@testmail.com   | abcdef123 |

@id=2 @positive @smokeT @prod @parallel @registration_login_module @brand=TH @desktop  @addressy
Scenario Outline: Complete registration with valid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should be registered successfully with complete details
	
	Examples:
	| brand  | email                   | password  | firstName | lastName | address            | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                                 | communication | type |
	| TH     | thtest@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1         | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 12   | United States | New Jersey | The Outlets at Bergen Town Center - 2701 Bergen Town Center, Paramus, NJ | web           | men  |
	
@id=3 @negative @parallel @registration_login_module @brand=TH @desktop  @addressy
Scenario Outline: Complete registration without providing details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>

	Examples:
	| brand  | email                    | password  | firstName |  lastName  |     address            |    apartment    |         city         |      country      |    state    |   zip   |    phone      |  gender |  bMonth   |  bDay  |  prefCountry  | prefState  |                          prefStore                              | communication | type | error  							   |
	| TH     | miss1+th@yopmail.com     | abcdef123 | test      |   User     |   1200 US Highway 22   |    1    		|     Bridgewater      |   United States   |  New York   |  08807  |   9085262900  |   Male  |  January  |   12   | United States | New Jersey |   Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ    |     web       | men  | The first name field cannot be empty |
#	| TH     | miss2+th@yopmail.com     | abcdef123 | Test PVH  |            |   1200 US Highway 22   |    1    		|     Bridgewater      |   United States   |  New Jersey |  08807  |   9085262900  |   Male  |  January  |   12   | United States | New Jersey |   Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ    |     web       | men  | The last name field cannot be empty  |
	
@id=4 @positive @parallel @registration_login_module @brand=TH @desktop
Scenario Outline: Register with valid details post checkout as Guest User
#	Given User access <brand> website
    And User searches an <item> with style number and adds it to cart
    And User provide <email> , <firstName> , <lastName> , <address> , <apartment> , <city> , <state> , <country> , <zip> , <phone> into shipping information
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	When User provide <password> on checkout page
	Then User should be registered successfully

	Examples:
	| brand  | item      | email                     | password | firstName | lastName | address            | apartment | city        | state      | country       | zip    | phone      | guestFields                                                                                                   | type | number           | code | expMonth | expYear |
	| TH     | aw04548   | testingUser@yopmail.com   | 1qaz@WSX | Bobby     | Smith    | 1200 US Highway 22 | 15        | Bridgewater | New Jersey | United States | 08807  | 1234567890 | testingUser@yopmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey;United States;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    |

@id=5 @negative @parallel @registration_login_module @brand=TH @desktop  @addressy
Scenario Outline: Complete Registration when providing invalid address and submitting 4 times
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	When User submits invalid address 4 times
	Then User should be registered successfully with complete details
	
	Examples:
	| brand | email                    | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| TH    | invadd1+th@yopmail.com   | abcdef123 | Test PVH  | User     | 1200       | 1         | Woodbridge  | United States | New Jersey | 08807 | 9085262900 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |

@id=6 @negative @parallel @registration_login_module @brand=TH @desktop
Scenario Outline: Partial registration with invalid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should get error message <error>

	Examples:
	| brand | email                   | password | error                                       |
	| TH    | testregisterckca1       | 1qaz@WSX | The email entered is not in a valid format. |
#	| TH    | testregisterckca1@gmail | 1qaz@WSX | The email entered is not in a valid format. |
	
@id=7 @negative @parallel @registration_login_module @brand=TH @desktop
Scenario Outline: Registration without providing details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should get error message <error>
	
	Examples:
	| brand | email | password | error                            |
	| TH    |       |          | The email field cannot be empty. |

@id=8 @negative @parallel @registration_login_module @brand=TH @desktop  @addressy
Scenario Outline: Complete registration with invalid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>
	
	Examples:
	| brand  | email                    | password  | firstName | lastName | address    		| apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                                              |
	| TH     | inv1+th@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1 		| Bridgewater | United States | New Jersey | abcde | 9085262900 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | Address Not Found                                  | 
#	| TH     | inv2+th@testmail.com     | abcdef123 | Test PVH  | User     | 22         		| 1 		| Bridgewater | United States | New Jersey | 08807 | 9085262900 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | Invalid Address                                    |
	
