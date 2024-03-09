package executions;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import pages.ContactUs;
import pages.HomePage;

public class Tc_6 {
	@Test
    public void contactUsForm() {
        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
        verifyGetInTouchIsVisible();
        verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible();
        clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully();
    }

   	    private void verifyGetInTouchIsVisible() {
        String getGetInTouchText = new HomePage(getDriver())
                .contactUsButtonClick()
                .getGetInTouch()
                .getText();
        Assert.assertEquals(getGetInTouchText, "GET IN TOUCH", "Verify 'GET IN TOUCH' is visible");
    }

   	    private void verifySuccessMessageSuccessYourDetailsHaveBeenSubmittedSuccessfullyIsVisible() {
        String alertSuccessText = new ContactUs(getDriver())
                .fillForm()
                .submitButtonClick()
                .okButtonClick()
                .getAlertSuccess()
                .getText();
        Assert.assertEquals(alertSuccessText, "Success! Your details have been submitted successfully.", "Verify success message 'Success! Your details have been submitted successfully.' is visible");
    }

  	    private void clickHomeButtonAndVerifyThatLandedToHomePageSuccessfully() {
        boolean homePageVisible = new ContactUs(getDriver())
                .homePageButtonClick()
                .homePageIsVisible()
                .isDisplayed();
        Assert.assertTrue(homePageVisible, "Click 'Home' button and verify that landed to home page successfully");
    }

		private WebDriver getDriver() {
			return null;
		}


}
