package executions;

import java.io.IOException;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.testng.Assert;

import library.JSONReader;
import library.Utilities;
import pages.AccountCreation;
import pages.Cart;
import pages.CheckOut;
import pages.HomePage;
import pages.LoggedHomePage;
import pages.Items;

public class Tc_14 extends TestBase {
	   String name = "name" + Utilities.generateCurrentDateAndTime();
	    String email = "email" + Utilities.generateCurrentDateAndTime() + "@o2.pl";

	    @Test
	    public void Checkout() throws IOException, ParseException {
	        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyThatCartPageIsDisplayed();
	        verifyAccountCreationAndClickContinueButton(name, email);
	        verifyLoggedInAsUsernameAtTop(name);
	        verifyAddressDetailsAndReviewYourOrder();
	        verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        Tc_1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }

	   	    static void verifyAccountCreationAndClickContinueButton(String name2, String email2) {
			
			
		}

			public static void verifyThatCartPageIsDisplayed() {
	        String shoppingCartText = new Items(getDriver()).addProductsToCart().getShoppingCart().getText();
	        Assert.assertEquals(shoppingCartText, "Shopping Cart", "Verify that cart page is displayed");
	    }

	   	    public static void verifyAccountCreatedAndClickContinueButton(String name, String email) throws IOException, ParseException, java.text.ParseException {
	        String accountCreatedText = new HomePage(getDriver()).signupLoginClick().fillCorrectSignup(name, email).fillAccountDetails().getAccountCreated().getText();
	        Assert.assertEquals(accountCreatedText, "ACCOUNT CREATED!", "Verify 'ACCOUNT CREATED!'");
	        new AccountCreation(getDriver()).continueButtonClick();
	    }

	   	    public static void verifyLoggedInAsUsernameAtTop(String name) {
	        String username = new LoggedHomePage()
	                .getUsername()
	                .getText();
	        Assert.assertEquals(username, name, "Verify ' Logged in as username' at top");
	    }

	  	    public static void verifyAddressDetailsAndReviewYourOrder() throws IOException, ParseException {
	        verifyAddressDetails();

	        List<String> productNames = new Cart(getDriver()).getProductsNames();
	        List<String> prices = new Cart(getDriver()).getPrices();
	        List<String> quantity = new Cart(getDriver()).getQuantity();
	        List<String> totalPrices = new Cart(getDriver()).getTotalPrices();
	        String totalAmount = new CheckOut(getDriver()).getTotalAmount().getText();

	        for (int i = 0; i < 2; i++) {
	            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify Review Your Order");
	            Assert.assertEquals(quantity.get(i), "1", "Verify Review Your Order");
	        }

	        Assert.assertEquals(productNames.get(0), "Blue Top", "Verify Review Your Order");
	        Assert.assertEquals(productNames.get(1), "Men Tshirt", "Verify Review Your Order");
	        Assert.assertEquals(totalAmount, "Rs. 800", "Verify Review Your Order");
	    }

	    public static void verifyAddressDetails() throws IOException, ParseException {
	        List<String> addressDelivery = new HomePage(getDriver())
	                .cartButtonClick()
	                .proceedToCheckoutLoggedButtonClick()
	                .getAddressDelivery();
	        List<String> addressInvoice = new CheckOut(getDriver()).getAddressInvoice();

	        Assert.assertEquals(addressDelivery.get(0), "YOUR DELIVERY ADDRESS", "Verify Address Details");
	        Assert.assertEquals(addressInvoice.get(0), "YOUR BILLING ADDRESS", "Verify Address Details");

	        for (int i = 1; i < 8; i++) {
	            Assert.assertEquals(addressDelivery.get(i), addressInvoice.get(i), "Verify Address Details");
	        }

	        String no1 = "Mr. " + JSONReader.accountDetails("firstName") + " " + JSONReader.accountDetails("lastName");
	        String no2 = JSONReader.accountDetails("company");
	        String no3 = JSONReader.accountDetails("address1");
	        String no4 = JSONReader.accountDetails("address2");
	        String no5 = JSONReader.accountDetails("city") + " " + JSONReader.accountDetails("state") + " " + JSONReader.accountDetails("zipcode");
	        String no6 = JSONReader.accountDetails("country");
	        String no7 = JSONReader.accountDetails("mobileNumber");

	        Assert.assertEquals(addressDelivery.get(1), no1, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(2), no2, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(3), no3, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(4), no4, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(5), no5, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(6), no6, "Verify Address Details");
	        Assert.assertEquals(addressDelivery.get(7), no7, "Verify Address Details");
	    }

	    	    public static void verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed() throws IOException, ParseException {
	        String alertSuccessText = new CheckOut(getDriver()).enterComment("Sed fringilla aliquet turpis, ut vestibulum orci vulputate sit amet.")
	         .fillPaymentDetails().getSuccessMessage().getText();
	        Assert.assertEquals(alertSuccessText, "Congratulations! Your order has been confirmed!", "Verify success message 'Congratulations! Your order has been confirmed!'");
	    }


}
