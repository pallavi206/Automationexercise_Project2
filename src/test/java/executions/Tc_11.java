package executions;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Test;

import pages.HomePage;

public class Tc_11 extends TestBase {
    @Test
    public void verifySubscriptionInCartPage() throws IOException, ParseException {
        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
        new HomePage(getDriver()).cartButtonClick();
        Tc_10.verifyTextSubscription();
        Tc_10.verifySuccessMessageYouHaveBeenSuccessfullySubscribedIsVisible();
    }
}


