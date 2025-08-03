package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.openqa.selenium.By;

public class CartPage extends PageBase {

    private By cartItem;
    private By checkoutButton;
    private By removeButton;

    public CartPage(AppiumDriver driver) {
        super(driver);

        if (isAndroid) {
            cartItem = By.xpath("//android.widget.TextView[@content-desc='test-Item title']");
            checkoutButton = By.xpath("//android.view.ViewGroup[@content-desc='test-CHECKOUT']");
            removeButton = By.xpath("//android.view.ViewGroup[@content-desc='test-REMOVE']");
        } else {
            cartItem = By.xpath("//XCUIElementTypeStaticText[@name='test-Item title']");
            checkoutButton = By.xpath("//XCUIElementTypeOther[@name='test-CHECKOUT']");
            removeButton = By.xpath("//XCUIElementTypeOther[@name='test-REMOVE']");
        }
    }

    public boolean isProductInCart(String productName) {
        return driver.findElement(cartItem).getText().equalsIgnoreCase(productName);
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    public void removeItem() {
        driver.findElement(removeButton).click();
    }
}

