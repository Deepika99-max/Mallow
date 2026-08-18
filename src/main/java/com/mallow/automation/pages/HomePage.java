package com.mallow.automation.pages;

import com.mallow.automation.base.BasePage;
import com.mallow.automation.utils.PlatformLocator;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HomePage extends BasePage {

    private final By bookARideButton = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@resource-id='dashboard_book_ride_btn']"), AppiumBy.accessibilityId("dashboard_book_ride_btn"));

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By homeTab = PlatformLocator.get(AppiumBy.xpath("//android.widget.TextView[@text='Home']"), AppiumBy.accessibilityId("bottomnav_dashboard"));
    private final By hamburgerIcon = PlatformLocator.get(AppiumBy.xpath("//android.view.View[@resource-id='dashboard_menu_btn']"), AppiumBy.accessibilityId("dashboard_menu_btn"));
    private final By logOut = PlatformLocator.get(AppiumBy.accessibilityId("drawer_logout_link"), AppiumBy.accessibilityId("drawer_logout_link"));


    public BookRidePage clickBookARide() {
        click(bookARideButton);
        return new BookRidePage(driver);
    }

    public void navigateToHomeTab() {
        click(homeTab);
    }

    public void logout(){
        click(hamburgerIcon);
        click(logOut);
    }

}