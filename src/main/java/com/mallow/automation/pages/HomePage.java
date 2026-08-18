package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    private final By bookARideButton =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Book a ride\")"
            );

    private final By bookingConfirmation =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Booking confirmed\")"
            );

    private final By upcomingTrips =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Upcoming Trips\")"
            );

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public BookRidePage clickBookARide() {

        click(bookARideButton);

        return new BookRidePage(driver);
    }

    public void verifyBookingConfirmation() {

        Assert.assertTrue(
                isDisplayed(bookingConfirmation),
                "Booking confirmation is not displayed on Home page"
        );
    }

    public void verifyUpcomingTrips() {

        Assert.assertTrue(
                isDisplayed(upcomingTrips),
                "Upcoming Trips section is not displayed"
        );
    }
}