package executions;

import java.util.List;

import org.junit.Test;
import org.testng.Assert;

import pages.HomePage;
import pages.ItemsDetails;

public class Tc_13 extends TestBase{
	  @Test
	    public void verifyProductQuantityInCart() {
	        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyProductDetailIsOpened();
	        verifyThatProductIsDisplayedInCartPageWithExactQuantity();
	    }

	    	    private void verifyProductDetailIsOpened() {
	        new HomePage(getDriver()).viewProduct1ButtonClick();
	        Assert.assertEquals(getDriver().getTitle(), "Automation Exercise - Product Details", "Verify product detail is opened");
	    }

	   	    private void verifyThatProductIsDisplayedInCartPageWithExactQuantity() {
	        List<String> quantity = new ItemsDetails(getDriver()).increaseQuantity("4")
	                .addToCartButtonClick()
	                .viewCartButtonClick().getQuantity();
	        Assert.assertEquals(quantity.get(0), "4", "Verify that product is displayed in cart page with exact quantity");
	    }


}
