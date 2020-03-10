package com.qualitest.pvh.actors;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.Random;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qualitest.core.actor.BaseActor;
import com.qualitest.core.manager.FileReaderManager;
import com.qualitest.core.util.EnvConfig;
import com.qualitest.pvh.pages.PBAccountSummaryPage;
import com.qualitest.pvh.pages.PBAccountUpdatedConfirmationPage;
import com.qualitest.pvh.pages.PBCartPage;
import com.qualitest.pvh.pages.PBCheckoutPage;
import com.qualitest.pvh.pages.PBCheckoutPreferencesPage;
import com.qualitest.pvh.pages.PBCreateNewPasswordPage;
import com.qualitest.pvh.pages.PBEditCartPage;
import com.qualitest.pvh.pages.PBForgotPasswordPage;
import com.qualitest.pvh.pages.PBItemPage;
import com.qualitest.pvh.pages.PBMyAddressBookPage;
import com.qualitest.pvh.pages.PBMyOrdersPage;
import com.qualitest.pvh.pages.PBNewAddressPage;
import com.qualitest.pvh.pages.PBOrderSummaryPage;
import com.qualitest.pvh.pages.PBPersonalInformationPage;
import com.qualitest.pvh.pages.PBQuickViewPage;
import com.qualitest.pvh.pages.PBRegisterAtCheckoutPage;
import com.qualitest.pvh.pages.PBRegistrationDetailsPage;
import com.qualitest.pvh.pages.PBReviewOrderPage;
import com.qualitest.pvh.pages.PBSearchResultsPage;
import com.qualitest.pvh.pages.PBShippingPage;
import com.qualitest.pvh.pages.PBSignInPage;
import com.qualitest.pvh.pages.PBStoreLocator;
import com.qualitest.pvh.pages.PBWishlistPage;
import com.qualitest.pvh.pages.PBHomePage;
import com.qualitest.pvh.testDataTypes.Account;
import com.qualitest.pvh.pages.PBFooter;
import com.qualitest.pvh.pages.PBHeader;
import net.serenitybdd.core.Serenity;


public class PBActor extends BaseActor {

	WebDriver driver;

	PBHomePage pbHP;
	PBSignInPage pbSIP;
	PBAccountSummaryPage pbASP;
	PBRegistrationDetailsPage pbRDP;
	PBAccountUpdatedConfirmationPage pbAUCP;
	PBPersonalInformationPage pbPIP;
	PBShippingPage pbSP;
	PBCheckoutPage pbCOP;
	PBOrderSummaryPage pbOSP;
	PBRegisterAtCheckoutPage pbRACOP;
	PBReviewOrderPage pbROP;
	PBCartPage pbCP;
	PBItemPage pbIP;
	PBEditCartPage pbECP;
	PBForgotPasswordPage pbFPP;
	PBSearchResultsPage pbSRP;
	PBCreateNewPasswordPage pbCNPP;
	PBQuickViewPage pbQVP;
	PBWishlistPage pbWLP;
	PBNewAddressPage pbNAP; 
	PBMyAddressBookPage pbMABP;
	PBMyOrdersPage pbMOP;
	PBCheckoutPreferencesPage pbCPP;
	PBStoreLocator pbSL;
	PBHeader pbHD;
	PBFooter pbFT;

	private static final EnvConfig ENV = ConfigFactory.create(EnvConfig.class);
	private static final Logger LOGGER = LoggerFactory.getLogger(CKActor.class);


	/**
	 * Steps to start checkout and enter address information as a guest on the
	 * checkout page
	 * 
	 * @param guestFields - Address information
	 */
	public void startCheckoutFromCart() {
		pbHP.clickOffPopUp();
		pbCP.clickProceedCheckOut();
	}

	public void saveOrderTotalFromCart() {
		pbHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(pbCP.getOrderTotal());
	}

	public void saveOrderTotalFromCheckout() {
		pbHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(pbCOP.getOrderTotal());
	}

	public void proceedToGuestCheckout() {
		pbHP.clickOffPopUp();
		pbSP.clickContinueAsGuest();
	}

	public void enterAndSubmitGuestGuestAddress(String guestFields) {
		pbSP.enterAddressAndSubmit(guestFields);
	}


	public void startCheckoutAndSubmitAddress(String guestFields) {
		//		if (pbCP.popUpExists()) {
		//			pbCP.clickClosePopUp();
		//		}
		//		if(Serenity.sessionVariableCalled("brand").toString().toLowerCase().equals("pb"))
		//		{
		//			Serenity.setSessionVariable("orderPrice").to(pbCP.getOrderTotal());
		//		}
		pbCP.clickProceedCheckOut();
		pbSP.clickContinueAsGuest();
		pbSP.enterAddressAndSubmit(guestFields);
	}

	public void saveQuickViewItemInfo() {
		String quickViewItem = pbQVP.getProductName();
		float quickViewPrice = pbQVP.returnOfferPrice();
		Serenity.setSessionVariable("firstItem").to(quickViewItem);
		Serenity.setSessionVariable("firstPrice").to(quickViewPrice);
	}

	public void addItemFromQuickViewPage() {
		pbSRP.goToFirstProductQuickViewPage();
		pbQVP.chooseRandomSizeWithStock();
		saveQuickViewItemInfo();
		pbQVP.clickAddToBag();

	}

	/**
	 * Navigate to homepage of the corresponding brand
	 * 
	 * @param brands String
	 */
	public void navigateTo(String brands) {
		if (brands.equalsIgnoreCase("VH")) {
			//pbHP.navigateTo(ENV.ckusURL());
			pbHP.openUrl(ENV.vhURL());
		} else if (brands.equalsIgnoreCase("IZ")) {
			//ckcaHP.navigateTo(ENV.ckcaURL());
			pbHP.openUrl(ENV.izodURL());
		}
		else if (brands.equalsIgnoreCase("SB")) {
			//ckcaHP.navigateTo(ENV.ckcaURL());
			pbHP.openUrl(ENV.sbURL());
		}
	}

	public void navigateToVH() {
		pbHP.openUrl(ENV.vhURL());
	}

	/**
	 * Click the sign in feature on the homepage
	 */
	public void clickSignIn() {
		pbHP.clickSignInRegister();
	}

	public void mobileSignIn() {
		pbHP.clickMenuButtonMobile();
		pbHP.clickSignInMobile();
	}

	public void verifyFooter()
	{
		pbFT.verifyFooterExists();
	}

	public void verifyAllHeaderLinks()
	{
		pbHP.verifyAllHeaderLinks();
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
		pbHP.clickOffPopUp();
		pbSIP.accountSignIn(email, password);
	}

	/**
	 * Sign in directly with password and email in the sign in page
	 * 
	 * @param email
	 * @param password
	 */
	public void accountSignInWithNewPassword(String email, String password) {
		pbSIP.accountSignIn(email, password);
	}

	/**
	 * Verify that the login in the account services page is successful
	 */
	public void verifyLoginIsSuccessful() {
		pbASP.verifyPageTitle();
	}

