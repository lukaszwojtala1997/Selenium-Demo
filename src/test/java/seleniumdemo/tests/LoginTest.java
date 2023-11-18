package seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumdemo.pages.HomePage;
import seleniumdemo.pages.LoggedUserPage;
import seleniumdemo.pages.MyAccountPage;
import seleniumdemo.utils.BaseTest;
import seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        ExtentTest test = extentReports.createTest("Login test");

        LoggedUserPage dashBoardLink = new HomePage(driver).openMyAccountPage()
                .loginValidData("testowy@testowy1.pl", "TestowyHaslo123@");

        Assert.assertEquals(dashBoardLink.getDashBoardLink(), "Dashboard");

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginWithoutPasswordTest() {
        ExtentTest test = extentReports.createTest("Login without password");

        MyAccountPage error = new HomePage(driver).openMyAccountPage()
                .loginInvalidData("testowy@testowy.pl", "");

        Assert.assertEquals(error.getError(), "ERROR: The password field is empty.");

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
