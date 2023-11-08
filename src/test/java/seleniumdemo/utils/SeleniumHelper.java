package seleniumdemo.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumHelper {

    public static void waitForClickable(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebDriver webDriver, WebElement locator){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(locator));
    }
    public static void presentOfElementLocation(WebDriver webDriver, By locator){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
