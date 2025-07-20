package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PayUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PayUpPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getFieldLabel(String fieldId) {
        String labelXpath = "//input[@id='" + fieldId + "']/preceding-sibling::label";
        WebElement label = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(labelXpath)));
        return label.getText();
    }

    public void fillPhoneNumber(String phoneNumber) {
        WebElement input = wait.until(ExpectedConditions.elementToBeClickable(By.id("phoneNumber")));
        input.clear();
        input.sendKeys(phoneNumber);
    }

    public void selectService(String serviceName) {
        String selectXpath = "//select[@id='serviceType']";
        Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectXpath))));
        select.selectByVisibleText(serviceName);
    }

    public void fillCardDetails(String number, String expiry, String cvv) {
        driver.findElement(By.id("cardNumber")).sendKeys(number);
        driver.findElement(By.id("cardExpiry")).sendKeys(expiry);
        driver.findElement(By.id("cardCvv")).sendKeys(cvv);
    }

    public boolean arePaymentIconsDisplayed() {
        return !driver.findElements(By.xpath("//div[contains(@class,'payment-icons')]//img")).isEmpty();
    }

    public String getContinueButtonText() {
        return driver.findElement(By.xpath("//button[contains(text(),'Продолжить')]")).getText();
    }

    public String getDisplayedSum() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='confirmation-sum']"))).getText();
    }

    public String getConfirmedPhoneNumber() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='confirmation-phone']"))).getText();
    }
}