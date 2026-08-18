package com.mallow.tests;

import com.mallow.automation.driver.DriverManager;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeMethod
    public void setUp()
            throws MalformedURLException {

        DriverManager.initializeDriver();

        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }
}