package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.constants.AppConstants;
import com.mallow.automation.driver.PlatformManager;
import com.mallow.automation.utils.DateUtils;
import com.mallow.automation.utils.PlatformLocator;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookRidePage extends BasePage {

    private final By pickupLocation = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='bookride_pickup_select']"), AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Select pickup point'`]"));

    private final By dropLocation = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='bookride_drop_select']"), AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Select drop point'`]"));

    private final By chooseRide = PlatformLocator.get(AppiumBy.xpath("//android.widget.TextView[@text='Choose date']"), AppiumBy.accessibilityId("Date Picker"));
//
//    private final By selectDate =
//            AppiumBy.accessibilityId("19 August 2026");

    private final By okButton = PlatformLocator.get(AppiumBy.id("android:id/button1"), AppiumBy.accessibilityId(""));

    private final By travelDate = AppiumBy.id("bookride_date_input");

    private final By shiftTime = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='bookride_shift_select']"), AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == 'Select shift'`]"));

    private final By submitButton = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@resource-id='bookride_submit_btn']"), AppiumBy.accessibilityId("bookride_submit_btn"));

    public BookRidePage(WebDriver driver) {
        super(driver);
    }

    public static String getFutureDay() {
        return LocalDate.now()
                .plusDays(1)
                .format(DateTimeFormatter.ofPattern("d MMMM yyyy"));
    }

    public static String getFutureDayIOS() {
        return LocalDate.now()
                .plusDays(1)
                .format(DateTimeFormatter.ofPattern("EEEE, d MMMM"));
    }

    public void selectThirdPickupLocation() {

        click(pickupLocation);

        By thirdLocation = PlatformLocator.get(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[3]"), AppiumBy.accessibilityId("Home — Indiranagar"));
        click(thirdLocation);
    }

    public void selectFourthDropLocation() {

        click(dropLocation);

        By fourthLocation = PlatformLocator.get(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[4]"), AppiumBy.xpath("(//XCUIElementTypeCollectionView/XCUIElementTypeOther[@name='Horizontal scroll bar, 1 page'])[2]"));
        click(fourthLocation);
    }

    private By getSelectDateLocator() {
        String futureDay = getFutureDay();
        String futureDayIOS = getFutureDayIOS();
        return PlatformLocator.get(AppiumBy.accessibilityId(futureDay), AppiumBy.xpath("//XCUIElementTypeButton[@name='"+ futureDayIOS +"']/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther"));
    }

    public void selectScheduleFutureRide() {
        click(chooseRide);
        click(getSelectDateLocator());

        if (PlatformManager.isIOS()) {
            navigateBack();
        }else {
            click(okButton);
        }
    }


    public void selectTime() {

        click(shiftTime);

        By timeOption = PlatformLocator.get(AppiumBy.xpath("//android.widget.ScrollView/android.view.View[1]"), AppiumBy.accessibilityId("Morning — 9:00 AM"));
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