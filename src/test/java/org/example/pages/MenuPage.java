package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.openqa.selenium.By;

public class MenuPage extends PageBase {

    private By openMenuButton;
    private By logoutButton;

    public MenuPage(AppiumDriver driver) {
        super(driver);
        if (isAndroid) {
            openMenuButton = By.xpath("//android.view.ViewGroup[@content-desc='test-Menu']");
            logoutButton = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGOUT']");
        } else {
            openMenuButton = By.xpath("//XCUIElementTypeOther[@name='test-Menu']");
            logoutButton = By.xpath("//XCUIElementTypeOther[@name='test-LOGOUT']");
        }
    }

    public void logout() {
        driver.findElement(openMenuButton).click();
        driver.findElement(logoutButton).click();
    }
}

