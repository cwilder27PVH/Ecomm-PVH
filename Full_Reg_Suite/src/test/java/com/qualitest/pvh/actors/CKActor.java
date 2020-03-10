package com.qualitest.pvh.actors;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;

import org.aeonbits.owner.ConfigFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qualitest.core.actor.BaseActor;
import com.qualitest.core.manager.FileReaderManager;
import com.qualitest.core.util.EnvConfig;
import com.qualitest.pvh.pages.CKAccountSummaryPage;
import com.qualitest.pvh.pages.CKAccountUpdatedConfirmationPage;
import com.qualitest.pvh.pages.CKCACheckOutBilling;
import com.qualitest.pvh.pages.CKCACheckOutPage;
import com.qualitest.pvh.pages.CKCAHomePage;
import com.qualitest.pvh.pages.CKCAOrderSummaryPage;
import com.qualitest.pvh.pages.CKCASearchResultsPage;
import com.qualitest.pvh.pages.CKCartPage;
import com.qualitest.pvh.pages.CKCheckoutPage;
import com.qualitest.pvh.pages.CKCheckoutPreferencesPage;
import com.qualitest.pvh.pages.CKCreateNewPasswordPage;
import com.qualitest.pvh.pages.CKEditCartPage;
import com.qualitest.pvh.pages.CKForgotPasswordPage;
import com.qualitest.pvh.pages.CKHomePage;
import com.qualitest.pvh.pages.CKItemPage;
import com.qualitest.pvh.pages.CKMyAddressBookPage;
import com.qualitest.pvh.pages.CKMyOrdersPage;
import com.qualitest.pvh.pages.CKNewAddressPage;
import com.qualitest.pvh.pages.CKOrderSummaryPage;
import com.qualitest.pvh.pages.CKPersonalInformationPage;
import com.qualitest.pvh.pages.CKRegisterAtCheckOutPage;
import com.qualitest.pvh.pages.CKRegistrationDetailsPage;
import com.qualitest.pvh.pages.CKReviewOrderPage;
import com.qualitest.pvh.pages.CKSearchResultsPage;
import com.qualitest.pvh.pages.CKShippingPage;
import com.qualitest.pvh.pages.CKSignInPage;
import com.qualitest.pvh.pages.CKStoreLocator;
import com.qualitest.pvh.pages.CKWishlistPage;
import com.qualitest.pvh.testDataTypes.Account;

import net.serenitybdd.core.Serenity;

public class CKActor extends BaseActor {

	CKHomePage ckHP;
	CKSignInPage ckSIP;
	CKAccountSummaryPage ckASP;
	CKRegistrationDetailsPage ckRDP;
	CKCAHomePage ckcaHP;
	CKAccountUpdatedConfirmationPage ckAUCP;
	CKPersonalInformationPage ckPIP;
	CKShippingPage ckSP;
	CKCheckoutPage ckCOP;
	CKOrderSummaryPage ckOSP;
	CKRegisterAtCheckOutPage ckRACOP;
	CKReviewOrderPage ckROP;
	CKCartPage ckCP;
	CKItemPage ckIP;
	CKEditCartPage ckECP;
	CKForgotPasswordPage ckFPP;
	CKSearchResultsPage ckSRP;
	CKCASearchResultsPage ckcaSRP;
	CKCACheckOutBilling ckcaCOB;
	CKCACheckOutPage ckcaCOP;
	CKCreateNewPasswordPage ckCNPP;
	CKEditCartPage ckQVP;
	CKWishlistPage ckWLP;
	CKNewAddressPage ckNAP; 
	CKCAOrderSummaryPage ckcaOSP;
	CKMyAddressBookPage ckMABP;
	CKMyOrdersPage ckMOP;
	CKCheckoutPreferencesPage ckCPP;
	CKStoreLocator ckSL;
	
	private static final EnvConfig ENV = ConfigFactory.create(EnvConfig.class);
	private static final Logger LOGGER = LoggerFactory.getLogger(CKActor.class);

	/**
	 * Navigate to homepage of the corresponding brand
	 * 
	 * @param brands String
	 */
	public void navigateTo(String brands) {
		if (brands.equalsIgnoreCase("CKUS")) {
			//ckHP.navigateTo(ENV.ckusURL());
			ckHP.openUrl(ENV.ckusURL());
		} else if (brands.equalsIgnoreCase("CKCA")) {
			//ckcaHP.navigateTo(ENV.ckcaURL());
			ckHP.openUrl(ENV.ckcaURL());
		}
	}
	
	/**
	 * Click the sign in feature on the homepage
	 */
	public void clickSignIn() {
		ckHP.clickSignInRegister();
	}

	public void mobileSignIn() {
		ckHP.clickOffPopUp();
		ckHP.clickMenuButtonMobile();
		ckHP.clickOffPopUp();
		ckHP.clickSignInMobile();
	}

	public void verifyFooter()
	{
		ckHP.verifyFooterExists();
	}
	
	public void verifyAllHeaderLinks()
	{
		ckHP.verifyAllHeaderLinks();
	}
	
	public void  verifyAllHeaderLinksCA()
	{
		ckcaHP.verifyAllHeaderLinks();
	}
	/**
	 * Sign in from the sign in page with an email and password parameter. Uses
	 * jason data reader to get new passwords and emails
	 * 
	 * @param email    String
	 * @param password String
	 */
	public void accountSignIn(String email, String password) {
		Account correctPassword = FileReaderManager.getInstance().getJsonDataReader()
				.getAccountPasswordByBrandAndEmail(Serenity.sessionVariableCalled("brand"), email);
		if (correctPassword != null) {
			password = correctPassword.password;
		}
		ckHP.clickOffPopUp();
		ckSIP.accountSignIn(email, password);
	}

	/**
	 * Sign in directly with password and email in the sign in page
	 * 
	 * @param email
	 * @param password
	 */
	public void accountSignInWithNewPassword(String email, String password) {
		ckSIP.accountSignIn(email, password);
	}

	/**
	 * Verify that the login in the account services page is successful
	 */
	public void verifyLoginIsSuccessful() {
		ckASP.verifyPageTitle();
	}

	/**
	 * verifies login error
	 * 
	 * @param error
	 */
	public void verifyLoginError(String error) {
		ckSIP.verifySignInError(error);
	}

	/**
	 * Sign in with an invalid password a number of times
	 * 
	 * @param email      String
	 * @param Password   String
	 * @param numOfTimes int of number of times
	 */
	public void signInWithInvalidPassword(String email, String Password, int numOfTimes) {
		for (int i = 0; i <= numOfTimes; i++) {
			ckSIP.accountSignIn(email, Password);
			ckHP.clickOffPopUp();
		}
	}

	/**
	 * Sign in with an invalid password a number of times for CKUS
	 * 
	 * @param email      String
	 * @param Password   String
	 * @param numOfTimes int of number of times
	 */
	public void signInWithInvalidPasswordCKUS(String email, String Password, int numOfTimes) {
		for (int i = 0; i <= numOfTimes; i++) {
			ckSIP.accountSignIn(email, Password);
			ckHP.clickOffPopUp();
			ckHP.pageRefresh();
		}
	}
	
	/**
	 * Sets up the reset password feature and create a new new one on CK
	 * 
	 * @param brand
	 * @param email
	 */
	public void resetPassword(String brand, String email, String password, String newPassword) {
		LOGGER.info("Navigating to personal information page and resetting password");
		ckHP.clickOffPopUp();
		ckHP.goToMyAccount();
		ckHP.clickOffPopUp();
		ckASP.clickEdit();
		
		//String correctPassword = FileReaderManager.getInstance().getJsonDataReader()
		//		.getAccountPasswordByBrandAndEmail(brand, email).password;
		//Random ra = new Random();
		//String newPassword = "Temp" + ra.nextInt(9999);
		ckPIP.resetPassword(password, newPassword);
		//FileReaderManager.getInstance().getJsonDataWriter().updateAccountPasswordData(brand, email, newPassword);
		Serenity.setSessionVariable("newPassword").to(newPassword);
	}


	public void mobileResetPassword(String brand, String email, String password, String newPassword) {
		LOGGER.info("Navigating to personal information page and resetting password");
		ckHP.clickOffPopUp();
		//ckHP.clickMenuButtonMobile();		
		ckHP.goToMobileMyAccount();
		ckHP.clickOffPopUp();
		ckASP.clickMobileEdit();
		
		//String correctPassword = FileReaderManager.getInstance().getJsonDataReader()
		//		.getAccountPasswordByBrandAndEmail(brand, email).password;
		//Random ra = new Random();
		//String newPassword = "Temp" + ra.nextInt(9999);
		ckPIP.resetPassword(password, newPassword);
		//FileReaderManager.getInstance().getJsonDataWriter().updateAccountPasswordData(brand, email, newPassword);
		Serenity.setSessionVariable("newPassword").to(newPassword);
	}

	/**
	 * Inputs registration on the sign in page to start up the registration process
	 * 
	 * @param email
	 * @param password
	 */
	public void registerAtSignInWithExactEmail(String email, String password) {
		Serenity.setSessionVariable("email").to(email);
		Serenity.setSessionVariable("password").to(password);
		ckSIP.registerAccount(email, password);
	}
	public void registerAtSignIn(String email, String password) {
		Random rand = new Random();
		if (email.contains("@")) {
			email = email.split("@")[0] + "+" + rand.nextInt(999999) + "@" + email.split("@")[1];
		}
		Serenity.setSessionVariable("email").to(email);
		Serenity.setSessionVariable("password").to(password);
		ckSIP.registerAccount(email, password);
	}

//	public void testAccountCreation(String email, String password) {
//		Serenity.setSessionVariable("email").to(email);
//		Serenity.setSessionVariable("password").to(password);
//		ckSIP.registerAccount(email, password);
//	}
	
	/**
	 * Verify that the registration details page is displayed
	 */
	public void verifyRegistrationDetailsPageIsDisplayed() {
		ckRDP.verifyPageTitle();
		FileReaderManager.getInstance().getJsonDataWriter().addAccountPasswordData(
				Serenity.sessionVariableCalled("brand"), Serenity.sessionVariableCalled("email"),
				Serenity.sessionVariableCalled("password"));
	}

