package executions;

import org.junit.Test;
import org.testng.Assert;

import pages.Cart;

public class Tc_17 extends TestBase {
	  @Test
	    public void removeProductsFromCart() {
	        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
	        Tc_14.verifyThatCartPageIsDisplayed();
	        verifyThatProductIsRemovedFromTheCart();
	    }

	   	    private void verifyThatProductIsRemovedFromTheCart() {
	        String emptyCartText = new Cart(getDriver())
	                .xButtonClick()
	                .getEmptyCartSpan()
	                .getText();
	        Assert.assertEquals(emptyCartText, "Cart is empty! Click here to buy products.", "Verify that product is removed from the cart");
	    }


}
