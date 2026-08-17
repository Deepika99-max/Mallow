package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmationPage extends BasePage {

    private final WebDriver driver;

    // Pickup
    private final By pickupLocation =
            AppiumBy.xpath("//android.widget.TextView[@text='Home – Indiranagar']");

    // Drop
    private final By dropLocation =
            AppiumBy.xpath("//android.widget.TextView[@text='Home – Whitefield']");

    // Date + Time
    private final By rideTime =
            AppiumBy.xpath("//android.widget.TextView[contains(@text,'Evening')]");


    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }


    public void verifyPickupLocation() {

        Assert.assertTrue(
                driver.findElement(pickupLocation).isDisplayed(),
                "Pickup location is not displayed"
        );
    }


    public void verifyDropLocation() {

        Assert.assertTrue(
                driver.findElement(dropLocation).isDisplayed(),
                "Drop location is not displayed"
        );
    }


    public void verifyRideTime() {

        Assert.assertTrue(
                driver.findElement(rideTime).isDisplayed(),
                "Ride time is not displayed"
        );
    }


    public void verifyRideDetails() {

        verifyPickupLocation();
        verifyDropLocation();
        verifyRideTime();
    }
}