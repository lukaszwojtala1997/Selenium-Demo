package seleniumdemo.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumdemo.models.Customer;
import seleniumdemo.pages.CartPage;
import seleniumdemo.pages.HomePage;
import seleniumdemo.pages.OrderDetailsPage;
import seleniumdemo.utils.BaseTest;
import seleniumdemo.utils.SeleniumHelper;

import java.io.IOException;


public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutTestJavaSeleniumTest(){
        ExtentTest test = extentReports.createTest("Checkout test java selenium");

        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct()
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer);

        Assert.assertEquals(orderDetailsPage.getProductName().getText(),
                "Java Selenium WebDriver  × 1");

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkoutTestBDDCucumberTest() {
        ExtentTest test = extentReports.createTest("Checkout test bdd cucumber");

        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct()
                .addProductToCart3()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer);

        Assert.assertEquals(orderDetailsPage.getProductName().getText(),
                "BDD Cucumber  × 1");

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void checkoutTestBDDCucumberPriceTest(){
        ExtentTest test = extentReports.createTest("Checkout test bdd cucumber price");

        CartPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct()
                .addProductToCart2()
                .addProductToCart2()
                .viewCart()
                .returnToHomePage()
                .cartPage();

        double priceExpected = 19.98;
        double price = orderDetailsPage.quantity();

        Assert.assertEquals(price, priceExpected);

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void checkoutTestBDDCucumberAndJavaSeleniumPriceTest(){
        ExtentTest test = extentReports.createTest("Checkout test bdd cucumber and java selenium price");

        CartPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct()
                .addProductToCart2()
                .viewCart()
                .addQuantity("4")
                .clickShop()
                .addToCartProduct()
                .checkCart();

        String priceExpected = "40,96 zł";
        String price = orderDetailsPage.getErrors();

        Assert.assertEquals(priceExpected, price);

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void checkoutTestSearchProductTest() {
        ExtentTest test = extentReports.createTest("Checkout test search product");

        CartPage cartPage = new HomePage(driver)
                .searchProduct()
                .enterProductName()
                .confirmProduct()
                .addProductByEnterValue("3")
                .viewCart();

        String price = "3,00 zł";
        String priceE = cartPage.getErrors();
        System.out.println(priceE);

        Assert.assertEquals(priceE, price);

        try {
            test.log(Status.PASS, "Assertions passed", SeleniumHelper.getScreenshot(driver));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
