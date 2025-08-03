package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.openqa.selenium.By;

public class CheckoutPage extends PageBase {

    private By firstNameField;
    private By lastNameField;
    private By postalCodeField;
    private By continueButton;

    public CheckoutPage(AppiumDriver driver) {
        super(driver);

        if (isAndroid) {
            firstNameField = By.id("test-First Name");
            lastNameField = By.id("test-Last Name");
            postalCodeField = By.id("test-Zip/Postal Code");
            continueButton = By.id("test-CONTINUE");
        } else {
            firstNameField = By.xpath("//XCUIElementTypeOther[@name='test-First Name']");
            lastNameField = By.xpath("//XCUIElementTypeOther[@name='test-Last Name']");
            postalCodeField = By.xpath("//XCUIElementTypeOther[@name='test-Zip/Postal Code']");
            continueButton = By.xpath("//XCUIElementTypeOther[@name='test-CONTINUE']");
        }
    }

    public void enterCheckoutDetails(String firstName, String lastName, String zipCode) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(zipCode);
        driver.findElement(continueButton).click();
    }
}
