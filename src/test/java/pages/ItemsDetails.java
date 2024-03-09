package pages;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.JSONReader;
import library.Locators;

public class ItemsDetails {
	 @FindBy(css = "div[class='product-information'] h2")
	    private WebElement itemsName;

	    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[1]")
	    private WebElement itemsCategory;

	    @FindBy(css = "div[class='product-information'] span span")
	    private WebElement itemPrice;

	    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[2]")
	    private WebElement itemsAvailability;

	    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[3]")
	    private WebElement itemCondition;

	    @FindBy(xpath = "//section/div/div/div[2]/div[2]/div[2]/div/p[4]")
	    private WebElement itemBrand;

	    @FindBy(id = "quantity")
	    private WebElement quantityInput;

	    @FindBy(css = "button[class='btn btn-default cart']")
	    private WebElement addToCartButton;

	    @FindBy(css = "a[href='/view_cart'] u")
	    private WebElement viewCartButton;

	    @FindBy(css = "a[href='#reviews']")
	    private WebElement writeYourReview;

	    @FindBy(id = "name")
	    private WebElement yourNameInput;

	    @FindBy(id = "email")
	    private WebElement emailAddress;

	    @FindBy(id = "review")
	    private WebElement addReviewHere;

	    @FindBy(id = "button-review")
	    private WebElement submitButton;

	    @FindBy(css = "div[class='alert-success alert'] span")
	    private WebElement successMessage;

	    private WebDriver driver;

	    public ItemsDetails(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getProductName() {
	        return itemsName;
	    }

	    public WebElement getProductCategory() {
	        return itemsCategory;
	    }

	    public WebElement getProductPrice() {
	        return itemPrice;
	    }

	    public WebElement getProductAvailability() {
	        return itemsAvailability;
	    }

	    public WebElement getProductCondition() {
	        return itemCondition;
	    }

	    public WebElement getProductBrand() {
	        return itemBrand;
	    }

	    public ItemsDetails increaseQuantity(String value) {
	        quantityInput.clear();
	        quantityInput.sendKeys(value);
	        return this;
	    }

	    public ItemsDetails addToCartButtonClick() {
	        addToCartButton.click();
	        return this;
	    }

	    public Cart viewCartButtonClick() {
	        Locators.waitForElementToBeClickable(driver, viewCartButton);
	        viewCartButton.click();
	        return new Cart(driver);
	    }

	    public WebElement getWriteYourReview() {
	        return writeYourReview;
	    }

	    public ItemsDetails fillReview() throws IOException, ParseException {
	        yourNameInput.sendKeys(JSONReader.existingUser("name"));
	        emailAddress.sendKeys(JSONReader.existingUser("email"));
	        addReviewHere.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
	                " Sed viverra, elit quis interdum feugiat, mi urna aliquam est, at venenatis quam odio et nisl." +
	                " In at massa sit amet dui hendrerit mattis ac sit amet erat.");
	        submitButton.click();
	        return this;
	    }

	    public WebElement getSuccessMessage() {
	        return successMessage;
	    }

}
