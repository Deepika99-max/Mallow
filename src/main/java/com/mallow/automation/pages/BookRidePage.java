package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.constants.AppConstants;
import com.mallow.automation.utils.DateUtils;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookRidePage extends BasePage {

    private final By pickupLocation = AppiumBy.xpath("//android.widget.EditText[@resource-id='bookride_pickup_select']");

    private final By dropLocation = AppiumBy.xpath("//android.widget.EditText[@resource-id='bookride_drop_select']");

    private final By chooseRide = AppiumBy.xpath("//android.widget.TextView[@text='Choose date']");
//
//    private final By selectDate =
//            AppiumBy.accessibilityId("19 August 2026");

    private final By okButton = AppiumBy.id("android:id/button1");

    private final By travelDate = AppiumBy.id("bookride_date_input");

    private final By shiftTime = AppiumBy.xpath("//android.widget.EditText[@resource-id='bookride_shift_select']");

    private final By submitButton = AppiumBy.xpath("//android.view.View[@resource-id='bookride_submit_btn']");

    public BookRidePage(WebDriver driver) {
        super(driver);
    }

    public static String getFutureDay() {
        return LocalDate.now()
                .plusDays(1)
                .format(DateTimeFormatter.ofPattern("d MMMM yyyy"));
    }

    public void selectThirdPickupLocation() {

        click(pickupLocation);

        By thirdLocation = AppiumBy.xpath("//android.widget.ScrollView/android.view.View[3]");
        click(thirdLocation);
    }

    public void selectFourthDropLocation() {

        click(dropLocation);

        By fourthLocation = AppiumBy.xpath("//android.widget.ScrollView/android.view.View[4]");
        click(fourthLocation);
    }

    private By getSelectDateLocator() {
        String futureDay = getFutureDay();
        return AppiumBy.accessibilityId(futureDay);
    }

    public void selectScheduleFutureRide() {
        click(chooseRide);
        click(getSelectDateLocator());
        click(okButton);
    }


    public void selectTime() {

        click(shiftTime);

        By timeOption = AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]");
        click(timeOption);
    }

    public void SubmitBooking() {
        click(submitButton);
    }

    public ConfirmationPage scheduleFutureRide() {

        selectThirdPickupLocation();
        selectFourthDropLocation();
        selectScheduleFutureRide();
        selectTime();
        SubmitBooking();

        return new ConfirmationPage(driver);
    }
}