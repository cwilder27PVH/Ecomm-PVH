@module=footerSP
Feature: Footer SP
Description: This feature verifys links including the footer and department tabs

@id=1 @positive @parallel @navigation_module @brand=SP
Scenario Outline: Verfiy that footer links exist
	Given User access <brand> website
	Then User verifies <footernames> exists
	
	Examples:
	| brand  | footernames |
	| SPEEDO | call 1-888-4speedo;customer service;accessibility;speedo size chart;become a dealer;become a sponsored team;order status;shipping & delivery;return policy;payment options;racing swimsuits;training swimwear;triathlon gear;lifeguard swimsuits;water polo gear;aquatic fitness;aquatic fitness;lap swimming;in the water;on land;kids - begin to swim;women's swimwear;men's swimwear;swim goggles;kids swimwear;swim gear & equipment;swim caps;overview;training;gear;classes|
	
@id=2 @positive @parallel @navigation_module @brand=SP
Scenario Outline: Verify department category links go to correct pages
	Given User access <brand> website
	Then User verifies footer links go to correct page <category>
	
	Examples:
	| brand  | category     |
	| SPEEDO | Order Status |
