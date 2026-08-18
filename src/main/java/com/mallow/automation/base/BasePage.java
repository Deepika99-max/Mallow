package com.mallow.automation.base;

import com.mallow.automation.driver.PlatformManager;
import com.mallow.automation.utils.WaitUtils;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return WaitUtils.waitForElement(driver, locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        return WaitUtils.waitForElement(driver, locator).isDisplayed();
    }

    protected void hideKeyboard() {
        if (PlatformManager.isIOS()) {
            driver.switchTo().activeElement().sendKeys(Keys.RETURN);
        }
    }

    protected void navigateBack() {
        driver.navigate().back();
    }
}