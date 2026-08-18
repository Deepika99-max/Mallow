package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.utils.PlatformLocator;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ConfirmationPage extends BasePage {


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    private final By rideBooked = PlatformLocator.get(AppiumBy.accessibilityId("confirmation_message"), AppiumBy.accessibilityId("confirmation_message"));
    private final By pickupText = PlatformLocator.get(AppiumBy.xpath("//android.widget.TextView[@text='PICKUP']"), AppiumBy.accessibilityId("PICKUP"));
    private final By dropText = PlatformLocator.get(AppiumBy.xpath("//android.widget.TextView[@text='DROP']"), AppiumBy.accessibilityId("DROP"));
    private final By backToBashboard = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@resource-id='confirmation_done_btn']"), AppiumBy.accessibilityId("confirmation_done_btn"));

    private final By tripTab = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@content-desc='bottomnav_trips']"), AppiumBy.accessibilityId("bottomnav_trips"));
    private final By upComingTab = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@resource-id='triphistory_tab_upcoming']"), AppiumBy.accessibilityId("triphistory_tab_upcoming"));
    private final By requestedText = PlatformLocator.get(AppiumBy.xpath("//android.widget.TextView[@text='REQUESTED']"), AppiumBy.accessibilityId("REQUESTED"));

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