package com.mallow.tests;

import com.mallow.automation.models.UserData;
import com.mallow.automation.pages.BookRidePage;
import com.mallow.automation.pages.ConfirmationPage;
import com.mallow.automation.pages.CreateAccountPage;
import com.mallow.automation.pages.HomePage;
import com.mallow.automation.pages.LoginPage;
import com.mallow.automation.utils.TestDataGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScheduleCabRideTest extends BaseTest {

    @Test
    public void scheduleFutureCabRide() {

        // Generate unique test data
        UserData user =
                TestDataGenerator.generateUser();

        // ------------------------------------------------
        // 1. Login screen
        // ------------------------------------------------

        LoginPage loginPage =
                new LoginPage(driver);

        CreateAccountPage createAccountPage =
                loginPage.clickCreateAccount();

        // ------------------------------------------------
        // 2. Create account
        // ------------------------------------------------

        HomePage homePage =
                createAccountPage.createAccount(user);

        // ------------------------------------------------
        // 3. Navigate to Book a Ride
        // ------------------------------------------------

        BookRidePage bookRidePage =
                homePage.clickBookARide();

        // ------------------------------------------------
        // 4. Schedule future ride
        // ------------------------------------------------

        ConfirmationPage confirmationPage =
                bookRidePage.scheduleFutureRide();

        // ------------------------------------------------
        // 5. Verify confirmation
        // ------------------------------------------------

        confirmationPage.verifyBookingConfirmation();

        // ------------------------------------------------
        // 6. Verify booking ID/reference generated
        // ------------------------------------------------

        String bookingReference =
                confirmationPage.getBookingReference();

        Assert.assertFalse(
                bookingReference.trim().isEmpty(),
                "Booking reference was not generated"
        );

        // ------------------------------------------------
        // 7. Navigate back to Home
        // ------------------------------------------------

        confirmationPage.navigateBackToHome();

        // ------------------------------------------------
        // 8. Verify booking confirmation on Home
        // ------------------------------------------------

        homePage.verifyBookingConfirmation();

        // ------------------------------------------------
        // 9. Verify Upcoming Trips
        // ------------------------------------------------

        homePage.verifyUpcomingTrips();
    }
}