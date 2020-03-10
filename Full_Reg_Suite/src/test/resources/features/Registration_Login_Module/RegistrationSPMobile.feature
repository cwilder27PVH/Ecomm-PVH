@module=registrationSPMobile
Feature: Registration SP Mobile
Description: This feature allows user to create an account

#@id=1 @positive @parallel @registration_login_module
#Scenario Outline: Partial registration with valid details from SignIn Page
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User provide <email> , <password> and register
#	Then User should be registered successfully without complete details

@id=2 @positive @smokeT @prod @parallel @registration_login_module @brand=SP @mobile  @addressy
Scenario Outline: Complete registration with valid details from SignIn Page
	Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should be registered successfully with complete details
	
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    		   | apartment  | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| SPEEDO | speedotest@testmail.com | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1 			| Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | January | 1    |               |            |                                                            |               |      |

@id=3 @negative @parallel @registration_login_module @brand=SP @mobile  @addressy
Scenario Outline: Complete registration without providing details from SignIn Page
	Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>

	Examples:
	| brand  | email                    | password  | firstName |  lastName  |     address    		  |    apartment    |         city         |      country      |    state    |   zip   |    phone     |  gender |  bMonth   |  bDay  |  prefCountry  | prefState  |                          prefStore                              | communication | type | error  							  |
	| SPEEDO | miss1+speedo@yopmail.com | abcdef123 | test      |   User     |   1200 US Highway 22   |    1    		|     Bridgewater      |   United States   |  New Jersey |  08807  |   123456789  |   Male  |  January  |    1   |               |            |                                                                 |               |      | The first name field cannot be empty |
#	| SPEEDO | miss2+speedo@yopmail.com | abcdef123 | Test PVH  |            |   1200 US Highway 22   |    1    		|     Bridgewater      |   United States   |  New Jersey |  08807  |   1234567890 |   Male  |  January  |    1   |               |            |                                                                 |               |      | The last name field cannot be empty  |

@id=4 @positive @parallel @registration_login_module @brand=SP @mobile
Scenario Outline: Register with valid details post checkout as Guest User
	Given User access <brand> website
    And User searches on mobile an <item> with style number and adds it to cart
#    When User provides <guestFields> into address fields
#	And User submit order using credit card <type>, <number>, <code>, <expMonth>, <expYear>
	And User provide <email> , <firstName> , <lastName> , <address> , <apartment> , <city> , <state> , <country> , <zip> , <phone> into shipping information
	When User provide <password> on mobile checkout page
	Then User should be registered successfully
	
	Examples:
	| brand  | item     | email                     | password | firstName  | lastName | address            | apartment | city        | state      | country       | zip    | phone      | guestFields                                                                               		 | type | number           | code | expMonth | expYear |
	| SPEEDO | 7530331  | testingUser@yopmail.com   | Passw0rd | Bobby	    | Smith    | 1200 US Highway 22 | 15        | Bridgewater | New Jersey |               | 08807  | 9085262900 |testingUser1@yopmail.com;Bobby;Smith;1200 US Highway 22;;Bridgewater;New Jersey; ;08807;1234567890 | VISA | 4111111111111111 | 456  | 10       | 2020    | 

#@id=5 @negative @parallel @registration_login_module
#Scenario Outline: Complete Registration when providing invalid address and submitting 3 times
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User provide <email> , <password> and register
#	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
#	When User submits invalid address 3 times
#	Then User should be registered successfully with complete details
	
#@id=6 @negative @parallel @registration_login_module
#Scenario Outline: Partial registration with invalid details from SignIn Page

#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User provide <email> , <password> and register
#	Then User should get error message <error>
	
#@id=7 @negative @parallel @registration_login_module
#Scenario Outline: Registration without providing details from SignIn Page
#	Given User access <brand> website
#	When User navigate to mobile login page
#	And User provide <email> , <password> and register
#	Then User should get error message <error>
	

@id=8 @negative @parallel @registration_login_module @brand=SP @mobile  @addressy
Scenario Outline: Complete registration with invalid details from SignIn Page
	Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>

	Examples:
	| brand  | email                    | password  | firstName | lastName | address   		    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | error                                              |
	| SPEEDO | inv1speedo               | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1 		| Bridgewater | United States | New Jersey | abcde | 1234567890 | Male   | January | 1    |               |            |                                                            |               |      | The email entered is not in a valid                |
#	| SPEEDO | inv2+speedo@testmail.com | abcd      | Test PVH  | User     | 1200 US Highway 22 | 1 		| Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | January | 1    |               |            |                                                            |               |      | You entered a password with less than 6 characters |
