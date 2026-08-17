package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookRidePage extends BasePage {

    private final WebDriver driver;

    private final By pickupLocation =
            AppiumBy.id("bookride_pickup_select");

    private final By dropLocation =
            AppiumBy.id("bookride_drop_select");

    private final By travelDate =
            AppiumBy.id("bookride_date_input");

    private final By shiftTime =
            AppiumBy.id("bookride_time_select");

    private final By submitButton =
            AppiumBy.androidUIAutomator(
                    "new UiSelector().text(\"Submit\")"
            );

    public BookRidePage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectThirdPickupLocation() {

        driver.findElement(pickupLocation).click();
        By thirdLocation =
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View[3]"
                );

        driver.findElement(thirdLocation).click();
    }

    public void selectFourthDropLocation() {

        driver.findElement(dropLocation).click();
        By fourthLocation =
                AppiumBy.xpath(
                        "//android.widget.ScrollView/android.view.View[4]"
                );

        driver.findElement(fourthLocation).click();
    }

    public void selectFutureDate() {

        driver.findElement(travelDate).click();

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        String day = String.valueOf(tomorrow.getDayOfMonth());

        By futureDay =
                AppiumBy.androidUIAutomator(
                        "new UiSelector().text(\"" + day + "\")"
                );

        driver.findElement(futureDay).click();

    }


    public void selectTime() {

        driver.findElement(shiftTime).click();
        By timeOption =
                AppiumBy.androidUIAutomator(
                        "//android.widget.ScrollView/android.view.View[2]"
                );

        driver.findElement(timeOption).click();
    }

    public void submitRide() {

        driver.findElement(submitButton).click();
    }

    public void scheduleFutureRide() {

        selectThirdPickupLocation();

        selectFourthDropLocation();

        selectFutureDate();

        selectTime();

        submitRide();
    }
}