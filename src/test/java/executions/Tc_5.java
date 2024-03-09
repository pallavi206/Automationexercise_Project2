package executions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.testng.Assert;

import pages.SignUpPage;
import pages.SignUpPage;

public class Tc_5 extends TestBase {
    @Test
    public void registerUserWithExistingEmail() throws IOException, ParseException {
        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
        Tc_1.verifyNewUserSignupIsVisible();
        verifyErrorEmailAddressAlreadyExistIsVisible();
    }

       private void verifyErrorEmailAddressAlreadyExistIsVisible() throws IOException, ParseException {
        String emailAddressAlreadyExistText = new SignUpPage(getDriver()).fillIncorrectSignup().getEmailAddressAlreadyExist().getText();
        Assert.assertEquals(emailAddressAlreadyExistText, "Email Address already exist!", "Verify error 'Email Address already exist!' is visible");
    }


}
