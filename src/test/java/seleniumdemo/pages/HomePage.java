package seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "//span[text()='My account']")
    private WebElement myAccountLink;

    @FindBy(xpath = "//span[text()='Shop']")
    private WebElement shopLink;

    @FindBy(xpath = "//a[@class='woocart cart-contents']")
    private WebElement cart;

    @FindBy(xpath = "//a[@class='search-toggle_btn icn-search czr-overlay-toggle_btn']")
    private WebElement searchButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public MyAccountPage openMyAccountPage() {
        myAccountLink.click();
        return new MyAccountPage(driver);
    }

    public ProductShopPage openShopPage() {
        shopLink.click();
        return new ProductShopPage(driver);
    }

    public CartPage cartPage() {
        cart.click();
        cart.click();
        return new CartPage(driver);
    }

    public SearchProductPage searchProduct(){
        searchButton.click();
        return new SearchProductPage(driver);
    }




}
