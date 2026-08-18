package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmationPage extends BasePage {


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private final By rideBooked = AppiumBy.accessibilityId("confirmation_message");
    private final By pickupText = AppiumBy.xpath("//android.widget.TextView[@text='PICKUP']");
    private final By dropText = AppiumBy.xpath("//android.widget.TextView[@text='DROP']");
    private final By backToBashboard = AppiumBy.xpath("//android.view.View[@resource-id='confirmation_done_btn']");

    private final By tripTab = AppiumBy.xpath("//android.view.View[@content-desc='bottomnav_trips']");
    private final By upComingTab = AppiumBy.xpath("//android.view.View[@resource-id='triphistory_tab_upcoming']");
    private final By requestedText = AppiumBy.xpath("//android.widget.TextView[@text='REQUESTED']");

    public void veryRideBooked() {
        Assert.assertTrue( isDisplayed(rideBooked), "Booking confirmation is not displayed");
    }

    public void verifyPickupText() {
        Assert.assertTrue( isDisplayed(pickupText), "Booking confirmation is not displayed");
    }

    public void verifyDropText() {
        Assert.assertTrue( isDisplayed(dropText), "Booking confirmation is not displayed");
    }

    public void selectBackToDashboard() {
        click(backToBashboard);
    }

    public void navigateToTripTab() {
        click(tripTab);
    }

    public void navigateToUpComingTab() {
        click(upComingTab);
    }

    public void verifyRequestLabel() {
        Assert.assertTrue( isDisplayed(requestedText), "Requested Label is not displayed");
    }



    public void verifyBookingConfirmation() {
        veryRideBooked();
        verifyPickupText();
        verifyDropText();
        selectBackToDashboard();
    }

    public void verifyRideAppearsIncomingTrip() {
        navigateToTripTab();
        navigateToUpComingTab();
        verifyRequestLabel();

    }
}