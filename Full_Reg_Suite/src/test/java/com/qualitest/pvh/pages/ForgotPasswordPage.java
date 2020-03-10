package com.qualitest.pvh.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.element.BaseElement;
import com.qualitest.core.page.BasePage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public abstract class ForgotPasswordPage extends BasePage {
	
	
	
	@FindBy(id="PasswordResetForm_FormInput_logonId_In")
	public BaseElement resetEmail;
	
	@FindBy(id="WC_PasswordResetForm_Link_2")
	public BaseElement submitResetEmail;
	
	@FindBy(xpath="//*[@id=\"myAccountBodyHeaderContent\"]/h2")
	public BaseElement confirmation;
	
	public static final Logger LOGGER = LoggerFactory.getLogger(ForgotPasswordPage.class);
	
	@Step
	public void inputResetEmail(String input) {
		resetEmail.type(input);
	}
	
	@Step
	public void clickSubmitEmail() {
		submitResetEmail.click();
	}
	
	@Step
	public void confirmResetPasswordEmailSent() {
		if( (Serenity.sessionVariableCalled("brand").equals("CKUS") || Serenity.sessionVariableCalled("brand").equals("CKCA") )  && confirmation.isCurrentlyVisible()) {
			WebElement web_Element_To_Be_Hovered = getDriver().findElement(By.xpath("//*[@class = 'signUpEmail full-width text-center']"));
			Actions builder = new Actions(getDriver());
			builder.moveToElement(web_Element_To_Be_Hovered).build().perform();
		}
		assertTrue("Not Confirmed", confirmation.getText().contains("THANK YOU"));
	}
	

}