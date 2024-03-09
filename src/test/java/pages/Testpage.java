package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import library.Locators;

public class Testpage {
	  @FindBy(css = "h2[class='title text-center'] b")
	    private WebElement testCases;

	    private WebDriver driver;

	    public Testpage(WebDriver driver) {
	        PageFactory.initElements(driver, this);
	        this.driver = driver;
	    }

	    public WebElement getTestCases() {
	        Locators.waitForElementToBeVisible(driver, testCases);
	        return testCases;
	    }


}

