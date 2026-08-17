package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {

    private final WebDriver driver;

    private final By nameField =
            AppiumBy.id("createaccount_name");

    private final By employeeIdField =
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='createaccount_employee_id_input']"
            );

    private final By emailField =
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='createaccount_email_input']"
            );

    private final By passwordField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_password_input']"
            );

    private final By confirmPasswordField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_confirm_password_input]"
            );

    private final By phoneField =
            AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_phone_input']");

    private final By departmentField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_department_input']"
            );

    private final By officeField =
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='createaccount_office_input']"
            );

    private final By createAccountButton =
            AppiumBy.xpath(
                    "//android.view.View[@content-desc='createaccount_submit_btn']"
            );

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
    }


    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmployeeId(String employeeId) {
        driver.findElement(employeeIdField).sendKeys(employeeId);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField)
                .sendKeys(confirmPassword);
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }

    public void enterDepartment(String department) {
        driver.findElement(departmentField).sendKeys(department);
    }

    public void enterOffice(String office) {
        driver.findElement(officeField).sendKeys(office);
    }

    public void clickCreateAccount() {
        driver.findElement(createAccountButton).click();
    }


    public void createAccount(
            String name,
            String employeeId,
            String email,
            String password,
            String confirmPassword,
            String phone,
            String department,
            String office
    ) {

        enterName(name);
        enterEmployeeId(employeeId);
        enterEmail(email);
        enterPassword(password);
        enterConfirmPassword(confirmPassword);
        enterPhone(phone);
        enterDepartment(department);
        enterOffice(office);

        clickCreateAccount();
    }
}