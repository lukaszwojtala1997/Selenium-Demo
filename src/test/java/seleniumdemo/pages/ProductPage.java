package seleniumdemo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumdemo.utils.SeleniumHelper;

public class ProductPage {

    @FindBy(css = "[class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
    private WebElement addToCartButton;

    @FindBy(css = "[class='single_add_to_cart_button button alt']")
    private WebElement addToCart2Button;

    @FindBy(css = "[class='added_to_cart wc-forward']")
    private WebElement viewCartButton;

    @FindBy(css = "[class='woocart cart-contents']")
    private WebElement viewCart2Button;

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

    public ProductPage addProductToCart2(){
        SeleniumHelper.waitForClickable(addToCart2Button, driver);
        addToCart2Button.click();
        return this;
    }

    public CartPage viewCart() {
        SeleniumHelper.waitForClickable(viewCart2Button, driver);
        viewCart2Button.click();
        viewCart2Button.click();
        return new CartPage(driver);
    }

    public ProductPage addProductByEnterValue(String value){
        quantityInput.clear();
        quantityInput.sendKeys(value);
        quantityInput.sendKeys(Keys.ENTER);
        return this;
    }
}
