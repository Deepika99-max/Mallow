package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.driver.PlatformManager;
import com.mallow.automation.models.UserData;
import com.mallow.automation.utils.PlatformLocator;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAccountPage extends BasePage {

    private final By emailID = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='login_email_input']"), AppiumBy.accessibilityId("login_email_input"));

    private final By password = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='login_password_input']"), AppiumBy.accessibilityId("login_password_input"));

    private final By getLogin = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@resource-id='login_submit_btn']"), AppiumBy.accessibilityId("login_submit_btn"));

    private final By nameField = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_name_input']"), AppiumBy.accessibilityId("createaccount_name_input"));

    private final By employeeIdField = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_employee_id_input']"), AppiumBy.accessibilityId("createaccount_employee_id_input"));

    private final By emailField = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_email_input']") , AppiumBy.accessibilityId("createaccount_email_input"));

    private final By passwordField = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_password_input']"), AppiumBy.accessibilityId("createaccount_password_input"));

    private final By confirmPasswordField = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_confirm_password_input']"), AppiumBy.accessibilityId("createaccount_confirm_password_input"));

    private final By phoneField = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_phone_input']"), AppiumBy.accessibilityId("createaccount_phone_input"));

    private final By departmentField = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_department_input']"), AppiumBy.accessibilityId("createaccount_department_input"));

    private final By officeField = PlatformLocator.get(AppiumBy.xpath("//android.widget.EditText[@resource-id='createaccount_office_input']"), AppiumBy.accessibilityId("createaccount_office_input"));

    private final By createAccountButton = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@resource-id='createaccount_submit_btn']"), AppiumBy.accessibilityId("createaccount_submit_btn"));

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        enter_text(nameField, name);
    }
    public void setEmailID(String name) {
        enter_text(emailID, name);
    }

    public void setPassword(String name) {
        enter_text(password, name);
    }

    public void enterEmployeeId(String employeeId) {
        enter_text(employeeIdField, employeeId);
    }

    public void enterEmail(String email) {
        enter_text(emailField, email);
    }

    public void enterPassword(String passwordText) {
        enter_text(passwordField, passwordText);
        hideKeyboard();
    }
    

    public void enterConfirmPassword(String passwordText) {
        enter_text(confirmPasswordField, passwordText);
        hideKeyboard();
    }

    public void enterPhone(String phone) {
        enter_text(phoneField, phone);
        hideKeyboard();
    }

    public void enterDepartment(String department) {
        enter_text(departmentField, department);
        hideKeyboard();
    }

    public void enterOffice(String office) {
        enter_text(officeField, office);
        hideKeyboard();
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