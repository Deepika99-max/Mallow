package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.models.UserData;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccountPage extends BasePage {

    private final By emailID =
            AppiumBy.xpath("//android.widget.EditText[@resource-id='login_email_input']");

    private final By password =
            AppiumBy.xpath("//android.widget.EditText[@resource-id='login_password_input']");

    private final By getLogin =
            AppiumBy.xpath("//android.view.View[@resource-id='login_submit_btn']");

    private final By nameField =
            AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_name_input']");

    private final By employeeIdField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_employee_id_input']"
            );

    private final By emailField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_email_input']"
            );

    private final By passwordField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_password_input']"
            );

    private final By confirmPasswordField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_confirm_password_input']"
            );

    private final By phoneField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_phone_input']"
            );

    private final By departmentField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_department_input']"
            );

    private final By officeField =
            AppiumBy.xpath(
                    "//android.widget.EditText[@resource-id='createaccount_office_input']"
            );

    private final By createAccountButton =
            AppiumBy.xpath(
                    "//android.view.View[@resource-id='createaccount_submit_btn']"
            );

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {

        type(nameField, name);
    }
    public void setEmailID(String name) {

        type(emailID, name);
    }

    public void setPassword(String name) {

        type(password, name);
    }

    public void enterEmployeeId(String employeeId) {

        type(employeeIdField, employeeId);
    }

    public void enterEmail(String email) {

        type(emailField, email);
    }

    public void enterPassword(String password) {

        type(passwordField, password);
    }

    public void enterConfirmPassword(String password) {

        type(confirmPasswordField, password);
    }

    public void enterPhone(String phone) {

        type(phoneField, phone);
    }

    public void enterDepartment(String department) {

        type(departmentField, department);
    }

    public void enterOffice(String office) {

        type(officeField, office);
    }

    public void clickCreateAccount() {

        click(createAccountButton);
    }
    public void clickLogin() {

        click(getLogin);
    }

    public HomePage createAccount(UserData user) {

        enterName(user.getName());

        enterEmployeeId(user.getEmployeeId());

        enterEmail(user.getEmail());

        enterPassword(user.getPassword());

        enterConfirmPassword(user.getPassword());

        enterPhone(user.getPhone());

        enterDepartment(user.getDepartment());

        enterOffice(user.getOffice());

        clickCreateAccount();

        return new HomePage(driver);
    }
}