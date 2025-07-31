package org.example;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class InitDriverSession {
    public static String userName = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");

    public static AppiumDriver initDriver(String sMobileDevice) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("project", "SwagLabsApp");
        capabilities.setCapability("build", "Build 1.0");
        capabilities.setCapability("w3c", true);
        switch (sMobileDevice) {
            case "Pixel 7":
                capabilities.setCapability("platformName", "android");
                capabilities.setCapability("deviceName", "Pixel 7");
                capabilities.setCapability("platformVersion", "13");
                capabilities.setCapability("app", "lt://APP10160301691753941998244672");
                capabilities.setCapability("isRealMobile", true);
                break;

            case "iPhone 15":
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "iPhone 15");
                capabilities.setCapability("platformVersion", "17");
                capabilities.setCapability("app", "lt://APP10160301691753942019340150");
                capabilities.setCapability("isRealMobile", true);
                break;

            default:
                throw new RuntimeException("Missing Device Configuration for: " + sMobileDevice);
        }
        System.out.println("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub");

        return new AppiumDriver(new URL("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"),capabilities);
    }
}
