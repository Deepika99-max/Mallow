package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By emailField =
            AppiumBy.id("login_email_input");

    private final By passwordField =
            AppiumBy.id("login_password_input");

    private final By createAccountButton =
            AppiumBy.xpath(
                    "//android.widget.TextView[@text='Create account']"
            );

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {

        type(emailField, email);
    }

    public void enterPassword(String password) {

        type(passwordField, password);
    }

    public CreateAccountPage clickCreateAccount() {

        click(createAccountButton);

        return new CreateAccountPage(driver);
    }
}