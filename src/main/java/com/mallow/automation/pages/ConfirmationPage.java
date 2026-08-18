package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmationPage extends BasePage {

    /*
     * Verify these locators in Appium Inspector.
     */

    private final By bookingConfirmation =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Booking confirmed\")"
            );

    private final By bookingReference =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Booking ID\")"
            );

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void verifyBookingConfirmation() {

        Assert.assertTrue(
                isDisplayed(bookingConfirmation),
                "Booking confirmation is not displayed"
        );
    }

    public String getBookingReference() {

        String reference =
                find(bookingReference).getText();

        Assert.assertNotNull(
                reference,
                "Booking reference is null"
        );

        Assert.assertFalse(
                reference.trim().isEmpty(),
                "Booking reference is empty"
        );

        return reference;
    }

    public void verifyBookingReferenceGenerated() {

        String reference =
                getBookingReference();

        Assert.assertFalse(
                reference.trim().isEmpty(),
                "Booking reference was not generated"
        );
    }

    public void verifyBookingDetails() {

        verifyBookingConfirmation();

        verifyBookingReferenceGenerated();
    }

    public void navigateBackToHome() {

        driver.navigate().back();
    }
}