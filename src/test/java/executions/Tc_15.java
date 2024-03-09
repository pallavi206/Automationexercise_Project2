package executions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import library.Utilities;
import pages.Cart;

public class Tc_15 extends TestBase {
	  String name = "name" + Utilities.generateCurrentDateAndTime();
	    String email = "email" + Utilities.generateCurrentDateAndTime() + "@o2.pl";

	    @Test
	    public  void Checkout() throws IOException, ParseException {
	        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
	        Tc_14.verifyAccountCreationAndClickContinueButton(name, email);
	        Tc_14.verifyLoggedInAsUsernameAtTop(name);
	        Tc_14.verifyThatCartPageIsDisplayed();
	        new Cart(getDriver()).proceedToCheckoutButtonClick();
	        Tc_14.verifyAddressDetailsAndReviewYourOrder();
	        Tc_14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
	        Tc_1.verifyThatAccountDeletedIsVisibleAndClickContinueButton();
	    }


}
