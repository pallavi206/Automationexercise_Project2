package executions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.testng.Assert;

import pages.LoggedHomePage;

public class Tc_4 extends TestBase {

    @Test
    public void logoutUser() throws IOException, ParseException {
        Tc_2.loginUserWithCorrectEmailAndPassword();
        verifyThatUserIsNavigatedToLoginPage();
    }

      private void verifyThatUserIsNavigatedToLoginPage() {
        String loginToYourAccountText = new LoggedHomePage()
                .logoutButtonClick()
                .getLoginToYourAccount()
                .getText();
        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify that user is navigated to login page");
    }

}
