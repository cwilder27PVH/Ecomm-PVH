package com.qualitest.pvh.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;

public class THOrderSummaryPage extends OrderSummaryPage{

	private static final Logger LOGGER = LoggerFactory.getLogger(THOrderSummaryPage.class); 
	
	
	@FindBy(xpath = "//*[@id=\"shoppingBagColumn2\"]/div[4]")
	private BaseElement cancellationField;
	
	@FindBy(xpath = "//*[@id='orderCancelSection']/div/a[1]")
	private BaseElement agreeToCancel;
	
	@FindBy(xpath = "//*[@id='orderCancelButton']")
	private BaseElement cancelOrder;
	
	@FindBy(xpath = "//*[@id = 'orderCancelMessage']/a")
	private BaseElement cancelOrder2;
	@Override
	/**
	 * Method to close pop up displayed on order summary page
	 */
	@Step
	protected void clickOffPopUp() {
		LOGGER.info("Closing pop up displayed on order summary page");
		try {
			find(By.xpath("//*[@id='pvhOverlayContentWrapper']/div[2]")).waitUntilVisible().click();
			try {
				find(By.xpath("(//img[@alt='Close Dialog'])[2]")).waitUntilVisible().click();
			} catch (Exception e) {
				find(By.xpath("//img[@alt='Close Dialog']")).waitUntilVisible().click();
			}
		} catch (Exception e1) {
			try {
				find(By.xpath("(//img[@alt='Close Dialog'])[2]")).waitUntilVisible().click();
			} catch (Exception e2) {
				try {
					find(By.xpath("//*[@id='pvhOverlayContentWrapper']/div[2]")).waitUntilVisible().click();
				} catch (Exception e3) {
					
				}
			}
		}
	}
	
	@Override
	/**
	 * Method to verify details on order summary page
	 * @param name - Name of product
	 * @param price - Order total
	 * @param cardType - Credit Card Type
	 */
	@Step
	public void verifyOrderDetails(String name, float price, String cardType) {
		clickOffPopUp();
		clickOffPopUp();
		clickOffPopUp();
		//if(!cancelOrder.isCurrentlyVisible())
		//{
		//	if(find(By.xpath("//*[@id='pvhOverlayContentWrapper']/div[2]")).isVisible())
		//	{
			//	clickOffPopUp();
		//	}
		//}
		
		LOGGER.info("Name of first product displayed on order summary page is: " + getNameOfProduct(0));
		SA.assertThat(getNameOfProduct(0)).isEqualTo(name);
		
		float i = getOrderTotal();
		LOGGER.info("Order total displayed on order summary page is: " + i);
		if(!appliedGiftCard.exists()) {
			SA.assertThat(i).isEqualTo(price);
		}else if(appliedGiftCard.exists()) {
			SA.assertThat(i).isEqualTo(price-100);
		}
		
		String card = getCardType();
		LOGGER.info("Credit card type displayed on order summary page is: " + card);
		SA.assertThat(card).isEqualTo(cardType);
		
		SA.assertAll();
	}
	
	@Override
	@Step
	public void verifyCancellation()
	{
		sleep(2000);
		cancelOrder.click();
		agreeToCancel.click();
		SA.assertThat(cancellationField.getText().contains("THE ORDER HAS BEEN CANCELED SUCCESSFULLY")).isTrue();
		SA.assertAll();
	}
	
	/**
	 * Method to click cancel order on order summary page
	 */
	public void cancelOrder() {
		LOGGER.info("Clicking cancel order");
		//sleep(2000);
		cancelOrder2.waitUntilClickable().click();
		agreeToCancel.waitUntilClickable().click();
	}
	
}
