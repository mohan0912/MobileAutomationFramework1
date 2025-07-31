package org.example.base;

import io.appium.java_client.AppiumDriver;
import org.example.InitDriverSession;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class TestBase {

    protected AppiumDriver driver;

    @Parameters({"device"})
    @BeforeClass
    public void setUp(String device) throws MalformedURLException {
        System.out.println("Device: " + device);
        driver = InitDriverSession.initDriver(device);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}