	/**
	 * Enter the registration details in the registration page for a new account
	 * 
	 * @param firstName String
	 * @param lastName  String
	 * @param address   String
	 * @param apartment String
	 * @param city      String
	 * @param country   String
	 * @param state     String
	 * @param zip       String
	 * @param phone     String
	 * @param gender    String
	 * @param bMonth    String
	 * @param bDay      String
	 */
	public void enterRegistrationDetails(String firstName, String lastName, String address, String apartment,
			String city, String country, String state, String zip, String phone, String gender, String bMonth,
			String bDay) {
		ckRDP.fillOutRegistration(firstName, lastName, address, apartment, city, country, state, zip, phone, gender,
				bMonth, bDay);
	}

	/**
	 * Verifies that the account is registered
	 */
	public void verifyAccountIsRegistered() {
		ckAUCP.verifyPageTitle();
		FileReaderManager.getInstance().getJsonDataWriter().addAccountPasswordData(
				Serenity.sessionVariableCalled("brand"), Serenity.sessionVariableCalled("email"),
				Serenity.sessionVariableCalled("password"));
	}

	/**
	 * Verifies the error on the registration page
	 * 
	 * @param error
	 */
	public void verifyErrorMessageOnRegistration(String error) {
		ckRDP.verifyError(error);
	}

	/**
	 * Submits an invalid address a number of times
	 * 
	 * @param noOfTimes int
	 */
	public void submittingInvalidAddress(int noOfTimes) {
		for (int i = 1; i <= noOfTimes; i++) {
			ckRDP.clickPopUpClose();
			ckRDP.clickSave();
		}
	}

