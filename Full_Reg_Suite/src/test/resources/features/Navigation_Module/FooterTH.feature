@module=footerTH
Feature: Footer TH
Description: This feature verifys links including the footer and department tabs

@id=1 @positive @parallel @navigation_module @brand=TH
Scenario Outline: Verfiy that footer links exist
	Given User access <brand> website
	Then User verifies <footernames> exists
	
	Examples:
	| brand  | footernames |
	| TH     | customer service;order status;your order;shipping;returns;size guide;my account;wish list;faqs;global site;corporate responsibility;careers;press;affiliate program;sitemap;terms & conditions;privacy policy;ca transparency in supply chain & uk modern slavery statement;accessibility|

@id=2 @positive @parallel @navigation_module @brand=TH
Scenario Outline: Verify department category links go to correct pages
	Given User access <brand> website
	Then User verifies footer links go to correct page <category>
	
	Examples:
	| brand  | category      |
	| TH     | FAQS          |