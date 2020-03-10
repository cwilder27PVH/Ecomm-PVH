package com.qualitest.pvh.pages;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://vh-b2cna-pq1.pvh.com/en")
public class PBFooter extends PBHomePage {

	protected SoftAssertions SA = new SoftAssertions();
	
	@FindBy(xpath = "//*[@id='footerNav']/div[1]/ul/li/a")
	private List<WebElement> footerSection1;
	
	@FindBy(xpath = "//*[@id='footerNav']/div[2]/ul/li/a")
	private List<WebElement> footerSection2;
	
	@FindBy(xpath = "//*[@id='footerNav']/div[3]/ul/li/a")
	private List<WebElement> footerSection3;
	
	@FindBy(xpath = "//*[@id='footerNav']/div[4]/ul/li/a")
	private List<WebElement> footerSection4;
	
	@FindBy(xpath = "//*[@id='footerNav']/div/ul/li/a")
	private List<WebElement> allFooterLinks;

	private static final Logger LOGGER = LoggerFactory.getLogger(PBFooter.class);
	
	/**
	 * Method to verify footer and links exist
	 */
	
	public void verifyFooterExists()
	{
		LOGGER.info("Verifying Footer is Displayed");
		//calls method to check if text is displayed
		CheckFooterText(footerSection1);
		CheckFooterText(footerSection2);
		CheckFooterText(footerSection3);
		CheckFooterText(footerSection4);
		//calling method to make sure links go
		ClickFooterLinks(footerSection1);
		ClickFooterLinks(footerSection2);
		ClickFooterLinks(footerSection3);
		ClickFooterLinks(footerSection4);
		
		
		SA.assertAll();
		
	}
	

	public void checkFooterLinkGoesToCorrespondingPage(String category){		
		for(int i = 0;i < allFooterLinks.size(); i++){
			//name of the category we are searching in footer;
			String nameOfFootCategory = allFooterLinks.get(i).getText();
			LOGGER.debug("Checking Text of Link : " + nameOfFootCategory);
			if(category.toUpperCase().equals(nameOfFootCategory.toUpperCase())) {
				allFooterLinks.get(i).click();
				Boolean isThere = false;
				switch(nameOfFootCategory.toUpperCase()) {
				
		          case "FAQS":
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'frequently asked questions')]")).size() > 0  ;
		              break;
		          case "ORDER STATUS": 
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Track By Order Number')]")).size() > 0;
		                 break;
		          case "PREFERRED LOYALTY PROGRAM": 
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Returning Customer')]")).size() > 0;
		                 break;
		          case "STORE LOCATOR":
		        	  isThere = getDriver().findElements(By.xpath("//h2[contains( text(), 'Find a store near you')]")).size() > 0;
		                 break;
		          case "CALVIN KLEIN JEANS":
		        	  isThere = getDriver().getCurrentUrl().contains("/jeans");
		              break;
		          case "WOMEN'S JEANS": 
		        	  isThere = getDriver().getCurrentUrl().contains("calvin-klein-jeans-women"); 
		                 break;
		          case "MEN'S JEANS":
		        	  isThere = getDriver().getCurrentUrl().contains("calvin-klein-jeans-men");	
		        	  	 break;
		          case "WATCHES + JEWELRY":
		        	  isThere = getDriver().getCurrentUrl().contains("watches-jewelry"); 
		                 break;
		          case "ABOUT CALVIN KLEIN":
		        	  isThere = getDriver().findElements(By.xpath("//h1[contains( text(), 'About CALVIN KLEIN, INC.')]")).size() > 0;
		              break;
		          case "CAREERS": 
		        	  isThere = getDriver().getCurrentUrl().equals("https://www.pvh.com/people/work-with-us");	 
		                 break;
		          case "EMAIL US":
		        	  	isThere = true;
		        	  	 break;
		          default:
		        	  isThere = pageTitleOrLinkContainsWord(nameOfFootCategory);
		          }
				LOGGER.debug("isThere is: "+isThere+" for iteration "+i);
				assertThat(isThere).isTrue();	 
				getDriver().navigate().back();
				clickOffPopUp();
				sleep(1500);
				break;
			}	
		}
	}


	public void verifyFooterNamesExists(String names)
	{
		int curPos = 0;
		LOGGER.info("Verifying Footer Names Are Displayed");
		//calls method to check if text is displayed
		curPos = CheckFooterTextWithNames(footerSection1,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection2,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection3,names,curPos);
		curPos = CheckFooterTextWithNames(footerSection4,names,curPos);		
	}
	
}
	
	
	
	
	
	
