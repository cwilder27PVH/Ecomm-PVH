package com.qualitest.core.uimap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends BasePage {
	public static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);
	
	
	/**
	 *  Page objects start here
	 */
	
	@FindBy (id ="txtUserName")
	private WebElementFacade userName;

	@FindBy (id ="txtPassword")
	private WebElementFacade password;

	@FindBy (id ="LinkButton1")
	private WebElementFacade loginButton;

	@FindBy(xpath ="//a[2]//div[1]")
	private BaseElement tommyPage;

//	@FindBy(xpath = "//*[@class = 'selectBrands fadeInRight animated'][1]")
//	@FindBy(xpath ="//a[2]")
	//private WebElementFacade tommyPage;
	
	

	/**
	 *  Page objects ends here
	 */
	
	

	/**
	 *  Start of click functions
	 * @throws InterruptedException 
	 */
	
	public void navigateToTommy () throws InterruptedException{
		//sleep(3000);

		System.out.println("testing here");
		Thread.sleep(5000);
		if(tommyPage.exists()) {
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
		tommyPage.waitUntilVisible();
		System.out.println("Page visibility: " + tommyPage.isCurrentlyVisible());
		System.out.println("Page clickable: " + tommyPage.isClickable());
		System.out.println("Page enabled: " + tommyPage.isEnabled());
		tommyPage.waitUntilClickable().click();
		
	}
	
	public void clickLogin() {
		loginButton.click();
	}
	

	/**
	 *  End of click functions
	 */
	

	/**
	 *  Start of text functions
	 */
	
	public void enterUserID(String un) {
		
		userName.sendKeys(un);
		
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	

	/**
	 *  End of text functions
	 */

}
