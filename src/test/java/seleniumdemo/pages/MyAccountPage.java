package seleniumdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumdemo.utils.SeleniumHelper;

public class MyAccountPage {


    @FindBy(id = "reg_email")
    private WebElement regEmailInput;

    @FindBy(id = "reg_password")
    private WebElement regPasswordInput;

    @FindBy(name = "register")
    private WebElement registerButton;

    @FindBy(xpath = "//ul[@class='woocommerce-error']//li")
    private WebElement error;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(name = "login")
    private WebElement loginButton;

    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }


    public RegisterUserPage registerUserValidData(String email, String password) {
        registerUser(email, password);
        SeleniumHelper.waitForClickable(registerButton, driver);
        /*
        try {
            driver.findElement(By.name("register")).click();
        } catch (Exception e) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", driver.findElement(By.name("register")));
            executor.executeScript("arguments[0].click();", driver.findElement(By.name("register")));
        }

         */
        registerButton.click();
//        registerButton.click();
        return new RegisterUserPage(driver);
    }

    public MyAccountPage registerUserInvalidData(String email, String password) {
        registerUser(email, password);
        registerButton.click();
        return this;
    }

    public LoggedUserPage loginValidData(String username, String password) {
        login(username, password);
        return new LoggedUserPage(driver);
    }

    public MyAccountPage loginInvalidData(String username, String password) {
        login(username, password);
        return this;
    }

    private void login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void registerUser(String email, String password) {
        regEmailInput.sendKeys(email);
        regPasswordInput.sendKeys(password);
    }

    public String getError() {
        SeleniumHelper.waitForElementToBeVisible(driver, error);
        return error.getText();
    }

    public MyAccountPage isButtonAvailable() {
        registerButton.click();
        return this;
    }
}
