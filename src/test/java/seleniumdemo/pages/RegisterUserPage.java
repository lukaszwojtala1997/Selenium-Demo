package seleniumdemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumdemo.utils.SeleniumHelper;

public class RegisterUserPage {

    @FindBy(linkText = "Dashboard")
    private WebElement dashBoardLink;

    WebDriver driver;

    public RegisterUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getDashBoardLink() {
        SeleniumHelper.waitForElementToBeVisible(dashBoardLink, driver);
        return dashBoardLink.getText();
    }
}
