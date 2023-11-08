package seleniumdemo.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumdemo.pages.HomePage;

public class RegisterTest extends BaseTest {

    int random = (int) (Math.random() * 1000);

    @Test
    public void registerUserTest() {
        WebElement dashBoardLink = new HomePage(driver).openMyAccountPage()
                .registerUserValidData("testowy" + random + "@testowy.pl", "TestowyHaslo123@")
                .getDashBoardLink();

        Assert.assertEquals(dashBoardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData("testowy@testowy.pl", "TestowyHaslo123@")
                .getError();

        Assert.assertEquals(error.getText(), "Error: An account is already registered with your email address. Please log in.");
    }

    @Test
    public void registerUserWithoutPasswordTest() {
        int random = (int) (Math.random() * 1000);

        WebElement error = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData("testowy" + random + "@testowy.pl", "")
                .getError();

        Assert.assertEquals(error.getText(), "Error: Please enter an account password.");
    }

    @Test
    public void registerUserWithToShortPasswordTest() {
        boolean button = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData("testowy@testowy.pl", "abc2")
                .isButtonAvailable();

        Assert.assertFalse(button);
    }

}
