package com.mallow.tests;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.pages.BookRidePage;
import org.testng.annotations.Test;

public class ScheduleCabRideTest extends BasePage {

    @Test
    public void scheduleFutureCabRide() {

        BookRidePage bookRidePage = new BookRidePage(driver);

        // 1. Select 3rd pickup location
        bookRidePage.selectThirdPickupLocation();

        // 2. Select 4th drop location
        bookRidePage.selectFourthDropLocation();

        // 3. Select future date
        bookRidePage.selectFutureDate();

        // 4. Select time
        bookRidePage.selectTime();

        // 5. Submit / book ride
        bookRidePage.submitRide();
    }
}