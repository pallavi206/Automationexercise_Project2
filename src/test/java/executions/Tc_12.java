package executions;

import java.util.List;

import org.junit.Test;
import org.testng.Assert;

import pages.Cart;
import pages.HomePage;

public class Tc_12 extends TestBase{
	@Test
    public void addProductsInCart() {
        Tc_1.verifyThatHomePageIsVisibleSuccessfully();
        verifyBothProductsAreAddedToCart();
        verifyTheirPricesQuantityAndTotalPrice();
    }

   	    private void verifyBothProductsAreAddedToCart() {
        List<String> productNames = new HomePage(getDriver())
                .productsButtonClick()
                .addProductsToCart()
                .getProductsNames();
        Assert.assertEquals(productNames.size(), 2, "Verify both products are added to Cart");
    }

   	    private void verifyTheirPricesQuantityAndTotalPrice() {
        List<String> prices = new Cart(getDriver()).getPrices();
        List<String> quantity = new Cart(getDriver()).getQuantity();
        List<String> totalPrices = new Cart(getDriver()).getTotalPrices();

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify their prices and total price");
            Assert.assertEquals(quantity.get(i), "1", "Verify their quantity");
            System.out.println(i + ". Prices = Total Prices | " + prices.get(i) + " = " + totalPrices.get(i));
            System.out.println(i + ". Quantity = 2 | " + quantity.get(i).equals("2"));
        }
    }


}
