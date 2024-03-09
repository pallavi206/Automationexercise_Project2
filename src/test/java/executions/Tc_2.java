package executions;

import java.io.IOException;


import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.testng.Assert;

import library.JSONReader;
import pages.HomePage;
import pages.SignUpPage;
import pages.SignUpPage;

public class Tc_2 extends TestBase {
	 @Test
	    public static void loginUserWithCorrectEmailAndPassword() throws IOException, ParseException {
	        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyLoginToYourAccountIsVisible();
	        verifyThatLoggedInAsUsernameIsVisible();
	    }

	   	    public static void verifyLoginToYourAccountIsVisible() {
	        String loginToYourAccountText = new HomePage(getDriver())
	                .signupLoginClick()
	                .getLoginToYourAccount()
	                .getText();
	        Assert.assertEquals(loginToYourAccountText, "Login to your account", "Verify 'Login to your account' is visible");
	    }

	   	    private static void verifyThatLoggedInAsUsernameIsVisible() throws IOException, ParseException {
	        HomePage username = new SignUpPage(getDriver()).fillCorrectLogin(JSONReader.existingUser("email"), JSONReader.existingUser("password"));
	        Assert.assertEquals(username, JSONReader.existingUser("name"), "Verify that 'Logged in as username' is visible");
	    }


}
