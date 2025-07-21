package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PaymentPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void iframeSwitch(){
        WebElement iframeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("bepaid-iframe")));
        driver.switchTo().frame(iframeElement);
    }

    public String getDisplayedSum() {
        String[] displayedSum = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span")).getText().split(" ");
        return displayedSum[0];
    }

    public String getButtonSum(){
        String[] buttonSum = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button")).getText().split(" ");
        return buttonSum[1];
    }

    public String getDisplayedPhone() {
        String[] displayedPhone = driver.findElement(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span")).getText().split("[^\\d\\.]+");
        return  displayedPhone[displayedPhone.length - 1];
    }

    public List<WebElement> getPaymentIcons() {
        return driver.findElements(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div"));
    }

    public void verifyIframePlaceholder(By locator, String expectedPlaceholder) {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String actualPlaceholder = inputField.getText();
        if (!actualPlaceholder.equals(expectedPlaceholder)) {
            throw new AssertionError("Ожидался плейсхолдер '" + expectedPlaceholder + "', но найден '" + actualPlaceholder + "'");
        }
    }

    public void verifyIframeFieldsPlaceholders() {
        verifyIframePlaceholder(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]"), "Номер карты");
        verifyIframePlaceholder(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]"), "Срок действия");
        verifyIframePlaceholder(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]"), "CVC");
        verifyIframePlaceholder(By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]"),"Имя и фамилия на карте");
    }
}