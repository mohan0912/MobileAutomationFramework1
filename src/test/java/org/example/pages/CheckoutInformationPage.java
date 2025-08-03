package org.example.pages;

import io.appium.java_client.AppiumDriver;
import org.example.base.PageBase;
import org.openqa.selenium.By;

public class CheckoutInformationPage extends PageBase {

    private By firstNameInput;
    private By lastNameInput;
    private By postalCodeInput;
    private By continueButton;

    public CheckoutInformationPage(AppiumDriver driver) {
        super(driver);
        if (isAndroid) {
            firstNameInput = By.xpath("//android.widget.EditText[@content-desc='test-First Name']");
            lastNameInput = By.xpath("//android.widget.EditText[@content-desc='test-Last Name']");
            postalCodeInput = By.xpath("//android.widget.EditText[@content-desc='test-Zip/Postal Code']");
            continueButton = By.xpath("//android.view.ViewGroup[@content-desc='test-CONTINUE']");
        } else {
            firstNameInput = By.xpath("//XCUIElementTypeTextField[@name='test-First Name']");
            lastNameInput = By.xpath("//XCUIElementTypeTextField[@name='test-Last Name']");
            postalCodeInput = By.xpath("//XCUIElementTypeTextField[@name='test-Zip/Postal Code']");
            continueButton = By.xpath("//XCUIElementTypeOther[@name='test-CONTINUE']");
        }
    }

    public void fillForm(String first, String last, String zip) {
        driver.findElement(firstNameInput).sendKeys(first);
        driver.findElement(lastNameInput).sendKeys(last);
        driver.findElement(postalCodeInput).sendKeys(zip);
        driver.findElement(continueButton).click();
    }
}
