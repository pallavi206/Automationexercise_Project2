package pages;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import executions.TestBase;
import library.JSONReader;
import library.Locators;

public class HomePage {

    @FindBy(css = "div[class='item active'] img[alt='demo website for practice']")
    private WebElement girlImgResponsive;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLoginButton;

    @FindBy(css = "a[href='/contact_us']")
    private WebElement contactUsButton;

    @FindBy(css = "a[href='/test_cases']")
    private WebElement testCasesButton;

    @FindBy(css = "a[href='/products']")
    private WebElement productsButton;
    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartButton;

    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProduct1Button;

    @FindBy(id = "accordian")
    private WebElement categories;

    @FindBy(xpath = "//*[@id='accordian']/div[1]/div[1]/h4/a/span/i")
    private WebElement womenCategory;

    @FindBy(css = "a[href='/category_products/1']")
    private WebElement dressCategory;

    @FindBy(css = "div[class='recommended_items'] h2")
    private WebElement recommendedItems;

    @FindBy(css = "div[id='recommended-item-carousel'] a[class='btn btn-default add-to-cart']")
    private WebElement blueTopAddToCartButton;

    @FindBy(css = "div[class='modal-content'] a[href='/view_cart']")
    private WebElement viewCartButton;

    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;

    @FindBy(xpath = "//section[1]/div/div/div/div/div/div[1]/div[1]/h2")
    private WebElement fullFledgedPracticeWebsiteForAutomationEngineers;

    //footer
    @FindBy(css = "div[class='single-widget'] h2")
    private WebElement subscription;

    @FindBy(id = "susbscribe_email")
    private WebElement subscribeEmailInput;

    @FindBy(id = "subscribe")
    private WebElement subscribeButton;

    @FindBy(id = "success-subscribe")
    private WebElement alertSuccessSubscribe;


    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

   

	public WebElement homePageIsVisible() {
        return girlImgResponsive;
    }

    public SignUpPage signupLoginClick() {
        signupLoginButton.click();
        return new SignUpPage(driver);
    }

    public ContactUs contactUsButtonClick() {
        contactUsButton.click();
        return new ContactUs(driver);
    }

    public TestBase testCasesButtonClick() {
        testCasesButton.click();
        return new TestBase();
    }

    public Items productsButtonClick() {
        productsButton.click();
        return new Items(driver);
    }

    public Cart cartButtonClick() {
        cartButton.click();
        return new Cart(driver);
    }

    public Items viewProduct1ButtonClick() {
        Locators.waitForElementToBeClickable(driver, viewProduct1Button);
        viewProduct1Button.click();
        return new Items(driver);
    }

    public WebElement getCategories() {
        return categories;
    }

    public HomePage womenCategoryClick() {
        Locators.waitForElementToBeClickable(driver, womenCategory);
        womenCategory.click();
        return this;
    }

    public Items dressCategoryClick() {
        Locators.waitForElementToBeClickable(driver, dressCategory);
        dressCategory.click();
        return new Items(driver);
    }

    public WebElement getRecommendedItems() {
        return recommendedItems;
    }

    public HomePage blueTopAddToCartButtonClick() {
        Locators.waitForElementToBeClickable(driver, blueTopAddToCartButton);
        blueTopAddToCartButton.click();
        return this;
    }

    public Cart viewCartButtonClick() {
        Locators.waitForElementToBeVisible(driver, viewCartButton);
        viewCartButton.click();
        return new Cart(driver);
    }

    public HomePage scrollUpButtonClick() {
        scrollUpButton.click();
        return this;
    }

    public WebElement getFullFledgedPracticeWebsiteForAutomationEngineers() {
       Locators.waitForElementToBeVisible(driver, fullFledgedPracticeWebsiteForAutomationEngineers);
        return fullFledgedPracticeWebsiteForAutomationEngineers;
    }


    //footer
    public WebElement getSubscription() {
        return subscription;
    }

    public HomePage fillSubscribe() throws IOException, ParseException{
        subscribeEmailInput.sendKeys(JSONReader.existingUser("email"));
        Locators.waitForElementToBeClickable(driver, subscribeButton);
        subscribeButton.click();
        return this;
    }

    public WebElement getAlertSuccessSubscribe() {
        return alertSuccessSubscribe;
    }

	public Object deleteAccountButtonClick() {
				return null;
	}

	public String getText() {
		
		return null;
	}

}
