@module=navigation
Feature: Navigation
Description: Navigating to different departments

@id=1 @positive @parallel @navigation_module
Scenario Outline: Verify on selecting department from header user is navigated to correct department landing page
	Given User access <brand> website
	Then User verifies header links work
	
	@brand=CKUS
	Examples:
	| brand	 |
	| CKUS 	 | 

	@brand=CKCA
	Examples:
	| brand	 |
	| CKCA   | 

	@brand=TH
	Examples:
	| brand  | 
	| TH     |
	
	@brand=SPEEDO
	Examples:
	| brand  | 
	| SPEEDO |

@id=2 @positive @parallel @navigation_module
Scenario Outline: Verify department category links go to correct page
	Given User access <brand> website
	Then User verifies <dept>, <links>, go to correct page
	
	@brand=CKUS
	Examples:
	| brand	 | dept 	|	 links						    |
	| CKUS	 | 	205w39nyc	|	dresses;handbags;shoes	    |	

	@brand=CKCA
	Examples:
	| brand	 | dept 	|	 links						    |
	| CKCA 	 | 	women	|	dresses;sweaters;outerwear	    |

	@brand=TH
	Examples:
	| brand  | dept 	|	 links						    |
	| TH	 | 	men 	|	trunks;belts;boots       	    |
	
	@brand=SPEEDO
	Examples:
	| brand  | dept 	    |	 links					     |
	| SPEEDO | teams	    |	womens;mens                  |
	
 @id=3 @positive @parallel @navigation_module
Scenario Outline: Verify department category link breadcrumbs on cat pages revert back to department
	Given User access <brand> website
	Then User verifies <dept>, <links>, breadcrumbs go to correct department page
	
	@brand=CKUS
	Examples:
	| brand	 | dept 	|	 links						    |
	| CKUS	 | 	205w39nyc	|	dresses;handbags;shoes	    |	

	@brand=CKCA
	Examples:
	| brand	 | dept 	|	 links						    |
	| CKCA 	 | 	women	|	dresses;sweaters;outerwear	    |	

	@brand=TH
	Examples:
	| brand  |  dept 	|	 links						    |
	| TH 	 | 	men	    |	trunks;belts;boots         	    |	
	
	@brand=SPEEDO
	Examples:
	| brand  |  dept 	|	 links						    			| 
	| SPEEDO | 	kids	|	 footwear;girls swimwear;boys swimwear	    | 

@id=4 @positive @parallel @navigation_module
Scenario Outline: Verify department category links can reach product page
	Given User access <brand> website
	Then User verifies <dept>, <links>, pages can go to item pages
	
	@brand=CKUS
	Examples:
	| brand	 | dept 	|	 links						    |
	| CKUS	 | 	205w39nyc	|	dresses;handbags;shoes	    |	

	@brand=CKCA
	Examples:
	| brand	 | dept 	|	 links						    |
	| CKCA	 | 	women	|	dresses;sweaters;outerwear	    |
	
	@brand=TH
	Examples:
	| brand  |  dept 	|	 links						    |
	| TH 	 | 	 men	|	trunks;belts;boots      	    |
	
	@brand=SPEEDO
	Examples:
	| brand      | dept 	|	 links						                |
	| SPEEDO	 | kids 	|	footwear;girls swimwear;boys swimwear	    | 	
	
@id=5 @positive @parallel @navigation_module
Scenario Outline: verify cart button brings you to the cart
	Given User access <brand> website
	Then User verifies bag link works
	
	@brand=CKUS
	Examples:
	| brand	 |
	| CKUS 	 | 

	@brand=CKCA
	Examples:
	| brand	 |
	| CKCA   | 

	@brand=TH
	Examples:
	| brand  | 
	| TH     |
	
	@brand=SPEEDO
	Examples:
	| brand  | 
	| SPEEDO |
	
@id=6 @positive @parallel @navigation_module
Scenario Outline: verify cart button brings you to the cart
	Given User access <brand> website
	Then User verifies sign in link works
	
	@brand=CKUS
	Examples:
	| brand	 |
	| CKUS 	 | 

	@brand=CKCA
	Examples:
	| brand	 |
	| CKCA   | 

	@brand=TH
	Examples:
	| brand  | 
	| TH     |
	
	@brand=SPEEDO
	Examples:
	| brand  | 
	| SPEEDO | 
