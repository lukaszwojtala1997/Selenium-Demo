package seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import seleniumdemo.utils.SeleniumHelper;

import java.time.Duration;
import java.util.List;

public class ProductShopPage {

    @FindBy(css = "[class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
    private List<WebElement> addToCart;

    @FindBy(css = "[class='woocart cart-contents']")
    private WebElement cart;

    @FindBy(css = "[class='button wc-forward']")
    private WebElement viewCart;

    @FindBy(css = "[class='czr-title']")
    private WebElement product;

    @FindBy(css = "[class='woocommerce-loop-product__title']")
    private WebElement productNameButton;

    public WebDriver driver;

    public ProductShopPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public ProductPage openProduct(){
        productNameButton.click();
        return new ProductPage(driver);
    }

    public ProductShopPage addToCartProduct() {
        addToCart.get(2).click();
        return this;

    }

    public CartPage checkCart(){
        SeleniumHelper.waitForClickable(cart, driver);
        cart.click();
        SeleniumHelper.waitForClickable(viewCart, driver);
        viewCart.click();
        return new CartPage(driver);

    }

    public ProductPage confirmProduct() {
        product.click();
        return new ProductPage(driver);
    }


}
