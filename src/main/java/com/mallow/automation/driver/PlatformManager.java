package com.mallow.automation.driver;

import com.mallow.automation.utils.ConfigReader;

public class PlatformManager {

    private PlatformManager() {
    }

    public static boolean isIOS() {
        return ConfigReader.get("platform")
                .equalsIgnoreCase("ios");
    }

    public static boolean isAndroid() {
        return ConfigReader.get("platform")
                .equalsIgnoreCase("android");
    }
}