@module=navigationTH
Feature: Navigation TH
Description: Navigating to different departments

@id=1 @positive @parallel @navigation_module
Scenario Outline: Verify on selecting department from header user is navigated to correct department landing page
	Given User access <brand> website
	Then User verifies header links work
	
	Examples:
	| brand  | 
	| TH     |

@id=2 @positive @parallel @navigation_module
Scenario Outline: Verify department category links go to correct page
	Given User access <brand> website
	Then User verifies <dept>, <links>, go to correct page

	Examples:
	| brand  | dept 	|	 links						    |
	| TH	 | 	men 	|	trunks;belts;boots       	    |
	
 @id=3 @positive @parallel @navigation_module
Scenario Outline: Verify department category link breadcrumbs on cat pages revert back to department
	Given User access <brand> website
	Then User verifies <dept>, <links>, breadcrumbs go to correct department page

	Examples:
	| brand  |  dept 	|	 links						    |
	| TH 	 | 	men	    |	trunks;belts;boots         	    |	

@id=4 @positive @parallel @navigation_module
Scenario Outline: Verify department category links can reach product page
	Given User access <brand> website
	Then User verifies <dept>, <links>, pages can go to item pages

	Examples:
	| brand  |  dept 	|	 links						    |
	| TH 	 | 	 men	|	trunks;belts;boots      	    |
	
@id=5 @positive @parallel @navigation_module
Scenario Outline: verify cart button brings you to the cart
	Given User access <brand> website
	Then User verifies bag link works

	Examples:
	| brand  | 
	| TH     |
	
@id=6 @positive @parallel @navigation_module
Scenario Outline: verify cart button brings you to the cart
	Given User access <brand> website
	Then User verifies sign in link works

	Examples:
	| brand  | 
	| TH     |