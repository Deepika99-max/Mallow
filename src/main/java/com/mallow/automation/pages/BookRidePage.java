package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.constants.AppConstants;
import com.mallow.automation.utils.DateUtils;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookRidePage extends BasePage {

    private final By pickupLocation =
            AppiumBy.id("bookride_pickup_select");

    private final By dropLocation =
            AppiumBy.id("bookride_drop_select");

    private final By travelDate =
            AppiumBy.id("bookride_date_input");

    private final By shiftTime =
            AppiumBy.id("bookride_time_select");

    /*
     * IMPORTANT:
     * Verify this locator using Appium Inspector.
     */
    private final By scheduleFutureRide =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Schedule future Ride\")"
            );

    /*
     * IMPORTANT:
     * Verify this locator using Appium Inspector.
     */
    private final By confirmBookingButton =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().textContains(\"Confirm Booking\")"
            );

    public BookRidePage(WebDriver driver) {
        super(driver);
    }

    public void selectThirdPickupLocation() {

        click(pickupLocation);

        By thirdLocation =
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View["
                                + AppConstants.PICKUP_LOCATION_INDEX
                                + "]"
                );

        click(thirdLocation);
    }

    public void selectFourthDropLocation() {

        click(dropLocation);

        By fourthLocation =
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View["
                                + AppConstants.DROP_LOCATION_INDEX
                                + "]"
                );

        click(fourthLocation);
    }

    public void selectScheduleFutureRide() {

        click(scheduleFutureRide);
    }

    public void selectFutureDate() {

        click(travelDate);

        String futureDay =
                DateUtils.getFutureDay();

        By futureDate =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\""
                                + futureDay
                                + "\")"
                );

        click(futureDate);
    }

    public void selectTime() {

        click(shiftTime);

        By timeOption =
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View["
                                + AppConstants.TIME_OPTION_INDEX
                                + "]"
                );

        click(timeOption);
    }

    public void confirmBooking() {

        click(confirmBookingButton);
    }

    public ConfirmationPage scheduleFutureRide() {

        selectThirdPickupLocation();

        selectFourthDropLocation();

        selectScheduleFutureRide();

        selectFutureDate();

        selectTime();

        confirmBooking();

        return new ConfirmationPage(driver);
    }
}