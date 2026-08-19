package com.mallow.automation.base;

import com.mallow.automation.driver.PlatformManager;
import com.mallow.automation.utils.WaitUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Collections;
import java.util.Map;

public class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return WaitUtils.waitForElement(driver, locator);
    }
    protected void click(By locator) {
        try {
            WebElement element = find(locator);

            System.out.println("========== CLICK ==========");
            System.out.println("Locator: " + locator);
            System.out.println("===========================");

            element.click();

        } catch (Exception e) {
            System.out.println("CLICK FAILED");
            System.out.println("Locator: " + locator);
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    protected void enter_text(By locator, String text) {
        try {
            WebElement element = find(locator);

            System.out.println("======= ENTER TEXT =======");
            System.out.println("Locator: " + locator);
            System.out.println("==========================");

            element.clear();
            element.sendKeys(text);

        } catch (Exception e) {
            System.out.println("ENTER TEXT FAILED");
            System.out.println("Locator: " + locator);
            System.out.println("Error: " + e.getMessage());
            throw e;
        }
    }

    protected boolean isDisplayed(By locator) {
        try {
            return WaitUtils.waitForElement(driver, locator).isDisplayed();

        } catch (Exception e) {
            System.out.println("ELEMENT NOT DISPLAYED");
            System.out.println("Locator: " + locator);
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

    protected void hideKeyboard() {
        try {
            if (PlatformManager.isIOS()) {
                if (((IOSDriver) driver).isKeyboardShown()) {
                    driver.switchTo().activeElement().sendKeys(Keys.RETURN);
                }
            } else {
                AndroidDriver androidDriver = (AndroidDriver) driver;

                if (androidDriver.isKeyboardShown()) {
                    androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
                }
            }
        } catch (Exception e) {
            // Keyboard is not present, so nothing to do
        }
    }


    protected void highlightElement(WebElement element) {
        try {
            ((AppiumDriver) driver).executeScript(
                    "mobile: highlight",
                    Map.of(
                            "elementId", element.getAttribute("elementId"),
                            "color", "yellow",
                            "duration", 1000
                    )
            );
        } catch (Exception e) {
            System.out.println("Highlight not supported: " + e.getMessage());
        }
    }

    protected void navigateBack() {
        driver.navigate().back();
    }

    protected void typePassword(By locator, String text) {
        WebElement element = find(locator);

        element.click();
        element.clear();
        element.sendKeys(text);
    }

    protected void tapOutside() {
        PointerInput finger = new PointerInput( PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);

        tap.addAction( finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 200, 150));

        tap.addAction( finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        tap.addAction( finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        ((AppiumDriver) driver).perform( Collections.singletonList(tap));
    }
}