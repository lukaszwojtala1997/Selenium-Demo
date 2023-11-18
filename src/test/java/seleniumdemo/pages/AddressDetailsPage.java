package seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import seleniumdemo.models.Customer;
import seleniumdemo.utils.SeleniumHelper;

public class AddressDetailsPage {

    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;


    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement companyNameInput;


    @FindBy(id = "billing_country")
    private WebElement billingCountrySelect;


    @FindBy(id = "billing_address_1")
    private WebElement billingAddressInput;


    @FindBy(id = "billing_address_2")
    private WebElement billingAddressSecondInput;


    @FindBy(id = "billing_postcode")
    private WebElement billingPostCodeInput;


    @FindBy(id = "billing_city")
    private WebElement billingCityInput;

    @FindBy(id = "billing_phone")
    private WebElement billingPhoneInput;

    @FindBy(id = "billing_email")
    private WebElement billingEmailInput;

    @FindBy(id = "order_comments")
    private WebElement orderCommentsInput;

    @FindBy(xpath = "//button[@class='button alt']")
    private WebElement placeOrderButton;

    public WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }


    public OrderDetailsPage fillAddressDetails(Customer customer) {
        SeleniumHelper.waitForElementToBeVisible(firstNameInput, driver);
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyNameInput.sendKeys(customer.getCompanyName());
        Select countrySelect = new Select(billingCountrySelect);
        countrySelect.selectByVisibleText(customer.getCountry());
        billingAddressInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        billingPostCodeInput.sendKeys(customer.getZipCode());
        billingCityInput.sendKeys(customer.getCity());
        billingPhoneInput.sendKeys(customer.getPhone());
        billingEmailInput.sendKeys(customer.getEmail());
        try {
            driver.findElement(By.id("place_order")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.id("place_order")));
        }

        return new OrderDetailsPage(driver);
    }
}
