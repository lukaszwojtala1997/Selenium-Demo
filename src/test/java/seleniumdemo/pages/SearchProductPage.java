package seleniumdemo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumdemo.utils.SeleniumHelper;

public class SearchProductPage {

    @FindBy(name = "s")
    private WebElement searchProductInput;

    public WebDriver driver;

    public SearchProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductShopPage enterProductName() {
        SeleniumHelper.waitForElementToBeVisible(searchProductInput, driver);
        searchProductInput.sendKeys("Java");
        searchProductInput.sendKeys(Keys.ENTER);
        return new ProductShopPage(driver);
    }






}
