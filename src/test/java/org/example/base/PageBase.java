package org.example.base;


import io.appium.java_client.AppiumDriver;


public class PageBase {

    protected AppiumDriver driver;
    protected boolean isAndroid;
    protected boolean isIOS;

    public PageBase(AppiumDriver driver) {
        this.driver = driver;
        String platform = driver.getCapabilities().getPlatformName().toString();
        isAndroid = platform.equalsIgnoreCase("android");
        isIOS = platform.equalsIgnoreCase("ios");
    }
}


