package seleniumdemo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumdemo.utils.SeleniumHelper;

public class ProductPage {

    @FindBy(name = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']//a[text()='View cart']")
    private WebElement viewCartButton;

    @FindBy(xpath = "//input[@class='input-text qty text']")
    private WebElement quantityInput;

    public WebDriver driver;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductPage addProductToCart(){
        SeleniumHelper.waitForClickable(addToCartButton, driver);
        addToCartButton.click();
        return this;
    }

    public CartPage viewCart() {
        SeleniumHelper.waitForClickable(viewCartButton, driver);
        viewCartButton.click();
        return new CartPage(driver);
    }

    public ProductPage addProductByEnterValue(String value){
        quantityInput.clear();
        quantityInput.sendKeys(value);
        quantityInput.sendKeys(Keys.ENTER);
        return this;
    }
}
