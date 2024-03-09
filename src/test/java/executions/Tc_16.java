package executions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.testng.Assert;

import library.JSONReader;
import pages.Cart;
import pages.HomePage;
import pages.LoggedHomePage;

public class Tc_16 extends TestBase {
    @Test
    public void placeOrderLoginBeforeCheckout() throws IOException, ParseException {
        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
        new HomePage(getDriver()).signupLoginClick().fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
        verifyLoggedInAsUsernameAtTop();
        Tc_14.verifyThatCartPageIsDisplayed();
        new Cart(getDriver()).proceedToCheckoutButtonClick();
        Tc_14.verifyAddressDetailsAndReviewYourOrder();
        Tc_14.verifySuccessMessageCongratulationsYourOrderHasBeenConfirmed();
    }

    private void verifyLoggedInAsUsernameAtTop() throws IOException, ParseException {
        String username = new LoggedHomePage()
                .getUsername()
                .getText();
        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify 'Logged in as username' at top");
    }


}
