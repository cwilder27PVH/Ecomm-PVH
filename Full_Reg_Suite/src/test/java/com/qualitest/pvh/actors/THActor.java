package com.qualitest.pvh.actors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.actor.BaseActor;
import com.qualitest.core.manager.FileReaderManager;
import com.qualitest.core.util.EnvConfig;
import com.qualitest.pvh.pages.THAccountSummaryPage;
import com.qualitest.pvh.pages.THCartPage;
import com.qualitest.pvh.pages.THShippingPage;
import com.qualitest.pvh.pages.THCreateNewPasswordPage;
import com.qualitest.pvh.pages.THEditCartPage;
import com.qualitest.pvh.pages.THForgotPasswordPage;
import com.qualitest.pvh.pages.THHomePage;
import com.qualitest.pvh.pages.THItemPage;
import com.qualitest.pvh.pages.THMyAddressBookPage;
import com.qualitest.pvh.pages.THNewAddressPage;
import com.qualitest.pvh.pages.THOrderSummaryPage;
import com.qualitest.pvh.pages.THPersonalInformationPage;
import com.qualitest.pvh.pages.THQuickViewPage;
import com.qualitest.pvh.pages.THRegisterAtCheckOutPage;
import com.qualitest.pvh.pages.THRegistrationDetailsPage;
import com.qualitest.pvh.pages.THReviewOrderPage;
import com.qualitest.pvh.pages.THSearchResultsPage;
import com.qualitest.pvh.pages.THCheckoutPage;
import com.qualitest.pvh.pages.THCheckoutPreferences;
import com.qualitest.pvh.pages.THSignInPage;
import com.qualitest.pvh.pages.THStoreLocator;
import com.qualitest.pvh.pages.THWishlistPage;
import com.qualitest.pvh.pages.THMyOrdersPage;
import com.qualitest.pvh.testDataTypes.Account;

import net.serenitybdd.core.Serenity;

public class THActor extends BaseActor {

	private static final EnvConfig ENV = ConfigFactory.create(EnvConfig.class);
	private static final Logger LOGGER = LoggerFactory.getLogger(THActor.class);
	THAccountSummaryPage thASP;
	THCreateNewPasswordPage thCNPP;
	THCheckoutPage thCOP;
	THCartPage thCP;
	THCheckoutPreferences thCPP;
	THEditCartPage thECP;
	THForgotPasswordPage thFPP;
	THHomePage thHP;
	THItemPage thIP;
	THMyAddressBookPage thMABP;
	THMyOrdersPage thMOP;
	THNewAddressPage thNAP;
	THOrderSummaryPage thOSP;
	THPersonalInformationPage thPIP;
	THQuickViewPage thQVP;
	THRegisterAtCheckOutPage thRACOP;
	THRegistrationDetailsPage thRDP;
	THReviewOrderPage thROP;
	THSignInPage thSIP;
	THStoreLocator thSL;
	THShippingPage thSP;
	THSearchResultsPage thSRP;
	THWishlistPage thWLP;

	public void accountSignIn(String email, String password) {
		Account correctPassword = FileReaderManager.getInstance().getJsonDataReader()
				.getAccountPasswordByBrandAndEmail(Serenity.sessionVariableCalled("brand"), email);
		if (correctPassword != null) {
			password = correctPassword.password;
		}
		thSIP.accountSignIn(email, password);
	}
	public void accountSignInWithNewPassword(String email, String password) {
		thSIP.accountSignIn(email, password);
	}

	public void addAmountOfItems(int x, String item)
	{
		//	MM4182019 Added clickOFFpopUP here for closing the popup before the submit search
		thHP.clickOffPopUp();
		thHP.submitSearchFor(item);
		thSRP.pageRefresh();
		thSRP.sleep(500);
		thSRP.selectProduct(1);
		thIP.chooseRandomSizeandAddToBag();
		thIP.clickAddToBag();
		thIP.sleep(500);
		int iteration = 1;
		while(thCP.getNumItemsInBag() < x+2 && iteration < x+2)
		{
			LOGGER.info("Running iteration: "+iteration);
			thHP.getDriver().navigate().back();
			iteration++;
			thSRP.selectProduct(iteration);
			thIP.chooseRandomSizeandAddToBag();
			thIP.clickAddToBag();
			thHP.sleep(2000);
		}
	}

	public void navigateToAddressBook() {
		thASP.navigateToMyAddressBook();
	}

	public void addBillingAddress(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterBillingAddressFieldsAndSubmit(guestFields);
	}

	public void updateBillingAddress(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.findAndUpdateBillingAddress(guestFields);
	}

	public void updateBillingAndShippingAddress(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.findAndUpdateShippingAndBillingAddress(guestFields);
	}

	public void updateBillingAndShippingAddressFourTimes(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.updateExisitingShippingAndBillingAddressFieldsAndSubmitFourTimes(guestFields);
	}

	public void enterUpdateShippingAddressFieldsFourTimes(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.updateShippingAddressFieldsFourTimes(guestFields);
	}

	public void enterUpdateBillingAddressFieldsFourTimes(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterUpdateBillingAddressFieldsFourTimes(guestFields);
	}

	public void verifyUpdatedInvalidAddressAddressBook() {
		thMABP.verifyUpdatedInvalidAddress();
	}

	public void addCartItemToWishlist() {
		thCP.addToWishlist();
	}

	public void verifyAddingCartItemToMobileWishlistForGuestUSer() {
		thCP.verifyAddToWishlistOnMobileForGuestUser();
	}

	public void addGiftBox(String to, String from, String message) {
		thHP.sleep(500);
		thCP.addGiftBox(to, from, message);
	}


	public void addInvalidShippingAddress(String guestFields) {

		//thASP.navigateToMyAddressBook();
		thMABP.addInvalidShippingAddress(guestFields);
	}

	public void addItemFromQuickViewPage() {
		thSRP.goToFirstProductQuickViewPage();
		thQVP.chooseRandomSizeWithStock();
		saveQuickViewItemInfo();
		thQVP.clickAddToBag();

	}

