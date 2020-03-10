package com.qualitest.pvh.pages;

import com.qualitest.core.element.BaseElement;
import net.serenitybdd.core.annotations.findby.FindBy;

public class SpeedoOrderSummaryPage extends OrderSummaryPage{

	@FindBy(xpath = "//a[@title = 'Go to the My Account page']")
	private BaseElement myAccount;
	
	@FindBy(xpath = "//*[@id='orderCancelMessage']/a")
	private BaseElement cancelOrder;

	@FindBy(xpath = "//*[@id=\"shoppingBagColumn2\"]/div[4]")
	private BaseElement cancellationField;
	
	@FindBy(xpath = "//*[@id='orderCancelSection']/div/a[1]")
	private BaseElement agreeToCancel;
	
	public void clickMyAccount() {
		pageRefresh();
		sleep(2000);
		myAccount.click();
	}
	public void clickCancelOrder() {
		sleep(500);
		cancelOrder.click();
		sleep(1000);
		agreeToCancel.click();
		sleep(1000);
	}
	
	@Override
	public void verifyCancellation()
	{
		sleep(1000);
		cancelOrder.click();
		sleep(500);
		agreeToCancel.click();
		sleep(1000);
		SA.assertThat(cancellationField.getText().toUpperCase().contains("THE ORDER HAS BEEN CANCELED SUCCESSFULLY")).isTrue();
		SA.assertAll();
	}
	
}
