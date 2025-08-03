package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends PageBase {

    private By finishButton;

    public CheckoutOverviewPage(AppiumDriver driver) {
        super(driver);
        if (isAndroid) {
            finishButton = By.xpath("//android.view.ViewGroup[@content-desc='test-FINISH']");
        } else {
            finishButton = By.xpath("//XCUIElementTypeOther[@name='test-FINISH']");
        }
    }

    public void finishCheckout() {
        driver.findElement(finishButton).click();
    }
}
