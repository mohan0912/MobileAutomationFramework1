package org.example;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class InitDriverSession {
    public static String userName = System.getenv("LT_USERNAME") == null ? "" : System.getenv("LT_USERNAME");
    public static String accessKey = System.getenv("LT_ACCESS_KEY") == null ? "" : System.getenv("LT_ACCESS_KEY");

    public static AppiumDriver initDriver(String sMobileDevice) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        capabilities.setCapability("project", "SwagLabsApp");
        capabilities.setCapability("build", "Build 1.0");
        capabilities.setCapability("w3c", true);

        switch (sMobileDevice) {
            case "Pixel 7":
                ltOptions.put("w3c", true);
                ltOptions.put("platformName", "android");
                ltOptions.put("deviceName", "Pixel 7");
                ltOptions.put("platformVersion", "13");
                ltOptions.put("app", "lt://APP10160301691753941998244672");
                ltOptions.put("devicelog", true);
                ltOptions.put("visual", true);
                ltOptions.put("network", true);
                ltOptions.put("video", true);
                ltOptions.put("isRealMobile", true);
                capabilities.setCapability("lt:options", ltOptions);
                break;

            case "iPhone 15":
                ltOptions.put("w3c", true);
                ltOptions.put("platformName", "ios");
                ltOptions.put("deviceName", "iPhone 15");
                ltOptions.put("platformVersion", "17");
                ltOptions.put("app", "lt://APP10160301691753942019340150");
                ltOptions.put("devicelog", true);
                ltOptions.put("visual", true);
                ltOptions.put("network", true);
                ltOptions.put("video", true);
                ltOptions.put("isRealMobile", true);
                capabilities.setCapability("lt:options", ltOptions);
                break;

            default:
                throw new RuntimeException("Missing Device Configuration for: " + sMobileDevice);
        }
        //System.out.println("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub");

        return new AppiumDriver(new URL("https://"+userName+":"+accessKey+"@mobile-hub.lambdatest.com/wd/hub"),capabilities);
    }
}