	public void addItemsForQuantityLess12Check()
	{
		boolean hadLessThan12 = false;
		String[] itemNames = new String[16];
		itemNames[0] = "shirt";
		itemNames[1] = "women shirt";
		itemNames[2] = "pants";
		itemNames[3] = "dress";
		itemNames[4] = "jacket";
		itemNames[5] = "suit";
		itemNames[6] = "underwear";
		itemNames[7] = "socks";
		itemNames[8] = "outerwear";
		itemNames[9] = "blazer";
		itemNames[10] = "hoodie";
		itemNames[11] = "swim";
		itemNames[12] = "sweater";
		itemNames[13] = "skirt";
		itemNames[14] = "girls shirt";
		itemNames[15] = "boys shirt";
		int num = 1;
		thHP.submitSearchFor(itemNames[(num % 16)]);
		thHP.pageRefresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thHP.clickOffPopUp();
		thSRP.selectProduct(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thIP.chooseRandomSizeandAddToBag();
		thIP.selectQuantity("4");


		if(thIP.getPageLevelMessage().toLowerCase().contains("quantity you selected exceeds"))
		{
			hadLessThan12 = true;
		}

		Serenity.setSessionVariable("firstItem").to(thIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(thIP.returnOfferPrice());
		thIP.clickHomePage();
		num++;
		int itemOn = 1;
		int currentSect = 15;
		while(hadLessThan12 == false)
		{
			if(num > currentSect)
			{
				itemOn++;
				currentSect = currentSect*2;
			}

			thHP.submitSearchFor(itemNames[(num % 16)]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thSRP.selectProduct(itemOn);
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			thIP.chooseRandomSizeandAddToBag();
			thIP.selectQuantity("4");

			Serenity.setSessionVariable("firstItem").to(thIP.getProductName());
			Serenity.setSessionVariable("firstPrice").to(thIP.returnOfferPrice());

			if(thIP.getPageLevelMessage().toLowerCase().contains("quantity you selected exceeds"))
			{
				hadLessThan12 = true;
			}

			//ckIP.getDriver().navigate().to(ckHP.URL);
			thIP.clickHomePage();
			//ckSRP.pageRefresh();
			num++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void addItemToCartTwice(String itemName)
	{

		//int num = 1;
		thHP.submitSearchFor(itemName);
		thSRP.pageRefresh();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thSRP.selectProduct(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thIP.chooseRandomSizeandAddToBag();
		thIP.selectQuantity("1");
		thIP.clickHomePage();
	}
	public void navigateToMyAccount() {
		thHP.pageRefresh();
		thHP.clickOffPopUp();
		thHP.goToMyAccount();
	}
	public void navigateToMobileMyAccount() {
		thHP.pageRefresh();
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
	}

	public void addShippingAddress(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterShippingAddressFieldsAndSubmit(guestFields);
	}

	public void addShippingAddressOnMobile(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterShippingAddressFieldsAndSubmitOnMobile(guestFields);
	}

	public void addShippingAddressWithAddressySelection(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterShippingAddressWithAddressySuggestionAndSubmit(guestFields);
	}
	public void addShippingAndBillingAddress(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterShippingAndBillingAddressFieldsAndSubmitTH(guestFields);
	}

	/**
	 * a void statement that adds to bag in the Item page and clicks off pop up on
	 * homepage
	 */
	public void addToBag() {
		thHP.clickOffPopUp();
		thIP.clickAddToBag();
	}


	public void verifyUserIsOnPDP() {
		thHP.clickOffPopUp();
		thIP.verifyUserIsOnPDP();
	}

	public void addToBagFromWishlist() {
		thWLP.addFirstItemToCart();
	}

	public void addToWishlist() {
		thIP.addToWishList();
	}


	public void addToMobileWishlist() {
		thIP.addToMobileWishList();
	}

	public void adjustQuantity(String quant) {
		thCP.adjustQuantity(Serenity.sessionVariableCalled("firstItem"), quant);
	}

	public void adjustQuantityOnMobile(String quant) {
		thCP.adjustQuantityOnMobile(quant);
	}

	public void adjustQuantityWithoutCheckStock(String quant) {
		thCP.adjustQuantityWithoutCheckStock(Serenity.sessionVariableCalled("firstItem"), quant);
	}

	/**
	 * Steps to submit order
	 */
	public void applyGiftCardInShoprunner(String number, String pin) {
		thCP.clickApplyShoprunnerGiftcard();
		thCP.enterGiftcard(number, pin);
		thCP.checkoutShoprunner();
	}

	public void applyPromoCode(String code) {
		thCP.applyPromoCode(code);
	}

	public void cancelOrder() {
		thHP.clickOffPopUp();
		thHP.clickOffPopUpTwo();
		//		thHP.tryClosePopUp();
		thOSP.cancelOrder();
	}

	public void changeAndAddAddress(String newAddress) { 
		thCOP.clickChangeAddress();
		thNAP.clickNewAddress();
		thNAP.enterNewAddress(newAddress);
	}

	public void changeAndAddBillingAddress(String newBilling) { 
		thCOP.clickChangeBillingAddress(); 
		thNAP.clickNewBillingAddress(); 
		thNAP.enterNewBillingAddress(newBilling); 
	}

	public void changeAndAddBillingAddressFromReviewOrderPage(String newBilling) {
		thROP.clickChangeBillingAddress();
		thNAP.clickNewBillingAddress();
		thNAP.enterNewBillingAddress(newBilling);
	}

	public void changeAndAddBillingSignedIn(String newBilling) {
		thCOP.clickChangeBillingAddress();
		if(thNAP.getNumberOfBillingAddresses() > 2) {
			thHP.clickOffPopUp();
		}else {
			thNAP.clickNewBillingAddress();
			thNAP.signedInEnterBillingAddress(newBilling);
		}
	}

	public void changeAndAddressFromReviewOrderPage(String newAddress) {
		thROP.clickChangeAddress();
		thNAP.clickNewAddress();
		thNAP.enterNewAddress(newAddress);
	}

	public void checkColorSizeQuant(String color, String size, String quant) {

		thCOP.checkColorSizeQuant(color, size, quant);
	}

	public void checkoutAndAdjustQuantity(String quant) {
		thCP.clickProceedCheckOut();
		thHP.clickOffPopUp();
		thCOP.adjustQuantityWithoutCheckStock(Serenity.sessionVariableCalled("firstItem"), quant);
	}

	public void checkoutShoprunner() {
		thCP.checkoutShoprunner();
		thHP.sleep(500);
	}

	public void CheckoutShopRunner(String email,String password) {
		Serenity.setSessionVariable("orderPrice").to(thCP.getOrderTotal());
		thCP.loginWithShoprunner(email, password);
		thHP.clickOffPopUp();
		//checkoutShoprunner();
	}

	/**
	 * A void method that clicks on the next available size in size selction option.
	 * Also adds the item to the cart
	 */
	public void chooseRandomSize() {
		thIP.chooseRandomSizeandAddToBag();
	}

	public void clickEditItemFromCartForFirst() {
		thCP.clickFirstEdit();
		thECP.chooseNextAvailableSize(Serenity.sessionVariableCalled("size"));
	}

	public void selectToEditItemFromCartForFirst() {
		thCP.clickFirstEdit();
	}

	/**
	 * Step to select first product on the search results page
	 */
	public void clickFirstProduct() {
		thSRP.selectFirstProduct();
		savePDPProductInfo();
		thHP.clickOffPopUp();
	}

	public void clickNext() {

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LOGGER.info("Clicking Next To Open Credit Card...");
		thHP.sleep(2000);
		thCOP.clickNext();
		thHP.sleep(5000);

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mobileSignIn() {
		thHP.clickMenuButtonMobile();
		thHP.clickSignInMobile();
	}

	public void clickSignIn() {
		thHP.clickSignInRegister();
	}

	public void clickSignUpPopUp() {
		thHP.capturePopUp();
		thHP.clickSignUpPopUp();
	}

	public void confirmResetEmailSent() {
		thFPP.confirmResetPasswordEmailSent();
	}


	public void createNewPasswordOnNewPage(String password) {
		thCNPP.createNewPasswordOnNewPasswordPage(password);
	}

	public void editCheckOutAddress(String editAddress) {
		//thCP.clickProceedCheckOut();
		thCOP.pageRefresh();
		thCOP.clickChangeAddress();
		thNAP.clickFirstShippingAddressEdit();
		thNAP.enterEditedAddress(editAddress);
	}

	public void editCheckOutBillingAddress(String editAddress) {
		thCOP.clickChangeBillingAddress();
		thNAP.clickFirstBillingAddressEdit();
		thNAP.enterEditedAddress(editAddress);
	}

	public void editCheckOutBillingAddressFromReviewOrderPage(String editAddress) {
		thROP.clickChangeBillingAddress();
		thNAP.clickFirstBillingAddressEdit();
		thNAP.enterEditedAddress(editAddress);
	}

	public void navigateToCheckoutPreferences() {	
		thHP.clickOffPopUp();
		thASP.navigateToCheckoutPreferences();
	}

	public void navigateToMobileCheckoutPreferences() {		
		thASP.navigateToCheckoutPreferencesOnMobile();
	}

	public void editCheckoutInformation(String infoFields) {

		//thASP.navigateToCheckoutPreferences();
		thHP.clickOffPopUp();
		thCPP.enterCheckoutInformation(infoFields);
	}

	public void editCheckoutInformationWithAddressySelection(String infoFields) {

		//thASP.navigateToCheckoutPreferences();
		thHP.clickOffPopUp();
		thCPP.enterCheckoutInformationWithAddressySelection(infoFields);
	}

	public void editCheckoutInformationWithAddressySelectionOnMobile(String infoFields) {

		//thASP.navigateToCheckoutPreferencesOnMobile();
		thHP.clickOffPopUp();
		thCPP.enterCheckoutInformationWithAddressySelection(infoFields);
	}

	public void saveCheckoutInformation() {
		// TODO Auto-generated method stub
		thCPP.clickUpdate();
	}

	public void editBillingCheckoutInformation(String infoFields) {
		thASP.navigateToCheckoutPreferences();
		thHP.clickOffPopUp();
		thCPP.clickOffSameAsBilling();
		thCPP.enterBillingCheckoutInformation(infoFields);
	}

	public void editGiftBox(String newTo, String newFrom, String newMessage) {
		thCP.editGiftBox(newTo, newFrom, newMessage);
	}

	public void saveProductInformationAtCheckout() {

		Serenity.setSessionVariable("item1Color").to(thCOP.getColorText());
		Serenity.setSessionVariable("item1Size").to(thCOP.getSizeText());
		Serenity.setSessionVariable("item1Quant").to(thCOP.getQuantText());
		LOGGER.info(thCOP.getColorText() + "   " + thCOP.getSizeText() + "  " + thCOP.getQuantText()  );

	}

	public void verifyProductQuntUpdated() {
		thHP.sleep(500);
		thCOP.verifyUpdatedProductQuanity();		
	}

	public void editItemAtCheckout() {

		/*	Serenity.setSessionVariable("item1Color").to(thCOP.getColorText());
		Serenity.setSessionVariable("item1Size").to(thCOP.getSizeText());
		Serenity.setSessionVariable("item1Quant").to(thCOP.getQuantText());
		LOGGER.info(thCOP.getColorText() + "   " + thCOP.getSizeText() + "  " + thCOP.getQuantText()  );*/
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thCOP.clickEditButton();

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//thIP.clickLarge();
		//thIP.clickColorOption(1);
		//String color = thIP.getColorText();
		Serenity.setSessionVariable("item1Quant").to("2");
		thHP.sleep(500);
		thIP.selectQuantityInPopup(Serenity.sessionVariableCalled("item1Quant"));
		//thCOP.checkColorSizeQuant(color,"L","2");
	}

	public void savePDPProductInfo() {
		Serenity.setSessionVariable("firstItem").to(thIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(thIP.returnOfferPrice());
		Serenity.setSessionVariable("firstListPrice").to(thIP.returnListPrice());
		Serenity.setSessionVariable("styleNumber").to(thIP.getProductStyleNumber());
		//pbHP.clickOffPopUp();
	}
	public void saveMobilePDPProductInfo() {
		Serenity.setSessionVariable("firstItem").to(thIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(thIP.returnOfferPrice());
		Serenity.setSessionVariable("firstListPrice").to(thIP.returnListPrice());
		Serenity.setSessionVariable("styleNumber").to(thIP.getMobileProductStyleNumber());
		//pbHP.clickOffPopUp();
	}

	public void saveMobilePDPSecondProductInfo() {
		Serenity.setSessionVariable("secondItem").to(thIP.getMobileProductName());
		Serenity.setSessionVariable("secondPrice").to(thIP.returnOfferPrice());
		Serenity.setSessionVariable("secondListPrice").to(thIP.returnListPrice());
		Serenity.setSessionVariable("secondStyleNumber").to(thIP.getMobileProductStyleNumber());
		//pbHP.clickOffPopUp();
	}

	public void savePDPSecondProductInfo() {
		Serenity.setSessionVariable("secondItem").to(thIP.getProductName());
		Serenity.setSessionVariable("secondPrice").to(thIP.returnOfferPrice());
		Serenity.setSessionVariable("secondListPrice").to(thIP.returnListPrice());
		Serenity.setSessionVariable("secondStyleNumber").to(thIP.getProductStyleNumber());
		//pbHP.clickOffPopUp();
	}

	public void editItemAtCheckoutOnMobile() {

		Serenity.setSessionVariable("item1Color").to(thCOP.getColorText());
		Serenity.setSessionVariable("item1Size").to(thCOP.getSizeText());
		Serenity.setSessionVariable("item1Quant").to(thCOP.getQuantText());
		LOGGER.info(thCOP.getColorText() + "   " + thCOP.getSizeText() + "  " + thCOP.getQuantText()  );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thCP.clickMobileEditButton();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//thIP.clickLarge();
		//thIP.clickColorOption(1);
		//String color = thIP.getColorText();
		//thIP.selectQuantityInPopup("2");
		//thCOP.checkColorSizeQuant(color,"L","2");
		Serenity.setSessionVariable("item1Quant").to("2");
		thCP.updateQuantityWithoutCheckStock();
	}

	public void editPaymentOnReviewOrderPage(){
		thROP.clickEditPayment();

	}

	public void editPersonalInformation(String infoFields) {
		thASP.clickEdit();
		thHP.clickOffPopUp();
		thPIP.enterAddressAndSubmit(infoFields);
	}

	public void editPersonalInformationOnMobile(String infoFields) {
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
		thASP.clickMobileEdit();
		thPIP.enterAddressAndSubmit(infoFields);
	}


	public void editPersonalInformationWithAddressy(String infoFields) {
		thASP.clickEdit();
		thHP.clickOffPopUp();
		thPIP.selectAddressySuggestionAndSubmit(infoFields);
	}

	public void editPersonalInformationWithAddressyOnMobile(String infoFields) {
		thASP.clickMobileEdit();
		thHP.clickOffPopUp();
		thPIP.selectAddressySuggestionAndSubmit(infoFields);
	}

	public void editPersonalInformationFourTimes(String infoFields) {
		thASP.clickEdit();
		thHP.clickOffPopUp();
		thPIP.enterAddressAndSubmitFourTimes(infoFields);
	}

	public void editPersonalInformationOnMobileAndSubmitFourTimes(String infoFields) {
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
		thASP.clickMobileEdit();
		thHP.clickOffPopUp();
		thPIP.enterAddressAndSubmitFourTimes(infoFields);
	}

	public void editShippingMethodOnReviewOrderPage() {
		thHP.sleep(500);
		thROP.clickEditShippingMethod();
	}

	public void enterAndApplyGiftCard(String number, String pin) {
		thCOP.clickNext();
		thCOP.enterGiftCardFields(number, pin);
	}

	protected int randomInt() {
		int i = (int)(Math.random() * ((1000 - 1) + 1)) + 1;
		LOGGER.info("Getting a random number of: "+i);
		return i;
	}


	public void enterAndSubmitOrderAddress(String email, String first, String last, String address, String apartment, String city, String state, String country, String zip, String phone) {
		thHP.clickOffPopUp();
		if(email.equals("testingUser@yopmail.com")) {
			email=randomInt()+"+"+email;
		}
		thCP.clickProceedCheckOut();
		thSP.clickContinueAsGuest();
		thSP.enterGuestFieldsAndSubmit(email, first, last, address, apartment, city, state, country, zip, phone);
	}

	public void enterInvalidEmailInNewsLetterAndSubmit() {
		thHP.clickOffPopUp();
		thASP.clickNewsLetterSignUp();
		String email = Serenity.sessionVariableCalled("email");
		String[] arr = email.split("@");
		thHP.enterAndSubmitSignUpPopUpWithoutRandomAddition(arr[0]);
	}

	public void enterNewLetterAndSubmit() {
		thHP.clickOffPopUp();
		thASP.clickNewsLetterSignUp();
		String email = Serenity.sessionVariableCalled("email");
		thHP.enterAndSubmitSignUpPopUpWithoutRandomAddition(email);
	}
	public void enterPaymentInformationButNoSubmit(String type, String number, String code, String expMonth, String expYear) {
		thCOP.sleep(3000);
		//thCOP.clickNext();
		thCOP.enterPaymentFieldsWithNoSubmit(type, number, code, expMonth, expYear);
		Serenity.setSessionVariable("orderPrice").to(thROP.getOrderTotal());
		thCOP.sleep(3000);
	}

	public void enterRegistrationDetails(String firstName, String lastName, String address, String apartment,
			String city, String country, String state, String zip, String phone, String gender, String bMonth,
			String bDay, String locationCountry, String locationState, String locationStore, String communication,
			String type) {
		thRDP.fillOutRegistration(firstName, lastName, address, apartment, city, country, state, zip, phone, gender,
				bMonth, bDay, locationCountry, locationState, locationStore, communication, type);
	}

	public void enterRegistrationOnCheckOut(String password) {
		thRACOP.registerAtCheckOut(password);
	} 
	public void enterShippingAndBilling() {
		//thCOP.clickNext();
		thCOP.enterPaymentFields("MasterCard", "5555555555554444", "321", "08", "2021");
		thROP.clickSubmitOrder();
	}
	public void enterShopRunnerInfo(String email, String password) {
		thCOP.enterShopRunnerInfo(email, password);
	}

	public void getFirstSize() {

		Serenity.setSessionVariable("size").to(thCP.getFirstSize());
	}

	public String getProductNameOfItemPage() {
		String name = thIP.getNameOfProduct();
		return name;
	}

	public String getProductPriceOfItemPage() {
		String price = thIP.getPrice();
		return price;
	}

	public void goToAccount() {
		thOSP.clickOnAccountPage();
	}

	public void goToCartFromCartCornerLink() {
		thIP.clickGoToCart();
	}
	/**
	 * Step to navigate to the cart page from the home page
	 */

	public void goToCartFromHome() {
		thHP.clickCart();
	}

	public void goToCheckout() {
		thCP.clickProceedCheckOut();
	}

	public void goToCheckOut() {
		thHP.clickOffPopUp();
		thHP.clickCart();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thHP.clickOffPopUp();
		thCP.clickProceedCheckOut();
		LOGGER.info("Checking to see if the script coninues here");
	}

	public void goToCheckoutAndApplyPromo(String code) {
		//thCP.clickProceedCheckOut();
		thSP.submitPromoCode(code);
	}

	public void goToEdit() {
		thHP.clickCart();
		thHP.clickOffPopUp();
		thCP.editProduct();
	}

	public void goToForgotPassword() {
		thSIP.clickForgotPassword();
	}
	public void goToPaypalPayment() {
		thCOP.payWithPayPal();
		thROP.clickProceedToPaypal();
	}
	public void goToReviewOrderPage() {
		thCOP.clickReviewOrder();
	}

	/**
	 * Step to navigate to wish list from cart page
	 */
	public void goToWishlist() {
		thHP.goToMyAccountPage();
		thASP.goToWishlist();
	}

	public void goToMobileWishlist() {
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
		thASP.goToWishlist();
	}
	public void guestUserGetOrderStatus(String email) {
		thMOP.sleep(1000);
		thMOP.clickGuestOrderStatus();
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		LOGGER.info("Inputting an order number of:"+ orderNumber);
		thMOP.enterOrderInfoAndCont(orderNumber, email);

	}

	public void guestUserVerifyStatus(String status) {

		thHP.clickOffPopUp();
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		thMOP.verifyOrderStatus(orderNumber, status);
	}

	public void setOrderNumber() {
		thHP.tryClosePopUp();
		thHP.clickOffPopUpTwo();
		thHP.sleep(1000);
		thHP.tryClosePopUp();
		thOSP.saveOrderNumber();
	}


	public void justEnterGiftCard(String number, String pin) {
		thCOP.enterGiftCardFields(number, pin);
	}

	public void logOut() {
		thASP.clickLogOut();
	}

	public void mobileLogOut() {
		thHP.clickMenuButtonMobile();
		thASP.clickMobileLogout();
	}
	public void navigateBackAndVerify() {

		thROP.clickBackButton();
		LOGGER.info("Navigating back...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thCOP.verifyOnPage();
	}


	public void navigateEditAndVerify() {

		thROP.clickEditButton();
		LOGGER.info("Navigating back...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thCP.verifyOnPage();

	}


	public void navigateTo() {
		thHP.navigateTo(ENV.thURL());
		thHP.clickOffPopUp();
	}

	public void navigateToMyOrders() {

		thHP.pageRefresh();
		thHP.clickOffPopUp();
		thHP.sleep(3000);
		thHP.goToMyAccount();
		thASP.navigateToMyOrders();
	}

	public void navigateToMyOrdersOnMobile() {
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
		thASP.navigateToMyOrders();
	}

	/**
	 * Step to navigate to Store Location page
	 */

	public void navigateToStoreLocator() {
		thHP.clickStoreLocator();
		thSL.switchFocusToStoreLocator();
	}


	public void openSite() {
		thHP.navigateTo(ENV.thURL());
	}
	public void proceedToReviewOrder() {

		LOGGER.info("Procedding to Review Order Page...");
		thCOP.clickReviewOrder();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void proceedToSecureCheckout() {
		//Serenity.setSessionVariable("orderPrice").to(thCP.getOrderTotal());
		thHP.clickOffPopUp();
		thCP.clickProceedCheckOut();
	}

	public void registerAtSignInWithExactEmail(String email, String password) {
		Serenity.setSessionVariable("email").to(email);
		Serenity.setSessionVariable("password").to(password);
		thSIP.registerAccount(email, password);
	}

	public void registerAtSignIn(String email, String password) {
		Random rand = new Random();
		if (email.contains("@")) {
			email = email.split("@")[0] + "+" + rand.nextInt(999999) + "@" + email.split("@")[1];
		}
		Serenity.setSessionVariable("email").to(email);
		Serenity.setSessionVariable("password").to(password);
		thSIP.registerAccount(email, password);
	}

	//	public void testAccountCreation(String email, String password) {
	//		Serenity.setSessionVariable("email").to(email);
	//		Serenity.setSessionVariable("password").to(password);
	//		thSIP.registerAccount(email, password);
	//	}

	public void removeFirstItemFromCart() {
		thCP.removeFirstItem();
	}

	public void removeGiftBox() {
		thCP.removeGiftBox();
	}

	public void removeItemAtCheckout() {

		//int initItems = thCOP.getNumOfCheckoutItems();
		thCOP.removeCheckoutItem1();
		/*try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(initItems >1)
		{
			int finalItems = thCOP.getNumOfCheckoutItems();
			thCOP.checkItemListNumbers(initItems,finalItems);
		}
		else
		{
			thCOP.checkForShoppingBagEmpty();
		}*/
	}
	public void removePromoCode() {
		thCP.removePromoCode();
	}

	public void removeSavedAddress() {
		//thASP.navigateToMyAddressBook();
		thMABP.selectExistingAddress();
		thMABP.removeAddress();
	}

	public void removeSecondItemFromCart() {
		thCP.getDriver().navigate().refresh();
		thCP.removeSecondItem();
	}
	public void resetPassword(String brand, String email, String password, String newPassword) {
		LOGGER.info("Navigating to personal information page and resetting password");
		thHP.clickOffPopUp();
		thHP.goToMyAccount();
		thASP.clickEdit();

		/*String correctPassword = FileReaderManager.getInstance().getJsonDataReader()
				.getAccountPasswordByBrandAndEmail(brand, email).password;
		Random ra = new Random();
		String newPassword = "Temp" + ra.nextInt(9999);*/
		thPIP.resetPassword(password, newPassword);
		/*FileReaderManager.getInstance().getJsonDataWriter().updateAccountPasswordData(brand, email, newPassword);*/
		Serenity.setSessionVariable("newPassword").to(newPassword);
	}
	public void mobileResetPassword(String brand, String email, String password, String newPassword) {
		LOGGER.info("Navigating to personal information page and resetting password");
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
		thASP.clickMobileEdit();

		/*String correctPassword = FileReaderManager.getInstance().getJsonDataReader()
				.getAccountPasswordByBrandAndEmail(brand, email).password;
		Random ra = new Random();
		String newPassword = "Temp" + ra.nextInt(9999);*/
		thPIP.resetPassword(password, newPassword);
		/*FileReaderManager.getInstance().getJsonDataWriter().updateAccountPasswordData(brand, email, newPassword);*/
		Serenity.setSessionVariable("newPassword").to(newPassword);
	}


	public void saveFirstItemInfo() {
		String firstItem = thIP.getProductName();
		float firstPrice = thIP.returnOfferPrice();
		Serenity.setSessionVariable("firstItem").to(firstItem);
		Serenity.setSessionVariable("firstPrice").to(firstPrice);
	}


	public void saveQuickViewItemInfo() {
		String quickViewItem = thQVP.getProductName();
		float quickViewPrice = thQVP.returnOfferPrice();
		Serenity.setSessionVariable("firstItem").to(quickViewItem);
		Serenity.setSessionVariable("firstPrice").to(quickViewPrice);
	}
	public void saveSecondItemInfo() {
		String secondItem = thIP.getProductName();
		float secondPrice = thIP.returnOfferPrice();
		Serenity.setSessionVariable("secondItem").to(secondItem);
		Serenity.setSessionVariable("secondPrice").to(secondPrice);
	}

	public void saveSizeInfo() {
		String size = thIP.getSizesSelected();
		Serenity.setSessionVariable("size").to(size);
	}
	/**
	 * Step to enter search term in search bar
	 * @param item - Search Term
	 */
	public void search(String item) {
		thHP.enterSearchTerm(item);
	}

	public void mobileSearch(String item) {
		thHP.enterMobileSearchTerm(item);
	}

	/**
	 * Search for products on the home page using provided search term
	 * 
	 * @param item - Search Term
	 */

	public void searchFor(String item) {
		thHP.clickOffPopUp();
		thHP.sleep(8000);
		thHP.submitSearchFor(item);
	}

	public void mobileSearchFor(String item) {
		thHP.submitMobileSearchFor(item);
	}

	public void searchForItemInCart(String item) {
		thCP.searchFor(item);
		clickFirstProduct();
		chooseRandomSize();
	}
	/**
	 * Step to search and add product in the cart from the Calvin Klein home page
	 * 
	 * @param item - Product
	 */
	public void searchForProductAndAddToCart(String item) {
		thHP.submitSearchFor(item);

		//thSRP.selectFirstProduct();
		thSRP.selectProduct(1);

		thIP.chooseRandomSizeandAddToBag();

		thIP.selectQuantity("1");

		saveFirstItemInfo();

		thIP.clickGoToCart();
	}
	/**
	 * Step to search store near provided search location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	public void searchStoreNearLocation(String location) {
		thSL.searchStoreNear(location);
	}
	/**
	 * Steps to select PayPal payment method
	 */
	public void selectPaypalPaymentMethod() {
		thCOP.payWithPayPal();
		thROP.clickProceedToPaypal();
	}
	public void selectQuantityItemPage(String quant) {
		thIP.selectQuantity(quant);
	}
	public void selectQuantityItemPageOnMobile(String quant) {
		thIP.selectQuantityOnMobile(quant);
	}
	/**
	 * Step to select provided shipping method
	 * @param shippingMethod - Shipping method e.g.: STANDARD / SECOND DAY / OVERNIGHT
	 */
	public void selectShippingMethod(String shippingMethod) {
		thCOP.selectShippinhMethod(shippingMethod);
		thHP.sleep(5000);
	}

	public void sendResetPasswordEmail(String email) {
		thHP.clickOffPopUp();
		thFPP.inputResetEmail(email);
		thFPP.clickSubmitEmail();
	}

	public void signInWithInvalidPassword(String email, String password, int numOfTimes) {
		for (int i = 0; i <= numOfTimes; i++) {
			thSIP.accountSignIn(email, password);
			thHP.clickOffPopUp();
		}
	}
	public void signUpOnPopUp(String email) {
		thHP.capturePopUp();
		thHP.enterAndSubmitSignUpPopUp(email);
	}

	/**
	 * Steps to start checkout and enter address information as a guest on the checkout page
	 * @param guestFields - Address information
	 */
	public void startCheckoutFromCart() {
		thHP.clickOffPopUp();
		thCP.clickProceedCheckOut();
	}

	public void saveOrderTotalFromCart() {
		thHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(thCP.getOrderTotal());
	}

	public void proceedToGuestCheckout() {
		thHP.clickOffPopUp();
		thSP.clickContinueAsGuest();
	}

	public void enterAndSubmitGuestGuestAddress(String guestFields) {
		thSP.enterAddressAndSubmit(guestFields);
	}

	public void startCheckoutAndSubmitAddress(String guestFields) {
		thHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(thCP.getOrderTotal());
		thCP.clickProceedCheckOut();
		thSP.clickContinueAsGuest();
		thSP.enterAddressAndSubmit(guestFields);
	}

	/**
	 * Steps to start checkout
	 */
	public void startCheckout() {
		thHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(thCP.getOrderTotal());
		thCP.clickProceedCheckOut();
	}

	public void submitCheckoutOrder() {
		thHP.sleep(500);
		thROP.clickSubmitOrder();
	}

	/**
	 * Step to enter payment information and submitting order
	 * @param type - Credit Card Type
	 * @param number - Credit Card Number
	 * @param code - Credit Card CCV Code
	 * @param expMonth - Expiry Month
	 * @param expYear - Expiry Year
	 */
	public void submitOrderWithCreditCard(String type, String number, String code, String expMonth, String expYear) {
		//thCOP.clickNext();
		thCOP.enterPaymentFields(type, number, code, expMonth, expYear);
		Serenity.setSessionVariable("orderPrice").to(thROP.getOrderTotal());
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
		thROP.clickSubmitOrder();
	}

	public void saveOrderTotalFromROP() {
		thHP.sleep(500);
		Serenity.setSessionVariable("orderPrice").to(thROP.getOrderTotal());
	}	


	public void submittingInvalidAddress(int noOfTimes) {
		for (int i = 1; i <= noOfTimes; i++) {
			thRDP.clickSave();
		}
	}


	public void updateSavedAddress(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.selectExistingAddress();
		thMABP.updateExisitingShippingAddressFieldsAndSubmit(guestFields);

	}

	public void updateShippingAddress(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.findAndUpdateShippingAddress(guestFields);

	}

	public void updateShippingAddressOnMobile(String guestFields) {
		thASP.navigateToMyAddressBook();
		thMABP.updateExisitingShippingAddressFieldsAndSubmitOnMobile(guestFields);

	}
	public void enterBillingAddressFieldsAndSubmitFourTimes(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterBillingAddressFieldsAndSubmitFourTimes(guestFields);
	}

	public void enterShipAndBillAddressFieldsFourTimes(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterShipAndBillAddressFieldsFourTimes(guestFields);
	}

	public void verifyAccountIsRegistered() {
		thHP.clickOffPopUp();
		thHP.verifyPageTitle();
		FileReaderManager.getInstance().getJsonDataWriter().addAccountPasswordData(
				Serenity.sessionVariableCalled("brand"), Serenity.sessionVariableCalled("email"),
				Serenity.sessionVariableCalled("password"));
	}

	public void verifyAddressAdded() {
		thMABP.verifyAddressAdded();
	}

	public void verifyAddressRemoved() {
		thMABP.verifyAddressRemoved();
	}

	public void verifyAdjustedQuantityOnCheckout() {
		thCOP.verifyCheckoutNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}

	public void verifyCancelAddress() {
		thMABP.verifyCancel();
	}

	public void deleteAllAddresses() {
		//thASP.navigateToMyAddressBook();
		thMABP.deleteAllAddresses();
	}

	public void verifyAllAddressesRemoved() {
		thMABP.verifyAllAddressesRemoved();
	}

	public void enterShipAndBillButCancels(String guestFields) {
		//thASP.navigateToMyAddressBook();
		thMABP.enterShipAndBillButCancels(guestFields);
	}

	public void verifyAllHeaderLinks()
	{
		thHP.verifyAllHeaderLinks();
	}

	public void verifyCheckoutPreUpdate() {
		thCPP.verifyInformationUpdated();
	}

	/**
	 * Step to verify default location on store locator
	 * @param location - location e.g. Sufferen NY 10901
	 */

	public void verifyDefaultStoreLocation(String location) {
		thSL.verifySearchLocation(location);
	}

	public void verifyEditAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		thCOP.verifyShippingAddressForEdit(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}

	public void verifyEditBillingAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		thCOP.verifyBillingAddressForEdit(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}

	public void verifyEmailNewsLetterSignUpOnAccount() {
		thHP.verifyCongratsPopUpSignUp();

	}

	public void verifyEmptyCart() {
		thCP.verifyEmptyCart();
	}

	/**
	 * Step to verify no result found error message on store locator
	 * @param message - No Result Error Message
	 */
	public void verifyErrorMessage(String message) {
		thSL.verifyNoResultError(message);

	}
	public void verifyErrorMessageOnRegistration(String error) {
		thRDP.verifyError(error);
	}
	public void verifyFooter()
	{
		thHP.verifyFooterExists();
	}
	public void verifyFooter(String names) {

		thHP.verifyFooterNamesExists(names);

	}
	public void verifyAllHeaderCategoryLinks(String dept, String links) {

		thHP.verifyAllHeaderCategoryLinks( dept, links);
	}

	public void verifyDeptBreadCrumbLinks(String dept, String links) {

		thHP.verifyAllDeptBreadCrumbLinks( dept, links);
	}

	public void verifyCatPageGoToItemPage(String dept, String links) {

		thHP.verifyAllCatPageGoToItemPage(dept, links);

	}
	public void verifyBagLink() {

		thHP.clickCartSimple();
		thCP.verifyOnCartPage();
	}

	public void verifyGiftBoxRemoved() {
		thCP.verifyRemovalGiftBox();
	}
	public void verifyGiftBoxText(String to, String from, String message) {
		thCP.verifyGiftBox(to, from, message);
	}
	public void verifyGiftCardApplied() {
		thCOP.verifyGiftCardApplied();
	}
	public void verifyInvalidAddressAdded() {

		thMABP.verifyInvalidAddressAdded();
	}

	public void verifyItemInCartMiniDisplay() {
		thIP.verifyItemInCartDisplayInCorner();
	}

	public void verifyItemNameMatchesCart() {
		thHP.clickCart();
		thHP.clickOffPopUp();
		thCP.verifyCartNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}

	public void verifySecondItemNameMatchesCart() {
		thHP.clickCart();
		thHP.clickOffPopUp();
		thCP.verifyCartNameMatchesItemPage(Serenity.sessionVariableCalled("secondItem"),
				Serenity.sessionVariableCalled("secondPrice"));
	}

	public void verifyItemWasAdded() {

		thCP.verifyItemWasAdded();
	}
	public void verifyLoginError(String error) {
		thSIP.verifySignInError(error);
	}
	public void verifyLoginIsSuccessful() {
		thASP.verifyPageTitle();
	}
	public void verifyNewAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		thCOP.verifyShippingAddress(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}

	public void verifyNewBillingAddressCurrent(String newBilling) { 
		String[] arr = newBilling.split(";");
		thCOP.verifyBillingAddress(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}
	public void verifyNoEmailErrorPopUp() {
		thHP.verifyNoEmailUnSuccessfulPopUp();
	}

	public void verifyNoEmailNewsLetterSignUpOnAccount(String error) {
		thHP.verifyNoEmailUnSuccessfulPopUp();
	}

	public void verifyNoOrders() {
		thMOP.verifyNoOrders();
	}

	public void verifyNoPromoApplied(String code) {
		thCP.verifyNoPromoApplied(code);
	}

	public void verifyNoResults() {
		thSRP.verifyNoSearchResultMessage();
	}
	public void verifyNumberOfItems(int quantity)
	{

		thIP.clickGoToCart();
		assertThat(thCP.getNumItemsInBag() >= quantity);
	}

	public void verifyNumItemsInCart(String code) {
		thHP.sleep(500);
		thCP.verifyNumItemsInCart(Integer.parseInt(code));
	}


	public void verifyOrderCancellation() {

		thHP.clickOffPopUp();
		thHP.tryClosePopUp();
		thHP.tryClosePopUp();
		thHP.tryClosePopUp();
		thHP.tryClosePopUp();
		thOSP.verifyCancellation();
	}

	public void verifyOrderPending(String status) {

		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		thMOP.checkItemStatus(orderNumber, status);
	}

	/**
	 * Step to verify summary of order submitted using credit card
	 * @param creditCardType - Credit Card Type
	 */
	public void verifyOrderSummary(String creditCardType) {
		thOSP.verifyOrderDetails(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"), creditCardType);
	}

	public void verifyPaymentInformationUpdated(String type, String cardNumber, String expMonth, String expYear) {
		thROP.verifyPaymentInformation(type, cardNumber, expMonth, expYear);
	}

	public void verifyPaypal() {
		//thHP.clickOffPopUpTwo();
		thHP.clickOffPopUp();
		//thHP.clickOffPopUpTwo();
		thHP.clickOffPopUp();
		thOSP.verifyFinalOrderDetailsWithPaypal(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"));
	}




	public void verifyPersonalInformationAddress() {
		thHP.clickOffPopUp();
		thRDP.goToAccountSummaryPage();
		thASP.verifySavedAddress();
	}

	public void verifyPersonalInformationAddressOnMobile() {
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
		//thRDP.goToAccountSummaryPageOnMobile();
		thASP.verifySavedAddress();
	}

	public void verifyPersonalInformationUpdated() {
		thPIP.verifyInformationUpdated();
	}

	public void verifyPersonalInformationWithoutAddress() {
		thRDP.goToAccountSummaryPage();
		thASP.verifyNoSavedAddress();
	}

	public void verifyPersonalInformationWithoutAddressOnMobile() {
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
		thASP.verifyNoSavedAddress();
	}

	public void verifyPleaseSelectASize() {
		thIP.verifyPleaseSelectSize();
	}

	public void verifyProhibitedCharacters() {
		thSRP.verifyProhibitedCharacter();
	}

	public void verifyPromoApplied(String code) {
		thCP.verifyPromoAppliedForMultiple(code);
	}

	public void verifyPromoCodeAppliedAndRemovedOnCheckout() {
		thSP.verifyPromoCodeAppliedAndRemovedOnCheckout();
	}


	public void verifyPromoCodeAppliedOnCheckout() {
		thSP.verifyPromoCodeAppliedOnCheckout();
	}

	public void verifyPromoMessage(String message) {
		thCP.verifyPromoCodeError(message);
	}

	public void verifyQuantityNotAvailableError() {
		thCP.verifyQuantityNotAvailableError();
	}


	public void verifyRegistrationDetailsPageIsDisplayed() {
		thRDP.verifyPageTitle();
		FileReaderManager.getInstance().getJsonDataWriter().addAccountPasswordData(
				Serenity.sessionVariableCalled("brand"), Serenity.sessionVariableCalled("email"),
				Serenity.sessionVariableCalled("password"));
	}
	public void verifyRemovalOfPromoCodes() {
		thCP.verifyRemovalOfPromotion();
	}
	/**
	 * Step to verify search result for provided search term
	 * @param searchTerm - Search Term
	 */
	public void verifySearchResults(String searchTerm) {
		thSRP.verifySearchResult(searchTerm);
	}
	/**
	 * Step to verify search result for provided style number
	 * 
	 * @param styleNum - Style Number of the product
	 */
	public void verifySearchResultsForStyleNumber(String styleNum) {
		if(thSRP.verifySearchResultHeaderExists()) {
			thSRP.verifySearchResult(styleNum);
		} else {
			thIP.verifyProductDetailsPageForSpecificStyleNumber(styleNum);
		}
	}
	/**
	 * Step to verify search suggestion displayed matches the provided search term
	 * 
	 * @param text - Search Term
	 */
	public void verifySearchSuggestion(String text) {
		thHP.verifySearchSuggestions(text);
	}

	public void verifySecondAddressApplies() { 
		thCOP.pageRefresh(); 
		thCOP.clickChangeAddress(); 
		String text = thNAP.getModdedRemoveAllSpacesAddress(); 
		thNAP.clickSecondAddress(); 
		thCOP.verifySelectedShippingAddressIsVisible(text); 
	}
	public void verifySecondBillingAddressApplies(String address) { 
		String[] arr = address.split(";");
		thCOP.pageRefresh(); 
		thCOP.clickChangeBillingAddress(); 
		String text = thNAP.getModdedBillingAddressMatchingName(arr[1], arr[2]); 
		thNAP.clickBillingAddressByFirstName(arr[1], arr[2]); 
		thCOP.verifySelectedBillingAddressIsVisible(text); 
	}
	public void verifyShippingMethodOnReviewOrderPage(String shippingMethod) {
		thROP.verifyShippingMethod(shippingMethod);
	}
	public void verifyShopRunner() {
		thHP.clickOffPopUp();
		thHP.sleep(500);
		thHP.clickOffPopUpTwo();
		thHP.sleep(500);
		thOSP.verifyFinalOrderDetailsWithShopRunner(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("firstPrice"));
	}

	public void verifySignUpOnPop() {
		thHP.verifyCongratsPopUpSignUpAtStart();
	}

	public void verifySizesAfterEdit() {
		thCP.verifyFirstSize(Serenity.sessionVariableCalled("size"));
	}
	/**
	 * Step to verify valid store result are displayed for provided location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	public void verifyStoreLocatorResult(String location) {
		thSL.verifyStoreLocatorResult(location);
	}
	/**
	 * Verifies that the name of a product is located on the web page
	 * 
	 * @param name of product that is being searched
	 */
	public void verifyStyleID(String item) {

		if (thSRP.getTitle().contains("Search Results")) {
			thSRP.clickOnFirstElement();
		}
		String pageID = thIP.getStyleNumber();

		assertTrue("The item name is not on the page where we just searched", (pageID.equalsIgnoreCase(item)));
	}
	/**
	 * Step to verify Tommy Hilfiger home page is displayed
	 */
	public void verifyTHHomePage() {
		thHP.verifyPageTitle();
	}
	public void verifyTitleOfCheckOutPage() {
		thIP.clickAddToBag();
		thIP.clickCheckOutFromItemPage();
		thCOP.verifyTitleOfCheckOutPage();
	}
	public void verifyTwoItemsMatchesCart() {
		thHP.clickCart();
		thHP.clickOffPopUp();
		thCP.verifyMultipleItemsInCart(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("secondItem"), Serenity.sessionVariableCalled("firstPrice"),
				Serenity.sessionVariableCalled("secondPrice"));
	}
	public void verifyUpdateAddress() {
		thMABP.verifyUpdateAddress();
	}

	public void verifyUserIsNotSignedIn() {
		thHP.verifyUserIsNotSignedIn();
	}

	public void verifyValidPromoForFirstItem(String code) {
		thCP.verifyValidPromoForFirstItem(code);
	}

	public void verifyValidPromoForMulitpleItems(String code) {
		thCP.verifyValidPromoForMulitpleItems(code);
	}

	public void verifyValidPromoWrongRequirement() {
		thCP.verifyValidPromoWrongRequirement();
	}

	public void verifyWishlistError(String error) {
		thCP.verifyWishlistError(error);
	}

	public void verifyWishlistNameMatchesCart() {

		thHP.clickOffPopUp();
		thWLP.verifyWishlistNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}
	public void verifyQuantityPageLevelMessage() {

		assertThat(thIP.getPageLevelMessage().contentEquals("The quantity you selected exceeds the quantity available. We have adjusted the number of items in your shopping bag."));
	}
	public void verifySignInLink() {

		thHP.clickSignInRegister();
		thSIP.verifyOnSignInPage();
	}
	public void adjustQuantityAddToBag(int quant) {

		thIP.adjustQuantityAddToBag(quant);
	}
	public void verifyFooterLinksGoToCorrespondingPage(String category) {
		thHP.checkFooterLinkGoesToCorrespondingPage(category);
	}
	public void verifyErrorMessage() {

		thCPP.verifyErrorMessage();
	}
	public void verifyCardErrorMessage() {

		thCPP.verifyCardErrorMessage();
	}
	public void verifyEmptyErrorMessage() {

		thCPP.verifyEmptyErrorMessage();
	}
	public void verifyEmptyWishlist() {
		thWLP.verifyNoWishlistItems();
	}
	public void shareWishlist() {
		thWLP.shareWishlist();
	}
	public void enterShareWishlistDetails(String toEmail, String name, String fromEmail, String message) {
		thWLP.enterWishlistFields(toEmail, name, fromEmail, message);
	}
	public void verifyWishlistDetailsNotProvided() {
		thWLP.verifyNoDetailsError();
	}
	public void verifyWishlistShared() {
		thWLP.verifySharedWishlist();
	}
	public void verifyExistingOrders() {
		thMOP.verifyExistingOrders();
	}

	public void verifyPageLevelErrorOnEditAccount(String error) {
		thPIP.verifyPageLevelError(error);
	}

	public void verifyFieldLevelErrorOnEditAccount(String error) {
		thPIP.verifyFieldLevelError(error);
	}

	public void verifyPageLevelMessageOnItemPage(String error) {
		thIP.verifyPageLevelMessageOnItemPage(error);
	}


	/**
	 * Step to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home
	 */

	public void selectDepartment(String department) {
		thSRP.selectDepartmentFromLeftNavigationBar(department);
	}

	public void selectDepartmentOnMobile(String department) {
		thSRP.selectDepartmentOnMobileFromLeftNavigationBar(department);
	}

	/**
	 * Step to verify if provided option is displayed on search result page
	 * @param option - Option e.g.: filter / sort
	 */

	public void verifyOptionIsDisplayed(String option) {
		thSRP.verifyOption(option);		
	}

	public void verifyOptionIsDisplayedOnMobile(String option) {
		thHP.clickOffPopUp();
		thSRP.verifyMobileOption(option);		
	}

	/**
	 * Step to filter search result using provided price range
	 * @param price - Price Range e.g.: $0 - $25
	 */

	public void filterSearchResultUsingPriceRange(String price) {
		thSRP.filterSearchResultUsingPriceRange(price);

	}

	public void filterSearchResultOnMobileUsingPriceRange(String price) {
		thHP.clickOffPopUp();
		thSRP.filterSearchResultUsingOnMobilePriceRange(price);

	}

	/**
	 * Step to verify filtered product list price is within provided price range
	 * @param priceRange - Price Range e.g.: $0 - $25
	 */

	public void verifyPriceOfProductsInFilteredList(String priceRange) {
		thSRP.verifyFilteredProductPrice(priceRange);

	}

	/**
	 * Step to filter search product list using provided color
	 * @param color - Color e.g.: black / blue / red
	 */

	public void filterSearchResultUsingColor(String color) {
		thSRP.filterSearchResultUsingColor(color);

	}


	public void filterSearchResultOnMobileUsingColor(String color) {
		thHP.clickOffPopUp();
		thSRP.filterSearchResultOnMobileUsingColor(color);

	}
	/**
	 * Step to verify searched product list is filtered using provided option
	 * @param option - Option e.g.: black / blue / 
	 */

	public void verifyProductsListIsFiltered(String option) {
		thSRP.verifyProductListIsFilteredUsing(option);

	}

	public void verifyMobileProductsListIsFiltered(String option) {
		thSRP.verifyProductListOnMobileIsFilteredUsing(option);

	}

	/**
	 * Step to filter search product list using provided size
	 * @param size - Size e.g.: s / m / xl / 4xl
	 */

	public void filterSearchResultUsingSize(String size) {
		thSRP.filterSearchResultUsingSize(size);

	}

	public void filterMobileSearchResultUsingSize(String size) {
		thSRP.filterSearchResultOnMobileUsingSize(size);

	}

	/**
	 * Step to sort CKUS search product list using provided price option
	 * @param price - Price e.g.: Low to High / High to Low
	 */
	public void sortSearchResultUsingPrice(String price) {
		thSRP.sortSearchResultUsingPrice(price);

	}
	public void sortSearchResultOnMobileUsingPrice(String price) {
		thSRP.sortSearchResultOnMobileUsingPrice(price);

	}

	/**
	 * Step to verify if product list is sorted based on provided price option
	 * @param priceRange - Price e.g.: Low to High / High to Low
	 */
	public void verifySortedProductList(String priceRange) {
		thSRP.verifyProductListIsSorted(priceRange);

	}

	/**
	 * Steps to create provided number of orders
	 * @param totalOrderCount - Total Order Count
	 * @param styleNumber - Product Style Number
	 * @param address - Billing Address
	 * @param ccType - Credit Card Type
	 * @param ccNumber - Credit Card Number
	 * @param ccCode - Credit Card CCV Code
	 * @param ccExpMonth - Credit Card Expiry Month
	 * @param ccExpYear - Credit Card Expiry Year
	 */
	public void placeOrder(int totalOrderCount, String styleNumber, String address, String ccType, String ccNumber,
			String ccCode, String ccExpMonth, String ccExpYear) {
		for(int count=1; count<=totalOrderCount; count++) {
			LOGGER.info("Starting order number: " + count);
			searchForProductAndAddToCart(styleNumber);
			if(count<=1) {
				startCheckoutAndSubmitAddress(address);
			} else {
				startCheckout();
			}
			submitOrderWithCreditCard(ccType, ccNumber, ccCode, ccExpMonth, ccExpYear);
			verifyOrderSummary(ccType);
		}		
	}

	/**
	 * Steps to clear wish list items
	 */
	public void clearWishlist() {
		//goToWishlist();
		thWLP.removeFromWishlist();

	}


	public void clearMobileWishlist() {
		thHP.clickOffPopUp();
		thHP.clickMenuButtonMobile();
		thHP.goToMobileMyAccount();
		thWLP.removeFromWishlist();

	}
	/**
	 * Steps to clear items from cart
	 */
	public void clearCart() {
		thCP.removeFirstItem();		
	}
	public void navigateToTH() {
		thHP.openUrl(ENV.thURL());
	}

	public boolean isSignedIn() {
		return thHP.isUserSignedIn();
	}

}