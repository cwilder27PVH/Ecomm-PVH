@module=loginSP
Feature: Login SP
	Description: This feature allows user to access account using their registered credentials 
	
Background:
	Given User navigates to Speedo Webstore
	And User logs out if already logged in
	When User navigate to login page

@id=1 @positive @smokeT @prod @parallel @registration_login_module @brand=SP @desktop
Scenario Outline: Login with valid credentials
#	Given User access <brand> website
#	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should be login successfully

	Examples:
	| brand  | email                       | password |
	| SPEEDO | myaccountspeedo43@gmail.com | Passw0rd |

@id=2 @negative @parallel @registration_login_module @brand=SP @desktop
Scenario Outline: Login with invalid credentials
#	Given User access <brand> website
#	When User navigate to login page
	And User try to login using <email> and <password>
	Then User should get error message <error>

	Examples:
	| brand  | email                       | password | error                  	                     	   |
	| SPEEDO | myaccountspeedo43@gmail.com | invalid1 | Either the E-mail or password entered is incorrect |

#@id=3 @negative @parallel @registration_login_module
#Scenario Outline: Attempt to login with invalid password more then 5 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User login using <email> and <password> more then 5 times
#	Then User should get error message <error>

#	Examples:
#	| brand  | email              | password | error                                                 |
#	| SPEEDO | test1@testmail.com | Speedo33 | Wait a few seconds before attempting to log in again. |

@id=4 @positve @parallel @registration_login_module @brand=SP @desktop
Scenario Outline: Login with new password after resetting password
#	Given User access <brand> website
#	When User navigate to login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
	And User reset password <newPassword>
	And User try to login using new password
	Then User should be login successfully
	
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore  | communication | type | newPassword |
	| SPEEDO | speedotest@testmail.com | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | January | 1    |               |            |            |               |      | Speedo2     |
	
