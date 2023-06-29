package pl.seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.seleniumdemo.pages.HomePage;

public class LoginTest extends BaseTest {

    int random = (int) (Math.random() * 1000);

    @Test
    public void loginTest() {
        WebElement dashBoardLink = new HomePage(driver).openMyAccountPage()
                .loginValidData("testowy1@testowy.pl", "TestowyHaslo123@")
                .getDashBoardLink();

        Assert.assertEquals(dashBoardLink.getText(), "Dashboard");
    }

    @Test
    public void loginWithInvalidPassword() {
        WebElement error = new HomePage(driver).openMyAccountPage()
                .loginInvalidData("testowy@testowy.pl", "TestowHaslo123@")
                .getError();

        Assert.assertEquals(error.getText(), "ERROR: Incorrect username or password.");
    }

}
