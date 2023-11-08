package seleniumdemo.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumdemo.utils.SeleniumHelper;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")
    private WebElement proccedToCheckoutButton;

    @FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']")
    private WebElement price;

    @FindBy(xpath = "//input[@class='input-text qty text']")
    private WebElement quantity;

    @FindBy(xpath = "//a[@class='navbar-brand-sitename  czr-underline']")
    private WebElement returnToHome;

    @FindBy(xpath = "//span[@class='woocommerce-Price-amount amount']")
    private List<WebElement> totalPrice;

    @FindBy(id = "menu-item-21")
    private WebElement shopLink;


    public WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public AddressDetailsPage openAddressDetails(){
        SeleniumHelper.waitForClickable(proccedToCheckoutButton, driver);
        proccedToCheckoutButton.click();
        return new AddressDetailsPage(driver);
    }

    public double quantity(){
        int quantityProduct = Integer.parseInt(quantity.getAttribute("value"));
        String priceCheck = price.getText();
        StringBuilder sb = new StringBuilder(priceCheck);
        sb.delete(sb.length()-2, sb.length());

        Double value = Double.valueOf(String.valueOf(sb.replace(1,2, ".")));
        double sum = value * quantityProduct;
        return sum;
    }

    public CartPage addQuantity(String value){
        quantity.clear();
        quantity.sendKeys(value);
        quantity.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage returnToHomePage(){
        returnToHome.click();
        return new HomePage(driver);
    }

/*
    public String getErrors() {

        String priceCheck = totalPrice.stream()
                .map(WebElement::getText)
                .filter(s -> s.length() >7)
                .sorted(Comparator.comparingInt(String::length))
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse("Price is null");
        return priceCheck;
    }

 */

    public String getErrors() {


        List<String> strings = new ArrayList<String>();
        for(WebElement e : totalPrice){
            strings.add(e.getText());
        }
        return strings.get(strings.size()-1);
    }


    public ProductShopPage clickShop(){
        shopLink.click();
        return new ProductShopPage(driver);
    }

}
