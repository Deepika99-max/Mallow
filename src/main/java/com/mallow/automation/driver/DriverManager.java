package com.mallow.automation.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager {

    private static AndroidDriver driver;

    private DriverManager() {
    }

    public static void initializeDriver() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setDeviceName("Android Emulator");

        String appPath = System.getProperty(
                "app",
                "/Users/nagarjunk/Downloads/app-debug.apk"
        );

        options.setApp(appPath);

        options.setAppPackage(
                "com.example.android_automation_app"
        );

        options.setAppActivity(
                "com.example.android_automation_app.MTMainActivity"
        );

        driver = new AndroidDriver(
                URI.create("http://127.0.0.1:4723")
                        .toURL(),
                options
        );
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}