@module=loginCKMobile
Feature: Login CK Mobile
	Description: This feature allows user to access account using their registered credentials 

@id=1 @positive @smokeT @prod @parallel @registration_login_module @brand=CKMobile @mobile
Scenario Outline: Login with valid credentials
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	Then User should be login successfully
	
	Examples:
	| brand | email                     | password |
	| CKUS  | myaccountckus43@gmail.com | Passw0rd |
	| CKCA  | myaccountckca43@gmail.com | Passw0rd |

@id=2 @negative @parallel @registration_login_module @brand=CKMobile @mobile
Scenario Outline: Login with invalid credentials
	Given User access <brand> website
	When User navigate to mobile login page
	And User try to login using <email> and <password>
	Then User should get error message <error>
	
	Examples:
	| brand | email                     | password | error                                                        |
	| CKUS  | myaccountckca43@gmail.com | invalid1 | The email or password you entered does not match our records |
	| CKCA  | myaccountckca43@gmail.com | invalid1 | The email or password you entered does not match our records |
	
#@id=3 @negative @parallel @registration_login_module
#Scenario Outline: Attempt to login with invalid password more then 5 times
#	Given User access <brand> website
#	When User navigate to login page
#	And User login using <email> and <password> more then 5 times
#	Then User should get error message <error>
	
#	Examples:
#	| brand | email              | password | error                                                 |
#	| CKCA  | test1@testmail.com | Calvin33 | Wait a few seconds before attempting to log in again. |
#	| CKUS  | test1@testmail.com | Calvin33 | Wait a few seconds before attempting to log in again. |
	
@id=4 @positve @parallel @registration_login_module @brand=CKMobile @mobile
Scenario Outline: Login with new password after resetting password
	Given User access <brand> website
	When User navigate to mobile login page
	And User provide <email> , <password> and register
	And User provide <firstName> , <lastName> , <address> , <apartment> , <city> , <country> , <state> , <zip> , <phone> , <gender> , <bMonth> , <bDay> , <prefCountry> , <prefState> , <prefStore> , <communication> , <type> and save
    And User reset mobile password <newPassword>
	And User try to login using new password
	Then User should be login successfully
	
	Examples:
	| brand  | email                   | password  | firstName | lastName | address    | apartment | city        | country       | state      | zip   | phone      | gender | bMonth  | bDay | prefCountry   | prefState  | prefStore   | communication | type | newPassword |
	| CKUS   | ckustest@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |             |               |      |  Calvin2    |
	| CKCA   | ckcatest@testmail.com   | abcdef123 | Test PVH  | User     | 1200 US 22 | Qualitest | Bridgewater | United States | New Jersey | 08807 | 1234567890 | Male   | 1       | 1    |               |            |             |               |      |  Calvin3    |
	