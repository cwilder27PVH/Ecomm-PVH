@module=registrationPB
Feature: Registration PB
Description: This feature allows user to create an account

Background:
	Given User navigates to Heritage Brands Webstore
	And User logs out if already logged in

@id=1 @positive @parallel @registration_login_module @brand=PB @desktop
Scenario Outline: Partial registration with valid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should be registered successfully without complete details

	Examples:
	| brand | email                 | password  |
	| VH    | testvh@testmail.com   | abcdef123 |

@id=2 @positive @smokeT @prod @parallel @registration_login_module @brand=PB @desktop  @addressy
Scenario Outline: Complete registration with valid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should be registered successfully with complete details
	
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    			| apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay |
	| VH     | cktest@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US Highway 22  | 1 		| Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |

@id=3 @negative @parallel @registration_login_module @brand=PB @desktop  @addressy
Scenario Outline: Complete registration without providing details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>

	Examples:
	| brand  | email                   | password  | firstName | lastName | address    		   | apartment  | city        | country       | state      | zip   | phone      | gender |  bMonth |  bDay  | error                                |
	| VH     | miss1+vh@yopmail.com    | abcdef123 |  test     | User     | 1200 US Highway 22 | 1 			|  			  | United States | New Jersey | abcde | 9085262900 | Male   |  1      |   12   | The first name field cannot be empty |
#	| TH     | miss2+vh@yopmail.com    | abcdef123 | Test PVH  |          | 1200 US Highway 22 | 1			| Bridgewater | United States | New Jersey | 08807 | 9085262900 | Male   |  1      |   12   | The last name field cannot be empty  |

@id=4 @positive @parallel @registration_login_module @brand=PB @desktop
Scenario Outline: Register with valid details post checkout as Guest User
#	Given User access <brand> website
    And User searches an <item> with style number and adds it to cart
	And User provide <email> , <firstName> , <lastName> , <address> , <apartment> , <city> , <state> , <country> , <zip> , <phone> into shipping information
	When User provide <password> on checkout page
	Then User should be registered successfully
	
	Examples:
	| brand  | item   	| email                     | password | firstName | lastName | address         | apartment | city        | state      | country       | zip    | phone      |
	| VH     | van8293  | testingUser@yopmail.com   | 1qaz@WSX | Bobby     | Smith    | 1200 US Highway 22      | 15    | Bridgewater | New Jersey |               | 08807  | 1234567890 |

@id=5 @negative @parallel @registration_login_module @brand=PB @desktop  @addressy
Scenario Outline: Complete Registration when providing invalid address and submitting 3 times
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	When User submits invalid address 4 times
	Then User should be registered successfully with complete details
	
	Examples:
	| brand | email                    | password  | firstName | lastName | address    | apartment | city   | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type |
	| VH    | invadd1+vh@yopmail.com   | abcdef123 | Test PVH  | User     | 1200       | 1 		   | texas  | United States | New Jersey | 08807 | 9085262900 | Male   | 1       | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  |
	

@id=6 @negative @parallel @registration_login_module @brand=PB @desktop
Scenario Outline: Partial registration with invalid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should get error message <error>

	Examples:
	| brand | email                   | password | error                                       |
	| VH    | testregisterckca1       | 1qaz@WSX | The email entered is not in a valid format. |
#	| VH    | testregisterckca1@gmail | 1qaz@WSX | The email entered is not in a valid format. |
	

@id=7 @negative @parallel @registration_login_module @brand=PB @desktop
Scenario Outline: Registration without providing details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	Then User should get error message <error>
	
	Examples:
	| brand | email | password | error                            |
	| VH    |       |          | The email field cannot be empty. |
	

@id=8 @negative @parallel @registration_login_module @brand=PB @desktop  @addressy
Scenario Outline: Complete registration with invalid details from SignIn Page
#	Given User access <brand> website
	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	Then User should see error message on registration page <error>
	
	Examples:
	| brand  | email                    | password  | firstName | lastName | address    		| apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | error             |
	| VH     | inv1+vh@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US Highway 22 | 1 		| Bridgewater | United States | New Jersey | abcde | 9085262900 | Male   | 1       | 12   | Address Not Found | 
#	| VH     | inv2+vh@testmail.com     | abcdef123 | Test PVH  | User     | 22         		| 1 		| Bridgewater | United States | New Jersey | 08807 | 9085262900 | Male   | 1       | 12   | Invalid Address   |
	
	