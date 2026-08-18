package com.mallow.automation.utils;

import com.mallow.automation.driver.PlatformManager;
import org.openqa.selenium.By;

public class PlatformLocator {

    private PlatformLocator() {
    }

    public static By get(
            By androidLocator,
            By iosLocator
    ) {

        return PlatformManager.isIOS()
                ? iosLocator
                : androidLocator;
    }
}