package executions;

import org.junit.Test;
import org.testng.Assert;

import pages.HomePage;

public class Tc_7 extends TestBase {
	  @Test
	    public void verifyTestCasesPage() {
	        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToTestCasesPageSuccessfully();
	    }

	   	    private void verifyUserIsNavigatedToTestCasesPageSuccessfully() {
	        String testCasesText = new HomePage(getDriver())
	                .testCasesButtonClick()
	                .getTestCases()
	                .getText();
	        Assert.assertEquals(testCasesText, "TEST CASES", "Verify user is navigated to test cases page successfully");
	    }


}
