package executions;

import org.junit.Test;
import org.testng.Assert;

import pages.HomePage;
import pages.Items;
import pages.ItemsDetails;

public class Tc_8 extends TestBase {
	 @Test
	    public void verifyAllProductsAndProductDetailPage() {
	        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
	        verifyUserIsNavigatedToAllProductsPageSuccessfully();
	        new Items(getDriver()).viewProductOfFirstProductButtonClick();
	        verifyThatDetailDetailIsVisible();
	    }

	   	    public static void verifyUserIsNavigatedToAllProductsPageSuccessfully() {
	        String allProductsText = new HomePage(getDriver()).productsButtonClick().getTitleTextCenter().getText();
	        Assert.assertEquals(allProductsText, "ALL PRODUCTS", "Verify user is navigated to ALL PRODUCTS page successfully");
	    }

	        private void verifyThatDetailDetailIsVisible() {
	        boolean name = new ItemsDetails(getDriver()).getProductName().isDisplayed();
	        boolean category = new ItemsDetails(getDriver()).getProductCategory().isDisplayed();
	        boolean price = new ItemsDetails(getDriver()).getProductPrice().isDisplayed();
	        boolean availability = new ItemsDetails(getDriver()).getProductAvailability().isDisplayed();
	        boolean condition = new ItemsDetails(getDriver()).getProductCondition().isDisplayed();
	        boolean brand = new ItemsDetails(getDriver()).getProductBrand().isDisplayed();

	        Assert.assertTrue(name, "Verify that detail detail is visible: name");
	        Assert.assertTrue(category, "Verify that detail detail is visible: category");
	        Assert.assertTrue(price, "Verify that detail detail is visible: price");
	        Assert.assertTrue(availability, "Verify that detail detail is visible: availability");
	        Assert.assertTrue(condition, "Verify that detail detail is visible: condition");
	        Assert.assertTrue(brand, "Verify that detail detail is visible: brand");
	    }


}
