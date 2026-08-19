package com.mallow.tests;

import com.mallow.automation.models.UserData;
import com.mallow.automation.pages.BookRidePage;
import com.mallow.automation.pages.ConfirmationPage;
import com.mallow.automation.pages.CreateAccountPage;
import com.mallow.automation.pages.HomePage;
import com.mallow.automation.pages.LoginPage;
import com.mallow.automation.utils.TestDataGenerator;
import org.testng.annotations.Test;

public class ScheduleCabRideTest extends BaseTest {

    @Test
    public void scheduleFutureCabRide() {

        UserData user = TestDataGenerator.generateUser();

        LoginPage loginPage = new LoginPage(driver);

//        loginPage.login(user);

        CreateAccountPage createAccountPage = loginPage.clickCreateAccount();

        HomePage homePage = createAccountPage.createAccount(user);

        BookRidePage bookRidePage = homePage.clickBookARide();

        ConfirmationPage confirmationPage = bookRidePage.scheduleFutureRide();

        confirmationPage.verifyBookingConfirmation();

        confirmationPage.verifyRideAppearsIncomingTrip();

        homePage.navigateToHomeTab();

        homePage.logout();
    }
}