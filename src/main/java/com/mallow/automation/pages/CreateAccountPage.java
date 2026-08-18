package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.models.UserData;
import com.mallow.automation.utils.PlatformLocator;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
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

    public void enterPassword(String passwordText) {

        click(passwordField);

        WebElement passwordElement = find(passwordField);

        passwordElement.clear();
        passwordElement.sendKeys(passwordText);
//
//        System.out.println("After password sendKeys:");
//        System.out.println(driver.getPageSource());
    }

    public void enterConfirmPassword(String passwordText) {

        click(confirmPasswordField);

        WebElement confirmElement = find(confirmPasswordField);

        confirmElement.clear();
        confirmElement.sendKeys(passwordText);
//
//        System.out.println("After confirm password sendKeys:");
//        System.out.println(driver.getPageSource());

    }
//    public void enterPassword(String password) {
//
////        type(passwordField, password);
//        click(passwordField);
//
//        WebElement element = find(passwordField);
//        element.clear();
//
//        element.sendKeys(password);
//
//        hideKeyboard();
//
//    }
//
//    public void enterConfirmPassword(String password) {
//
////        type(confirmPasswordField, password);
//        click(confirmPasswordField);
//
//        WebElement element = find(confirmPasswordField);
//        element.clear();
//
//        element.sendKeys(password);
//        hideKeyboard();
//    }

    public void enterPhone(String phone) {

        type(phoneField, phone);
        hideKeyboard();
    }

    public void enterDepartment(String department) {

        type(departmentField, department);
        hideKeyboard();
    }

    public void enterOffice(String office) {

        type(officeField, office);
        hideKeyboard();
    }
    public void clickCreateAccount() {

        click(createAccountButton);
    }
    public void clickLogin() {

        click(getLogin);
    }

    public HomePage createAccount(UserData user) {
//
//        enterName(user.getName());
//
//        enterEmployeeId(user.getEmployeeId());
//
//        enterEmail(user.getEmail());
//
//        enterPassword(user.getPassword());
//
//        enterConfirmPassword(user.getPassword());
//
//        enterPhone(user.getPhone());
//
//        enterDepartment(user.getDepartment());
//
//        enterOffice(user.getOffice());
//
//        clickCreateAccount();

        return new HomePage(driver);
    }
}