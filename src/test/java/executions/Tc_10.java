package executions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.testng.Assert;

import pages.HomePage;

public class Tc_10 extends TestBase {

    @Test
    public void verifySubscriptionInHomePage() throws IOException, ParseException {
        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
        verifyTextSubscription();
        verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
    }

      public static void verifyTextSubscription() {
        String subscriptionText = new HomePage(getDriver())
                .getSubscription()
                .getText();
        Assert.assertEquals(subscriptionText, "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");
    }

        public static void verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible() throws IOException, ParseException {
        String messageAlert = new HomePage(getDriver()).fillSubscribe().getAlertSuccessSubscribe().getText();
        Assert.assertEquals(messageAlert, "You have been successfully subscribed!", "Verify success message 'You have been successfully subscribed!' is visible");
    }


}
