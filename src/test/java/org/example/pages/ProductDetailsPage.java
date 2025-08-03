package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.openqa.selenium.By;

public class ProductDetailsPage extends PageBase {

    private final By productTitle;
    private final By productPrice;
    private final By productDescription;
    private final By addToCartButton;
    private final By backButton;

    public ProductDetailsPage(AppiumDriver driver) {
        super(driver);
        if (isAndroid) {
            productTitle = By.xpath("//android.widget.TextView[@content-desc='test-Item title']");
            productPrice = By.xpath("//android.widget.TextView[@content-desc='test-Price']");
            productDescription = By.xpath("//android.widget.TextView[@content-desc='test-Description']");
            addToCartButton = By.xpath("//android.view.ViewGroup[@content-desc='test-ADD TO CART']");
            backButton = By.xpath("//android.view.ViewGroup[@content-desc='test-BACK TO PRODUCTS']");
        } else {
            productTitle = By.xpath("//XCUIElementTypeStaticText[@name='test-Item title']");
            productPrice = By.xpath("//XCUIElementTypeStaticText[@name='test-Price']");
            productDescription = By.xpath("//XCUIElementTypeStaticText[@name='test-Description']");
            addToCartButton = By.xpath("//XCUIElementTypeOther[@name='test-ADD TO CART']");
            backButton = By.xpath("//XCUIElementTypeOther[@name='test-BACK TO PRODUCTS']");
        }
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void goBack() {
        driver.findElement(backButton).click();
    }
}


