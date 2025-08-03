package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends PageBase {

    private By thankYouMessage;
    private By backHomeButton;

    public CheckoutCompletePage(AppiumDriver driver) {
        super(driver);
        if (isAndroid) {
            thankYouMessage = By.xpath("//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']");
            backHomeButton = By.xpath("//android.view.ViewGroup[@content-desc='test-BACK HOME']");
        } else {
            thankYouMessage = By.xpath("//XCUIElementTypeStaticText[@name='THANK YOU FOR YOU ORDER']");
            backHomeButton = By.xpath("//XCUIElementTypeOther[@name='test-BACK HOME']");
        }
    }

    public String getThankYouText() {
        return driver.findElement(thankYouMessage).getText();
    }

    public void backHome() {
        driver.findElement(backHomeButton).click();
    }
}

