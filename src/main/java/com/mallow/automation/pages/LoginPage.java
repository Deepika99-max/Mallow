package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.models.UserData;
import com.mallow.automation.utils.PlatformLocator;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailField = PlatformLocator.get(AppiumBy.id("login_email_input"), AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == 'jane.doe@company.com'`]"));

    private final By passwordField = PlatformLocator.get(AppiumBy.id("login_password_input"),AppiumBy.iOSClassChain("**/XCUIElementTypeSecureTextField[`value == 'Enter password'`]"));

    private final By createAccountButton = PlatformLocator.get(AppiumBy.xpath("//android.widget.TextView[@text='Create account']"),AppiumBy.accessibilityId("login_create_account_link"));

    private final By getLogin = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@resource-id='login_submit_btn']"), AppiumBy.accessibilityId("login_submit_btn"));

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {

        enter_text(emailField, email);
    }

    public void enterPassword(String password) {

        enter_text(passwordField, password);
    }

    public void clickLogin() {

        click(getLogin);
    }

    public HomePage login(UserData user) {

        enterEmail(user.getemailLogin());
        enterPassword(user.getpasswordLogin());
        clickLogin();

        return new HomePage(driver);
    }


    public CreateAccountPage clickCreateAccount() {

        click(createAccountButton);

        return new CreateAccountPage(driver);
    }
}