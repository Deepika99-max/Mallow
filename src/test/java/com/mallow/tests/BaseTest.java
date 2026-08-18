package com.mallow.tests;

import com.mallow.automation.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        DriverManager.initializeDriver();

        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void tearDown() {

        DriverManager.quitDriver();
    }
}