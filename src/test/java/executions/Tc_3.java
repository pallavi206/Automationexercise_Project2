package executions;

import org.junit.Test;

import org.testng.Assert;

import library.Utilities;
import pages.SignUpPage;
import pages.SignUpPage;

public class Tc_3 extends TestBase {
	   @Test
	    public void loginUserWithIncorrectEmailAndPassword() {
	        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
	        Tc_2.verifyLoginToYourAccountIsVisible();
	        verifyErrorYourEmailOrPasswordIsIncorrectIsVisible();
	    }

	   	    private void verifyErrorYourEmailOrPasswordIsIncorrectIsVisible() {
	        String email = "email" + Utilities.generateCurrentDateAndTime() + "@incorrect.pl";
	        String password = "pass" + Utilities.generateCurrentDateAndTime();

	        String errorLoginText = new SignUpPage(getDriver())
	                .fillIncorrectLogin(email, password)
	                .getErrorLogin()
	                .getText();
	        Assert.assertEquals(errorLoginText, "Your email or password is incorrect!", "Verify error 'Your email or password is incorrect!' is visible");
	    }

}