	/**
	 * verifies login error
	 * 
	 * @param error
	 */
	public void verifyLoginError(String error) {
		pbSIP.verifySignInError(error);
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
			pbSIP.accountSignIn(email, Password);
			pbHP.clickOffPopUp();
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
			pbSIP.accountSignIn(email, Password);
			pbHP.clickOffPopUp();
			pbHP.pageRefresh();
		}
	}

	/**
	 * Sets up the reset password feature and create a new new one on CK
	 * 
	 * @param brand
	 * @param email
	 */
	public void resetPassword(String brand, String email) {
		LOGGER.info("Navigating to personal information page and resetting password");
		pbASP.clickEdit();
		//pbHP.clickOffPopUp();

		String correctPassword = FileReaderManager.getInstance().getJsonDataReader()
				.getAccountPasswordByBrandAndEmail(brand, email).password;
		System.out.println("Old Password is : "+correctPassword);
		Random ra = new Random();
		String newPassword = "Temp" + ra.nextInt(9999);
		System.out.println("New Password is : "+newPassword);
		pbPIP.resetPassword(correctPassword, newPassword);
		FileReaderManager.getInstance().getJsonDataWriter().updateAccountPasswordData(brand, email, newPassword);
	}

	public void resetPasswordPB(String brand, String email, String password, String newPassword) {
		LOGGER.info("Navigating to personal information page and resetting password");
		pbHP.clickOffPopUp();
		pbHD.goToMyAccount();
		pbASP.clickEdit();
		//String correctPassword = FileReaderManager.getInstance().getJsonDataReader()
		//		.getAccountPasswordByBrandAndEmail(brand, email).password;
		//System.out.println("Old Password is : "+correctPassword);
		//Random ra = new Random();
		//String newPassword = "Temp" + ra.nextInt(9999);
		pbPIP.resetPassword(password, newPassword);
		//FileReaderManager.getInstance().getJsonDataWriter().updateAccountPasswordData(brand, email, newPassword);
		Serenity.setSessionVariable("newPassword").to(newPassword);
	}


	public void mobileResetPassword(String brand, String email, String password, String newPassword) {
		LOGGER.info("Navigating to personal information page and resetting password");
		pbHP.clickOffPopUp();
		pbHP.clickMenuButtonMobile();
		pbHD.goToMobileMyAccount();
		pbASP.clickMobileEdit();
		//String correctPassword = FileReaderManager.getInstance().getJsonDataReader()
		//		.getAccountPasswordByBrandAndEmail(brand, email).password;
		//System.out.println("Old Password is : "+correctPassword);
		//Random ra = new Random();
		//String newPassword = "Temp" + ra.nextInt(9999);
		pbPIP.resetPassword(password, newPassword);
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
		pbSIP.registerAccount(email, password);
	}

	public void registerAtSignIn(String email, String password) {
		Random rand = new Random();
		if (email.contains("@")) {
			email = email.split("@")[0] + "+" + rand.nextInt(999999) + "@" + email.split("@")[1];
		}
		Serenity.setSessionVariable("email").to(email);
		Serenity.setSessionVariable("password").to(password);
		pbSIP.registerAccount(email, password);
	}

	/**
	 * Verify that the registration details page is displayed
	 */
	public void verifyRegistrationDetailsPageIsDisplayed() {
		pbRDP.verifyPageTitle();
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
		pbRDP.fillOutRegistration(firstName, lastName, address, apartment, city, country, state, zip, phone, gender,
				bMonth, bDay);
	}

	/**
	 * Verifies that the account is registered
	 */
	public void verifyAccountIsRegistered() {
		pbAUCP.verifyPageTitle();
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
		pbRDP.verifyError(error);
	}

	/**
	 * Submits an invalid address a number of times
	 * 
	 * @param noOfTimes int
	 */
	public void submittingInvalidAddress(int noOfTimes) {
		for (int i = 1; i <= noOfTimes; i++) {
			pbRDP.clickPopUpClose();
			pbRDP.clickSave();
		}
	}

	/**
	 * Step to search and add product in the cart from the Calvin Klein home page
	 * 
	 * @param item - Product
	 */
	public void searchForProductAndAddToCart(String item) {
		pbHP.submitSearchFor(item);
		//pbHP.clickOffPopUp();

		//pbHP.clickOffPopUp();
		pbSRP.selectFirstProduct();

		//pbHP.clickOffPopUp();
		pbIP.chooseRandomSizeandAddToBag();

		pbIP.addToBag();

		Serenity.setSessionVariable("firstItem").to(pbIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(pbIP.returnOfferPrice());
		Serenity.setSessionVariable("firstListPrice").to(pbIP.returnListPrice());
		//saveSizeInfo();
		savePDPProductInfo();

		//		driver.navigate().refresh();
		pbIP.clickCheckout();
		pbHP.clickOffPopUp();	
	}

	public void savePDPProductInfo() {
		Serenity.setSessionVariable("firstItem").to(pbIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(pbIP.returnOfferPrice());
		Serenity.setSessionVariable("firstListPrice").to(pbIP.returnListPrice());
		Serenity.setSessionVariable("styleNumber").to(pbIP.getProductStyleNumber());
		//pbHP.clickOffPopUp();
	}
	public void saveMobilePDPProductInfo() {
		pbHP.clickOffPopUp();
		Serenity.setSessionVariable("firstItem").to(pbIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(pbIP.returnOfferPrice());
		Serenity.setSessionVariable("firstListPrice").to(pbIP.returnListPrice());
		Serenity.setSessionVariable("styleNumber").to(pbIP.getMobileProductStyleNumber());
		//pbHP.clickOffPopUp();
	}

	public void saveMobilePDPSecondProductInfo() {
		Serenity.setSessionVariable("secondItem").to(pbIP.getMobileProductName());
		Serenity.setSessionVariable("secondPrice").to(pbIP.returnOfferPrice());
		Serenity.setSessionVariable("secondListPrice").to(pbIP.returnListPrice());
		Serenity.setSessionVariable("secondStyleNumber").to(pbIP.getMobileProductStyleNumber());
		//pbHP.clickOffPopUp();
	}
	public void savePDPSecondProductInfo() {
		Serenity.setSessionVariable("secondItem").to(pbIP.getProductName());
		Serenity.setSessionVariable("secondPrice").to(pbIP.returnOfferPrice());
		Serenity.setSessionVariable("secondListPrice").to(pbIP.returnListPrice());
		Serenity.setSessionVariable("secondStyleNumber").to(pbIP.getProductStyleNumber());
		//pbHP.clickOffPopUp();
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
		pbHP.clickOffPopUp();
		if(email.equals("testingUser@yopmail.com")) {
			email=randomInt()+"+"+email;
		}
		Serenity.setSessionVariable("orderPrice").to(pbCP.getOrderTotal());
		pbCP.clickProceedCheckOut();
		pbSP.clickContinueAsGuest();
		pbSP.enterGuestFieldsAndSubmit(email, first, last, address, apartment, city, state, zip, phone);
	}

	/**
	 * Steps to start checkout and enter address information as a guest on the
	 * checkout page
	 * 
	 * @param guestFields - Address information
	 */
	/*
	public void startCheckoutAndSubmitAddress(String guestFields) {
		if (pbCP.popUpExists()) {
			pbCP.clickClosePopUp();
		}
		if(Serenity.sessionVariableCalled("brand").toString().toLowerCase().equals("ck"))
		{
			Serenity.setSessionVariable("orderPrice").to(pbCP.getOrderTotal());
		}
		pbCP.clickProceedCheckOut();
		pbSP.clickContinueAsGuest();
		pbSP.enterAddressAndSubmit(guestFields);
	}
	 */
	/**
	 * Steps to start checkout
	 */
	/*
	public void startCheckout() {
		if (pbCP.popUpExists()) {
			pbCP.clickClosePopUp();
		}
		if(Serenity.sessionVariableCalled("brand").toString().toLowerCase().equals("ck"))
		{
			Serenity.setSessionVariable("orderPrice").to(pbCP.getOrderTotal());
		}
		pbCP.clickProceedCheckOut();
	}
	 */

	/**
	 * Enters the shipping and billing info from the CK US pages
	 */
	public void enterShippingAndBilling() {
		pbCOP.clickNext();
		pbCOP.enterPaymentFields("MasterCard", "5555555555554444", "321", "08", "2021");
		pbROP.clickSubmitOrder();
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
		//pbCOP.clickNext();
		pbCOP.enterPaymentFields(type, number, code, expMonth, expYear);
		Serenity.setSessionVariable("orderPrice").to(pbROP.getOrderTotal());
		pbROP.clickSubmitOrder();
	}

	public void saveOrderTotalFromROP() {
		pbHP.sleep(500);
		Serenity.setSessionVariable("orderPrice").to(pbROP.getOrderTotal());
	}

	public void verifyPageLevelMessageOnItemPage(String error) {
		pbIP.verifyPageLevelMessageOnItemPage(error);
	}

	public void enterPaymentInformationButNoSubmit(String type, String number, String code, String expMonth, String expYear) {
		pbCOP.sleep(1000);
		//pbCOP.clickNext();
		pbCOP.enterPaymentFieldsWithNoSubmit(type, number, code, expMonth, expYear);
		Serenity.setSessionVariable("orderPrice").to(pbROP.getOrderTotal());
		pbCOP.sleep(1000);
	}

	public void goToReviewOrderPage() {
		pbCOP.clickReviewOrder();
	}

	/**
	 * Enters the password from the registration from pop up screen. Password is
	 * only needed because email is taken earlier in order process
	 * 
	 * @param password String
	 */
	public void enterRegistrationOnCheckOut(String password) {
		pbRACOP.registerAtCheckOut(password);
	}

	/**
	 * Cancels an order from the order summary page
	 */
	public void cancelOrder() {
		pbOSP.cancelOrder();
	}

	/**
	 * Goes to account page from the order summary page
	 */
	public void goToAccount() {
		pbOSP.clickOnAccountPage();
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
	//		pbCP.clickProceedCheckOut();
	//		ckcaCOP.enterShippingInfo(first, last, address, "United States", phone, email);
	//	}

	/**
	 * Search for products on the home page using provided search term
	 * 
	 * @param item - Search Term
	 */

	public void searchFor(String item) {
		pbHP.sleep(4000);
		pbHP.clickOffPopUp();
		pbHP.sleep(4000);
		pbHP.submitSearchFor(item);
	}
	public void mobileSearchFor(String item) {
		pbHP.clickOffPopUp();
		pbHP.submitMobileSearchFor(item);
	}

	public void enterSearchcriteria(String item) {
		pbHP.clickOffPopUp();
		pbHP.enterSearchTerm(item);
	}

	public void validateSearchSuggestion() {
		//pbHP.clickOffPopUp();
		pbHP.verifySearchSuggestion();
	}

	public void validateSearchCorrection() {
		//pbHP.clickOffPopUp();
		pbHP.verifySearchCorrection();
	}
	/**
	 * Step to enter search term in search bar
	 * 
	 * @param item - Search Term
	 */
	public void search(String item) {
		pbHP.enterSearchTerm(item);
	}


	public void mobileSearch(String item) {
		pbHP.enterMobileSearchTerm(item);
	}

	/**
	 * Step to verify search result for provided search term
	 * 
	 * @param searchTerm - Search Term
	 */
	public void verifySearchResults(String searchTerm) {
		pbHP.clickOffPopUp();
		pbSRP.verifySearchResult(searchTerm);
	}

	/**
	 * Step to verify search result for provided style number
	 * 
	 * @param styleNum - Style Number of the product
	 */
	public void verifySearchResultsForStyleNumber(String styleNum) {
		pbHP.clickOffPopUp();
		if (pbSRP.verifySearchResultHeaderExists()) {
			pbSRP.verifySearchResult(styleNum);
		} else {
			pbIP.verifyProductDetailsPageForSpecificStyleNumber(styleNum);
		}
	}

	/**
	 * Clicks on Log out on the Account Summary Page
	 */
	public void logOut() {
		LOGGER.info("Logging Out");
		pbASP.clickLogout();
	}

	public void mobileLogOut() {
		LOGGER.info("Logging Out");
		pbHP.clickMenuButtonMobile();
		pbASP.clickMobileLogout();
	}


	/**
	 * Goes to forget password
	 */
	public void goToForgotPassword() {
		pbSIP.clickForgotPassword();
	}

	/**
	 * Sends email by entering it through a field on a page
	 * 
	 * @param email
	 */
	public void sendResetPasswordEmail(String email) {
		pbHP.clickOffPopUp();
		pbFPP.inputResetEmail(email);
		pbFPP.clickSubmitEmail();
	}

	/**
	 * Confirms that reset password email has been sent
	 */
	public void confirmResetEmailSent() {
		pbFPP.confirmResetPasswordEmailSent();
	}

	/**
	 * Step to verify no search results message
	 */
	public void verifyNoResults() {
		pbSRP.verifyNoSearchResultMessage();
	}

	/**
	 * Step to verify Clavin Klein - US home page is displayed
	 */
	public void verifyCKUSHomePage() {
		pbHP.verifyPageTitle();
	}


	/**
	 * Verifies that the name of a product is located on the web page
	 * 
	 * @param name of product that is being searched
	 */
	public void verifyStyleID(String item) {

		if (pbSRP.getTitle().contains("Search Results")) {
			pbSRP.clickOnFirstElement();
		}
		pbHP.clickOffPopUp();
		String pageID = pbIP.getStyleNumber();
		assertThat(pageID).isEqualTo(item);
	}

	/**
	 * Step to verify search suggestion displayed matches the provided search term
	 * 
	 * @param text - Search Term
	 */
	public void verifySearchSuggestion(String text) {
		pbHP.verifySearchSuggestions(text);
	}

	public void selectSearchSuggestion() {
		pbHP.selectFromSearchSuggestions();
	}
	/**
	 * Step to verify user is not signed in
	 */
	public void verifyUserIsNotSignedIn() {
		pbHP.verifyUserIsNotSignedIn();
	}

	/**
	 * Step to verify prohibited character message
	 */
	public void verifyProhibitedCharacters() {
		pbSRP.verifyProhibitedCharacter();
	}

	/**
	 * Goes to the cart page from the Item page
	 */
	public void goToCartFromItemPage() {
		pbIP.clickGoToCheckOut();
		pbHP.clickOffPopUp();
	}

	public void goToCartFromCartCornerLink() {
		pbIP.clickCheckout();
		//		pbHP.clickOffPopUp();
	}

	/**
	 * Step to navigate to the cart page from the home page
	 */

	public void goToCartFromHome() {
		//		pbHP.clickCart();
		pbIP.clickCheckout();
		//		pbHP.clickOffPopUp();
	}


	public void goToCartFromMobileHome() {
		pbIP.clickMobileCheckout();
		//pbHP.clickOffPopUp();
	}

	/**
	 * Step to select first product on the search results page
	 */
	public void clickFirstProduct() {
		pbHP.clickOffPopUp();
		pbSRP.selectFirstProduct();
		savePDPProductInfo();
	}

	public void clickFirstProductOnMobile() {
		pbHP.clickOffPopUp();
		pbSRP.selectFirstProduct();
		pbHP.clickOffPopUp();
	}
	/**
	 * Creates a new password on the new password page
	 * 
	 * @param password String
	 */
	public void createNewPasswordOnNewPage(String password) {
		pbCNPP.createNewPasswordOnNewPasswordPage(password);
	}

	/**
	 * a void statement that adds to bag in the Item page and clicks off pop up on
	 * homepage
	 */
	public void addToBag() {
		pbHP.clickOffPopUp();
		try{
			Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
		pbHP.clickOffPopUp();
		pbHP.sleep(1000);
		pbIP.clickAddToBag();
		//pbHP.clickOffPopUp();
		//pbHP.sleep(500);
	}


	public void mobileAddToBag() {
		//pbHP.clickOffPopUp();
		try{
			Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
		pbHP.clickOffPopUp();
		pbHP.sleep(500);
		pbIP.clickAddToMobileBag();
		//pbHP.clickOffPopUp();
		//pbHP.sleep(500);
	}

	/**
	 * A void method that clicks on the next available size in size selction option.
	 * Also adds the item to the cart
	 */
	public void chooseRandomSize() {
		pbHP.clickOffPopUp();
		pbIP.chooseRandomSizeandAddToBag();
	}
	/**
	 * Gets the name of the product of the item page
	 * @return
	 */
	public String getProductNameOfItemPage() {
		String name = pbIP.getNameOfProduct();
		return name;
	}

	/**
	 * Gets the name of the product price of the item page
	 * @return
	 */
	public String getProductPriceOfItemPage() {
		String price = pbIP.getPrice();
		return price;
	}

	/**
	 * Saves the item info into a session variable on serenity
	 */
	public void saveFirstItemInfo() {
		String firstItem = pbIP.getProductName();
		float firstPrice = pbIP.returnOfferPrice();
		float firstListPrice = pbIP.returnListPrice();
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
		float orderPrice = pbCP.getOrderTotal();
		Serenity.setSessionVariable("orderPrice").to(orderPrice);
	}

	/**
	 * Saves the size information 
	 */

	public void saveSizeInfo() {
		String size = pbIP.getSizesSelected();
		Serenity.setSessionVariable("size").to(size);
	}

	/**
	 * Verifies the item in the cart mini display
	 */
	public void verifyItemInCartMiniDisplay() {
		pbIP.verifyItemInCartDisplayInCorner();
	}

	/**
	 * Verifies the item in the cart matches the item that was added recently
	 */

	public void verifyItemNameMatchesCart() {
		pbIP.clickGoToCheckOut();
		pbCP.clickClosePopUp();
		pbCP.verifyCartNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}

	public void verifySecondItemNameMatchesCart() {
		pbIP.clickGoToCheckOut();
		pbCP.clickClosePopUp();
		pbCP.verifyCartNameMatchesItemPage(Serenity.sessionVariableCalled("secondItem"),
				Serenity.sessionVariableCalled("secondPrice"));
	}


	public void verifyWishlistNameMatchesCart() {

		pbHP.clickOffPopUp();
		pbWLP.verifyWishlistNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("firstPrice"));
	}

	/**
	 * Searches for item in the cart and clicks on the first product of the search results. Next it selects a size
	 * @param item
	 */
	public void searchForItemInCart(String item) {
		//		pbCP.searchFor(item);
		pbHP.submitSearchFor(item);
		clickFirstProduct();
		chooseRandomSize();
		saveFirstItemInfo();
	}

	public void searchForItemAfterFirst(String item) {
		pbCP.searchFor(item);
		clickFirstProduct();
		chooseRandomSize();
	}

	/**
	 * Goes to the edit button on the cart page to edit a product
	 */
	public void goToEdit() {
		pbHP.clickCart();
		pbHP.clickOffPopUp();
		pbCP.editProduct();
	}

	/**
	 * Adjusts the quantity of an item
	 * @param quant
	 */
	public void adjustQuantity(String quant) {
		pbCP.adjustQuantity(Serenity.sessionVariableCalled("firstItem"), quant);
	}


	public void adjustQuantityOnMobile(String quant) {
		pbCP.adjustQuantityOnMobile(quant);
	}

	/**
	 * Selects the quantity of an item number
	 * @param quant
	 */
	public void selectQuantityItemPage(String quant) {
		pbIP.selectQuantity(quant);

	}

	public void selectQuantityItemPageOnMobile(String quant) {
		pbIP.selectQuantityOnMobile(quant);

	}

	/**
	 * Refreshes page
	 */
	public void refreshPage() {
		pbHP.getDriver().navigate().refresh();
	}

	/**
	 * Saves the second item that was searched for in the session
	 */
	public void saveSecondItemInfo() {
		String secondItem = pbIP.getProductName();
		float secondPrice = pbIP.returnOfferPrice();
		float secondListPrice = pbIP.returnListPrice();
		Serenity.setSessionVariable("secondItem").to(secondItem);
		Serenity.setSessionVariable("secondPrice").to(secondPrice);
		Serenity.setSessionVariable("secondListPrice").to(secondListPrice);
	}

	/**
	 * Verifies that the two items that were added to the cart are the same in the cart
	 */
	public void verifyTwoItemsMatchesCart() {
		//		pbIP.clickGoToCheckOut();
		//		pbIP.clickCheckout();
		pbHP.clickOffPopUp();
		pbCP.verifyMultipleItemsInCart(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("secondItem"), Serenity.sessionVariableCalled("firstPrice"),
				Serenity.sessionVariableCalled("secondPrice"));
	}

	/**
	 * Removes the second item from the cart
	 */
	public void removeSecondItemFromCart() {
		pbCP.getDriver().navigate().refresh();
		pbCP.removeSecondItem();
	}

	/**
	 * Verifies an empty cart
	 */
	public void verifyEmptyCart() {
		pbCP.verifyEmptyCart();
	}

	/**
	 * Adds a gift box to the order 
	 * @param to
	 * @param from
	 * @param message
	 */
	public void addGiftBox(String to, String from, String message) {
		pbCP.addGiftBox(to, from, message);
	}

	/**
	 * Edits the gift box in the order
	 * @param newTo
	 * @param newFrom
	 * @param newMessage
	 */
	public void editGiftBox(String newTo, String newFrom, String newMessage) {
		pbCP.editGiftBox(newTo, newFrom, newMessage);
	}

	/**
	 * Verifies the gift box text is equal to what was inputted
	 * @param to
	 * @param from
	 * @param message
	 */
	public void verifyGiftBoxText(String to, String from, String message) {
		pbCP.verifyGiftBox(to, from, message);
	}

	/**
	 * Removes the gift box
	 */
	public void removeGiftBox() {
		pbCP.removeGiftBox();
	}

	/**
	 * Verifies gift box is removed
	 */
	public void verifyGiftBoxRemoved() {
		pbCP.verifyRemovalGiftBox();
	}

	/**
	 * Clicks edit from an item on the cart page
	 */
	public void clickEditItemFromCartForFirst() {
		pbCP.clickFirstEdit();
		pbECP.chooseNextAvailableSize(Serenity.sessionVariableCalled("size"));
	}

	public void selectToEditItemFromCartForFirst() {
		pbCP.clickFirstEdit();
	}
	public void verifyUserIsOnPDP() {
		pbHP.clickOffPopUp();
		pbIP.verifyUserIsOnPDP();
	}

	/**
	 * Clicks edit from an item on the cart page
	 */
	public void updateColor() {
		pbCP.clickFirstEdit();
		String itemSize = Serenity.sessionVariableCalled("styleNumber");
		LOGGER.info("Initially selected color is : "+pbCOP.getColorText(itemSize));
		pbIP.clickColorOption(1);
		pbIP.updateBag();
		//Serenity.setSessionVariable("item1Color").to(pbCOP.getColorText(itemSize));
		//LOGGER.info(Serenity.sessionVariableCalled("item1Color"));
	}

	public void updateProductOnMobile() {
		pbCP.clickFirstEdit();
		LOGGER.info("Updating Quantity in cart");
		Serenity.setSessionVariable("item1Quant").to("2");
		pbIP.updateQuantityAddToBag();
	}

	/**
	 * Verifies the size after an edit on the cart page
	 */
	public void verifySizesAfterEdit() {
		pbCP.verifyFirstSize(Serenity.sessionVariableCalled("size"));
	}

	/**
	 * Applies the promo code
	 * @param code
	 */
	public void applyPromoCode(String code) {
		pbCP.applyPromoCode(code);
	}

	/**
	 * Verifies promo code message
	 * @param message
	 */
	public void verifyPromoMessage(String message) {
		pbCP.verifyPromoCodeError(message);
	}

	/**
	 * Click add to wish list
	 */
	public void addToWishlist() {
		pbHP.clickOffPopUp();
		pbIP.addToWishList();
	}
	/**
	 * Click add to mobile wish list
	 */
	public void addToMobileWishlist() {
		pbHP.clickOffPopUp();
		pbIP.addToMobileWishList();
	}
	/**
	 * Steps to navigate to wish list from my account option on header
	 */
	public void goToWishlist() {
		pbHP.pageRefresh();
		pbHP.clickOffPopUp();
		pbHD.goToMyWishlist();
	}


	public void goToMobileWishlist() {
		pbHP.clickOffPopUp();
		pbHP.clickMenuButtonMobile();
		pbHD.goToMyMobileWishlist();
	}
	/**
	 * Goes to check out from the Cart page. It clicks the proceed to checkout button
	 */
	public void goToCheckout() {
		pbCP.clickProceedCheckOut();
	}

	/**
	 * Add to bag from the wish list on the wish list page
	 */
	public void addToBagFromWishlist() {
		pbWLP.addFirstItemToCart();
	}

	/**
	 * Add to bag from the mobile wish list on the wish list page
	 */
	public void addToBagFromMobileWishlist() {
		pbWLP.addFirstItemToMobileCart();
	}

	/**
	 * Saves the total of the order on the cart page, and proceeds to checkout from the cart page
	 */
	public void proceedToSecureCheckout() {
		//Serenity.setSessionVariable("orderPrice").to(pbCP.getOrderTotal());
		pbHP.clickOffPopUp();
		pbCP.clickProceedCheckOut();
	}

	/**
	 * Step to verify summary of order submitted using credit card
	 * 
	 * @param creditCardType - Credit Card Type
	 */
	public void verifyOrderSummary(String creditCardType) {
		pbHP.clickOffPopUp();
		pbOSP.verifyOrderDetails(Serenity.sessionVariableCalled("firstItem"),
				Serenity.sessionVariableCalled("orderPrice"), creditCardType);
	}

	/**
	 * verifies order summary and the shop runner account
	 */
	public void verifyOrderSummaryAndShopRunner() {
		pbHP.clickOffPopUp();
		LOGGER.info(Serenity.sessionVariableCalled("type").toString());
	}

	/**
	 * Steps to enter gift card information during checkout
	 * 
	 * @param number - Gift Card Number
	 * @param pin    - Gift Card Pin
	 */
	public void enterAndApplyGiftCard(String number, String pin) {
		pbCOP.clickNext();
		pbCOP.enterGiftCardFields(number, pin);
	}

	public void justEnterGiftCard(String number, String pin) {
		pbCOP.enterGiftCardFields(number, pin);
	}

	/**
	 * Step to verify gift is applied on checkout page
	 */
	public void verifyGiftCardApplied() {
		pbCOP.verifyGiftCardApplied();
	}

	/**
	 * Changes an address on the checkout page and adds it on the pop up new address page
	 * @param newAddress
	 */
	public void changeAndAddAddress(String newAddress) { 
		pbCOP.clickChangeAddress(); 
		pbNAP.clickNewAddress(); 
		pbNAP.enterNewAddress(newAddress); 
	} 

	public void changeAndAddressFromReviewOrderPage(String newAddress) {
		pbROP.clickChangeAddress();
		pbNAP.clickNewAddress();
		pbNAP.enterNewAddress(newAddress);
	}

	/**
	 * Changes a billing address from the check out page and adds a billing address through a pop up new address page
	 * @param newBilling
	 */
	public void changeAndAddBillingAddress(String newBilling) { 
		pbCOP.clickChangeBillingAddress(); 
		pbNAP.clickNewBillingAddress(); 
		pbNAP.enterNewBillingAddress(newBilling);
	}

	public void changeAndAddBillingAddressFromReviewOrderPage(String newBilling) {
		pbROP.clickChangeBillingAddress();
		pbNAP.clickNewBillingAddress();
		pbNAP.enterNewBillingAddress(newBilling);
	}

	/**
	 * Adds billign address if necessary while signed in.
	 * Since the sign in feature stores the added addresses, the best way to make sure it doesn't go over board with addresses is with a check
	 * It checks to see if the address list is above two, if not it adds an address
	 * @param newBilling
	 */
	public void changeAndAddBillingSignedIn(String newBilling) {
		pbCOP.clickChangeBillingAddress();
		if (pbNAP.getNumberOfBillingAddresses() > 2) {
			pbHP.clickOffPopUp();
		} else {
			pbNAP.clickNewBillingAddress();
			pbNAP.signedInEnterBillingAddress(newBilling);
		}
	}

	/**
	 * Verifies that the new shipping address is the current one on the check out page
	 * @param newAddress
	 */
	public void verifyNewAddressCurrent(String newAddress) { 
		String[] arr = newAddress.split(";");
		pbCOP.verifyShippingAddress(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]);
	}

	/**
	 * verifies that the new billing address is the current on on the checkout page
	 * @param newBilling
	 */
	public void verifyNewBillingAddressCurrent(String newBilling) {
		String[] arr = newBilling.split(";");
		pbCOP.verifyBillingAddress(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	} 

	/**
	 * Verifies that the edited address is the current one on the checkout page. The would normally 
	 * @param newAddress
	 */
	public void verifyEditAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		pbCOP.verifyShippingAddressForEdit(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}

	public void verifyEditBillingAddressCurrent(String newAddress) {
		String[] arr = newAddress.split(";");
		pbCOP.verifyBillingAddressForEdit(arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], arr[9], arr[0]); 
	}
	public void verifySecondAddressApplies() { 
		pbCOP.clickChangeAddress(); 
		String text = pbNAP.getModdedRemoveAllSpacesAddress(); 
		pbNAP.clickSecondAddress();  
		pbCOP.verifySelectedShippingAddressIsVisible(text); 
	} 
	public void verifySecondBillingAddressApplies(String address) { 
		pbCOP.clickChangeBillingAddress(); 
		String[] arr = address.split(";");
		String text = pbNAP.getModdedBillingAddressMatchingName(arr[1], arr[2]); 
		pbNAP.clickBillingAddressByFirstName(arr[1], arr[2]); 
		pbCOP.verifySelectedBillingAddressIsVisible(text); 
	} 
	public void editCheckOutAddress(String editAddress) {
		//pbCP.clickProceedCheckOut();
		pbCOP.clickChangeAddress();
		pbNAP.clickFirstShippingAddressEdit();
		pbNAP.enterEditedAddress(editAddress);
	}

	/**
	 * Steps to select Paypal payment method
	 */
	public void selectPaypalPaymentMethod() {
		pbCOP.payWithPayPal();
		pbROP.clickProceedToPaypal();
	}

	/**
	 * Steps to submit order
	 */
	public void submitCheckoutOrder() {
		pbHP.sleep(500);
		pbROP.clickSubmitOrder();
	}

	public void editCheckOutBillingAddress(String editAddress) {
		pbCOP.clickChangeBillingAddress();
		pbNAP.clickFirstBillingAddressEdit();
		pbNAP.enterEditedAddress(editAddress);
	}
	public void editCheckOutBillingAddressFromReviewOrderPage(String editAddress) {
		pbROP.clickChangeBillingAddress();
		pbNAP.clickFirstBillingAddressEdit();
		pbNAP.enterEditedAddress(editAddress);
	}

	public void enterShopRunnerInfo(String email, String password) {
		pbCOP.enterShopRunnerInfo(email, password);
	}
	public void verifyShopRunnerAndItemDetails() {
		pbOSP.verifyFinalOrderDetailsWithShopRunner(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"), Serenity.sessionVariableCalled("type"));
	}

	public void applyAward(String reward) {
		pbCP.clickProceedCheckOut();
		pbCOP.clickNext();
		pbCOP.selectFirstReward();
	}
	public void applyTwoAwards() {
		pbCP.clickProceedCheckOut();
		pbCOP.clickNext();
		pbCOP.deSelectAwards();
		pbCOP.selectTwoAwards();
	}
	public void verify100LoyaltyApplied() {
		pbCOP.verifyRewardsApplied("0.00", "100.00");
		pbCOP.clickReviewOrder();
		pbROP.clickSubmitOrder();
		pbOSP.verifyLoyaltyAppliedToTotal("0.00", "100.00");
	}
	public void verifyRewardApplied(String amount) {
		pbCOP.verifyRewardsApplied(amount, amount);
		pbCOP.clickReviewOrder();
		pbROP.clickSubmitOrder();
		pbOSP.verifyLoyaltySavingsApplied(amount, amount);
	}
	public void verifyRewardsSelected() {
		pbCOP.verifyRewardsApplied();
		pbCOP.clickReviewOrder();
		pbROP.clickSubmitOrder();
		pbOSP.verifyLoyaltySavingsApplied("30.00", "30.00");
	}

	public void CheckoutShopRunner(String email,String password) {
		pbHP.clickOffPopUp();
		Serenity.setSessionVariable("orderPrice").to(pbCP.getOrderTotal());
		pbCP.loginWithShoprunner(email, password);
		pbHP.clickOffPopUp();
	}

	public void checkoutShoprunner() {
		pbCP.checkoutShoprunner();
	}
	public void verifyShopRunner() {
		pbHP.clickOffPopUp();
		pbHP.clickOffPopUp();
		pbOSP.verifyFinalOrderDetailsWithShopRunner(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"));
	}

	/**
	 * Step to select provided shipping method
	 * 
	 * @param shippingMethod - Shipping method e.g.: STANDARD / SECOND DAY /
	 *                       OVERNIGHT
	 */
	public void selectShippingMethod(String shippingMethod) {
		pbCOP.selectShippinhMethod(shippingMethod);
		pbHP.sleep(5000);

	}

	public void applyGiftCardInShoprunner(String number, String pin) {
		pbCP.clickApplyShoprunnerGiftcard();
		try{
			Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
		pbCP.enterGiftcard(number, pin);
		try{
			Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

	public void verifyPaypal() {
		pbHP.clickOffPopUp();
		pbHP.clickOffPopUp();
		pbOSP.verifyFinalOrderDetailsWithPaypal(Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"));
	}

	public void verifyLoyatyandGiftCard(String amount, String creditCardType) {

		pbCOP.verifyRewardsApplied(amount, amount);
		pbCOP.clickReviewOrder();
		pbROP.clickSubmitOrder();
		pbOSP.verifyLoyaltySavingsAndGiftCard(amount, amount, Serenity.sessionVariableCalled("firstItem"), Serenity.sessionVariableCalled("orderPrice"), creditCardType);
	}


	public void addCartItemToWishlist() {
		pbCP.addToWishlist();
		pbHP.sleep(1500);
	}

	/**
	 * Step to verify wish list error message
	 * @param error
	 */
	public void verifyWishlistError(String error) {
		pbCP.verifyWishlistError(error);		
	}

	public void editPersonalInformation(String infoFields) {
		pbASP.clickEdit();
		pbHP.clickOffPopUp();
		pbPIP.enterAddressAndSubmit(infoFields);
	}


	public void editPersonalInformationOnMobile(String infoFields) {
		pbHP.clickOffPopUp();
		pbHP.clickMenuButtonMobile();
		pbHD.goToMobileMyAccount();
		pbASP.clickMobileEdit();
		pbHP.clickOffPopUp();
		pbPIP.enterAddressAndSubmit(infoFields);
	}

	public void editPersonalInformationWithAddressy(String infoFields) {
		pbASP.clickEdit();
		pbHP.clickOffPopUp();
		pbPIP.selectAddressySuggestionAndSubmit(infoFields);
	}

	public void editPersonalInformationWithAddressyOnMobile(String infoFields) {
		pbASP.clickMobileEdit();
		pbHP.clickOffPopUp();
		pbPIP.selectAddressySuggestionAndSubmit(infoFields);
	}

	public void editPersonalInformationAndSubmitFourTimes(String infoFields) {
		pbASP.clickEdit();
		pbHP.clickOffPopUp();
		pbPIP.enterAddressAndSubmitFourTimes(infoFields);
	}

	public void editPersonalInformationOnMobileAndSubmitFourTimes(String infoFields) {
		pbASP.clickMobileEdit();
		pbHP.clickOffPopUp();
		pbPIP.enterAddressAndSubmitFourTimes(infoFields);
	}


	public void verifyPersonalInformationUpdated() {
		pbPIP.verifyInformationUpdated();
	}

	public void navigateToCheckoutPreferences() {
		pbHP.clickOffPopUp();
		pbASP.navigateToCheckoutPreferences();
	}

	public void navigateToMobileCheckoutPreferences() {		
		pbASP.navigateToCheckoutPreferencesOnMobile();
	}

	public void editCheckoutInformation(String infoFields) {

		//pbASP.navigateToCheckoutPreferences();
		pbHP.clickOffPopUp();
		pbCPP.enterCheckoutInformation(infoFields);
	}

	public void editCheckoutInformationOnMobile(String infoFields) {

		//pbHP.clickMenuButtonMobile();
		//pbASP.navigateToCheckoutPreferencesOnMobile();
		pbHP.clickOffPopUp();
		pbCPP.enterCheckoutInformation(infoFields);
	}

	public void editCheckoutInformationWithAddressySelection(String infoFields) {

		//pbASP.navigateToCheckoutPreferences();
		pbHP.clickOffPopUp();
		pbCPP.enterCheckoutInformationWithAddressySelection(infoFields);
	}	

	public void editCheckoutInformationWithAddressySelectionOnMobile(String infoFields) {
		pbHP.clickOffPopUp();
		pbHP.sleep(500);
		pbASP.navigateToCheckoutPreferencesOnMobile();
		pbHP.clickOffPopUp();
		pbCPP.enterCheckoutInformationWithAddressySelection(infoFields);
	}	

	public void saveCheckoutInformation() {
		// TODO Auto-generated method stub
		pbCPP.clickUpdate();
	}
	public void editBillingCheckoutInformation(String infoFields) {
		pbASP.navigateToCheckoutPreferences();
		pbHP.clickOffPopUp();
		pbCPP.clickOffSameAsBillingPB();
		pbCPP.enterBillingCheckoutInformation(infoFields);
	}

	public void verifyCheckoutPreUpdate() {

		pbCPP.verifyInformationUpdated();
	}

	public void navigateToMyAccount() {
	//	pbHD.pageRefresh();
		pbHD.clickOffPopUp();
		pbHD.goToMyAccount();
	}

	public void navigateToMobileMyAccount() {
		pbHD.pageRefresh();
		pbHP.clickOffPopUp();
		pbHP.clickMenuButtonMobile();
		pbHD.goToMobileMyAccount();
	}

	public void navigateToAddressBook() {
		pbASP.navigateToMyAddressBook();
	}

	public void addShippingAddress(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.enterShippingAddressFieldsAndSubmit(guestFields);
	}

	public void addShippingAddressWithAddressySelection(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.enterShippingAddressWithAddressySuggestionAndSubmit(guestFields);
	}

	public void verifyAddressAdded() {
		pbMABP.verifyAddressAdded();
	}

	public void addBillingAddress(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.enterBillingAddressFieldsAndSubmit(guestFields);
	}

	public void updateBillingAddress(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.findAndUpdateBillingAddress(guestFields);
	}

	public void enterBillingAddressFieldsAndSubmitFourTimes(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.enterBillingAddressFieldsAndSubmitFourTimes(guestFields);
	}

	public void enterShipAndBillAddressFieldsFourTimes(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.enterShipAndBillAddressFieldsFourTimes(guestFields);
	}

	public void enterShipAndBillButCancels(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.enterShipAndBillButCancels(guestFields);
	}

	public void verifyAllAddressesRemoved() {
		pbMABP.verifyAllAddressesRemoved();
	}

	public void deleteAllAddresses() {
		//pbASP.navigateToMyAddressBook();
		pbMABP.deleteAllAddresses();
	}

	public void verifyCancelAddress() {
		pbMABP.verifyCancel();
	}

	public void updateBillingAndShippingAddress(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.findAndUpdateShippingAndBillingAddress(guestFields);
	}

	public void addShippingAndBillingAddress(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.enterShippingAndBillingAddressFieldsAndSubmit(guestFields);
	}

	public void updateBillingAndShippingAddressFourTimes(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.updateExisitingShippingAndBillingAddressFieldsAndSubmitFourTimes(guestFields);
	}

	public void enterUpdateBillingAddressFieldsThreeTimes(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.enterUpdateBillingAddressFieldsFourTimes(guestFields);
	}

	public void enterUpdateShippingAddressFieldsFourTimes(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.updateShippingAddressFieldsFourTimes(guestFields);
	}

	public void verifyUpdatedInvalidAddressAddressBook() {
		pbMABP.verifyUpdatedInvalidAddress();
	}

	public void verifyInvalidAddressAdded() {

		pbMABP.verifyInvalidAddressAdded();
	}

	public void addInvalidShippingAddress(String guestFields) {

		//pbASP.navigateToMyAddressBook();
		pbMABP.addInvalidShippingAddress(guestFields);
	}


	public void removeSavedAddress() {
		//pbASP.navigateToMyAddressBook();
		pbMABP.selectExistingAddress();
		pbMABP.removeAddress();
	}
	public void verifyAddressRemoved() {
		pbMABP.verifyAddressRemoved();
	}

	public void verifyRewardsExist() {
		pbASP.clickSideTabRewards();
		pbASP.verifyRewardsAvailable();
	}

	public void signUpOnPopUp(String email) {
		pbHP.capturePopUp();
		pbHP.enterAndSubmitSignUpPopUp(email);
	}

	public void verifySignUpOnPop() {
		pbHP.verifyCongratsPopUpSignUp();
	}

	public void verifyNoEmailErrorPopUp() {
		pbHP.verifyNoEmailUnSuccessfulPopUp();
	}

	public void clickSignUpPopUp() {
		pbHP.capturePopUp();
		pbHP.clickSignUpPopUp();
	}


	public void updateSavedAddress(String guestFields) {
		//pbASP.navigateToMyAddressBook();
		pbMABP.selectExistingAddress();
		pbMABP.updateExisitingShippingAddressFieldsAndSubmit(guestFields);
	}

	public void updateShippingAddress(String guestFields) {
		pbASP.navigateToMyAddressBook();
		pbMABP.findAndUpdateShippingAddress(guestFields);
	}

	public void verifyUpdateAddress() {
		pbMABP.verifyUpdateAddress();
	}


	public void addItemWithQuantity(String item, int x)
	{
		pbHP.submitSearchFor(item);
		pbSRP.pageRefresh();
		pbSRP.selectFirstProduct();
		pbIP.chooseRandomSizeandAddToBag();
		pbIP.selectQuantity("" + x);
		Serenity.setSessionVariable("firstItem").to(pbIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(pbIP.returnOfferPrice());
		//pbIP.clickGoToCart();
	}

	public void addAmountOfItems(int x, String item)
	{

		pbHP.submitSearchFor(item);
		pbHP.pageRefresh();
		pbHP.sleep(500);
		pbHP.clickOffPopUp();
		pbSRP.selectProduct(1);
		pbIP.chooseRandomSizeandAddToBag();
		pbIP.clickAddToBag();
		pbHP.sleep(500);
		int iteration = 1;
		while(pbCP.getNumItemsInBag() < x+2 && iteration < x+2)
		{
			LOGGER.info("Running iteration: "+iteration);
			pbHP.getDriver().navigate().back();
			iteration++;
			pbSRP.selectProduct(iteration);
			pbIP.chooseRandomSizeandAddToBag();
			pbIP.clickAddToBag();
			pbHP.sleep(2000);
		}
	}

	public void verifyNumberOfItems(int quantity)
	{

		goToCartFromItemPage();
		assertThat(pbCP.getNumItemsInBag() >= quantity);
	}


	public void addItemToCartTwice(String itemName)
	{
		pbHP.submitSearchFor(itemName);
		pbHP.clickOffPopUp();
		pbHP.sleep(1000);
		pbSRP.selectProduct(1);
		pbIP.sleep(1000);
		pbHP.clickOffPopUp();
		pbIP.chooseRandomSizeandAddToBag();
		pbIP.selectQuantity("1");
		pbIP.clickHomePage();
	}
	public void verifyNumItemsInCart(String error) {
		pbCP.verifyNumItemsInCart(Integer.parseInt(error));
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
		pbHP.submitSearchFor(itemNames[(num % 16)]);
		pbHP.pageRefresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pbHP.clickOffPopUp();
		pbSRP.selectProduct(1);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pbIP.chooseRandomSizeandAddToBag();
		pbIP.selectQuantity("11");


		if(pbIP.getPageLevelMessage().toLowerCase().contains("quantity you selected exceeds"))
		{
			hadLessThan12 = true;
		}

		Serenity.setSessionVariable("firstItem").to(pbIP.getProductName());
		Serenity.setSessionVariable("firstPrice").to(pbIP.returnOfferPrice());
		pbIP.clickHomePage();
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

			pbHP.submitSearchFor(itemNames[(num % 16)]);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pbSRP.selectProduct(itemOn);
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pbIP.chooseRandomSizeandAddToBag();
			pbIP.selectQuantity("11");

			Serenity.setSessionVariable("firstItem").to(pbIP.getProductName());
			Serenity.setSessionVariable("firstPrice").to(pbIP.returnOfferPrice());

			if(pbIP.getPageLevelMessage().toLowerCase().contains("quantity you selected exceeds"))
			{
				hadLessThan12 = true;
			}

			//pbIP.getDriver().navigate().to(pbHP.URL);
			pbIP.clickHomePage();
			//pbSRP.pageRefresh();
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

		pbCP.verifyItemWasAdded();
	}

	public void saveProductInformationAtCheckout() {
		String itemSize = Serenity.sessionVariableCalled("styleNumber");
		Serenity.setSessionVariable("item1Color").to(pbCOP.getColorText(itemSize));
		Serenity.setSessionVariable("item1Size").to(pbCOP.getSizeText());
		Serenity.setSessionVariable("item1Quant").to(pbCOP.getQuantText());
		LOGGER.info(pbCOP.getColorText(itemSize) + "   " + pbCOP.getSizeText() + "  " + pbCOP.getQuantText()  );
	}

	public void editItemAtCheckout() {

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		pbCOP.clickEditButton();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		pbIP.clickLarge();
		//		pbIP.clickColorOption(1);
		//		String color = pbIP.getColorText();
		Serenity.setSessionVariable("item1Quant").to("2");
		pbHP.sleep(500);
		pbIP.selectQuantityInPopup(Serenity.sessionVariableCalled("item1Quant"));
		//		pbCOP.checkColorSizeQuant(color,"L","2");
		pbIP.updateBag();
		pbHP.sleep(3000);
	}

	public void editItemAtCheckoutOnMobile() {

		String itemSize = Serenity.sessionVariableCalled("styleNumber");
		Serenity.setSessionVariable("item1Color").to(pbCOP.getColorText(itemSize));
		Serenity.setSessionVariable("item1Size").to(pbCOP.getSizeText());
		Serenity.setSessionVariable("item1Quant").to(pbCOP.getQuantText());
		LOGGER.info(pbCOP.getColorText(itemSize) + "   " + pbCOP.getSizeText() + "  " + pbCOP.getQuantText()  );
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.info("Clicking on the Edit botton");
		pbCOP.clickEditButton();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//		pbIP.clickLarge();
		//		pbIP.clickColorOption(1);
		//		String color = pbIP.getColorText();

		LOGGER.info("Updating Quantity in cart");
		Serenity.setSessionVariable("item1Quant").to("2");
		pbIP.updateQuantityAddToBag();
		//		pbCOP.checkColorSizeQuant(color,"L","2");
		//		pbIP.updateBag();
	}

	public void editAtCheckOut() {
		pbCOP.waitFor(3000);
		pbCOP.clickEditButton();
		pbCOP.waitFor(3000);
	}

	public void verifyProductQuntUpdated() {
		pbCOP.verifyUpdatedProductQuanity();		
	}

	public void checkColorSizeQuant(String color, String size, String quant) {

		pbCOP.checkColorSizeQuant(color, size, quant);
	}
	public void removeItemAtCheckout() {

		/*int initItems = pbCOP.getNumOfCheckoutItems();
		pbCOP.removeCheckoutItem1();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(initItems >1)
		{
			int finalItems = pbCOP.getNumOfCheckoutItems();
			pbCOP.checkItemListNumbers(initItems,finalItems);
		}
		else
		{
			pbCOP.checkForShoppingBagEmpty();
		}*/
		pbHP.sleep(1000);
		pbCOP.removeCheckoutItem1();
	}
	public void proceedToReviewOrder() {

		LOGGER.info("Procedding to Review Order Page...");
		pbCOP.clickReviewOrder();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void navigateBackAndVerify() {

		pbROP.clickBackButton();
		LOGGER.info("Navigating back...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pbHP.sleep(1000);
		pbCOP.verifyOnPage();
	}
	public void clickNext() {

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LOGGER.info("Clicking Next To Open Credit Card...");
		pbHP.sleep(5000);
		pbCOP.clickNext();
		pbHP.sleep(5000);

		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void navigateEditAndVerify() {

		pbROP.clickEditButton();
		LOGGER.info("Navigating back...");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pbCP.verifyOnPage();

	}
	public void navigateToOrderPage() {
		pbASP.navigateToMyOrders();
	}
	public void verifyNoOrders() {
		pbMOP.verifyNoOrders();
	}
	public void getFirstSize() {

		Serenity.setSessionVariable("size").to(pbCP.getFirstSize());
	}
	public void verifyValidPromoWrongRequirement() {
		pbCP.verifyValidPromoWrongRequirement();
	}

	public void verifyValidPromoForFirstItem(String code) {
		pbCP.verifyValidPromoForFirstItem(code);
	}

	public void removeFirstItemFromCart() {
		pbCP.removeFirstItem();
	}
	public void removePromoCode() {
		pbCP.removePromoCode();	}

	public void verifyPersonalInformationWithoutAddress() {
		pbHD.clickGoToAccountOnPage();
		pbASP.verifyNoSavedAddress();
	}

	public void verifyPersonalInformationWithoutAddressOnMobile() {
		pbHP.clickOffPopUp();
		pbHP.clickMenuButtonMobile();
		pbHD.goToMobileMyAccount();
		pbASP.verifyNoSavedAddress();
	}
	public void verifyPersonalInformationAddress() {
		pbHP.clickOffPopUp();
		pbHD.clickGoToAccountOnPage();
		pbASP.verifySavedAddress();
	}

	public void verifyPersonalInformationAddressOnMobile() {
		pbHP.clickOffPopUp();
		pbHP.clickOffPopUp();
		pbHP.clickMenuButtonMobile();
		pbHD.goToMobileMyAccount();
		//pbHD.clickGoToAccountOnPage();
		pbASP.verifySavedAddress();
	}

	public void verifyQuantityNotAvailableError() {
		pbCP.verifyQuantityNotAvailableError();
	}
	public void adjustQuantityWithoutCheckStock(String quant) {
		pbCP.adjustQuantityWithoutCheckStock(Serenity.sessionVariableCalled("firstItem"), quant);
	}
	public void verifyPleaseSelectASize() {
		pbIP.verifyPleaseSelectSize();
	}
	public void checkoutAndAdjustQuantity(String quant) {
		pbCP.clickProceedCheckOut();
		pbCP.clickClosePopUp();
		pbCOP.adjustQuantityWithoutCheckStock(Serenity.sessionVariableCalled("firstItem"), quant);
	}

	public void verifyAdjustedQuantityOnCheckout(String quantity) {
		//pbCOP.verifyCheckoutNameMatchesItemPage(Serenity.sessionVariableCalled("firstItem"),
		//Serenity.sessionVariableCalled("firstPrice"));
		pbCOP.verifyUpdatedQuantity(quantity);
	}

	public void verifyCartPage() {
		pbIP.clickAddToBag();
		pbIP.clickEditBagFromMiniCart();
		pbCP.verifyCartPage();
	}
	public void verifyValidPromoForMulitpleItems(String code) {
		pbCP.verifyValidPromoForMulitpleItems(code);
	}
	public void verifyNoPromoApplied(String code) {
		pbCP.verifyNoPromoApplied(code);
	}
	public void goToCheckoutAndApplyPromo(String code) {
		//pbCP.clickProceedCheckOut();
		pbSP.pageRefresh();
		pbSP.submitPromoCode(code);
	}
	public void verifyPromoCodeAppliedOnCheckout() {
		pbSP.verifyPromoCodeAppliedOnCheckout();
	}
	public void verifyPromoCodeAppliedAndRemovedOnCheckout() {
		pbSP.verifyPromoCodeAppliedAndRemovedOnCheckout();
	}
	public void editPaymentOnReviewOrderPage(){
		pbROP.clickEditPayment();
	}
	public void editShippingMethodOnReviewOrderPage() {
		pbROP.clickEditShippingMethod();
	}
	public void verifyShippingMethodOnReviewOrderPage(String shippingMethod) {
		pbROP.verifyShippingMethod(shippingMethod);
	}
	public void verifyPaymentInformationUpdated(String type, String cardNumber, String expMonth, String expYear) {
		pbROP.verifyPaymentInformation(type, cardNumber, expMonth, expYear);
	}
	public void verifyProductColorUpdated() {
		pbOSP.verifyUpdatedProductColor();
	}
	public void verifyProductQuantityUpdated() {
		pbOSP.verifyUpdatedProductQuanity();
	}
	public void verifyOrderCancellation() {

		pbHP.clickOffPopUp();
		if(Serenity.sessionVariableCalled("brand").toString().toLowerCase().equals("ckus"))
		{
			pbOSP.verifyCancellation();	
		}

	}
	public void navigateToMyOrders() {

		pbHP.pageRefresh();
		pbHD.goToMyAccount();
		pbASP.navigateToMyOrders();
	}

	public void navigateToMyOrdersOnMobile() {


		pbHP.clickOffPopUp();
		pbHP.clickMenuButtonMobile();
		pbHD.goToMobileMyAccount();
		pbASP.navigateToMyOrders();
	}

	public void verifyOrderPending(String status) {

		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		pbMOP.checkItemStatus(orderNumber, status);
	}
	public void guestUserGetOrderStatus(String email) {

		pbMOP.clickGuestOrderStatus();
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		pbMOP.enterOrderInfoAndCont(orderNumber, email);
	}

	public void guestUserGetOrderStatusCKCA() {
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		pbHP.clickHomePageButton();
		pbMOP.clickGuestOrderStatus();
		pbMOP.enterTrackingNumberAndSubmitCKCA( orderNumber);
	}

	public void guestUserVerifyStatus(String status) {

		pbHP.clickOffPopUp();
		String orderNumber = Serenity.sessionVariableCalled("orderNumber");
		LOGGER.info("Inputting an order number of:"+ orderNumber);
		pbMOP.verifyOrderStatus(orderNumber, status);
	}
	public void verifyAllHeaderCategoryLinks(String dept, String links) {

		pbHP.verifyAllHeaderCategoryLinks(dept, links);
	}
	public void verifyFooter(String names) {

		pbFT.verifyFooterNamesExists(names);

	}
	public void verifyDeptBreadCrumbLinks(String dept, String links) {

		pbHP.verifyAllDeptBreadCrumbLinks(dept, links);

	}
	public void verifyCatPageGoToItemPage(String dept, String links) {

		pbHP.verifyAllCatPageGoToItemPage(dept, links);

	}
	public void verifyBagLink() {

		pbHP.clickCartSimple();
		pbCP.verifyOnCartPage();
	}

	public void clickSubmitOrder() {
		pbROP.clickSubmitOrder();
	}
	public void editOrderFromOrderSummary() {
		pbHP.clickOffPopUp();
		pbOSP.editOrder();
	}
	public void enterNewLetterAndSubmit() {
		pbHP.clickOffPopUp();
		pbHD.clickGoToAccountOnPage();
		String email = Serenity.sessionVariableCalled("email");
		pbASP.enterNewLetterAndSubmit(email);
	}
	public void enterInvalidEmailInNewsLetterAndSubmit() {
		pbHP.clickOffPopUp();
		pbHD.clickGoToAccountOnPage();
		String email = Serenity.sessionVariableCalled("email");
		String[] arr = email.split("@");
		pbASP.enterNewLetterAndSubmit(arr[0]);
	}
	public void enterNoNewsLetterAndSubmit() {
		pbHP.clickOffPopUp();
		pbHD.clickGoToAccountOnPage();
	}

	public void verifyNoEmailNewsLetterSignUpOnAccount(String error) {
		pbASP.verifyNoEmailNewsLetterSignUpOnAccount(error);
	}
	public void verifyEmailNewsLetterSignUpOnAccount() {
		pbASP.verifyEmailNewsLetterSignUpOnAccount();
	}
	public void verifyFooterLinksGoToCorrespondingPage(String category) {
		pbFT.checkFooterLinkGoesToCorrespondingPage(category);
	}

	public void setOrderNumber() {
		pbHP.clickOffPopUp();
		pbOSP.saveOrderNumber();
	}
	public void setOrderNumberCKCA() {
		pbOSP.saveOrderNumberCKCA();
	}


	/**
	 * Step to navigate to Store Location page
	 */

	public void navigateToStoreLocator() {
		pbHP.clickStoreLocator();
		pbSL.switchFocusToStoreLocator();
	}

	/**
	 * Step to verify default location on store locator
	 * @param location - location e.g. Sufferen NY 10901
	 */

	public void verifyDefaultStoreLocation(String location) {
		pbSL.verifySearchLocation(location);
	}

	/**
	 * Step to search store near provided search location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	public void searchStoreNearLocation(String location) {
		pbSL.searchStoreNear(location);
	}

	/**
	 * Step to verify no result found error message on store locator
	 * @param message - No Result Error Message
	 */
	public void verifyErrorMessage(String message) {
		pbSL.verifyNoResultError(message);

	}

	/**
	 * Step to verify valid store result are displayed for provided location
	 * @param location - search location e.g.: Edison, New Jersey
	 */
	public void verifyStoreLocatorResult(String location) {
		pbSL.verifyStoreLocatorResult(location);
	}
	public void verifyQuantityPageLevelMessage() {

		assertThat(pbIP.getPageLevelMessage().contentEquals("The quantity you selected exceeds the quantity available. We have adjusted the number of items in your shopping bag."));
	}
	public void verifySignInLink() {

		pbHP.clickSignInRegister();
		pbSIP.verifyOnSignInPage();
	}
	public void adjustQuantityAddToBag(int quant) {

		pbIP.adjustQuantityAddToBag(quant);
	}
	public void verifyErrorMessage() {

		pbCPP.verifyErrorMessage();
	}
	public void verifyCardErrorMessage() {

		pbCPP.verifyCardErrorMessage();
	}
	public void verifyEmptyErrorMessage() {

		pbCPP.verifyEmptyErrorMessage();
	}


	public void goToPaypalPayment() {
		pbCOP.payWithPayPal();
		pbROP.clickProceedToPaypal();
	}

	public void verifyEmptyWishlist() {
		pbWLP.verifyNoWishlistItems();
	}
	public void shareWishlist() {
		pbWLP.shareWishlist();
	}
	public void enterShareWishlistDetails(String toEmail, String name, String fromEmail, String message) {
		pbWLP.enterWishlistFields(toEmail, name, fromEmail, message);
	}
	public void verifyWishlistDetailsNotProvided() {
		pbWLP.verifyNoDetailsError();
	}
	public void verifyWishlistShared() {
		pbWLP.verifySharedWishlistPB();
	}
	public void verifyExistingOrders() {
		pbMOP.verifyExistingOrders();
	}

	public void clickRewardsTabOnAccountPage() {
		pbASP.clickSideTabRewards();
	}

	public void verifyPageLevelErrorOnEditAccount(String error) {
		pbPIP.verifyPageLevelError(error);
	}

	public void verifyNoRewardAvailable() {
		pbASP.verifyRewardAmount("0");
	}

	public void verifyFieldLevelErrorOnEditAccount(String error) {
		pbPIP.verifyFieldLevelError(error);
	}

	/**
	 * Step to select provided department on search result page
	 * @param department - Department e.g.: Men / Women / Kids / Home
	 */

	public void selectDepartment(String department) {
		pbSRP.selectDepartmentFromLeftNavigationBar(department);
	}

	public void selectDepartmentOnMobile(String department) {
		pbSRP.selectDepartmentOnMobileFromTopNavigationBar(department);
	}

	/**
	 * Step to verify if provided option is displayed on search result page
	 * @param option - Option e.g.: filter / sort
	 */

	public void verifyOptionIsDisplayed(String option) {
		pbSRP.verifyOption(option);		
	}

	public void verifyOptionIsDisplayedOnMobile(String option) {
		pbSRP.verifyOptionOnMobile(option);		
	}

	/**
	 * Step to filter search result using provided price range
	 * @param price - Price Range e.g.: $0 - $25
	 */

	public void filterSearchResultUsingPriceRange(String price) {
		pbSRP.filterSearchResultUsingPriceRange(price);
	}


	/**
	 * Step to verify CKUS filtered product list price is within provided price range
	 * @param priceRange - Price Range e.g.: $0 - $25
	 */

	public void verifyPriceOfProductsInFilteredList(String priceRange) {
		pbSRP.verifyFilteredProductPrice(priceRange);
	}


	/**
	 * Step to filter CKUS search product list using provided color
	 * @param color - Color e.g.: black / blue / red
	 */

	public void filterSearchResultUsingColor(String color) {
		pbSRP.filterSearchResultUsingColor(color);

	}

	public void filterSearchResultOnMobileUsingColor(String color) {
		pbSRP.filterSearchResultOnMobileUsingColor(color);

	}


	/**
	 * Step to verify searched product list is filtered using provided option
	 * @param option - Option e.g.: black / blue / 
	 */

	public void verifyProductsListIsFiltered(String option) {
		pbSRP.verifyProductListIsFilteredUsing(option);

	}



	public void verifyMobileProductsListIsFiltered(String option) {
		pbSRP.verifyMobileProductListIsFilteredUsing(option);

	}
	/**
	 * Step to filter CKUS search product list using provided size
	 * @param size - Size e.g.: s / m / xl / 4xl
	 */

	public void filterSearchResultUsingSize(String size) {
		pbSRP.filterSearchResultUsingSize(size);

	}

	public void filterMobileSearchResultUsingSize(String size) {
		pbSRP.filterSearchResultOnMobileUsingSize(size);

	}



	/**
	 * Step to filter CKUS search product list using provided category
	 * @param size - Size e.g.: BIG + TALL / BODY / BODY MODAL / MODERN MODAL
	 */

	public void filterSearchResultUsingCategory(String category) {
		pbSRP.filterSearchResultUsingCategory(category);

	}


	/**
	 * Step to sort CKUS search product list using provided price option
	 * @param price - Price e.g.: Low to High / High to Low
	 */
	public void sortSearchResultUsingPrice(String price) {
		pbSRP.sortSearchResultUsingPrice(price);

	}


	public void sortSearchResultOnMobileUsingPrice(String price) {
		pbSRP.sortSearchResultOnMobileUsingPrice(price);

	}
	/**
	 * Step to verify if product list is sorted based on provided price option
	 * @param priceRange - Price e.g.: Low to High / High to Low
	 */
	public void verifySortedProductList(String priceRange) {
		pbSRP.verifyProductListIsSorted(priceRange);

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
	/*	public void placeOrder(int totalOrderCount, String styleNumber, String address, String ccType, String ccNumber,
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

	 */
	/**
	 * Step to clear items in wish list
	 */
	public void clearWishlist() {
		//pbHD.goToMyWishlist();
		pbWLP.removeFromWishlist();		
	}


	public void clearMobileWishlist() {
		pbHP.clickOffPopUp();
		pbHP.clickMenuButtonMobile();
		pbHD.goToMyMobileWishlist();
		//pbWLP.removeFromWishlist();
		pbWLP.removeFromMobileWishlist();		
	}
	/**
	 * Steps to clear items from cart
	 */
	public void clearCart() {
		pbCP.removeFirstItem();

	}

	public boolean isSignedIn() {
		return pbHP.isUserSignedIn();
	}

}
