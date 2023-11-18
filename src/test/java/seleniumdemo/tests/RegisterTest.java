package seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumdemo.pages.HomePage;
import seleniumdemo.pages.MyAccountPage;
import seleniumdemo.pages.RegisterUserPage;
import seleniumdemo.utils.BaseTest;
import seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;

public class RegisterTest extends BaseTest {

    int random = (int) (Math.random() * 1000);

    @Test
    public void registerUserTest() {
        ExtentTest test = extentReports.createTest("Register user");

        RegisterUserPage dashBoardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData("testowy" + random +
                        "@testowy.pl", "TestowyHaslo123@");

        String getDashBoardLink = dashBoardLink.getDashBoardLink();

        Assert.assertEquals(getDashBoardLink, "Dashboard");

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void registerUserWithExistingEmailTest() {
        ExtentTest test = extentReports.createTest("Register user with existing email");

        MyAccountPage error = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData("testowy@testowy.pl", "TestowyHaslo123@");

        Assert.assertEquals(error.getError(), "Error: An account is already registered with your email address. Please log in.");

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void registerUserWithoutPasswordTest() {
        ExtentTest test = extentReports.createTest("Register user without password");

        MyAccountPage error = new HomePage(driver).openMyAccountPage()
                .registerUserInvalidData("testowy11" + random + "@testowy.pl", "");

        Assert.assertEquals(error.getError(),"Error: Please enter an account password.");

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
