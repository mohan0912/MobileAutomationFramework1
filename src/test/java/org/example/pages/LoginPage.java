package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class LoginPage extends PageBase {

    private final WebDriverWait wait;

    private By usernameLocator;
    private By passwordLocator;
    private By loginButtonLocator;
    private By productsTitleLocator;
    private By errorMessage;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (isAndroid) {
            usernameLocator = By.xpath("//*[@content-desc='test-Username']");
            passwordLocator = By.xpath("//*[@content-desc='test-Password']");
            loginButtonLocator = By.xpath("//*[@content-desc='test-LOGIN']");
            productsTitleLocator = By.xpath("//*[@text='PRODUCTS']");
            errorMessage = By.xpath("//android.view.ViewGroup[@content-desc='test-Error message']");
        } else {
            usernameLocator = By.xpath("//*[@name='test-Username']");
            passwordLocator = By.xpath("//*[@name='test-Password']");
            loginButtonLocator = By.xpath("//*[@name='test-LOGIN']");
            productsTitleLocator = By.xpath("//*[@name='PRODUCTS']");
            errorMessage = By.xpath("//XCUIElementTypeOther[@name='test-Error message']");
        }
    }

    public void enterUsername(String username) {

        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void tapLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginBtn.click();
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