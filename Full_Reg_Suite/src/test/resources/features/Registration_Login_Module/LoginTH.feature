@module=loginTH
Feature: Login TH
	Description: This feature allows user to access account using their registered credentials 

Background:
	Given User navigates to Tommy Hilfiger Webstore
	And User logs out if already logged in
	When User navigate to login page

@id=1 @positive @smokeT @prod @registration_login_module @brand=TH @desktop
Scenario Outline: Login with valid credentials
#	Given User access <brand> website
#	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully
	
	Examples:
	| brand | email                   | password |
	| TH    | myaccountth43@gmail.com | Passw0rd |

@id=2 @negative @registration_login_module @brand=TH @desktop
Scenario Outline: Login with invalid credentials
#	Given User access <brand> website
#	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should get error message <error>
	
	Examples:
	| brand | email                     | password | error                                               |
	| TH    | myaccountth43@gmail.com   | invalid1 | EITHER THE E-MAIL OR PASSWORD ENTERED IS INCORRECT. |

#@id=3 @negative @parallel @registration_login_module
#Scenario Outline: Attempt to login with invalid password more then 5 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User login using <email> and <password> more then 5 times
#	Then User should get error message <error>
	
#	Examples:
#	| brand | email              | password | error                                                |
#	| TH    | test1@testmail.com | Tommy33  | WAIT A FEW SECONDS BEFORE ATTEMPTING TO LOG IN AGAIN |
	
@id=4 @positve @registration_login_module @brand=TH @desktop
Scenario Outline: Login with new password after resetting password
#	Given User access <brand> website
#	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User reset password <newPassword>
	And User try to login using new password
	Then User should be login successfully
	
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore                                                  | communication | type | newPassword |
	| TH     | thtest@testmail.com     | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 7326368321 | Male   | January | 12   | United States | New Jersey | Garden State Plaza - 1 Garden State Plaza Way, Paramus, NJ | web           | men  | Tommy3      |