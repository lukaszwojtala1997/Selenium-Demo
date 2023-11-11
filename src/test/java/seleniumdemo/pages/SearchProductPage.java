package seleniumdemo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumdemo.utils.SeleniumHelper;

public class SearchProductPage {

    @FindBy(xpath = "//input[@id='s-654c7aa3500f3']")
    private WebElement searchProductInput;

    public WebDriver driver;

    public SearchProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductShopPage enterProductName() {
        SeleniumHelper.waitForElementToBeVisible(driver, searchProductInput);
        searchProductInput.sendKeys("Java");
        searchProductInput.sendKeys(Keys.ENTER);
        return new ProductShopPage(driver);
    }






}
