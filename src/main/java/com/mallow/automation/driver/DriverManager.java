package com.mallow.automation.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import com.mallow.automation.utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URI;

public class DriverManager {

    private static AppiumDriver driver;

    String platform =
            ConfigReader.get("platform");

    private DriverManager() {
    }

    public static void initializeDriver() throws MalformedURLException {
        String platform =
                ConfigReader.get("platform");

        if (platform.equalsIgnoreCase("ios")) {

            initializeIOSDriver();

        } else {

            initializeAndroidDriver();
        }
//
//        String platform =
//                System.getProperty("platform", "android")
//                        .toLowerCase();
//
//        if ("ios".equals(platform)) {
//
//            initializeIOSDriver();
//
//        } else {
//
//            initializeAndroidDriver();
//        }

    }

    private static void initializeAndroidDriver()
            throws MalformedURLException {

        UiAutomator2Options options =
                new UiAutomator2Options();

        options.setPlatformName("Android");

        options.setAutomationName("UiAutomator2");

        options.setDeviceName("Android Emulator");

        options.setApp(
                ConfigReader.get("android.app.path")
        );

        options.setAppPackage(
                ConfigReader.get("android.app.package")
        );

        options.setAppActivity(
                ConfigReader.get("android.app.activity")
        );

        driver =
                new AndroidDriver(
                        URI.create(
                                "http://127.0.0.1:4723"
                        ).toURL(),
                        options
                );
    }
    private static void initializeIOSDriver()
            throws MalformedURLException {

        XCUITestOptions options =
                new XCUITestOptions();

        options.setPlatformName("iOS");

        options.setAutomationName("XCUITest");

        options.setDeviceName(
                ConfigReader.get("ios.device.name")
        );

        options.setPlatformVersion(
                ConfigReader.get("ios.platform.version")
        );

        options.setUdid(
                ConfigReader.get("ios.udid")
        );

        options.setBundleId(
                ConfigReader.get("ios.bundle.id")
        );

        driver =
                new IOSDriver(
                        URI.create(
                                "http://127.0.0.1:4723"
                        ).toURL(),
                        options
                );
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {

            driver.quit();

            driver = null;
        }
    }
}