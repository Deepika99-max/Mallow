package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private final By emailField = AppiumBy.id("login_email_input");
    private final By passwordField = AppiumBy.id("login_password_input");

    public LoginPage() {
        super();
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void createAccount() {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Create account']"));
    }
}