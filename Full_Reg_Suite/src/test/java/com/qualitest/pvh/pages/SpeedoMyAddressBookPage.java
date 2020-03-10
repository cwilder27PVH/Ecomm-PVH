package com.qualitest.pvh.pages;

import org.assertj.core.api.SoftAssertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpeedoMyAddressBookPage extends MyAddressBookPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(MyAddressBookPage.class);
	
	public void enterDefaultShippingAndBillingAddressFieldsAndSubmit(String guestFields) {
		String[] arr = guestFields.split(";");
		if(arr.length != 8) {
			LOGGER.info("Incomplete address information provided");
		}
		clickOnShippingAndBillingAddress();
		enterFirstName(arr[0]);
		enterLastName(arr[1]);
		clickEnterManual();
		if(!arr[2].equals(" ")) {
			enterAddress(arr[2]);
		}
		if(!arr[3].equals(" ")) {
			enterApartment(arr[3]);
		}
		enterCity(arr[4]);
		selectState(arr[5]);
		enterZip(arr[6]);
		enterPhone(arr[7]);
		clickUpdate();
		sleep(5000);
	}

}
