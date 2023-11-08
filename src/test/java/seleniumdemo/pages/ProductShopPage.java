package seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumdemo.utils.SeleniumHelper;

import java.util.List;

public class ProductShopPage {

    @FindBy(xpath = "//a[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
    private List<WebElement> addToCart;

    @FindBy(xpath = "//a[@class='woocart cart-contents']")
    private WebElement cart;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    private WebElement viewCart;

    @FindBy(xpath = "//a[@class='czr-title']")
    private WebElement product;

    public WebDriver driver;

    public ProductShopPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public ProductPage openProduct(String title){
        driver.findElement(By.xpath("//h2[text()='" + title + "']")).click();
        return new ProductPage(driver);
    }

    public ProductShopPage addToCartProduct() throws InterruptedException {
        addToCart.get(2).click();
        Thread.sleep(3000);
        return this;

    }

    public CartPage checkCart() throws InterruptedException {
        cart.click();
        SeleniumHelper.waitForClickable(viewCart, driver);
        viewCart.click();
        Thread.sleep(3000);
        return new CartPage(driver);

    }

    public ProductPage confirmProduct() throws InterruptedException {
        product.click();
        Thread.sleep(5000);
        return new ProductPage(driver);
    }


}
