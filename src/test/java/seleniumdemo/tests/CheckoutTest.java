package seleniumdemo.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumdemo.models.Customer;
import seleniumdemo.pages.CartPage;
import seleniumdemo.pages.HomePage;
import seleniumdemo.pages.OrderDetailsPage;


public class CheckoutTest extends BaseTest {

    int random = (int) (Math.random() * 1000);

    @Test
    public void checkoutTestJavaSelenium() throws InterruptedException {

        Customer customer = new Customer();


        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer);

        Assert.assertEquals(orderDetailsPage.getProductName().getText(),
                "Java Selenium WebDriver  × 1");

    }
    @Test
    public void checkoutTestBDDCucumber() throws InterruptedException {

        Customer customer = new Customer();


        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("BDD Cucumber")
                .addProductToCart()
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer);


    }

    @Test
    public void checkoutTestBDDCucumberPrice() throws InterruptedException {

        CartPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("BDD Cucumber")
                .addProductToCart()
                .addProductToCart()
                .viewCart()
                .returnToHomePage()
                .cartPage();

        double price = 19.98;
        double priceExpected = orderDetailsPage.quantity();

        Assert.assertEquals(price, priceExpected);



    }


    @Test
    public void checkoutTestBDDCucumberAndJavaSeleniumPrice() throws InterruptedException {

        CartPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("BDD Cucumber")
                .addProductToCart()
                .viewCart()
                .addQuantity("4")
                .clickShop()
                .addToCartProduct()
                .checkCart();


        String price = "40,96 zł";
        String priceE = orderDetailsPage.getErrors();
        System.out.println(priceE);

        Assert.assertEquals(priceE, price);

    }
    @Test
    public void checkoutTestSearchProduct() throws InterruptedException {

        CartPage productShopPage = new HomePage(driver)
                .searchProduct()
                .enterProductName()
                .confirmProduct()
                .addProductByEnterValue("3")
                .viewCart();


        String price = "3,00 zł";
        String priceE = productShopPage.getErrors();
        System.out.println(priceE);

        Assert.assertEquals(priceE, price);

    }

}
