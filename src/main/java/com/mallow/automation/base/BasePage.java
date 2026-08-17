package com.mallow.automation.base;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class BasePage {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();

        caps.setCapability("platformName", "Android");
        caps.setCapability("appium:automationName", "UiAutomator2");
        caps.setCapability(
                "appium:deviceName",
                "Android Emulator"
        );

        caps.setCapability(
                "appium:appPackage",
                "com.example.android_automation_app"
        );

        caps.setCapability(
                "appium:appActivity",
                ".MTMainActivity"
        );

        driver = new AndroidDriver(
                new URL("http://127.0.0.1:4723"),
                caps
        );
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}