package seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumdemo.pages.HomePage;

public class LoginTest extends BaseTest {

    int random = (int) (Math.random() * 1000);

    @Test
    public void loginTest() {
        WebElement dashBoardLink = new HomePage(driver).openMyAccountPage()
                .loginValidData("testowy@testowy.pl", "TestowyHaslo123@")
                .getDashBoardLink();

        Assert.assertEquals(dashBoardLink.getText(), "Dashboard");
    }

    @Test(enabled = false)
    public void loginWithInvalidData() {
        WebElement error = new HomePage(driver).openMyAccountPage()
                .loginInvalidData("testowyemail@testowy.pl", "TestowHaslo123@")
                .getError();

        Assert.assertEquals(error.getText(), "ERROR: Incorrect username or password.");
    }

    @Test
    public void loginWithoutPassword() {
        WebElement error = new HomePage(driver).openMyAccountPage()
                .loginInvalidData("testowy@testowy.pl", "")
                .getError();

        Assert.assertEquals(error.getText(), "ERROR: The password field is empty.");
    }



}
