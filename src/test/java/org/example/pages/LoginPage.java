package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final AppiumDriver driver;
    private final WebDriverWait wait;

    private final By usernameLocator;
    private final By passwordLocator;
    private final By loginButtonLocator;
    private final By productsTitleLocator;

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        String platform = driver.getCapabilities().getCapability("platformName").toString().toLowerCase();

        if (platform.equals("android")) {
            usernameLocator = By.xpath("//*[@content-desc='test-Username']");
            passwordLocator = By.xpath("//*[@content-desc='test-Password']");
            loginButtonLocator = By.xpath("//*[@content-desc='test-LOGIN']");
            productsTitleLocator = By.xpath("//*[@text='PRODUCTS']");
        } else {
            usernameLocator = By.xpath("//XCUIElementTypeOther[@name='test-Username']");
            passwordLocator = By.xpath("//XCUIElementTypeOther[@name='test-Password']");
            loginButtonLocator = By.xpath("//XCUIElementTypeOther[@name='test-LOGIN']");
            productsTitleLocator = By.xpath("//XCUIElementTypeStaticText[@name='PRODUCTS']");
        }
    }

    public void enterUsername(String username) {

        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void tapLoginButton() {

        driver.findElement(loginButtonLocator).click();
    }

    public boolean isLoginSuccessful() {
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitleLocator));
        return title.isDisplayed();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        tapLoginButton();
    }
}