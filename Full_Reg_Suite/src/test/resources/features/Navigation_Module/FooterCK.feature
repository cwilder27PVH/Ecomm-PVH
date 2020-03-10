@module=footerCK
Feature: Footer CK
Description: This feature verifys links including the footer and department tabs

@id=1 @positive @parallel @navigation_module @brand=CK
Scenario Outline: Verfiy that footer links exist
	Given User access <brand> website
	Then User verifies <footernames> exists
	
	Examples:
	| brand	 | footernames |
	| CKUS 	 | faqs;order status;returns;shipping;coupons;preferred loyalty program;store locator;accessibility;women's underwear;men's underwear;calvin klein jeans;women's jeans;men's jeans;watches + jewelry;about calvin klein;about raf simons;careers;student discount;email us|
	| CKCA   | shipping;returns;track order;coupons;women's size guide;men's size guide;kids's size guide;preferred customer program;store locator;accessibility;205w39nyc;women;men;kids;underwear;women's underwear;men's underwear;sale;calvin klein jeans;about calvin klein;about raf simons;careers;projects;email us;|

@id=2 @positive @parallel @navigation_module @brand=CK
Scenario Outline: Verify department category links go to correct pages
	Given User access <brand> website
	Then User verifies footer links go to correct page <category>
	
	Examples:
	| brand	 | category      |
	| CKUS 	 | store locator |
	| CKCA   | coupons       |
