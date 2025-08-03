package org.example.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.example.models.ProductInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends PageBase {


    public ProductsPage(AppiumDriver driver) {
        super(driver);
    }

    public By getProductContainer(String productName) {
        if (isAndroid) {
            return By.xpath("//android.view.ViewGroup[@content-desc='test-Item' and .//android.widget.TextView[@text='" + productName + "']]");
        } else {
            return By.xpath("//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@label='" + productName + "']]");
        }
    }

    public By getProductPriceLocator(String productName) {
        if (isAndroid) {
            return By.xpath("//android.view.ViewGroup[@content-desc='test-Item' and .//android.widget.TextView[@text='" + productName + "']]//android.widget.TextView[@content-desc='test-Price']");
        } else {
            return By.xpath("//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@label='" + productName + "']]//XCUIElementTypeStaticText[@name='test-Price']");
        }
    }

    public By getProductImageLocator(String productName) {
        if (isAndroid) {
            return By.xpath("//android.view.ViewGroup[@content-desc='test-Item' and .//android.widget.TextView[@text='" + productName + "']]//android.widget.ImageView");
        } else {
            return By.xpath("//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@label='" + productName + "']]//XCUIElementTypeImage");
        }
    }

    public By getAddToCartButtonLocator(String productName) {
        if (isAndroid) {
            return By.xpath("//android.view.ViewGroup[@content-desc='test-Item' and .//android.widget.TextView[@text='" + productName + "']]//android.view.ViewGroup[@content-desc='test-ADD TO CART']");
        } else {
            return By.xpath("//XCUIElementTypeOther[@name='test-Item' and .//XCUIElementTypeStaticText[@label='" + productName + "']]//XCUIElementTypeOther[@name='test-ADD TO CART']");
        }
    }

    public void tapAddToCart(String productName) {
        scrollToProduct(productName);
        driver.findElement(getAddToCartButtonLocator(productName)).click();
    }

    public String getProductPrice(String productName) {
        scrollToProduct(productName);
        return driver.findElement(getProductPriceLocator(productName)).getText();
    }

    public boolean isProductImageVisible(String productName) {
        scrollToProduct(productName);
        return driver.findElement(getProductImageLocator(productName)).isDisplayed();
    }

    public void scrollToProduct(String productName) {
        if (isAndroid) {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollTextIntoView(\"" + productName + "\")"));
        } else {
            String scrollableText = "**/XCUIElementTypeStaticText[`label == '" + productName + "'`]";
            driver.findElement(AppiumBy.iOSClassChain(scrollableText));
        }
    }

    public List<ProductInfo> getAllProductDetails() {
        List<ProductInfo> productList = new ArrayList<>();

        List<WebElement> productNameElements;
        if (isAndroid) {
            productNameElements = driver.findElements(By.xpath("//android.widget.TextView[@content-desc='test-Item title']"));
        } else {
            productNameElements = driver.findElements(By.xpath("//XCUIElementTypeStaticText[@name='test-Item title']"));
        }

        for (WebElement nameElement : productNameElements) {
            String name = nameElement.getText();
            String price = "";
            boolean imageVisible = false;

            try {
                price = driver.findElement(getProductPriceLocator(name)).getText();
            } catch (Exception ignored) {
            }

            try {
                imageVisible = driver.findElement(getProductImageLocator(name)).isDisplayed();
            } catch (Exception ignored) {
            }

            productList.add(new ProductInfo(name, price, imageVisible));
        }

        return productList;
    }
}