	/**
	 * Step to search and add product in the cart from the Calvin Klein home page
	 * 
	 * @param item - Product
	 */
	public void searchForProductAndAddToCart(String item) {
		ckHP.clickOffPopUp();
		ckHP.submitSearchFor(item);
		
		ckHP.clickOffPopUp();
		ckSRP.selectFirstProduct();
		
		ckHP.clickOffPopUp();
		ckIP.chooseRandomSizeandAddToBag();
		
		ckIP.selectQuantity("1");
		
		Serenity.setSessionVariable("firstItem").to(ckIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(ckIP.returnOfferPrice());
		Serenity.setSessionVariable("firstListPrice").to(ckIP.returnListPrice());
		saveSizeInfo();
		
		ckIP.clickGoToCart();
		ckHP.clickOffPopUp();
	}
	
	protected int randomInt() {
		int i = (int)(Math.random() * ((1000 - 1) + 1)) + 1;
		LOGGER.info("Getting a random number of: "+i);
		return i;
	}

	/**
	 * Enters the address information in the order screen for CK US
	 * 
	 * @param email
	 * @param first
	 * @param last
	 * @param address
	 * @param apartment
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	public void enterAndSubmitOrderAddress(String email, String first, String last, String address, String apartment,
			String city, String state, String zip, String phone) {
		if (ckCP.popUpExists()) {
			ckCP.clickClosePopUp();
		}
		if(email.equals("testingUser@yopmail.com")) {
			email=randomInt()+"+"+email;
		}
		Serenity.setSessionVariable("orderPrice").to(ckCP.getOrderTotal());
		ckCP.clickProceedCheckOut();
		ckSP.clickContinueAsGuest();
		ckSP.enterGuestFieldsAndSubmit(email, first, last, address, apartment, city, state, zip, phone);
	}

	/**
	 * Steps to start checkout and enter address information as a guest on the
	 * checkout page
	 * 
	 * @param guestFields - Address information
	 */
	public void startCheckoutFromCart() {
		if (ckCP.popUpExists()) {
			ckCP.clickClosePopUp();
		}
			ckCP.clickProceedCheckOut();
	}
	
	public void saveOrderTotalFromCart() {
		if (ckCP.popUpExists()) {
		ckCP.clickClosePopUp();
	}
		Serenity.setSessionVariable("orderPrice").to(ckCP.getOrderTotal());
	}
	
	public void proceedToGuestCheckout() {
		ckSP.clickContinueAsGuest();
		if (ckCP.popUpExists()) {
			ckCP.clickClosePopUp();
		};
	}

	public void enterAndSubmitGuestGuestAddress(String guestFields) {
		ckSP.enterAddressAndSubmit(guestFields);
	}
	
	public void startCheckoutAndSubmitAddress(String guestFields) {
		if (ckCP.popUpExists()) {
			ckCP.clickClosePopUp();
		}
		if(Serenity.sessionVariableCalled("brand").toString().toLowerCase().equals("ck"))
		{
			Serenity.setSessionVariable("orderPrice").to(ckCP.getOrderTotal());
		}
		ckCP.clickProceedCheckOut();
		ckSP.clickContinueAsGuest();
		if (ckCP.popUpExists()) {
			ckCP.clickClosePopUp();
		};
		ckSP.enterAddressAndSubmit(guestFields);
	}
	
	/**
	 * Steps to start checkout
	 */
	public void startCheckout() {
		if (ckCP.popUpExists()) {
			ckCP.clickClosePopUp();
		}
		if(Serenity.sessionVariableCalled("brand").toString().toLowerCase().equals("ck"))
		{
			Serenity.setSessionVariable("orderPrice").to(ckCP.getOrderTotal());
		}
		ckCP.clickProceedCheckOut();
	}

	/**
	 * Enters and submits order address in the checkout page for CKCA. There a lot
	 * of different steps in CKCA, which is why it's seperate
	 * 
	 * @param email
	 * @param first
	 * @param last
	 * @param address
	 * @param apartment
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	public void enterAndSubmitOrderAddressCA(String email, String first, String last, String address, String apartment,
			String city, String state, String zip, String phone) {
		ckCP.getDriver().navigate().refresh();
		ckCP.clickClosePopUp();
		ckCP.clickProceedCheckOut();
		ckcaCOP.enterShippingInfo(email, first, last, address, city, zip, phone);
	}

	/**
	 * Enters the shipping and billing info from the CK US pages
	 */
	public void enterShippingAndBilling() {
		 ckCOP.clickNext();
		ckCOP.enterPaymentFields("MasterCard", "5555555555554444", "321", "08", "2021");
		ckROP.clickSubmitOrder();
	}

	/**
	 * Entering the shipping and billing information for CKCA. Different from the
	 * shipping and billing from CKUS Specifically does an example for VISA
	 */
	public void enterShippingAndBillingCA() {
		ckcaCOB.enteringBillingInformation("4111111111111111", "01", "2021", "123", "Bobby Smith");
		ckcaCOB.clickSubmit();
	}
	
	public void enterShippingAndBillingCKCA(String number, String month, String year, String code, String name) {
		String n = name;
		if(n.equals(" ")) {
			n = "Bobby Smith";
		}
		ckcaCOB.enteringBillingInformation(number, month, year, code, n);
	}

	/**
	 * Step to enter payment information and submitting order
	 * 
	 * @param type     - Credit Card Type
	 * @param number   - Credit Card Number
	 * @param code     - Credit Card CCV Code
	 * @param expMonth - Expiry Month
	 * @param expYear  - Expiry Year
	 */
	public void submitOrderWithCreditCard(String type, String number, String code, String expMonth, String expYear) {
		//ckCOP.clickNext();
		ckCOP.enterPaymentFields(type, number, code, expMonth, expYear);
		Serenity.setSessionVariable("orderPrice").to(ckROP.getOrderTotal());
		ckROP.clickSubmitOrder();
	}
	

	public void saveOrderTotalFromROP() {
		ckHP.sleep(500);
		Serenity.setSessionVariable("orderPrice").to(ckROP.getOrderTotal());
	}
	
	public void verifyPageLevelMessageOnItemPage(String error) {
		ckIP.verifyPageLevelMessageOnItemPage(error);
	}
	
	public void enterPaymentInformationButNoSubmit(String type, String number, String code, String expMonth, String expYear) {
		ckCOP.sleep(1000);
		//ckCOP.clickNext();
		ckCOP.enterPaymentFieldsWithNoSubmit(type, number, code, expMonth, expYear);
		Serenity.setSessionVariable("orderPrice").to(ckROP.getOrderTotal());
		ckCOP.sleep(1000);
	}
	
	public void goToReviewOrderPage() {
		ckCOP.clickReviewOrder();
	}

	/**
	 * Enters the password from the registration from pop up screen. Password is
	 * only needed because email is taken earlier in order process
	 * 
	 * @param password String
	 */
	public void enterRegistrationOnCheckOut(String password) {
		ckRACOP.registerAtCheckOut(password);
	}

	/**
	 * Cancels an order from the order summary page
	 */
	public void cancelOrder() {
		ckOSP.cancelOrder();
	}

	/**
	 * Goes to account page from the order summary page
	 */
	public void goToAccount() {
		ckOSP.clickOnAccountPage();
	}

	/**
	 * Enters and submits the shipping information on the canada CK page
	 * 
	 * @param email
	 * @param first
	 * @param last
	 * @param address
	 * @param phone
	 */
//	public void enterAndSubmitOrderAddressCanada(String email, String first, String last, String address, String phone) {
//		ckCP.clickProceedCheckOut();
//		ckcaCOP.enterShippingInfo(first, last, address, "United States", phone, email);
//	}
	/**
	 * Enters Shipping and Billing info on the Canada CK Page
	 */
	public void enterShippingAndBillingCanada() {
		ckcaCOB.enteringBillingInformation("4111111111111111", "08", "2020", "321", "Bobby Smith");
	}

	/**
	 * Search for products on the home page using provided search term
	 * 
	 * @param item - Search Term
	 */
	
	public void searchFor(String item) {
		ckHP.clickOffPopUp();
		ckHP.sleep(1000);
		ckHP.submitSearchFor(item);
		ckHP.sleep(1000);
		ckHP.clickOffPopUp();
//		refreshPage();
//		ckHP.clickOffPopUp();
	}
	
	public void mobileSearchFor(String item) {
		ckHP.clickOffPopUp();
		ckHP.submitMobileSearchFor(item);
	}

	/**
	 * Step to enter search term in search bar
	 * 
	 * @param item - Search Term
	 */
	public void search(String item) {
		ckHP.enterSearchTerm(item);
	}


	public void mobileSearch(String item) {
		ckHP.enterMobileSearchTerm(item);
	}

	/**
	 * Step to verify search result for provided search term
	 * 
	 * @param searchTerm - Search Term
	 */
	public void verifySearchResults(String searchTerm) {
		ckHP.clickOffPopUp();
		ckSRP.verifySearchResult(searchTerm);
	}

	/**
	 * Step to verify search result for provided style number
	 * 
	 * @param styleNum - Style Number of the product
	 */
	public void verifySearchResultsForStyleNumber(String styleNum) {
		ckHP.clickOffPopUp();
		if (ckSRP.verifySearchResultHeaderExists()) {
			ckSRP.verifySearchResult(styleNum);
		} else {
			ckIP.verifyProductDetailsPageForSpecificStyleNumber(styleNum);
		}
	}


	public void verifySearchResultsForStyleNumberOnMobile(String styleNum) {
		ckHP.clickOffPopUp();
		if (ckSRP.verifySearchResultHeaderExists()) {
			ckSRP.verifySearchResult(styleNum);
		} else {
			ckIP.verifyProductDetailsPageOnMobileForSpecificStyleNumber(styleNum);
		}
	}

	/**
	 * Clicks on Log out on the Account Summary Page
	 */
	public void logOut() {
		for(int attempts = 3; attempts > 0; attempts--) {
			LOGGER.info("Logging Out");
			ckASP.clickLogout();
			if(!isSignedIn()) {
				break;
			}
			ckASP.sleep(5000);
		}
	}

	public void mobileLogOut() {
		LOGGER.info("Logging Out");
		//ckHP.clickMenuButtonMobile();
		ckASP.clickMobileLogout();
	}


	/**
	 * Goes to forget password
	 */
	public void goToForgotPassword() {
		ckSIP.clickForgotPassword();
	}

	/**
	 * Sends email by entering it through a field on a page
	 * 
	 * @param email
	 */
	public void sendResetPasswordEmail(String email) {
		ckHP.clickOffPopUp();
		ckFPP.inputResetEmail(email);
		ckFPP.clickSubmitEmail();
	}

	/**
	 * Confirms that reset password email has been sent
	 */
	public void confirmResetEmailSent() {
		ckFPP.confirmResetPasswordEmailSent();
	}

	/**
	 * Step to verify no search results message
	 */
	public void verifyNoResults() {
		ckSRP.verifyNoSearchResultMessage();
	}

	/**
	 * Step to verify Clavin Klein - US home page is displayed
	 */
	public void verifyCKUSHomePage() {
		ckHP.verifyPageTitle();
	}

	/**
	 * Step to verify Clavin Klein - CA home page is displayed
	 */
	public void verifyCKCAHomePage() {
		ckcaHP.verifyPageTitle();
	}

	/**
	 * Verifies that the name of a product is located on the web page
	 * 
	 * @param name of product that is being searched
	 */
	public void verifyStyleID(String item) {

		if (ckSRP.getTitle().contains("Search Results")) {
			ckSRP.clickOnFirstElement();
		}
		ckHP.clickOffPopUp();
		String pageID = ckIP.getStyleNumber();
		assertThat(pageID).isEqualTo(item);
	}

	/**
	 * Step to verify search suggestion displayed matches the provided search term
	 * 
	 * @param text - Search Term
	 */
	public void verifySearchSuggestion(String text) {
		ckHP.verifySearchSuggestions(text);
	}

	/**
	 * Step to verify user is not signed in
	 */
	public void verifyUserIsNotSignedIn() {
		ckHP.verifyUserIsNotSignedIn();
	}

	/**
	 * Step to verify prohibited character message
	 */
	public void verifyProhibitedCharacters() {
		ckSRP.verifyProhibitedCharacter();
	}

	/**
	 * Goes to the cart page from the Item page
	 */
	public void goToCartFromItemPage() {
		ckIP.clickGoToCheckOut();
		ckHP.clickOffPopUp();
	}

	public void goToCartFromCartCornerLink() {
		ckIP.clickGoToCart();
		ckHP.clickOffPopUp();
	}

	/**
	 * Step to navigate to the cart page from the home page
	 */
	
	public void goToCartFromHome() {
		ckHP.clickCart();
		ckHP.sleep(200);
		ckHP.clickOffPopUp();
	}
	
	public void savePDPProductInfo() {
		Serenity.setSessionVariable("firstItem").to(ckIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(ckIP.returnOfferPrice());
		Serenity.setSessionVariable("firstListPrice").to(ckIP.returnListPrice());
		Serenity.setSessionVariable("styleNumber").to(ckIP.getProductStyleNumber());
		//pbHP.clickOffPopUp();
	}
	
	public void saveMobilePDPProductInfo() {
		Serenity.setSessionVariable("firstItem").to(ckIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(ckIP.returnOfferPrice());
		Serenity.setSessionVariable("firstListPrice").to(ckIP.returnListPrice());
		Serenity.setSessionVariable("styleNumber").to(ckIP.getMobileProductStyleNumber());
		//pbHP.clickOffPopUp();
	}
	
	public void saveMobilePDPSecondProductInfo() {
		Serenity.setSessionVariable("secondItem").to(ckIP.getMobileProductName());
		Serenity.setSessionVariable("secondPrice").to(ckIP.returnOfferPrice());
		Serenity.setSessionVariable("secondListPrice").to(ckIP.returnListPrice());
		Serenity.setSessionVariable("secondStyleNumber").to(ckIP.getMobileProductStyleNumber());
		//pbHP.clickOffPopUp();
	}
	
	public void savePDPSecondProductInfo() {
		Serenity.setSessionVariable("secondItem").to(ckIP.getProductName());
		Serenity.setSessionVariable("secondPrice").to(ckIP.returnOfferPrice());
		Serenity.setSessionVariable("secondListPrice").to(ckIP.returnListPrice());
		Serenity.setSessionVariable("secondStyleNumber").to(ckIP.getProductStyleNumber());
		//pbHP.clickOffPopUp();
	}
	/**
	 * Step to select first product on the search results page
	 */
	public void clickFirstProduct() {
		ckHP.clickOffPopUp();
		ckSRP.selectFirstProduct();
		ckHP.clickOffPopUp();
	}


	public void clickFirstProductOnMobile() {
		ckHP.clickOffPopUp();
		ckSRP.selectFirstProduct();
		ckHP.clickOffPopUp();
	}


	/**
	 * Creates a new password on the new password page
	 * 
	 * @param password String
	 */
	public void createNewPasswordOnNewPage(String password) {
		ckCNPP.createNewPasswordOnNewPasswordPage(password);
	}

	/**
	 * a void statement that adds to bag in the Item page and clicks off pop up on
	 * homepage
	 */
	public void addToBag() {
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		ckHP.sleep(500);
		ckHP.clickOffPopUp();
		ckHP.sleep(500);
		ckIP.clickAddToBag();
//		ckHP.clickOffPopUp();
//		ckHP.sleep(200);
	}
	/**
	 * a void statement that adds to bag in the Item page and clicks off pop up on
	 * homepage
	 */
	public void mobileAddToBag() {
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		ckHP.sleep(500);
		ckHP.clickOffPopUp();
		ckHP.sleep(500);
		ckIP.clickMobileAddToBag();
//		ckHP.clickOffPopUp();
//		ckHP.sleep(200);
	}
	/**
	 * A void method that clicks on the next available size in size selction option.
	 * Also adds the item to the cart
	 */
	public void chooseRandomSize() {
		ckHP.clickOffPopUp();
		ckIP.chooseRandomSizeandAddToBag();
	}
	/**
	 * Gets the name of the product of the item page
	 * @return
	 */
	public String getProductNameOfItemPage() {
		String name = ckIP.getNameOfProduct();
		return name;
	}

	/**
	 * Gets the name of the product price of the item page
	 * @return
	 */
	public String getProductPriceOfItemPage() {
		String price = ckIP.getPrice();
		return price;
	}

	/**
	 * Saves the item info into a session variable on serenity
	 */
	public void saveFirstItemInfo() {
		String firstItem = ckIP.getProductName();
		float firstPrice = ckIP.returnOfferPrice();
		float firstListPrice = ckIP.returnListPrice();
		LOGGER.info("Saving: "+firstItem+ " to first item");
		LOGGER.info("Saving: "+firstPrice+ " to first price");
		Serenity.setSessionVariable("firstItem").to(firstItem);
		Serenity.setSessionVariable("firstPrice").to(firstPrice);
		Serenity.setSessionVariable("firstListPrice").to(firstListPrice);
	}

	/**
	 * Saves the order total into a Serernity session variable
	 */
	public void saveOrderTotal() {
		float orderPrice = ckCP.getOrderTotal();
		Serenity.setSessionVariable("orderPrice").to(orderPrice);
	}
	
	/**
	 * Saves the size information 
	 */
	
	public void saveSizeInfo() {
		String size = ckIP.getSizesSelected();
		Serenity.setSessionVariable("size").to(size);
	}

	/**
	 * Verifies the item in the cart mini display
	 */
	public void verifyItemInCartMiniDisplay() {
		ckIP.verifyItemInCartDisplayInCorner();
	}

	/**
	 * Verifies the item in the cart matches the item that was added recently
	 */
	
	public void verifyUserIsOnPDP() {
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		ckHP.sleep(500);
		ckHP.clickOffPopUp();
		ckHP.sleep(500);
		ckIP.verifyUserIsOnPDP();
	}
	
	public void verifyItemNameMatchesCart() {
		ckIP.clickGoToCheckOut();
		ckCP.clickClosePopUp();
		ckCP.verifyCartNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}
	
	public void verifyItemNameMatchesCheckoutCKCA() {
		ckcaOSP.verifyCKCACheckout(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("firstPrice"));
	}
	
	public void verifySecondItemNameMatchesCart() {
		ckIP.clickGoToCheckOut();
		ckCP.clickClosePopUp();
		ckCP.verifyCartNameMatchesItemPage(Serenity.sessionVariableCalled("secondItem"),
				Serenity.sessionVariableCalled("secondPrice"));
	}
	
	
	public void verifyWishlistNameMatchesCart() {

		ckHP.clickOffPopUp();
		ckWLP.verifyWishlistNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}

	/**
	 * Searches for item in the cart and clicks on the first product of the search results. Next it selects a size
	 * @param item
	 */
	public void searchForItemInCart(String item) {
		ckCP.searchFor(item);
		clickFirstProduct();
		chooseRandomSize();
		saveFirstItemInfo();
	}
	
	public void searchForItemAfterFirst(String item) {
		ckCP.searchFor(item);
	}

	/**
	 * Goes to the edit button on the cart page to edit a product
	 */
	public void goToEdit() {
		ckHP.clickCart();
		ckHP.clickOffPopUp();
		ckCP.editProduct();
	}

	/**
	 * Adjusts the quantity of an item
	 * @param quant
	 */
	public void adjustQuantity(String quant) {
		ckCP.adjustQuantity(Serenity.sessionVariableCalled("firstItem"), quant);
		ckHP.clickOffPopUp();
	}
	

	public void adjustQuantityOnMobile(String quant) {
		ckCP.adjustQuantityOnMobile(quant);
	}

	/**
	 * Selects the quantity of an item number
	 * @param quant
	 */
	public void selectQuantityItemPage(String quant) {
		ckIP.selectQuantity(quant);

	}
	
	public void selectQuantityItemPageOnMobile(String quant) {
		ckIP.selectQuantityOnMobile(quant);

	}

	/**
	 * Refreshes page
	 */
	public void refreshPage() {
		ckHP.getDriver().navigate().refresh();
	}

	/**
	 * Saves the second item that was searched for in the session
	 */
	public void saveSecondItemInfo() {
		String secondItem = ckIP.getProductName();
		float secondPrice = ckIP.returnOfferPrice();
		float secondListPrice = ckIP.returnListPrice();
		Serenity.setSessionVariable("secondItem").to(secondItem);
		Serenity.setSessionVariable("secondPrice").to(secondPrice);
		Serenity.setSessionVariable("secondListPrice").to(secondListPrice);
	}

	/**
	 * Verifies that the two items that were added to the cart are the same in the cart
	 */
	public void verifyTwoItemsMatchesCart() {
		//ckIP.clickGoToCheckOut();
		ckHP.clickOffPopUp();
		ckCP.verifyMultipleItemsInCart(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("secondItem"), Serenity.sessionVariableCalled("firstPrice"),
				Serenity.sessionVariableCalled("secondPrice"));
	}

	/**
	 * Removes the second item from the cart
	 */
	public void removeSecondItemFromCart() {
		ckCP.getDriver().navigate().refresh();
		ckCP.removeSecondItem();
	}

	/**
	 * Verifies an empty cart
	 */
	public void verifyEmptyCart() {
		ckCP.verifyEmptyCart();
	}

	/**
	 * Adds a gift box to the order 
	 * @param to
	 * @param from
	 * @param message
	 */
	public void addGiftBox(String to, String from, String message) {
		ckCP.addGiftBox(to, from, message);
	}

	/**
	 * Edits the gift box in the order
	 * @param newTo
	 * @param newFrom
	 * @param newMessage
	 */
	public void editGiftBox(String newTo, String newFrom, String newMessage) {
		ckCP.editGiftBox(newTo, newFrom, newMessage);
	}

	/**
	 * Verifies the gift box text is equal to what was inputted
	 * @param to
	 * @param from
	 * @param message
	 */
	public void verifyGiftBoxText(String to, String from, String message) {
		ckCP.verifyGiftBox(to, from, message);
	}

	/**
	 * Removes the gift box
	 */
	public void removeGiftBox() {
		ckCP.removeGiftBox();
	}

	/**
	 * Verifies gift box is removed
	 */
	public void verifyGiftBoxRemoved() {
		ckCP.verifyRemovalGiftBox();
	}

	/**
	 * Clics edit from an item on the cart page
	 */
	public void clickEditItemFromCartForFirst() {
		ckCP.clickFirstEdit();
		ckECP.chooseNextAvailableSize(Serenity.sessionVariableCalled("size"));
	}
	

	public void selectToEditItemFromCartForFirst() {
		ckCP.clickFirstEdit();
	}

	/**
	 * Verifies the size after an edit on the cart page
	 */
	public void verifySizesAfterEdit() {
		ckCP.verifyFirstSize(Serenity.sessionVariableCalled("size"));
	}

	/**
	 * Applies the promo code
	 * @param code
	 */
	public void applyPromoCode(String code) {
		ckCP.applyPromoCode(code);
	}

	/**
	 * Verifies promo code message
	 * @param message
	 */
	public void verifyPromoMessage(String message) {
		ckCP.verifyPromoCodeError(message);
	}

	/**
	 * Click add to wish list
	 */
	public void addToWishlist() {
		ckHP.clickOffPopUp();
		ckIP.addToWishList();
	}
	/**
	 * Click add to wish list
	 */
	public void addToMobileWishlist() {
		ckHP.clickOffPopUp();
		ckIP.addToMobileWishList();
	}

	/**
	 * Steps to navigate to wish list from my account option on header
	 */
	public void goToWishlist() {
		ckHP.pageRefresh();
		ckHP.clickOffPopUp();
		ckHP.goToMyWishlist();
	}

	public void goToMobileWishlist() {
		ckHP.clickOffPopUp();
	//	ckHP.clickMenuButtonMobile();		
		//ckHP.goToMobileMyAccount();
		ckHP.goToMyMobileWishlist();
	}
	
	/**
	 * Goes to check out from the Cart page. It clicks the proceed to checkout button
	 */
	public void goToCheckout() {
		ckCP.clickProceedCheckOut();
	}

	/**
	 * Add to bag from the wish list on the wish list page
	 */
	public void addToBagFromWishlist() {
		ckWLP.addFirstItemToCart();
	}

	/**
	 * Saves the total of the order on the cart page, and proceeds to checkout from the cart page
	 */
	public void proceedToSecureCheckout() {
		//Serenity.setSessionVariable("orderPrice").to(ckCP.getOrderTotal());
		if (ckCP.popUpExists()) {
			ckCP.clickClosePopUp();
		}
		ckCP.clickProceedCheckOut();
	}

	/**
	 * Step to verify summary of order submitted using credit card
	 * 
	 * @param creditCardType - Credit Card Type
	 */
	public void verifyOrderSummary(String creditCardType) {
		ckHP.clickOffPopUp();
		ckOSP.verifyOrderDetails(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("orderPrice"), creditCardType);
	}
	
	/**
	 * verifies order summary and the shop runner account
	 */
	public void verifyOrderSummaryAndShopRunner() {
		ckHP.clickOffPopUp();
		LOGGER.info(Serenity.sessionVariableCalled("type").toString());
	}

	/**
	 * Steps to enter gift card information during checkout
	 * 
	 * @param number - Gift Card Number
	 * @param pin    - Gift Card Pin
	 */
	public void enterAndApplyGiftCard(String number, String pin) {
		ckCOP.clickNext();
		ckCOP.enterGiftCardFields(number, pin);
	}
	
	public void justEnterGiftCard(String number, String pin) {
		ckCOP.enterGiftCardFields(number, pin);
	}

	/**
	 * Step to verify gift is applied on checkout page
	 */
	public void verifyGiftCardApplied() {
		ckCOP.verifyGiftCardApplied();
	}
	
	/**
	 * Changes an address on the checkout page and adds it on the pop up new address page
	 * @param newAddress
	 */
	public void changeAndAddAddress(String newAddress) { 
		ckCOP.clickChangeAddress(); 
		ckNAP.clickNewAddress(); 
		ckNAP.enterNewAddress(newAddress); 
	} 
	
	public void changeAndAddressFromReviewOrderPage(String newAddress) {
		ckROP.clickChangeAddress();
		ckNAP.clickNewAddress();
		ckNAP.enterNewAddress(newAddress);
	}
 
	 /**
	  * Changes a billing address from the check out page and adds a billing address through a pop up new address page
	  * @param newBilling
	  */
	public void changeAndAddBillingAddress(String newBilling) { 
		ckCOP.clickChangeBillingAddress(); 
		ckNAP.clickNewBillingAddress(); 
		ckNAP.enterNewBillingAddress(newBilling);
	}
	
	public void changeAndAddBillingAddressFromReviewOrderPage(String newBilling) {
		ckROP.clickChangeBillingAddress();
		ckNAP.clickNewBillingAddress();
		ckNAP.enterNewBillingAddress(newBilling);
	}
	
	/**
	 * Adds billign address if necessary while signed in.
	 * Since the sign in feature stores the added addresses, the best way to make sure it doesn't go over board with addresses is with a check
	 * It checks to see if the address list is above two, if not it adds an address
	 * @param newBilling
	 */
	public void changeAndAddBillingSignedIn(String newBilling) {
		ckCOP.clickChangeBillingAddress();
		if (ckNAP.getNumberOfBillingAddresses() > 2) {
			ckHP.clickOffPopUp();
		} else {
			ckNAP.clickNewBillingAddress();
			ckNAP.signedInEnterBillingAddress(newBilling);
		}
	}
	
	/**
	 * Verifies that the new shipping address is the current one on the check out page
	 * @param newAddress
	 */
	public void verifyNewAddressCurrent(String newAddress) { 
		String[] arr = newAddress.split(";");
		ckCOP.verifyShippingAddress(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]);
	}

	/**
	 * verifies that the new billing address is the current on on the checkout page
	 * @param newBilling
	 */
	public void verifyNewBillingAddressCurrent(String newBilling) {
		String[] arr = newBilling.split(";");
		ckCOP.verifyBillingAddress(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	} 
	
	/**
	 * Verifies that the edited address is the current one on the checkout page. The would normally 
	 * @param newAddress
	 */
	public void verifyEditAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		ckCOP.verifyShippingAddressForEdit(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}
	
	public void verifyEditBillingAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		ckCOP.verifyBillingAddressForEdit(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}
	public void verifySecondAddressApplies() { 
		ckCOP.clickChangeAddress(); 
		String text = ckNAP.getModdedRemoveAllSpacesAddress(); 
		ckNAP.clickSecondAddress();  
		ckCOP.verifySelectedShippingAddressIsVisible(text); 
	} 
	public void verifySecondBillingAddressApplies(String address) { 
		ckCOP.clickChangeBillingAddress(); 
		String[] arr = address.split(";");
		String text = ckNAP.getModdedBillingAddressMatchingName(arr[1], arr[2]); 
		ckNAP.clickBillingAddressByFirstName(arr[1], arr[2]); 
		ckCOP.verifySelectedBillingAddressIsVisible(text); 
	} 
	public void editCheckOutAddress(String editAddress) {
		//ckCP.clickProceedCheckOut();
		ckCOP.clickChangeAddress();
		ckNAP.clickFirstShippingAddressEdit();
		ckNAP.enterEditedAddress(editAddress);
	}

	/**
	 * Steps to select Paypal payment method
	 */
	public void selectPaypalPaymentMethod() {
		ckCOP.payWithPayPal();
		ckROP.clickProceedToPaypal();
	}

	/**
	 * Steps to submit order
	 */
	public void submitCheckoutOrder() {
		ckHP.sleep(5000);
		ckROP.clickSubmitOrder();
	}

	public void editCheckOutAddressCKCA(String editAddress) {
		//ckCP.clickProceedCheckOut();
		ckcaCOP.enterShippingInfo(editAddress);
		ckcaCOB.enteringBillingInformation("4111111111111111", "02", "2020", "321", "Bobby Smith");
	}
	
	public void editCheckOutShippingAddressCKCA(String editAddress) {
		ckHP.clickOffPopUp();
		ckCP.clickProceedCheckOut();
		ckcaCOP.enterShippingInfo(editAddress);
	}
	
	public void enterAndSubmitGuestGuestAddressCKCA(String editAddress) {
		ckcaCOP.enterShippingInfo(editAddress);
	}

	public void editCheckOutBillingAddress(String editAddress) {
		ckCOP.clickChangeBillingAddress();
		ckNAP.clickFirstBillingAddressEdit();
		ckNAP.enterEditedAddress(editAddress);
	}
	public void editCheckOutBillingAddressFromReviewOrderPage(String editAddress) {
		ckROP.clickChangeBillingAddress();
		ckNAP.clickFirstBillingAddressEdit();
		ckNAP.enterEditedAddress(editAddress);
	}

	public void enterShippingandBillingInformationCKCA(String newBilling, String newAddress) {
		ckCP.clickProceedCheckOut();
		ckcaCOP.enterBillingInfo(newBilling);
		ckcaCOP.enterShippingInfo(newAddress);
	}

	public void enterTestPaymentInfoCKCA() {
		ckcaCOB.enteringBillingInformation("4111111111111111", "02", "2020", "321", "Bobby Smith");
	}
	public void enterShopRunnerInfo(String email, String password) {
		ckCOP.enterShopRunnerInfo(email, password);
	}
	public void verifyShopRunnerAndItemDetails() {
		ckOSP.verifyFinalOrderDetailsWithShopRunner(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"), Serenity.sessionVariableCalled("type"));
	}
	public void verifyShippingAddressCKCA(String address) {
		ckcaOSP.verifyShippingAddress(address);
	}
	public void verifyBillingAddressCKCA(String address) {
		ckcaOSP.verifyBillingAddress(address);
	}
	public void applyAward(String reward) {
		ckCP.clickProceedCheckOut();
		ckCOP.clickNext();
		ckCOP.selectFirstReward();
	}
	public void applyTwoAwards() {
		ckCP.clickProceedCheckOut();
		ckCOP.clickNext();
		ckCOP.deSelectAwards();
		ckCOP.selectTwoAwards();
	}
	public void verify100LoyaltyApplied() {
		ckCOP.verifyRewardsApplied("0.00", "100.00");
		ckCOP.clickReviewOrder();
		ckROP.clickSubmitOrder();
		ckOSP.verifyLoyaltyAppliedToTotal("0.00", "100.00");
	}
	public void verifyRewardApplied(String amount) {
		ckCOP.verifyRewardsApplied(amount, amount);
		ckCOP.clickReviewOrder();
		ckROP.clickSubmitOrder();
		ckOSP.verifyLoyaltySavingsApplied(amount, amount);
	}
	public void verifyRewardsSelected() {
		ckCOP.verifyRewardsApplied();
		ckCOP.clickReviewOrder();
		ckROP.clickSubmitOrder();
		ckOSP.verifyLoyaltySavingsApplied("30.00", "30.00");
	}
	
	public void CheckoutShopRunner(String email,String password) {
		ckHP.clickOffPopUp();
		//evaluateJavascript("arguments[0].scrollIntoView();", loginWithShoprunner);
		//Serenity.setSessionVariable("orderPrice").to(ckCP.getOrderTotal());
		ckCP.loginWithShoprunner(email, password);
		ckHP.clickOffPopUp();
	}
	
	public void checkoutShoprunner() {
		ckCP.checkoutShoprunner();
	}
	public void verifyShopRunner() {
		ckHP.clickOffPopUp();
		ckHP.clickOffPopUp();
		ckHP.sleep(500);
		ckOSP.verifyFinalOrderDetailsWithShopRunner(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("firstPrice"));
	}

	/**
	 * Step to select provided shipping method
	 * 
	 * @param shippingMethod - Shipping method e.g.: STANDARD / SECOND DAY /
	 *                       OVERNIGHT
	 */
	public void selectShippingMethod(String shippingMethod) {
		ckCOP.selectShippinhMethod(shippingMethod);
	
	}

	public void applyGiftCardInShoprunner(String number, String pin) {
		ckCP.clickApplyShoprunnerGiftcard();
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
		ckCP.enterGiftcard(number, pin);
		try{
		    Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
	
	public void verifyPaypal() {
		ckHP.clickOffPopUp();
		ckHP.clickOffPopUp();
		ckOSP.verifyFinalOrderDetailsWithPaypal(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"));
	}
	
	public void verifyLoyatyandGiftCard(String amount, String creditCardType) {

		ckCOP.verifyRewardsApplied(amount, amount);
		ckCOP.clickReviewOrder();
		ckROP.clickSubmitOrder();
		ckOSP.verifyLoyaltySavingsAndGiftCard(amount, amount, Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"), creditCardType);
	}
	
	
	public void addCartItemToWishlist() {
		ckCP.addToWishlist();
	}
	
	
	public void verifyAddingCartItemToMobileWishlistForGuestUSer() {
		ckCP.verifyAddToWishlistForGuestUser();
	}
	
	/**
	 * Step to verify wish list error message
	 * @param error
	 */
	public void verifyWishlistError(String error) {
		ckCP.verifyWishlistError(error);		
	}
	
	public void editPersonalInformation(String infoFields) {
		ckASP.clickEdit();
		ckHP.clickOffPopUp();
		ckPIP.enterAddressAndSubmit(infoFields);
	}
	
	public void editPersonalInformationOnMobile(String infoFields) {
		ckHP.clickOffPopUp();
		//ckHP.clickMenuButtonMobile();		
		//ckHP.goToMobileMyAccount();
		ckHP.clickOffPopUp();
		ckHP.sleep(500);
		ckASP.clickMobileEdit();
		ckPIP.enterAddressAndSubmit(infoFields);
	}
	
	public void editPersonalInformationWithAddressy(String infoFields) {
		ckASP.clickEdit();
		ckHP.clickOffPopUp();
		ckPIP.selectAddressySuggestionAndSubmit(infoFields);
	}	
	
	public void editPersonalInformationWithAddressyOnMobile(String infoFields) {
		ckASP.clickMobileEdit();
		ckHP.clickOffPopUp();
		ckPIP.selectAddressySuggestionAndSubmit(infoFields);
	}	
	
	public void editPersonalInformationAndSubmitFourTimes(String infoFields) {
		ckASP.clickEdit();
		ckHP.clickOffPopUp();
		ckPIP.enterAddressAndSubmitFourTimes(infoFields);
	}	
	
	public void editPersonalInformationOnMobileAndSubmitFourTimes(String infoFields) {
		ckHP.clickOffPopUp();
		//ckHP.clickMenuButtonMobile();		
		ckHP.goToMobileMyAccount();
		ckHP.clickOffPopUp();
		ckHP.sleep(500);
		ckASP.clickMobileEdit();
		ckPIP.enterAddressAndSubmitFourTimes(infoFields);
	}
	
	
	public void verifyPersonalInformationUpdated() {
		ckPIP.verifyInformationUpdated();
	}

	public void navigateToCheckoutPreferences() {	
		ckHP.clickOffPopUp();
		ckASP.navigateToCheckoutPreferences();
	}
	
	public void navigateToMobileCheckoutPreferences() {		
		//ckHP.clickMenuButtonMobile();
		//ckHP.clickOffPopUp();
		ckHP.sleep(5000);
		ckASP.navigateToCheckoutPreferencesOnMobile();
	}

	public void editCheckoutInformation(String infoFields) {
		
		//ckASP.navigateToCheckoutPreferences();
		ckHP.clickOffPopUp();
		ckCPP.enterCheckoutInformation(infoFields);
	}

	public void editCheckoutInformationOnMobile(String infoFields) {
		//ckHP.clickOffPopUp();
		//ckHP.clickMenuButtonMobile();		
		//ckHP.goToMobileMyAccount();
		//ckHP.clickOffPopUp();
		//ckHP.sleep(500);
		//ckASP.navigateToCheckoutPreferencesOnMobile();
		ckHP.clickOffPopUp();
		ckCPP.enterCheckoutInformation(infoFields);
	}

	public void editCheckoutInformationWithAddressySelection(String infoFields) {
		
		//ckASP.navigateToCheckoutPreferences();
		ckHP.clickOffPopUp();
		ckCPP.enterCheckoutInformationWithAddressySelection(infoFields);
	}

	public void editCheckoutInformationWithAddressySelectionOnMobile(String infoFields) {
		
		ckASP.navigateToCheckoutPreferencesOnMobile();
		ckHP.clickOffPopUp();
		ckCPP.enterCheckoutInformationWithAddressySelection(infoFields);
	}

	
	public void saveCheckoutInformation() {
		// TODO Auto-generated method stub
		ckCPP.clickUpdate();
	}
	
	public void editBillingCheckoutInformation(String infoFields) {
		ckASP.navigateToCheckoutPreferences();
		ckHP.clickOffPopUp();
		ckCPP.clickOffSameAsBilling();
		ckCPP.enterBillingCheckoutInformation(infoFields);
	}

	public void verifyCheckoutPreUpdate() {
		
		ckCPP.verifyInformationUpdated();
	}
	public void navigateToMyAccount() {
		ckHP.pageRefresh();
		ckHP.clickOffPopUp();
		ckHP.goToMyAccount();
	}
	public void navigateToMobileMyAccount() {
		//ckHP.pageRefresh();
		//ckHP.clickOffPopUp();
		//ckHP.clickMenuButtonMobile();		
		ckHP.goToMobileMyAccount();
	}
	public void addShippingAddress(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterShippingAddressFieldsAndSubmit(guestFields);
	}
	
	public void navigateToAddressBook() {
		//ckUser.navigateToMobileMyAccount();
		ckASP.navigateToMyAddressBook();
	}
	
	public void addShippingAddressOnMobile(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterShippingAddressFieldsAndSubmit(guestFields);
	}
	
	public void addShippingAddressWithAddressySelection(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterShippingAddressWithAddressySuggestionAndSubmit(guestFields);
	}
	
	public void verifyAddressAdded() {
		ckMABP.verifyAddressAdded();
	}
	
	public void addBillingAddress(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterBillingAddressFieldsAndSubmit(guestFields);
	}
	
	public void updateBillingAddress(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.findAndUpdateBillingAddress(guestFields);
	}
	
	public void enterBillingAddressFieldsAndSubmitFourTimes(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterBillingAddressFieldsAndSubmitFourTimes(guestFields);
	}
	
	public void enterShipAndBillAddressFieldsFourTimes(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterShipAndBillAddressFieldsFourTimes(guestFields);
	}
	
	public void enterShipAndBillButCancels(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterShipAndBillButCancels(guestFields);
	}
	
	public void verifyAllAddressesRemoved() {
		ckMABP.verifyAllAddressesRemoved();
	}
	
	public void deleteAllAddresses() {
		//ckASP.navigateToMyAddressBook();
		ckMABP.deleteAllAddresses();
	}
	
	public void verifyCancelAddress() {
		ckMABP.verifyCancel();
	}
	
	public void updateBillingAndShippingAddress(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.findAndUpdateShippingAndBillingAddress(guestFields);
	}
	
	public void addShippingAndBillingAddress(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterShippingAndBillingAddressFieldsAndSubmit(guestFields);
	}
	
	public void updateBillingAndShippingAddressFourTimes(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.updateExisitingShippingAndBillingAddressFieldsAndSubmitFourTimes(guestFields);
	}
	
	public void enterUpdateBillingAddressFieldsFourTimes(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.enterUpdateBillingAddressFieldsFourTimes(guestFields);
	}
	
	public void enterUpdateShippingAddressFieldsFourTimes(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.updateShippingAddressFieldsFourTimes(guestFields);
	}
	
	public void verifyUpdatedInvalidAddressAddressBook() {
		ckMABP.verifyUpdatedInvalidAddress();
	}
	
	public void verifyInvalidAddressAdded() {
		
		ckMABP.verifyInvalidAddressAdded();
	}
	
	public void addInvalidShippingAddress(String guestFields) {
		//ckHP.clickOffPopUp();
		//ckASP.navigateToMyAddressBook();
		ckHP.clickOffPopUp();
		ckMABP.addInvalidShippingAddress(guestFields);
	}


	public void removeSavedAddress() {
		//ckASP.navigateToMyAddressBook();
		ckMABP.selectExistingAddress();
		ckMABP.removeAddress();
	}
	public void verifyAddressRemoved() {
		ckMABP.verifyAddressRemoved();
	}
	
	public void verifyRewardsExist() {
		ckASP.clickSideTabRewards();
		ckASP.verifyRewardsAvailable();
	}
	
	public void signUpOnPopUp(String email) {
		ckHP.capturePopUp();
		ckHP.enterAndSubmitSignUpPopUp(email);
	}
	
	public void verifySignUpOnPop() {
		ckHP.verifyCongratsPopUpSignUp();
	}
	
	public void verifyNoEmailErrorPopUp() {
		ckHP.verifyNoEmailUnSuccessfulPopUp();
	}
	
	public void clickSignUpPopUp() {
		ckHP.capturePopUp();
		ckHP.clickSignUpPopUp();
	}
	

	public void updateSavedAddress(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.selectExistingAddress();
		ckMABP.updateExisitingShippingAddressFieldsAndSubmit(guestFields);
	}

	public void updateShippingAddress(String guestFields) {
		//ckASP.navigateToMyAddressBook();
		ckMABP.findAndUpdateShippingAddress(guestFields);
	}	
	public void verifyUpdateAddress() {
		ckMABP.verifyUpdateAddress();
	}
	
	
	public void addItemWithQuantity(String item, int x)
	{
		ckHP.submitSearchFor(item);
		ckSRP.pageRefresh();
		ckSRP.selectFirstProduct();
		ckIP.chooseRandomSizeandAddToBag();
		ckIP.selectQuantity("" + x);
		Serenity.setSessionVariable("firstItem").to(ckIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(ckIP.returnOfferPrice());
		//ckIP.clickGoToCart();
	}
	
	public void addAmountOfItems(int x, String item)
	{
		
		ckHP.submitSearchFor(item);
		ckHP.pageRefresh();
		ckHP.sleep(500);
		ckHP.clickOffPopUp();
		ckSRP.selectProduct(1);
		ckIP.chooseRandomSizeandAddToBag();
		ckIP.clickAddToBag();
		ckHP.sleep(500);
		int iteration = 1;
		while(ckCP.getNumItemsInBag() < x+2 && iteration < x+2)
		{
			LOGGER.info("Running iteration: "+iteration);
			ckHP.getDriver().navigate().back();
			iteration++;
			ckSRP.selectProduct(iteration);
			ckIP.chooseRandomSizeandAddToBag();
			ckIP.clickAddToBag();
			ckHP.sleep(2000);
		}
	}
	
	public void verifyNumberOfItems(int quantity)
	{
		
		goToCartFromItemPage();
		assertThat(ckCP.getNumItemsInBag() >= quantity);
	}
	
	
	public void addItemToCartTwice(String itemName)
	{
		ckHP.submitSearchFor(itemName);
		ckHP.clickOffPopUp();
		ckHP.sleep(1000);
		ckSRP.selectProduct(1);
		ckIP.sleep(1000);
		ckHP.clickOffPopUp();
		ckIP.chooseRandomSizeandAddToBag();
		ckIP.selectQuantity("1");
		ckIP.clickHomePage();
	}
	public void verifyNumItemsInCart(String error) {
		ckCP.verifyNumItemsInCart(Integer.parseInt(error));
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
		ckHP.submitSearchFor(itemNames[(num % 16)]);
		ckHP.pageRefresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ckHP.clickOffPopUp();
		ckSRP.selectProduct(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ckIP.chooseRandomSizeandAddToBag();
		ckIP.selectQuantity("11");
		

		if(ckIP.getPageLevelMessage().toLowerCase().contains("quantity you selected exceeds"))
		{
			hadLessThan12 = true;
		}
		
		Serenity.setSessionVariable("firstItem").to(ckIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(ckIP.returnOfferPrice());
		ckIP.clickHomePage();
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
			
			ckHP.submitSearchFor(itemNames[(num % 16)]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ckSRP.selectProduct(itemOn);
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ckIP.chooseRandomSizeandAddToBag();
			ckIP.selectQuantity("11");
			
			Serenity.setSessionVariable("firstItem").to(ckIP.getProductName());
			Serenity.setSessionVariable("firstPrice").to(ckIP.returnOfferPrice());
			
			if(ckIP.getPageLevelMessage().toLowerCase().contains("quantity you selected exceeds"))
			{
				hadLessThan12 = true;
			}
			
				//ckIP.getDriver().navigate().to(ckHP.URL);
				ckIP.clickHomePage();
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
	public void verifyItemWasAdded() {
		
		ckCP.verifyItemWasAdded();
	}
	public void saveProductInformationAtCheckout() {
		
		Serenity.setSessionVariable("item1Color").to(ckCOP.getColorText());
		Serenity.setSessionVariable("item1Size").to(ckCOP.getSizeText());
		Serenity.setSessionVariable("item1Quant").to(ckCOP.getQuantText());
		LOGGER.info(ckCOP.getColorText() + "   " + ckCOP.getSizeText() + "  " + ckCOP.getQuantText());

	}	
	
	public void editItemAtCheckout() {
		
/*		Serenity.setSessionVariable("item1Color").to(ckCOP.getColorText());
		Serenity.setSessionVariable("item1Size").to(ckCOP.getSizeText());
		Serenity.setSessionVariable("item1Quant").to(ckCOP.getQuantText());
		LOGGER.info(ckCOP.getColorText() + "   " + ckCOP.getSizeText() + "  " + ckCOP.getQuantText()  );*/
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ckCOP.clickEditButton();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//ckIP.clickLarge();
		//ckIP.clickColorOption(1);
		//String color = ckIP.getColorText();
		Serenity.setSessionVariable("item1Quant").to("2");
		ckHP.sleep(500);
		ckIP.selectQuantityInPopup(Serenity.sessionVariableCalled("item1Quant"));
		//ckCOP.checkColorSizeQuant(color,"L","2");
	}
	
	public void verifyProductQuntUpdated() {
		ckCOP.verifyUpdatedProductQuanity();		
	}
	
	public void editItemAtCheckoutOnMobile() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ckCOP.clickEditButton();
		//try {
		//	Thread.sleep(3000);
		//} catch (InterruptedException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		//Serenity.setSessionVariable("item1Quant").to("2");
		//ckCP.updateQuantityWithoutCheckStock();
		//ckIP.clickLarge();
		//ckIP.clickColorOption(1);
		//String color = ckIP.getColorText();
		//ckIP.selectQuantityInPopup("2");
		//ckCOP.checkColorSizeQuant(color,"L","2");
	}
	public void editAtCheckOut() {
		ckCOP.waitFor(3000);
		ckCOP.clickEditButton();
		ckCOP.waitFor(3000);
		
	}
	
	public void checkColorSizeQuant(String color, String size, String quant) {
		
		ckCOP.checkColorSizeQuant(color, size, quant);
	}
	
	
	public void removeItemAtCheckout() {
		/*
		int initItems = ckCOP.getNumOfCheckoutItems();
		ckCOP.removeCheckoutItem1();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(initItems >1)
		{
			int finalItems = ckCOP.getNumOfCheckoutItems();
			ckCOP.checkItemListNumbers(initItems,finalItems);
		}
		else
		{
			ckCOP.checkForShoppingBagEmpty();
		}*/
		ckCOP.removeCheckoutItem1();
	}
	
	
	public void proceedToReviewOrder() {
		
		LOGGER.info("Procedding to Review Order Page...");
		ckCOP.clickReviewOrder();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void navigateBackAndVerify() {
		
		ckROP.clickBackButton();
		LOGGER.info("Navigating back...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ckCOP.verifyOnPage();
	}
	public void clickNext() {
		
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ckHP.sleep(5000);
		LOGGER.info("Clicking Next To Open Credit Card...");
		
		ckCOP.clickNext();
		ckHP.sleep(5000);
		
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void navigateEditAndVerify() {
		
		ckROP.clickEditButton();
		LOGGER.info("Navigating back...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ckCP.verifyOnPage();
		
	}
	public void navigateToOrderPage() {
		ckASP.navigateToMyOrders();
	}
	public void verifyNoOrders() {
		ckMOP.verifyNoOrders();
	}
	public void getFirstSize() {
		
		Serenity.setSessionVariable("size").to(ckCP.getFirstSize());
	}
	public void verifyValidPromoWrongRequirement() {
		ckCP.verifyValidPromoWrongRequirement();
	}
	
	public void verifyValidPromoForFirstItem(String code) {
		ckCP.verifyValidPromoForFirstItem(code);
	}
	
	public void removeFirstItemFromCart() {
		ckCP.removeFirstItem();
	}
	public void removePromoCode() {
		ckCP.removePromoCode();	}
	
	public void verifyPersonalInformationWithoutAddress() {
		ckHP.clickGoToAccountOnPage();
		ckASP.verifyNoSavedAddress();
	}
	
	public void verifyPersonalInformationWithoutAddressOnMobile() {
		ckHP.clickOffPopUp();
		ckHP.clickMenuButtonMobile();
		ckHP.clickOffPopUp();
		ckASP.verifyNoSavedAddress();
	}
	
	public void verifyPersonalInformationAddress() {
		ckHP.clickOffPopUp();
		ckHP.clickGoToAccountOnPage();
		ckASP.verifySavedAddress();
	}
	
	public void verifyPersonalInformationAddressOnMobile() {
		ckHP.clickOffPopUp();
		//ckHP.clickMenuButtonMobile();		
		ckHP.goToMobileMyAccount();
		//ckHP.clickGoToAccountOnPage();
		ckASP.verifySavedAddress();
	}
	public void verifyQuantityNotAvailableError() {
		ckCP.verifyQuantityNotAvailableError();
	}
	public void adjustQuantityWithoutCheckStock(String quant) {
		ckCP.adjustQuantityWithoutCheckStock(Serenity.sessionVariableCalled("firstItem"), quant);
	}
	public void verifyPleaseSelectASize() {
		ckIP.verifyPleaseSelectSize();
	}
	public void checkoutAndAdjustQuantity(String quant) {
		ckCP.clickProceedCheckOut();
		ckCP.clickClosePopUp();
		ckCOP.adjustQuantityWithoutCheckStock(Serenity.sessionVariableCalled("firstItem"), quant);
	}
	
	public void verifyAdjustedQuantityOnCheckout(String quantity) {
		//ckCOP.verifyCheckoutNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				//Serenity.sessionVariableCalled("firstPrice"));
		ckCOP.verifyUpdatedQuantity(quantity);
	}
	
	public void verifyCartPage() {
		ckIP.clickEditBagFromMiniCart();
		ckCP.verifyCartPage();
	}
	public void verifyValidPromoForMulitpleItems(String code) {
		ckCP.verifyValidPromoForMulitpleItems(code);
	}
	public void verifyNoPromoApplied(String code) {
		ckCP.verifyNoPromoApplied(code);
	}
	public void goToCheckoutAndApplyPromo(String code) {
		//ckCP.clickProceedCheckOut();
		ckSP.pageRefresh();
		ckSP.submitPromoCode(code);
	}
	public void verifyPromoCodeAppliedOnCheckout() {
		ckSP.verifyPromoCodeAppliedOnCheckout();
	}
	public void verifyPromoCodeAppliedAndRemovedOnCheckout() {
		ckSP.verifyPromoCodeAppliedAndRemovedOnCheckout();
	}
	public void editPaymentOnReviewOrderPage(){
		ckROP.clickEditPayment();
	}
	public void editShippingMethodOnReviewOrderPage() {
		ckHP.sleep(500);
		ckROP.clickEditShippingMethod();
	}
	public void verifyShippingMethodOnReviewOrderPage(String shippingMethod) {
		ckROP.verifyShippingMethod(shippingMethod);
	}
	public void verifyPaymentInformationUpdated(String type, String cardNumber, String expMonth, String expYear) {
		ckROP.verifyPaymentInformation(type, cardNumber, expMonth, expYear);
	}
	public void verifyOrderCancellation() {
		
		ckHP.clickOffPopUp();
		if(Serenity.sessionVariableCalled("brand").toString().toLowerCase().equals("ckus"))
		{
			ckOSP.verifyCancellation();	
		}
		
	}
	public void navigateToMyOrders() {
		
		ckHP.pageRefresh();
		ckHP.clickOffPopUp();
//		ckHP.goToMyAccount();
		ckHP.clickOffPopUp();
		ckASP.navigateToMyOrders();
	}
	public void navigateToMyOrdersOnMobile() {
		
		ckHP.pageRefresh();
		ckHP.clickOffPopUp();
		//ckHP.clickMenuButtonMobile();		
		ckHP.goToMobileMyAccount();
//		ckHP.goToMyAccount();
		ckHP.clickOffPopUp();
		ckASP.navigateToMobileMyOrders();
	}
	public void verifyOrderPending(String status) {
		
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		ckMOP.checkItemStatus(orderNumber, status);
	}
	public void guestUserGetOrderStatus(String email) {
		
		ckMOP.clickGuestOrderStatus();
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		ckMOP.enterOrderInfoAndCont(orderNumber, email);
	}
	
	public void guestUserGetOrderStatusCKCA() {
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		ckHP.clickHomePageButton();
		ckMOP.clickGuestOrderStatus();
		ckMOP.enterTrackingNumberAndSubmitCKCA( orderNumber);
	}
	
	public void guestUserVerifyStatus(String status) {
		
		ckHP.clickOffPopUp();
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		LOGGER.info("Inputting an order number of:"+ orderNumber);
		ckMOP.verifyOrderStatus(orderNumber, status);
	}
	public void verifyAllHeaderCategoryLinks(String dept, String links) {
		
		ckHP.verifyAllHeaderCategoryLinks(dept, links);
	}
	public void verifyFooter(String names) {
		
		ckHP.verifyFooterNamesExists(names);
		
	}
	public void verifyDeptBreadCrumbLinks(String dept, String links) {
		
		ckHP.verifyAllDeptBreadCrumbLinks(dept, links);
		
	}
	public void verifyCatPageGoToItemPage(String dept, String links) {
		
		ckHP.verifyAllCatPageGoToItemPage(dept, links);
		
	}
	public void verifyBagLink() {
		
		ckHP.clickCartSimple();
		ckCP.verifyOnCartPage();
	}
	
	public void clickSubmitOrder() {
		ckROP.clickSubmitOrder();
	}
	public void editOrderFromOrderSummary() {
		ckHP.clickOffPopUp();
		ckOSP.editOrder();
	}
	public void enterNewLetterAndSubmit() {
		ckHP.clickOffPopUp();
		ckHP.clickGoToAccountOnPage();
		String email = Serenity.sessionVariableCalled("email");
		ckASP.enterNewLetterAndSubmit(email);
	}
	public void enterInvalidEmailInNewsLetterAndSubmit() {
		ckHP.clickOffPopUp();
		ckHP.clickGoToAccountOnPage();
		String email = Serenity.sessionVariableCalled("email");
		String[] arr = email.split("@");
		ckASP.enterNewLetterAndSubmit(arr[0]);
	}
	public void enterNoNewsLetterAndSubmit() {
		ckHP.clickOffPopUp();
		ckHP.clickGoToAccountOnPage();
	}
	
	public void verifyNoEmailNewsLetterSignUpOnAccount(String error) {
		ckASP.verifyNoEmailNewsLetterSignUpOnAccount(error);
	}
	public void verifyEmailNewsLetterSignUpOnAccount() {
		ckASP.verifyEmailNewsLetterSignUpOnAccount();
	}
	public void verifyFooterLinksGoToCorrespondingPage(String category) {
		ckHP.checkFooterLinkGoesToCorrespondingPage(category);
	}
	public void verifyFooterLinksGoToCorrespondingPageCA(String category) {
		ckcaHP.checkFooterLinkGoesToCorrespondingPage(category);
	}
	public void setOrderNumber() {
		ckHP.clickOffPopUp();
		ckOSP.saveOrderNumber();
	}
	public void setOrderNumberCKCA() {
		ckOSP.saveOrderNumberCKCA();
	}
	
	
	/**
	 * Step to navigate to Store Location page
	 */
	
	public void navigateToStoreLocator() {
		ckHP.clickStoreLocator();
		ckSL.switchFocusToStoreLocator();
	}
	
	/**
	 * Step to verify default location on store locator
	 * @param location - location e.g. Sufferen NY 10901
	 */
	
	public void verifyDefaultStoreLocation(String location) {
		ckSL.verifySearchLocation(location);
	}
	
	/**
	 * Step to search store near provided search location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	public void searchStoreNearLocation(String location) {
		ckSL.searchStoreNear(location);
	}
	
	/**
	 * Step to verify no result found error message on store locator
	 * @param message - No Result Error Message
	 */
	public void verifyErrorMessage(String message) {
		ckSL.verifyNoResultError(message);
		
	}
	
	/**
	 * Step to verify valid store result are displayed for provided location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	public void verifyStoreLocatorResult(String location) {
		ckSL.verifyStoreLocatorResult(location);
	}
	public void verifyQuantityPageLevelMessage() {
		
		assertThat(ckIP.getPageLevelMessage().contentEquals("The quantity you selected exceeds the quantity available. We have adjusted the number of items in your shopping bag."));
	}
	public void verifySignInLink() {
		
		ckHP.clickSignInRegister();
		ckSIP.verifyOnSignInPage();
	}
	public void adjustQuantityAddToBag(int quant) {
		
		ckIP.adjustQuantityAddToBag(quant);
	}
	public void verifyErrorMessage() {
		
		ckCPP.verifyErrorMessage();
	}
	public void verifyCardErrorMessage() {
		
		ckCPP.verifyCardErrorMessage();
	}
	public void verifyEmptyErrorMessage() {
		
		ckCPP.verifyEmptyErrorMessage();
	}


	public void goToPaypalPayment() {
		ckCOP.payWithPayPal();
		ckROP.clickProceedToPaypal();
	}
	public void goToPaypalPaymentCKCA() {
		ckcaCOP.navigateToPaypalCheckout();
	}
	public void verifyEmptyWishlist() {
		ckWLP.verifyNoWishlistItems();
	}
	public void shareWishlist() {
		ckWLP.shareWishlist();
	}
	public void enterShareWishlistDetails(String toEmail, String name, String fromEmail, String message) {
		ckWLP.enterWishlistFields(toEmail, name, fromEmail, message);
	}
	public void verifyWishlistDetailsNotProvided() {
		ckWLP.verifyNoDetailsError();
	}
	public void verifyWishlistShared() {
		ckWLP.verifySharedWishlist();
	}
	public void verifyExistingOrders() {
		ckMOP.verifyExistingOrders();
	}
	public void verifyExistingOrdersOnMobile() {
		ckMOP.verifyExistingOrders();
	}
	
	public void clickRewardsTabOnAccountPage() {
		ckASP.clickSideTabRewards();
	}
	
	public void clickRewardsTabOnAccountPageOnMobile() {
		//ckHP.clickMenuButtonMobile();		
		ckHP.goToMobileMyAccount();
		ckASP.clickSideTabRewards();
	}
	
	public void verifyPageLevelErrorOnEditAccount(String error) {
		ckPIP.verifyPageLevelError(error);
	}
	
	public void verifyNoRewardAvailable() {
		ckCOP.sleep(1000);
		ckASP.verifyNoRewards();
	}
	
	public void verifyFieldLevelErrorOnEditAccount(String error) {
		ckPIP.verifyFieldLevelError(error);
	}

	/**
	 * Step to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home
	 */
	
	public void selectDepartment(String department) {
		ckSRP.selectDepartmentFromLeftNavigationBar(department);
	}
	

	
	public void selectDepartmentOnMobile(String department) {
		ckSRP.selectDepartmentFromMobileTopBar(department);
	}
	
	/**
	 * Step to verify if provided option is displayed on search result page
	 * @param option - Option e.g.: filter / sort
	 */
	
	public void verifyOptionIsDisplayed(String option) {
		ckSRP.verifyOption(option);		
	}
	
	public void verifyOptionIsDisplayedOnMobile(String option) {
		ckSRP.verifyMobileOption(option);		
	}
	
	/**
	 * Step to filter search result using provided price range
	 * @param price - Price Range e.g.: $0 - $25
	 */
	
	public void filterSearchResultUsingPriceRange(String price) {
		ckSRP.filterSearchResultUsingPriceRange(price);
	}
	

	
	public void filterSearchResultOnMobileUsingPriceRange(String price) {
		ckSRP.filterSearchResultOnMobileUsingPriceRange(price);
	}
	
	/**
	 * Step to filter CKCA search result using provided price range
	 * @param price - Price Range e.g.: $0 - CAD $100 / CAD $100 - CAD $200
	 */
	
	public void filterCKCASearchResultUsingPriceRange(String price) {
		ckcaSRP.filterSearchResultUsingPriceRange(price);
	}
	

	
	public void filterCKCASearchResultOnMobileUsingPriceRange(String price) {
		ckcaSRP.filterSearchResultOnMobileUsingPriceRange(price);
	}
	
	/**
	 * Step to verify CKUS filtered product list price is within provided price range
	 * @param priceRange - Price Range e.g.: $0 - $25
	 */
	
	public void verifyPriceOfProductsInFilteredList(String priceRange) {
		ckSRP.verifyFilteredProductPrice(priceRange);
	}
	
	public void verifyMobilePriceOfProductsInFilteredList(String priceRange) {
		ckSRP.verifyMobileFilteredProductPrice(priceRange);
	}
	
	/**
	 * Step to verify CKCA filtered product list price is within provided price range
	 * @param priceRange - Price Range e.g.: $0 - CAD $100 / CAD $200 - CAD $300
	 */
	
	public void verifyCKCAPriceOfProductsInFilteredList(String priceRange) {
		ckcaSRP.verifyFilteredProductPrice(priceRange);
	}
	

	
	public void verifyCKCAMobilePriceOfProductsInFilteredList(String priceRange) {
		ckcaSRP.verifyMobileFilteredProductPrice(priceRange);
	}
	
	/**
	 * Step to filter CKUS search product list using provided color
	 * @param color - Color e.g.: black / blue / red
	 */
	
	public void filterSearchResultUsingColor(String color) {
		ckSRP.filterSearchResultUsingColor(color);
	}
		
	public void filterSearchResultOnMobileUsingColor(String color) {
			ckSRP.filterSearchResultonMobileUsingColor(color);
			
	}
	
	/**
	 * Step to filter CKCA search product list using provided color
	 * @param color - Color e.g.: black / blue / red
	 */
	
	public void filterCKCASearchResultUsingColor(String color) {
		ckcaSRP.filterSearchResultUsingColor(color);
		
	}
	public void filterCKCASearchResultOnMobileUsingColor(String color) {
		ckcaSRP.filterSearchResultonMobileUsingColor(color);
		
	}
	/**
	 * Step to verify searched product list is filtered using provided option
	 * @param option - Option e.g.: black / blue / 
	 */
	
	public void verifyProductsListIsFiltered(String option) {
		ckSRP.verifyProductListIsFilteredUsing(option);
		
	}
	
	public void verifyMobileProductsListIsFiltered(String option) {
		ckSRP.verifyMobileProductListIsFilteredUsing(option);
		
	}
	
	/**
	 * Step to filter CKUS search product list using provided size
	 * @param size - Size e.g.: s / m / xl / 4xl
	 */
	
	public void filterSearchResultUsingSize(String size) {
		ckSRP.filterSearchResultUsingSize(size);
		
	}
	
	public void filterMobileSearchResultUsingSize(String size) {
		ckSRP.filterMobileSearchResultUsingSize(size);
		
	}
	
	/**
	 * Step to filter CKCA search product list using provided size
	 * @param size - Size e.g.: s / m / xl / 4xl
	 */
	
	public void filterCKCASearchResultUsingSize(String size) {
		ckcaSRP.filterSearchResultUsingSize(size);
		
	}
	
	public void filterCKCAMobileSearchResultUsingSize(String size) {
		ckcaSRP.filterMobileSearchResultUsingSize(size);
		
	}
	
	/**
	 * Step to filter CKUS search product list using provided category
	 * @param size - Size e.g.: BIG + TALL / BODY / BODY MODAL / MODERN MODAL
	 */
	
	public void filterSearchResultUsingCategory(String category) {
		ckSRP.filterSearchResultUsingCategory(category);
		
	}
	
	public void filterMobileSearchResultUsingCategory(String category) {
		ckSRP.filterMobileSearchResultUsingCategory(category);
		
	}
	
	/**
	 * Step to filter CKCA search product list using provided category
	 * @param size - Size e.g.: BODY / BODY MODAL / CALVIN KLEIN ID
	 */
	
	public void filterCKCASearchResultUsingCategory(String category) {
		ckcaSRP.filterSearchResultUsingCategory(category);
		
	}
	
	public void filterCKCASearchResultoOnMobileUsingCategory(String category) {
		ckcaSRP.filterSearchResultOnMobileUsingCategory(category);
		
	}
	
	/**
	 * Step to sort CKUS search product list using provided price option
	 * @param price - Price e.g.: Low to High / High to Low
	 */
	public void sortSearchResultUsingPrice(String price) {
		ckSRP.sortSearchResultUsingPrice(price);
		
	}
	
	public void sortSearchResultOnMobileUsingPrice(String price) {
		ckSRP.sortSearchResultOnMobileUsingPrice(price);
		
	}
	
	/**
	 * Step to sort CKCA search product list using provided price option
	 * @param price - Price e.g.: Low to High / High to Low
	 */
	public void sortCKCASearchResultUsingPrice(String price) {
		ckcaSRP.sortSearchResultUsingPrice(price);
		
	}
	

	public void sortCKCASearchResultOnMobileUsingPrice(String price) {
		ckcaSRP.sortSearchResultOnMobileUsingPrice(price);
		
	}
	/**
	 * Step to verify if product list is sorted based on provided price option
	 * @param priceRange - Price e.g.: Low to High / High to Low
	 */
	public void verifySortedProductList(String priceRange) {
		ckSRP.verifyProductListIsSorted(priceRange);
		
	}
	
	/**
	 * Step to verify if product list is sorted based on provided price option
	 * @param priceRange - Price e.g.: Low to High / High to Low
	 */
	public void verifyCKCASortedProductList(String priceRange) {
		ckcaSRP.verifyProductListIsSorted(priceRange);
		
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
	 * Steps to create provided number of CKCA orders
	 * @param totalOrderCount - Total Order Count
	 * @param styleNumber - Product Style Number
	 * @param address - Billing Address
	 * @param ccType - Credit Card Type
	 * @param ccNumber - Credit Card Number
	 * @param ccCode - Credit Card CCV Code
	 * @param ccExpMonth - Credit Card Expiry Month
	 * @param ccExpYear - Credit Card Expiry Year
	 */
	public void placeCKCAOrder(int totalOrderCount, String styleNumber, String address, String ccType, String ccNumber,
			String ccCode, String ccExpMonth, String ccExpYear) {
		for(int count=1; count<=totalOrderCount; count++) {
			LOGGER.info("Starting order number: " + count);
			searchForProductAndAddToCart(styleNumber);
			editCheckOutShippingAddressCKCA(address);
			String name = "Bob Smith";
			enterShippingAndBillingCKCA(ccNumber, ccExpMonth, ccExpYear, ccCode, name);
		}
		
	}

	/**
	 * Step to clear items in wish list
	 */
	public void clearWishlist() {
		//ckHP.goToMyWishlist();
		ckWLP.removeFromWishlist();		
	}
	
	public void clearMobileWishlist() {
	//	ckHP.clickMenuButtonMobile();		
		//ckHP.goToMobileMyAccount();
		ckHP.goToMyMobileWishlist();
		ckWLP.removeFromWishlist();		
	}

	/**
	 * Steps to clear items from cart
	 */
	public void clearCart() {
		ckCP.removeFirstItem();
		
	}

	public void navigateToCKCA() {
		ckHP.openUrl(ENV.ckcaURL());
		
	}

	public void navigateToCK() {
		ckHP.openUrl(ENV.ckusURL());
		
	}

	public boolean isSignedIn() {
		return ckHP.isUserSignedIn();
	}
	
}
