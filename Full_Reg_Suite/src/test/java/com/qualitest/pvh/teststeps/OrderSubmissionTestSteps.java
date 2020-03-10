package com.qualitest.pvh.teststeps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.pvh.actors.CKActor;
import com.qualitest.pvh.actors.SpeedoActor;
import com.qualitest.pvh.actors.THActor;

import cucumber.api.java.en.And;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;

public class OrderSubmissionTestSteps {

	@Steps
	CKActor ckUser;

	@Steps
	THActor thUser;

	@Steps
	SpeedoActor speedoUser;

	protected static final Logger LOGGER = LoggerFactory.getLogger(OrderSubmissionTestSteps.class);
	
	@And("^User place (.*) orders for product (.*) using billing address (.*) and credit card (.*), (.*), (.*), (.*), (.*)$")
	public void user_place_orders (int totalOrderCount, String styleNumber, String address, String ccType, String ccNumber, String ccCode, String ccExpMonth, String ccExpYear) {
		LOGGER.info("Placing " + totalOrderCount + " orders for product " + styleNumber + " using " + ccType + " credit card...");
		String brand = Serenity.sessionVariableCalled("brand");

		switch (brand.toUpperCase()) {
		case "CKUS":
			ckUser.placeOrder(totalOrderCount,styleNumber,address,ccType,ccNumber,ccCode,ccExpMonth,ccExpYear);
			break;
		case "CKCA":
			ckUser.placeCKCAOrder(totalOrderCount,styleNumber,address,ccType,ccNumber,ccCode,ccExpMonth,ccExpYear);
			break;
		case "TH":
			thUser.placeOrder(totalOrderCount,styleNumber,address,ccType,ccNumber,ccCode,ccExpMonth,ccExpYear);
			break;
		case "SPEEDO":
			speedoUser.placeOrder(totalOrderCount,styleNumber,address,ccType,ccNumber,ccCode,ccExpMonth,ccExpYear);
			break;
		default:
			LOGGER.info("Incorrect Brand: " + brand + " provided. Expected Brands are: CKUS, CKCA, TH, SPEEDO");
		}
	}

}