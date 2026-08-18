package com.mallow.tests;

import com.mallow.automation.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {

        DriverManager.initializeDriver();

        driver = DriverManager.getDriver();
    }

    @AfterClass
    public void tearDown() {

        DriverManager.quitDriver();
    }
}